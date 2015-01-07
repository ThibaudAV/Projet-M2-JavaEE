<%@ include file="_header.jsp"%>

<ul class="nav nav-tabs nav-justified onglet">
	<li role="presentation" class=""><a href="<c:url value="/Articles"/>"><fmt:message key="general.actu" /></a></li>

<li role="presentation" class="dropdown active"><a
		class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
		aria-expanded="false"> <fmt:message key="article.categorie" /> <span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
			<c:forEach items="${requestScope.list_cat}" var="categorie"> 
				<li> <a href="Articles_by?cat=${categorie.id}">${categorie.nom}</a></li>
			</c:forEach>
		</ul>
	</li>


	<li role="presentation" class="dropdown"><a
		class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
		aria-expanded="false"><fmt:message key="general.archive" /><span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
			<li role="presentation" class="dropdown-header">2015</li>
			<li><a href="Articles_byDate?mois=2"><fmt:message key="months.february" /></a></li> 
			<li><a href="Articles_byDate?mois=1"><fmt:message key="months.january" /></a></li>
			<li class="divider"></li>
			<li><a href="Articles_byDate?annee=2014">2014</a></li>
			<li class="divider"></li>
			<li><a href="Articles_byDate?annee=2013">2013</a></li>
			<li></li>
		</ul>
	</li>
</ul>


<div class="">
	<div class="box">
		<div class="col-lg-12">
              <hr>
              <h1 class="intro-text text-center">${requestScope.catname}
              </h1>
              <hr>
          </div>

			<c:forEach items="${requestScope.liste_bycat}" var="article">
            <div class="col-lg-12 text-center">
            
            
            	<c:if test="${!empty article.image }">
                <img class="img-responsive img-border img-full"
                    src="${pageContext.request.contextPath}/static/img/articles/${article.image}" alt=""></c:if>
                 <h2>${article.titre} <br> 
					<small><fmt:formatDate value="${article.getDateCreation()}" pattern="dd MMMMMMMMMMMM yyyy"/></small>
                 </h2>

  
                <p>${fn:substring(article.corps,0,200)} ...</p>
                <a href="Article?id=${article.id}" class="btn btn-default btn-lg"><fmt:message key="article.readmore" /></a>
                <hr>
            </div>
        </c:forEach>

</div>

</div>


<%@ include file="_footer.jsp"%>