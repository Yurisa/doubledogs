var QAnum = document.getElementsByClassName('QA');
for(var i=0;i<QAnum.length;i++) {
	document.getElementsByClassName('QA')[i].onmouseover = function() {
		this.getElementsByTagName('div')[0].className = "Q-area";
	}
	document.getElementsByClassName('QA')[i].onmouseout = function() {
		this.getElementsByTagName('div')[0].className = "Q-area-default";
	}
	document.getElementsByClassName('QA')[i].onclick = function() {
		this.getElementsByTagName('div')[1].style.display = this.getElementsByTagName('div')[1].style.display == 'block' ? 'none' : 'block';
	}
}
var mapProp = {
  center:new google.maps.LatLng(51.508742,-0.120850),
  zoom:7,
  mapTypeId: google.maps.MapTypeId.ROADMAP
};
var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
google.maps.event.addDomListener(window, 'load', initialize);