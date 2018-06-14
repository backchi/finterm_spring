<%--
  Created by IntelliJ IDEA.
  User: ekgml
  Date: 2018-06-14
  Time: 오후 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="/signUpProc" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="id">아이디</label>
            <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요.">
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요.">
        </div>
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요.">
        </div>
        <div class="form-group">
            <label for="tel">전화번호</label>
            <input type="text" class="form-control" id="tel" name="tel" placeholder="전화번호를 입력하세요.">
        </div>

        <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
</div>
</body>
</html>
