document.getElementsByClassName('chance-title')[0].onclick = function() {
	document.getElementsByClassName('option')[0].style.display = document.getElementsByClassName('option')[0].style.display == 'block' ? 'none' : 'block';
}

document.getElementsByClassName('chance-title')[1].onclick = function() {
	document.getElementsByClassName('option')[1].style.display = document.getElementsByClassName('option')[1].style.display == 'block' ? 'none' : 'block';
}
document.getElementById('products').onmouseover = function() {
    document.getElementsByClassName("products-content")[0].style.display = "block";
}
document.getElementById('products').onmouseout = function() {
    document.getElementsByClassName("products-content")[0].style.display = "none";
}	//移动到products时 出现products-content
document.getElementsByClassName('products-content')[0].onmouseover = function() {
    this.style.display = "block";
}
document.getElementsByClassName('products-content')[0].onmouseout = function() {
    this.style.display = "none";
}