<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Ajax</title>
<link href="/resources/css/style.css" rel="stylesheet">
</head>

<body>
	<h1>Upload with Ajax</h1>

	<div class="uploadDiv">
		<input type="file" name='uploadFiles' multiple></p>
        <button id="uploadBtn">Upload</button>
    </div>

    <div class="uploadResult">
        <ul class="uploadResultUL">
        </ul>
    </div>

	<div class="bigPictureWrapper">
		<div class="bigPicture">
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>

	<script type="text/javascript">

        let uploadResult = $(".uploadResult ul");

        function showUploadedFiles(uploadResultArr){
            let str = "";

            $(uploadResultArr).each(function (i, obj){
               if(!obj.image){
				    let fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
				    console.log(fileCallPath);

               		str += "<li><a href='/download?fileName="+fileCallPath+"'><img src='/resources/img/attach.png'/></a>"+obj.fileName+
							"<span data-file=\'"+fileCallPath+"\' data-type='file'>x</span></li>";
			   }
               else {
				   let fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
				   console.log(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);

				   let originalPath = obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName

				   originalPath = originalPath.replace(new RegExp(/\\/g),"/");

				   str += "<li><a href=javascript:showImage(\'"+originalPath+"\')><img src='/display?fileName="+fileCallPath+"'></a>"+
               				"<span data-file=\'"+fileCallPath+"\' data-type='image'>x</span></li></li>";
				   // str += "<li><img src='/display?fileName="+fileCallPath+"'/></li>";
			   }
            });
			uploadResult.append(str);
        }

        function removeFile(){
        	let ul = $(".uploadResultUL");
			let li = ul[0].getElementsByTagName('li');

			console.log(li);

			if(li.length > 0)  {
				li[0].remove();
			}
		}

		$(".uploadResult").on("click", "span", function (e){
			let targetFile = $(this).data("file");
			let targetType = $(this).data("type");

			console.log(targetFile);

			$.ajax({
				url: '/deleteFile',
				data: {'fileName': targetFile, 'fileType': targetType},
				dataType: 'text',
				type: 'POST',
				success: function (result){
					alert(result);
					removeFile();
				}
			});


		})

		$(document).ready(function() {
			let regex = new RegExp("(.*?)\.(png|gif|jpg|JPG|jpeg|pdf|hwp)$");
			let maxSize = 5242880; //5MB

			function checkExtension(fileName, fileSize) {

				console.log("fileName: "+fileName);

				if (fileSize >= maxSize) {
					alert("파일 사이즈 초과")
					return false;
				}
				if (!regex.test(fileName)) {
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false
				}

				return true;
			}

			let cloneObj = $(".uploadDiv").clone();

			function uploadFile(){
				let formData = new FormData();
				let inputFile = $("input[name='uploadFiles']");
				let files = inputFile[0].files;

				console.log("files size: "+files.length);
				if(files.length <= 0){
					alert("업로드 하실 파일을 선택헤주세요.")
					return false;
				}


				for (let i = 0; i < files.length; i++) {
					console.log("file size: "+files[i].size);
					if (!checkExtension(files[i].name, files[i].size)) {
						return false;
					}

					formData.append("uploadFiles", files[i]);
				}

				// $.ajax({
				// 	url : '/uploadAjaxAction',
				// 	processData : false,
				// 	contentType : false,
				// 	data : formData,
				// 	method : 'POST',
				// 	success : function(result) {
				// 		alert("Uploaded");
				// 	}
				//
				// });

				$.ajax({
					url : '/uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					type: 'POST',
					dataType: 'json',
					success : function(result) {
						alert("Uploaded")
						console.log(result);
						showUploadedFiles(result);

						$(".uploadDiv").html(cloneObj.html());
						$(".uploadDiv button").on("click", uploadFile);
					}
				});
			}

			$("#uploadBtn").on("click", function(e) {
				uploadFile();
			});

			$(".bigPictureWrapper").on("click", function (e){
				$(".bigPicture").animate({width: '0%', height: '0%'}, 800);
				setTimeout(function (){
					$(".bigPictureWrapper").hide();
				}, 1000);
			})
		});


        function showImage(fileCallPath){
        	// alert(fileCallPath);

			$(".bigPictureWrapper").css("display", "flex").show();
			$(".bigPicture").html("<img src='/display?fileName="+encodeURI(fileCallPath)+"'/>")
			.animate({width:'100%', height:'100%'}, 800);
		}
	</script>
</body>
</html>