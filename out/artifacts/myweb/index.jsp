<%--
  Created by IntelliJ IDEA.
  User: 范勇奇
  Date: 2022/4/18
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>

  <h1>小组成员管理系统</h1>
  <table>
    <tr>


      <th>学号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>生日</th>
      <th>联系方式</th>
      <th>邮箱</th>
      <th>班级</th>
      <th>爱好</th>

    </tr>
    <c:forEach items="${list}" var="student">
      <tr>
        <td>${student.student_id}</td>
        <td>${student.name}</td>
        <td>${student.gender}</td>
          <td>${student.age}</td>
          <td>${student.birthday}</td>
          <td>${student.contact}</td>
          <td>${student.email}</td>
          <td>${student.classes}</td>
          <td>${student.hobby}</td>
        <td>
          <a href="/student?method=delete&student_id=${student.student_id}">删除</a>
          <a href="/student?method=findById&student_id=${student.student_id}">修改</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <form action="/student" method="post">
    <input type="hidden" name="method" value="to_add_page"/>
    <input type="submit" value="添加">
  </form>
  <form action="/student" method="post">
    <input type="hidden" name="method" value="to_search_page"/>
    <input type="submit" value="查找">
  </form>

  </body>
</html>
