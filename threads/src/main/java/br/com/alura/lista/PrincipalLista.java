package br.com.alura.lista;

public class PrincipalLista {

	public static void main(String[] args) throws InterruptedException {
		
		Lista lista = new Lista();
		
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new TarefaAdicionarElementoLista(lista, i));
			thread.start();
		}
		
		new Thread(new TarefaImprimir(lista)).start();

	}

}
