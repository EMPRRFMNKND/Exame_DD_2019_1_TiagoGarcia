package controller;

import model.bo.AlunoBO;


public class ControllerNotas {
	
	public static final String NIVEL_BASICO = "B�sico";
	public static final String NIVEL_INTERMEDIARIO = "Intermedi�rio";
	public static final String NIVEL_AVANCADO = "Avan�ado";
	
	private AlunoBO bo = new AlunoBO();
	
	public String validarCamposSalvar(String nomeDigitado, String sobrenomeDigitado, String matricula
			) {
		String mensagem = "";

		if (nomeDigitado.isEmpty() || nomeDigitado.trim().length() < 3) {
			mensagem += "Nome deve possuir pelo menos 3 letras \n";
		}

		if (sobrenomeDigitado.isEmpty() || sobrenomeDigitado.trim().length() < 3) {
			mensagem += "Sobrenome deve possuir pelo menos 3 letras \n";
		}

		if (matricula == null) {
			mensagem += "Informe a Matr�cula \n";
		}

		return mensagem;
	}

}
