<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 05.12.2021
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="dream.store.DbStore" %>
<%@ page import="dream.models.Post" %>
<%@ page import="dream.models.Candidate" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<body>
<%
    String id = request.getParameter("id");
    Candidate candidate = new Candidate(0, "");
    if (id != null) {
        candidate = DbStore.instOf().findByIdCandidate(Integer.parseInt(id));
    }
%>
<div class="container pt-3">
    <jsp:include page="/menu.jsp" />
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новый кандидат.
                <% } else { %>
                Редактирование кандидата.
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/candidate.do?id=<%=candidate.getId()%>" method="post">
                    <div class="form-group">
                        <label>Имя</label>
                        <input type="text" class="form-control"  name="name" value="<%=candidate.getName()%>">
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
