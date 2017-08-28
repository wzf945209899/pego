package com.zhiyou100.video.model;

public class VideoVO {
	
	private Video v;
	private String videoTitle;
	private String speakerName;
	private String courseName;
	private int currentPage;
	public Video getV() {
		return v;
	}
	public void setV(Video v) {
		this.v = v;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "VideoVO [v=" + v + ", videoTitle=" + videoTitle + ", speakerName=" + speakerName + ", courseName="
				+ courseName + ", currentPage=" + currentPage + "]";
	}
	
	
	
	
	

}
