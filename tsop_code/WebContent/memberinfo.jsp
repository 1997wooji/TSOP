<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Bootstrap Theme The Band</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="./vendor/css/navbar.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  body {
      font: 400 15px/1.8 Lato, sans-serif;
      color: #777;
  }
  h3, h4 {
      margin: 10px 0 30px 0;
      letter-spacing: 10px;      
      font-size: 20px;
      color: #111;
  }
  .container {
      padding: 80px 120px;
  }
  .person {
      border: 10px solid transparent;
      margin-bottom: 25px;
      width: 80%;
      height: 80%;
      opacity: 0.7;
  }
  .person:hover {
      border-color: #f1f1f1;
  }
  .carousel-inner img {
      -webkit-filter: grayscale(90%);
      filter: grayscale(90%); /* make all photos black and white */ 
      width: 100%; /* Set width to 100% */
      margin: auto;
  }
  .carousel-caption h3 {
      color: #fff !important;
  }
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
  }
  .bg-1 {
      background: #2d2d30;
      color: #bdbdbd;
  }
  .bg-1 h3 {color: #fff;}
  .bg-1 p {font-style: italic;}
  .list-group-item:first-child {
      border-top-right-radius: 0;
      border-top-left-radius: 0;
  }
  .list-group-item:last-child {
      border-bottom-right-radius: 0;
      border-bottom-left-radius: 0;
  }
  .thumbnail {
      padding: 0 0 15px 0;
      border: none;
      border-radius: 0;
  }
  .thumbnail p {
      margin-top: 15px;
      color: #555;
  }
  .btn {
      padding: 10px 20px;
      background-color: #333;
      color: #f1f1f1;
      border-radius: 0;
      transition: .2s;
  }
  .btn:hover, .btn:focus {
      border: 1px solid #333;
      background-color: #fff;
      color: #000;
  }
  .modal-header, h4, .close {
      background-color: #333;
      color: #fff !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-header, .modal-body {
      padding: 40px 50px;
  }
  .nav-tabs li a {
      color: #777;
  }

  .navbar {
      font-family: Montserrat, sans-serif;
      margin-bottom: 0;
      background-color: #2d2d30;
      border: 0;
      font-size: 11px !important;
      letter-spacing: 4px;
      opacity: 0.9;
  }
  .navbar li a, .navbar .navbar-brand { 
      color: #d5d5d5 !important;
  }
  .navbar-nav li a:hover {
      color: #fff !important;
  }
  .navbar-nav li.active a {
      color: #fff !important;
      background-color: #29292c !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
  }
  .open .dropdown-toggle {
      color: #fff;
      background-color: #555 !important;
  }
  .dropdown-menu li a {
      color: #000 !important;
  }
  .dropdown-menu li a:hover {
      background-color: red !important;
  }
  footer {
      background-color: #2d2d30;
      color: #f5f5f5;
      padding: 32px;
  }
  footer a {
      color: #f5f5f5;
  }
  footer a:hover {
      color: #777;
      text-decoration: none;
  }  
  .form-control {
      border-radius: 0;
  }
  textarea {
      resize: none;
  }
  </style>
  
<style type="text/css">.image__full,.image{text-align:center;position:relative;background-repeat:no-repeat}.image__lightOutline .image__full{box-shadow:rgba(0,0,0,.1)0 0 0 1px inset}.image__whiteOutline .image__full{border:2px solid #fff;box-sizing:border-box;background-origin:border-box}.image.dragover{box-shadow:0 0 15px #06c}.image.interactive{cursor:pointer}.image__rounded{border-radius:50%}.image:focus{outline:0}.image:focus .image__full{border:1px dotted #999;box-sizing:border-box;background-origin:border-box}.image__rounded.m-loaded.sc-artwork{background:0 0}.image__button{position:absolute;bottom:0;left:0;right:0;height:20%}.image.readOnly .image__button{display:none}.image.customImage .image__button{overflow:hidden;opacity:0;transition:opacity .1s linear}.image.alwaysShowEditButton .image__button,.image.customImage:hover .image__button,.image.customImage .image__button:focus{opacity:1}.image__placeholder{position:absolute}.image.m-station::before{position:absolute;content:'';display:block;top:0;bottom:0;right:0;left:0;width:60%;height:60%;}</style>
<!-- 확신 X -->
<style type="text/css">.announcement{padding:15px 30px;background-color:rgba(0,0,0,.9);position:relative;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-justify-content:space-between;-ms-flex-pack:justify;justify-content:space-between;-webkit-align-items:baseline;-ms-flex-align:baseline;align-items:baseline}.announcement.m-dismiss-visible{padding-right:30px}.announcement__dismiss{position:absolute;width:18px;height:18px;cursor:pointer;right:30px;top:50%;margin-top:-9px;background:url() no-repeat 50% 50%;background-size:18px 18px}.announcement>.announcement__message>a{color:#ccc;text-decoration:underline}.announcements__item+.announcements__item .announcement{padding-top:0}.announcements__item+.announcements__item .announcement__dismiss,.announcements__item+.announcements__item .announcement__ack{display:none}@media (max-width:1079px){.announcement{padding-left:20px;padding-right:20px}.announcement.m-dismiss-visible{padding-right:20px}.announcement__dismiss{right:20px}}@media (-webkit-min-device-pixel-ratio:2),(min-resolution:2dppx),(min-resolution:192dpi){.announcement__dismiss{background-image:url(https://a-v2.sndcdn.com/assets/images/close-announcement@2x-65dcea9.png)}}</style>
<style type="text/css">.image__full,.image{text-align:center;position:relative;background-repeat:no-repeat}.image__lightOutline .image__full{box-shadow:rgba(0,0,0,.1)0 0 0 1px inset}.image__whiteOutline .image__full{border:2px solid #fff;box-sizing:border-box;background-origin:border-box}.image.dragover{box-shadow:0 0 15px #06c}.image.interactive{cursor:pointer}.image__rounded{border-radius:50%}.image:focus{outline:0}.image:focus .image__full{border:1px dotted #999;box-sizing:border-box;background-origin:border-box}.image__rounded.m-loaded.sc-artwork{background:0 0}.image__button{position:absolute;bottom:0;left:0;right:0;height:20%}.image.readOnly .image__button{display:none}.image.customImage .image__button{overflow:hidden;opacity:0;transition:opacity .1s linear}.image.alwaysShowEditButton .image__button,.image.customImage:hover .image__button,.image.customImage .image__button:focus{opacity:1}.image__placeholder{position:absolute}.image.m-station::before{position:absolute;content:'';display:block;top:0;bottom:0;right:0;left:0;width:60%;height:60%;background-image:url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iODAiIGhlaWdodD0iODAiIHZpZXdCb3g9IjAgMCA4MCA4MCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayI+PHRpdGxlPkU1QjVFRTU3LTU4RjYtNEYxNy05RjVDLTZGMUEzQjBCRUI1NjwvdGl0bGU+PGRlZnM+PGVsbGlwc2UgaWQ9ImEiIGN4PSI0MCIgY3k9IjQwIiByeD0iNDAiIHJ5PSI0MCIvPjxtYXNrIGlkPSJmIiB4PSIwIiB5PSIwIiB3aWR0aD0iODAiIGhlaWdodD0iODAiIGZpbGw9IiNmZmYiPjx1c2UgeGxpbms6aHJlZj0iI2EiLz48L21hc2s+PHBhdGggZD0iTTU4LjUxMiA1OC41MTJhMjUuNzM0IDI1LjczNCAwIDAgMCA3LjU2LTE4LjI1M2MwLTcuMTMtMi44ODgtMTMuNTgzLTcuNTYtMTguMjU1IiBpZD0iYiIvPjxtYXNrIGlkPSJnIiB4PSIwIiB5PSIwIiB3aWR0aD0iNy41NjEiIGhlaWdodD0iMzYuNTA3IiBmaWxsPSIjZmZmIj48dXNlIHhsaW5rOmhyZWY9IiNiIi8+PC9tYXNrPjxwYXRoIGQ9Ik01Mi4yMDUgNTIuMjA1YTE2Ljg2IDE2Ljg2IDAgMCAwIDQuOTU0LTExLjk2QTE2Ljg2IDE2Ljg2IDAgMCAwIDUyLjIxNyAyOC4zIiBpZD0iYyIvPjxtYXNrIGlkPSJoIiB4PSIwIiB5PSIwIiB3aWR0aD0iNC45NTQiIGhlaWdodD0iMjMuOTA2IiBmaWxsPSIjZmZmIj48dXNlIHhsaW5rOmhyZWY9IiNjIi8+PC9tYXNrPjxwYXRoIGQ9Ik0yOC4yODcgMjguMjg3YTE2Ljg2IDE2Ljg2IDAgMCAwLTQuOTU0IDExLjk2IDE2Ljg2IDE2Ljg2IDAgMCAwIDQuOTY3IDExLjk3IiBpZD0iZCIvPjxtYXNrIGlkPSJpIiB4PSIwIiB5PSIwIiB3aWR0aD0iNC45NjYiIGhlaWdodD0iMjMuOTMxIiBmaWxsPSIjZmZmIj48dXNlIHhsaW5rOmhyZWY9IiNkIi8+PC9tYXNrPjxwYXRoIGQ9Ik0yMi4wMDUgMjIuMDA1YTI1LjczNCAyNS43MzQgMCAwIDAtNy41NiAxOC4yNTRjMCA3LjEyNyAyLjg5IDEzLjU4IDcuNTYgMTguMjUyIiBpZD0iZSIvPjxtYXNrIGlkPSJqIiB4PSIwIiB5PSIwIiB3aWR0aD0iNy41NjEiIGhlaWdodD0iMzYuNTA3IiBmaWxsPSIjZmZmIj48dXNlIHhsaW5rOmhyZWY9IiNlIi8+PC9tYXNrPjwvZGVmcz48ZyBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPjx1c2Ugc3Ryb2tlPSIjRkZGIiBtYXNrPSJ1cmwoI2YpIiBzdHJva2Utd2lkdGg9IjIiIGZpbGwtb3BhY2l0eT0iLjIiIGZpbGw9IiMwMDAiIHhsaW5rOmhyZWY9IiNhIi8+PGVsbGlwc2UgZmlsbD0iI0ZGRiIgY3g9IjQwLjIzMSIgY3k9IjQwLjIzMSIgcng9IjYuMjMxIiByeT0iNi4yMzEiLz48dXNlIHN0cm9rZT0iI0ZGRiIgbWFzaz0idXJsKCNnKSIgc3Ryb2tlLXdpZHRoPSIyIiB4bGluazpocmVmPSIjYiIvPjx1c2Ugc3Ryb2tlPSIjRkZGIiBtYXNrPSJ1cmwoI2gpIiBzdHJva2Utd2lkdGg9IjIiIHhsaW5rOmhyZWY9IiNjIi8+PHVzZSBzdHJva2U9IiNGRkYiIG1hc2s9InVybCgjaSkiIHN0cm9rZS13aWR0aD0iMiIgeGxpbms6aHJlZj0iI2QiLz48dXNlIHN0cm9rZT0iI0ZGRiIgbWFzaz0idXJsKCNqKSIgc3Ryb2tlLXdpZHRoPSIyIiB4bGluazpocmVmPSIjZSIvPjwvZz48L3N2Zz4=);background-size:cover;z-index:3;margin:auto}.image.m-station.m-smallOverlay::before{background-image:url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayI+PGRlZnM+PHBhdGggZD0iTTE2IDMyYzguODM3IDAgMTYtNy4xNjMgMTYtMTZTMjQuODM3IDAgMTYgMCAwIDcuMTYzIDAgMTZzNy4xNjMgMTYgMTYgMTZ6IiBpZD0iYSIvPjxtYXNrIGlkPSJmIiB4PSIwIiB5PSIwIiB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIGZpbGw9IiNmZmYiPjx1c2UgeGxpbms6aHJlZj0iI2EiLz48L21hc2s+PHBhdGggZD0iTTIzLjQwNSAyMy40MDVhMTAuMjkzIDEwLjI5MyAwIDAgMCAzLjAyNC03LjMwMWMwLTIuODUyLTEuMTU1LTUuNDMzLTMuMDI0LTcuMzAyIiBpZD0iYiIvPjxtYXNrIGlkPSJnIiB4PSIwIiB5PSIwIiB3aWR0aD0iMy4wMjQiIGhlaWdodD0iMTQuNjAzIiBmaWxsPSIjZmZmIj48dXNlIHhsaW5rOmhyZWY9IiNiIi8+PC9tYXNrPjxwYXRoIGQ9Ik0yMC44ODIgMjAuODgyYTYuNzQ0IDYuNzQ0IDAgMCAwIDEuOTgyLTQuNzg0IDYuNzQ0IDYuNzQ0IDAgMCAwLTEuOTc3LTQuNzc4IiBpZD0iYyIvPjxtYXNrIGlkPSJoIiB4PSIwIiB5PSIwIiB3aWR0aD0iMS45ODEiIGhlaWdodD0iOS41NjIiIGZpbGw9IiNmZmYiPjx1c2UgeGxpbms6aHJlZj0iI2MiLz48L21hc2s+PHBhdGggZD0iTTExLjMxNSAxMS4zMTVhNi43NDQgNi43NDQgMCAwIDAtMS45ODIgNC43ODNjMCAxLjg3MS43NiAzLjU2NSAxLjk4NyA0Ljc5IiBpZD0iZCIvPjxtYXNrIGlkPSJpIiB4PSIwIiB5PSIwIiB3aWR0aD0iMS45ODciIGhlaWdodD0iOS41NzIiIGZpbGw9IiNmZmYiPjx1c2UgeGxpbms6aHJlZj0iI2QiLz48L21hc2s+PHBhdGggZD0iTTguODAyIDguODAyYTEwLjI5MyAxMC4yOTMgMCAwIDAtMy4wMjQgNy4zMDJjMCAyLjg1IDEuMTU2IDUuNDMyIDMuMDI0IDcuMyIgaWQ9ImUiLz48bWFzayBpZD0iaiIgeD0iMCIgeT0iMCIgd2lkdGg9IjMuMDI0IiBoZWlnaHQ9IjE0LjYwMyIgZmlsbD0iI2ZmZiI+PHVzZSB4bGluazpocmVmPSIjZSIvPjwvbWFzaz48L2RlZnM+PGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj48dXNlIHN0cm9rZT0iI0ZGRiIgbWFzaz0idXJsKCNmKSIgc3Ryb2tlLXdpZHRoPSIyIiBmaWxsLW9wYWNpdHk9Ii4yIiBmaWxsPSIjMDAwIiB4bGluazpocmVmPSIjYSIvPjxlbGxpcHNlIGZpbGw9IiNGRkYiIGN4PSIxNi4wOTMiIGN5PSIxNi4wOTIiIHJ4PSIyLjQ5MyIgcnk9IjIuNDkyIi8+PHVzZSBzdHJva2U9IiNGRkYiIG1hc2s9InVybCgjZykiIHN0cm9rZS13aWR0aD0iMiIgeGxpbms6aHJlZj0iI2IiLz48dXNlIHN0cm9rZT0iI0ZGRiIgbWFzaz0idXJsKCNoKSIgc3Ryb2tlLXdpZHRoPSIyIiB4bGluazpocmVmPSIjYyIvPjx1c2Ugc3Ryb2tlPSIjRkZGIiBtYXNrPSJ1cmwoI2kpIiBzdHJva2Utd2lkdGg9IjIiIHhsaW5rOmhyZWY9IiNkIi8+PHVzZSBzdHJva2U9IiNGRkYiIG1hc2s9InVybCgjaikiIHN0cm9rZS13aWR0aD0iMiIgeGxpbms6aHJlZj0iI2UiLz48L2c+PC9zdmc+Cg==)}</style>
<style type="text/css">.notificationIcon{width:100%;height:100%;position:relative}.selected .notificationIcon,.notificationIcon:hover,.notificationIcon:focus,.notificationIcon.newItems__some{outline:0}.notificationIcon:before{content:'';position:absolute;width:100%;height:100%;left:0;top:0;opacity:.75}.selected .notificationIcon:before,a:focus .notificationIcon:before,.notificationIcon:hover:before,.notificationIcon:focus:before{opacity:1}.notificationIcon.messages:before{background:url(}.notificationIcon.activities:before{background:url()}.notificationIcon__badge{z-index:1;position:absolute;width:7px;height:7px;top:12px;right:11px}.notificationIcon.activities .notificationIcon__badge{right:15px}</style>
<style type="text/css">.searchMenu .loading{background-color:#333;padding:5px 0}.searchMenu__item{padding:0}.searchMenu__searchFor{padding:0;background-color:#333;border-bottom:1px solid rgba(0,0,0,.22);border-left:1px solid #404040;border-right:1px solid #404040;text-align:left;box-shadow:0 1px 0 rgba(255,255,255,.05)}.searchMenu__searchFor.g-dark-selected{background-color:#262626}.searchMenu__searchFor a{display:block;padding:10px 10px 10px 14px}</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<c:import url="navBar.jsp" />

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="ny.jpg" alt="New York" width="1200" height="700">
        <div class="carousel-caption">
          <h3>New York</h3>
          <p>The atmosphere in New York is lorem ipsum.</p>
        </div>      
      </div>

      <div class="item">
        <img src="chicago.jpg" alt="Chicago" width="1200" height="700">
        <div class="carousel-caption">
          <h3>Chicago</h3>
          <p>Thank you, Chicago - A night we won't forget.</p>
        </div>      
      </div>
    
      <div class="item">
        <img src="la.jpg" alt="Los Angeles" width="1200" height="700">
        <div class="carousel-caption">
          <h3>LA</h3>
          <p>Even though the traffic was a mess, we had the best time playing at Venice Beach!</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<!-- 헤더 -->
<div id="tour" class="bg-1">
  <div class="container">
    <div class="l-user-hero">

<div class="profileHeader"><div class="profileHeader__info">
  <div class="profileHeaderInfo sc-media"><div class="profileHeaderInfo__avatar sc-media-image">
  <div class="image m-user image__noOutline readOnly customImage interactive sc-artwork sc-artwork-placeholder-5 image__rounded m-loaded" tabindex="0" style="height: 200px; width: 200px;">
<%--   <span style="background-image: url들어감; width: 200px; height: 200px; opacity: 1;" class="sc-artwork sc-artwork-placeholder-5 image__rounded image__full g-opacity-transition" aria-label="Layout’s avatar" aria-role="img"></span> --%>
	<span ><img style="width: 200px; height: 200px; opacity: 1;" class="sc-artwork sc-artwork-placeholder-5 image__rounded image__full g-opacity-transition" aria-label="Layout’s avatar" aria-role="img" src="./img/DSC00778.JPG"></span>
  <div class="image__button">
    <div class="imageChooser"><button type="button" class="imageChooser__chooseButton sc-button sc-button-translucent sc-button-camera sc-button-medium">Update image</button>
<input class="imageChooser__fileInput sc-visuallyhidden" type="file" accept="image/jpeg,image/pjpeg,image/gif,image/png">
</div>
  </div>
</div>
</div>
<div class="profileHeaderInfo__content sc-media-content">
  <h3 class="profileHeaderInfo__userName g-type-shrinkwrap-block g-type-shrinkwrap-large-primary">
    Jiwoo Kim<span class="profileHeaderInfo__premiumIndicator"><a class="premiumIconLink" href="/pro?ref=t071" title="Yearly Pro plan user"><span class="sc-status-icon sc-status-icon-creator sc-status-icon-medium sc-ir">Grade Icon</span></a></span>
  </h3>
    <br><h4 class="profileHeaderInfo__additional g-type-shrinkwrap-block g-type-shrinkwrap-large-secondary">hello i'm jiwoo!</h4>
</div>
</div>
</div>

<div class="profileHeaderBackground m-visualLoaded">  <div class="profileHeaderBackground__visual" style="background-image: url(https://i1.sndcdn.com/visuals-000008796197-NdsPQn-t1240x260.jpg);"></div>
</div>
<div class="featuredProfiles g-dark"></div>
</div></div>

  </div>
  
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Tickets</h4>
        </div>
        <div class="modal-body">
          <form role="form">
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-shopping-cart"></span> Tickets, $23 per person</label>
              <input type="number" class="form-control" id="psw" placeholder="How many?">
            </div>
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Send To</label>
              <input type="text" class="form-control" id="usrname" placeholder="Enter email">
            </div>
              <button type="submit" class="btn btn-block">Pay 
                <span class="glyphicon glyphicon-ok"></span>
              </button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button>
          <p>Need <a href="#">help?</a></p>
        </div>
      </div>
    </div>
  </div>
</div>

  <div class="userInfoBar__buttons">
  <div class="sc-button-group">  <a type="button" class="sc-button-startstation sc-button sc-button-medium sc-button-responsive" tabindex="0" href="/stations/artist/distinctlayout" rel="nofollow" title="Go to station">Station</a>
  <button type="button" class="sc-button-follow sc-button sc-button-medium sc-button-responsive sc-button-cta" tabindex="0" title="Follow">Follow</button>
  <button type="button" class="sc-button-share sc-button sc-button-medium sc-button-responsive" aria-describedby="tooltip-98" tabindex="0" aria-haspopup="true" role="button" aria-owns="dropdown-button-99" title="Share">Share</button>
  <a href="" class="sc-button sc-button-medium sc-button-icon sc-button-responsive sc-button-message" tabindex="0" title="Send a message">Message</a>
  <button type="button" class="sc-button-more sc-button sc-button-medium sc-button-icon sc-button-responsive" tabindex="0" aria-haspopup="true" role="button" aria-owns="dropdown-button-102" title="More">More</button>
</div>
</div> 

<!-- Container (Contact Section) -->
<div id="contact" class="container">
  <h3 class="text-center">Contact</h3>
  <p class="text-center"><em>We love our fans!</em></p>
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">All</a></li>
    <li><a data-toggle="tab" href="">Tracks</a></li>
    <li><a data-toggle="tab" href="">Playlists</a></li>
    <li><a data-toggle="tab" href="">Artists</a></li>
    <li><a data-toggle="tab" href="">Likes</a></li>
    <li><a data-toggle="tab" href="">Follows</a></li>
    <li><a data-toggle="tab" href="">Followers</a></li>
  </ul>
</div>


<!-- Container (The Band Section) -->
<div id="band" class="container text-center">
  <h3>THE BAND</h3>
  <p><em>We love music!</em></p>
  <p>content</p>
  <br>
 <div class="1-main">
<div class="search">
<div class="searchList lazyLoadingList">
<ul class="lazyLoadingList__list sc-list-nostyle sc-clearfix">
<li class="searchList__item"><div class="searchItem"><div role="group" class="sound searchItem__trackItem playlist streamContext" aria-label="Playlist: jiwoo by 최지우">
<div class="sound__body">
    <div class="sound__artwork">
      <a class="sound__coverArt" href="/hrpnjgwqpxdm/sets/jiwoo" draggable="true">
        <div class="image m-playlist image__lightOutline readOnly sc-artwork sc-artwork-placeholder-3 m-loaded" style="height: 100%; width: 100%;"><span style="width: 100%; height: 100%; opacity: 1; background-image: url(&quot;https://i1.sndcdn.com/artworks-000169847717-pi530r-t200x200.jpg&quot;);" class="sc-artwork sc-artwork-placeholder-3  image__full g-opacity-transition" aria-label="jiwoo" aria-role="img"></span>

</div>
      </a>
    </div>

  <div class="sound__content">
      <div class="sound__header">
          <div class="soundTitle sc-clearfix sc-hyphenate sc-type-h2 streamContext"><div class="soundTitle__titleContainer">
    <div class="soundTitle__playButton  ">
        <a aria-role="button" href="" class="sc-button-play playButton sc-button sc-button-xlarge" tabindex="0" title="Play" draggable="true">Play</a>
    </div>

  <div class="soundTitle__usernameTitleContainer">
      <div class="sc-type-light soundTitle__secondary ">
        <a href="/hrpnjgwqpxdm" class="soundTitle__username
              sc-link-light
            ">
          <span class="soundTitle__usernameText">username</span>
        </a>
              </div>
        <a class="soundTitle__title sc-link-dark" href="sets link">
            <span class="">playlistName</span>
        </a>
        <span class="releaseDataCompact sc-type-light sc-font-light"></span>
  </div>
  <div class="soundTitle__additionalContainer">
      <div class="soundTitle__uploadTime">
        <time class="relativeTime" title="Posted on 4 August 2016" datetime="2016-08-04T00:45:03.000Z"><span class="sc-visuallyhidden">Posted 1 year ago</span><span aria-hidden="true">1 year</span></time>
      </div>
  </div>
</div>
</div>
      </div>

    <div class="sound__waveform">
        <div class="waveformWrapper"><div class="waveformWrapper__waveform"><div class="waveform loaded"><div class="waveform__layer waveform__scene"><canvas aria-hidden="true" class="g-box-full sceneLayer" width="505" height="60"></canvas><canvas aria-hidden="true" class="g-box-full sceneLayer" width="505" height="60"></canvas></div>
</div></div>
  <div class="waveformWrapper__empty sc-type-small">This playlist has no tracks yet</div>
</div>
    </div>


      <div class="sound__footer g-all-transitions-300">
          <div class="sound__trackList">
            <div class="compactTrackList sc-border-light sc-font-body"><div class="compactTrackList__listWrapper">
  <div class="compactTrackList__listContainer"><ul class="compactTrackList__list sc-list-nostyle sc-clearfix"><li class="compactTrackList__item"><div class="compactTrackListItem sc-media sc-border-light-bottom clickToPlay" tabindex="0"><div class="compactTrackListItem__image">
  <span style="background-image:url(https://i1.sndcdn.com/artworks-000169847717-pi530r-tiny.jpg);width:20px;height:20px;" class="sc-artwork sc-artwork-placeholder-5  " aria-label="1.Proove" aria-role="img"></span>
</div>
  <span class="compactTrackListItem__number">1</span>
<div class="compactTrackListItem__content sc-truncate">
    <span class="compactTrackListItem__user">Nino Brown - </span>
  <span class="compactTrackListItem__trackTitle">
    1.Proove
  </span>
</div>
<div class="compactTrackListItem__additional g-flex-row-centered">
      <span class="compactTrackListItem__tierIndicator g-go-plus-marker-list sc-hidden"></span>
      <span class="compactTrackListItem__plays sc-ministats sc-ministats-small sc-ministats-plays">
        788
      </span>
</div>
</div></li><li class="compactTrackList__item"><div class="compactTrackListItem sc-media sc-border-light-bottom clickToPlay" tabindex="0"><div class="compactTrackListItem__image">
  <span style="background-image:url(https://i1.sndcdn.com/artworks-000169847714-s9n0gk-tiny.jpg);width:20px;height:20px;" class="sc-artwork sc-artwork-placeholder-1  " aria-label="2.Hot Shit" aria-role="img"></span>
</div>
  <span class="compactTrackListItem__number">2</span>
<div class="compactTrackListItem__content sc-truncate">
    <span class="compactTrackListItem__user">Nino Brown - </span>
  <span class="compactTrackListItem__trackTitle">
    2.Hot Shit
  </span>
</div>
<div class="compactTrackListItem__additional g-flex-row-centered">
      <span class="compactTrackListItem__tierIndicator g-go-plus-marker-list sc-hidden"></span>
      <span class="compactTrackListItem__plays sc-ministats sc-ministats-small sc-ministats-plays">
        609
      </span>
</div>
</div></li><li class="compactTrackList__item"><div class="compactTrackListItem sc-media sc-border-light-bottom clickToPlay" tabindex="0"><div class="compactTrackListItem__image">
  <span style="background-image:url(https://i1.sndcdn.com/artworks-000169847709-w137bl-tiny.jpg);width:20px;height:20px;" class="sc-artwork sc-artwork-placeholder-11  " aria-label="3.Always" aria-role="img"></span>
</div>
  <span class="compactTrackListItem__number">3</span>
<div class="compactTrackListItem__content sc-truncate">
    <span class="compactTrackListItem__user">Nino Brown - </span>
  <span class="compactTrackListItem__trackTitle">
    3.Always
  </span>
</div>
<div class="compactTrackListItem__additional g-flex-row-centered">
      <span class="compactTrackListItem__tierIndicator g-go-plus-marker-list sc-hidden"></span>
      <span class="compactTrackListItem__plays sc-ministats sc-ministats-small sc-ministats-plays">
        382
      </span>
</div>
</div></li><li class="compactTrackList__item"><div class="compactTrackListItem sc-media sc-border-light-bottom clickToPlay" tabindex="0"><div class="compactTrackListItem__image">
  <span style="background-image:url(https://i1.sndcdn.com/artworks-000169847704-ig0l81-tiny.jpg);width:20px;height:20px;" class="sc-artwork sc-artwork-placeholder-3  " aria-label="4.Pick Me" aria-role="img"></span>
</div>
  <span class="compactTrackListItem__number">4</span>
<div class="compactTrackListItem__content sc-truncate">
    <span class="compactTrackListItem__user">Nino Brown - </span>
  <span class="compactTrackListItem__trackTitle">
    4.Pick Me
  </span>
</div>
<div class="compactTrackListItem__additional g-flex-row-centered">
      <span class="compactTrackListItem__tierIndicator g-go-plus-marker-list sc-hidden"></span>
      <span class="compactTrackListItem__plays sc-ministats sc-ministats-small sc-ministats-plays">
        684
      </span>
</div>
</div></li><li class="compactTrackList__item"><div class="compactTrackListItem sc-media sc-border-light-bottom clickToPlay" tabindex="0"><div class="compactTrackListItem__image">
  <span style="background-image:url(https://i1.sndcdn.com/artworks-000169847703-qb8gp5-tiny.jpg);width:20px;height:20px;" class="sc-artwork sc-artwork-placeholder-1  " aria-label="5.Two Gold" aria-role="img"></span>
</div>
  <span class="compactTrackListItem__number">5</span>
<div class="compactTrackListItem__content sc-truncate">
    <span class="compactTrackListItem__user">Nino Brown - </span>
  <span class="compactTrackListItem__trackTitle">
    5.Two Gold
  </span>
</div>
<div class="compactTrackListItem__additional g-flex-row-centered">
      <span class="compactTrackListItem__tierIndicator g-go-plus-marker-list sc-hidden"></span>
      <span class="compactTrackListItem__plays sc-ministats sc-ministats-small sc-ministats-plays">
        449
      </span>
</div>
</div></li></ul></div>
</div>
  <a href="" class="compactTrackList__moreLink sc-link-light sc-border-light">
  View 47 tracks
  </a>
</div>
          </div>
          <div class="sound__soundActions">
            <div class="soundActions sc-button-toolbar soundActions__small">  <div class="sc-button-group sc-button-group-small">
      <button type="button" class="sc-button-like sc-button sc-button-small sc-button-responsive" aria-describedby="tooltip-30036" tabindex="0" title="Like">Like</button>
      <button type="button" class="sc-button-repost sc-button sc-button-small sc-button-responsive" aria-describedby="tooltip-30038" tabindex="0" aria-haspopup="true" role="button" aria-owns="dropdown-button-30039" title="Repost">Repost</button>
      <button type="button" class="sc-button-share sc-button sc-button-small sc-button-responsive" aria-describedby="tooltip-30041" tabindex="0" aria-haspopup="true" role="button" aria-owns="dropdown-button-30042" title="Share">Share</button>
      <button type="button" class="sc-button-queue addToNextUp sc-button sc-button-small sc-button-responsive" aria-describedby="tooltip-30044" tabindex="0" title="Add to Next up"><span class="sc-button-alt-labels"><span class="sc-button-label-default">Add to Next up</span><span class="sc-button-label-hover">Add to Next up</span><span class="sc-button-label-alt">Add to Next up</span><span class="sc-button-label-alt">Added</span></span></button>
  </div>


</div>
          </div>
          <div class="sound__footerRight">
            <div class="sound__soundStats">
              <ul class="soundStats sc-ministats-group" aria-label="Playlist stats">

</ul>
            </div>
          </div>
      </div>
  </div>
</ul>
</div>
</div>
</div>
</div>

<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>

</body>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="./vendor/js/jquery-slim.min.js"></script>
<script src="./vendor/js/popper.min.js"></script>
<script src="./vendor/js/bootstrap.min.js"></script>
</html>
