
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
					${article.titre} <br> <small>${requestScope.day}
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
                          ${requestScope.year}</small>
				</h2>
				<p>${article.corps}</p>
				<a href="Article?id=${article.id}" class="btn btn-default btn-lg"><fmt:message key="article.readmore" /></a>
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