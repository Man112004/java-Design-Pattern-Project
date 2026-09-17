<%@ page import="jakarta.servlet.http.Cookie" %>

    <%
    String username = "";

    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {

            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            }
        }
    }
%>

        <!DOCTYPE html>
        <html>

        <head>
            <title>Login</title>
        </head>

        <body>

            <h2>Login</h2>

            <form action="login" method="post">

                Username:
                <input type="text" name="username" value="<%= username %>" required>

                <br><br>

                <input type="checkbox" name="remember"> Remember Me

                <br><br>

                <input type="submit" value="Login">

            </form>

        </body>

        </html>