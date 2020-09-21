$('[name=deleteBtn]').click(function(e){
	$('[name=mId]').val($('#musicId').val());
	alert($('[name=mId]').val());
	$('#submitForm').attr('action','deletemusic.do');
	$('#submitForm').attr('method','get');
	$('#submitForm').submit();
})

$('[name=updateBtn]').click(function(e){
	$('div[name=updateDiv]').show();
})


$(document).ready(function(e) {
	$(".btn-like").click(function(e) {
		if ($(e.target).hasClass("like-active")){
			$(this).removeClass("like-active");
		} else {
			$(this).addClass("like-active");
		}
	});
});


$('[name=uploadFile]').change(function(e){
	var formData = new FormData($('#fileSubmit')[0]);
	$.ajax({ 
		url:"imageupload.do",
		processData: false,
		contentType: false,
		type: "post",
		data: formData,
		success: function(data,status){
			alert(data);
			var obj = eval('('+ data +')');
			var filePath = obj.filePath;
			alert(filePath);
			$('.updateImg').attr('src', URL.createObjectURL(e.target.files[0]));
			$('#2').val(filePath);
		}
	});
});

$('[name=cancelBtn]').click(function(e){
	$('[name=updateTitle]').val($('[name=musicTitle]').val());
	$('[name=updateTag]').val($('[name=musicTag]').val());
	$('[name=updateGenre]').val($('[name=musicGenre]').val());
	$('[name=updateIntro]').val($('[name=musicIntro]').val());
	$('[name=updateVisibility]').val($('[name=musicVisibility]').val());
	$('[name=updateDownAccept]').val($('[name=musicDownloadAccept]').val());
	$('[name=updateDiv]').hide();
});

$('[name=updateOkBtn]').click(function(e){
	$('[name=updateTitle]').val($('[name=Title]').val());
	$('[name=updateTag]').val($('[name=Tag]').val());
	$('[name=updateGenre]').val($('[name=Genre]').val());
	$('[name=updateIntro]').val($('[name=Intro]').val());
	$('[name=updateVisibility]').val($('radio[name=visibility]:checked').val());
	$('[name=updateDownAccept]').val($('radio[name=downAccept]:checked').val());
	$('#updateForm').attr('action','updatemusic.do');
	$('#updateForm').attr('method','post');
	$('#updateForm').submit();
});

$('#memberNickName').click(function(e){
	$('#musicInfo').attr('action','memberInfo.do');
	$('#musicInfo').attr('method','post');
	$('#musicInfo').submit();
});


$('#likeBtn').click(function(e){

	$.ajax({
		async: true,
		url: "likemusic.do",
		type: 'POST',
		data: {'musicId':$('#musicId').val(), 'isLike': $('[name=isLike]').val()}, 
		success: function(data, txtStatus, xhr){
				var obj = eval('('+data+')');
				if(obj.result == 'true'){
					$('#likeBtn').text('좋아요취소');
					$('[name=isLike]').val(true);
				}else{
					$('#likeBtn').text('좋아요');
					$('[name=isLike]').val(false);
				}
					
		}
	});			
});

$('[name=addMusicPlaylistBtn]').click(function(e){
	
	if($('[name=isAdd]').val() == 'false'){
		$('[name=isAdd]').val('true');
	$.ajax({
		url:"searchmylist.do",
		type: "GET",
		success: function(data, status, xhr){
			var obj = eval( '(' + data + ')' );
			$.each(obj, function(index, value){
				for(var i =0; i<value.length; i++){
					var button = "<button class='listSelectBtn' name='btn'>선택</button>";
					var hidden = "<input type='hidden' name='listId' value='"+value[i].playlistId + "'>";
					var title = "<div class='form' name='form1' onclick='select()'><div name='addPlaylistTitle' style='color: blue'>"+ value[i].playlistTitle +"</div>" + button + hidden +"</div>";
					var ui = '<a class="dropdown-item" href="#">'+value[i].playlistTitle+'</a>';
					$('.test').append(ui);
				}
			})
			
		},
		error: function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	}
});

$('[name=cancelBtn]').click(function(e){
	$('[name=addPlaylistTitle]').remove();
	$('.listSelectBtn').remove();
	$('[name=isAdd]').val('false');
});

function select(){
	$('.form').click(function(e){
		if($(e.target).attr("name") == "btn"){
			$.ajax({
				url: 'addplaylistmusic.do',
				type: "GET",
				data: {'lId': $(this).find("[name=listId]").val(), 'mId': $('#musicId').val()},
				success: function(data, status, xht){
					var obj = eval('('+ data +')');
					if(obj.res == 'true'){
						alert('재생목록에 곡을 추가했습니다.');
					}else{
						alert('재생목록에 곡 추가를 실패했습니다.');
					}
					$('[name=addPlaylistTitle]').remove();
					$('.listSelectBtn').remove();
				}
			});
		}
	});
}