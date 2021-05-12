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
            <div class="panel-body">
                <form action="/board/modify" method="POST">
                    <div class="form-group">
                        <input type="hidden" class="form-control" name="bno" value="<c:out value='${post.bno}'/>">
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                        <input type="text" class="form-control" name="title" value="<c:out value='${post.title}'/>">
                    </div>
                    <div class="form-group">
                        <label>Writer</label>
                        <input type="text" class="form-control" name="writer" readonly value="<c:out value='${post.writer}'/>">
                    </div>
                    <div class="form-group">
                        <label>Context</label>
                        <textarea class="form-control" name="context" rows="10"><c:out value='${post.context}'/></textarea>
                    </div>
                    <div style="margin-top: 40px">
                        <button type="submit" class="btn btn-success btn-lg modify">등록</button>
                        <button type="button" class="btn btn-secondary btn-lg list">목록</button>
                    </div>
                </form>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>

	<script
			src="https://code.jquery.com/jquery-3.6.0.js"
			integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
			crossorigin="anonymous">
	</script>
	
    <script>
        $(".list").on("click", function (e) {

            $(location).attr("href", "/board/list");
        });


        $(".delete").on('click', function(e) {
        	let bno = <c:out value='${post.bno}'/>
            const form = $('<form></form>');
            form.attr('action', "/board/delete");
            form.attr('method', 'post');
            form.appendTo('body');
            form.append($('<input type="hidden" value="' +bno+ '" name=bno>'));
            form.submit();
        });
    </script>

<%@ include file="/includes/footer.jsp"%>