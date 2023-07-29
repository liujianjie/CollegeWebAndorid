package com.android.musicman;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainActivity extends Activity {
    //存放SD卡读上来的音乐信息
    private static List<MusicInfo> musicList = null;
    //当前播放位置
    public static int curPosition = 0;
    //保证只载入一次sd卡
    private static int loadFlag = 1;
    //上一曲  播放 下一曲按钮
    private ImageButton imgPlayButton = null;
    private ImageButton imgNextButton = null;
    private ImageButton imgPreButton = null;
    //进度条
    private static SeekBar mSeekBar = null;
    //歌曲实时时间和总时间
    private static TextView nowTimeText = null;
    private static TextView totalTimeText = null;
    //歌曲名和歌手
    private static TextView musicTitle = null;
    private static TextView musicSinger = null;
    public static MediaPlayer mediaPlayer = null;
    //更新主界面图片
    private static SimpleDateFormat nowTimeFormat = null;
    //进度条实时更新handle
    private static Handler mScheduleHandler = new Handler();

    private ListView listView = null;
    private ListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setText(getIntent().getStringExtra("nickname"));

        mediaPlayer = new MediaPlayer();
        nowTimeFormat = new SimpleDateFormat("mm:ss");

        getMusicListFromSD();
        initPlayMusic();
        initNextMusic();
        initPreMusic();
        initSeekBar();

        adapter = new ListAdapter(this, musicList);
        listView = (ListBounceView) findViewById(R.id.MusicListView);
        listView.setAdapter(adapter);

        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "开始播放" + musicList.get(position).getMusicTitle(), Toast.LENGTH_SHORT).show();
                MainActivity.playMusic(musicList.get(position).getMusicPath());
            }
        });
    }


    public void initPlayMusic() {
//    	nowTimeText.setText("00:00");
        musicTitle = (TextView) findViewById(R.id.musicName);
        musicSinger = (TextView) findViewById(R.id.singer);
        imgPlayButton = (ImageButton) findViewById(R.id.play);
        imgPlayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imgPlayButton.setImageDrawable(getResources().getDrawable(R.drawable.stop));
                } else {
                    imgPlayButton.setImageDrawable(getResources().getDrawable(R.drawable.play));
                    if (curPosition == 0) {
                        playMusic(musicList.get(curPosition++).getMusicPath());
                    } else {
                        mediaPlayer.start();
                    }
                }
            }
        });
    }


    public void initNextMusic() {
        imgNextButton = (ImageButton) findViewById(R.id.right_song);
        imgNextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ++curPosition;

                if (curPosition == musicList.size())
                    curPosition = 0;

                playMusic(musicList.get(curPosition).getMusicPath());
            }
        });
    }


    public void initPreMusic() {
        imgPreButton = (ImageButton) findViewById(R.id.left_song);
        imgPreButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                --curPosition;

                if (curPosition == -1)
                    curPosition = musicList.size() - 1;

                playMusic(musicList.get(curPosition).getMusicPath());
            }
        });
    }


    public static void playMusic(String path) {

        //初始播放时间清零
        nowTimeText.setText("00:00");

        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();

            //更新进度条
            doSeekBarUpdate();

            //更新播放总时间
            int musicDurationTime = mediaPlayer.getDuration();
            SimpleDateFormat totalTimeFormat = new SimpleDateFormat("mm:ss");
            String ms2 = totalTimeFormat.format(musicDurationTime);
            totalTimeText.setText(ms2);

            //更新歌曲名和歌者
            musicTitle.setText(musicList.get(curPosition).getMusicTitle());
//		    musicTitle.setSingleLine(true);
//		    musicTitle.setFocusable(true);
//		    musicTitle.setEllipsize(TruncateAt.MARQUEE);
//		    musicTitle.setMarqueeRepeatLimit(-1);
            musicSinger.setText(musicList.get(curPosition).getMusicSinger());

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    if (++curPosition >= musicList.size())
                        curPosition = 0;

                    playMusic(musicList.get(curPosition).getMusicPath());

                    //更新歌曲名和歌者
                    musicTitle.setText(musicList.get(curPosition).getMusicTitle());
                    musicSinger.setTag(musicList.get(curPosition).getMusicSinger());

                    //更新播放总时间
                    int musicDurationTime = mediaPlayer.getDuration();
                    SimpleDateFormat totalTimeFormat = new SimpleDateFormat("mm:ss");
                    String ms2 = totalTimeFormat.format(musicDurationTime);
                    totalTimeText.setText(ms2);
                }
            });
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }


    public void initSeekBar() {
        mSeekBar = (SeekBar) findViewById(R.id.playback_seeker);
        nowTimeText = (TextView) findViewById(R.id.now_time);
        totalTimeText = (TextView) findViewById(R.id.all_time);
        mSeekBar.setProgress(0);

        mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub
                mediaPlayer.start();
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub
                mediaPlayer.pause();
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                //用户手动拖动进度条则更新播放进度
                if (arg2)
                    mediaPlayer.seekTo(mSeekBar.getProgress());
            }
        });
    }


    private static void doSeekBarUpdate() {
        //设置进度条的最大值为播放时间
        mSeekBar.setMax(mediaPlayer.getDuration());

        //新开一个线程进行UI更新
        mScheduleHandler.post(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub

                if (mediaPlayer.isPlaying() && !mSeekBar.isPressed()) {
                    //更新播放进度
                    int nowTime = mediaPlayer.getCurrentPosition();
                    mSeekBar.setProgress(nowTime);

                    //更新播放时间
                    String nowTime_s = nowTimeFormat.format(nowTime);
                    nowTimeText.setText(nowTime_s);

                    try {
                        mScheduleHandler.postDelayed(this, 1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    public void getMusicListFromSD() {
        //保证只加载一次
        if (loadFlag != 1)
            return;


        musicList = MusicUtils.getMusicInfoList(this);

        loadFlag++;
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        menu.add("menu");
        return super.onPrepareOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}