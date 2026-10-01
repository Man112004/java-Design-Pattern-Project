<%@ page contentType="text/html;charset=UTF-8" %>

    <%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

        <!DOCTYPE html>

        <html>

        <head>

            <title>Orders</title>

            <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">

            <link rel="stylesheet" href="<c:url value='/css/adminlte.min.css'/>">

        </head>

        <body>

            <div class="container-fluid">

                <div class="row">

                    <!-- Sidebar -->

                    <div class="col-md-3 bg-dark min-vh-100">

                        <h3 class="text-white p-3">
                            My Admin
                        </h3>

                        <ul class="nav flex-column">

                            <li class="nav-item">

                                <a href="<c:url value='/dashboard'/>" class="nav-link text-white">

                        Dashboard

                    </a>

                            </li>

                            <li class="nav-item">

                                <a href="<c:url value='/orders'/>" class="nav-link text-white">

                        Orders

                    </a>

                            </li>

                            <li class="nav-item">

                                <a href="<c:url value='/profile'/>" class="nav-link text-white">

                        Profile

                    </a>

                            </li>

                        </ul>

                    </div>

                    <!-- Main Content -->

                    <div class="col-md-9 p-5">

                        <h1>Orders</h1>

                        <div class="card mt-4">

                            <div class="card-header">

                                <h3>Flipkart Style Orders</h3>

                            </div>

                            <div class="card-body">

                                <table class="table table-bordered table-striped">

                                    <thead>

                                        <tr>

                                            <th>Order ID</th>

                                            <th>Product Name</th>

                                            <th>Status</th>

                                        </tr>

                                    </thead>

                                    <tbody>

                                        <c:forEach var="order" items="${orders}">

                                            <tr>

                                                <td>
                                                    ${order.orderId}
                                                </td>

                                                <td>
                                                    ${order.productName}
                                                </td>

                                                <td>
                                                    ${order.status}
                                                </td>

                                            </tr>

                                        </c:forEach>

                                    </tbody>

                                </table>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

            <script src="<c:url value='/js/bootstrap.bundle.min.js'/>">
            </script>

            <script src="<c:url value='/js/adminlte.min.js'/>">
            </script>

        </body>

        </html>