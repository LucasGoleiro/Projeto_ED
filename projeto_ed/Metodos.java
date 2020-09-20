package projeto_ed;

public class Metodos {
	
	private No inicio;
	
	public Metodos() {
		inicio = null;
	}
	
	public void AdicionaFinal(Vestibulando vestibulando) {
		if (inicio==null) {
			
			No n = new No(vestibulando);
			inicio=n;
		}
		else {
			
			No aux = inicio;
			while(aux.prox!=null){
				aux=aux.prox;
			}
			
			No n=new No(vestibulando);
			aux.prox=n;
		}
	}
	
	public String Mostrar(){
		No aux=inicio;
		String r=" ";
		while(aux!=null){
			r=r+"\n"+aux.vestibulando.getNome();
			aux=aux.prox;
		}
		return r;
	}



}
