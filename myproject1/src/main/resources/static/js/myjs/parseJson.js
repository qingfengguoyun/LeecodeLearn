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