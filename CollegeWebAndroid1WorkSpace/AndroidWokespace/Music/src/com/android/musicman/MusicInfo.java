package com.android.musicman;

public class MusicInfo {
	private int m_musicId;
	private String m_musicPath;
	private String m_musicTitle;
	private String m_musicSinger;
	private int m_duration;
	
	public MusicInfo(Integer musicId, String musicPath, String musicTitle, String musicSinger, int duration){
		this.m_musicId = musicId;
		this.m_musicPath = musicPath;
		this.m_musicTitle = musicTitle;
		this.m_musicSinger = musicSinger;
		this.m_duration = duration;
	}
	
	public int getMusicId(){
		return m_musicId;
	}
	
	public String getMusicPath(){
		return m_musicPath;
	}
	
	public String getMusicTitle(){
		return m_musicTitle;
	}
	
	public String getMusicSinger(){
		return m_musicSinger;
	}
	
    public int getDuration(){
    	return m_duration;
    }
}
