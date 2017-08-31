package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseExample;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.service.FrontCourseService;
@Service
public class FrontCourseServiceImpl implements FrontCourseService{
    @Autowired
	CourseMapper cm;
    @Autowired
    VideoMapper vm; 
    @Autowired
    SubjectMapper sm;
    @Autowired
    SpeakerMapper ssm;
	@Override
	public List<Course> selectCourse(int subjectId) {
		CourseExample CM = new CourseExample();
		CM.createCriteria().andSubjectIdEqualTo(subjectId);
		return cm.selectByExample(CM);
	}

	@Override
	public List<Video> selectVideo(Integer id) {
		VideoExample ex = new VideoExample();
		ex.createCriteria().andCourseIdEqualTo(id);
		return vm.selectByExample(ex);
	}

	@Override
	public Subject findSuject(int subjectId) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(subjectId);
	}

	@Override
	public Video selectVideo1(int videoId) {
		// TODO Auto-generated method stub
		return vm.selectByPrimaryKey(videoId);
	}

	@Override
	public Speaker findSpaker(Integer speakerId) {
		// TODO Auto-generated method stub
		return ssm.selectByPrimaryKey(speakerId);
	}

	@Override
	public Course findCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return cm.selectByPrimaryKey(courseId);
	}

	@Override
	public void updatePlayTimes(Video v) {
		// TODO Auto-generated method stub
		vm.updateByPrimaryKeySelective(v);
	}

	

}
