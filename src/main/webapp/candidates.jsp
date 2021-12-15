<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 14.12.2021
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<jsp:include page="header.jsp" />
<body>

<div class="container pt-3">
    <jsp:include page="menu.jsp" />
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Кандидаты
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Названия</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${candidates}" var="candidate">
                        <tr>
                            <td>
                                <a href='<c:url value="/candidate/edit.jsp?id=${candidate.id}"/>'>
                                    <i class="fa fa-edit mr-3"></i>
                                </a>
                                <c:out value="${candidate.name}"/>
                            </td>
                            <td>
                                <form action="<c:url value='/upload?id=${candidate.id}'/>" method="post" enctype="multipart/form-data">
                                    <button type="submit" class="btn btn-default">Добавить фото</button>
                                </form>
                                <form action="<c:url value='/delete?id=${candidate.id}'/>" method="post" enctype="multipart/form-data">
                                    <button type="submit" class="btn btn-default">DELETE</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">Back</a>
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
