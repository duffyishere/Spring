<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Ajax</title>
<style type="text/css">
	.uploadResult{
		width: 100%;
		background-color: gray;
	}

	.uploadResult ul{
		display: flex;
		flex-flow: row;
		justify-content: center;
		align-items: center;
	}

	.uploadResult ul li{
		list-style: none;
		padding: 10px;
	}

	.uploadResult ul li img{
		width: 20px;
	}
</style>
</head>

<body>
	<h1>Upload with Ajax</h1>

	<div class="uploadDiv">
		<input type="file" name='uploadFiles' multiple></p>
        <button id="uploadBtn">Upload</button>
    </div>
    <div class="uploadResult">
        <ul>

        </ul>
    </div>

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>

	<script type="text/javascript">

        let uploadResult = $(".uploadResult");

        function showUploadedFiles(uploadResultArr){
            let str = "";

            $(uploadResultArr).each(function (i, obj){
               if(!obj.image){
               		str += "<li><img src='/resources/img/attach.png'/>"+obj.fileName+"</li>"
			   }
               else {
				   str += "<li>"+obj.fileName+"</li>";
			   }
            });
            uploadResult.append(str);
        }

		$(document).ready(function() {
			let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			let maxSize = 5242880; //5MB

			function checkExtension(fileName, fileSize) {

				if (fileSize >= maxSize) {
					alert("파일 사이즈 초과")
					return false;
				}
				if (regex.test(fileName)) {
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false
				}

				return true;
			}

			let cloneObj = $(".uploadDiv");

			$("#uploadBtn").on("click", function(e) {
				let formData = new FormData();
				let inputFile = $("input[name='uploadFiles']");
				let files = inputFile[0].files;

				console.log(files)

				for (let i = 0; i < files.length; i++) {
					console.log(files[i].size);
					if (!checkExtension(files[i].name, files[i].size)) {
						return false;
					}

					formData.append("uploadFiles", files[i]);
				}

				$.ajax({
					url : '\\uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					method : 'POST',
					success : function(result) {
						alert("Uploaded");
					}

				});

                $.ajax({
                    url : '\\uploadAjaxAction',
                    processData : false,
                    contentType : false,
                    data : formData,
                    type: 'POST',
                    dataType: 'json',
                    success : function(result) {
                        console.log(result);
                        showUploadedFiles(result);

                        $(".uploadDiv").html(cloneObj.html());
                    }
                });

			});

		});
	</script>
</body>
</html>