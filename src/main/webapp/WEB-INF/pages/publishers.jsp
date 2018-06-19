<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<script>
	function deletePublisher(id) {
		$.ajax({
			url : 'publisher/' + id,
			type : 'DELETE',
			success : function(data) {
				alert("ok");
			},
			error : function(err) {
				alert("err");

			}
		});
	}
</script>
</head>
<body>
	<div class="wrapper">
		<%@include file="../include/header.jsp"%>
		<div class="container content margin-top">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="./publishers"><h2>
							<strong><fmt:message key="title.yayinevi.listesi" /></strong>
						</h2></a></li>
			</ol>

			<div class="list-group">
				<c:forEach items="${publishers }" var="publisher">
					<li href="./publisher/${publisher.id}"
						class="list-group-item list-group-item-action flex-column align-items-start">
						<a href="./publisher/${publisher.id}"
						class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">${publisher.name }</h5> <small><fmt:message
									key="label.created.date" /> :<fmt:formatDate
									value="${publisher.createdDate.time}" type="both"
									pattern="dd/MM/yyyy" /></small>
					</a>
						<p class="mb-1"></p>
						<small>${publisher.description }</small> <span class="pull-right">
							<button type="button" class="btn btn-xs btn-danger"
								onclick="deletePublisher('${publisher.id}')"
								title="<fmt:message key='label.sil'/>">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</button>
							<button type="button" class="btn btn-xs btn-warning" onclick=""
								title="<fmt:message key='label.duzenle'/>">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</button>
					</span>
					</li>
				</c:forEach>
			</div>
			<c:if test="${empty publishers }">
				<div class="jumbotron jumbotron-fluid">
					<div class="container">
						<h4 class="display-4">Kayıt Bulunamadı</h4>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>