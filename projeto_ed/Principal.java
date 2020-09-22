package projeto_ed;

import java.io.IOException;

import javax.swing.JOptionPane;

import grava.ArquivoController;

public class Principal {

	public static void main(String[] args) {
		int opc = 0;
		int cpf;
		int id;
		String mostrar;
		String nome;
		String dataNasc;
		String periodo;
		String curso;
		Metodos lista = new Metodos();
		Vestibulando vestibulando;
		
		ArquivoController arquivo = new ArquivoController();
		
		JOptionPane.showMessageDialog(null, "Vestibular Fatec 2020 \n Inscrições abertas !!!!!");
		
		id = Integer.parseInt(JOptionPane.showInputDialog("1 - Sou um candidato \n2 - Sou administrador"));
		
		if (id == 1) {
			
			while(opc != 9) {
				opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Fazer Inscrição \n9 - Sair"));
				
				switch(opc) {
				
				case 1: cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite seu CPF"));
						nome = JOptionPane.showInputDialog("Digite seu nome");
						dataNasc = JOptionPane.showInputDialog("Digite sua data de nascimento (DD/MM/AAAA)");
						curso = JOptionPane.showInputDialog("Digite o curso pretendido");
						periodo = JOptionPane.showInputDialog("Digite o período do curso pretendido");
						vestibulando = new Vestibulando(cpf, nome, dataNasc, curso, periodo);
						lista.AdicionaFinal(vestibulando);
						JOptionPane.showMessageDialog(null, "Inscrição efetuado com sucesso !!!!!");
					try {
						arquivo.insereCadastro(vestibulando);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
				
				case 2: try {
						arquivo.imprimeCadastro(2222222);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				case 7: mostrar = lista.Mostrar();
					try {
						arquivo.readFile("C://ed", "lista_vestibulando");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
						
				break;
				}
			}
		
			
		} else if (id == 2){
			while(opc != 9) {
				opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Mostrar lista de inscritos \n9 - Sair"));
				
				switch(opc) {
				
				case 1: //mostrar = lista.Mostrar();
				try {
					mostrar = arquivo.readFile("C://ed", "lista_vestibulando");
					JOptionPane.showMessageDialog(null, mostrar);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			    break;
				
				case 2: try {
						arquivo.imprimeCadastro(2222222);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
					
				
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Opção Inválida !!!!!");
		}
		
	}

}
