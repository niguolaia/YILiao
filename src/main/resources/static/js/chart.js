//定义webscocket
var webSocket=null;
//判断当前浏览器是否支持websocket
if('WebSocket' in window){
    webSocket=new WebSocket("ws://172.242.3.211/websocket");
}else {
    alert("浏览器不支持webSocket");
}
//连接错误回掉函数
webSocket.onerror=function () {
sendMessage("链接失败");
}
//连接成功回掉函数
webSocket.onopen=function () {
    console.log("连接成功");
}
//消息接受成功回掉函数
webSocket.onmessage=function (event) {
        sendMessage(event.data);
}
//连接关闭回掉函数
webSocket.onclose=function () {
    sendMessage("关闭连接");
}
 
//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，
//防止连接还没断开就关闭窗口，server端会抛异常。
window.οnbefοreunlοad=function () {
    webSocketClose();

}

//发送消息
function sendMsg(){
	//getElementsByClassName获取的是一个数组
    var txt=document.getElementsByClassName("inputText")[0].value;
   webSocket.send(txt);
}
//关闭连接
function webSocketClose(){
    webSocket.close();
}
 
 
//消息处理函数
function sendMessage(date) {
    if(date.indexOf("#")>=0){
        document.getElementsByClassName("msg")[0].innerHTML+=event.data.split("#")[0]+"<br>";
        document.getElementsByClassName("onlinecount")[0].innerHTML=event.data.split("#")[1];
    }else {
    document.getElementsByClassName("msg")[0].innerHTML+=date+"<br>";
    }
}