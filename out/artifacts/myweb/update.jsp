<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>

<body>
<form action="/student" method="post">
    学号: <input type="text" name="student_id" value="${student.student_id}" readonly>(不可修改)<br/>
    姓名：<input type="text" name="name" value="${student.name}"><br/>
    性别：<input type="text" name="gender" value="${student.gender}"><br/>
    年龄：<input type="text" name="age" value="${student.age}"><br/>
    生日：<input type="text" name="birthday" value="${student.birthday}"><br/>
    联系方式：<input type="text" name="contact" value="${student.contact}"><br/>
    邮箱：<input type="text" name="email" value="${student.email}"><br/>
    班级：<input type="text" name="classes" value="${student.classes}"><br/>
    爱好：<input type="text" name="hobby" value="${student.hobby}"><br/>

    <input type="hidden" name="method" value="update"/>
    <input type="submit" value="修改">

</form>
</body>
</html>
