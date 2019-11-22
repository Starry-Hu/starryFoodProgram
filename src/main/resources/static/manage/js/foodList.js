// 添加菜品
function addFood(){
    layer.open({
        type: 2,
        content: 'foodAdd.html',
        area: ['500px', '350px'],
        move:false,
        shade:0.5,
        shadeClose: true,//点击遮罩关闭
    });
}
// 更新菜品
function updateFood(foodId){
    layer.open({
        type: 2,
        content: ['foodUpdate.html?foodId='+foodId],
        area: ['500px','350px'],
        shade:0.5,
        shadeClose: true,//点击遮罩关闭
        // move: false,//禁止拖动
        end: function () { //最后判断是否有添加，执行reload，刷新父页面
            if(false) location.reload();
        }
    });
}

// 删除菜品
function deleteFood(foodId){
    if (window.confirm("您确定要删除吗？")) {
        $.ajax({
            type: "get",
            url: location.protocol + "//" + window.location.host + "/starryfood/food/delete?foodId=" + foodId,
            dataType: "json",
            success: function (response) {
                layer.msg(response.msg);
            }
        })
    }
}