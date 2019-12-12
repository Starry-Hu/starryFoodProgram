layui.use(['layer'], function () {
    // 请求的基本路径
    const path = location.protocol + "//" + window.location.host + "/starryfood";

    $(function () {
        // 获取当前登录用户信息
        $.ajax({
            type: "get",
            url: path + "/customer/getLoginedCustomer",
            dataType: "json",
            success: function (response) {
                if (response.code != '0') {
                    layer.msg(`${response.msg}`, {
                        time: 1500,
                        end: function () {
                            // 未登陆时跳转到登录页面
                            if (response.code == '397') location.href = "login.html";
                        }
                    })
                } else {
                    // 将用户名取出来显示
                    $('#editPersonInfo span').text(response.data.customerName);
                    $('#editPersonInfo').bind('click', function () {
                        layer.open({
                            title: '修改个人信息',
                            type: 2,
                            content: 'editPersonInfo.html',
                            area: ['500px', '400px'],
                            // offset: '20%',
                            shade: 0.5,
                            shadeClose: true,//点击遮罩关闭
                        });
                    });
                }
            }
        });
    })

    // 退出登录
    $('#logout').click(function () {
        $.ajax({
            type: "get",
            url: path + "/customer/logout",
            dataType: "json",
            success: function (response) {
                if (response.code == '0') {
                    layer.msg('欢迎下次光临 ~ ', {
                        time: 1500,
                        end: function () {
                            location.href = "login.html";
                        }
                    })
                }
            }
        });
    })
})