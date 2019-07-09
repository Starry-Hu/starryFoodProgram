// 添加菜品
function addFood(){
    layer.open({
        type: 2,
        content: 'foodAdd.html',
        area: ['500px', '450px']
    });
}
// 更新菜品
function updateFood(fid){
    layer.open({
        type: 2,
        content: ['foodUpdate.html?fid='+fid, 'no'],
        area: ['500px', '450px']
    });
}

// 删除菜品
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