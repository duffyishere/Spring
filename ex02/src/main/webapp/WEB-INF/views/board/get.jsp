<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<div class="form-group">
					<label>BNO</label> <input name="bno" class="form-control"
						readonly="readonly" value='<c:out value="${ board.bno }" />'>
				</div>

				<div class="form-group">
					<label>Title</label> <input name="title" class="form-control"
						readonly="readonly" value='<c:out value="${ board.title }" />'>
				</div>

				<div class="form-group">
					<label>Context</label>
					<textarea class="form-control" name="context" rows="3"
						readonly="readonly" style="resize: none;"><c:out
							value="${ board.context }" />
						</textarea>
				</div>

				<div class="form-group">
					<label>Writer</label> <input class="form-control" name="writer"
						readonly="readonly" value='<c:out value="${ board.writer }" />'>
				</div>

				<button type="button" class='btn btn-default btn-list btn-list'><a href="/board/list">List</a></button>
				
				<button type="button" class='btn btn-default btn-modify'><a href="/board/modify?bno=<c:out value="${ board.bno }" />">Modify</a></button>
				

				<form id="actionForm" action="/board/list" method="get">
					<input type="hidden" name="pageNum" value="${cri.pageNum }"> 
					<input type="hidden" name="amount" value="${cri.amount }">
					<input type="hidden" name="bno" value="${board.bno }">
				</form>
				
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<script type="text/javascript">
		$(document).ready(function() {
			var operform = $("#operform")
		})
		
		var actionForm = $("#actionForm");
		
		$(".btn-list").click(function(e){
			e.preventDefault();
			actionForm.find("input[name='bno']").remove();
			actionForm.submit();
		})
		
		$(".btn-modify").click(function(e){
			e.preventDefault();
			actionForm.attr("action", "/board/modify");
			actionForm.submit();
		})
	</script>

	<%@ include file="../includes/footer.jsp"%>