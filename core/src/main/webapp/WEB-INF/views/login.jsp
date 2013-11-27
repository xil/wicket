<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Xil</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <%--<title><spring:message code="label.title" /></title>--%>
    <link href="<c:url value="/resources/css/bootstrap/bootstrap-responsive.min.css"/>" media="all" type="text/css"
          rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>" media="all" type="text/css"
          rel="stylesheet"/>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="<c:url value="/resources/js/lib/bootstrap/bootstrap.js"/>"></script>
    <style>
        .container {
            bottom: 0;
            height: 216px;
            left: 0;
            margin: auto;
            position: absolute;
            top: 0;
            right: 0;
            width: 300px;
        }

        #welcomeMess {
            text-align: center;
        }
    </style>
</head>
<body>

<%--<a href="<c:url value="" />">--%>
<%--<spring:message code="label.contacts" />--%>
<%--</a><br/>--%>

<%--<c:if test="${not empty param.error}">--%>
<%--<font color="red"> <spring:message code="label.loginerror" />--%>
<%--: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>--%>
<%--</c:if>--%>
<div class="container">
    <div class="row">
        <div class="span4 well">
            <legend id="welcomeMess">Welcome to Xil</legend>
            <c:if test="${not empty error}">
                <div class="alert alert-error">
                    <a class="close" data-dismiss="alert" href="#">×</a><spring:message code="label.loginerror"/>
                    : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                </div>
            </c:if>
            <form method="POST" action="<c:url value="/j_spring_security_check" />" accept-charset="UTF-8">
                <input type="text" id="username" class="span4" name="j_username" placeholder="Username">
                <input type="password" id="password" class="span4" name="j_password" placeholder="Password">
                <label class="checkbox">
                    <input type="checkbox" name="_spring_security_remember_me" value="1"> Remember Me
                </label>
                <button type="submit" name="submit" class="btn btn-info btn-block">Sign in</button>
            </form>
        </div>
    </div>
</div>


<%--<form method="POST" action="<c:url value="/j_spring_security_check" />">--%>


<%--<table>--%>
<%--<tr>--%>
<%--&lt;%&ndash;<td align="right"><spring:message code="label.login" /></td>&ndash;%&gt;--%>
<%--<td><input type="text" name="j_username"/></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--&lt;%&ndash;<td align="right"><spring:message code="label.password" /></td>&ndash;%&gt;--%>
<%--<td><input type="password" name="j_password"/></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--&lt;%&ndash;<td align="right"><spring:message code="label.remember" /></td>&ndash;%&gt;--%>
<%--<td><input type="checkbox" name="_spring_security_remember_me"/></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan="2" align="right"><input type="submit" value="Login"/>--%>
<%--<input type="reset" value="Reset"/></td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--</form>--%>
</body>
</html>