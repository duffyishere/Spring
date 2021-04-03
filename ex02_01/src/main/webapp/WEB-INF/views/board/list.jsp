<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="/includes/header.jsp"%>

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
			<div class="panel-heading">Board List</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<button type="button" class="btn btn-primary pull-right register">Register</button>

				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>Bno</th>
							<th>Title</th>
							<th>Writer</th>
							<th>RegDate</th>
							<th>UpdateDate</th>
						</tr>
					</thead>
					<c:forEach items="${list }" var="board">
						<tr class="odd gradeX">
							<td><c:out value="${board.bno }" /></td>
							<td><a class="move" href='<c:out value="${board.bno }"/>' id='title'><c:out value="${board.title }" /></a></td>
							<td><c:out value="${board.writer }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.regDate }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.updateDate }" /></td>
						</tr>
					</c:forEach>
				</table>

				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:if test="${page.prev }">
							<li class="page-item paginate_button"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="num" begin="${page.startPage }"
							end="${page.endPage }">
							<li class="page-item paginate_button ${page.cri.pageNum == num? 'active':'' }"><a class="page-link" href="${num }">${num }</a></li>
						</c:forEach>
						<c:if test="${page.next }">
							<li class="page-item paginate_button"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<form id="actionform" action="/board/list" method="get">
	<input type="hidden" name="pageNum" value="${page.cri.pageNum }">
	<input type="hidden" name="amount" value="${page.cri.amount }">
</form>
<div class="modal" id="myModal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>처되었습니다.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<%@ include file="/includes/footer.jsp"%>

<script>
	$(document).ready(function() {

				var num = '<c:out value="${result}"/>';

				checkModal(num);

				history.replaceState({}, null, null);

				var actionForm = $("#actionform");
				

				function checkModal(result) {
					if (result == '' || history.state) {
						return;
					}

					if (parseInt(result) > 0) {
						$(".modal-body").html("게시물" + parseInt(result) + "번이 등록되었습니다.");
					}
					$("#myModal").modal("show");
				}

				$(".register").on("click", function() {
					self.location = "/board/register";
				})

				$(".page-item a").on("click", function(e){
					e.preventDefault();

					console.log("click");

					actionForm.find("input[name='pageNum']").val($(this).attr("href"));
					actionForm.submit();
				})	

				$(".move").on("click", function(e){
					e.preventDefault();

					actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
					actionForm.attr("action", "/board/get");
					actionForm.submit();
				})

			})
</script>