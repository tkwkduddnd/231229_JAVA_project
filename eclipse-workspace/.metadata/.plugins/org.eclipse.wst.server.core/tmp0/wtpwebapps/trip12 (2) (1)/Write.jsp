<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 작성</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="Write.css?after">
</head>
<body>
	<section id ="reviewWtire">
    <div class="container">
        <h2>글 작성 페이지</h2>
        <form action="WriteServlet" method="post">
            <label for="title">제목</label>
            <input type="text" id="title" name="title">
            
            <label for="content">내용</label>
            <textarea id="content" name="content"></textarea>
            
            <input type="submit" value="제출">
        </form>
    </div>
    <br>
    <br>
    </section>
</body>
</html>
