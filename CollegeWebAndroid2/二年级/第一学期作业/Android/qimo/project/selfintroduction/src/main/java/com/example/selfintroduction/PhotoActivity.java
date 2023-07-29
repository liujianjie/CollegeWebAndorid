package com.example.selfintroduction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.adpter.GridBasicAdpdter;
import com.example.application.GetColorAndStyleClass;
import com.example.application.MyApplication;
import com.example.bean.PhotoBean;
import com.example.dao.PhotoDao;
import com.example.dao.SettingDao;
import com.example.dialog.PhotoDelDialog;
import com.example.dialog.PhotoDialog;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.io.InputStream;
import java.io.FileInputStream;

// ���ҳ��
public class PhotoActivity extends AppCompatActivity {
	private TextView title;
	private GridView photogrid;
	private int[] selfimg = { R.drawable.self1, R.drawable.self2, R.drawable.self3, R.drawable.addphoto };// ͼƬ

	// �������ݿ��uri
	List<PhotoBean> photolist = new ArrayList<PhotoBean>();
	// ͼƬuriΪbitmap
	private List<Bitmap> allphotobitmap = new ArrayList<Bitmap>();
	GridBasicAdpdter ap;

	PhotoDao photodao = new PhotoDao();
	SelfSqlite seqlite;
	SQLiteDatabase db;

	
	// Ĭ��ͼƬ
	int [] defaultphoto = {R.drawable.self1,R.drawable.self2,R.drawable.self3};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// �ޱ���
		setContentView(R.layout.activity_photo);
		getSupportActionBar().hide();
		findViews();
		initData();
		readPhotoUriFromDataToBitmap();
		setAdpter();
		givLis();
	}

	private void findViews() {
		photogrid = (GridView) findViewById(R.id.photo_gridview);
		title = (TextView) findViewById(R.id.photo_title);
		if (MyApplication.getSettingbean() != null) {
			photogrid.setNumColumns(MyApplication.getSettingbean().getPhotonum());
			title.setTextSize(MyApplication.getSettingbean().getTitlesize());
			title.setTextColor(GetColorAndStyleClass.getColorFromIndex(MyApplication.getSettingbean().getTitlecolor()));
			// ��ʽ����
			int style = MyApplication.getSettingbean().getTitlestyle();
			title.setTypeface(Typeface.MONOSPACE, GetColorAndStyleClass.getStyleFromIndex(style));
		}
	}

	// Ĭ�ϵ�ͼƬ
	private void initData() {
		for(int i = 0; i < defaultphoto.length; i++){
			Bitmap b1 = readBitMaps(this, defaultphoto[i]);

			//Bitmap b1 = BitmapFactory.decodeResource(this.getResources(), defaultphoto[i]);
			allphotobitmap.add(b1);
		}
	}
	// photo quality

	public Bitmap readBitMaps(Context context, int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		//��ȡ��ԴͼƬ
		InputStream is = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is, null, opt);
	}
	public static Bitmap getLocalBitmap(String url) {
		try {
			FileInputStream fis = new FileInputStream(url);
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = false;
			options.inSampleSize = 2;
			Bitmap btp = BitmapFactory.decodeStream(fis, null, options);
			return btp;  ///����ת��ΪBitmapͼƬ

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	// �����ݿ��ȡͼƬ���ұ���Ϊbitmap
	public void readPhotoUriFromDataToBitmap() {
		seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		db = seqlite.getReadableDatabase();// �Զ���ʽ��

		// ��ȡ
		photolist = photodao.readDataWithPhoto(db, photolist);
		boolean isok;
		// ת��Ϊbitmap
		int size = photolist.size();// ��¼����Ϊlist��С���
		for (int i = 0; i < size; i++) {
			isok = true;
			Bitmap bit = null;
			try {
				// ��ȷ����
				// bit = BitmapFactory.decodeFile(photolist.get(i).getPhotouri());
				// change
				bit = getLocalBitmap(photolist.get(i).getPhotouri());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isok = false;
			} 
			// ���ͼƬ������Ҫɾ��list�������ݿ� ���Ҳ���ӵ�bitmaplist��
			if (bit != null && isok) {
				allphotobitmap.add(bit);
			} else {
				// ���ݿ���ɾ��
				photodao.deletePhotoByid(db, photolist.get(i).getPhotoid());
				// �б�ɾ��
				photolist.remove(i);
			}
		}

		// ���һ������
		Bitmap b4 = readBitMaps(this, R.drawable.addphoto);
		//Bitmap b4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.addphoto);
		allphotobitmap.add(b4);
	}

	// ͼƬgridview
	public void setAdpter() {
		ap = new GridBasicAdpdter(this);
		ap.setData(allphotobitmap);
		photogrid.setAdapter(ap);
	}

	public void Back(View view) {
		finish();
	}

	// ����
	public void camera() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// �������Ҫ��action
																	// ��MediaStore����
		startActivityForResult(intent, 1);
	}

	public void photos() {
		Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);// ��һ����ͼ�⣬�ڶ�����ͼƬ��uri
		startActivityForResult(intent, 2);
	}

	public void givLis() {
		photogrid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				// TODO Auto-generated method stub
				// ��������һ������ȥ
				if (position == allphotobitmap.size() - 1) {// �����һ��
					// ���ֵ���
					PhotoDialog dialogs = new PhotoDialog(PhotoActivity.this, R.style.custom_dialog);
					dialogs.show();
				} else if(position != allphotobitmap.size() - 1){// ������ɾ���¼� ���ܲ���Ĭ�ϵ�ͼƬ
					PhotoDelDialog del = new PhotoDelDialog(PhotoActivity.this, R.style.custom_dialog, position);
					del.show();
				}

			}
		});
	}

	// ���һ��ͼƬuri�����ݿ��� ����uri String
	public void addPhotoData(String uri) {
		if (!uri.equals("")) {
			// ��������
			int id = photodao.addPhoto(db, uri);
			if (id != 0) {
				PhotoBean pho = new PhotoBean();
				pho.setPhotoid(id);
				pho.setPhotouri(uri);
				photolist.add(pho);
			}
		}
	}

	// ������ͼƬ
	public void putNewPhoto(Bitmap bit) {
		// ��ԭ������ɾ��
		Bitmap oldbi = allphotobitmap.get(allphotobitmap.size() - 1);
		allphotobitmap.remove(allphotobitmap.size() - 1);
		// ����
		allphotobitmap.add(bit);
		// �ӻ�
		allphotobitmap.add(oldbi);
		notifys();// ˢ��
	}

	// ɾ��ͼƬ
	public void removePhoto(int position) {
		// ����position ��ɾ��
		// ��ɾ�����ݿ�����
		photodao.deletePhotoByid(db, photolist.get(position - defaultphoto.length).getPhotoid());
		// ��ɾ��list Ҫ��ȥĬ��ͼƬ
		photolist.remove(position - defaultphoto.length);
		// ɾ��ͼƬ
		allphotobitmap.remove(position);
		// ����
		notifys();
	}

	// notify
	public void notifys() {
		ap.setData(allphotobitmap);
		ap.notifyDataSetChanged();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// dataӦ���Ǳ�����ͼƬ��Bitmap
		// ͼƬ��data��ȡ
		if (requestCode == 1) {
			try {
				Bitmap bit = (Bitmap) data.getExtras().get("data");
				if (bit != null) {
					// �ж��� ��map
					putNewPhoto(bit);
					// ͨ��bit�õ�����ͼƬ��Ӧ�ð�
					String path = saveImage(bit);
					addPhotoData(path);
				}
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		} else if (requestCode == 2) {// ͼ��ѡ��һ����Ƭ�Ĳ���
			try {
				// �����ͼ�����õĻ� �õ�ͼƬ��uri
				Uri photouri = data.getData();
				// ͨ��uri��ȡͼƬλͼ ���Ա�����Ӧ��
				Bitmap bitmaps = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photouri);//
				putNewPhoto(bitmaps);
				// ͼƬ��Ϣ��·���ֶ���
				// ���DATAӦ����ͼƬ·�����ֶ�
				String photopath[] = { MediaStore.Images.Media.DATA };
				// �����ֶ�����ͼƬ��uri��ȡͼƬ������·��
				Cursor cursor = this.getContentResolver().query(photouri, photopath, "", null, "");
				int index = cursor.getColumnIndexOrThrow(photopath[0]);
				cursor.moveToFirst();
				// ��ȡ·��
				String path = cursor.getString(index);
				// tx=path;ֻ�ǻ�ȡ���˾���·��
				// ��ȡ
//				Toast.makeText(PhotoActivity.this, path, Toast.LENGTH_LONG).show();
				addPhotoData(path);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

	public String saveImage(Bitmap bit) {
		// ��������ɹ��ŷ���
		String png = "/"+System.currentTimeMillis()+".png";
		String path = Environment.getExternalStorageDirectory().getAbsolutePath() +  png;
		File files = new File(path);// ������ļ���������������Ҫ������
		try {
			if (!files.exists()) {
				files.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(files);
			bit.compress(CompressFormat.PNG, 100, fo);// 100Ϊ����ͼƬ����Ķ��� �����Ȱɡ�����

			fo.flush();
			fo.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			path = "";
		}
		return path;
	}
}
