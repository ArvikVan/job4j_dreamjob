<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 14.12.2021
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!doctype html>
<html lang="en">
<jsp:include page="header.jsp" />
<body>
<div class="container pt-3">
    <div class="container">
        <jsp:include page="menu.jsp" />
    </div>
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
                        <th scope="col">Описание</th>
                        <th scope="col">Дата создания</th>
                        <th scope="col">Удалить</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${posts}" var="posts">
                        <tr>
                            <td>
                                <a href='<c:url value="/post/edit.jsp?id=${posts.ID}"/>'>
                                    <i class="fa fa-edit mr-3"></i>
                                </a>
                                <c:out value="${posts.name}"/>
                            </td>
                            <td>
                                <c:out value="${posts.description}"/>
                            </td>
                            <td>
                                <fmt:parseDate value="${posts.created}" pattern="yyyy-MM-dd'T'HH:mm" var="parseCreated"/>
                                <fmt:formatDate value="${parseCreated}" pattern="dd.MM.yyyy HH:mm"/>
                            </td>
                            <td>
                                <form action="<c:url value='/deletepost?id=${posts.ID}'/>" method="post" enctype="multipart/form-data">
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
