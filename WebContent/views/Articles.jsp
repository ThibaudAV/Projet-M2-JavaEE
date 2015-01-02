
<%@ include file="_header.jsp"%>

<ul class="nav nav-tabs nav-justified onglet">
	<li role="presentation" class="active"><a href="#"><fmt:message key="general.actu" /></a></li>

<li role="presentation" class="dropdown"><a
		class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
		aria-expanded="false"> <fmt:message key="article.categorie" /> <span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
			<c:forEach items="${requestScope.list_cat}" var="categorie"> 
				<li> <a href="#">${categorie.nom}</a></li>
			</c:forEach>
		</ul>
	</li>


	<li role="presentation" class="dropdown"><a
		class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
		aria-expanded="false"><fmt:message key="general.archive" /><span class="caret"></span></a>
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

			<c:forEach items="${requestScope.list_article}" var="article" begin="0" end="4">
            <div class="col-lg-12 text-center">
            
            
            	<c:if test="${!empty article.image }">
                <img class="img-responsive img-border img-full"
                    src="${pageContext.request.contextPath}${article.image}" alt=""></c:if>
                 <h2>${article.titre} <br></h2>
                <p>${fn:substring(article.corps,0,200)} ...</p>
                <a href="Article?id=${article.id}" class="btn btn-default btn-lg"><fmt:message key="article.readmore" /></a>
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

</div>


<%@ include file="_footer.jsp"%>