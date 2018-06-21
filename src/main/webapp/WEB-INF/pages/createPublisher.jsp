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
			$('#publisher-form').validate({
				// Rules for form validation
				rules : {
					name : {
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
				<li class="breadcrumb-item"><a href="./publisher" ><h2><strong><fmt:message key="title.yayinevi.form"/></strong></h2></a></li>
			</ol>
			<form:form modelAttribute="publisher" action="./publisher" method="post" id="publisher-form">
				<form:hidden path="id" id="id" />
				<form:errors path="*"/>

				<div class=" form-group">

					<div class="">
						<label><fmt:message key="label.yayinevi.adi" /></label>
						<form:input type="text" path="name" placeholder=""
							class="form-control" />
					</div>
				</div>
				<div class=" form-group">
					<div>
						<label><fmt:message key="label.yayinevi.aciklama" /></label>
						<form:textarea rows="5" cols="40" path="description"
							class="form-control" />
					</div>
				</div>
				<button type="submit" class="btn btn-success pull-right"><fmt:message key="button.submit"/></button>
			</form:form>
			<!-- /.row -->
		</div>
	</div>
</body>
</html>