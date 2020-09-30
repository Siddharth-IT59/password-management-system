function showPass(){
	var input = document.getElementById('passInput') ;
	if(input.type === 'password'){
		input.type = 'text' ;
	}else{
		input.type = 'password' ;
	}
}