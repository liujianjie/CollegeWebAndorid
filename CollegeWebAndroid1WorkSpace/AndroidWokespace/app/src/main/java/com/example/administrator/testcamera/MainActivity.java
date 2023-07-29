package com.example.administrator.testcamera;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    String bathpath = Environment.getExternalStorageDirectory().getAbsolutePath();

    private static final String IMAGE_FILE_LOCATION = "file://sdcard/";//temp file
//    Uri imageUri = Uri.parse(IMAGE_FILE_LOCATION);//The Uri to store the big bitmap

    Uri imageUri ;
    private Uri mOutPutFileUri;


    private ImageView main_ig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_ig = (ImageView) this.findViewById(R.id.main_ig);
        // load(url):表示加载图片的Url地址 Url地址是网页还是文件？
        // placeholder():表示设置默认图片
        // into(ImageView):表示图片加载到那个ImageView里面。
        //Picasso.with(this).load("http://192.168.23.1:8080/Android_Service/image/a.png").placeholder(R.drawable.ic_launcher).into(main_ig);
    }

    public void takecarme(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//打开照相机要用action 用MediaStore就行

        startActivityForResult(intent, 1);
    }

    //照相返回图片，图库选择图片返回uri 都有返回
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //data应该是保存了图片的Bitmap
        //图片用data获取
        if(requestCode==1){
            Bitmap bit = (Bitmap) data.getExtras().get("data");
            Toast.makeText(this, bit+"", Toast.LENGTH_LONG).show();
            //通过bit拿到保存图片到应用吧
           // File file = saveImage(bit);
            //返回的File上传到tomcat
            //UpdFile(file);
//            main_ig.setImageBitmap(bit);
            saveImage(bit);
            cropImageUri(mOutPutFileUri, 1500, 1900, 2);

        }else if(requestCode == 2){

            if(data != null) {
                FileInputStream fis;
                try {
                    fis = new FileInputStream(imageUri.toString());
                    Bitmap bitmap = BitmapFactory.decodeStream(fis); // /把流转化为Bitmap图片
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//                    byte[] bitmapByte = baos.toByteArray();
//                    lastIntent.putExtra("bitmap", bitmapByte);
//                    Constant.imagePath = new File(Constant.imageDir + address + ".JPEG");
//                    setResult(Activity.RESULT_OK, lastIntent);
                    main_ig.setImageBitmap(bitmap);
                    finish();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

//                Bitmap bitmap = decodeUriAsBitmap(mOutPutFileUri);
//                Toast.makeText(this, " "+mOutPutFileUri, Toast.LENGTH_LONG).show();
//                Toast.makeText(this, "requestCode == 2", Toast.LENGTH_LONG).show();
//                main_ig.setImageBitmap(bitmap);
            }
        }
    }

    private void cropImageUri(Uri uri, int outputX, int outputY, int requestCode){

//        imageUri = Uri.parse(IMAGE_FILE_LOCATION + System.currentTimeMillis()+ ".JPEG");
//        Intent intent = new Intent("com.android.camera.action.CROP");
//// 照片URL地址
//        intent.setDataAndType(uri, "image/*");
//        intent.putExtra("crop", "true");
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
//        intent.putExtra("outputX", 500);
//        intent.putExtra("outputY", 500);
//        intent.putExtra("scale", true);
//// 输出路径
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//// 输出格式
//        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
//// 不启用人脸识别
//        intent.putExtra("noFaceDetection", true);
//        intent.putExtra("return-data", false);
//        startActivityForResult(intent, REQUEST_PHOTOCROP);
        imageUri = Uri.parse(IMAGE_FILE_LOCATION + System.currentTimeMillis()+ ".JPEG");
        Intent intent = new Intent("com.android.camera.action.CROP");

        intent.setDataAndType(uri, "image/*");

        intent.putExtra("crop", "true");

        intent.putExtra("aspectX", 2);

        intent.putExtra("aspectY", 1);

        intent.putExtra("outputX", outputX);

        intent.putExtra("outputY", outputY);

        intent.putExtra("scale", true);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

        intent.putExtra("return-data", false);

        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());

        intent.putExtra("noFaceDetection", true); // no face detection

        startActivityForResult(intent, 2);

//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
//
//        intent.setType("image/*");

//        imageUri = Uri.parse(IMAGE_FILE_LOCATION + System.currentTimeMillis()+ ".JPEG");
//
//          intent.setDataAndType(uri, "image/*");
//        intent.putExtra("crop", "true");
//
//        intent.putExtra("aspectX", 2);
//
//        intent.putExtra("aspectY", 1);
//
//        intent.putExtra("outputX", 600);
//
//        intent.putExtra("outputY", 300);
//
//        intent.putExtra("scale", true);
//
//        intent.putExtra("return-data", false);
//
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//
//        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
//
//        intent.putExtra("noFaceDetection", true); // no face detection
//
//        startActivityForResult(intent, 2);

    }

    private Bitmap decodeUriAsBitmap(Uri uri){

        Bitmap bitmap = null;

        try {

            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));

        } catch (FileNotFoundException e) {

            e.printStackTrace();

            return null;

        }

        return bitmap;

    }

    //保存图片到项目不是在本地。。
    public File saveImage(Bitmap bit){
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+System.currentTimeMillis()+".png";

        File file = new File(path);//而这个文件不存在所以我们要创建它
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fo = new FileOutputStream(file);
            bit.compress(Bitmap.CompressFormat.PNG, 100, fo);//100为这张图片传输的多少 清晰度吧。。。
            mOutPutFileUri = Uri.fromFile(file);
            fo.flush();
            fo.close();
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return file;
    }
}
