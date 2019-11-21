// 添加菜品
function addFood(){
    layer.open({
        type: 2,
        content: 'foodAdd.html',
        area: ['500px', '550px'],
        move:false,
        success: function (layero, index) {
            //获取当前弹出窗口的索引及初始大小
            var layerIndex = index;
            var layerInitWidth = $("#layui-layer" + layerIndex).width();
            var layerInitHeight = $("#layui-layer" + layerIndex).height();
            resizeLayer(layerIndex, layerInitWidth, layerInitHeight);
        }
    });
}
// 更新菜品
function updateFood(fid){
    layer.open({
        type: 2,
        content: ['foodUpdate.html?fid='+fid],
        area: ['500px','400px'],
        // offset: '20%',
        shade:0.5,
        shadeClose: true,//点击遮罩关闭
        // move: false,//禁止拖动
        // 调整使高度宽度自适应
        success: function (layero, index) {
            // //获取当前弹出窗口的索引及初始大小
            // layerIndex = index;
            // layerInitWidth = $("#layui-layer" + layerIndex).width();
            // layerInitHeight = $("#layui-layer" + layerIndex).height();
            // resizeLayer(layerIndex, layerInitWidth, layerInitHeight);
            layer.iframeAuto(index);
        }
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

// 对弹出层大小做自适应调整
function resizeLayer(layerIndex, layerInitWidth, layerInitHeight) {
    var top = $(this).offset().top;
    var windowWidth = $(document).width();
    var windowHeight = $(document).height();
    var minWidth = layerInitWidth > windowWidth ? windowWidth : layerInitWidth;
    var minHeight = layerInitHeight > windowHeight ? windowHeight : layerInitHeight;

    alert(top)
    layer.style(layerIndex, {
        top: top,
        width: minWidth,
        height: minHeight
    });
}