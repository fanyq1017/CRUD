
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>

<body>
    <form action="/student" method="post">
        学号: <input type="text" name="student_id"><br/>
        姓名：<input type="text" name="name"><br/>

        性别：<input type="text" name="gender"><br/>
        年龄：<input type="text" name="age"><br/>
        生日：<input type="text" name="birthda"><br/>
        联系方式：<input type="text" name="contact"><br/>
        邮箱：<input type="text" name="email"><br/>
        班级：<input type="text" name="classes"><br/>
        爱好：<input type="text" name="hobby"><br/>

        <input type="hidden" name="method" value="add"/>
        <input type="submit" value="提交">

    </form>
</body>
</html>
