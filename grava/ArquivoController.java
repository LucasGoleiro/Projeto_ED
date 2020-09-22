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

//import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import projeto_ed.Vestibulando;

public class ArquivoController implements IArquivoController {

	// --------------------- VERIFICA SE DIRETÓRIO EXISTE ----------------------
	@Override
	public void verificaDirTemp() throws IOException {
		File diretorio = new File("C://ed");
		if (diretorio.exists() && diretorio.isDirectory()) {
			System.out.println(" -------- DIRETÓRIO EXISTE -------------");
		}else {
			System.out.println(" ----- DIRETÓRIO NÃO EXISTE ---------- \n");
			System.out.println("Criando diretório....");
			new File("C//ed").mkdir();
		}		
		
	}
	// --------------------- VERIFICA SE O ARQUVIO EXISTE NO DIRETÓRIO ----------------------
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
			throw new IOException("Diretório inválido");
		}
		return existe;

	}

	// --------------------- IMPRIME INFORMAÇÕES DO CADASTRO ----------------------
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
					System.out.println(" --- CÓDIGO NÃO EXISTE ----- ");
				}
			}

		}

	}
	
	// --------------------- INSERE INFORMAÇÕES NA TABELA ----------------------
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
	
	// --------------------- LE E IMPRIME DADOS DO ARQUIVO TXT ----------------------
	public String readFile(String path, String nome) throws IOException { 
		String lista = "";
		File arq = new File("C://ed", "lista_vestibulando");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) { // procurando End of File
				System.out.println(linha);
				lista += linha + "\n";
				linha = buffer.readLine();				
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			throw new IOException("Arquivo Inválido");
		}
		return lista;
	}

}
