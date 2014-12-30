
<%@ include file="_header.jsp"%>


<div class="row">
	<div class="box">

		<div class="col-md-12">

			<h2>Edit Profile</h2>
			<hr>
			<div class="row">
				<!-- left column -->
				<div class="col-md-3">
					<div class="text-center">
						<img src="${pageContext.request.contextPath}/static/img/avatar/${user.getAvatar()}" class="avatar img-circle"
							alt="avatar">
						<h6>Upload a different photo...${user.getAvatar()}</h6>

						<form class="form-horizontal" role="form"  method="post" action="<c:url value="/profil"/>" enctype="multipart/form-data">
							<input type="file" class="form-control" name="uploadFile">
								<input type="submit" class="btn btn-primary"
									value="Envoyer">
						</form>
					</div>
				</div>

				<!-- edit form column -->
				<div class="col-md-9 personal-info">
					<h3>Personal info</h3>
					<div class="alert alert-info alert-dismissable">
						<a class="panel-close close" data-dismiss="alert">×</a> <i
							class="fa fa-coffee"></i> ${requestScope["message"]}.
					</div>
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-lg-3 control-label">Pseudo:</label>
							<div class="col-lg-8">
								<input class="form-control" type="text" value="Jane">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Email:</label>
							<div class="col-lg-8">
								<input class="form-control" type="text"
									value="janesemail@gmail.com">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Password:</label>
							<div class="col-md-8">
								<input class="form-control" type="password" value="11111122333">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Confirm password:</label>
							<div class="col-md-8">
								<input class="form-control" type="password" value="11111122333">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label"></label>
							<div class="col-md-8">
								<input type="button" class="btn btn-primary"
									value="Save Changes"> <span></span> <input type="reset"
									class="btn btn-default" value="Cancel">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="_footer.jsp"%>