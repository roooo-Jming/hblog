<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>语音设置</title>
<%--    <meta name="renderer" content="webkit">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">--%>
<%--    <meta name="apple-mobile-web-app-status-bar-style" content="black">--%>
<%--    <meta name="apple-mobile-web-app-capable" content="yes">--%>
<%--    <meta name="format-detection" content="telephone=no">--%>
<%--    <link rel="stylesheet" href="${ctxStatic}/plugins/layui/css/layui.css" media="all" />--%>
<%--    <link rel="stylesheet" href="${ctxStatic}/plugins/font-awesome/css/font-awesome.min.css">--%>
    <link href="${ctxStatic}/css/log.css" type="text/css" rel="stylesheet"/>

</head>

<body style=" background-color: gainsboro;">

<div class="content">
    <div class="input-panel">
        <form id="form1" method="post" action="${ctx}/audioSetting">
            <fieldset>

                    <legend>语音播报设置</legend>
                    <dd>
                        <p>语速<span class="error"></span></p>
                        <select name="spd">
                            <option value="慢">--慢--</option>
                            <option value="适中">--适中--</option>
                            <option value="快">--快--</option>
                        </select>
                    </dd>
                    <dd>

                        <p>音量<span class="error"></span></p>

                        <select name="vol">
                            <option value="大">--大--</option>
                            <option value="适中">--适中--</option>
                            <option value="小">--小--</option>
                        </select>
                    </dd>
                    <dd>
                        <p>发音人选择<span class="error"></span></p>
                        <select name="sex">
                            <option value="男">--男--</option>
                            <option value="女">--女--</option>
                        </select>
                    </dd>
                    <br>
                    <dd class="btn-groups">
                        <input type="submit" value="确 定" class="btn btn-primary" />
                        <input type="reset" value="重 置" class="btn btn-success" />
                    </dd>

            </fieldset>

        </form>
    </div>
</div>

</body>

</html>