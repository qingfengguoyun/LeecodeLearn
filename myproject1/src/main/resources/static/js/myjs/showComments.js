function queryCommentByArticleIdAndPageNo(articleId,pageNo) {

    // console.log($("#comment").html());
    var data={};
    data['articleId']=articleId;
    data['pageNo']=pageNo;
    alert(data);
    $.ajax({
        type:"GET",
        url:"/comment/queryCommentByArticleIdAndPageNo",
        data:data,
        success:function (html) {
            $('#comment').html(html);
            // console.log("WER");
        }
    })
}

