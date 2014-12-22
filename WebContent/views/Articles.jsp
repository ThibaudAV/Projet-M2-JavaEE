
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


<div class="row">
	<div class="box">
		<div class="col-lg-12">


			<h1>
				Test de langues :
				<fmt:message key="general.hello" />
			</h1>
			<hr>
			<h2 class="intro-text text-center">
				Company <strong>blog</strong>
			</h2>
			<hr>
		</div>
		<div class="col-lg-12 text-center">
			<img class="img-responsive img-border img-full"
				src="${pageContext.request.contextPath}/static/img/slide-1.jpg"
				alt="">
			<h2>
				Post Title <br> <small>October 13, 2013</small>
			</h2>
			<p>Lid est laborum dolo rumes fugats untras. Etharums ser quidem
				rerum facilis dolores nemis omnis fugats vitaes nemo minima rerums
				unsers sadips amets. Sed ut perspiciatis unde omnis iste natus error
				sit voluptatem accusantium doloremque laudantium, totam rem aperiam,
				eaque ipsa quae ab illo inventore veritatis et quasi architecto
				beatae vitae dicta sunt explicabo.</p>
			<a href="#" class="btn btn-default btn-lg">Read More</a>
			<hr>
		</div>
		<div class="col-lg-12 text-center">
			<img class="img-responsive img-border img-full"
				src="${pageContext.request.contextPath}/static/img/slide-2.jpg"
				alt="">
			<h2>
				Post Title <br> <small>October 13, 2013</small>
			</h2>
			<p>Lid est laborum dolo rumes fugats untras. Etharums ser quidem
				rerum facilis dolores nemis omnis fugats vitaes nemo minima rerums
				unsers sadips amets. Sed ut perspiciatis unde omnis iste natus error
				sit voluptatem accusantium doloremque laudantium, totam rem aperiam,
				eaque ipsa quae ab illo inventore veritatis et quasi architecto
				beatae vitae dicta sunt explicabo.</p>
			<a href="#" class="btn btn-default btn-lg">Read More</a>
			<hr>
		</div>
		<div class="col-lg-12 text-center">
			<img class="img-responsive img-border img-full"
				src="${pageContext.request.contextPath}/static/img/slide-3.jpg"
				alt="">
			<h2>
				Post Title <br> <small>October 13, 2013</small>
			</h2>
			<p>Lid est laborum dolo rumes fugats untras. Etharums ser quidem
				rerum facilis dolores nemis omnis fugats vitaes nemo minima rerums
				unsers sadips amets. Sed ut perspiciatis unde omnis iste natus error
				sit voluptatem accusantium doloremque laudantium, totam rem aperiam,
				eaque ipsa quae ab illo inventore veritatis et quasi architecto
				beatae vitae dicta sunt explicabo.</p>
			<a href="#" class="btn btn-default btn-lg">Read More</a>
			<hr>
		</div>
		<div class="col-lg-12 text-center">
			<ul class="pager">
				<li class="previous"><a href="#">&larr; Older</a></li>
				<li class="next"><a href="#">Newer &rarr;</a></li>
			</ul>
		</div>
	</div>
</div>

</div>


<%@ include file="_footer.jsp"%>