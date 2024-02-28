function saveArticleImage(files,editor, welEditable) {
    var data = new FormData();
    data.append("file",files[0]);
    $.ajax({
        data:data,
        type:"POST",
        url:"/article/saveArticleImage",
        cache:false,
        contentType:false,
        processData: false,

        success:function (url) {
            console.log(url);
            editor.insertImage(welEditable,url,'img');
        }
    })
}

function admitArticle() {
    //获取富文本输入框的内容
    var articleContent=$('.article-summernote').code()
    var data={};
    //从界面的隐藏div中获取userId
    var userId=$("#userId").attr("userId");
    data['userId']=userId;
    console.log("userId"+$("#userId").attr("userId"))
    //获取主题Title
    data['articleTitle']=$(".newArticleTitle").val();
    //获取主题的Content
    data['articleContent']=articleContent;
    //转化为json字符串
    data=JSON.stringify(data);
    $.ajax({
        type:"POST",
        url:"/article/insertArticle",
        data:data,
        contentType: "application/json",
        success:function (res) {
            console.log(res.code);
        }
    })
    //提交完成后显示文章列表
    queryAllArticlesView();
}