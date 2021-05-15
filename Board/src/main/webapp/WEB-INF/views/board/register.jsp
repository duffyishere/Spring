<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="/includes/header.jsp"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-right: 30px">Register
</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-body">
                <form action="/board/register" method="POST"/>
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input type="text" class="form-control" id="title" name="title" placeholder="Input title">
                    </div>
                    <div class="form-group">
                        <label for="writer">Writer</label>
                        <input type="text" class="form-control" id="writer" name="writer" placeholder="Input writer">
                    </div>
                    <div class="form-group">
                        <label for="context">Context</label>
                        <textarea class="form-control" id="context" rows="10" name="context"></textarea>
                    </div> 
                    <div style="margin-top: 40px">
                        <button type="submit" class="btn btn-success btn-lg upload">등록</button>
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
  crossorigin="anonymous"></script>
  
<script type="text/javascript">
    $(document).ready(function (){
        $(".upload").on("click", function (e){
            e.preventDefault();

            if($("#title").val() == "" || $("#writer").val() == "" || $("#context").val() == ""){
                alert("빈칸을 모두 입력헤주세요.")
                return false;
            }
            else{
                $("form").submit();
            }
        })

        $(".list").on("click", function (e){

            history.back();
            // location.replace("/board/list")
        })
    })
</script>

<%@ include file="/includes/footer.jsp"%>