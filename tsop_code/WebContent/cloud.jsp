<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./vendor/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<link rel="stylesheet" href="./tsop/css/tsop-nav.css">
<link rel="stylesheet" href="./tsop/css/tsop-layout.css">
<link rel="stylesheet" href="./tsop/css/tsop-color.css">
<link rel="stylesheet" href="./tsop/css/tsop-button.css">
<link rel="stylesheet" href="./tsop/css/cloud.css">

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="./vendor/js/popper.min.js"></script>
<script src="./vendor/js/bootstrap.min.js"></script>
<script src="./tsop/js/cloud.js"></script>
<script src="./tsop/js/player.js"></script>
<script src="./tsop/js/navSearch.js"></script>
<title>cloud</title>
</head>
<body>
	<!-- 상단 네비게이션 -->
	<c:import url="./navBar.jsp"></c:import>
	<!-- 사이드 메뉴 -->
	<div class="sidemenu shadow-sm">
		<div class="container-fluid">
			<div class="nav-header">
				<h3>
					Cloud
				</h3>	
			</div>
			<div>
				<form>
					<div class="input-group">
						<input type="text" class="form-control" placeholder="파일 찾기..." aria-label="Username" aria-describedby="basic-addon1">
						<div class="input-group-append">
							<button type="submit" class="btn fa fa-search" id="basic-addon1"></button>
						</div>
					</div>
				</form>
			</div>
			<ul class="sidemenu-navbar mb-5">
				<li class="nav-item">
					<a class="nav-link" href="cloud.do"><i class="far fa-hdd"></i>내 드라이브</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="importantfilelist.do"><i class="far fa-star"></i>중요 문서함</a>
				</li>
			</ul>
			<div class="sidemenu-info">
				<div class="nav-item">
					<i class="fa fa-cloud"></i>
					<span>저장용량</span>
				</div>
				<div class="text-right text-small">${requestScope.storageInfo["currentSize"] } / ${requestScope.storageInfo["maxSize"] }</div>
				<div class="progress">
					<div class="progress-bar" style="width:${requestScope.storageInfo.sizePercent}%"></div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 현재 폴더 경로 -->
	<input type="hidden" id="pathId" value="${requestScope.pathId }">
	
	<!-- 파일 브라우저 -->
	<div id="browser" class="main content">
		<div class="container" style="min-width:800px">
			<!-- 상단 메뉴 -->
			<div class="navbar-cloud ml-1 pr-5 pl-5">
				<div class="d-flex align-items-center">
					<button type="button" class="btn"  id="btnUpPath" >
						<i class="fas fa-angle-left"></i>
					</button>
					<button class ="btn" type="button" id="btnCreateFolder" data-toggle="modal" data-target="#popupCreateFolder"><i class="fas fa-folder"></i></button>
					<button class ="btn" type="button" id="btnUpload"><i class="fas fa-upload"></i></button>
					<button class ="btn btn-for-selected btn-disabled" type="button" id="btnDownload" disabled><i class="fas fa-download"></i></button>
					<button class ="btn btn-for-selected btn-disabled ml-auto" type="button" id="btnChangeName" disabled><i class="fas fa-edit"></i></button>
					<button class ="btn btn-for-selected btn-disabled" type="button" id="btnMove"disabled><i class="fas fa-file-export"></i></button>
					<button class ="btn btn-for-selected btn-disabled" type="button" id="btnDelete"disabled><i class="fas fa-trash"></i></button>
					<button class ="btn btn-for-selected btn-disabled" type="button" id="btnDetail"disabled><i class="fas fa-info-circle"></i></button>
				</div>
			</div>
			
			<!-- 폴더 -->
			<div class="cloud-browser" id="">
				<div class="card mt-5">
					<div class="card-header bg-white border-0" id="headingOne">
						<h5 class="mb-0">
							<button class="btn btn-link" type="button" data-toggle="collapse" data-target="#folderTable" aria-expanded="true" aria-controls="collapseOne">
							        폴더
							</button>
						</h5>
					</div>
					
					<div id="folderTable" class="collapse show">
						<div class="card-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">폴더 명</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${requestScope.folders ne null }">
									<c:forEach items="${requestScope.folders }" var="folder" varStatus="folderStatus">
									<tr class="folder">
										<td class="order-${pageScope.folderStatus.index+1 }">${pageScope.folderStatus.index+1 }</td>
										<td class="folder-name">${pageScope.folder.folderName }</td>
										<input type="hidden" name="index" value="${pageScope.status.index}"/>
										<input type="hidden" name="folderId" value="${pageScope.folder.folderId }"/>
									</tr>
									</c:forEach>
									</c:if>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				
				<!-- 파일 -->
				<div class="card mt-5">
					<div class="card-header bg-white border-0" id="headingTwo">
						<h5 class="mb-0">
							<button class="btn btn-link" type="button" data-toggle="collapse" data-target="#fileTable" aria-expanded="true" aria-controls="collapseOne">
							       파일
							</button>
						</h5>
					</div>
					
					<div id="fileTable" class="collapse show">
						<div class="card-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">파일 명</th>
										<th scope="col">파일 업로드 날짜</th>
										<th scope="col">파일 크기</th>
										<th scope="col" class="text-center">중요 파일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.files }" var="file" varStatus="fileStatus">
									<tr class="file">
										<td class="order-${pageScope.fileStatus.index+1 }">${pageScope.fileStatus.index+1 }</td>
										<td class="file-name">${pageScope.file.fileName }</td>
										<td class="file-upload" >${pageScope.file.fileUpload }</td>
										<td class="file-image">${pageScope.file.fileSize }</td>
										<td class="text-center"><button type="button" class="btn btn-file-important fas fa-star <c:if test="${pageScope.file.fileImportant eq true }">btn-important</c:if>" data-toggle="button"></button></td>
										<input type="hidden" class="file-image"value="${pageScope.file.fileImage }">
										<input type="hidden" name="index" value="${pageScope.status.index}"/>
										<input type="hidden" name="fileId" value="${pageScope.file.fileId }"/>
										<input type="hidden" class="file-important" value="${pageScope.file.fileImportant }"/>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			</div>
		</div>
	
	<!-- Modal -->
	<!-- 새 폴더 만들기 -->
	<div class="modal fade" id="popupCreateFolder" tabindex="-1" role="dialog">
	<form action="./createfolder.do" method="POST" id="createFolderForm">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="popupCreateFolderLabel">새 폴더 만들기</h5>
	        <button type="button" class="close" data-dismiss="modal">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
				<input class="w-100"type="text" name="folderName" value="">
				<input type="hidden" name="folderId" value="">
	      </div>
	      <div class="modal-footer">
	      	<button type="submit" class="btn btn-primary">만들기</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	  </form>
	</div>
	
	<!-- 이름 변경하기 -->
	
	<div class="modal fade" id="changeNamePopup" tabindex="-1" role="dialog">
	<form action="./changename.do" method="POST" id="changeNameForm">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="changeNamePopupLabel">이름 변경하기</h5>
	        <button type="button" class="close" data-dismiss="modal">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
				<input type="hidden" name="id" value="">
				<input type="hidden" name="type" value="">
				<input type="text" class="w-100" name="name" value="">
	      </div>
	      <div class="modal-footer">
	      	<button type="submit" class="btn btn-primary">변경하기</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	  </form>
	</div>
	
	<!-- 안내 팝업 -->
	
	<div class="modal fade" id="resultPopup" tabindex="-1" role="dialog">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" name="title"></h5>
	        <button type="button" class="close" data-dismiss="modal">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
				<label name="result"></label>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- hidden -->
	<div style="display:none">
		<!-- 모달 버튼 -->
		<input type="button" id="btnChangeNameToggler" data-toggle="modal" data-target="#changeNamePopup">
		<input type="button" id="resultToggler" data-toggle="modal" data-target="#resultPopup">

		<!-- 폴더 이동 -->
		<form action="./cloud.do" method="GET" id="moveFolderForm">
			<input type="hidden" name="folderId" value="">
			<input type="hidden" name="job" value="">
			<input id="btnCD" type="submit">
		</form>
		
		<!-- 파일 업로드 -->
		<form method="post" action="./upload.do" enctype="multipart/form-data" id="uploadForm">
		<input type="file" name="uploadFile">
		<input type="submit" id="btnUpload" value="업로드">
		</form>
		
		<!-- 파일 삭제 -->
		<form action="./deletefile.do" method="POST" id="deleteFileForm">
			<input type="hidden" name="type" value="">
			<input type="hidden" name="id" value="">
			<input type="hidden" name="folderId" value="">
			<input type="submit" name="submit">
		</form>
	</div>
	<c:import url="./player.jsp"></c:import>
</body>
</html>