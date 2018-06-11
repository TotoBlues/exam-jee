<%--
  Created by IntelliJ IDEA.
  User: workstation
  Date: 11/06/18
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <c:forEach items="${myList}" var="myList">
        <tr>
            <td>${myList.civility}</td>
            <td>${myList.lname}</td>
            <td>${myList.fname}</td>
            <td>${empty myList.urgent ? '' : 'Rendez-vous urgent !!' }</td>
            <td><a href="<c:url value="/deleteAppoitment?lname=${myList.lname}&fname=${myList.fname}"/>">Supprimer le rendez-vous</a></td>
        </tr>
        </c:forEach>
    </table>
    <br>
    <a href="<c:url value="/"/>">Retour à l'accueil</a>

</body>
</html>
