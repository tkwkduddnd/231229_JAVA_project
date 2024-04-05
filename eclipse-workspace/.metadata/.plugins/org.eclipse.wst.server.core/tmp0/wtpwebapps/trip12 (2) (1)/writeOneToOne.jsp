<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1:1 문의 글쓰기</title>
    <link rel="stylesheet" href="writeOneToOne.css">
</head>
<body>
    <!-- 헤더 섹션: 여행사 이름 표시 -->
    <header>
        <h1>NH 여행</h1>
    </header>

    
    <nav>
        <!-- 네비게이션 코드는 여기에 삽입 -->
    </nav>

    <!-- 글쓰기 섹션: 1:1 문의 글 작성 폼 -->
    <section id="formSection" style="display: none;">
        <h2 style="margin-bottom: 20px;">1:1 문의 글쓰기</h2>
        
        <!-- 글 작성 폼: 제목 입력란 -->
        <form action="WriteOneToOneServlet" method="post">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" required>

            <!-- 글 작성 폼: 내용 입력란 -->
            <label for="content">내용</label>
            <textarea id="content" name="content" rows="8" required></textarea>

            <!-- 글 작성 폼: 제출 버튼 -->
            <input type="submit" value="제출">
        </form>
    </section>

    <!-- 푸터 섹션: 저작권 정보 표시 -->
    <footer>
        © 2023 여행사. All Rights Reserved.
    </footer>
</body>
</html>
