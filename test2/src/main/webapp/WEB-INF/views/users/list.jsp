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
			<h3>Customer</h3>
		</div>
	</div>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>custId</th>
					<th>customer name</th>
					<th>address</th>
					<th>phone</th>
				</tr>
			</thead>
			
			<tbody>
				<!-- list에 담긴 내용이 없을 시 -->
				<c:if test="${list.size() < 1}">
					<tr>
						<td colspan="4">검색된 고객이 없습니다.</td>
					</tr>
				</c:if>
				
				<!-- list에 담긴 모든 것들 출력 -->
				<c:forEach var="item" items="${list}">
					<tr>
						<td>${item.custId}</td>
						<td>${item.name}</td>
						<td>${item.address}</td>
						<td>${item.phone}</td>
						<td>
							<!-- 오버헤드가 발갱 -->
							<!-- <a href="update/bookid=${item.bookid}">update</a>	 파라미더로 되어있어서 파라미터로 읽을수 있음 -->
							<a href="update/${item.custId}">update</a>
							<!-- 오버헤드가 적음 -->
							<a href="delete/${item.custId}">delete</a>		<!-- pathvariable을 사용해야함. 경로에 있는 값을 꺼내서 사용해야함. -->
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div>
		<div><a href="add">등록</a></div>
		<div><a href="..">이전</a></div>
	</div>
</body>
</html>