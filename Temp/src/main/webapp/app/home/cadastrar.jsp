<%@include file="../fragment/head.jsp"%>

<section class="card" style="background-color: #FFFFFF !important;">
	<div class="card-body">
		<div class="row">
			<div class="col-lg-12">
				<div class="form-group">
					<label>Cadastro</label>

				</div>
			</div>
		</div>
		<section class="card"
			style="background-color: #EFEFEF !important; padding: 50px;">
			<header class="voce-esta">Usuário</header>
			<div class="card-body" id="clienteCard">

				<i class="fa fa-plus-circle"></i>
				<div class="row" id="rowCliente">
					<div class="col-lg-10">
						<div class="form-group">
							<label>Nome do usuário</label> <input id="nomeUsuario"
								class="form-control" name="nomeUsuario" maxlength="100"
								class="form-control" required="true" />
						</div>
					</div>
				</div>
				<div class="row" id="rowCliente">
					<div class="col-lg-6">
						<div class="form-group">
							<label>E-mail</label> <input id="emailUsuario"
								class="form-control" type="email" name="telefoneUsuario"
								maxlength="100" class="form-control" required="true" />
						</div>

					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label>Senha</label> <input id="senhaUsuario"
								class="form-control" type="password" name="senhaUsuario"
								id="cliente" maxlength="100" class="form-control"
								required="true" />
						</div>
					</div>
				</div>
		</section>


		<section id="session" class="card"
			style="background-color: #EFEFEF !important; padding: 50px; margin-top: 20px;">
			<header class="voce-esta">Telefone</header>
			<div class="card-body" id="telefoneCard">

				<div class="row" id="rowFabrica">
					<div class="col-lg-2" style="margin-center: auto;">
						<div class="form-group">
							<label>DDD</label> <input type="number" id="ddd"
								name="ddd" maxlength="100" class="form-control"
								required="true" />
						</div>
					</div>
					<div class="col-lg-6" style="margin-center: auto;">
						<div class="form-group">
							<label>Número</label> <input id="telefone" name="telefone"
								maxlength="100" type="number" class="form-control"
								required="true" />
						</div>
					</div>
					<div class="col-lg-8" style="margin-center: auto;">
						<div class="form-group">
							<label>Tipo do telefone</label> <input type="text" id="tipo"
								name="tipo" maxlength="100" class="form-control" required="true" />
						</div>
					</div>
				</div>

			</div>
			<button onclick="addTelefone()"
				style="cursor: pointer; font-size: 130%;">
				<i class="fa fa-plus-circle"></i> adicionar telefone
			</button>
		</section>

		<div class="panel-body "
			style="padding-top: 20px; text-align: center;">
			<button id="buttonSend" type="submit"
				class="btn btn-success btn-primary" style="width: 20% !important">Salvar
				Registro</button>
			<button type="button" class="btn btn-danger btn-second"
				style="width: 20% !important"
				onclick="window.location = 'usuarioLogin'">Cancelar</button>
			&nbsp;
		</div>
	</div>
</section>

<script type="text/javascript" src="js/script.js"></script>
<%@include file="../fragment/endpage.jsp"%>