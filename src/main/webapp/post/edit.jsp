<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 05.12.2021
  Time: 19:49
  To change this template use File | Settings | File Templates.
  Обратите внимание я добавить к тегу input аттрибут name="name".
  Это значит, что в запросе на сервер нужно отправить содержимое этого поля с ключом name.
  В форму добавим id.
    <form action="<%=request.getContextPath()%>/post/save?id=<%=post.getId()%>" method="post">
    В поле name загрузим имя.
    <input type="text" class="form-control" name="name" value="<%=post.getName()%>">
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="dream.store.DbStore" %>
<%@ page import="dream.models.Post" %>
<%@ page import="java.time.LocalDateTime" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<body>
<%
    String id = request.getParameter("id");
    Post post = new Post(0, "", "", LocalDateTime.now());
    if (id != null) {
        post = DbStore.instOf().findByIdPost(Integer.parseInt(id));
    }
%>
<div class="container pt-3">
    <c:import url="/menu.jsp" />
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новая вакансия.
                <% } else { %>
                Редактирование вакансии.
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/post.do?id=<%=post.getID()%>" method="post">
                    <div class="form-group">
                        <label>Название вакансии</label>
                        <input type="text" class="form-control" id="namePost" name="name" required value="<%=post.getName()%>"
                               title="Введите название вакансии" placeholder="Введите название вакансии"/>
                    </div>
                    <div class="form-group">
                        <label>Описание</label>
                        <input type="text" class="form-control" name="description" required  value="<%=post.getDescription()%>"
                               id="description" title="Введите описание" placeholder="Введите описание вакансии"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

