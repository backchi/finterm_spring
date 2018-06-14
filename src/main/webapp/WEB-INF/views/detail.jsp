<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시글</title>
</head>
    <body>
      <h2> 게시글 상세 </h2>

        <div class="container">
            <form action="/list" method="post">
                <div class="form-group">
                    <label>제목 ${detail.title}</label>
                    <%--<p></p>--%>
                </div>
                <div class="form-group">
                    <%--<label>사진</label>--%><img src="/image?url=${detail.fileurl}${detail.filename}" alt="/">
                </div>
                <div class="form-group">
                    <label>내용 :</label> ${detail.content}
                    <%--<p></p>--%>
                </div>

                <core:if test="${sessionScope.login ne null && sessionScope.login.id eq detail.username}">
                </core:if>

            </form>
            <button class="btn btn-primary" onclick="location.href='/update/${detail.id}'">수정</button>
            <button class="btn btn-danger" onclick="location.href='/delete/${detail.id}'">삭제</button>
        </div>
    <button type="submit" class="btn btn-primary" onclick="location.href='/list/'">홈으로</button>
</body>
</html>
