<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="/board/register" method="POST">
					<div class="form-group">
						<label for="exampleFormControlInput1">Title</label> 
						<input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="Input title">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Writer</label> 
						<input type="text" class="form-control" id="exampleFormControlInput1" name="writer" placeholder="Input writer">
					</div>
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Context</label>
						<textarea class="form-control" id="exampleFormControlTextarea1" name="context" rows="3" placeholder="Input context"></textarea>
					  </div>
					  <button type="submit" class="btn btn-primary">Submit</button>
				</form>
				<button type="button" class="btn list btn-secondary">List</button>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<%@ include file="/includes/footer.jsp"%>

<script>
	$(document).ready(function(){

		$(".list").on("click", function(){
			self.location="/board/list"
		})
	});
</script>