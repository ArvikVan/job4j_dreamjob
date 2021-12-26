<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 08.12.2021
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="dream.models.User" %>
<%@ page import="dream.models.Candidate" %>
<%@ page import="dream.store.MemStore" %>
<%@ page import="dream.store.DbStore" %>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
    <table class="table">
        <thead>
        <a class="nav-link" href="<%=request.getContextPath()%>/candidates.jsp">Back</a>
        <tr>
            <th>URL</th>
            <th>View</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${images}" var="image" varStatus="status">
            <tr valign="top">
                <td><a href="<c:url value='/download?name=${image}'/>">Download</a></td>
                <td>
                    <img src="<c:url value='/download?name=${image}'/>" width="100px" height="100px"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%
        String id = request.getParameter("id");
        Candidate cnd = new Candidate(0, "");
        if (id != null) {
            cnd = DbStore.instOf().findByIdCandidate(Integer.valueOf(id));
        }
    %>
    <h2>Upload image</h2>
    <form action="<%=request.getContextPath()%>/upload?id=<%=request.getParameter("id")%>" method="post" enctype="multipart/form-data">
        <div class="checkbox">
            <input type="file" name="file">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>
