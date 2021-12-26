<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="dream.store.DbStore" %>
<%@ page import="dream.models.Post" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!doctype html>
<html lang="en">
<jsp:include page="header.jsp" />
<body>
<div class="container">
    <jsp:include page="menu.jsp" />
</div>
<div class="row">
    <div class="card" style="width: 100%">
        <div class="card-header">
            Сегодняшние вакансии.
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Названия</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Дата создания</th>
                </tr>
                </thead>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>
                            <c:out value="${post.name}"/>
                        </td>
                        <td>
                            <c:out value="${post.description}"/>
                        </td>
                        <td>
                            <fmt:parseDate value="${post.created}" pattern="yyyy-MM-dd'T'HH:mm" var="parseCreated"/>
                            <fmt:formatDate value="${parseCreated}" pattern="dd.MM.yyyy HH:mm"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<div class="row pt-3">
    <div class="card" style="width: 100%">
        <div class="card-header">
            Сегодняшние кандидаты.
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Имя</th>
                    <th scope="col">Фото</th>
                    <th scope="col">Город</th>
                    <th scope="col">Дата создания</th>
                </tr>
                </thead>
                <c:forEach items="${candidates}" var="candidate">
                    <tr>
                        <td>
                            <c:out value="${candidate.name}"/>
                        </td>
                        <td>
                            <img src="<c:url value='/download?name=${candidate.id}.png'/>" width="100px" height="100px"/>
                        </td>
                        <td>
                            <c:forEach items="${cities}" var="city">
                                <c:if test="${city.id == candidate.cityId}">
                                    <c:out value="${city.name}"/>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <fmt:parseDate value="${candidate.created}" pattern="yyyy-MM-dd'T'HH:mm" var="parseCreated"/>
                            <fmt:formatDate value="${parseCreated}" pattern="dd.MM.yyyy HH:mm"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</div>

</body>
</html>