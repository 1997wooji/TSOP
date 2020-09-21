var selectedNode = null;
	
	var selectNode = function(node) {
		node.addClass("selected");
		selectedNode = node;
		$(".btn-for-selected").prop("disabled", false);
	};
	
	var unselectNode = function() {
		if (selectedNode != null) {
			console.log(selectedNode);
			selectedNode.removeClass("selected");
			selectedNode = null;
			$(".btn-for-selected").prop("disabled", true);
		}
	};
	
	var initSelect = function(e) {
		$(".folder, .file").click( function(e) {
			e.stopPropagation();
			if (e.detail != 1) return;
			if (!$(this).hasClass("selected")) {
				unselectNode();
				selectNode($(this));
			}
		});
		
		$("#browser").click( function(e) {
			unselectNode();
		});
	};
	
	var folderMove = function(e) {
		$(".folder").click( function(e) {
			e.stopPropagation();
			if (e.detail >= 2) {
				var folderId = $(this).find("[name=folderId]").val();
				$("#moveFolderForm").find("[name=folderId]").val(folderId);
				$("#btnCD").click();
			}
		});
	};
	
	var folderUp = function(e) {
		$("#btnUpPath").click( function(e) {
			var folderId = $("#pathId").val();
			$("#moveFolderForm").find("[name=folderId]").val(folderId);
			$("[name=job]").val("up");
			$("#btnCD").click();
		});
	};
	
	var newFolder = function(e) {
		$("#btnCreateFolder").click(function(e) {
			var folderId = $("#pathId").val();
			$("#createFolderForm").find("[name=folderId]").val(folderId);
		});
	};
	
	var changeName = function(e) {
		$("#btnChangeName").click(function(e){
			if (selectedNode != null) {
				var type;
				var id;
				var name;
				if (selectedNode.hasClass("folder")) {
					type = "folder";
					id = selectedNode.find("[name=folderId]").val();
					name = selectedNode.find(".folder-name").text();
				} else {
					type = "file";
					id = selectedNode.find("[name=fileId]").val();
					name = selectedNode.find(".file-name").text();
				}
				$("#changeNameForm").find("[name=id]").val(id);
				$("#changeNameForm").find("[name=type]").val(type);
				$("#changeNameForm").find("[name=name]").val(name);
				$("#btnChangeNameToggler").click();
			}
		});
	};
	
	var toggleImportant = function() {
		$(".file").click(function(e) {
			var target = e.target;
			if ($(target).hasClass("btn-file-important")) {
				var id = $(this).find("[name=fileId]").val();
				var important = $(this).find(".file-important").val();
				var targetFile = this;
				$.ajax({
					async: true,
					url: "./importantfile.do",
					data: {
						fileId: id,
						important: important
					},
					type: "POST",
					success: function(data, status) {
						var obj = eval("("+data+")");
						$(targetFile).find(".file-important").val(obj.important);
						if(obj.important == "true") {
							$(targetFile).find(".btn").addClass("btn-important");
						} else {
							$(targetFile).find(".btn").removeClass("btn-important");
						}
					}
				});
			}
		});
	};
	
	var deleteFile = function() {
		$("#btnDelete").click(function(e) {
			if (selectedNode != null) {
				var type;
				var id;
				var folderId;
				if (selectedNode.hasClass("folder")) {
					type = "folder";
					id = selectedNode.find("[name=folderId]").val();
				} else {
					type = "file";
					id = selectedNode.find("[name=fileId]").val();
				}
				folderId = $("#pathId").val();
				var form = $("#deleteFileForm");
				form.find("[name=type]").val(type);
				form.find("[name=id]").val(id);
				form.find("[name=folderId]").val(folderId);
				form.find("[name=submit]").click();
			}
		});
	};
	
	var uploadFail = function() {
		$("#resultPopup").find("[name=title]").text("업로드 실패");
		$("#resultPopup").find("[name=result]").text("업로드는 'mp3', 'ogg', 'wav' 파일만 가능합니다.");
		$("#uploadForm").find("[name=uploadFile]").unbind("change");
		$("#uploadForm").find("[name=uploadFile]").val("");
		$("#resultToggler").click();
		uploading();
	}
	
	var uploadCheck = function(str) {
		str = str.trim();
		if (str.endsWith("mp3", str.length)) {
			return true;
		}
		else if (str.endsWith("ogg", str.length)) {
			return true;
		}
		else if (str.endsWith("wav", str.length)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	var uploading = function(e) {
		$("#uploadForm").find("[name=uploadFile]").change(function(e) {
			var data = $("#uploadForm").find("[name=uploadFile]").val();
			if (uploadCheck(data)) {
				$("#uploadForm").find("[type=submit]").click();
			} else {
				uploadFail();
			}
		});
	}
	
	var uploadFile = function(e) {
		$("#btnUpload").click(function(e) {
			$("#uploadForm").find("[name=uploadFile]").click();
		});
		
		// 동기 업로드
		
		/* 비동기 업로드
		$("#uploadForm").find("[name=uploadFile]").change(function(e) {
			var formData = new FormData($("#uploadForm")[0]);
			$.ajax({
				url: "./upload.do",
				processData: false,
				contentType: false,
				data: formData,
				type: "POST",
				success: function(data, status) {
					$("#resultPopup").find("[name=title]").text("업로드 결과");
					$("#resultPopup").find("[name=result]").text(data);
					$("#resultToggler").click();
				}	
			});
		});
		*/
	}
	var searchFile = function(e){
		
		$("#btnSearchFile").click(function(e){
		      $('#search').attr('action', 'SearchFile.do');
		      $('#search').attr('method', 'get');
		      $('#search').submit();
		});
		
	};
	
	var fileInfo = function(e){
		$('#btnDetail').click(function(e){
			
			$.ajax({
				url : 'FileInfo.do',
				type:'GET',
				data : {
					'fileId' : $('#fileId').val()
				},
				success : function(data) {
					var obj = eval("(" + data + ")");
					$('#b').text(obj.fileName + obj.fileUpload + obj.fileSize + obj.fileImportant+obj.fileImage);
				}
			});
			
		});
		
	};
	var downloadFile = function(e){
	      $('#btnDownload').click(function(e){
	         location.href="download.do";
	         
	      });
	   }
	var initCloud = function() {
		initSelect();
		folderMove();
		folderUp();
		newFolder();
		changeName();
		toggleImportant();
		deleteFile();
		uploadFile();
		uploading();
		downloadFile();
	};
	
	$(document).ready(initCloud);