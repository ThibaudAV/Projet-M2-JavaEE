
<%@ include file="_header.jsp"%>

<ul class="nav nav-tabs nav-justified onglet">
	<li role="presentation" class="active"><a href="#">Accueil</a></li>

<li role="presentation" class="dropdown"><a
		class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
		aria-expanded="false"> Catégories <span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
			<li role="presentation" class="dropdown-header">2014</li>
			<li><a href="#">Informatique</a></li>
			<li><a href="#">Robotique</a></li>
			<li><a href="#">Domotique</a></li>
			<li></li>
		</ul>
	</li>


	<li role="presentation" class="dropdown"><a
		class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
		aria-expanded="false"> Archives <span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
			<li role="presentation" class="dropdown-header">2014</li>
			<li><a href="#">Janvier</a></li>
			<li><a href="#">Février</a></li>
			<li><a href="#">Mars</a></li>
			<li><a href="#">Avril</a></li>
			<li class="divider"></li>
			<li><a href="#">2013</a></li>
			<li></li>
		</ul>
	</li>
</ul>


<div class="">
	<div class="box">
		<div class="col-lg-12">

			<c:forEach items="${requestScope.list_article}" var="article">
            <div class="col-lg-12 text-center">
                <img class="img-responsive img-border img-full"
                    src="${pageContext.request.contextPath}${article.image}" alt="">
				<h2>
					${article.titre} <br> <small></small>
                </h2>
                <p>${article.corps}</p>
                <a href="views/Article.jsp?id=${article.id}" class="btn btn-default btn-lg"><fmt:message key="article.readmore" /></a>
                <hr>
            </div>
        </c:forEach>
	</div>
</div>

</div>


<%@ include file="_footer.jsp"%>