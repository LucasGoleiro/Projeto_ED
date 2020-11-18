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
	
	/*
	 * Ordenacao
	 */
	public void mergeSort(String[] vetor) {
		if (vetor.length == 1)
			return;

		int metade = vetor.length / 2;

		String[] esquerda = new String[metade];
		String[] direita = new String[vetor.length - metade];

		for (int i = 0; i < vetor.length; i++) {
			if (i < metade)
				esquerda[i] = vetor[i];
			else
				direita[i - metade] = vetor[i];
		}

		mergeSort(esquerda);
		mergeSort(direita);
		intercala(vetor, esquerda, direita);
		
	}
	
public void intercala(String[] vetor, String[] esquerda, String[] direita) {
		
		//indices
		int iEsquerda = 0;
		int iDireita = 0;
		
		for (int k = 0; k < vetor.length; k++) {
			if (iEsquerda == esquerda.length) {
				vetor[k] = direita[iDireita];
				iDireita++;
			} else if (iDireita == direita.length) {
				vetor[k] = esquerda[iEsquerda];
				iEsquerda++;
			} else if (esquerda[iEsquerda].compareToIgnoreCase(direita[iDireita]) < 0) {
				vetor[k] = esquerda[iEsquerda];
				iEsquerda++;
			} else {
				vetor[k] = direita[iDireita];
				iDireita++;
			}
		}
}


}
