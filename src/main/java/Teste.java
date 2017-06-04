

public class Teste {

	public static void main(String[] args) throws Exception {
		Pessoa p = new Pessoa();
		p.isPessoaFisica();
		p.setCpfCnpj("043.842.981-88");
		boolean resultado;
		resultado = p.ValidaCpfCnpj("043.842.981.-88");
		
		if(resultado){
			System.out.println("CPF Válido!");
		}else{
			System.out.println("CPF Inválido!");
		}
	}

}
