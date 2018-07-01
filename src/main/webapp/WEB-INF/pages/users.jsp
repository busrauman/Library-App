<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>

</head>
<body>
	<div class="wrapper">
		<%@include file="../include/header.jsp"%>		
		<div class="container content margin-top">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="./users"><h2>
							<strong><fmt:message key="title.users" /></strong>
						</h2></a></li>
			</ol>

			<div class="list-group">
				<c:forEach items="${users }" var="user">
					<li href="./user/${user.id}"
						class="list-group-item list-group-item-action flex-column align-items-start " id="item_${user.id }">
						<a href="./user/${user.id}"
						class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">${user.firstname } &nbsp; ${user.lastname }</h5>
							 <small><fmt:message key="label.email" /> ${user.email}</small>
					</a><br/>
						 <small><fmt:message
									key="label.created.date" /> :<fmt:formatDate
									value="${user.createdDate.time}" type="both"
									pattern="dd/MM/yyyy" /></small>
						 <sec:authorize access="hasRole('ROLE_ADMIN')">
							<button type="button" class="btn btn-xs btn-danger pull-right"
								onclick="changeRoleToAdmin('${user.id}')"
								title="<fmt:message key='label.admin'/>">
								<span class="glyphicon glyphicon-transfer " aria-hidden="true"></span>
							</button>
							
						  </sec:authorize>
					</span>
					</li>
				</c:forEach>
			</div>
			<c:if test="${empty users }">
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
	function changeRoleToAdmin(id){
		swal({
			  title: '<fmt:message key="label.user.rol"/>',
			  text: '<fmt:message key="label.user.rol.onay"/>',
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
						url:"changeRoleToAdmin/"+id,
						method:"PUT",
						async:false,
						success:function(data){
							if(data){
								$("#item_"+id).remove();
								swal({
							    	position: 'top-right',
							    	text:'<fmt:message key="label.user.rol.basarili"/>',
								    type:'info',
							     	toast:true,
							     	timer:1500,
							     	showConfirmButton:false
							    });
								
							}else{
								swal({
							    	position: 'top-right',
							    	text:'<fmt:message key="label.user.rol.basarisiz"/>',
								    type:'danger',
							     	toast:true,
							     	timer:1500,
							     	showConfirmButton:false
							    });
							}
						},
						error:function(err){
							swal({
						    	position: 'top-right',
						    	text:'<fmt:message key="label.user.rol.hata"/>',
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