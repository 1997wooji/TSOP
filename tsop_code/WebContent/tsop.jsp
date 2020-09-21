<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./vendor/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<link rel="stylesheet" href="./tsop/css/tsop-nav.css">

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="./vendor/js/popper.min.js"></script>
<script src="./vendor/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="./navBar.jsp"></c:import>

<form action="./mamberinfo.do" method="post">
<input type="hidden" name="memberId" value="jiwoo">
지우 개인 블로그
<input type="submit" value="jiwooGongju">
</form>

</body>
</html>