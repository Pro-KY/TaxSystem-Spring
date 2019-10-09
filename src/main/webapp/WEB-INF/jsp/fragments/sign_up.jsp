<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ua.training.taxsystem.util.constans.Commands" %>
<%@ page import="ua.training.taxsystem.util.constans.Parameters" %>

<html>
<head>
    <title>Login page</title>
    <meta charset="utf-8">
</head>
<body>
<div class="container-fluid">
    <form name="SignUpForm" method="POST" action ="${pageContext.request.contextPath}/taxsystem/">
        <input type="hidden" name="command" value="${Commands.SIGN_UP}">
        <!-- user_type -->
        <div class="form-group">
            <label for="usertype"><fmt:message key="signup.user.type.label" bundle="${rb}"/></label>
            <select class="form-control" id="usertype" name="${Parameters.USER_TYPE}">
                <option value="1" selected><fmt:message key="signup.user.type.individual" bundle="${rb}"/></option>
                <option value="2"> <fmt:message key="signup.user.type.legalentity" bundle="${rb}"/> </option>
            </select>
        </div>
        <div id = "fistLastNamesWrapper" class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="fistName"><fmt:message key="signup.user.firstName" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="fistName" name="${Parameters.USER_FIRST_NAME}">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="lastName"><fmt:message key="signup.user.lastName" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="lastName" name="${Parameters.USER_LAST_NAME}">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="email"><fmt:message key="signin.email" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="email" name="${Parameters.EMAIL}">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="password"><fmt:message key="signin.password" bundle="${rb}"/></label>
                    <input type="password" class="form-control" id="password" name="${Parameters.PASSWORD}">
                </div>
            </div>
        </div>

        <div id="organizationWrapper" class="form-group">
            <label for="organization"><fmt:message key="signup.user.organization" bundle="${rb}"/></label>
            <input type="text" class="form-control" id="organization" name="${Parameters.USER_ORGANIZATION}">
        </div>
        <div class="form-group">
            <label for="address"><fmt:message key="signup.user.address" bundle="${rb}"/></label>
            <input type="text" class="form-control" id="address"  name="${Parameters.USER_ADDRESS}">
        </div>
        <button type="submit" class="btn btn-primary"><fmt:message key="sendreport.form.button.submit" bundle="${rb}"/></button>
    </form>
    <div><fmt:message key="msg.sigin" bundle="${rb}"/> <a href="${pageContext.request.contextPath}/taxsystem/?command=${Commands.GET_SIGN_IN_FRAGMENT}"><fmt:message key="signin" bundle="${rb}"/></a></div>
</div>

</body>
</html>
