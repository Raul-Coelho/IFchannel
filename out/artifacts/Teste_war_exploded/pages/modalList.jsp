<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ifpb.controller.servico.PostService" %>
<%@ page import="com.ifpb.model.entidades.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ifpb.model.entidades.User" %>
<%--
  Created by IntelliJ IDEA.
  User: raul
  Date: 15/03/19
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modal List</title>
    <%
        try {

            User user = (User) session.getAttribute("user");
            PostService service = new PostService();
            List<Post> posts = (List<Post>) service.list(user.getId());

            request.setAttribute("posts", posts);

        }catch (Exception e){
            e.printStackTrace();
        }
    %>
</head>
<body>
<div class="modal fade" id="modalList" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h6 class="modal-title" id="exampleModalLabel">List of Publications</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <thead>
                    </thead>
                    <tbody>
                    <c:forEach var="post" items="${posts}">
                        <tr>
                            <td>
                                <c:out value="${sessionScope.post.title}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Exit</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
