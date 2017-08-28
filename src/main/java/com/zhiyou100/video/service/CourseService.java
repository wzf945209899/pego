package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.utils.Page;

public interface CourseService {

	List<Course> findAllCourse();

	Page loadPage(Integer page);

	void addCourse(Course c);

	void deleteCourse(Integer id);

	Course selectCourse(Integer id);

	void updateCourse(Course c);



}
