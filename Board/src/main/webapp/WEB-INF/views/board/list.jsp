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
			<div class="panel-heading">
				<h4>
					Recent Posts
					<button type="button"
						class="btn btn-info btn-sm pull-right register">글쓰기</button>
				</h4>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<tbody>
						<c:forEach items="${post}" var="list">
							<tr>
								<td width="5"><c:out value='${list.bno}' /></td>
								<td width="75%"><a class="title"
									href="<c:out value='${list.bno}'/>"><c:out
											value='${list.title}' /></a></td>
								<td width="10%"><c:out value='${list.writer}' /></td>
								<td width="10%"><fmt:formatDate value="${list.updateDate}"
										pattern="yyyy.MM.dd" var="redDateF" /> <c:out
										value="${redDateF}" /></td>
								<%--							<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" var="updateDateF" /><c:out value="${updateDateF}" /></td>--%>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:if test="${page.prev}">
							<li class="page-item"><a class="page-link" href="${page.cri.pageNum-1}">Previous</a></li>
						</c:if>
						<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
							<li class="page-item ${page.cri.pageNum == num? 'active':'' } "><a class="page-link" href="${num}">${num}</a></li>
						</c:forEach>
						<c:if test="${page.next}">
							<li class="page-item"><a class="page-link" href="${page.cri.pageNum+1}">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
			<!-- /.panel-body -->

		</div>
		<!-- /.panel -->
		<div>
			<form class="post" action="/board/post">
				<input type="hidden" name="bno" value=""/>
			</form>
			<form class="list" action="/board/list">
				<input type="hidden" name="pageNum" value=""/>
			</form>
		</div>
	</div>
	<!-- /.col-lg-12 -->
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
					<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous">
		
	</script>

	<%@ include file="/includes/footer.jsp"%>


	<script type="text/javascript">
		function showModal(result) {
			if (typeof result != "undefined") {
				if (typeof result != "boolean") {
					$(".modal-body p").text(result + "번 글이 작성되었습니다.")
				}
				$("#myModal").modal();
			}
		}

		$(document).ready(function() {

			var result = <c:out value="${result}"/>

			showModal(result);

			$(".pagination li a").on("click", function (e){
				e.preventDefault();

				let keyWord = "${page.cri.keyword}";

				$('.list input[name=pageNum]').attr("value", ($(this).attr("href")))


				if(keyWord != ""){
					console.log("--------------");
					$('.list').append('<input type="hidden" name="keyword" value='+keyWord+' />');
					// $('.list input[name=keyword]').attr("value", keyWord);
				}

				console.log(keyWord);

				$(".list").submit();
			})


			$(".register").on("click", function(e) {

				$(location).attr("href", "/board/register");
			});

			$(".title").on("click", function(e) {
				e.preventDefault();

				let bno = ($(this).attr("href"));

				console.log(bno)

				$(location).attr("href", "/board/post/"+bno);
			})

		})
	</script>

