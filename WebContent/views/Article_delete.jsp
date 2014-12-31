<%@ include file="_header.jsp" %>

	
        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <h2 class="intro-text text-center">
                    	<fmt:message key="article.supprimerarticle" />
                    </h2>
                    <hr>
                </div>
                <div class="col-lg-12 text-center">
                    <h2>
						${requestScope.titre} <br> <small>October 13, 2013</small>
                    </h2>
                    <p><fmt:message key="article.confirmsuppr" /> ? </p>
                    <form method="post" action="<c:url value="/Article_delete"/>">
                    	<input type="hidden" name="id" value="${requestScope.id}">
				  		<button type="submit" class="btn btn-default btn-lg"><fmt:message key="general.supprimer" /></button>
				  		<a href="Article_my" class="btn btn-default btn-lg"><fmt:message key="general.annuler" /></a>
                    </form>
                    <hr>
                </div>
            </div>
        </div>


<%@ include file="_footer.jsp" %>