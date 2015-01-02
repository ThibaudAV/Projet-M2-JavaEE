
<%@ include file="_header.jsp" %>

	

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <h1></h1>
                    <hr>
                    <h2 class="intro-text text-center">Company
                        <strong>blog</strong>
                    </h2>
                    <hr>
                </div>
                <div class="col-lg-12 text-center">
                    <img class="img-responsive img-border img-full" src="${pageContext.request.contextPath}${image}" alt="">
                    <h2>${requestScope.titre }
                        <br>
                        <small>${requestScope.day} ${requestScope.month} ${requestScope.year}</small>
                    </h2>
                    <p>${requestScope.corps}</p>
                    <hr>
                </div>
            </div>
        </div>



<%@ include file="_footer.jsp" %>