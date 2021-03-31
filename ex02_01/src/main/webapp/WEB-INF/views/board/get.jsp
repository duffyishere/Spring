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
					  <label for="inputEmail4">Bno</label>
					  <input type="text" class="form-control" name="bno" value="<c:out value="${post.bno }"/>" readonly>
					</div>
					<div class="form-group col-md-6">
					  <label for="inputPassword4">Writer</label>
					  <input type="text" class="form-control" name="writer" value="<c:out value="${post.writer }"/>" readonly>
					</div>
				  </div>
				<div class="form-group">
					<label for="exampleFormControlInput1">Title</label> 
					<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<c:out value="${post.title }"/>' readonly/>
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1">RegDate</label> 
					<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${post.regDate }"/>' readonly/>
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1">UpdateDate</label> 
					<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${post.updateDate}"/> 'readonly/>
				</div>
				<div class="form-group">
					<label for="exampleFormControlTextarea1">Context</label>
					<textarea class="form-control" id="exampleFormControlTextarea1" name="context"' rows="3" readonly><c:out value="${post.context }"/></textarea>
				  </div> 
				

				  <button type="button" id="list" class="btn btn-outline-secondary">List</button>	
				  <button type="button" id="modify" class="btn btn-primary">Modify</button>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<%@ include file="/includes/footer.jsp"%>

<script type="text/javascript">

$(document).ready(function(){

    $("#list").on("click", function(){
      self.location="/board/list"
    })

	$("#modify").on("click", function(){
      self.location="/board/modify?bno="+<c:out value="${post.bno }"/>
    })

	// $("#remove").on("click", function(){
    //   self.location="/board/remove?bno="+<c:out value="${post.bno }"/>
    // })
})
</script>