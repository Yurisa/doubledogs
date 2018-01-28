var imgArray = ["images/home/bg1.jpg","images/home/bg2.jpg","images/home/bg3.jpg","images/home/bg4.jpg","images/home/bg5.jpg","images/home/bg6.jpg"];
for(var i=1;i<imgArray.length+1;i++) {
	var formattedimg = document.createElement('img');
	formattedimg.src = imgArray[i-1];
	document.getElementsByClassName('theBGArea')[0].getElementsByTagName('ul')[0].getElementsByTagName('li')[i-1].appendChild(formattedimg);
}
var imgBarArray = document.getElementsByClassName('imgBar')[0].getElementsByTagName('div');
var changeColor = function(index) {
	for(i=0;i<imgBarArray.length;i++) {
		imgBarArray[i].style.backgroundColor = 'rgba(242, 242, 242, 1)';
	}
	imgBarArray[index].style.backgroundColor = '#cc7a00';
}
var formattedwidth = 0;
var index = 0;
changeColor(index);
var clientwidth = document.getElementsByClassName('theBGArea')[0].clientWidth;
var timeImg = window.setInterval("set()",4000);
document.getElementsByClassName('right-btn')[0].getElementsByTagName('img')[0].onclick = function() {
	if (formattedwidth > (-5*clientwidth)) {
		clearInterval(timeImg);
		formattedwidth = formattedwidth - clientwidth;
		document.getElementsByClassName('theBGArea')[0].getElementsByTagName('ul')[0].style.left = formattedwidth + 'px';
		index++;
		if (index > 5) {
			index = 0;
		}
		timeImg = window.setInterval("set()",4000);
		changeColor(index);
		console.log(index);
	}
	
}
document.getElementsByClassName('left-btn')[0].getElementsByTagName('img')[0].onclick = function() {
	if (formattedwidth < 0) {
		clearInterval(timeImg);
		formattedwidth = formattedwidth + clientwidth;
		document.getElementsByClassName('theBGArea')[0].getElementsByTagName('ul')[0].style.left = formattedwidth + 'px';
		index--;
		timeImg = window.setInterval("set()",4000);
		changeColor(index);
		console.log(index);
	}
}
var set = function() {
	formattedwidth = -(index+1)*clientwidth;
	if (formattedwidth < (-5*clientwidth)) {
		formattedwidth = 0;
	}
	index++;
	if (index > 5) {
		index = 0;
	}
	changeColor(index);
	document.getElementsByClassName('theBGArea')[0].getElementsByTagName('ul')[0].style.left = formattedwidth + 'px';	
}
// while($(body).scrollTop() > 200) {
// 	document.getElementsByClassName('theSloganArea')[0].style.display = 'block';
// }
// console.log($(".theSloganArea").scrollTop());
