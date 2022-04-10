<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
        <head>
            <link  rel="stylesheet" type="text/css" href="style.css" >
            <title>JSP - Hello World</title>
        </head>
<body>


<div class="mainContainer">

<div class="container">
    <form method="post" action="login" >
            <label for="exampleInputEmail1">Email address</label>
            <input type="text" name="email" class="form-control" value="${email}" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">

            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" class="form-control" value="${password}" id="exampleInputPassword1" placeholder="Password">

            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
            <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<div class="errorMessage">
    ${errorMessage}
</div>

</div>

 <a href="hello-servlet">  Click here please </a>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>

</html>