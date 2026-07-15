<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户列表</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
            background: #f5f7fa;
            padding: 20px;
        }
        .container {
            max-width: 1000px;
            margin: 0 auto;
        }
        .header {
            background: white;
            padding: 20px 30px;
            border-radius: 8px;
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 { color: #333; }
        .search-box {
            display: flex;
            gap: 10px;
        }
        .search-box input {
            padding: 8px 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 200px;
        }
        .btn {
            padding: 8px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            color: white;
            font-size: 14px;
        }
        .btn-primary { background: #667eea; }
        .btn-success { background: #48bb78; }
        .btn-danger { background: #f56565; }
        .btn-warning { background: #ed8936; }
        .btn:hover { opacity: 0.9; }
        table {
            width: 100%;
            background: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 15px 20px;
            text-align: left;
            border-bottom: 1px solid #eee;
        }
        th {
            background: #f7fafc;
            font-weight: 600;
            color: #4a5568;
        }
        tr:hover { background: #f7fafc; }
        .actions {
            display: flex;
            gap: 5px;
        }
        .actions a {
            padding: 5px 10px;
            border-radius: 3px;
            font-size: 12px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>用户列表</h1>
            <div class="search-box">
                <form action="user_list" method="get">
                    <input type="text" name="keyword" value="${keyword}" placeholder="搜索用户名/邮箱/手机">
                    <button type="submit" class="btn btn-primary">搜索</button>
                </form>
            </div>
        </div>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>用户名</th>
                    <th>邮箱</th>
                    <th>手机</th>
                    <th>状态</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td>${user.status == 1 ? '正常' : '禁用'}</td>
                        <td>${user.createTime}</td>
                        <td class="actions">
                            <a href="user_edit?id=${user.id}" class="btn btn-warning">编辑</a>
                            <a href="javascript:void(0)" onclick="deleteUser(${user.id})" class="btn btn-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty userList}">
                    <tr>
                        <td colspan="7" style="text-align: center; padding: 40px;">
                            暂无数据，<a href="user_add" style="color: #667eea;">添加用户</a>
                        </td>
                    </tr>
                </c:if>
            </tbody>
        </table>

        <div style="margin-top: 20px; text-align: center;">
            <a href="user_add" class="btn btn-success">添加用户</a>
            <a href="/" class="btn btn-primary">返回首页</a>
        </div>
    </div>

    <script>
        function deleteUser(id) {
            if (confirm('确定要删除该用户吗?')) {
                // 简单的AJAX请求
                fetch('user_delete?id=' + id, {
                    method: 'POST'
                })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        alert(data.message);
                        location.reload();
                    } else {
                        alert(data.message);
                    }
                });
            }
        }
    </script>
</body>
</html>
