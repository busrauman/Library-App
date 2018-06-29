<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<%@include file="../include/cssIncludes.jsp"%>
<%@include file="../include/javascriptIncludes.jsp"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<style type="text/css">
@import "font-awesome.min.css";

@import "font-awesome-ie7.min.css";
/* Space out content a bit */
body {
	padding-top: 20px;
	padding-bottom: 20px;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header, .marketing, .footer {
	padding-right: 15px;
	padding-left: 15px;
}

/* Custom page header */
.header {
	border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
	padding-bottom: 19px;
	margin-top: 0;
	margin-bottom: 0;
	line-height: 40px;
}

/* Custom page footer */
.footer {
	padding-top: 19px;
	color: #777;
	border-top: 1px solid #e5e5e5;
}

/* Customize container */
@media ( min-width : 768px) {
	.container {
		max-width: 730px;
	}
}

.container-narrow>hr {
	margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
	text-align: center;
	border-bottom: 1px solid #e5e5e5;
}

.jumbotron .btn {
	padding: 14px 24px;
	font-size: 21px;
}

/* Supporting marketing content */
.marketing {
	margin: 40px 0;
}

.marketing p+h4 {
	margin-top: 28px;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
	/* Remove the padding we set earlier */
	.header, .marketing, .footer {
		padding-right: 0;
		padding-left: 0;
	}
	/* Space out the masthead */
	.header {
		margin-bottom: 30px;
	}
	/* Remove the bottom border on the jumbotron for visual effect */
	.jumbotron {
		border-bottom: 0;
	}
}
</style>
</head>
<body>
	<div class="container">
		<h4 class="well"><fmt:message key="form.register"/></h4>
		<div class="col-lg-12 well">
			<div class="row">
				<form:form modelAttribute="user" action="register" method="post">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label><fmt:message key="label.firstname" /></label>
								<form:input type="text" path="firstname"
									 class="form-control"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label><fmt:message key="label.lastname" /></label>
								<form:input type="text" path="lastname"
									 class="form-control"></form:input>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label><fmt:message key="label.email" /></label>
								<form:input type="email" path="email"
									 class="form-control"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label><fmt:message key="label.username" /></label>
								<form:input type="text" path="username"
									class="form-control"></form:input>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label><fmt:message key="label.password" /></label>
								<form:input type="password" path="password"
									 class="form-control"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label><fmt:message key="label.passConfirm" /></label>
								<form:input type="password" path="passwordConfim"
									 class="form-control"></form:input>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-lg btn-info pull-right"><fmt:message key="button.submit"/></button>
			</div>
			</form:form>
		</div>
	</div>
	</div>
</body>
</html>