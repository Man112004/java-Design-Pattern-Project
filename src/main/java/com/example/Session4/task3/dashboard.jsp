<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html>

        <head>

            <title>Dashboard</title>

            <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">

            <link rel="stylesheet" href="<c:url value='/css/adminlte.min.css'/>">

        </head>

        <body>

            <div class="container mt-5">

                <h1>Dashboard</h1>

                <div class="card mt-4">

                    <div class="card-body">

                        <h3>
                            Welcome, ${userName}!
                        </h3>

                        <p>
                            Welcome to the Admin Dashboard.
                        </p>

                    </div>

                </div>

            </div>

            <script src="<c:url value='/js/bootstrap.bundle.min.js'/>"></script>

            <script src="<c:url value='/js/adminlte.min.js'/>"></script>

        </body>

        </html>