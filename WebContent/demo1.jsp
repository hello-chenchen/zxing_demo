<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>懒人原创tab标签、选项卡切换效果#######Demo2</title>
<style>
*{ margin:0; padding:0; list-style:none;}
body{ font-size:12px; color:#666; text-align:left;}
h1{ text-align:center;}

.hello_chenchen{ width:500px; height:140px; margin:100px auto; background:#f0f0f0; font-family:'微软雅黑';}
.hello_chenchen .tab{ overflow:hidden; background:#ccc;}
.hello_chenchen .tab a{ display:block; padding:10px 20px; float:left; text-decoration:none; color:#333;}
.hello_chenchen .tab a:hover{ background:#E64E3F; color:#fff; text-decoration:none;}
.hello_chenchen .tab a.on{ background:#E64E3F; color:#fff; text-decoration:none;}
.hello_chenchen .content{ overflow:hidden; width:500px; height:100px; position:relative;}
.hello_chenchen .content ul{ position:absolute; left:0; top:0; height:100px;}
.hello_chenchen .content li{ width:500px; height:100px; float:left;}
.hello_chenchen .content li p{ padding:10px;}
</style>
</head>
<body>
<div class="hello_chenchen">
    <div class="tab">
        <a href="javascript:;" class="on">js特效</a>
        <a href="javascript:;">flash素材</a>
        <a href="javascript:;">亚当学院</a>
        <a href="javascript:;">在线客服代码</a>
    </div>
    <div class="content">
        <ul>
            <li>
            <p>
                <form action="qrcode">
                     <input type="text" name="website" />
                     <input type="submit" value="生成二维码" />
                </form>
            </p></li>
            <li><p>flash素材内容</p></li>
            <li><p>亚当学院内容</p></li>
            <li><p>在线客服代码内容</p></li>
        </ul>
    </div>
</div>

</body>
</html>