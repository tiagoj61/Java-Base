function addTelefone() {
	
	html = `<div class="row" id="rowFabrica">
	<button id="removedor" onclick="this.parentElement.remove();"
		style="cursor: pointer;">Remover</button>
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
	</div>`;
	document.getElementById('telefoneCard').insertAdjacentHTML('beforeend',html)
}

$( "#buttonSend" ).click(function( event ) {
	let nome=$('#nomeUsuario').val()
	let email=$('#emailUsuario').val()
	let senha=$('#senhaUsuario').val()
	let telefones=[];
	let DDDs=[];
	let tipos=[];
	var elements = document.getElementById("session").querySelectorAll(".form-control");
	for (var i = 0; i<elements.length;i++) {
		let element=elements[i]
		console.log(element)
    		if(element.id==='telefone'){
    			telefones.push(element.value)
    		}else if(element.id==='ddd'){
    			DDDs.push(element.value)
    		}else if(element.id==='tipo'){
    			tipos.push(element.value)
    		}
    	}
     
	$.ajax({
		method: "POST",
		url: "usuarioCadastro",
		data: {
			"nomeUsuario": nome,
			"emailUsuario":email,
			"senhaUsuario": senha,
			"telefonesUsuario[]": telefones,
			"ddds[]": DDDs,
			"tipos[]": tipos
		},
		dataType: "json"
	}).done(function(json) {
		if(json.notify){
			Swal.fire('Usuário criado')
			window.location="../usuario/index.jsp"
		}else{
			Swal.fire('Email ou senha não estão no sistema')
			window.location="../"
		}
	}).fail(function() {
	});
});
$( "#buttonSubmit" ).click(function( event ) {
	let email=$('#email').val()
	let senha=$('#senha').val()
	$.ajax({
		method: "POST",
		url: "usuarioLogin",
		data: {
			"emailUsuario":email,
			"senhaUsuario":senha
		},
		dataType: "json"
	}).done(function(json) {
		console.log(json)
		if(json.ok){
			window.location="../usuario/index.jsp"
		}else{
			Swal.fire('Email ou senha não estão no sistema')
		}
	
	}).fail(function() {
	});
});
