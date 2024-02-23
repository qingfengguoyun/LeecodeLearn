$(function () {
    console.log("dodod");
})
function toRegist() {
    // console.log("323")
    $(location).attr("href","/to/toRegistPage");
}
function test() {
    console.log("qeqweqw");
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
function login(){
    var formdata=$("form").serializeArray();
    var data={}
    for(var i=0;i<formdata.length;i++){
        data[formdata[i].name]=formdata[i].value;
    }

    data=JSON.stringify(data);
    console.log(data);
    $.ajax({
        url:"/user/userLogin",
        type:"POST",
        data:data,
        contentType:"application/json;charset=utf-8",
        success:function (res) {
            console.log(res);
            if(res.code==1){
                alert("登录失败");
                return false;
            }
            var msg="欢迎登录："+res.data.userName;
            alert(msg);
            $(location).attr("href","/to/toFront");
        }
    })
}