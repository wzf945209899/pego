package com.zhiyou100.video.web.controller.speaker;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;

@Controller
public class SpeakerController {

	@Autowired
	SpeakerService ss;
	
	
	@RequestMapping("/speaker/speakerList.action")
	public ModelAndView videoList(
			@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="")String speakerJob,
			@RequestParam(defaultValue="")String speakerName
			 ){
		//@RequestParam(value="id",required=true,defaultValue="1")Integer theid
		
		//System.out.println(v);
		ModelAndView mv = new ModelAndView();
	    Page pa = ss.loadPage(page,speakerJob,speakerName);
		mv.addObject("page", pa);
		mv.addObject("speakerJob", speakerJob);
		mv.addObject("speakerName", speakerName);
		//System.out.println(mv);
		mv.setViewName("/speaker/speakerList");
		return mv;
	}
	
	@RequestMapping(value="/speaker/addSpeaker.action", method=RequestMethod.GET)
	public String addSpeaker(){
		return "/speaker/addSpeaker";
	}
	
	@RequestMapping(value="/speaker/addSpeaker.action",method=RequestMethod.POST)
	public String addSpeaker(Speaker s){
		s.setInsertTime(new Date(System.currentTimeMillis()));
		ss.addSpeaker(s);
		return "redirect:/speaker/speakerList.action";
	}
	
	
	@RequestMapping(value="/speaker/deleteSepaker.action")
	public String deleteSpeaker(Integer id){
		ss.deleteSpeaker(id);
		return "redirect:/speaker/speakerList.action";
	}
	
	@RequestMapping(value="/speaker/updateSepaker.action",method=RequestMethod.GET)
	public String updateSpeaker(Integer id,Model md){
		Speaker s = ss.updateSpeaker(id);
		md.addAttribute("list", s);
		return "/speaker/updateSpeaker";
	}
	@RequestMapping(value="/speaker/updateSepaker.action",method=RequestMethod.POST)
	public String updateSpeaker(Speaker s){
		 ss.updateSpeaker(s);
		return "redirect:/speaker/speakerList.action";
	}
}
