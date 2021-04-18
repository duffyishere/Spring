<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Post</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Post</div>
			<!-- /.panel-heading -->

			<div class="panel-body">
				<div class="form-group">
					<div class="form-group col-md-6">
						<label for="inputPassword4">RegDate</label>
						<input type="text" class="form-control" name="writer" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${post.regDate }"/>' readonly>
					</div>
					<div class="form-group col-md-6">
					  <label for="inputEmail4">UpdateDate</label>
					  <input type="text" class="form-control" name="bno" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${post.updateDate}"/>'  readonly>
					</div>
				  </div>
				  <div class="form-group">
					<label for="exampleFormControlInput1">Bno</label> 
					<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<c:out value="${post.bno }"/>' readonly/>
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1">Title</label> 
					<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<c:out value="${post.title }"/>' readonly/>
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1">Writer</label> 
					<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<c:out value="${post.writer }"/>' readonly/>
				</div>
				<div class="form-group">
					<label for="exampleFormControlTextarea1">Context</label>
					<textarea class="form-control" id="exampleFormControlTextarea1" name="context" rows="3" readonly><c:out value="${post.context }"/></textarea>
				  </div> 
				

				  <button type="button" id="list" class="btn btn-outline-secondary">List</button>	
				  <button type="button" id="modify" class="btn btn-primary">Modify</button>


			</div>

	</div>
		<!-- /.panel -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Reply
				</div>
				<div class="panel-body">
					<ul class="chat">
						<li class="left clearfix" data-rno='12'>
							<div>
								<div class="header">
									<strong class="primary-font">user-00</strong>
									<small class="pull-right text-muted">2021-04-18</small>
								</div>
								<p>Looks Good!</p>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>


	</div>
	<!-- /.col-lg-12 -->
</div>

<%@ include file="/includes/footer.jsp"%>


<script src="/resources/js/reply.js"></script>

<script>
	$(document).ready(function (){

		var bnoValue = '<c:out value="${post.bno}"/>';
		var replyUL = $(".chat");

		showList(1);

		function showList(page){

			replyService.getList({bno:bnoValue, page:page||1}, function(list){
				var str="";
				if(list == null || list.length == 0){
					replyUL.html("");

					return;
				}
				for(var i=0, len = list.length; i<len || 0; i++){
						str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>"
						str += "<div> <div class='header'> <strong class='primary-font'>"+list[i].replyer+"</strong>"
						str += "<small class='pull-right text-muted'>"+replyService.displayTime(list[i].replyDate)+"</small></div>"
						str += "<p>"+list[i].reply+"</p> </div> </li>"
					}

				replyUL.html(str);

				})
		}

	})
</script>
<script>
	var bnoValue = <c:out value="${post.bno}"/>

<%--	 replyService.modify({rno:25, bno:bnoValue, reply:"Modify Reply"},--%>
<%--	 	function(result){--%>
<%--	 		alert("Modified");--%>
<%--	 })--%>

<%--	 replyService.remove(21, function(count){--%>

<%--	 	console.log(count);--%>

<%--	 	if(count === "success"){--%>
<%--	 		alert("REMOVED")--%>
<%--	 	}--%>
<%--	 },function(err){--%>
<%--	 	alert("ERROR")--%>
<%--	 })--%>

<%--	replyService.get(3, function(data){--%>
<%--		console.log(data);--%>
<%--	})--%>
	
<%--	 replyService.getList({bno:bnoValue, page:1}, function(list){--%>
<%--		for(var i=0, len = list.length || 0; i<len; i++){--%>
<%--			console.log(list[i]);--%>
<%--	 	}--%>
<%--	 }) --%>

<%-- 	replyService.add(--%>
<%--		{reply:"JS TEST", replyer:"tester", bno:bnoValue}--%>
<%--		,--%>
<%--		function(result){--%>
<%--			alert("RESULT :" + result)--%>
<%--		}--%>
<%--	) --%>
	
</script>
<script type="text/javascript">
$(document).ready(function(){

    $("#list").on("click", function(){
      self.location="/board/list?pageNum="+<c:out value="${cri.pageNum}"/>+"&amount="+<c:out value="${cri.amount}"/>
    })

	$("#modify").on("click", function(){
      self.location="/board/modify?bno="+<c:out value="${post.bno }"/>+"&pageNum="+<c:out value="${cri.pageNum}"/>+"&amount="+<c:out value="${cri.amount}"/>
    })

	// $("#remove").on("click", function(){
    //   self.location="/board/remove?bno="+<c:out value="${post.bno }"/>
    // })

})
</script>