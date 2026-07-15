<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加用户</title>
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
        input {
            width: 100%;
            padding: 12px 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }
        input:focus {
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
    </style>
</head>
<body>
    <div class="container">
        <h1>添加用户</h1>
        <form action="user_save" method="post">
            <div class="form-group">
                <label>用户名</label>
                <input type="text" name="user.username" required>
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="password" name="user.password" required>
            </div>
            <div class="form-group">
                <label>邮箱</label>
                <input type="email" name="user.email">
            </div>
            <div class="form-group">
                <label>手机</label>
                <input type="text" name="user.phone">
            </div>
            <div class="actions">
                <button type="submit" class="btn btn-primary">保存</button>
                <a href="user_list" class="btn btn-secondary">返回</a>
            </div>
        </form>
    </div>
</body>
</html>
