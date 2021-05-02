<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Ajax</title>
</head>
<body>
	<h1>Upload with Ajax</h1>

	<div class="uploadDiv">
		<input type="file" name='uploadFiles' multiple>
	</div>

	<button id="uploadBtn">Upload</button>

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
		
    <script type="text/javascript">
        $(document).ready(function (){

            $("#uploadBtn").on("click", function (e){
                var formData = new FormData();
                var inputFile =  $("input[name='uploadFiles']");
                var files = inputFile[0].files;

                console.log(files)

                for(var i=0; i<files.length; i++){
                    formData.append("uploadFiles", files[i]);
                }

                $.ajax({
                    url:'/uploadAjaxAction',
                    processData: false,
                    contentType: false,
                    data: formData,
                    method: 'POST',
                    success: function (result){
                        alert("Uploaded");
                    }
                });
            });
        });
    </script>
</body>
</html>