window.onload = changeText ;

function changeText(){
	let text = document.getElementById('text') ;
	let node = document.createTextNode("Password Encryption Successfull..") ;
	text.appendChild(node) ;

	window.setTimeout(blank,1800) ;
}

function blank(){
	let text = document.getElementById('text') ;
	text.innerHTML = "Welcome" ;
}

