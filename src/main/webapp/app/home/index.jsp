<%@include file="../fragment/head.jsp"%>

<div class="d-flex justify-content-center">
	<section class="card"
		style="background-color: #EFEFEF !important; width: 60% !important; padding: 50px; margin: 50px;">
		<div class="card-body">
			<h4>Login</h4>
			<div class="form-group">
				<label>Email</label> <input type="email" class="form-control"
					id="email" required="true" placeholder="Email">
			</div>
			<div class="form-group">
				<label>Senha</label> <input type="password" class="form-control"
					id="senha" name="senhaLogin" placeholder="Senha">
			</div>
			<button id="buttonSubmit" class="btn btn-success">Entrar</button>

			<a href="cadastrar.jsp" class="btn btn-primary">Cadastrar-se</a>
		</div>
	</section>
</div>


<script type="text/javascript" src="js/script.js"></script>
<%@include file="../fragment/endpage.jsp"%>