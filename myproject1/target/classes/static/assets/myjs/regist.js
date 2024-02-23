$(function (){
    $("#getVCode").bind("click",getVcode);
    $("#regist").bind("click",regist);
})

function test() {
    alert("ok")
}
// 自定义转json字符串的方法
/**
 *
 * @param serializeArrayData serializeArray()后的json数组
 * @returns {string}：json字符串
 */
function parseJSON(serializeArrayData) {
    var data={}
    for(var i=0;i<serializeArrayData.length;i++){
        data[serializeArrayData[i].name]=serializeArrayData[i].value;
    }

    data=JSON.stringify(data);
    return data
}
function regist() {
    var data=$("form").serializeArray();
    data=parseJSON(data);
    console.log(data);
    $.ajax({
        url:"/user/userRegist",
        type:"POST",
        data:data,
        contentType:"application/json;charset=utf-8",
        success:function (res) {
            console.log(res.msg);
            alert(res.msg);
            $(location).attr("href","/to/toLoginPage");
        }
    })
}
function getVcode() {
    if($("input[name='userEmail']").val()==''){
        alert("请填写邮箱");
        return false;
    }
    var data=$("input[name='userEmail']").serialize();
    console.log(data);
    $.get("/user/sendVCode",data,function (res) {
        console.log(res);
        alert(res.msg);
    })
    return false;
}

function backToLogin() {
    console.log("osos");
    $(location).attr("href","/to/toLoginPage")
}