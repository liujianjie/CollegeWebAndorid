package com.android.musicman;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class MusicUtils {

    private static List<MusicInfo> musicList = new ArrayList<MusicInfo>();

    public static List<MusicInfo> getMusicInfoList(Context context) {

        musicList.clear();

        Cursor mAudioCursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                MediaStore.Audio.AudioColumns.TITLE);

        for (int i = 0; i < mAudioCursor.getCount(); i++) {
            mAudioCursor.moveToNext();

            int duration = mAudioCursor.getInt(mAudioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
            //筛选时长大于2分钟的歌曲
         
                //歌曲ID
                int musicId = mAudioCursor.getInt(mAudioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                //歌曲路径(URI)
                String musicPath = mAudioCursor.getString(mAudioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                //歌曲名
                String musicTitle = mAudioCursor.getString(mAudioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                //歌手
                String musicSinger = mAudioCursor.getString(mAudioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                //向容器添加以供ListView使用
                musicList.add(new MusicInfo(musicId, musicPath, musicTitle, musicSinger, duration));

            
        }

        return musicList;
    }
}
