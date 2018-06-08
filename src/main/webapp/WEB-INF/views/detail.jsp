<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2> 게시글 상세 </h2>

<div class="container">
    <form action="/list" method="post">
        <div class="form-group">
            <label>제목</label>
            <p>${detail.title}</p>
        </div>
        <div class="form-group">
            <label>내용</label>
            <p>${detail.content}</p>
        </div>
        <button type="submit" class="btn btn-primary">홈으로</button>
    </form>
</div>
</body>
</html>
