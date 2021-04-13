<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Modify</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Modify</div>
			<!-- /.panel-heading -->
				<div class="panel-body">
				<form role="form" action="/board/modify" method="POST">
					<div class="form-group">
						<input name='pageNum' value='<c:out value="${ cri.pageNum}"/>'>
						<input name='amount' value='<c:out value="${ cri.amount}"/>'>
						<div class="form-group col-md-6">
						  <label>Bno</label>
						  <input type="text" class="form-control" name="bno" value="<c:out value="${post.bno }"/>" readonly>
						</div>
						<div class="form-group col-md-6">
						  <label for="inputPassword4">Writer</label>
						  <input type="text" class="form-control" name="writer" value="<c:out value="${post.writer }"/>" readonly>
						</div>
					  </div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Title</label> 
						<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<c:out value="${post.title }"/>'/>
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" id="exampleFormControlInput1" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${post.regDate }"/>' readonly/>
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" id="exampleFormControlInput1" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${post.updateDate}"/> 'readonly/>
					</div>
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Context</label>
						<textarea class="form-control" id="exampleFormControlTextarea1" name="context" rows="3"><c:out value="${post.context }"/></textarea>
					  </div>
	
				  <button type="submit" id="list" data-oper="list" class="btn btn-outline-secondary">List</button>	
				  <button type="submit" id="modify" data-oper="modify" class="btn btn-primary">Modify</button>
				  <button type="submit" id="remove" data-oper="remove" class="btn btn-danger">Remove</button>
				</form>
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

	var formObj = $("form");

	$("button").on("click", function(e){

		e.preventDefault();

		var operation = $(this).data("oper");

		console.log(operation);
		
		if(operation === 'remove'){
			formObj.attr("action", "/board/remove")
		}
		else if(operation === 'list'){
			formObj.attr("action", "/board/list").attr("method", "GET")
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();

			console.log(pageNumTag)
			console.log(amountTag)

			formObj.empty();
			formObj.append(pageNumTag)
			formObj.append(amountTag)
		}
		formObj.submit();
	})

    // $("#list").on("click", function(){
    //   self.location="/board/list"
    // })

	// $("#modify").on("click", function(){
    //   self.location="/board/modify?bno="+<c:out value="${post.bno }"/>
    // })

	// $("#remove").on("click", function(){
    //   self.location="/board/remove?bno="+<c:out value="${post.bno }"/>
    // })
})
</script>