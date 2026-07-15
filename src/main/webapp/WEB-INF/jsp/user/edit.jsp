<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>编辑用户</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
            background: #f5f7fa;
            padding: 20px;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            background: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #4a5568;
            font-weight: 500;
        }
        input, select {
            width: 100%;
            padding: 12px 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }
        input:focus, select:focus {
            outline: none;
            border-color: #667eea;
        }
        .btn {
            padding: 12px 30px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            color: white;
            font-size: 14px;
            margin-right: 10px;
        }
        .btn-primary { background: #667eea; }
        .btn-secondary { background: #718096; }
        .btn:hover { opacity: 0.9; }
        .actions {
            text-align: center;
            margin-top: 30px;
        }
        input[type="hidden"] {
            display: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>编辑用户</h1>
        <form action="user_update" method="post">
            <input type="hidden" name="user.id" value="${user.id}">
            <div class="form-group">
                <label>用户名</label>
                <input type="text" name="user.username" value="${user.username}" required>
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="password" name="user.password" value="${user.password}">
            </div>
            <div class="form-group">
                <label>邮箱</label>
                <input type="email" name="user.email" value="${user.email}">
            </div>
            <div class="form-group">
                <label>手机</label>
                <input type="text" name="user.phone" value="${user.phone}">
            </div>
            <div class="form-group">
                <label>状态</label>
                <select name="user.status">
                    <option value="1" ${user.status == 1 ? 'selected' : ''}>正常</option>
                    <option value="0" ${user.status == 0 ? 'selected' : ''}>禁用</option>
                </select>
            </div>
            <div class="actions">
                <button type="submit" class="btn btn-primary">更新</button>
                <a href="user_list" class="btn btn-secondary">返回</a>
            </div>
        </form>
    </div>
</body>
</html>
