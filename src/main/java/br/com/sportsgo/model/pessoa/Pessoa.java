package br.com.sportsgo.model.pessoa;

import java.util.ArrayList;
import br.com.sportsgo.model.Endereco;
import br.com.sportsgo.model.RedeSocial;
import br.com.sportsgo.model.Telefone;
import br.com.sportsgo.model.Email;
//*Atributos CamelCase: Verificar BD/Diagrama ER.

public class Pessoa{
    private String cpfCnpj;
	private String nome;
    private boolean pessoaJuridica = false;
  //private boolean pessoaFisica = false; // Nao consta no BD/MER
    private String sobrenome;
	private ArrayList<Email> email = new ArrayList<Email> ();
	private ArrayList<Endereco> endereco = new ArrayList<Endereco> ();
	private ArrayList<RedeSocial> redeSocial = new ArrayList<RedeSocial> ();
	private ArrayList<Telefone> telefone = new ArrayList<Telefone> ();
    
	public boolean ValidaCpfCnpj(String cpfCnpj) throws Exception{
		   boolean resultado = false;
		   if(pessoaJuridica){
			  PessoaJuridicaValidator PessoaValida = new PessoaJuridicaValidator();
			  resultado = PessoaValida.validate(this.cpfCnpj);
		   }
		   else{
				  PessoaFisicaValidator PessoaValida = new PessoaFisicaValidator();
				  resultado = PessoaValida.validate(this.cpfCnpj);
		   }
		return resultado;
	 }
    
    public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public boolean isPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica() {
		this.pessoaJuridica = true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(ArrayList<Endereco> endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(ArrayList<Telefone> telefone) {
		this.telefone = telefone;
	}

	public ArrayList<RedeSocial> getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(ArrayList<RedeSocial> redeSocial) {
		this.redeSocial = redeSocial;
	}

	public ArrayList<Email> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<Email> email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

}