//Fonte: Validacao CPF/CNPJ: DEVMEDIA

package br.com.sportsgo.model.pessoa;

import java.util.InputMismatchException;

import br.com.sportsgo.model.Endereco;
import br.com.sportsgo.model.RedeSocial;
import br.com.sportsgo.model.Telefone;
//*Atributos CamelCase verificar banco/Diagrama ER.

public class Pessoa{
	
    private String nome;
    private String sobrenome;
    private Endereco endereco;
    private Telefone telefone;
    private RedeSocial redeSocial;
    private String cpfCnpj;
    private String email;
    private boolean pessoaFisica;
    private boolean pessoaJuridica;
    
    //Metodos validacao CPF/CNPJ (separadamente). Sugestao: Implementar JavaScript [?]
    //OBS Alterar Metodos para ValidarCpfCnpj usando pessoaFisica/pessoaJuridica [?]
    public boolean ValidarCnpj(String cnpj){
    	cnpj = cnpj.replaceAll("\\.", "").replaceAll("-","").replaceAll("/", ""); //Remove pontos e o traco, caso estes existam
    	// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
    	    if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
    	        cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
    	        cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
    	        cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
    	        cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
    	       (cnpj.length() != 14))
    	       return(false);

    	    char dig13, dig14;
    	    int sm, i, r, num, peso;

    	// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
    	    try {
    	// Calculo do 1o. Digito Verificador
    	      sm = 0;
    	      peso = 2;
    	      for (i=11; i>=0; i--) {
    	// converte o i-�simo caractere do CNPJ em um n�mero:
    	// por exemplo, transforma o caractere '0' no inteiro 0
    	// (48 eh a posicao de '0' na tabela ASCII)
    	        num = (int)(cnpj.charAt(i) - 48);
    	        sm = sm + (num * peso);
    	        peso = peso + 1;
    	        if (peso == 10)
    	           peso = 2;
    	      }

    	      r = sm % 11;
    	      if ((r == 0) || (r == 1))
    	         dig13 = '0';
    	      else dig13 = (char)((11-r) + 48);

    	// Calculo do 2o. Digito Verificador
    	      sm = 0;
    	      peso = 2;
    	      for (i=12; i>=0; i--) {
    	        num = (int)(cnpj.charAt(i)- 48);
    	        sm = sm + (num * peso);
    	        peso = peso + 1;
    	        if (peso == 10)
    	           peso = 2;
    	      }

    	      r = sm % 11;
    	      if ((r == 0) || (r == 1))
    	         dig14 = '0';
    	      else dig14 = (char)((11-r) + 48);

    	// Verifica se os digitos calculados conferem com os digitos informados.
    	      if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
    	         return(true);
    	      else return(false);
    	    } catch (InputMismatchException erro) {
    	        return(false);
    	    }
    }
    
    public static boolean ValidarCpf(String cpf) {
        cpf = cpf.replaceAll("\\.", "").replaceAll("-",""); //Remove pontos e os tracos, caso existam
   // Considera-se erro CPF's formados por uma sequencia de numeros iguais
    	        if (cpf.equals("00000000000") || cpf.equals("11111111111")
    	                || cpf.equals("22222222222") || cpf.equals("33333333333")
    	                || cpf.equals("44444444444") || cpf.equals("55555555555")
    	                || cpf.equals("66666666666") || cpf.equals("77777777777")
    	                || cpf.equals("88888888888") || cpf.equals("99999999999")
    	                || (cpf.length() != 11)) {
    	            return (false);
    	        }
    	 
    	        char dig10, dig11;
    	        int sm, i, r, num, peso;
    	 
    	// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
    	        try {
    	// Calculo do 1o. Digito Verificador
    	            sm = 0;
    	            peso = 10;
    	            for (i = 0; i < 9; i++) {
    	// converte o i-esimo caractere do CPF em um numero:
    	// por exemplo, transforma o caractere '0' no inteiro 0         
    	// (48 eh a posicao de '0' na tabela ASCII)         
    	                num = (int) (cpf.charAt(i) - 48);
    	                sm = sm + (num * peso);
    	                peso = peso - 1;
    	            }
    	 
    	            r = 11 - (sm % 11);
    	            if ((r == 10) || (r == 11)) {
    	                dig10 = '0';
    	            } else {
    	                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
    	            }
    	// Calculo do 2o. Digito Verificador
    	            sm = 0;
    	            peso = 11;
    	            for (i = 0; i < 10; i++) {
    	                num = (int) (cpf.charAt(i) - 48);
    	                sm = sm + (num * peso);
    	                peso = peso - 1;
    	            }
    	 
    	            r = 11 - (sm % 11);
    	            if ((r == 10) || (r == 11)) {
    	                dig11 = '0';
    	            } else {
    	                dig11 = (char) (r + 48);
    	            }
    	 
    	// Verifica se os digitos calculados conferem com os digitos informados.
    	            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
    	                return (true);
    	            } else {
    	                return (false);
    	            }
    	        } catch (InputMismatchException erro) {
    	            return (false);
    	        }
    }
    
	//Metodos Getters and Setters
    public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public boolean isPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(boolean pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public boolean isPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public RedeSocial getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(RedeSocial redeSocial) {
		this.redeSocial = redeSocial;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}