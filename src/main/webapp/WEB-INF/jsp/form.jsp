<%--
  Created by IntelliJ IDEA.
  User: workstation
  Date: 31/05/18
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register customer</title>
</head>
<body>
<form action="addAppoitment" method="post">
    <div>
        <label>Civility : </label>
        Civility:
        <select name="civility">
        <option value="Monsieur">Mr</option>
        <option value="Madame">Mme</option>
        </select>
    </div>

    <div>
    First name: <input type="text" name="fname" value="<c:out value="${param['fname']}" />">
    <span class="error"><c:out value="${errors['fname']}"/></span>
    </div>
    <div>
    Last name: <input type="text" name="lname" value="<c:out value="${param['lname']}" />">
    <span class="error"><c:out value="${errors['lname']}"/></span>
    </div>
    <div>
    <input type="checkbox" name="urgent" value="oui">Le rendez-vous demandé est-il urgent ?
    </div>
    <input type="submit" value="Submit">
</form>

<div>
    <a href="<c:url value="/"/>">Retour à l'accueil</a>
</div>

</body>
</html>