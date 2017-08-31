<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="lyb" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>hello world</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <style>
    		.body {
				    background-color: #fff;
				    display: flex;
				    justify-content: center;
				    align-items: center;
		}
    </style>
    
    
  </head>
  <body>
	  <nav class="navbar navbar-inverse">
      <div class="container-fluid" style="width: 60%;">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#" >视频管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">视频管理</a></li>
            <li ><a href="${pageContext.request.contextPath }/admin/speaker/speakerList.action">主讲人管理</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/course/courseList.action">课程管理</a></li>
              <li><a href="${pageContext.request.contextPath }/admin/course/seeCourseTimes.action">统计分析</a></li>
           
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
 </nav>
    <div class="jumbotron" align="middle">
      <h2>编辑视频信息-视频管理</h2>
    </div>
       <div class="body">
         	<div style="width: 60%;">
			  <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/video/addVideo.action" method="post">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">视频标题</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputEmail3" placeholder="视频标题" name="videoTitle">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">主讲人</label>
			    <div class="col-sm-10">
			      <select class="form-control" name="speakerId">
 				    <c:forEach items="${spList }" var="list">
					  <option value="${list.id }" ${speakerName eq list.id ? "selected":""}>${list.speakerName }</option>
					</c:forEach> 
				</select>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
			    <div class="col-sm-10">
			     <select class="form-control" name="courseId">
 					<c:forEach items="${coList }" var="list">
					  <option value="${list.id }" ${courseName eq list.id ? "selected":""}>${list.courseName }</option>
					</c:forEach>
				</select>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">课程时长</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputPassword3" placeholder="课程时长(秒)" name="videoPlayTimes">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">封面图片</label>
			    <div class="col-sm-10">
			    <!--  <input type="file" id="exampleInputFile" name="videoimageUrl" placeholder="封面图片"> -->
			     <input type="text" class="form-control" id="inputEmail3" placeholder="封面图片" name="videoImageUrl"> 
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">视频播放地址</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputEmail3" placeholder="视频播放地址" name="videoUrl">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">视频简介</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputEmail3" placeholder="视频简介" name="videoDescr">
			    </div>
			   </div>
				  
				 <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      		<button type="submit" class="btn btn-primary va-bottom">保存</button>
				      			<a class="btn btn-primary va-bottom" href="javascript:history.go(-1)">返回列表</a>
				   	</div>
				 </div>
			   </div>
			 </div>
	  </form>
  </body>
</html>
