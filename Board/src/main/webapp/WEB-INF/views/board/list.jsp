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
				<h4> Recent Posts <button type="button" class="btn btn-info btn-sm pull-right register">글쓰기</button></h4>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<tbody>
					<c:forEach items="${post}" var="list">
						<tr>
							<td width="5"><c:out value='${list.bno}'/></td>
							<td width="75%"><a class="title" href="<c:out value='${list.bno}'/>"><c:out value='${list.title}'/></a></td>
							<td width="10%"><c:out value='${list.writer}'/></td>
							<td width="10%"><fmt:formatDate value="${list.updateDate}" pattern="yyyy.MM.dd" var="redDateF" /> <c:out value="${redDateF}" /></td>
<%--							<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" var="updateDateF" /><c:out value="${updateDateF}" /></td>--%>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
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
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>

	<div>
		<form action="/board/post">
			<input type="hidden" name="bno" value="">

		</form>
	</div>
</div>
	<script
			src="https://code.jquery.com/jquery-3.6.0.js"
			integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
			crossorigin="anonymous">
	</script>

	<script type="text/javascript">
		$(document).ready(function (){

			console.log(<c:out value="${result}"/> )

            $(".register").on("click", function (e){

                $(location).attr("href", "/board/register");
            });
			
			

			$(".title").on("click", function (e){
				e.preventDefault();

				$('input[name=bno]').attr("value", ($(this).attr("href")))

				$("form").submit();
			})

		})
	</script>

<%@ include file="/includes/footer.jsp"%>
