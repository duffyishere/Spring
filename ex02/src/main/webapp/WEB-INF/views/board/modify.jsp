<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"> Board Modify</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="/board/modify" method="post">
					<input type="hidden" name="pageNum" value="${cri.pageNum }"></input>
					<input type="hidden" name="amount" value="${cri.amount }"></input>
				
					<div class="form-group">
						<label>BNO</label> 
						<input name="bno" class="form-control" readonly="readonly"
						value='<c:out value="${ board.bno }" />'>
					</div>
			
					<div class="form-group">
						<label>Title</label> 
						<input name="title" class="form-control" 
						value='<c:out value="${ board.title }" />'>
					</div>

					<div class="form-group">
						<label>Context</label>
						<textarea class="form-control" name="context" rows="3" style="resize: none;"><c:out value="${ board.context }" />
						</textarea>
					</div>

					<div class="form-group">
						<label>Writer</label>
						 <input class="form-control" name="writer" 
						 value='<c:out value="${ board.writer }" />'>
					</div>
					
					<div class="form-group">
						 <input class="form-control" name="writer" readonly="readonly" type="hidden"
						 value='<fmt:formatDate pattern="yyyy/MM/dd" value="${ board.regdate }" />'>
					</div>
					
					<div class="form-group">
						 <input class="form-control" name="writer" readonly="readonly" type="hidden"
						 value='<fmt:formatDate pattern="yyyy/MM/dd" value="${ board.updatedate }" />'>
					</div>
					
					<button type="submit" class="btn btn-info" data-oper="list">List</button>
					<button type="submit" class="btn btn-primary" data-oper="modify">Modify</button>
					<button type="submit" class="btn btn-danger" data-oper="remove">Remove</button>
				</form>


				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	
<script>
	$(document).ready(function(){
		var formObj = $("form");
		
		$('button').on("click", function(e){
		
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === "remove"){
				formObj.attr("action", "/board/remove");
			}else if(operation === "list"){
				self.location = "/board/list?pageNum=" +$("input[name='pageNum']").val()+ "&amount=" +$("input[name='amount']").val(); 
/* 				self.location = "/board/list"
 */ 				return;	
 			}
  			formObj.submit();
  			
		});
	});
</script>

<%@ include file="../includes/footer.jsp"%>