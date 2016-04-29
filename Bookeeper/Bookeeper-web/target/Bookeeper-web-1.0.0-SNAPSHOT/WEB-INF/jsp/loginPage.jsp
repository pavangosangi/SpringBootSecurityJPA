<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE HTML>
<html>

    <head>
        <title>Login Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginPage.css">
    </head>
   
    <body class="loginPage">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="text-center">Login Form</h1>
                </div>
                <div class="modal-body">
                	<c:url var="saveUrl" value="/login" ></c:url>
                    <form action="${saveUrl}" method="post" class="col-md-12 center-block">
                    	<c:if test="${errorMessage ne null}">
                    		<div class="alert alert-danger"><p>${errorMessage.errorMsg}</p></div>
					    </c:if>
                        <div class="form-group has-feedback has-feedback">
                            <input name="username" class="form-control input-lg" placeholder="UserName" type="text"/>
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input name="password" class="form-control input-lg" placeholder="Password" type="password"/>
                            <span class="glyphicon glyphicon-asterisk form-control-feedback"></span>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-block btn-lg btn-primary" value="Let me in">
                            <span class="pull-right"><a href="#">Sign me up</a></span>
                            <span class="pull-left"><a href="#">Dog has my Password</a></span>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
                    <div class="modal-footer">
                        <div class="col-md-12">
                            <h6 class="text-center"><small>Copyrights <span class="glyphicon glyphicon-copyright-mark"></span> belongs to me. Ask me if you want to copy, i will provide you the code. Dont take pain of typing. It will be Easy!!!</small></h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>