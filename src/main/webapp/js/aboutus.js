var samllboxArray = document.getElementsByClassName('smallbox');
samllboxArray[0].onmouseover = function() {
	this.style.backgroundColor = 'rgb(105, 105, 105)';
		
	$('.left-box').append("<style>.left-box:nth-child(1)::after{border: 5px solid #cc7a00}</style>");
}
samllboxArray[1].onmouseover = function() {
	this.style.backgroundColor = 'rgb(105, 105, 105)';
		
	$('.left-box').append("<style>.left-box:nth-child(2)::after{border: 5px solid #cc7a00}</style>");
}
samllboxArray[2].onmouseover = function() {
	this.style.backgroundColor = 'rgb(105, 105, 105)';
	
	$('.left-box').append("<style>.left-box:nth-child(3)::after{border: 5px solid #cc7a00}</style>");
}
samllboxArray[3].onmouseover = function() {
	this.style.backgroundColor = 'rgb(105, 105, 105)';
		
	$('.right-box').append("<style>.right-box:nth-child(1)::after{border: 5px solid #cc7a00}</style>");
}
samllboxArray[4].onmouseover = function() {
	this.style.backgroundColor = 'rgb(105, 105, 105)';
		
	$('.right-box').append("<style>.right-box:nth-child(2)::after{border: 5px solid #cc7a00}</style>");
}