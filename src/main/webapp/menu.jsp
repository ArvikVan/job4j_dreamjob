<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 14.12.2021
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<div class="row">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/post.do">Вакансии</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/candidate.do">Кандидаты</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/post/edit.jsp">Добавить вакансию</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/candidate/edit.jsp">Добавить кандидата</a>
        </li>
        <c:if test="${user != null}">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/logout.do">
                    <c:out value='${user.name}'/> | Выйти</a>
            </li>
        </c:if>
    </ul>
</div>