package com.example.selfintroduction;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.Sqlite.SelfSqlite;
import com.example.Sqlite.Version;
import com.example.bean.PhotoBean;
import com.example.dao.PhotoDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PhotoDetailActivity extends AppCompatActivity {
    private int[] selfimg = { R.drawable.self1, R.drawable.self2, R.drawable.self3, R.drawable.addphoto };// 图片

    ImageView photodetail_imgv;

    Bitmap bp = null;
    float scaleWidth;
    float scaleHeight;

    int h;
    boolean num = false;

    int position;
    PhotoDao photodao = new PhotoDao();
    List<PhotoBean> photolist = new ArrayList<PhotoBean>();
    SelfSqlite seqlite;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photodetail);
        getSupportActionBar().hide();
        findView();
        getImgPos();
        photoWay();
    }
    private void findView(){
        photodetail_imgv = (ImageView) findViewById(R.id.photodetail_imgv);
    }
    private void getImgPos(){
        Intent in = getIntent();
        position = in.getIntExtra("img",0);

    }
    private void photoWay(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        //bp = BitmapFactory.decodeResource(getResources(),R.drawable.self1);
        // 根据图片的pos 是读取本地的还是drawble的
        if(position < 3){
            bp = readBitMaps(this, selfimg[position]);
        }else{
            // 本地的 读取，通过list
            bp = readPhotoUriFromDataToBitmap();
        }
        int width = bp.getWidth();
        int height = bp.getHeight();
        int w = dm.widthPixels;// 宽
        int h = dm.heightPixels;// 高
        scaleWidth =( (float)w )/ width;
        scaleHeight = ((float)h)/height;
        photodetail_imgv.setImageBitmap(bp);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:  //当屏幕检测到第一个触点按下之后就会触发到这个事件。
                if(num==true)        {
                    Matrix matrix= new Matrix();
                    matrix.postScale(scaleWidth,scaleHeight);

                    Bitmap newBitmap=Bitmap.createBitmap(bp, 0, 0, bp.getWidth(), bp.getHeight(),
                            matrix, true);
                    photodetail_imgv.setImageBitmap(newBitmap);
                    num=false;
                }
                else{
                    Matrix matrix = new Matrix();
                    matrix.postScale(1.0f,1.0f);
                    Bitmap newBitmap=Bitmap.createBitmap(bp, 0, 0, bp.getWidth(), bp.getHeight(),
                            matrix, true);
                    photodetail_imgv.setImageBitmap(newBitmap);
                    num=true;
                }
                break;
        }

        return super.onTouchEvent(event);
    }
    // 从数据库读取图片并且保存为bitmap
    public Bitmap readPhotoUriFromDataToBitmap() {
        seqlite = new SelfSqlite(this, "personal.db", null, Version.dataversion);
        db = seqlite.getReadableDatabase();// 以读方式打开

        // 读取
        photolist = photodao.readDataWithPhoto(db, photolist);
        boolean isok;
        isok = true;
        Bitmap bit = null;
        try {
            bit = getLocalBitmap(photolist.get(position - 3).getPhotouri());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            isok = false;
        }
        // 如果图片不存在要删除list，和数据库 并且不添加到bitmaplist中
        if (bit != null && isok) {

        } else {
            // 数据库先删除
            photodao.deletePhotoByid(db, photolist.get(position - 3).getPhotoid());
            // 列表删除
            photolist.remove(position - 3);
        }
        return bit;
    }
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
}
