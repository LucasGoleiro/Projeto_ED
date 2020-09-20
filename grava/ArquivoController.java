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
import javax.imageio.IIOException;
import javax.swing.JOptionPane;

import projeto_ed.Vestibulando;

public class ArquivoController implements IArquivoController {

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
				if (codigo == 1) {
					System.out.println(linha);
				} else {
					System.out.println(" --- C�DIGO N�O EXISTE ----- ");
				}
			}

		}

	}
	
	// --------------------- INSERE INFORMA��ES NA TABELA ----------------------
	@Override
	public void insereCadastro(Vestibulando vestibulando) throws IOException {
		File arq = new File("C://ed", "lista_vestibulando");
		String conteudo = (vestibulando.getCpf() + " " + vestibulando.getNome() + " " + vestibulando.getDataNasc() +" "+
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

}
