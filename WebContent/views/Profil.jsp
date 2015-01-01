
<%@ include file="_header.jsp"%>


<div class="row">
	<div class="box">

		<div class="col-md-12">

			<h2>${user.pseudo}</h2>
			<hr>
			<div class="row">
				<!-- left column -->
				<div class="col-md-3">
					<div class="text-center">
						<img src="${pageContext.request.contextPath}/static/img/avatar/${user.getAvatar()}" class="avatar img-circle"
							alt="avatar" width="50px" height="50px">
						<h6><fmt:message key="profile.changeimg" /></h6>

						<form class="form-horizontal" role="form"  method="post" action="<c:url value="/Profil"/>" enctype="multipart/form-data">
						<input type="hidden" name="nameFrom" value="editImage">
							<input type="file" class="form-control" name="uploadFile">
								<input type="submit" class="btn btn-primary"
									value="<fmt:message key="profile.submit" />">
						</form>
					</div>
				</div>

				<!-- edit form column -->
				<div class="col-md-9 personal-info">
					 <c:if test="${requestScope['message']}">
						<div class="alert alert-info alert-dismissable">
							<a class="panel-close close" data-dismiss="alert">×</a> <i
								class="fa fa-coffee"></i> ${requestScope["message"]}.
						</div>
					</c:if>
					<form class="form-horizontal" role="form" method="post" action="<c:url value="/Profil"/>">
					<input type="hidden" name="nameFrom" value="editProfil">
						
						<div class="form-group">
							<label class="col-lg-3 control-label"><fmt:message key="register.mail" /> :</label>
							<div class="col-lg-8">
								<input class="form-control" name="emailUser" type="text"
									value="${user.email}">
									<span class="erreur">${form.erreurs['emailUser']}</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label"><fmt:message key="profile.signature" /> :</label>
							<div class="col-md-8">
								<textarea class="form-control" name="signatureUser" rows="3">${user.signature}</textarea>
								<span class="erreur">${form.erreurs['signatureUser']}</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label"></label>
							<div class="col-md-8">
								<input type="submit" class="btn btn-primary"
									value="<fmt:message key="profile.savech" />"> <span></span> <input type="reset"
									class="btn btn-default" value="<fmt:message key="profile.cancel" />">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="_footer.jsp"%>