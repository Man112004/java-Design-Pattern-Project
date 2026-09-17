<!DOCTYPE html>
<html>

<head>
    <title>Add Product</title>
</head>

<body>

    <h2>Add Product</h2>

    <form action="products" method="post">

        Product Name:
        <input type="text" name="name" required>
        <br><br> Price:
        <input type="number" name="price" step="0.01" required>
        <br><br>

        <button type="submit">Add Product</button>

    </form>

    <br>

    <a href="products">View Products</a>

</body>

</html>