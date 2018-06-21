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
							<strong><fmt:message key="title.yayinevi.detay" /></strong>
						</h2></a></li>
			</ol>
			<div class="panel-body">
				<c:choose>
					<c:when test="${not empty publisher }">
						<div class="tab-pane fade in active">

							<div class="table-responsive panel">
								<table class="table">
									<tbody>

										<tr>
											<td class="text-success"><i class="fa fa-user"></i> <fmt:message
													key="label.yayinevi.adi" /></td>
											<td>${publisher.name }</td>
										</tr>
										<tr>
											<td class="text-success"><i class="fa fa-list-ol"></i> <fmt:message
													key="label.yayinevi.aciklama" /></td>
											<td>${publisher.description }</td>
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

<script>
	
</script>
</html>