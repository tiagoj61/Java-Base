<%@include file="../fragment/head.jsp"%>

<section class="card">
	<header class="card-header">Registros</header>

	<div class="card-body text-right">
		<a href="/Temp/app/home/cadastrar.jsp" id="addUsuario"
			class="btn btn-primary"> Adicionar
			Novo
		</a> <a href="usuarioLogout" id="addUsuario"
			class="btn btn-primary"> sair
		</a>
	</div>

	<div class="card-body">
		<table class="table table-striped table-advance table-hover">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody id="listaUsuario">
			</tbody>
		</table>
	</div>

</section>
<script type="text/javascript" src="js/script_index.js"></script>
<%@include file="../fragment/endpage.jsp"%>