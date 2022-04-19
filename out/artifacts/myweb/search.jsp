
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search</title>
</head>
<body>
<h1>通过条件查找</h1>
<form action="/student" method="post">
    学号: <input type="text" name="student_id"><br/>
    姓名：<input type="text" name="name"><br/>

    性别：<input type="text" name="gender"><br/>
    年龄：<input type="text" name="age"><br/>
    生日：<input type="text" name="birthday"><br/>
    联系方式：<input type="text" name="contact"><br/>
    邮箱：<input type="text" name="email"><br/>
    班级：<input type="text" name="classes"><br/>
    爱好：<input type="text" name="hobby"><br/>

    <input type="hidden" name="method" value="search"/>
    <input type="submit" value="查找">
</form>
</body>
</html>
