<%
    String name = request.getParameter("name");
    String feedback = request.getParameter("feedback");
%>

    <!DOCTYPE html>
    <html>

    <head>
        <title>Thank You</title>
    </head>

    <body>

        <h2>Thank You!</h2>

        <p><b>Name:</b>
            <%= name %>
        </p>

        <p><b>Feedback:</b>
            <%= feedback %>
        </p>

    </body>

    </html>