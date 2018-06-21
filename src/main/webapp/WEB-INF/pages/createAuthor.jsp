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
				<li class="breadcrumb-item"><a href="./author" ><h2><strong><fmt:message key="title.yazar.form"/></strong></h2></a></li>
			</ol>
			<form:form modelAttribute="author" action="./author" method="post" id="author-form">
				<form:hidden path="id" id="id" />
				<form:errors path="*"/>
				<div class=" form-group">
					<div class="col-md-6">
						<label><fmt:message key="label.ad" /></label>
						<form:input type="text" path="firstname" placeholder=""
							class="form-control" />
					</div>
					<div class="col-md-6">
						<label><fmt:message key="label.soyad" /></label>
						<form:input type="text" path="lastname" placeholder=""
							class="form-control" />
					</div>
				</div>
				<div class=" form-group">
					<div >
						<label><fmt:message key="label.aciklama" /></label>
						<form:textarea rows="5" cols="40" path="description"
							class="form-control" />
					</div>
				</div>
				<div class="row">
					<button type="submit" class="btn btn-success pull-right"><fmt:message key="button.submit"/></button>
				</div>
			</form:form>
			<!-- /.row -->
		</div>
	</div>
</body>
</html>