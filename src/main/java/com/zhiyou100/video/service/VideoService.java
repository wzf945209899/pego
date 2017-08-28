package com.zhiyou100.video.service;




import java.sql.Array;
import java.util.List;

import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.utils.Page;

public interface VideoService {

	//List<Video> findAllVideo();

	Page loadPage(VideoVO v);

	void addVideo(Video v);

	void deleteVideo(int id);

	Video updateVideo(int id);
	void updateVideo(Video v);

	

	void deleteAllVideo(Integer[] brr);

	List<Video> seeCourseTimes();

	
}
