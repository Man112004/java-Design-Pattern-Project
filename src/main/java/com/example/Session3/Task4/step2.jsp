<%
    String name = request.getParameter("name");
%>

    <!DOCTYPE html>
    <html>

    <head>
        <title>Feedback Step 2</title>
    </head>

    <body>

        <h2>Feedback Form - Step 2</h2>

        <form action="feedback" method="post">

            <input type="hidden" name="name" value="<%= name %>"> Enter Feedback:
            <br>
            <textarea name="feedback" rows="5" cols="40" required></textarea>

            <br><br>

            <input type="submit" value="Submit Feedback">
        </form>

    </body>

    </html>