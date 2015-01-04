<%@ include file="_header.jsp"%>

<ul class="nav nav-tabs nav-justified onglet">
	<li role="presentation" class=""><a href="<c:url value="/Articles"/>"><fmt:message key="general.actu" /></a></li>

<li role="presentation" class="dropdown"><a
		class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
		aria-expanded="false"> <fmt:message key="article.categorie" /> <span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
			<c:forEach items="${requestScope.list_cat}" var="categorie"> 
				<li> <a href="Articles_by?cat=${categorie.id}">${categorie.nom}</a></li>
			</c:forEach>
		</ul>
	</li>


	<li role="presentation" class="dropdown active"><a
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
              <h1 class="intro-text text-center">
              	<c:if test="${not empty requestScope.month}">
	              	<c:choose>
	                	<c:when test="${requestScope.month == 1}"> <fmt:message key='months.january' /></c:when>
	                	<c:when test="${requestScope.month == 2}"> <fmt:message key='months.february' /></c:when>
	                	<c:when test="${requestScope.month == 3}"> <fmt:message key='months.march' /></c:when>
	                	<c:when test="${requestScope.month == 4}"> <fmt:message key='months.april' /></c:when>
	                	<c:when test="${requestScope.month == 5}"> <fmt:message key='months.may' /></c:when>
	                	<c:when test="${requestScope.month == 6}"> <fmt:message key='months.june' /></c:when>
	                	<c:when test="${requestScope.month == 7}"> <fmt:message key='months.july' /></c:when>
	                	<c:when test="${requestScope.month == 8}"> <fmt:message key='months.august' /></c:when>
	                	<c:when test="${requestScope.month == 9}"> <fmt:message key='months.september' /></c:when>
	                	<c:when test="${requestScope.month == 10}"> <fmt:message key='months.october' /></c:when>
	                	<c:when test="${requestScope.month == 11}"> <fmt:message key='months.november' /></c:when>
	                	<c:when test="${requestScope.month == 12}"> <fmt:message key='months.december' /></c:when>
	                </c:choose>
	                &nbsp;
                </c:if>
                ${requestScope.year}
              </h1>
              <hr>
          </div>

			<c:forEach items="${requestScope.liste_by}" var="article">
            <div class="col-lg-12 text-center">
            	<c:if test="${!empty article.image }">
                <img class="img-responsive img-border img-full"
                    src="${pageContext.request.contextPath}/static/img/articles/${article.image}" alt=""></c:if>
                 <h2>${article.titre} <br></h2>
                <p>${fn:substring(article.corps,0,200)} ...</p>
                <a href="Article?id=${article.id}" class="btn btn-default btn-lg"><fmt:message key="article.readmore" /></a>
                <hr>
            </div>
        </c:forEach>

</div>

</div>


<%@ include file="_footer.jsp"%>