package controller;

import model.bo.AlunoBO;
import model.vo.Aluno;


public class AlunoController {
	
	public static final String NIVEL_BASICO = "B�sico";
	public static final String NIVEL_INTERMEDIARIO = "Intermedi�rio";
	public static final String NIVEL_AVANCADO = "Avan�ado";
	public static final String NIVEL_ESPECIALISTA = "Especialista";
	public static final String NIVEL_SELECIONE = "Selecione";
	
	private AlunoBO bo = new AlunoBO();
	
	public String validarCamposSalvar(String nomeDigitado, String sobrenomeDigitado, String matricula,
			Double notaProvaUm, Double notaProvaDois, Double trabalhoUm, Double trabalhoDois,
			Double pesoProva, Double pesoTrabalho) {
		
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
		
		if (notaProvaUm == null) {
			mensagem += "Informe a nota da primeira prova \n";
		} else if (notaProvaUm < 0) {
			mensagem += "Informe uma nota maior ou igual a zero";
		}
		
		if (notaProvaDois == null) {
			mensagem += "Informe a nota da segunda prova \n";
		} else if (notaProvaUm < 0) {
			mensagem += "Informe uma nota maior ou igual a zero";
		}
		
		if (trabalhoUm == null) {
			mensagem += "Informe a nota do primeiro trabalho \n";
		} else if (notaProvaUm < 0) {
			mensagem += "Informe uma nota maior ou igual a zero";
		}
		
		if (trabalhoDois == null) {
			mensagem += "Informe a nota do segundo trabalho \n";
		} else if (notaProvaUm < 0) {
			mensagem += "Informe uma nota maior ou igual a zero";
		}
		
		if (pesoProva == null) {
			mensagem += "Informe o peso das provas \n";
		} else if (pesoProva < 0 || pesoProva >1) {
			mensagem += "O peso das provas deve estar no intervalor entre zero e um";
		}
		
		if (pesoTrabalho == null) {
			mensagem += "Informe o peso dos trabalhos \n";
		} else if (pesoProva < 0 || pesoProva >1) {
			mensagem += "O peso das provas deve estar no intervalor entre zero e um";
		}
			
		return mensagem;
	}

	public String validarSoma(Aluno novoaluno) {
		return AlunoBO.verificarSoma(novoaluno);
		
	}
	
	public String salvar (Aluno novoAluno) {
		String situacao = null;
		
		double mediaFinal = bo.calcularMediaFinal(novoAluno);
		if (mediaFinal >= 8.5) {
			situacao = "�timo";
		} else if (mediaFinal >= 7) {
			situacao = "Bom";
		} else if (mediaFinal >=6) {
			situacao = "Satisfat�rio";
		} else {
			situacao = "Insatisfat�rio";
		}
		
		return situacao;
			
	}

	public double calcularNota(Aluno aluno) {
		return bo.calcularNota(aluno);
	}
	
}
