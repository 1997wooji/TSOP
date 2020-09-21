$('.input-group-append').click(function(e){
	if($('input[name=key]').val().trim() == ''){
		alert("빈문자");
	}else{
		$('.form-inline').submit();
	}
});