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

// 相册页面
public class PhotoActivity extends AppCompatActivity {
	private TextView title;
	private GridView photogrid;
	private int[] selfimg = { R.drawable.self1, R.drawable.self2, R.drawable.self3, R.drawable.addphoto };// 图片

	// 保存数据库的uri
	List<PhotoBean> photolist = new ArrayList<PhotoBean>();
	// 图片uri为bitmap
	private List<Bitmap> allphotobitmap = new ArrayList<Bitmap>();
	GridBasicAdpdter ap;

	PhotoDao photodao = new PhotoDao();
	SelfSqlite seqlite;
	SQLiteDatabase db;

	
	// 默认图片
	int [] defaultphoto = {R.drawable.self1,R.drawable.self2,R.drawable.self3};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 无标题
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
			// 样式特殊
			int style = MyApplication.getSettingbean().getTitlestyle();
			title.setTypeface(Typeface.MONOSPACE, GetColorAndStyleClass.getStyleFromIndex(style));
		}
	}

	// 默认的图片
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
		//获取资源图片
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
			return btp;  ///把流转化为Bitmap图片

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	// 从数据库读取图片并且保存为bitmap
	public void readPhotoUriFromDataToBitmap() {
		seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
		db = seqlite.getReadableDatabase();// 以读方式打开

		// 读取
		photolist = photodao.readDataWithPhoto(db, photolist);
		boolean isok;
		// 转换为bitmap
		int size = photolist.size();// 记录，因为list大小会变
		for (int i = 0; i < size; i++) {
			isok = true;
			Bitmap bit = null;
			try {
				// 正确姿势
				// bit = BitmapFactory.decodeFile(photolist.get(i).getPhotouri());
				// change
				bit = getLocalBitmap(photolist.get(i).getPhotouri());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isok = false;
			} 
			// 如果图片不存在要删除list，和数据库 并且不添加到bitmaplist中
			if (bit != null && isok) {
				allphotobitmap.add(bit);
			} else {
				// 数据库先删除
				photodao.deletePhotoByid(db, photolist.get(i).getPhotoid());
				// 列表删除
				photolist.remove(i);
			}
		}

		// 最后一个加上
		Bitmap b4 = readBitMaps(this, R.drawable.addphoto);
		//Bitmap b4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.addphoto);
		allphotobitmap.add(b4);
	}

	// 图片gridview
	public void setAdpter() {
		ap = new GridBasicAdpdter(this);
		ap.setData(allphotobitmap);
		photogrid.setAdapter(ap);
	}

	public void Back(View view) {
		finish();
	}

	// 照相
	public void camera() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 打开照相机要用action
																	// 用MediaStore就行
		startActivityForResult(intent, 1);
	}

	public void photos() {
		Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);// 第一个是图库，第二个是图片的uri
		startActivityForResult(intent, 2);
	}

	public void givLis() {
		photogrid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				// TODO Auto-generated method stub
				// 如果是最后一个加上去
				if (position == allphotobitmap.size() - 1) {// 是最后一个
					// 出现弹框
					PhotoDialog dialogs = new PhotoDialog(PhotoActivity.this, R.style.custom_dialog);
					dialogs.show();
				} else if(position != allphotobitmap.size() - 1){// 其它的删除事件 不能操作默认的图片
					PhotoDelDialog del = new PhotoDelDialog(PhotoActivity.this, R.style.custom_dialog, position);
					del.show();
				}

			}
		});
	}

	// 添加一个图片uri到数据库里 传入uri String
	public void addPhotoData(String uri) {
		if (!uri.equals("")) {
			// 返回主键
			int id = photodao.addPhoto(db, uri);
			if (id != 0) {
				PhotoBean pho = new PhotoBean();
				pho.setPhotoid(id);
				pho.setPhotouri(uri);
				photolist.add(pho);
			}
		}
	}

	// 放入新图片
	public void putNewPhoto(Bitmap bit) {
		// 把原来最后的删除
		Bitmap oldbi = allphotobitmap.get(allphotobitmap.size() - 1);
		allphotobitmap.remove(allphotobitmap.size() - 1);
		// 新增
		allphotobitmap.add(bit);
		// 加回
		allphotobitmap.add(oldbi);
		notifys();// 刷新
	}

	// 删除图片
	public void removePhoto(int position) {
		// 根据position 来删除
		// 先删除数据库数据
		photodao.deletePhotoByid(db, photolist.get(position - defaultphoto.length).getPhotoid());
		// 再删除list 要减去默认图片
		photolist.remove(position - defaultphoto.length);
		// 删除图片
		allphotobitmap.remove(position);
		// 更新
		notifys();
	}

	// notify
	public void notifys() {
		ap.setData(allphotobitmap);
		ap.notifyDataSetChanged();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// data应该是保存了图片的Bitmap
		// 图片用data获取
		if (requestCode == 1) {
			try {
				Bitmap bit = (Bitmap) data.getExtras().get("data");
				if (bit != null) {
					// 判断了 是map
					putNewPhoto(bit);
					// 通过bit拿到保存图片到应用吧
					String path = saveImage(bit);
					addPhotoData(path);
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else if (requestCode == 2) {// 图库选择一个照片的操作
			try {
				// 这个从图库里拿的话 拿到图片的uri
				Uri photouri = data.getData();
				// 通过uri获取图片位图 可以保存在应用
				Bitmap bitmaps = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photouri);//
				putNewPhoto(bitmaps);
				// 图片信息的路径字段名
				// 这个DATA应该是图片路径的字段
				String photopath[] = { MediaStore.Images.Media.DATA };
				// 根据字段名和图片的uri获取图片真正的路径
				Cursor cursor = this.getContentResolver().query(photouri, photopath, "", null, "");
				int index = cursor.getColumnIndexOrThrow(photopath[0]);
				cursor.moveToFirst();
				// 获取路径
				String path = cursor.getString(index);
				// tx=path;只是获取到了绝对路径
				// 获取
//				Toast.makeText(PhotoActivity.this, path, Toast.LENGTH_LONG).show();
				addPhotoData(path);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	public String saveImage(Bitmap bit) {
		// 如果创建成功才返回
		String png = "/"+System.currentTimeMillis()+".png";
		String path = Environment.getExternalStorageDirectory().getAbsolutePath() +  png;
		File files = new File(path);// 而这个文件不存在所以我们要创建它
		try {
			if (!files.exists()) {
				files.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(files);
			bit.compress(CompressFormat.PNG, 100, fo);// 100为这张图片传输的多少 清晰度吧。。。

			fo.flush();
			fo.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			path = "";
		}
		return path;
	}
}
