package grava;

import java.io.IOException;
import javax.imageio.IIOException;

import projeto_ed.Vestibulando; 

public interface IArquivoController {

	    public void verificaDirTemp() throws IOException;
		public boolean verificaCadastro(int codigo) throws IOException;
		public void imprimeCadastro(int codigo) throws IOException;
		public void insereCadastro(Vestibulando vestibulando) throws IOException;
		
		
	}

