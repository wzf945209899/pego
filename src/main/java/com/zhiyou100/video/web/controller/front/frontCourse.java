package com.zhiyou100.video.web.controller.front;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.FrontCourseService;
import com.zhiyou100.video.utils.SecondToDate;

@Controller
public class frontCourse {
       @Autowired
	   FrontCourseService fcs;
       @RequestMapping("/front/course/index.action")
          public String webCourse(int subjectId,Model md,HttpSession session){
    	   //System.out.println(subjectId);
    	  Subject s  = fcs.findSuject(subjectId);
    	  List<Course> list =  fcs.selectCourse(subjectId);
    	  for(Course c:list){
    		List<Video> mm = fcs.selectVideo(c.getId());
    		 for(Video b:mm){
    			int seconds = b.getVideoLength();
    			String sb = SecondToDate.ToDate(seconds);  //把秒转换成时分秒
                b.setVideoLengthstr(sb.toString());
    		 }
    		c.setVideoList(mm);
    	  } 
    	  
    	  session.setAttribute("subjectId", subjectId);
    	 // md.addAttribute("subjectId", subjectId);
    	  md.addAttribute("courses", list);
    	  md.addAttribute("subject", s);
    	 // System.out.println(list);
    	  return "/front/course/index"; 
       }
       
      
       @RequestMapping("/front/video/index.action")
       public String video(int subjectId,int videoId,Model md,HttpSession session){
 	   //System.out.println(subjectId+"++++++++++++"+videoId);
 	    Subject s  = fcs.findSuject(subjectId);
 		//Video v = fcs.selectVideo1(videoId);
 	
 	    md.addAttribute("videoId", videoId);
 	    md.addAttribute("subject", s);
 	   /* int a = (int) session.getAttribute("subjietId");
 	    md.addAttribute("subjietId", a);*/
 	  //System.out.println(list);
 	  return "/front/video/index"; 
    }
       
       @RequestMapping("/front/video/videoData.action")
       public String videoData(int videoId,Model md){
 		Video v = fcs.selectVideo1(videoId);
 	    md.addAttribute("video", v);
 	   // System.out.println(v.getSpeakerId());
 	    Speaker S = fcs.findSpaker(v.getSpeakerId());
 	    md.addAttribute("speaker", S);
 	    Course ss = fcs.findCourse(v.getCourseId());
 	    md.addAttribute("course", ss);
 	    List<Video> mm = fcs.selectVideo(v.getSpeakerId());
 	    for(Video c:mm){
 	    	int seconds = c.getVideoLength();
 	    	  String sb = SecondToDate.ToDate(seconds); //把秒转换成时分秒
               c.setVideoLengthstr(sb.toString());
   		       c.setSpeakerName(S.getSpeakerName());
   	    } 
 	    
 	    md.addAttribute("videoList", mm);
 	    md.addAttribute("subjictId", 0);
 	    // System.out.println(mm);
 	  return "/front/video/content"; 
    }
       
       @RequestMapping("/front/video/state.action")
       public void state(int videoId,Model md){
 		Video v = fcs.selectVideo1(videoId);
 	   // md.addAttribute("video", v);
 	     int a = v.getVideoPlayTimes();
 	      a = a+1;
 	      v.setVideoPlayTimes(a);
 	     fcs.updatePlayTimes(v);
 	    /*// System.out.println(v.getSpeakerId());
 	    Speaker S = fcs.findSpaker(v.getSpeakerId());
 	    md.addAttribute("speaker", S);
 	    Course ss = fcs.findCourse(v.getCourseId());
 	    md.addAttribute("course", ss);
 	    List<Video> mm = fcs.selectVideo(v.getSpeakerId());
 	    for(Video c:mm){
   		c.setSpeakerName(S.getSpeakerName());
   	    } 
 	    md.addAttribute("videoList", mm);
 	    md.addAttribute("subjictId", 0);*/
 	    // System.out.println(mm);
 	 
    }
}
