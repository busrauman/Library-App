<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
</head>
<body>
	<div class="wrapper">
		<%@include file="../include/header.jsp"%>
		<div class="container content margin-top">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="./publisher" ><h2><strong><fmt:message key="title.yayinevi.form"/></strong></h2></a></li>
			</ol>
			<form:form modelAttribute="publisher" action="./publisher" method="post">
				<form:hidden path="id" id="id" />

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
				<button type="submit" class="btn btn-success pull-right">Submit</button>
			</form:form>
			<!-- /.row -->
		</div>
	</div>
</body>
</html>