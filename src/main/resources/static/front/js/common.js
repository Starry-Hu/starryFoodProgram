// 获取登录对象
var path = location.protocol + "//" + window.location.host + "/starryfood/customer/getLoginedAdmin";

function checkLogin() {
    $.ajax({
        type: "get",
        url: path,
        dataType: "json",
        success: function(response) {
            if (response.code != 0) {
                alert("请先登录！")
                window.location.href = "login.html";
            }
        }
    });
}

// 退出登录
