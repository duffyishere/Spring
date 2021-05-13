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
            <div class="panel-body">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" id="title" readonly value="<c:out value='${post.title}'/>">
                </div>
                <div class="form-group">
                    <label for="writer">Writer</label>
                    <input type="text" class="form-control" id="writer" readonly value="<c:out value='${post.writer}'/>">
                </div>
                <div class="form-group">
                    <label for="regDate">RegDate</label>
                    <input type="text" class="form-control" id="regDate" readonly value="<fmt:formatDate value="${post.regDate}" pattern="yyyy-MM-dd" var="redDateF" /> <c:out value="${redDateF}" />">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Context</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" readonly><c:out value='${post.context}'/></textarea>
                </div>
                <div style="margin-top: 40px">
                    <button type="button" class="btn btn-success btn-lg modify">수정</button>
                    <button type="button" class="btn btn-danger btn-lg delete">삭제</button>
                    <button type="button" class="btn btn-secondary btn-lg list">목록</button>
                </div>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
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


	<script
			src="https://code.jquery.com/jquery-3.6.0.js"
			integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
			crossorigin="anonymous">
	</script>
	
    <script>
        function showModal(result){
            if(typeof result != "undefined"){
                $("#myModal").modal();
            }
        }

        $(document).ready(function (){

            var result = <c:out value="${result}"/>

            showModal(result);

            $(".list").on("click", function (e) {

                $(location).attr("href", "/board/list");
            });

            $(".modify").on("click", function (e){
                $(location).attr("href", "/board/modify?bno="+<c:out value="${post.bno}"/>);
            })

            $(".delete").on('click', function(e) {
                let bno = <c:out value='${post.bno}'/>
                    let form = $('<form></form>');
                form.attr('action', "/board/delete");
                form.attr('method', 'post');
                form.appendTo('body');
                form.append($('<input type="hidden" value="' +bno+ '" name=bno>'));
                form.submit();
            });
        })
    </script>

<%@ include file="/includes/footer.jsp"%>