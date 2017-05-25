package br.com.sportsgo.model.pessoa;

public class TipoPessoa {

	enum Pessoa {
		FISICA, JURIDICA;

		public String getDescricao() {
			switch (this) {
			case FISICA:
				return "fisica";
			case JURIDICA:
				return "juridica";
			default:
				return "";
			}
		}

	}

}
