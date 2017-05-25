package br.com.sportsgo.model.usuario;

public class TipoUsuario {

	enum Usuario {
		ADM, COMUM;

		public String getDescricao() {
			switch (this) {
			case COMUM:
				return "comum";
			case ADM:
				return "administrador";
			default:
				return "";
			}
		}

	}

}
