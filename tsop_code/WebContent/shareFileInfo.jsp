<!DOCTYPE html>
<html>
<meta charset="UTF-8">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <style>
    	.container-fluid{
    	margin-top:10px;
    	}
    	.glyphicon.glyphicon-music{
    		font-size:50px;
    	}
    	.file_name{
    		font-size:25px;
    	}
    	.line{
    		width:20%;
    		border-color:gray;
    		margin-left:10px;
    	}
    	.bg-danger{
    	background-repeat:no-repeat;
    	background-position:50%;
    	border-radius:50%;
    	width:100px;
    	height:100px;
    	
    	}
    	.text-muted{
    	font-size:25px;
    	
    	}
    	.file_info{
    		font-size:25px;
    		line-height:60px;
    	}
    	.btn.btn-primary btn-sm{
    	color:red;
    	}
    	
    </style>
  </head>
  <body>
    <div class="container-fluid">
    	<div class="col-xs-1 sideav">
    	 <span class="glyphicon glyphicon-music"></span>
    	 </div>
    	 <div class="col-xs-1">
    	 <small class="file_name">ABC Song.mp3</small>
    	 </div>
   		 <div class="col-xs-2">
         	   <button type="button" class="btn btn-default">X</button>
     	  </div>
   		
    	  </div>	
	
     <hr class="line">
    	 
    	
    	  <div class="file_info">
	    	 <div class="col-xs-1">닉네임</div>
	    	 <div class="col-xs-11">woo</div>
    	 </div>
    	  <div class="file_info">
	    	 <div class="col-xs-1">폴더크기</div>
	    	 <div class="col-xs-11">2KB</div>
    	 </div>
    	 <div class="file_info">
	    	 <div class="col-xs-1">공유 날짜</div>
	    	 <div class="col-xs-11">2018.07.14</div>
    	 </div>
        <div class="file_info">
	    	 <div class="col-xs-1">공유 허용</div>
	    	 <div class="col-xs-11">Y</div>
    	 </div> 
    	
  </body>
</html>
