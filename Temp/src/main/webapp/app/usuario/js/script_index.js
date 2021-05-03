$(function() {
	carregarUsuarios()
});

function carregarUsuarios() {
	console.log(window)
	$.ajax({
		method : "GET",
		url : "usuarioListAll"
	}).done(function(json) {
		console.log(json)
		$(json).each(function(index,value) {
			let html;
			html = `<tr >`;
			html+=`<td>${value.nome}</td>`;
			html+=`<td>${value.email}</td>`;
			html+=`<td class="text-right">
			<button type="button" class="btn btn-outline-primary btn-xs"
				onclick="window.location.href = 'usuarioEditar?usuario.id=${value.id}'">
				<i class="fas fa-edit"></i> editar
			</button>
			<button type="button" class="btn btn-outline-danger btn-xs"
				onclick="remove(${value.id})">
				<i class="fas fa-trash-alt"></i> excluir
			</button>
		</td>`;
			html+=`</tr >`;
			document.getElementById('listaUsuario').insertAdjacentHTML('beforeend',html)
		});
	}).fail(function() {
	});

}
function remove(id){
	$.ajax({
		method : "GET",
		url : "usuarioDelete?usuario.id="+id
	}).done(function(json) {
		if(json.notify){
			window.location="../usuario/index.jsp"
		}
	});
}
