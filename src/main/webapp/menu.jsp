<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 14.12.2021
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
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
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> <c:out value="${user.name}"/> | Выйти</a>
        </li>
    </ul>
</div>