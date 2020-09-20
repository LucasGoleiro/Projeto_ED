package projeto_ed;

public class Vestibulando {
	
	private int cpf;
	private String nome;
	private String dataNasc;
	private String curso;
	private int codInscricao;
	private String periodo;
	private int nota1;
	private int nota2;
	
	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}


	public int getCodInscricao() {
		return codInscricao;
	}

	public void setCodInscricao(int codInscricao) {
		this.codInscricao = codInscricao;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Vestibulando(int cpf, String nome, String dataNasc, String curso, String periodo) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc  = dataNasc;
		this.curso = curso;
		this.periodo = periodo;
		
	}
	

}
