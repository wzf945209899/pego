<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="lyb" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link href="../css/bootstrap.min.css" rel="stylesheet">
	 	<script src="../js/jquery-1.12.4.min.js"></script>
   	 	<script src="../js/bootstrap.min.js"></script>
    <script type="text/javascript">
     function selectAll(a){
    	 var arr = document.getElementsByName("box");
    	 var span = document.getElementById("span");
    	 var brr = new Array;
    	 for(var i=0;i<arr.length;i++){
    			 arr[i].checked=a.checked;
    			 brr[i] = arr[i].value;
    	 }
    	   //  alert(arr.length);
    	     span.innerHTML=arr.length;
	} 
     function deleteall() {
    	 var arr = document.getElementsByName("box");
    	 var j=0;
    	 var brr = new Array;
    	 for(var i=0;i<arr.length;i++){
    			 if(arr[i].checked){
    				brr[j++] = arr[i].value; 
    				
    		 }
    	 }
    	 var span = document.getElementById("span");
    	 span.innerHTML= j;       
	  } 
	   
     function deletevideo(){
    	
    	 var arr = document.getElementsByName("box");
    	 var j=0;
    	 var brr = new Array;
    	 for(var i=0;i<arr.length;i++){
    			 if(arr[i].checked){
    				brr[j++] = arr[i].value; 
    		 }
    	 }
    		 if(confirm("你确定要删除"+j+"条记录吗")){
     		 	document.location="${pageContext.request.contextPath }/video/deleteAllVideo.action?brr="+brr;
     		 }
    	 }
	  
     
	
	
    </script>
    <style type="text/css">
    		
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
          <a class="navbar-brand" href="#">视频管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
          <ul class="nav navbar-nav">
            <li class="active"><a  href="#">视频管理</a></li>
            <li ><a href="${pageContext.request.contextPath }/speaker/speakerList.action">主讲人管理</a></li>
            <li><a href="${pageContext.request.contextPath }/course/courseList.action">课程管理</a></li>
            <li><a href="${pageContext.request.contextPath }/course/seeCourseTimes.action">统计分析</a></li>
          </ul>
            <ul class="nav navbar-nav navbar-right">
            	 <li><a href="#">${user.loginName }</a></li>
            	 <li><a href="${pageContext.request.contextPath }/index.jsp" onclick="" target="_blank" class="glyphicon glyphicon-log-out"></a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
      	</div><!-- /.container-fluid -->
      	
    </nav>
  
  	<div align="middle">
		       	<div class="jumbotron" >
		      		<div><h2>视频列表-视频管理</h2></div>
		    	</div>
  	</div>
  	
  	<div class="body">
		<div style="width: 70%" >
		
			<form action="${pageContext.request.contextPath }/video/videoList.action">
			<a href="${pageContext.request.contextPath }/video/addVideo.action" class="btn btn-primary" >添加视频</a>&nbsp;&nbsp;
		       <!-- <button class="btn btn-primary" type="button">
                                                   批量删除 <a class="btn btn-primary" onclick="deletevideo()"><span class="badge" id="span">0</span></a>
               </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
               <a class="btn btn-primary" onclick="deletevideo()">批量删除<span class="badge" id="span">0</span></a>&nbsp;&nbsp;
               
                <div class="pull-right">
			 	<input type="text" placeholder="视频标题" value="${videoTitle }" name="videoTitle"/>&nbsp;&nbsp;
			 	<div class="btn-group">
				   <select class="form-control" name="speakerName">
				     <option value="">请选择主讲人</option>
				    <c:forEach items="${spList }" var="list">
					  <option value="${list.id }" ${speakerName eq list.id ? "selected":""}>${list.speakerName }</option>
					</c:forEach> 
					</select>
				 </div>
			 	<div class="btn-group">
				    <select class="form-control" name="courseName">
				    <option value="">请选择课程</option>
				    <c:forEach items="${coList }" var="list">
					  <option value="${list.id }" ${courseName eq list.id ? "selected":""}>${list.courseName }</option>
					</c:forEach> 
					</select>
				 </div>
			 	<input type="submit" class="btn btn-primary"/>
			 	</div>
		 	</form>
		 </div>
  	</div>
  	
  	<div class="body">
  		<div style="width: 70%">
  			<table class="table table-hover">
  				<thead>
  				<tr>
  					<td width="50px"><input type="checkbox" id="box1" onclick="selectAll(this)"  /></td>
  					<td width="50px">序号</td>
  					<td width="100px">名称</td>
  					<td>介绍</td>
  					<td width="60px">讲师</td>
  					<td width="100px">课程</td>
  					<td width="60px">时长(秒)</td>
  					<td width="40px">播放次数</td>
  					<td width="40px">编辑</td>
  					<td width="40px">删除</td>
  					</tr>
  				</thead>
  				<tbody>
  			 <c:forEach var="mm" items="${page.rows}" varStatus="status">
  				<tr class="button">
  					<td ><input type="checkbox" name="box" onclick="deleteall()" value="${mm.id }"/></td>
  					<td>${status.count}</td>
  					<td>${mm.videoTitle }</td>
  					<td>${mm.videoDescr }</td>
  					<td>${mm.speakerName }</td>
  					<td>${mm.courseName}</td>
  					<td>${mm.videoLength}</td>
  					<td>${mm.videoPlayTimes}</td>
  					<td><a class="glyphicon glyphicon-edit" href="${pageContext.request.contextPath }/video/updateVideo.action?id=${mm.id }"></a></td>
  				<%-- 	<td><a class="glyphicon glyphicon-trash" href="${pageContext.request.contextPath }/video/deleteVideo.action?id=${mm.id }"></a></td>  --%>
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
		                     <a class="btn btn-primary" href="${pageContext.request.contextPath }/video/deleteVideo.action?id=${mm.id }" >确定</a>
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
  	<div class="body">
  		<div style="width: 70%">
  		        <lyb:page url="${pageContext.request.contextPath }/video/videoList.action"></lyb:page>
        </div>
  	</div>
	</body>
</html>
