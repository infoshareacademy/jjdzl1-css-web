<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Rezerwacja samochodów">
    <meta name="keywords" content="samochód, rezerwacja">
    <meta name="author" content="CSS Group">
    <meta http-equiv="X-Ua-Compatible" content="IE=edge">

    <title>Logowanie - CarSharingSystem</title>

    <!-- Styles - Bootstrap core and custom -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">

</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
        <a class="navbar-brand" href="index.jsp"><img src="img/css-logo.png" width="35" height="35" class="d-inline-block mr-1" alt=""> CarSharingSystem</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Start
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Logowanie</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Rezerwacja</a>
                </li>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Opłaty</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Kontakt</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    ${error}
    ${emptyData}
    <div class="row my-4">
        <div class="col-lg-12">

            <form class="form-signin" action="LoginServlet" method="post">
                <h1 class="h3 mb-3 font-weight-normal">Logowanie</h1>
                <label for="inputLogin" class="sr-only">Login</label>
                <input type="text" name="username" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
                <label for="inputPassword" class="sr-only">Hasło</label>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Hasło" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
            </form>

        </div>
    </div>


</div>
<!-- /.container -->

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
