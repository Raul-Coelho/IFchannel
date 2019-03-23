<%--
  Created by IntelliJ IDEA.
  User: raul
  Date: 16/03/19
  Time: 07:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modal Comment</title>
</head>
<body>
<div class="modal fade" id="modalComment" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                    <tr>
                        <td><label>Name:</label></td>
                        <td><label>VIDEO BOM</label></td>
                    </tr>
                    <tr>
                        <td><label>Name:</label></td>
                        <td><label>VIDEO BOM D+</label></td>
                    </tr>
                    <tr>
                        <td><label>Name:</label></td>
                        <td><label>THE GREAT</label></td>
                    </tr>
                    <tr>
                        <td><label>Name:</label></td>
                        <td><label>THE GREAT</label></td>
                    </tr>
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
