package projeto_ed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		String[] listaOrdenada = null;
		
		ArquivoController arquivo = new ArquivoController();
		
		JOptionPane.showMessageDialog(null, "Vestibular Fatec 2020 \n Inscrições abertas !!!!!");
		JOptionPane.showMessageDialog(null, "Inscrições para o processo seletivo____________03/10/2019 a 27/10/2019\n"
										  + "Divulgação das inscrições deferidas____________30/10/2019\n"
										  + "Solicitação de recursos sobre as inscrições____31/10/2019 a 01/11/2019\n"
										  + "Divulgação das inscrições homologadas__________04/11/2019\n"
										  + "Processo seletivo Etapa 1______________________04/11/2019 a 08/11/2019\n"
										  + "Divulgação do resultado da Etapa 1_____________11/11/2019\n"
										  + "Divulgação do cronograma das entrevistas_______13/11/2019\n"
										  + "Processo seletivo Etapa 2______________________18/11/2019 a 22/11/2019\n"
										  + "Divulgação de resultado preliminar_____________02/12/2019\n"
										  + "Solicitação de recursos da nota final__________09/12/2019\n"
										  + "Divulgação da classificação final______________16/12/2019\n"
										  + "Matrícula______________________________________08/01/2020 a 17/01/2020\n"
										  + "Segunda chamada para vagas remanescentes_______20/01/2020 a 24/01/2020\n"
										  + "Início das Aulas_______________________________17/02/2020");
		
		id = Integer.parseInt(JOptionPane.showInputDialog("1 - Sou um candidato \n2 - Sou administrador"));
		
		if (id == 1) {
			
			while(opc != 9) {
				opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Fazer Inscrição \n9 - Sair"));
				
				switch(opc) {
				
				case 1: nome = JOptionPane.showInputDialog("Digite seu nome");
						cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite seu CPF"));
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
				
				case 9: System.exit(0);
				
				default:
				JOptionPane.showMessageDialog(null,"Opção inválida");
				}
			}
		
			
		} else if (id == 2){
			while(opc != 9) {
				String listaOrdenadaFinal = "";
				int codigo;
				String [] vetor = {"Guilherme S", " Luciana", "Mat ilde", "Lucas", "Arnaldo", "Kleber", "Viviane"};
				opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Mostrar lista de inscritos \n2 - Pesquisar vestibulando \n3 - Ordenar por nome \n9 - Sair"));
				
				switch(opc) {
				
				case 1: //mostrar = lista.Mostrar();
				try {
					listaOrdenada = arquivo.readFile("C://ed", "lista_vestibulando");
					
					//JOptionPane.showMessageDialog(null, mostrar);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			    break;
				
				case 2: codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF no vestibulando:"));
					try {
						arquivo.imprimeCadastro(codigo);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
				case 3: lista.mergeSort(listaOrdenada);
				for (int i = 0; i < listaOrdenada.length; i++) {
					listaOrdenadaFinal += listaOrdenada[i];
					listaOrdenadaFinal += "\n";
					//System.out.println(listaOrdenada[i]);
					
				}
				JOptionPane.showMessageDialog(null, listaOrdenadaFinal);
				break;
				
				case 9: System.exit(0);
				
				default:
				JOptionPane.showMessageDialog(null,"Opção inválida");
					
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Opção Inválida !!!!!");
		}
		
	}

}
