<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>

</head>
<body>
	<div class="wrapper">
		<%@include file="../include/header.jsp"%>
		<div class="container content margin-top">
			<ol class="breadcrumb">
				<li class="breadcrumb-item">
				</li>
			</ol>
			<div class="panel-body">
				<form action="/library/book/search" method="GET"> 
					  <div class="">
					    <div class="col-md-12">
					      <div class="input-group">
					        <input type="text" class="form-control" placeholder="ISBN, Kitap Adı.."  name="search"/>
					        <div class="input-group-btn">
					          <button class="btn btn-primary" type="submit">
					            <span class="glyphicon glyphicon-search"></span>
					          </button>
					        </div>
					      </div>
					    </div>
					  </div>
					</form>
			</div>
			<div class="list-group">
				<c:forEach items="${books }" var="book">
					<li href="${book.id}"
						class="list-group-item list-group-item-action flex-column align-items-start " id="item_${book.id }">
						<a href="${book.id}"
						class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">${book.name }</h5> <small><fmt:message
									key="label.created.date" /> :<fmt:formatDate
									value="${book.createdDate.time}" type="both"
									pattern="dd/MM/yyyy" /></small>
					</a>
						<p class="mb-1"><small>${book.description }</small> <span class="pull-right">
						</p>
						 <sec:authorize access="hasRole('ROLE_ADMIN')">
							<button type="button" class="btn btn-xs btn-danger"
								onclick="deleteBook('${book.id}')"
								title="<fmt:message key='label.sil'/>">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</button>
						  </sec:authorize>
							<a type="button" href="book?id=${book.id }" class="btn btn-xs btn-warning" 
								title="<fmt:message key='label.duzenle'/>">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</a>
					</span>
					</li>
				</c:forEach>
			</div>
			<c:if test="${empty books }">
				<div class="jumbotron jumbotron-fluid">
					<div class="container">
						<h4 class="display-4"><fmt:message key="warning.kayit.bulunamadi"/></h4>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</body>

<script>
	
</script>
</html>