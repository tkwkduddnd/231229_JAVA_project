<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="Common.css">
    <link rel="stylesheet" type="text/css" href="Admin.css?after">
</head>
<body>

    <jsp:include page="AdminNav.jsp" />

    <section>
        <div class="admin-content">
            <h2>관리자님, 여행 상품을 추가, 수정, 삭제하세요.</h2>
        </div>
    </section>

    <jsp:include page="footer.jsp" />

</body>
</html>
