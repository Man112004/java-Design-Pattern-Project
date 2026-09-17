<%@ page import="java.util.List" %>
    <%@ page import="com.example.model.Product" %>

        <!DOCTYPE html>
        <html>

        <head>
            <title>Product List</title>
        </head>

        <body>

            <h1>Product List</h1>

            <table>
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                </tr>

                <%
    List<Product> products =
        (List<Product>) request.getAttribute("products");

    if (products != null) {
        for (Product product : products) {
%>

                    <tr>
                        <td>
                            <%= product.getId() %>
                        </td>
                        <td>
                            <%= product.getName() %>
                        </td>
                        <td>₹
                            <%= product.getPrice() %>
                        </td>
                    </tr>

                    <%
        }
    }
%>

            </table>

        </body>

        </html>