	var ifrm = parent.document.getElementById('player');
	var doc = ifrm.contentDocument; 
	var player = doc.getElementsByTagName('audio').item(0);
	var progress = document.getElementById('progressbar');
	var amazingPlay = doc.getElementsByClassName('amazingaudioplayer-play').item(0);
	var amazingPause = doc.getElementsByClassName('amazingaudioplayer-pause').item(0);
	var amazingNext = doc.getElementsByClassName('amazingaudioplayer-next').item(0);
	var amazingPrev = doc.getElementsByClassName('amazingaudioplayer-prev').item(0);
	var index = parent.document.getElementById('playListIndex');
	var playListIndex = $(index).attr('value');
	var playListItem = $('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex);
	var maxIndex = $('#playlistDropDown .dropdown-item').length;
	var loopCheck = 0;
	var playerlist = parent.document.getElementById('playerlist');

	function dynamicEvnet() {
		$('#playlistDropDown .dropdown-menu .dropdown-item').click(function(e){
			playListIndex = $(this).index();
			$(index).attr('value', $(this).index());
			var mem = $(this).find('[name=memberName]').val();
			var title = $(this).find('[name=title]').val();
			var id = $(this).find('#mId').val();
			if($(e.target).attr('name') == 'playMusic'){
				$('#playingMusic').val($(this).find("[name=mId]").val());
				$('#playingMem').val($(this).find("[name=memId]").val());
				$('#musicCover').attr('src', $(this).find("[name=playMusic]").attr('src'));
				$('#memName').text(mem);
				$('#musicTitle').text(title);
				$.ajax({
					url : 'playmusic.do',
					type:'POST',
					data : {
						'musicId' : $(this).find("[name=mId]").val()
							},
					success : function(data) {
						var obj = eval("(" + data + ")");
						$(player).attr('src', obj.musicFilePath);
						$('#play').css('display', 'none');
						$('#pause').css('display', 'inline-block');
						$(amazingPlay).trigger('click');
					}
				});
			}
		});
	}
	
$(document).ready(function(e){	
	
	player.addEventListener("ended", function(){
		index.setAttribute('value', ++playListIndex);
		playListItem = $('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex);
		$('#memName').text($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=memberName]').val());
		$('#musicTitle').text($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=title]').val());
		$('#musicCover').attr('src', $('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=playMusic]').attr('src'));
		$('#playingMem').val($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=memId]').val());
		$('#playingMusic').val($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=mId]').val());
		
		$.ajax({
			url : 'playmusic.do',
			type:'POST',
			data : {
				'musicId' : $(playListItem).find("[name=mId]").val()
					},
			success : function(data) {
				var obj = eval("(" + data + ")");
				$(player).attr('src', obj.musicFilePath);
				$('#play').css('display', 'none');
				$('#pause').css('display', 'inline-block');
				$(amazingPlay).trigger('click');
			}
		});
	});
	
	for(var i =0 ; i < $(playerlist).find('li').length; i++){
		$('#playlistDropDown .dropdown-menu').append('<div class="dropdown-item"></div>');
		$('#playlistDropDown .dropdown-item:last-child').append('<img name="playMusic" src="' + $(playerlist).find('li').eq(i).find('[name=playMusic]').val() +'" style="width:50px;height50px;">');
		$('#playlistDropDown .dropdown-item:last-child').append('<span name="musicTitle">'+ $(playerlist).find('li').eq(i).find('[name=musicTitle]').val() +'</span>');
		$('#playlistDropDown .dropdown-item:last-child').append('<input type="hidden" name="memberName" value="' +  $(playerlist).find('li').eq(i).find('[name=memberName]').val()+ '">');
		$('#playlistDropDown .dropdown-item:last-child').append('<input type="hidden" name="title" value="' +  $(playerlist).find('li').eq(i).find('[name=musicTitle]').val() + '">');
		$('#playlistDropDown .dropdown-item:last-child').append('<input type="hidden" name="mId" value="' +  $(playerlist).find('li').eq(i).find('[name=mId]').val() + '">');
		$('#playlistDropDown .dropdown-item:last-child').append('<input type="hidden" name="memId" value="' +  $(playerlist).find('li').eq(i).find('[name=memberId]').val() + '">');
	}
	
	$('#memName').text($(playerlist).find('li').eq(playListIndex).find('[name=memberName]').val());
	$('#musicTitle').text($(playerlist).find('li').eq(playListIndex).find('[name=musicTitle]').val());
	$('#musicCover').attr('src', $(playerlist).find('li').eq(playListIndex).find('[name=playMusic]').val());
	$('#playingMem').val($(playerlist).find('li').eq(playListIndex).find('[name=memId]').val());
	$('#playingMusic').val($(playerlist).find('li').eq(playListIndex).find('[name=mId]').val());
	$('#playingTime').text('0:00');
	$('#endTime').text('0:00');
	
	$('#playlistDropDown .dropdown-menu .dropdown-item').on('click', dynamicEvnet);
	
	$('.music').click(function(e){
		var musicId = $(this).find("[name=musicId]").val();
		if($(e.target).hasClass("btn-play-music")){
		$.ajax({
			url : 'playmusic.do',
			type:'POST',
			data : { 'musicId' : musicId },
			success : function(data) {
				var obj = eval("(" + data + ")");
				var musicBean = obj.musicBean;
				var musicSrc = obj.musicFilePath;
				var imagePath = obj.imagePath;
				var memberId = musicBean.memberId;
				var memberNickName = musicBean.memberNickName;
				var musicId = musicBean.musicId;
				var musicTitle = musicBean.musicTitle;
				$('#playlistDropDown .dropdown-menu').append('<div class="dropdown-item"></div>');
				$('#playlistDropDown .dropdown-item:last-child').append('<img name="playMusic" src="' + imagePath +'" style="width:50px;height50px;">');
				$('#playlistDropDown .dropdown-item:last-child').append('<span name="musicTitle">');
				$('#playlistDropDown .dropdown-item:last-child span').text(musicTitle);
				$('#playlistDropDown .dropdown-item:last-child').append('<input type="hidden" name="memberName" value="' + memberNickName+ '">');
				$('#playlistDropDown .dropdown-item:last-child').append('<input type="hidden" name="title" value="' + musicTitle + '">');
				$('#playlistDropDown .dropdown-item:last-child').append('<input type="hidden" name="mId" value="' + musicId + '">');
				$('#playlistDropDown .dropdown-item:last-child').append('<input type="hidden" name="memId" value="' + memberId + '">');
				$(playerlist).append('<li></li>');
				$(playerlist).find('li:last-child').append('<input type="hidden" value="' + imagePath + '"name="playMusic">');
				$(playerlist).find('li:last-child').append('<input type="hidden" value="' + musicTitle + '"name="musicTitle">');
				$(playerlist).find('li:last-child').append('<input type="hidden" value="' + memberNickName + '"name="memberName">');
				$(playerlist).find('li:last-child').append('<input type="hidden" value="' + musicTitle + '"name="title">');
				$(playerlist).find('li:last-child').append('<input type="hidden" value="' + musicId + '" name="mId">');
				$(playerlist).find('li:last-child').append('<input type="hidden" value="' + memberId + '"name="memId">');
				$('#playlistDropDown .dropdown-menu .dropdown-item').on('click', dynamicEvnet);
				playListItem = $(playerlist).find('li:last-child').index();
				$('#memName').text( $(playerlist).find('li:last-child').find('[name=memberName]').val());
				$('#musicTitle').text( $(playerlist).find('li:last-child').find('[name=title]').val());
				$('#musicCover').attr('src', $(playerlist).find('li:last-child').find('[name=playMusic]').val());
				$('#playingMem').val( $(playerlist).find('li:last-child').find('[name=memId]').val());
				$('#playingMusic').val( $(playerlist).find('li:last-child').find('[name=mId]').val());
				$(player).attr('src', obj.musicFilePath);
				$('#play').css('display', 'none');
				$('#pause').css('display', 'inline-block');
				$(amazingPlay).trigger('click');
				}
				
			});
		}
	});
	
	if(player.currentTime != 0){
		currentTime = player.currentTime.toFixed(0);
		duration = player.duration.toFixed(0);
		
		var currentMin = Math.floor((currentTime/60).toFixed(2));
		var currentSec = Math.floor((currentTime%60).toFixed(2));
		
		var duMin = Math.floor((duration/60).toFixed(2));
		var duSec = Math.floor((duration%60).toFixed(2));
		
		$('#volume').val(player.volume.toFixed(1)*$('#volume').width());
		$('#progressbar > .progress-bar').width((player.currentTime/player.duration)*$('#progressbar').width());
		
		if(currentSec < 10){
			$('#playingTime').text(currentMin + ":0" + currentSec);
		} else {
			$('#playingTime').text(currentMin + ":" + currentSec);
		}
		
		if(duSec < 10){
			$('#endTime').text(duMin + ":0" + duSec);
		} else {
			$('#endTime').text(duMin + ":" + duSec);
		}
	}
		
	if($(amazingPlay).css('display') == 'none'){
		$('#play').css('display', 'none');
		$('#pause').css('display', 'inline-block');
	}
	
	$(player).bind('timeupdate', function(e){
		currentTime = player.currentTime.toFixed(0);
		duration = player.duration.toFixed(0);
		
		var currentMin = Math.floor((currentTime/60).toFixed(2));
		var currentSec = Math.floor((currentTime%60).toFixed(2));
		
		var duMin = Math.floor((duration/60).toFixed(2));
		var duSec = Math.floor((duration%60).toFixed(2));
		
		if(player.networkState == 1){
			if(currentSec < 10){
				$('#playingTime').text(currentMin + ":0" + currentSec);
			} else {
				$('#playingTime').text(currentMin + ":" + currentSec);
			}
			
			if(duSec < 10){
				$('#endTime').text(duMin + ":0" + duSec);
			} else {
				$('#endTime').text(duMin + ":" + duSec);
			}
		}
		$('#progressbar > .progress-bar').width((player.currentTime/player.duration)*$('#progressbar').width());
	});
	
	$('#volume').click(function(e){
		var volume = e.offsetX/this.offsetWidth;
		player.volume = volume.toFixed(1);
	});
	
	$('#play').click(function(){
		$('#play').css('display', 'none');
		$('#pause').css('display', 'inline-block');
		$(amazingPlay).trigger('click');
	}); 
	
	$('#pause').click(function(){
		$('#pause').css('display', 'none');
		$('#play').css('display', 'inline-block');
		$(amazingPause).trigger('click');
	});
	
	$('#next').click(function(){
		index.setAttribute('value', ++playListIndex);
		playListItem = $('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex);
		$('#memName').text($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=memberName]').val());
		$('#musicTitle').text($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=title]').val());
		$('#musicCover').attr('src', $('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=playMusic]').attr('src'));
		$('#playingMem').val($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=memId]').val());
		$('#playingMusic').val($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=mId]').val());
		$.ajax({
			url : 'playmusic.do',
			type:'POST',
			data : {
				'musicId' : $(playListItem).find("[name=mId]").val()
					},
			success : function(data) {
				var obj = eval("(" + data + ")");
				$(player).attr('src', obj.musicFilePath);
				$('#play').css('display', 'none');
				$('#pause').css('display', 'inline-block');
				$(amazingPlay).trigger('click');
			}
		});
	});
	
	$('#prev').click(function(){
		index.setAttribute('value', --playListIndex);
		playListItem = $('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex);
		$('#memName').text($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=memberName]').val());
		$('#musicTitle').text($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=title]').val());
		$('#musicCover').attr('src', $('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=playMusic]').attr('src'));
		$('#playingMem').val($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=memId]').val());
		$('#playingMusic').val($('#playlistDropDown .dropdown-menu .dropdown-item').eq(playListIndex).find('[name=mId]').val());
		$.ajax({
			url : 'playmusic.do',
			type:'POST',
			data : {
				'musicId' : $(playListItem).find("[name=mId]").val()
					},
			success : function(data) {
				var obj = eval("(" + data + ")");
				$(player).attr('src', obj.musicFilePath);
				$('#play').css('display', 'none');
				$('#pause').css('display', 'inline-block');
				$(amazingPlay).trigger('click');
			}
		});
	});
	
	$('#progressbar').click(function(e){
		var percent = e.offsetX / $(this).width();
		player.currentTime = percent * player.duration;
		$('#progressbar > .progress-bar').width(e.offsetX);
	});
	
	$('#memName').click(function(){
		if($('#playingMem').val() == ''){
			return;
		}
		var memId = $('#playingMem').val();
		$('#playerDiv > form').attr('id', 'memberInfo');
		$('#playerDiv > form').attr('action', 'memberInfo.do');
		$('#playerDiv > form').attr('method', 'post');
		$('#playerDiv > form > input').attr('id', 'memberId');
		$('#playerDiv > form > input').attr('value', memId);
		$('#playerDiv > form').submit();
	});
	
	$('#musicTitle').click(function(){
		if($('#playingMusic').val() == ''){
			return;
		}
		var musicId = $('#playingMusic').val();
		$('#playerDiv > form').attr('id', 'musicInfo');
		$('#playerDiv > form').attr('action', 'musicInfo.do');
		$('#playerDiv > form').attr('method', 'post');
		$('#playerDiv > form > input').attr('id', 'musicId');
		$('#playerDiv > form > input').attr('value', musicId);
		$('#playerDiv > form').submit();
	});
	
	$('#playlistDropDown .dropdown-menu').on({
	    "click":function(e){
	    	e.stopPropagation();
	    }
	});
	

	
	
	//--------------------------셔플 기능----------------------------------------------
	
	//--------------------------반복 기능----------------------------------------------
});