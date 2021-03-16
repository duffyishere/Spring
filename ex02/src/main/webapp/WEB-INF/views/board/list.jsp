<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board List</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				DataTables Advanced Tables
				<button type="button" id="regBtn"
					class="btn btn-xs btn-primary pull-right">Register New Board</button>

			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>BNO</th>
							<th>Title</th>
							<th>Writer</th>
							<th>RegDate</th>
							<th>UpdateDate</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ list }" var="board">
							<tr class="odd gradeX">
								<td>${board.bno}</td>
								<td><a class="move"
									href='<c:out value="${ board.bno }" />'>
										${board.title} </a></td>
								<td>${board.writer}</td>
								<td class="center"><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regdate}" /></td>
								<td class="center"><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.updatedate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

<%-- 				<h3>${pageMaker}</h3> --%>				
				<div class="pull-right">
					<ul class="pagination">
						<c:if test="${pageMaker.prev }">
							<li class="page-item"><a class="page-link" href="${pageMaker.startPage -1 }"
								tabindex="-1">Previous</a></li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}"
							end="${pageMaker.endPage }" var="num">
							<li class="page-item ${pageMaker.cri.pageNum == num? 'active' : ''} }"><a class="page-link" href="${num }">${num }</a></li>
						</c:forEach>
						<c:if test="${pageMaker.next }">
							<li class="page-item"><a class="page-link" href="${pageMaker.endPage + 1 }"
								tabindex="-1">Next</a></li>
						</c:if>
					</ul>
				</div>
				
				<form id="actionForm" action="/board/list" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
				</form>

				<!-- 				<div class="myModal" tabindex="-1" role="dialog" aria-hidden="true">
					<div class="modal-dialog" role="document">
					  <div class="modal-content">
						<div class="modal-header">
						  <h5 class="modal-title">Modal title</h5>
						  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						  </button>
						</div>
						<div class="modal-body">
						  <p>Modal body text goes here.</p> 
						</div>
						<div class="modal-footer">
						  <button type="button" class="btn btn-primary">Save changes</button>
						  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
					  </div>
					</div>
				  </div> -->
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>

	<script>
		$(document).ready(function() {
			var result = '<c:out value="${result}"/>'

			console.log(result);

			checkModal(result);

			history.replaceState({}, null, null);

			function checkModal(result) {

				if (result === "" || history.state) {
					return;
				}
				if (result == "success") {
					$(".modal-body").html("정상적으로 처리되었습니다.")
				}
				$("#myModal").modal("show");
			}
		})

		$("#regBtn").click(function() {
			self.location = "/board/register";
		})
		
		var actionForm = $("#actionForm")
		
		$(".page-link").on("click", function(e){
			e.preventDefault();
			
			var tagetPage = $(this).attr("href");
			
			actionForm.find("input[name='pageNum']").val(tagetPage);
			 
			actionForm.submit();
		});
		
		$(".move").on("click", function(e){
			e.preventDefault();
			
			var targetBno = $(this).attr("href");
			
			actionForm.append("<input type='hidden' name='bno' value='"+targetBno+"'>'");
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		});
		
		
			
			
	</script>

	<%@ include file="../includes/footer.jsp"%>