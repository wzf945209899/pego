package com.zhiyou100.video.service.impl;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;

@Service
public class VideoServiceImpl implements VideoService {
    
	@Autowired
	VideoMapper vm;


	@Override
	public Page loadPage(VideoVO v) {
		Page<Video> pa = new Page<>();
		pa.setPage(v.getCurrentPage());
		pa.setSize(10);
		v.setCurrentPage((v.getCurrentPage()-1)*10);
		pa.setTotal(vm.findAllVideoCount(v));
		pa.setRows(vm.findVideo(v));
		//System.out.println(vm.findVideo(v));
		//System.out.println(vm.findAllVideoCount(v));
		return pa;
	
	}

	@Override
	public void addVideo(Video v) {
		vm.insert(v);
		
	}

	@Override
	public void deleteVideo(int id) {
		vm.deleteByPrimaryKey(id);
		
	}

	@Override
	public Video updateVideo(int id) {
		// TODO Auto-generated method stub
		return vm.selectByPrimaryKey(id);
	}

	@Override
	public void updateVideo(Video v) {
		// TODO Auto-generated method stub
		vm.updateByPrimaryKeySelective(v);
	}
 

	@Override
	public void deleteAllVideo(Integer[] brr) {
		VideoExample example = new VideoExample();
		List<Integer> list = Arrays.asList(brr);
		example.createCriteria().andIdIn(list);
 		vm.deleteByExample(example);
	}

	@Override
	public List<Video> seeCourseTimes() {
		// TODO Auto-generated method stub
		return vm.seeCourseTimes();
	}
}
