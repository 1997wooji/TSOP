<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	body {
		margin: 0;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Over The Flow</title>
</head>	
<body style="margin:0;overflow:hidden;">
	<iframe id="main" src="chart.do?job=all" style="position:fixed; top:0px; left:0px; bottom:0px; right:0px; width:100%; height:100%; border:none; margin:0; padding:0; overflow:hidden; z-index:999999;"></iframe>
	<div style="display:none;"><iframe id="player" src="NewFile1.jsp" style="border:none;width:100%;display:none;"></iframe></div>
	<input type="hidden" id="playListIndex" value="0">
	   <input type="hidden" id="playListIndex" value="0">
   <ul id="playerlist" style="display:none">

   </ul>
</body>
</html>