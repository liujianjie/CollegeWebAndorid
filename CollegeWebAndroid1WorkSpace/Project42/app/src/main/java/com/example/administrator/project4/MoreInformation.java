package com.example.administrator.project4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MoreInformation extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6;
    ImageView ig1,ig2;
    Bitmap bit1,bit2;
    String imageurl1,imageurl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreinformation);
        findView();
    }
    public void findView(){
        t1 = (TextView) this.findViewById(R.id.moreinfo_textView1);
        t2 = (TextView) this.findViewById(R.id.moreinfo_textView2);
        t3 = (TextView) this.findViewById(R.id.moreinfo_textView3);
        t4 = (TextView) this.findViewById(R.id.moreinfo_textView4);
        t5 = (TextView) this.findViewById(R.id.moreinfo_textView5);
        t6 = (TextView) this.findViewById(R.id.moreinfotip_textView1);
        ig1 = (ImageView)this.findViewById(R.id.moreinfo_imgview1);
        ig2 = (ImageView)this.findViewById(R.id.moreinfo_imgview2);
        getDataFromActivity();
    }

    public void getDataFromActivity(){
        Intent intent = this.getIntent();
        Music mu = (Music) intent.getSerializableExtra("mu");
        Movie mv = (Movie) intent.getSerializableExtra("mv");
        SoftWare sw = (SoftWare) intent.getSerializableExtra("sw");
        if(mu != null){
            t1.setText("trackName:"+mu.getTrackName());
            t2.setText("artistName:"+mu.getArtistName());
            t3.setText("collectionName:"+mu.getCollectionName());
            t4.setText("trackPrice:"+mu.getTrackPrice());
            t5.setText("collectionPrice:"+mu.getCollectionPrice());
            ig1.setVisibility(View.GONE);
            ig2.setVisibility(View.GONE);
        }else if(mv != null){
            t1.setText("trackName:"+mv.getTrackName());
            t2.setText("longDescription:"+mv.getLongDescription());
            t3.setText("primaryGenreName:"+mv.getPrimaryGenreName());
            t4.setText("trackHdprice:"+mv.getTrackHdPrice());
            ig1.setVisibility(View.GONE);
            ig2.setVisibility(View.GONE);
        }else if(sw != null){
            ig1.setVisibility(View.VISIBLE);
            ig2.setVisibility(View.VISIBLE);
            t1.setText("artistName:"+sw.getArtistName());
            String str = "";
            for(int i = 0; i < sw.getSupportedDevices().length; i++){
                str += (sw.getSupportedDevices()[i]);
                if(i != (sw.getSupportedDevices().length-1) ){
                    str += ",";
                }
            }
            t2.setText("supportedDevices:"+str);
            t3.setText("description:"+sw.getDescription());
            str = "";
            for(int i = 0; i < sw.getGenres().length; i++){
                str += (sw.getGenres()[i]);
                if(i != (sw.getGenres().length-1) ){
                    str += ",";
                }
            }
            t4.setText("genres:"+str);

            if(sw.getScreenshotUrls().length > 0){
                imageurl1 = sw.getScreenshotUrls()[0];
                new Thread() {
                    public void run() {
                        //耗时操作不能放在主线程
                        bit1 = Project4.returnBitMap(imageurl1);
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                //更新UI
                                ig1.setImageBitmap(bit1);
                            }

                        });
                    }
                }.start();
            }
            if(sw.getScreenshotUrls().length > 1){
                imageurl2 = sw.getScreenshotUrls()[1];
                new Thread() {
                    public void run() {
                        bit2 = Project4.returnBitMap(imageurl2);
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                //更新UI
                                ig2.setImageBitmap(bit2);
                            }

                        });
                    }
                }.start();
            }
            //这里也可以直接用picasso 更好，第三方包，自己决定
            /*
            *  Picasso.with(this).load(sw.getScreenshotUrls()[0]).into(ig1);
            *  Picasso.with(this).load(sw.getScreenshotUrls()[1]).into(ig2);
            * */
        }
    }
}
