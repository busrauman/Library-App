<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<script type="text/javascript">
$(document).ready(function() {
	validateForm.initValidateForm();
});

var validateForm = function() {
	return {
		initValidateForm : function() {
			// Validation
			$('#author-form').validate({
				// Rules for form validation
				rules : {
					firstname : {
						required : true
					},
					lastname : {
						required : true
					},
					description : {
						required : true					
					},
					
				},
				// Do not change code below
				errorPlacement : function(error, element) {
					error.insertAfter(element.parent());
				}
			});
		}
	};
}();
</script>
</head>
<body>
	<div class="wrapper">
		<%@include file="../include/header.jsp"%>
		
		<div class="container content margin-top">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="./author" ><h2><strong><fmt:message key="title.yazar.detay"/></strong></h2></a></li>
			</ol>
			<div class="panel-body">
				<c:choose>
					<c:when test="${not empty author }">
						<div class="tab-pane fade in active">

							<div class="table-responsive panel">
								<table class="table">
									<tbody>

										<tr>
											<td class="text-success"><i class="fa fa-user"></i> <fmt:message
													key="label.ad" /></td>
											<td>${author.name }</td>
										</tr>
										<tr>
											<td class="text-success"><i class="fa fa-list-ol"></i> <fmt:message
													key="label.aciklama" /></td>
											<td>${author.description}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="jumbotron jumbotron-fluid">
							<div class="container">
								<h4 class="display-4">
									<fmt:message key="warning.kayit.bulunamadi" />
								</h4>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>