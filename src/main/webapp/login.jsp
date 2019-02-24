
<!DOCTYPE html>
<html lang="pl">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Rezerwacja samochod�w">
    <meta name="keywords" content="samoch�d, rezerwacja">
    <meta name="author" content="CSS Group">
    <meta http-equiv="X-Ua-Compatible" content="IE=edge">

    <title>CarSharingSystem</title>

    <!-- Styles - Bootstrap core and custom -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/css/main.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">

</head>
<body>


<!-- Page Content -->
<div class="container">
    <br>
    <br>
    <br>

    ${error}
    ${emptyData}
<form action="LoginServlet" method="post">
    <table style="with: 50%">

        <tr>
            <td>Username</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
    </table>
    <input type="submit" value="Login" /></form>
<br>
<br>
<br>
<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white"><img src="img/css-logo.png" width="35" height="35" class="d-inline-block mr-1" alt=""> Copyright &copy; 2018-2019 by CSS Group</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
