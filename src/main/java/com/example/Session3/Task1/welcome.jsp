<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String username =
        (String) session.getAttribute("username");
%>

    <!DOCTYPE html>
    <html>

    <head>
        <title>Welcome</title>
    </head>

    <body>

        <h2>Welcome,
            <%= username %>!</h2>

        <p>You are successfully logged in.</p>

    </body>

    </html>