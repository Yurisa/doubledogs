var smallImgArray = document.getElementsByClassName('smallImg')[0].getElementsByTagName('ul')[0].getElementsByTagName('li');
for(var i=0;i<smallImgArray.length;i++) {
	smallImgArray[i].onclick = function() {
		for(var j=0;j<smallImgArray.length;j++) {
			smallImgArray[j].style.border = '2px solid rgba(247, 247, 247, 0.66)';
		}	
		document.getElementsByClassName('detailImg')[0].getElementsByTagName('img')[0].src = this.getElementsByTagName('img')[0].src;
		this.style.border = '2px solid grey';
	}
}