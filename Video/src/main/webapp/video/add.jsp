<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0047)http://localhost:8080/Voids/Course/addCourse.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
<!--<base href="http://localhost:8080/Voids/">--><base href=".">


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>智游教育</title>

<link href="http://localhost:8080/Video/js/bootstrap.css" rel="stylesheet">

<style type="text/css">
.col-md-1 {
	padding-top: 20px;
}

.a1 {
	color: gray;
}

b {
	float: right;
}
</style>



</head>

<body>

	




<nav class="navbar-inverse">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand">视频管理系统</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
			<ul class="nav navbar-nav">
				<li class="active"><a href="videoShow">视频管理</a></li>
				<li><a href="speakerShow">主讲人管理</a></li>
				<li><a href="courseShow">课程管理</a></li>
			</ul>
			<p class="navbar-text navbar-right">
				<span>admin</span> <i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a class="navbar-link">退出</a>
			</p>
		</div>
	</div>

</nav>



	<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
		<div class="container">

			
				<h2>添加视频</h2>
			
			
		</div>
	</div>



	<div class="container" style="margin-top: 20px;">

		<form id="infoForm" action="addVideo" class="form-horizontal"  method="post" >

			<div class="form-group">
				<label for="subjectTitle" class="col-sm-2 control-label">视频标题</label>
				<div class="col-sm-10">
					<input class="form-control" name="title" id="subjectTitle" placeholder="课程标题" type="text">
				</div>
			</div>
			<div class="form-group">
			    <label for="subjectId" class="col-sm-2 control-label">主讲人</label>
			    <div class="col-sm-10">
					<select name="speaker_id" id="subjectId" class="form-control">
						<option value="0" selected="selected">请选择讲师</option>
						<c:forEach items="${speakerList}" var="speakerList">
							<option value="${speakerList.id}">${speakerList.speaker_name }</option>
						</c:forEach>
					</select>
			    </div>
			 </div>
			<div class="form-group">
			    <label for="subjectId" class="col-sm-2 control-label">所属课程</label>
			    <div class="col-sm-10">
					<select name="course_id" id="subjectId" class="form-control">
						<option value="0" selected="selected">请选择所属课程</option>
						<c:forEach begin="0" end="${courseList.size()-1}" var="i">
							<option value="${courseList[i].id }">${courseList[i].course_title}</option>
						</c:forEach>
					</select>
			    </div>
			  </div>
			<div class="form-group">
				<label for="subjectTitle" class="col-sm-2 control-label">视频时长（秒）</label>
				<div class="col-sm-10">
					<input class="form-control" name="time" id="subjectTitle" placeholder="精确到秒（正整数）" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="subjectTitle" class="col-sm-2 control-label">封面图片地址</label>
				<div class="col-sm-10">
					<input class="form-control" name="image_url" id="subjectTitle" placeholder="具体的url" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="subjectTitle" class="col-sm-2 control-label">视频播放地址</label>
				<div class="col-sm-10">
					<input class="form-control" name="video_url" id="subjectTitle" placeholder="具体的url" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="courseDesc" class="col-sm-2 control-label">备注</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="courseDesc" name="detail" rows="3"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">保存</button>
				</div>
			</div>
		</form>
	</div>
<script src="http://localhost:8080/Video/js/jquery-1.js"></script>
<script src="http://localhost:8080/Video/js/bootstrap.js"></script>
<script src="http://localhost:8080/Video/js/confirm.js"></script>
<script src="http://localhost:8080/Video/js/jquery.js"></script>
<script src="http://localhost:8080/Video/js/message_cn.js"></script>


<div id="modal-background" class=""></div><div id="confirm-modal" class="modal fade role=" dialog"="" tabindex="-1"><div class="modal-dialog modal-undefined"><div class="modal-content"><div class="modal-header"><button id="modal-upper-close" class="close modal-close" aria-label="Close" type="button"><span aria-hidden="true">×</span></button><h4 id="modal-title" class="modal-title">Modal Title</h4></div><div id="modal-body" class="modal-body"> Modal Message </div><div id="modal-footer" class="modal-footer"></div></div></div></div><div id="modal-background" class=""></div></body></html>