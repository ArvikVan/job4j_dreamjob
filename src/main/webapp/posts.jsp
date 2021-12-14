<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 14.12.2021
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="dream.store.DbStore" %>
<%@ page import="dream.models.Post" %>
<%@ page import="java.util.Collection" %>
<!doctype html>
<html lang="en">
<jsp:include page="header.jsp" />
<body>
<div class="container pt-3">
    <jsp:include page="menu.jsp" />
    <div class="row">

        <div class="card" style="width: 100%">

            <div class="card-header">
                Вакансии
            </div>

            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Названия</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${posts}" var="post">
                        <tr>
                            <td>
                                <a href='<c:url value="/post/edit.jsp?id=${post.ID}"/>'>
                                    <i class="fa fa-edit mr-3"></i>
                                </a>
                                <c:out value="${post.name}"/>
                            </td>
                            <td>
                                <form action="<c:url value='/deletepost?id=${post.ID}'/>" method="post" enctype="multipart/form-data">
                                    <button type="submit" class="btn btn-default">DELETE</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

    </div>

</div>
</body>
</html>

</body>
</html>
