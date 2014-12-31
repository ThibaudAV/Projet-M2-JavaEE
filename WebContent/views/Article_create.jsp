
<%@ include file="_header.jsp"%>


<div class="row">
	<div class="box">
		<div
			class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<form method="post" action="<c:url value="/Article_create"/>" onsubmit="return valider()" enctype="multipart/form-data">
				<h2>
					<fmt:message key="general.addarticle" />
				</h2>
				<hr>
				  <div class="form-group">
				    <label class="control-label" for="InputTitle"><fmt:message key="article.titre" /></label>
				    <input type="text" class="form-control" id="title" name="title" placeholder="<fmt:message key='article.entrertitre' />">
				    <p class="help-block hide"><fmt:message key='article.errortitre' />.</p>
				  </div>
				  <div class="form-group">
				    <label class="control-label" for="InputCategorie"><fmt:message key='article.categorie' /></label>
				    <select class="form-control" id="categorie" name="categorie">
					  <option value="default"><fmt:message key='article.defaultcategorie' /></option>
					  <c:forEach items="${requestScope.list_cat}" var="categorie"> 
							<option value="${categorie.id}">${categorie.nom}</option>
					  </c:forEach>
					</select>
					<p class="help-block hide"><fmt:message key='article.errorcategorie' />.</p>
				  </div>
				  <div class="form-group">
				    <label class="control-label" for="TextCorps"><fmt:message key='article.contenu' /></label>
				   	<textarea id="corps" name="corps" class="form-control" rows="10"></textarea>
				   	<p class="help-block hide"><fmt:message key='article.errorcontenu' />.</p>
				  </div>
				  <div class="form-group">
				    <label class="control-label" for="InputFileImage"><fmt:message key='article.image' /></label>
				    <input type="file" id="image" name="image">
				    <p class="help-block"><fmt:message key='article.helpimage' />.</p>
				  </div>
				  <button id="valid_add" type="submit" class="btn btn-default"><fmt:message key='article.publier' /></button>
			</form>
		</div>
	</div>
</div>

<script>
	function valider(){
		// récupération des éléments pour le titre
		var title = $("#title");
		var div_title = title.parent();
		var p_title = div_title.children('p');
		// récupération des éléments pour le select (catégorie)
		var select = $("#categorie");
		var div_select = select.parent();
		var p_select = div_select.children('p');
		// récupération des éléments pour le contenu
		var content = $("#corps");
		var div_content = content.parent();
		var p_content = div_content.children('p');
		// récupération des éléments pour l'image
		var image = $("#image");
		var div_img = image.parent();
		var p_img = div_img.children('p');
		if(select.val() == "default" || title.val() == "" || content.val().split(/\s+/).length < 50){
			// Vérification de la longueur du contenu de l'article (au moins 50 mots)
			if(content.val().split(/\s+/).length < 50) {
				div_content.addClass('has-error');
				p_content.removeClass('hide');
			} else {
				// clear css contenu
				div_content.removeClass('has-error');
				p_content.addClass('hide');
			}
			// Vérification du titre pour l'article
			if(title.val() == ""){
				div_title.addClass('has-error');
				p_title.removeClass('hide');
			} else {
				// clear css titre
				div_title.removeClass('has-error');
				p_title.addClass('hide');
			}
			// Vérification du select pour la catégorie
			if(select.val() == "default"){
				div_select.addClass('has-error');
				p_select.removeClass('hide');
			} else {
				// clear css select
				div_select.removeClass('has-error');
				p_select.addClass('hide');
			}
			
			return false;
		} else {
			// clear css contenu
			div_content.removeClass('has-error');
			p_content.addClass('hide');
			// clear css titre
			div_title.removeClass('has-error');
			p_title.addClass('hide');
			// clear css select
			div_select.removeClass('has-error');
			p_select.addClass('hide');
			// vérification de l'extensio de l'image si il y en une
			if(image.val() != ""){
				console.log(image.val());
				var index = image.val().lastIndexOf('.');
				var ext = image.val().substring(index);
				console.log(ext);
				// vérification d'extension d'image : gif bmp jpg jpeg png psd tif
				if(!(ext==".gif" || ext==".bmp" || ext==".jpg" || ext==".jpeg" || ext==".png" || ext==".psd" || ext==".tif")){
					div_img.addClass('has-error');
					p_img.html("Vous ne pouvez ajouter qu'un fichier de type image.");
					return false;
				} else {
					div_img.removeClass('has-error');
					p_img.html("Télécharger une image pour mettre en valeur votre article.");
				}				
			}
			return true;
		}
		
		
	}
</script>

<%@ include file="_footer.jsp"%>