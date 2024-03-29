<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><a href="list">Board List</a></h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading"></div>
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
							<td><a class="move" href='<c:out value="${board.bno }"/>' id='title'><c:out value="${board.title }" />	<b>[<c:out value="${board.replyCnt}"/>]</b></a></td>
							<td><c:out value="${board.writer }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.regDate }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.updateDate }" /></td>
						</tr>
					</c:forEach>
				</table>

				<div class="row">
					<div class="col-lg-12">
						<form id="search-form" action="/board/list" method="GET">
							<select class="selectpicker" name="type">
							  <optgroup label="Searching Option">
								<option value="" <c:out value='${page.cri.type eq null? "selected": ""}'/> >--</option>
								<option value="T" <c:out value='${page.cri.type eq "T"? "selected": ""}'/> >Title</option>
								<option value="W" <c:out value='${page.cri.type eq "W"? "selected": ""}'/> >Writer</option>
								<option value="C" <c:out value='${page.cri.type eq "C"? "selected": ""}'/> >Context</option>
								<option value="TW" <c:out value='${page.cri.type eq "TW"? "selected": ""}'/> >Title or Writer</option>
								<option value="TC" <c:out value='${page.cri.type eq "TC"? "selected": ""}'/> >Title or Context</option>
								<option value="TCW" <c:out value='${page.cri.type eq "TCW"? "selected": ""}'/> >Title or Writer or Context</option>
							  </select>
							  <input type="text" name="keyWord"value="${page.cri.keyWord }" placeholder="Please enter a search term." style="width: 300px;">
							  <input type="hidden" name="pageNum" value="${page.cri.pageNum }">
							  <input type="hidden" name="amount" value="${page.cri.amount }">
							  <button type="button" class="btn btn-primary">Search</button>
						</form>
					</div>
				</div>

				<nav aria-label="Page navigation example" class="center">
					<ul class="pagination">
						<c:if test="${page.prev }">
							<li class="page-item paginate_button"><a class="page-link" href="${page.startPage-1 }"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="num" begin="${page.startPage }"
							end="${page.endPage }">
							<li class="page-item paginate_button ${page.cri.pageNum == num? 'active':'' }"><a class="page-link" href="${num }">${num }</a></li>
						</c:forEach>
						<c:if test="${page.next }">
							<li class="page-item paginate_button"><a class="page-link" href="${page.endPage+1 }"
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
	<input type="hidden" name="type" value="${page.cri.type }">
	<input type="hidden" name="keyWord" value="${page.cri.keyWord }">
	
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
				var searchForm = $("#search-form")

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

				$("#search-form button").on('click', function(e){
					e.preventDefault();

					if(!searchForm.find("option:selected").val()){
						alert("검색종류를 선택하세요. ")
						return false;
					}

					if(!searchForm.find("input[name='keyWord']").val()){
						alert("검색어를 입력하세요. ")
						return false;
					}

					searchForm.find("input[name='pageNum']").val("1");
					
					searchForm.submit();
				})
			})
</script>