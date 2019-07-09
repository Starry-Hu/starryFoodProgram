/* 新闻类别 */

// 检测是否填写标题
function checkTitle() {
    var title = $('#title').val();
    var tips = $('#title').siblings('span');
    if (title == '') {
        $('#title').addClass('input-error');
        tips.css('display', 'inline');
        return false;
    } else {
        $('#title').removeClass('input-error');
        tips.css('display', 'none');
        return true;
    }
}
//检查是否选择版块
function checkSection() {
    var section = $('#section').val();
    var tips = $('#section').siblings('span');
    if (section == "none") {
        $('#section').addClass('input-error');
        tips.css('display', 'inline');
        return false;
    } else {
        $('#section').removeClass('input-error');
        tips.css('display', 'none');
        return true;
    }
}

/* 用户修改个人信息 */

// 检查用户名称是否填写
function checkCname() {
    var cname = $('#cname').val();
    var tips = $('#cname').siblings('span');
    if (cname == '') {
        $('#cname').addClass('input-error');
        tips.css('display', 'inline');
        return false;
    } else {
        $('#cname').removeClass('input-error');
        tips.css('display', 'none');
        return true;
    }
}

/* 管理员类别 */

//检查管理员账号
function checkAdminId() {
 var adminId = $('#adminId').val();
 var tips = $('#adminId').siblings('span');
 if (adminId == '') {
     $('#adminId').addClass('input-error');
     tips.css('display', 'inline');
     return false;
 } else {
     $('#adminId').removeClass('input-error');
     tips.css('display', 'none');
     return true;
 }
}

//检查管理员名称
function checkAdminName() {
 var adminName = $('#adminName').val();
 var tips = $('#adminName').siblings('span');
 if (adminName == '') {
     $('#adminName').addClass('input-error');
     tips.css('display', 'inline');
     return false;
 } else {
     $('#adminName').removeClass('input-error');
     tips.css('display', 'none');
     return true;
 }
}

//检查密码
function checkPsw() {
 var password = $('#password').val();
 var password2 = $('#password2').val();
 var tips = $('#password').siblings('span');
 var tips2 = $('#password2').siblings('span');

 if (password != '' && password2 != '') {
     $('#password').removeClass('input-error');
     $('#password2').removeClass('input-error');
     tips.css('display', 'none');
     tips2.css('display', 'none');
     return true;
 } else {
     // 第一次未填写
     if (password == '') {
         $('#password').addClass('input-error');
         tips.css('display', 'inline');
     } else {
         // 第二次未填写
         $('#password2').addClass('input-error');
         tips2.css('display', 'inline');
     }
     return false;
 }
}

/* 检查原密码是否填写 */
function checkOldPsw() {
    var oldPassword = $('#oldPassword').val();
    var tips = $('#oldPassword').siblings('span');
    if (oldPassword == '') {
        $('#oldPassword').addClass('input-error');
        tips.css('display', 'inline');
        return false;
    } else {
        $('#oldPassword').removeClass('input-error');
        tips.css('display', 'none');
        return true;
    }
}