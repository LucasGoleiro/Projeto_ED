package projeto_ed;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		int opc = 0;
		int cpf;
		String mostrar;
		String nome;
		String dataNasc;
		String periodo;
		String curso;
		Metodos lista = new Metodos();
		Vestibulando vestibulando;
		
		while(opc != 99) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Fazer Inscrição \n7 - Mostrar vestibulandos"));
			
			switch(opc) {
			case 1: cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite seu CPF"));
					nome = JOptionPane.showInputDialog("Digite seu nome");
					dataNasc = JOptionPane.showInputDialog("Digite sua data de nascimento (DD/MM/AAAA)");
					curso = JOptionPane.showInputDialog("Digite o curso pretendido");
					periodo = JOptionPane.showInputDialog("Digite o período do curso pretendido");
					vestibulando = new Vestibulando(cpf, nome, dataNasc, curso, periodo);
					lista.AdicionaFinal(vestibulando);
			break;
			case 7: mostrar = lista.Mostrar();
					System.out.println(mostrar);
			}
		}
	
	}

}
