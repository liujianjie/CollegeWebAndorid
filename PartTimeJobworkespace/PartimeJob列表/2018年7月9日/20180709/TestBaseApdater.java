package com.example.administrator.project4;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestBaseApdater extends BaseAdapter {
    public List<ViewHolder> mHolderList = new ArrayList<ViewHolder>();

    int id_row_layout;
    LayoutInflater mInflater;
    LinkedList<Music> musiclist;
    Context project4ct;
    Bitmap bitm;
    public TestBaseApdater(Context context, int id_row_layout) {
        super();
        this.id_row_layout = id_row_layout;
        mInflater = LayoutInflater.from(context);
        project4ct = context;
    }

    public void setMusicData(LinkedList<Music> musiclist){
        this.musiclist = musiclist;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if(musiclist != null){
            return musiclist.size();
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
        ViewHolder holder = null;
        if (convertView == null) {
            synchronized (TestBaseApdater.this) {
                convertView = mInflater.inflate(id_row_layout, null);
                holder = new ViewHolder();

                holder.txt1 = (TextView) convertView
                        .findViewById(R.id.textView1);
                holder.txt2 = (TextView) convertView
                        .findViewById(R.id.textView2);
                holder.txt3 = (TextView) convertView
                        .findViewById(R.id.textView3);
                holder.igview1 = (ImageView) convertView
                        .findViewById(R.id.igview1);

                convertView.setTag(holder);
                mHolderList.add(holder);
            }
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if(position == 0){
            holder.txt1.setText("trackName");
            holder.txt2.setText("collectionName");
            holder.txt3.setText("artworkUrl30");
            holder.txt3.setVisibility(View.VISIBLE);
            holder.igview1.setVisibility(View.GONE);
        }else{
            holder.txt3.setVisibility(View.GONE);
            holder.igview1.setVisibility(View.VISIBLE);
            if(musiclist != null){
                Music musicbean = musiclist.get(position);
                holder.txt1.setText(musicbean.getTrackName());
                holder.txt2.setText(musicbean.getCollectionName());
                bitm = Project4.returnBitMap(musicbean.getArtworkUrl30());
                holder.igview1.setImageBitmap(bitm);
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
