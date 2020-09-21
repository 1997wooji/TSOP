<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Amazing HTML5 Audio Player, powered by http://amazingaudioplayer.com</title>

	<link rel="stylesheet" href="./vendor/css/bootstrap.min.css">
	<link rel="stylesheet" href="./vendor/css/font-awesome.min.css">
  
    <!-- Insert to your webpage before the </head> -->
    <script src="audioplayerengine/jquery.js"></script>
    <script src="./vendor/js/popper.min.js"></script>
	<script src="./vendor/js/bootstrap.min.js"></script>
    <script src="audioplayerengine/amazingaudioplayer.js"></script>
    <script src="audioplayerengine/initaudioplayer-1.js"></script>
   
    <!-- End of head section HTML codes -->

<title>Insert title here</title>
</head>
<body>
    <div id="amazingaudioplayer-1" style="display:none;position:relative;width:100%;max-width:420px;height:auto;margin:50px auto 50px;">
        <ul class="amazingaudioplayer-audios" style="display:none;">
            <li data-artist="" data-title="Lone_Wolf" data-album="" data-info="" data-image="" data-duration="134">
                <div id="music" class="amazingaudioplayer-source" data-src="" data-type="audio/mpeg" />
            </li>
        </ul>
        <div class="amazingaudioplayer-engine"><a href="http://amazingaudioplayer.com" title="audio player for website">html5 audio player</a></div>
    </div>  
</body>
</html>