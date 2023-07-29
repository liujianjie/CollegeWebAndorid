package com.example.administrator.project4;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProjectBaseApdater extends BaseAdapter {
    public List<ViewHolder> mHolderList = new ArrayList<ViewHolder>();

    LayoutInflater mInflater;
    static LinkedList datalist;
    Context project4ct;
    Bitmap bitm;
    Project4 pro;
    String imgstr;
    ViewHolder holder;
    Movie moviebean;
    Music musicbean;

    public enum Flag{
        music,movie,software
    }
    public Flag flg = Flag.music;// default music list

    public ProjectBaseApdater(Context context) {
        super();
        mInflater = LayoutInflater.from(context);
        project4ct = context;
        pro = (Project4)project4ct;
    }

    public void setLinkListData(LinkedList list){
        this.datalist = list;
        if(datalist != null || datalist.size() != 0){
            Object ob = datalist.get(0);
            if(ob instanceof Movie){
                flg = Flag.movie;
            }else if(ob instanceof Music){
                flg = Flag.music;
            }else{
                flg = Flag.software;
            }
        }
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if(datalist != null || datalist.size() != 0){
            return datalist.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parentView) {
        holder = null;
        if (convertView == null) {
            synchronized (ProjectBaseApdater.this) {
                holder = new ViewHolder();
                if(flg == Flag.music){
                    convertView = mInflater.inflate(R.layout.music_item, null);
                    holder.txt1 = (TextView) convertView
                            .findViewById(R.id.textView1);
                    holder.txt2 = (TextView) convertView
                            .findViewById(R.id.textView2);
                    holder.txt3 = (TextView) convertView
                            .findViewById(R.id.textView3);
                    holder.igview1 = (ImageView) convertView
                            .findViewById(R.id.igview1);

                }else if(flg == Flag.movie){
                    convertView = mInflater.inflate(R.layout.movie_item, null);
                    holder.txt1 = (TextView) convertView
                            .findViewById(R.id.mvitm_textView1);
                    holder.txt2 = (TextView) convertView
                            .findViewById(R.id.mvitm_textView2);
                    holder.txt3 = (TextView) convertView
                            .findViewById(R.id.mvitm_textView3);
                    holder.igview1 = (ImageView) convertView
                            .findViewById(R.id.mvitm_igview1);
                }else if(flg == Flag.software){
                    convertView = mInflater.inflate(R.layout.software_item, null);
                    holder.txt1 = (TextView) convertView
                            .findViewById(R.id.softw_textView1);
                    holder.txt2 = (TextView) convertView
                            .findViewById(R.id.softw_textView2);
                }

                convertView.setTag(holder);
                mHolderList.add(holder);
            }
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if(position == 0){
            if(flg == Flag.movie || flg == Flag.music){
                holder.txt1.setText("trackName");
                if(flg == Flag.music){
                    holder.txt2.setText("collectionName");
                }else{
                    holder.txt2.setText("contentAdvisoryRating");
                }
                holder.txt3.setText("artworkUrl30");
                holder.txt3.setVisibility(View.VISIBLE);
                holder.igview1.setVisibility(View.GONE);
            }else if(flg == Flag.software){
                holder.txt1.setText("artistName");
                holder.txt2.setText("price");
            }
        }else{
            if(datalist != null){
                if(flg == Flag.movie || flg == Flag.music){
                    holder.txt3.setVisibility(View.GONE);
                    holder.igview1.setVisibility(View.VISIBLE);
                    if(flg == Flag.music){
                        musicbean = (Music)datalist.get(position);
                        holder.txt2.setText(musicbean.getCollectionName());
                        holder.txt1.setText(musicbean.getTrackName());
                        Picasso.with(pro).load(musicbean.getArtworkUrl30()).into(holder.igview1);
                        //原来的 不好用，bug多
//                        new Thread() {
//                            public void run() {
//                                bitm = Project4.returnBitMap(musicbean.getArtworkUrl30());
//                                pro.runOnUiThread(new Runnable(){
//                                    @Override
//                                    public void run() {
//                                        synchronized(this) {
//                                            holder.igview1.setImageBitmap(bitm);
//                                        }
//                                    }
//
//                                });
//                            }
//                        }.start();
                    }else{
                        moviebean = (Movie)datalist.get(position);
                        holder.txt2.setText(moviebean.getContentAdvisoryRating());
                        holder.txt1.setText(moviebean.getTrackName());
                        Picasso.with(pro).load(moviebean.getArtworkUrl30()).into(holder.igview1);
                        //原来的 不好用，bug多
//                        new Thread() {
//                            public void run() {
//                                bitm = Project4.returnBitMap(moviebean.getArtworkUrl30());
//                                pro.runOnUiThread(new Runnable(){
//                                    @Override
//                                    public void run() {
//                                        synchronized(this) {
//                                            holder.igview1.setImageBitmap(bitm);
//                                        }
//                                    }
//                                });
//                            }
//                        }.start();
                    }
                }else if(flg == Flag.software){
                    SoftWare bean = (SoftWare)datalist.get(position);
                    holder.txt2.setText(bean.getPrice()+"");
                    holder.txt1.setText(bean.getArtistName());

                }
            }
        }
        return convertView;
    }
    class ViewHolder {
        TextView txt1;
        TextView txt2;
        TextView txt3;
        ImageView igview1;
    }
}
