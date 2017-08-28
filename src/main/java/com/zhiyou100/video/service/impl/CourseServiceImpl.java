package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.utils.Page;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
	CourseMapper cm;
	
	@Override
	public List<Course> findAllCourse() {
		return cm.selectByExample(null);
	}

	@Override
	public Page loadPage(Integer page) {
		Page<Video> pa = new Page<>();
		pa.setPage(page);
		pa.setSize(10);
		page = (page-1)*10;
		pa.setTotal(cm.findAllCourseCount());
		pa.setRows(cm.findAllCourse(page));
		//System.out.println(pa);
		return pa;
	}

	@Override
	public void addCourse(Course c) {
		cm.insertSelective(c);
	}

	@Override
	public void deleteCourse(Integer id) {
		cm.deleteByPrimaryKey(id);
		
	}

	@Override
	public Course selectCourse(Integer id) {
		// TODO Auto-generated method stub
		return cm.selectByPrimaryKey(id);
	}

	@Override
	public void updateCourse(Course c) {
		// TODO Auto-generated method stub
		cm.updateByPrimaryKeySelective(c);
	}



}
