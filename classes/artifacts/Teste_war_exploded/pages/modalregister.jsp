<%--
  Created by IntelliJ IDEA.
  User: raul
  Date: 15/03/19
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modal Register</title>
</head>
<body>
<div class="modal fade" id="modalRegister" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h6 class="modal-title" id="exampleModalLabel">Sign up for a new lesson</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" class="my-5 ml-5" enctype="multipart/form-data" action="/controller?action=SavePost">
                    <div class="form-group">
                        <label for="recipient-title" class="col-form-label">Title:</label>
                        <input type="text" name="title" class="form-control" id="recipient-title">
                    </div>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Your Name:</label>
                        <input type="text" name="name" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="recipient-description" class="col-form-label">Description:</label>
                        <input type="text" name="description" class="form-control" id="recipient-description">
                    </div>
                    <table class="form-group">
                        <tr>
                            <td>
                                <label for="recipient-private" class="col-form-label">Exclusivity:</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="radio" name="exclusivity" id="recipient-private" value="private"><label> Private</label>
                            </td>
                        </tr>
                    </table>
                    <div class="form-group">
                        <label for="recipient-file" class="col-form-label">Video:</label>
                        <input type="file" name="video" class="form-control" id="recipient-file">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Exit</button>
                        <input type="submit" class="btn btn-primary" name="action" value="Save">
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
