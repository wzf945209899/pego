package com.zhiyou100.video.web.controller.video;


import java.sql.Timestamp;

import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.model.View;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;
@Controller
public class VideoController {
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	@RequestMapping("/video/videoList.action")
	public ModelAndView videoList(VideoVO v,
			@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="")String videoTitle,
			@RequestParam(defaultValue="")String speakerName,
			@RequestParam(defaultValue="")String courseName ){
		//@RequestParam(value="id",required=true,defaultValue="1")Integer theid
		v.setVideoTitle(videoTitle);
		v.setSpeakerName(speakerName);
		v.setCourseName(courseName);
		v.setCurrentPage(page);
		//System.out.println(v);
		ModelAndView mv = new ModelAndView();
	    List<Speaker> li = ss.findAllSpeaker();
		mv.addObject("spList", li);
		List<Course> list = cs.findAllCourse();
		mv.addObject("coList", list);
	    Page pa = vs.loadPage(v);
		mv.addObject("page", pa);
		mv.addObject("videoTitle", videoTitle);
		mv.addObject("speakerName", speakerName);
		mv.addObject("courseName", courseName);
		return mv;
	}
	
	@RequestMapping(value="/video/addVideo.action",method=RequestMethod.GET)
	public ModelAndView addVideo(){
		    ModelAndView mv = new ModelAndView();
		    List<Speaker> li = ss.findAllSpeaker();
			mv.addObject("spList", li);
			List<Course> list = cs.findAllCourse();
			mv.addObject("coList", list);
		    mv.setViewName("/video/addVideo");
		    return mv;
	}

	@RequestMapping(value="/video/addVideo.action",method=RequestMethod.POST)
	public String addVideo(Video v){
		    
		    v.setInsertTime( new Timestamp(System.currentTimeMillis()));
		    vs.addVideo(v);
		    // System.out.println(v);
		   //mv.setViewName("/video/addVideo");
		    return "redirect:/video/videoList.action";
	}

	//redirect
	
	@RequestMapping(value="/video/deleteVideo.action")
	public String deleteVideo(int id){
		 //  System.out.println(id);
		    vs.deleteVideo(id);
		    return "redirect:/video/videoList.action";
	}
	
	
	@RequestMapping(value="/video/updateVideo.action",method=RequestMethod.GET )
	public ModelAndView updateVideo(int id){
		    Video v = vs.updateVideo(id);
		    ModelAndView mv = new ModelAndView();
		    List<Speaker> li = ss.findAllSpeaker();
			mv.addObject("spList", li);
			List<Course> list = cs.findAllCourse();
			mv.addObject("coList", list);
		   // System.out.println(v);
		    mv.addObject("video", v);
		    mv.setViewName("/video/updateVideo");
		    return mv;
	}
	
	@RequestMapping(value="/video/updateVideo.action",method=RequestMethod.POST )
	public String updateVideo(Video v){
		   // System.out.println(v);
		    vs.updateVideo(v);
		    return "redirect:/video/videoList.action";
	}
	
	@RequestMapping(value="/video/deleteAllVideo.action" )
	public String deleteAllVideo(Integer[] brr){
		  
		    vs.deleteAllVideo(brr);
		    return "redirect:/video/videoList.action";
	}
	
	@RequestMapping("/course/seeCourseTimes.action")
	public String view(){
		return "/echarts/echarts";
	}

	
	@RequestMapping(value="/course/seeCourseTimes11.action" )
	@ResponseBody
	public String seeCourseTimes() throws JsonProcessingException{
		
	     List<Video> list = vs.seeCourseTimes();
	   //  md.addAttribute("list", list);
	     
	     List li = new LinkedList();
			for(Video v: list){
				View vi = new View();
				vi.setId(v.getVideoPlayTimes());
				vi.setName(v.getCourseName());
				li.add(vi);
			}
			  ObjectMapper mapper = new ObjectMapper();    
			  String json = mapper.writeValueAsString(li); 
			 
			 // System.out.println(list);
			//  System.out.println(json);
			 return json;

	     
	     
	     
	  
	}
	
}
