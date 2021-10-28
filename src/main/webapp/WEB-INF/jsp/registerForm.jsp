<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserForm</title>
</head>
<body>
<form action="registerUser.java" method="post" >
<p>ログインID：</p><input type="text" name="id" >
<p>パスワード：</p><input type="text" name="pass">
<p>名前：</p><input type ="text" name="name">
<input type="submit" name="submit-btn" value="送信">

</form>

</body>
</html>