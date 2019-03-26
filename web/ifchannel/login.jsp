<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ page import="com.ifpb.model.entidades.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Raul Coelho
  Date: 20/11/2018
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="../images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../css/util.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<%
    User u = (User) session.getAttribute("user");

    if(u != null){
        if(u.getPrivilege() == "aluno"){
            response.sendRedirect("studentPage.jsp");
        }else{
            response.sendRedirect("professorPage.jsp");
        }
    }
%>
<f:view>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="../images/img-01.png" alt="IMG">
            </div>

            <form method="post" action="/controller?action=Authenticate" class="login100-form validate-form">
					<span class="login100-form-title">
						IFPB Channel
					</span>
                <!--email-->
                <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.com">
                    <input class="input100" type="text" name="email" placeholder="Email">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>
                <!--passoword-->
                <div class="wrap-input100 validate-input" data-validate = "Password is required">
                    <input class="input100" type="password" name="password" placeholder="Password">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" href="home.jsp">
                        Login
                    </button>
                </div>
                <%--<div class="text-center p-t-136">--%>
                    <%--<a class="txt2" href="register.jsp">--%>
                        <%--Create your Account--%>
                        <%--<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>--%>
                    <%--</a>--%>
                <%--</div>--%>
            </form>
            <h:form>
                <h:panelGrid columns="2">
                    <h:commandButton action="#{userBean.openRegister}" value="Create your Account"></h:commandButton>
                </h:panelGrid>
            </h:form>
        </div>
    </div>
</div>
</f:view>




<!--===============================================================================================-->
<script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="../vendor/bootstrap/js/popper.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="../vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="../vendor/tilt/tilt.jquery.min.js"></script>
<script >
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>
<!--===============================================================================================-->
<script src="../js/main.js"></script>

</body>
</html>
