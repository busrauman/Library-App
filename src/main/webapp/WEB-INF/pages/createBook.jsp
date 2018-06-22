<%@include file="../include/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<script type="text/javascript">
$(document).ready(function() {
	validateForm.initValidateForm();
	$('.select2').select2({
		placeholder: '<fmt:message key="label.seciniz" />'
	});
});

var validateForm = function() {
	return {
		initValidateForm : function() {
			// Validation
			$('#book-form').validate({
				// Rules for form validation
				rules : {
					isbnNo : {
						required : true
					},
					name : {
						required : true					
					},
					authors : {
						required : true					
					},
					publisher : {
						required : true					
					},
					description : {
						required : true					
					},
					
				},
				// Do not change code below
				errorPlacement : function(error, element) {
					error.insertAfter(element.after());
				}
			});
		}
	};
}();
</script>
</head>
<body>
	<div class="wrapper">
		
		<div class="container content margin-top">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="./book" ><h2><strong><fmt:message key="title.kitap.form"/></strong></h2></a></li>
			</ol>
			<form:form modelAttribute="book" action="./book" method="post" id="book-form">
				<form:hidden path="id" id="id" />
				<form:errors path="*"/>

				<div class=" form-group">

					<div class="col-md-6">
						<label><fmt:message key="label.kitap.isbn" /></label>
						<form:input type="text" path="isbnNo" placeholder=""
							class="form-control" />
					</div>
					<div class="col-md-6">
						<label><fmt:message key="label.kitap.adi" /></label>
						<form:input type="text" path="name" placeholder=""
							class="form-control" />
					</div>
				</div>
				
				<div class=" form-group">

					<div class="col-md-6">
						<label><fmt:message key="label.kitap.subname" /></label>
						<form:input type="text" path="subName" placeholder=""
							class="form-control" />
					</div>
					<div class="col-md-6">
						<label><fmt:message key="label.kitap.seriesname" /></label>
						<form:input type="text" path="seriesName" placeholder=""
							class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-md-6">
						<label><fmt:message key ="label.kitap.yazar"/></label>
									<form:select path="authors" class="select2 form-control authors " >
										<form:option value=""><fmt:message key="label.seciniz"/></form:option>
										<form:options items="${authors}" itemLabel="name" ></form:options>
									</form:select>
					</div>
					<div class="col-md-6">
						<label><fmt:message key ="label.kitap.yayinevi"/></label>
									<form:select path="publisher" class="form-control publisher" >
										<form:option value=""><fmt:message key="label.seciniz"/></form:option>
										<form:options items="${publishers}" itemLabel="name" ></form:options>
									</form:select>
					</div>
				</div>
				
				<div class=" form-group">
					<div class="">
						<label><fmt:message key="label.aciklama" /></label>
						<form:textarea rows="5" cols="40" path="description"
							class="form-control" />
					</div>
				</div>
				<button type="submit" class="btn btn-success pull-right"><fmt:message key="button.submit"/></button>
			</form:form>
		</div>
	</div>
</body>

</html>