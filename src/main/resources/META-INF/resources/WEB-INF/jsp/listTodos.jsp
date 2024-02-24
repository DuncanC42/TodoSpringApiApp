<%@ include file="common/navigation.jspf"%>
<%@ include file="common/header.jspf"%>

<div class="container">
    <table class="table">
        <thead>
        <tr>
<%--            <th>id</th>--%>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done ?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
<%--                <td>${todo.id}</td>--%>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-info">UPDATE</a></td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf"%>
