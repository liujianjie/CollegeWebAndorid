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
            //ɸѡʱ������2���ӵĸ���
         
                //����ID
                int musicId = mAudioCursor.getInt(mAudioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                //����·��(URI)
                String musicPath = mAudioCursor.getString(mAudioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                //������
                String musicTitle = mAudioCursor.getString(mAudioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                //����
                String musicSinger = mAudioCursor.getString(mAudioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                //����������Թ�ListViewʹ��
                musicList.add(new MusicInfo(musicId, musicPath, musicTitle, musicSinger, duration));

            
        }

        return musicList;
    }
}
