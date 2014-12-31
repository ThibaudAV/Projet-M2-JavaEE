
<%@ include file="_header.jsp"%>

<div class="row">
	<div class="box">
		<div class="col-lg-12">
			<h2 class="intro-text text-center">
				<fmt:message key="general.myarticles" />
			</h2>
			<hr>
		</div>
		<c:forEach items="${requestScope.list_article}" var="article">
			<div class="col-lg-12 text-center">
				<img class="img-responsive img-border img-full"
					src="${pageContext.request.contextPath}/static/img/articles/${article.image}"
					alt="">
				<h2>
					${article.titre} <br> <small>October 13, 2013</small>
				</h2>
				<p>${article.corps}</p>
				<a href="views/Article.jsp?id=${article.id}" class="btn btn-default btn-lg"><fmt:message key="article.readmore" /></a>
				<a href="Article_edit?id=${article.id}" class="btn btn-default btn-lg"><fmt:message key="article.modifier" /></a>
				<a href="Article_delete?id=${article.id}" class="btn btn-default btn-lg"><fmt:message key="general.supprimer" /></a>
				<hr>
			</div>
		</c:forEach>
		
		<div class="col-lg-12 text-center">
			<ul class="pager">
				<li class="previous"><a href="#">&larr; <fmt:message key="nav.older" /></a></li>
				<li class="next"><a href="#"><fmt:message key="nav.newer" /> &rarr;</a></li>
			</ul>
		</div>
	</div>
</div>
	
<%@ include file="_footer.jsp"%>