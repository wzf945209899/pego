<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
 
<head>
   <base href="<%=basePath%>">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/profile.css">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">
   <jsp:include page="uheader.jsp"></jsp:include>
    <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
                    <li><a href="front/user/profile.action">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="front/user/avatar.action">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="front/user/password.action">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                        
                           <c:if test="${empty user.headUrl}">
		                         <img id="avatar"  src="static/img/avatar_lg.png" alt="">
		                      </c:if>
		                      
		                      <c:if test="${not empty user.headUrl}">
		                         <img id="avatar" width="200px" height="200px" src="/pic/${user.headUrl }" alt="">
		                      </c:if>
                           
                        </div>
                        
                        <div class="profile_ifo_area">
                        
                         <c:if test="${not empty message}">
				            <div>
				                <strong>${message}</strong>
				            </div>
				            </c:if>
                            <form action="front/user/password.action" method="post" id="Form">
                                <div class="form_group">
                                    <span class="dd">旧&#x3000;密&#x3000;码：</span>
                                    <input type="password" id="oldPassword" name="oldPassword">
                                    <span id="mm"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">新&#x3000;密&#x3000;码：</span>
                                    <input type="password" id="newPassword"  name="newPassword">
                                </div>
                                <div class="form_group">
                                    <span class="dd">确认新密码：</span>
                                    <input type="password" id="newPassword02" name="newPasswordAgain">
                                </div>
                                <div class="form_submit dd">
                                    <input type="submit" value="保&#x3000;存">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="ufooter.jsp"></jsp:include>
    <%@include file="../include/script.html"%>
   <script type="text/javascript">
   $(":input[name=oldPassword]").blur(function(){
		$.ajax({
			type:"get",
			dataType:"text",
			data:"password=" + $(":input[name=oldPassword]").val(),
			url:"${pageContext.request.contextPath}/front/user/password1.action",
			success:function(data){
				if(data == "fail"){
					$("#mm").text("旧密码错误");
					$(":input[name=oldPassword]").val("");
					$(":input[name=oldPassword]").focus();
				}else{
					$("#mm").text("");
				}
			}
		});	

	});

   $('#Form').validate({
		submitHandler:function(form){
			//ajax提交注册信息，并且返回注册结果
			console.log($('#Form').serialize());
			//使用ajax的post方法提交注册信息
			$.post('front/user/password.action',$('#Form').serialize(),function(result){
				console.log(result);
				if(result=="success"){
					//注册成功,刷新页面
					alert("更改成功");
					$(":input[name=oldPassword]").val("");
					$(":input[name=newPassword]").val("");
					$(":input[name=newPasswordAgain]").val("");
		 		}else{
					alert("更改失败");
				}
			},'text');
			
		},
		rules:{//写校验规则的
			oldPassword:{
				required:true
			  },
			  newPassword:{
				required:true,
				minlength:3
			},
			newPasswordAgain:{
				required:true,
				equalTo:'#newPassword'
			}
		},
		oldPassword:{//写提示信息的
			email:"旧密码必须填",
			newPassword:'密码是必须填写的，3-30个字符',
			newPasswordAgain:'两次密码必须输入一致'
		}
	});	
   
   
   </script>
</body>
</html>