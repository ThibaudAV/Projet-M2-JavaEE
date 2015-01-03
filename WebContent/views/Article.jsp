
<%@ include file="_header.jsp" %>

	

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h1 class="intro-text text-center">${requestScope.categorie}
                    </h1>
                    <hr>
                </div>
                <div class="col-lg-12 text-center">
                    <img class="img-responsive img-border img-full" src="${pageContext.request.contextPath}${image}" alt="">
                    <h2>
                   		 ${requestScope.titre}
                        <br>
                        <small>${requestScope.day}
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
                    <p>${requestScope.corps}</p>
                    <hr>
                    <fmt:message key='article.written' /> <img src="${pageContext.request.contextPath}/static/img/avatar/${auteur.getAvatar()}" class="avatar img-circle"
							alt="avatar" width="20px" height="20px"/> ${requestScope.pseudo } <br>
                   <em> ${requestScope.signature } </em>
                </div>
            </div>
        </div>



<%@ include file="_footer.jsp" %>