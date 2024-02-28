// 左侧边栏用到的函数
// 左侧列表显示用户信息修改界面视图
function toChangeUserInfo() {

    $(location).attr("href", "/user/changeUserInfoView")
}
function toFileUpload() {
    var articleShow = $("#articleShow");
    $(location).attr("href", "/uploadFile/toFileUpload")
}
function toFileDownload(){
    var articleShow = $("#articleShow");
    $(location).attr("href","/uploadFile/toFileDownload")
}

function newArticle() {
    //导入添加界面
    $.ajax({
        type: "GET",
        url: "/article/newArticleView",
        success: function (html) {
            $("#articleShow").html(html);
        }
    })
    //将发布新主题按钮隐藏
    $(".newArticle").attr("hidden", "hidden");
}
function recordSearchElement() {
    //获取上方搜索框框的值
    $("#searchRecord").attr("searchRecord", $("#top-search").val());
    //显示搜索结果的第一页
    queryArticleByPageNo(1);
}