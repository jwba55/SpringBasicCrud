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
			<h3>Book (${pager.total})</h3>
		</div>
	</div>
	<div class="container">
      <div class="row">
          <div class="col-lg-12 card-margin">
              <div class="card search-form">
                  <div class="card-body p-0">
                      <form id="search-form">
                          <div class="row">
                              <div class="col-12">
                                  <div class="row no-gutters">
                                      <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                          <select class="form-control" id="exampleFormControlSelect1" name="search">
                                              	<option value="1">bookid</option>
			                                    <option value="2">bookname</option>
			                                    <option value="3">publisher</option>
                                          </select>
                                      </div>
                                      <div class="col-lg-8 col-md-6 col-sm-12 p-0">
                                          <input type="text" placeholder="Search..." class="form-control" id="search" name="keyword">
                                      </div>
                                      <div class="col-lg-1 col-md-3 col-sm-12 p-0">
                                          <button type="submit" class="btn btn-base">
                                              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg>
                                          </button>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </form>
                  </div>
              </div>
          </div>
      </div>         
   </div>

	
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>bookid</th>
					<th>bookname name</th>
					<th>publisher</th>
					<th>price</th>
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
					<!-- EL 동작 원리: book객체를 item이라고 명명했기에 item에 해당하는 book객체를 찾고 거기에 getter를 호출해서 값을 가져옴. -->
						<td>${item.bookid}</td>
						<td>${item.bookname}</td>
						<td>${item.publisher}</td>
						<td>${item.price}</td>
						<td>
							<!-- 오버헤드가 발갱 -->
							<!-- <a href="update/bookid=${item.bookid}">update</a>	 파라미더로 되어있어서 파라미터로 읽을수 있음 -->
							<a href="update/${item.bookid}">update</a>
							<!-- 오버헤드가 적음 -->
							<a href="delete/${item.bookid}">delete</a>		<!-- pathvariable을 사용해야함. 경로에 있는 값을 꺼내서 사용해야함. -->
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
			<tfoot>
				<tr>
					<td>
						<!-- form태그에 action값을 주지 않았던 것처럼 현재 주소의 값에서 주소에 그저 값을 추가해주는 정도 -->
						<div>
							<div><a href="?page=1${pager.query}">처음</a></div>
							<div><a href="?page=${pager.prev}${pager.query}">이전</a></div>
							<!-- 페이지를 얼마나 보여주고 얼마나? 어떻게? 제어할 것인가? -->
					       	<div>
					        	<c:forEach var="page" items="${pager.list}">
					        		<li class="page-item ${pager.page == page ? 'active' : ''}">
					            	
					           		<a href="?page=${page}${pager.query}">${page}</a>
					        		</li>
					       		</c:forEach>
					    	</div>
							<!-- 다음을 눌렀을때 어디로 이동할 것인가? 현재 페이지가 속해있는 그룹의 다음 그룹 속 첫 페이지로 넘어가는 것이 UX적으로 가장 합리적이라고 생각함. -->
							<div><a href="?page=${pager.next}${pager.query}">다음</a></div>
							<!-- last라는 필드가 있든 없든 상관이 없음. getter를 이용햇 last를 호출할 뿐임. -->
							<div><a href="?page=${pager.last}${pager.query}">마지막</a></div>
						</div>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
	
	
	<div>
		<div><a href="add">등록</a></div>
		<div><a href="dummy">대량등록</a></div>
		<div><a href="init">직전 등록 정보 롤백</a></div>
		<div><a href="..">이전</a></div>
	</div>
</body>
</html>