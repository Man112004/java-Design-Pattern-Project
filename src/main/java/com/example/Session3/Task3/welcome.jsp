<html>

<head>
    <title>Welcome</title>
</head>

<body>

    <%
    if (session.getAttribute("username") != null) {
%>

        <h2>Welcome,
            <%= session.getAttribute("username") %>!</h2>

        <form action="logout" method="post">
            <input type="submit" value="Logout">
        </form>

        <%
    } else {
%>

            <h2>Please login first.</h2>

            <a href="login.jsp">Go to Login</a>

            <%
    }
%>

</body>

</html>