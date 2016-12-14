<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.12.2016
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>

<%
    List<String> userNamesList = Arrays
            .asList("name1", "name2", "name3", "name4", "name5");
    response.getWriter().print(userNamesList);
    request.setAttribute("userNamesList1", userNamesList);

%>

<body>

    <form method="post" action="<%=request.getContextPath()%>/users">
        <input name="login_ui" type="text" value=""/>
        <input name="age_ui" type="text" value=""/>
        <input name="password_ui" type="text" value=""/>
        <input name="phone_ui" type="text" value=""/>
        <input name="email_ui" type="text" value=""/>
        <input name="adres_ui" type="text" value=""/>
        <input type="submit" value="add user"/>
    </form>
</body>
</html>
