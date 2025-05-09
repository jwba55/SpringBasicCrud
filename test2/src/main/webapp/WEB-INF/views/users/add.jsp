<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<h3>add customer</h3>
		</div>
		<div>
			<form method="post">	<!-- action 값이 없기 때문에 이 페이지에 대해서의 주소를 처리 -->
				<div>
					<div><label>customer name:</label></div>
					<div><input type="text" name="name"></div>
				</div>
				<div>
					<div><label>address:</label></div>
					<div><input type="text" name="address"></div>
				</div>
				<div>
					<div><label>phone:</label></div>
					<div><input type="number" name="phone"></div>
				</div>
				
				<div>
					<div><button type="submit">submit</button></div>	<!-- 기본적으로 버튼이 폼태그 안에 있으면 타입이 submit이 됨 -->
					<div><a href="list"><button type="button">back</button></a></div>	<!-- 취소 버튼이 등록이 되면 안되기 때문에 버튼의 타입을 버튼으로 지정해줌 -->
				</div>
			</form>
		</div>

	</div>

</body>
</html>