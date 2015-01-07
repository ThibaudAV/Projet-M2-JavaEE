
<%@ include file="_header.jsp"%>


<div class="row">
	<div class="box">
		<div
			class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<form role="form" method="post"
				action="<c:url value="/Inscription"/>">
				<h2>
					<fmt:message key="register.title" />
					<small><fmt:message key="register.subtitle" /></small>
				</h2>
				<hr>

				<div class="form-group">
					<input type="text" name="pseudoUser" id="pseudo"
						class="form-control input-lg" placeholder="Pseudo" tabindex="3"
						value="<c:out value="${utilisateur.pseudo}"/>"> <span
						class="erreur"> <c:if
							test="${not empty form.erreurs['pseudoUser']}">
							<fmt:message key="register.${form.erreurs['pseudoUser']}" />
						</c:if>
					</span>
				</div>
				<div class="form-group">
					<input type="email" name="emailUser" id="email"
						class="form-control input-lg"
						placeholder="<fmt:message key="register.mail" />"
						value="<c:out value="${utilisateur.email}"/>" tabindex="4">
					<span class="erreur"> <c:if
							test="${not empty form.erreurs['emailUser']}">
							<fmt:message key="register.${form.erreurs['emailUser']}" />
						</c:if>
					</span>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="password" name="passwordUser" id="password"
								class="form-control input-lg"
								placeholder="<fmt:message key="register.password" />"
								tabindex="5" value="">
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="password" name="passwordUser_confirmation"
								id="password_confirmation" class="form-control input-lg"
								placeholder="<fmt:message key="register.passwordconf" />"
								tabindex="6" value="">
						</div>
					</div>
					<span class="erreur"><c:if
							test="${not empty form.erreurs['passwordUser']}">
							<fmt:message key="register.${form.erreurs['passwordUser']}" />
						</c:if></span>
				</div>
				<div class="row">
					<div class="col-xs-4 col-sm-3 col-md-3">
						<span class="button-checkbox">
							<button type="button" class="btn" data-color="info" tabindex="7">
								<fmt:message key="register.agree" />
							</button> <input type="checkbox" name="t_and_c" id="t_and_c"
							class="hidden" value="1">
						</span>
					</div>
					<div class="col-xs-8 col-sm-9 col-md-9">
						<fmt:message key="register.term1" />
						<strong class="label label-primary"><fmt:message
								key="general.register" /></strong>,
						<fmt:message key="register.term2" />
						<a href="#" data-toggle="modal" data-target="#t_and_c_m"><fmt:message
								key="register.termlink" /></a>
						<fmt:message key="register.term3" />
					</div>
					<span class="erreur"><c:if
							test="${not empty form.erreurs['t_and_c']}">
							<fmt:message key="register.${form.erreurs['t_and_c']}" />
						</c:if></span>
				</div>

				<hr>
				<div class="row">
					<div class="col-xs-12 col-md-6">
						<input type="submit"
							value="<fmt:message key="general.register" />"
							class="btn btn-primary btn-block btn-lg" tabindex="7">
					</div>
					<div class="col-xs-12 col-md-6">
						<a href="<c:url value="/Connexion"/>"
							class="btn btn-success btn-block btn-lg"><fmt:message
								key="general.signin" /></a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
			</div>
			<div class="modal-body">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
					natus odio reiciendis perferendis rem nisi tempore possimus ipsa
					porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
					natus odio reiciendis perferendis rem nisi tempore possimus ipsa
					porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
					natus odio reiciendis perferendis rem nisi tempore possimus ipsa
					porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
					natus odio reiciendis perferendis rem nisi tempore possimus ipsa
					porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
					natus odio reiciendis perferendis rem nisi tempore possimus ipsa
					porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
					natus odio reiciendis perferendis rem nisi tempore possimus ipsa
					porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
					natus odio reiciendis perferendis rem nisi tempore possimus ipsa
					porro delectus quidem dolorem ad.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">I
					Agree</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script>
	$(function() {
		$('.button-checkbox')
				.each(
						function() {

							// Settings
							var $widget = $(this), $button = $widget
									.find('button'), $checkbox = $widget
									.find('input:checkbox'), color = $button
									.data('color'), settings = {
								on : {
									icon : 'glyphicon glyphicon-check'
								},
								off : {
									icon : 'glyphicon glyphicon-unchecked'
								}
							};

							// Event Handlers
							$button.on('click', function() {
								$checkbox.prop('checked', !$checkbox
										.is(':checked'));
								$checkbox.triggerHandler('change');
								updateDisplay();
							});
							$checkbox.on('change', function() {
								updateDisplay();
							});

							// Actions
							function updateDisplay() {
								var isChecked = $checkbox.is(':checked');

								// Set the button's state
								$button.data('state', (isChecked) ? "on"
										: "off");

								// Set the button's icon
								$button
										.find('.state-icon')
										.removeClass()
										.addClass(
												'state-icon '
														+ settings[$button
																.data('state')].icon);

								// Update the button's color
								if (isChecked) {
									$button.removeClass('btn-default')
											.addClass(
													'btn-' + color + ' active');
								} else {
									$button.removeClass(
											'btn-' + color + ' active')
											.addClass('btn-default');
								}
							}

							// Initialization
							function init() {

								updateDisplay();

								// Inject the icon if applicable
								if ($button.find('.state-icon').length == 0) {
									$button
											.prepend('<i class="state-icon '
													+ settings[$button
															.data('state')].icon
													+ '"></i>');
								}
							}
							init();
						});
	});
</script>



<%@ include file="_footer.jsp"%>