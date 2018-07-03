<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>

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
			<div class="panel-body">
				<form action="/library/publisher/search" method="GET">
					<div class="">
						<div class="">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Yayın evi adı ile arama yapabilirsiniz "
									name="search" />
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
				<c:forEach items="${publishers }" var="publisher">
					<li href="${publisher.id}"
						class="list-group-item list-group-item-action flex-column align-items-start "
						id="item_${publisher.id }"><a
						href="./publisher/${publisher.id}"
						class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">${publisher.name }</h5> <small><fmt:message
									key="label.created.date" /> :<fmt:formatDate
									value="${publisher.createdDate.time}" type="both"
									pattern="dd/MM/yyyy" /></small>
					</a>
						<p class="mb-1"></p> <small>${publisher.description }</small> <span
						class="pull-right"> <sec:authorize
								access="hasRole('ROLE_ADMIN')">
								<button type="button" class="btn btn-xs btn-danger"
									onclick="deletePublisher('${publisher.id}')"
									title="<fmt:message key='label.sil'/>">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</button>
							</sec:authorize> <a type="button" href="publisher?id=${publisher.id }"
							class="btn btn-xs btn-warning"
							title="<fmt:message key='label.duzenle'/>"> <span
								class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</a>
					</span></li>
				</c:forEach>
			</div>
			<c:if test="${empty publishers }">
				<div class="jumbotron jumbotron-fluid">
					<div class="container">
						<h4 class="display-4">
							<fmt:message key="warning.kayit.bulunamadi" />
						</h4>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</body>

<script>
	function deletePublisher(id) {
		
		swal({
			  title: '<fmt:message key="label.sil.onay"/>',
			  text: '<fmt:message key="label.sil.eminmisiniz"/>',
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#d33',
			  cancelButtonColor:'#2ecc71' ,
			  cancelButtonText: '<fmt:message key="label.vazgec"/>',
			  confirmButtonText : '<fmt:message key="label.evet"/>',
			  confirmButtonClass: 'btn btn-danger',
			  cancelButtonClass: 'btn btn-success'
			}).then((result)=>{
			  if (result.value) {
					$.ajax({
						url : 'publisher/' + id,
						type : 'DELETE',
						success : function(data) {
							$("#item_"+id).remove();
							swal({
						    	position: 'top-right',
						    	text:'<fmt:message key="label.silme.basarili"/>',
							    type:'success',
						     	toast:true,
						     	timer:1500,
						     	showConfirmButton:false
						    });
						},
						error : function(err) {
							alert("err");
							swal({
						    	position: 'top-right',
						    	text:'<fmt:message key="label.silme.hata"/>',
							    type:'danger',
						     	toast:true,
						     	timer:1500,
						     	showConfirmButton:false
						    });
						}
					});
			  }
			})

	}
</script>
</html>