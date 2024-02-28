function openArticle(articleId) {
    var url="/article/toArticleDetailPage"+"?articleId="+articleId;
    window.open(url);
    return false
}