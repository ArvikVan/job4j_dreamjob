<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="dream.store.DbStore" %>
<%@ page import="dream.models.Post" %>
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
        </div>
    </div>
</div>
<div class="row pt-3">
    <div class="card" style="width: 100%">
        <div class="card-header">
            Сегодняшние кандидаты.
        </div>
        <div class="card-body">
        </div>
    </div>
</div>
</body>
</html>