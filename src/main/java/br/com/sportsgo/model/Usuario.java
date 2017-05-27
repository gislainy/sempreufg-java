
public class Usuario extends Pessoa{
	private String id;
	private String senha;
    //Implementar tipoPessoa : EnumTipoPessoa (?)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}