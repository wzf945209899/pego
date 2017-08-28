<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="lyb" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>hello world</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery-1.12.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
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
        <div class="navbar-header" >
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">视频管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath }/video/videoList.action">视频管理</a></li>
            <li><a href="${pageContext.request.contextPath }/speaker/speakerList.action">主讲人管理</a></li>
            <li class="active"><a href="#">课程管理</a></li>
            <li><a href="${pageContext.request.contextPath }/course/seeCourseTimes.action">统计分析</a></li>
             </ul>
               <ul class="nav navbar-nav navbar-right">
            		  <li><a href="#">${user.loginName }</a></li>
            		  <li><a href="${pageContext.request.contextPath }/index.jsp" onclick="" target="_blank" class="glyphicon glyphicon-log-out"></a></li>
                 </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
     
 </nav>
    <div class="jumbotron" align="middle">
      <h2>课程列表-课程管理</h2>
    </div>
	<!-- *****************************************************************-->
	<div class="body" >
		<div style="width: 60%;">
	 <a class="btn btn-primary va-bottom" href="${pageContext.request.contextPath }/course/addCourse.action">添加课程</a>
	 	</div>
    </div>  
   <!-- ***************************************************************-->
   <div class="body">
   	<div style="width: 60%">
   	<table class="table">
      <thead>
        <tr>
          <th width="100px">序号</th>
          <th width="100px">标题</th>
          <th width="100px">学科</th>
          <th >简介</th>
          <th width="100px">编辑</th>
           <th width="100px">删除</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach var="mm" items="${page.rows}" varStatus="status">
        <tr>
          <th>${status.count}</th>
          <td>${mm.courseName }</td>
          <td>${mm.subjectName }</td>
          <td>${mm.courseDescr }</td>
          <td><a class="glyphicon glyphicon-edit"  href="${pageContext.request.contextPath }/course/updateCourse.action?id=${mm.id}"></a></td>
         <%--  <td><a class="glyphicon glyphicon-trash" href="${pageContext.request.contextPath }/course/deleteCourse.action?id=${mm.id}"></a></td> --%>
      <td>
  				<a class="glyphicon glyphicon-trash" data-toggle="modal" data-target="#myModal${mm.id }" ></a>
					<!-- Modal -->		
				<div class="modal fade" id="myModal${mm.id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  					<div class="modal-dialog" role="document">
    					<div class="modal-content">
     						 <div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        						<h4 class="modal-title" id="myModalLabel">确认框</h4>
      						 </div>
                          <div class="modal-body">确认删除么</div>
      						<div class="modal-footer">
       							 <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
		                     <a class="btn btn-primary" href="${pageContext.request.contextPath }/video/deleteVideo.action?id=${mm.id }" />确定</a>
						      </div>
						    </div>
						  </div>
						</div>
  				    </td>
      
        </tr>
      </c:forEach>
      </tbody>
    </table>
    </div>
   </div>
 <!-- **********************************************************************--> 
	<div class="body">
  		<div style="width: 60%">
  		    <lyb:page url="${pageContext.request.contextPath }/course/courseList.action"></lyb:page>
        </div>
  	</div>    
  </body>
</html>
 