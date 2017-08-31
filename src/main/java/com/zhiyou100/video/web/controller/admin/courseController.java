package com.zhiyou100.video.web.controller.admin;



import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("/admin")
public class courseController {
	@Autowired
	CourseService cs ;
	@Autowired
	SubjectService  ss;
	
	@RequestMapping("/course/courseList.action")
	public ModelAndView videoList(@RequestParam(defaultValue="1")Integer page){
		ModelAndView mv = new ModelAndView();
	    Page pa = cs.loadPage(page);
	    // System.out.println(pa);
	    mv.addObject("page", pa);
	    mv.setViewName("/course/courseList");
		return mv;
	}
	
	@RequestMapping(value="/course/addCourse.action", method=RequestMethod.GET)
	public String addCourse(Model md){
	    List<Subject> li = ss.findAllSubject();
	    md.addAttribute("list", li);
		return "/course/addCourse";
	}
	
	@RequestMapping(value="/course/addCourse.action", method=RequestMethod.POST)
	public String addCourse(Course c){
	    c.setInsertTime(new Date(System.currentTimeMillis()));
	    cs.addCourse(c);
		return "redirect:/admin/course/courseList.action";
	}
	
	@RequestMapping(value="/course/deleteCourse.action")
	public String deleteCourse(Integer id){
	    cs.deleteCourse(id);
		return "redirect:/admin/course/courseList.action";
	}
	
	
	@RequestMapping(value="/course/updateCourse.action",method=RequestMethod.GET)
	public String updateCourse(Integer id,Model md){
	    Course co = cs.selectCourse(id);
	    List<Subject> li = ss.findAllSubject();
	    md.addAttribute("li", co);
	    md.addAttribute("list", li);
		return "/course/updateCourse";
	}
	@RequestMapping(value="/course/updateCourse.action",method=RequestMethod.POST )
	public String updateCourse(Course c){
	     c.setUpdateTime(new Date(System.currentTimeMillis()));
	     cs.updateCourse(c);
		return "redirect:/admin/course/courseList.action";
	}
	
	
	
}
