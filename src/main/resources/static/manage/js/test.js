
// 更新
function updateFood(fid){
    layer.open({
        type: 2,
        content: ['updateFood.html', 'no'],
        area: ['500px', '800px']
    });
}

// 删除
function deleteFood(fid){
    if (window.confirm("您确定要删除吗？")) {
        $.ajax({
            type: "get",
            url: path + "/food/delete?fid",
            dataType: "json",
            success: function (response) {
                layer.msg(response.msg);
            }
        })
    }
}