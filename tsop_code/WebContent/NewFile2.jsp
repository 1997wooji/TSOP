<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
	$(document).ready(function (e){
		var ifrm = parent.document.getElementById('NewFile1');
		var win = ifrm.contentWindow;
		var doc = ifrm.contentDocumnet? ifrm.contentDocument : ifrm.contentWindow.document;
		var data = doc.getElementById('music');
		var player = doc.getElementsByTagName('audio').item(0);
		var progress = doc.getElementById('progress');
		var progressbar = doc.getElementById('progressbar');
		var currentTime = 0;
		var duration = 1;
		
		$(player).bind('timeupdate', function(e){
			currentTime = player.currentTime;
			duration = player.duration;
			$(progressbar).css('width', (currentTime/duration)*400);
		});
		
		$(progress).click(function(){
			var time = $(progressbar).css('width');
			alert(time);
			$(player).prop('currentTime', time);
		});
		
		$('button').click(function (e){
			var audioSource = doc.getElementsByTagName('audio').item(0);
			$(audioSource).attr('src','audios/Lone_Wolf.mp3');
		var requestData = "music=audios/Lone_Wolf.mp3";
		$.ajax({ 
			url: './Test',
			method: 'GET', 
			data: requestData,
			async: true,
			contentType: false,
			processData: false,
			success: function(data, status) {
				if(status == 'success') {
				} else {
					alert('실패');
				}
			}
		});
		});
	});
</script>
</head>
<body>
		<div><a href="Test?music=audios/Lone_Wolf.mp3">뮤직1</a><button type="button">버튼</button></div>
		<div><a href="artist.jsp">뮤직2</a></div>
		<div><a href="musicchart.jsp">뮤직3</a></div>
		<div><a>뮤직4</a></div>
		<div id='a'>값</div>
		<progress id="seek" value="0" max="1" style="width:400px"></progress>
		<div id="play">재생</div>
</body>
</html>