package pacotes.bean;

/**
*
* @author Tiago M
*/
public class Telefone {
	private long id;
	private int ddd;
	private String numero;
	private String tipo;
	private Usuario usuario;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
