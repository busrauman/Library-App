<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>

</head>
<body>
	<div class="wrapper">
		<%@include file="../include/header.jsp"%>
		<div class="container content margin-top">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="./books"><h2>
							<strong><fmt:message key="title.yayinevi.listesi" /></strong>
						</h2></a></li>
			</ol>

			<div class="list-group">
				<c:forEach items="${books }" var="book">
					<li href="./book/${book.id}"
						class="list-group-item list-group-item-action flex-column align-items-start " id="item_${book.id }">
						<a href="./book/${book.id}"
						class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">${book.name }</h5> <small><fmt:message
									key="label.created.date" /> :<fmt:formatDate
									value="${book.createdDate.time}" type="both"
									pattern="dd/MM/yyyy" /></small>
					</a>
						<p class="mb-1"></p>
						<small>${book.description }</small> <span class="pull-right">
							<button type="button" class="btn btn-xs btn-danger"
								onclick="deleteBook('${book.id}')"
								title="<fmt:message key='label.sil'/>">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</button>
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
	function deleteBook(id) {
		
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
						url : 'book/' + id,
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