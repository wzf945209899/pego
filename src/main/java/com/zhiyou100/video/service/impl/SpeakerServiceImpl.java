package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
	SpeakerMapper sm;
	
	@Override
	public List<Speaker> findAllSpeaker() {
		return sm.selectByExample(null);
	}

	@Override
	public Page loadPage(Integer page, String speakerJob, String speakerName) {
		Page<Video> pa = new Page<>();
		pa.setPage(page);
		pa.setSize(10);
		page = (page-1)*10;
		pa.setTotal(sm.findAllSpeakerCount(speakerJob,speakerName));
		pa.setRows(sm.findAllSpeaker(page,speakerName,speakerJob));
		//System.out.println(pa);
		return pa;
	}

	@Override
	public void addSpeaker(Speaker s) {
		// TODO Auto-generated method stub
		sm.insertSelective(s);
	}

	@Override
	public void deleteSpeaker(Integer id) {
		// TODO Auto-generated method stub
		sm.deleteByPrimaryKey(id);
	}

	@Override
	public Speaker updateSpeaker(Integer id) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(id);
	}

	@Override
	public void updateSpeaker(Speaker s) {
		// TODO Auto-generated method stub
		sm.updateByPrimaryKeySelective(s);
	}

}
