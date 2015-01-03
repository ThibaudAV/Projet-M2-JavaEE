
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
                    <img class="img-responsive img-border img-full" src="${pageContext.request.contextPath}/static/img/articles/${image}" alt="">
                    <h2>
                   		 ${requestScope.titre}
                        <br>
                        
                        <small><fmt:formatDate value="${requestScope.date}" pattern="dd MMMMMMMMMMMM yyyy"/></small>
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
