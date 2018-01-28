document.getElementsByClassName('wishListNum_div')[0].onmouseover = function() {
	document.getElementsByClassName("wishList_div")[0].style.display = "block";
}
document.getElementsByClassName('wishListNum_div')[0].onmouseout = function() {
	document.getElementsByClassName("wishList_div")[0].style.display = "none";
}	//my wish list
document.getElementsByClassName("wishList_div")[0].onmouseover = function() {
	this.style.display = "block";
}
document.getElementsByClassName("wishList_div")[0].onmouseout = function() {
	this.style.display = "none";
}


document.getElementById('search').onmouseover = function() {
	document.getElementsByClassName('searchArea')[0].style.display = "block";
}
document.getElementById('search').onmouseout = function() {
	document.getElementsByClassName('searchArea')[0].style.display = "none";
}
document.getElementsByClassName('searchArea')[0].onmouseover = function() {
	this.style.display = "block";
}
document.getElementsByClassName('searchArea')[0].onmouseout = function() {
	this.style.display = "none";
}

document.getElementsByClassName('icon-weibo')[0].onmouseover = function() {
	this.style.border = "1.5px solid #cc7a00";
	document.getElementsByClassName('icon-weibo')[0].getElementsByTagName('img')[0].style.opacity = "1"; 
}
document.getElementsByClassName('icon-weibo')[0].onmouseout = function() {
	this.style.border = "1.5px solid #fff";
	document.getElementsByClassName('icon-weibo')[0].getElementsByTagName('img')[0].style.opacity = "0.5"; 
}
document.getElementsByClassName('icon-wechat')[0].onmouseover = function() {
	this.style.border = "1.5px solid #cc7a00";
	document.getElementById('wechat').style.opacity = "1"; 
	this.getElementsByTagName('ul')[0].style.left = '-72px';
}
document.getElementsByClassName('icon-wechat')[0].onmouseout = function() {
	this.style.border = "1.5px solid #fff";
	document.getElementById('wechat').style.opacity = "0.5"; 
	this.getElementsByTagName('ul')[0].style.left = '0';
}		//icon

document.getElementsByClassName('theSignArea')[0].style.bottom = document.body.scrollTop + 'px';

document.getElementById('Sign-join-btn').onclick = function() {
	document.getElementsByClassName('theSignArea')[0].style.display = "none";
	document.getElementsByClassName('theJoinArea')[0].style.display = "block";
}
document.getElementById('backToSign').onclick = function() {
	document.getElementsByClassName('theSignArea')[0].style.display = "block";
	document.getElementsByClassName('theJoinArea')[0].style.display = "none";
}

$(function() {   
    $(".login").click(function(e) {
    	if($(".theJoinArea").is(":hidden")) {
          	$(".theJoinArea").fadeIn();
            e ? e.stopPropagation() : event.cancelBubble = true;
        }
    });
    $(".theJoinArea").click(function(e) {
         e ? e.stopPropagation() : event.cancelBubble = true;
    });
    $(document).click(function() {
        $(".theJoinArea").fadeOut();
    });
})
$(function() {   
    $(".login").click(function(e) {
    	if($(".theSignArea").is(":hidden")) {
          	$(".theSignArea").fadeIn();
            e ? e.stopPropagation() : event.cancelBubble = true;
        }
    });
    $(".theSignArea").click(function(e) {
         e ? e.stopPropagation() : event.cancelBubble = true;
    });
    $(document).click(function() {
        $(".theSignArea").fadeOut();
    });
})
$(document).ready(function() {
    $.ajax({
                type: "GET",
                url: "/doubledogs/judgelogin",
                dataType: "json",
                success: function (data) {
                    if(data.success == 1){
                        $(".wishList_div").html("MY WISH LIST/"+data.person.email);
                        $.ajax({
                            type: "GET",
                            url: "/doubledogs/gettotalcollectnum",
                            dataType: "json",
                            success: function (data) {
                                $(".wishListNum_div").html(data.collectnum);
                            }
                        });
                    }

        }
    });

})

$("#login").click(function(){
    $.ajax({
        type: "GET",
        data: {
            "email":$("#useremail").val(),
            "password":$("#userpassword").val(),
        },
        url: "/doubledogs/dologin",
        dataType: "json",
        success: function (data) {
            if(data.success==1){
                alert("登陆成功");
                $(".theSignArea").hide();
//                    $(".login").html(data.person.email);
                $(".wishList_div").html("MY WISH LIST/"+data.person.email);
               gettotalcollectnum();
            }else{
                alert("登录失败");
            }

        }
    });

});

$("#regemail").bind('input propertychange',function(){
    $.ajax({
        type: "GET",
        data: {
            "email":$("#regemail").val(),
        },
        url: "/doubledogs/isrepeat",
        dataType: "json",
        success: function (data) {
            console.log(data.isrepeat);
            if (data.isrepeat == 1) {
                console.log("用户名重复")
                $("#prompt").show();
            }else {
                $("#prompt").hide();
            }
        }
    });
});
$("#register").click(function(){
    $.ajax({
        type: "GET",
        data: {
            "email":$("#regemail").val(),
            "password":$("#regpassword").val(),
        },
        url: "/doubledogs/addperson",
        dataType: "json",
        success: function (data) {
            if (data.success == 1) {
                console.log("注册成功")
                alert("注册成功");
                $(".theJoinArea").hide();

            }
        }
    });
});

function gettotalcollectnum() {
    $.ajax({
        type: "GET",
        url: "/doubledogs/gettotalcollectnum",
        dataType: "json",
        success: function (data) {
            $(".wishListNum_div").html(data.collectnum);

        }
    });
}