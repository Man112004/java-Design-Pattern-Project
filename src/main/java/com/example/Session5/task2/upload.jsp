<!DOCTYPE html>
<html>

<head>
    <title>Upload Song</title>
</head>

<body>

    <h2>Upload Favorite Song</h2>

    <form action="uploadSong" method="post" enctype="multipart/form-data">

        Username:
        <input type="text" name="username" required>
        <br><br> Select MP3:
        <input type="file" name="song" accept=".mp3" required>
        <br><br>

        <button type="submit">Upload Song</button>

    </form>

</body>

</html>