<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아웃스타그램</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>

<!-- 인클루드 top -->
<%@ include file="top.jspf" %>

    <h2> 게시글 목록 </h2>


    <div class="container">
        <table class="table table-hover">
            <tr>
                <th>No</th>
                <th>Title</th>
                <th>Content</th>
            </tr>
              <c:forEach var="l" items="${list}">
                  <tr onclick="location.href='/detail/${l.id}'">
                      <td>${l.id}</td>
                      <td>${l.title}</td>
                      <td>${l.content}</td>
                  </tr>
              </c:forEach>

        </table>
    </div>
    <button class="btn btn-primary" onclick="location.href='/insert'">글쓰기</button>
</body>
</html>

