package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;

public interface FrontCourseService {

	List<Course> selectCourse(int subjectId);

	List<Video> selectVideo(Integer id);

	Subject findSuject(int subjectId);

	Video selectVideo1(int videoId);

	Speaker findSpaker(Integer speakerId);

	Course findCourse(Integer courseId);

	

	void updatePlayTimes(Video v);
    
}
