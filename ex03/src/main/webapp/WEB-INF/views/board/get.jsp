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
			<div class="panel-heading">Post</div>
			<!-- /.panel-heading -->

			<div class="panel-body">
				<div class="form-group">
					<div class="form-group col-md-6">
						<label for="inputPassword4">RegDate</label>
						<input type="text" class="form-control" name="writer" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${post.regDate }"/>' readonly>
					</div>
					<div class="form-group col-md-6">
					  <label for="inputEmail4">UpdateDate</label>
					  <input type="text" class="form-control" name="bno" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${post.updateDate}"/>'  readonly>
					</div>
				  </div>
				  <div class="form-group">
					<label for="exampleFormControlInput1">Bno</label> 
					<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<c:out value="${post.bno }"/>' readonly/>
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1">Title</label> 
					<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<c:out value="${post.title }"/>' readonly/>
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1">Writer</label> 
					<input type="text" class="form-control" id="exampleFormControlInput1" name="title" value='<c:out value="${post.writer }"/>' readonly/>
				</div>
				<div class="form-group">
					<label for="exampleFormControlTextarea1">Context</label>
					<textarea class="form-control" id="exampleFormControlTextarea1" name="context" rows="3" readonly><c:out value="${post.context }"/></textarea>
				  </div> 
				

				  <button type="button" id="list" class="btn btn-outline-secondary">List</button>	
				  <button type="button" id="modify" class="btn btn-primary">Modify</button>


			</div>

	</div>
		<!-- /.panel -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Reply
					<button id="addReplyBtn" type="button" class="pull-right btn btn-xs btn-primary">New Reply</button>
				</div>
				<div class="panel-body">
					<ul class="chat">
						<li class="left clearfix" data-rno='12'>
							<div>
								<div class="header">
									<strong class="primary-font">user-00</strong>
									<small class="pull-right text-muted">2021-04-18</small>
								</div>
								<p>Looks Good!</p>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- /.col-lg-12 -->
	<div class="panel-footer">
<%--		<nav aria-label="Page navigation example">--%>
<%--			<ul class="pagination pull-right">--%>
<%--				<li class="page-item"><a class="page-link" href="#">Previous</a></li>--%>
<%--				<li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--				<li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--				<li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--				<li class="page-item"><a class="page-link" href="#">Next</a></li>--%>
<%--			</ul>--%>
<%--		</nav>--%>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Reply</label>
					<input class="form-control" name='reply' value="New Reply"/>
				</div>
				<div class="form-group">
					<label>Replyer</label>
					<input class="form-control" name='replyer' value="New Replyer"/>
				</div>
				<div class="form-group">
					<label>Reply Date</label>
					<input class="form-control" name='replyDate' value=""/>
				</div>
			</div>
			<div class="modal-footer">
				<button id="modalModifyBtn" type="button" class="btn btn-warning">Modify</button>
				<button id="modalRemoveBtn" type="button" class="btn btn-danger">Remove</button>
				<button id="modalAddBtn" type="button" class="btn btn-primary">Add</button>
				<button id="modalCloseBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->

	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<%@ include file="/includes/footer.jsp"%>


<script src="/resources/js/reply.js"></script>

<script>
	$(document).ready(function (){

		var bnoValue = '<c:out value="${post.bno}"/>';
		var replyUL = $(".chat");

		showList(1);

		function showList(page){

			replyService.getList({bno:bnoValue, page:page||1}, function(replyCount, list){

				console.log("reply count : "+ replyCount)
				console.log("page : "+ page)
				console.log("list : "+ list)

				if(page==-1){
					pageNum = Math.ceil(replyCount/10.0)
					showList(pageNum)
					return;
				}

				var str="";

				if(list == null || list.length == 0){
					replyUL.html("");
					return;
				}
				for(var i=0, len = list.length; i<len || 0; i++){
						str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>"
						str += "<div> <div class='header'> <strong class='primary-font'>"+list[i].replyer+"</strong>"
						str += "<small class='pull-right text-muted'>"+replyService.displayTime(list[i].replyDate)+"</small></div>"
						str += "<p>"+list[i].reply+"</p> </div> </li>"
					}

				replyUL.html(str);

				showReplyPage(replyCount, page)
				})
		}

		var modal = $(".modal")
		var modalInputReply = modal.find("input[name='reply']")
		var modalInputReplyer = modal.find("input[name='replyer']")
		var modalInputReplyDate = modal.find("input[name='replyDate']")

		var modalModifyBtn = $("#modalModifyBtn")
		var modalRemoveBtn = $("#modalRemoveBtn")
		var modalAddBtn = $("#modalAddBtn")
		var modalCloseBtn = $("#modalCloseBtn")

		$("#addReplyBtn").on("click", function (e){

			modal.find("input").val("");
			modalInputReplyDate.closest("div").hide();
			modal.find("button[id != modalCloseBtn]").hide();

			modalAddBtn.show();

			$(".modal").modal("show");
		});

		modalAddBtn.on("click", function (e){

			var reply = {reply:modalInputReply.val(), replyer:modalInputReplyer.val(), bno:bnoValue};
			replyService.add(reply, function (result){
				alert(result);

				modal.find("input").val();
				modal.modal("hide");

				showList(-1);
			});
		});

		$(".chat").on("click", "li", function (e){

			var rno = $(this).data("rno");

			replyService.get(rno, function (result){
				modalInputReply.val(result.reply);
				modalInputReplyer.val(result.replyer).attr("readonly", "readonly");
				modalInputReplyDate.val(replyService.displayTime(result.replyDate)).attr("readonly", "readonly")
				modal.data("rno", result.rno)

				modal.find("button[id != 'modalCloseBtn']").hide();
				modalModifyBtn.show();
				modalRemoveBtn.show();

				$(".modal").modal("show");
			})

			// console.log(rno);

			modalModifyBtn.on("click", function (e){

				var reply = {rno:modal.data("rno"), reply: modalInputReply.val()};

				replyService.modify(reply, function (result){

					alert(result)
					modal.modal('hide')
					showList(pageNum);
				})
			})

			modalRemoveBtn.on("click", function (e){
				var rno = modal.data("rno");

				replyService.remove(rno, function (result){

					alert(result)
					modal.modal('hide')
					showList(pageNum);
				})
			})
		})

				// <nav aria-label="Page navigation example">
		<%--			<ul class="pagination pull-right">--%>
		<%--				<li class="page-item"><a class="page-link" href="#">Previous</a></li>--%>
		<%--				<li class="page-item"><a class="page-link" href="#">1</a></li>--%>
		<%--				<li class="page-item"><a class="page-link" href="#">2</a></li>--%>
		<%--				<li class="page-item"><a class="page-link" href="#">3</a></li>--%>
		<%--				<li class="page-item"><a class="page-link" href="#">Next</a></li>--%>
		<%--			</ul>--%>
		<%--		</nav>--%>

		var pageNum = 1;
		var replyPageFooter = $(".panel-footer");

		function showReplyPage(replyCount, pageNum){

			var endNum = Math.ceil(pageNum/10.0) * 10;
			var startNum = endNum-9;

			var prev = startNum != 1;
			var next = false;

			if(endNum * 10 >= replyCount)
				endNum = Math.ceil(replyCount/10.0)

			if(endNum*10 < replyCount)
				next = true;

			var str = "<nav aria-label='Page navigation example'><ul class='pagination pull-right'>"

			if(prev){
				str += "<li class='page-item'><a class='page-link' href='"+(startNum-1)+"'>Previous</a></li>"
			}

			for(var i=startNum; i<= endNum; i++){
				var active = pageNum==i?"active":"";

				str += "<li class='page-item "+active+"'><a class='page-link' href='"+i+"'>"+i+"</a></li>"
			}

			if(next){
				str += "<li class='page-item'><a class='page-link' href='"+(endNum+1)+"'>Next</a></li>"
			}

			str+="</ul></nav>"

			console.log(str);

			replyPageFooter.html(str);
		}

		$(".panel-footer").on("click", "li a", function (e){
			e.preventDefault();

			var targetPageNum = $(this).attr("href")

			pageNum = targetPageNum;

			console.log("page click"+targetPageNum);

			showList(targetPageNum);
		})

	});
</script>
<script>
	var bnoValue = <c:out value="${post.bno}"/>

<%--	 replyService.modify({rno:25, bno:bnoValue, reply:"Modify Reply"},--%>
<%--	 	function(result){--%>
<%--	 		alert("Modified");--%>
<%--	 })--%>

<%--	 replyService.remove(21, function(count){--%>

<%--	 	console.log(count);--%>

<%--	 	if(count === "success"){--%>
<%--	 		alert("REMOVED")--%>
<%--	 	}--%>
<%--	 },function(err){--%>
<%--	 	alert("ERROR")--%>
<%--	 })--%>

<%--	replyService.get(3, function(data){--%>
<%--		console.log(data);--%>
<%--	})--%>
	
<%--	 replyService.getList({bno:bnoValue, page:1}, function(list){--%>
<%--		for(var i=0, len = list.length || 0; i<len; i++){--%>
<%--			console.log(list[i]);--%>
<%--	 	}--%>
<%--	 }) --%>

<%-- 	replyService.add(--%>
<%--		{reply:"JS TEST", replyer:"tester", bno:bnoValue}--%>
<%--		,--%>
<%--		function(result){--%>
<%--			alert("RESULT :" + result)--%>
<%--		}--%>
<%--	) --%>
	
</script>
<script type="text/javascript">
$(document).ready(function(){

    $("#list").on("click", function(){
      self.location="/board/list?pageNum="+<c:out value="${cri.pageNum}"/>+"&amount="+<c:out value="${cri.amount}"/>
    })

	$("#modify").on("click", function(){
      self.location="/board/modify?bno="+<c:out value="${post.bno }"/>+"&pageNum="+<c:out value="${cri.pageNum}"/>+"&amount="+<c:out value="${cri.amount}"/>
    })

	// $("#remove").on("click", function(){
    //   self.location="/board/remove?bno="+<c:out value="${post.bno }"/>
    // })

})
</script>