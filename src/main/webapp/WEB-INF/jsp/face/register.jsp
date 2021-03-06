<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <base href="/" >
        <title>注册</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--<link href="css/style.css" rel="stylesheet">-->
        <!-- 设置CSS -->
        <style>
            body{text-align: center; font-family: "微软雅黑";}
        </style>
        <!-- 导入JQuery类库-->

<%--        <script src="${ctxStatic}/js/jquery-3.2.1.min.js"></script>--%>
        <script type="text/javascript" src="${ctxStatic}/js/jquery.1.4.2.min.js"></script>
        <!-- 设置javascript -->
        <script >
            // 页面启动函数
            $(document).ready(function(){
                console.log("页面启动");
                // 调用invokeCamera()
                invokeCamera();
                // 创建全局对象context,存放人像数据
                var context = canvas.getContext("2d");
                // 为按钮添加单击处理事件
                document.getElementById("acqusition_of_features").addEventListener("click", function(){
                    console.log("点击按钮");
                    // 在canvas中生成静态人像图片
                    context.drawImage(video,0,0,250,200);
                    console.log("人像采集完毕.")
                    // 调用人像数据上传函数
                    uploadImage();
                });
            });

            // 自定义一个函数，启动设备摄像头，并将视频流数据实时显示在组件中
            function invokeCamera(){
                console.log("开始调用invokeCamera()函数");
                // 步骤1：创建局部变量设置视频采集区域大小以及是否接受声音
                let constranits = {
                    video: {width:510, height:430},
                    audio: false // 设置为True可以获取声音
                }
                console.log("获取video对象.");
                let video = document.getElementById("video");
                console.log("获取promise对象.")
                let promise = navigator.mediaDevices.getUserMedia(constranits);
                console.log("获取到的视频流绑定到video对象中……")
                // 使用promise对象的then()函数
                promise.then(function(MediaStream){
                    video.srcObject = MediaStream;  // 将媒体流对象设置到video组件中
                    video.play();  // 设置video对象为播放状态
                });
            }

            // 自定义函数实现Ajax图片上传
            var uploadImage = function(){
                console.log("启动人像图片上传……");
                // 获取canvas组件中的图片信息数据
                imageData = getBase64();
                // 将人像图片的数据类型装换成json格式
                var data = {"username":$("#username").val(),"data":imageData}
                console.log(data);
                // 使用Ajax上传数据
                $.ajax({
                    url: "/face/facedetect",
                    type: "POST",
                    data: data,
                    success:function(res){
                        if(res==1){
                            parent.location.href="message/success"
                            // alert("注册成功！");
                        }else{
                            // parent.location.href="message/error"
                            alert("注册失败！");
                        }
                    }
                });
            }
            function getBase64() {
                var data = document.getElementById("canvas");
                console.log(data);
                var imgSrc = data.toDataURL(
                    "image/png");
                return imgSrc.split("base64,")[1];
            }



        </script>
    </head>
    <body >

        <h2>请把脸置于镜头正中</h2>
        <!-- 设置video组件，用于采集用户动态图像 -->
        <div style="margin:0px auto; ">

            <video id="video" autoplay="autoplay"
                   style="width: 600px; border: 1px dashed blueviolet; border-radius: 12px;"></video>
        </div>
        <div><input type="hidden" value="${fns:getUser().getUsername()}" id="username" /></div>
        <!-- 设置Button组件 -->
        <div style="margin:0px auto; ">
            <button id="acqusition_of_features"
                    style="cursor: pointer; width: 140px;
                           height: 45px; color: white;
                           background-color:#1a7dde;
                           border: 0px; border-radius: 7px;
                           margin-top: 10px;">
                注册
            </button>
        </div>

        <!-- 设置Canvas组件，用于存放用户人像静态图片 -->
        <div style="margin:0px auto;">
            <canvas id="canvas" width="250", height="200"
                    style="border: 1px dashed blueviolet; border-radius: 10px; margin-top: 30px;"></canvas>
        </div>


    </body>
</html>