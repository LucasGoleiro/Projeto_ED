package grava;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.IIOException;
import javax.swing.JOptionPane;

//import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import projeto_ed.Vestibulando;

public class ArquivoController implements IArquivoController {
	String[] listaOrdenada = new String[1000];
	
	int c = 0;

	// --------------------- VERIFICA SE DIRET�RIO EXISTE ----------------------
	@Override
	public void verificaDirTemp() throws IOException {
		File diretorio = new File("C://ed");
		if (diretorio.exists() && diretorio.isDirectory()) {
			System.out.println(" -------- DIRET�RIO EXISTE -------------");
		}else {
			System.out.println(" ----- DIRET�RIO N�O EXISTE ---------- \n");
			System.out.println("Criando diret�rio....");
			new File("C//ed").mkdir();
		}		
		
	}
	// --------------------- VERIFICA SE O ARQUVIO EXISTE NO DIRET�RIO ----------------------
	@Override
	public boolean verificaCadastro(int codigo) throws IOException {
		File arq = new File("C://ed", "lista_vestibulando");
		boolean existe = false;

		if (arq.exists() && arq.isFile()) {
			System.out.println(" --------- LENDO ARQUIVO --------- ");
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) { // procurando End of File
				String texto;
				texto = linha;
				linha = buffer.readLine();
				if (codigo != 0) {
					existe = true;
					
				} else {
					existe = false;
				}
			}

		} else {
			throw new IOException("Diret�rio inv�lido");
		}
		return existe;

	}

	// --------------------- IMPRIME INFORMA��ES DO CADASTRO ----------------------
	@Override
	public void imprimeCadastro(int codigo) throws IOException {
		boolean existe = verificaCadastro(codigo);

		if (existe == true) {
			File arq = new File("C://ed","lista_vestibulando");
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) { // procurando End of File
				String texto;
				texto = linha;
				linha = buffer.readLine();
				if (existe) {
					JOptionPane.showMessageDialog(null, "Vestibulando j� cadastrado");
				} else {
					JOptionPane.showMessageDialog(null, "Vestibulando n�o cadastrado");
				}
			}

		}

	}
	
	// --------------------- INSERE INFORMA��ES NA TABELA ----------------------
	@Override
	public void insereCadastro(Vestibulando vestibulando) throws IOException {
		File arq = new File("C://ed", "lista_vestibulando");
		String conteudo = ( vestibulando.getNome() + " " + vestibulando.getCpf()  + " " + vestibulando.getDataNasc() +" "+
				vestibulando.getCurso() +" "+ vestibulando.getPeriodo() + "; \n");
		boolean existe = false;
		//boolean existe = verificaCadastro(arquivo, codigo);
		if (existe == false) {
			FileWriter filewriter = new FileWriter(arq, true);
			PrintWriter print = new PrintWriter(filewriter);
			print.write(conteudo);
			print.flush();
			print.close();
			filewriter.close();			
			
		}
	

	}
	
	// --------------------- LE E IMPRIME DADOS DO ARQUIVO TXT ----------------------
	public String[] readFile(String path, String nome) throws IOException { 
		String lista = "";
		
		File arq = new File("C://ed", "lista_vestibulando");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) { // procurando End of File
				listaOrdenada[this.c] = linha;
				c++;
				//System.out.println(linha);
				lista += linha + "\n";
				linha = buffer.readLine();				
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			throw new IOException("Arquivo Inv�lido");
		}
		JOptionPane.showMessageDialog(null, lista);
		String[] listaOrdenadaFinal = new String[this.c];
		int b = 0;
		while (b < this.c) {
			listaOrdenadaFinal[b] = listaOrdenada[b]; 
			b++;
		}
		return listaOrdenadaFinal;
	}

}
