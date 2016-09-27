package br.com.alura.lista;

public class TarefaAdicionarElementoLista implements Runnable {

	private Lista lista;
	private int numeroDoThread;
	
	public TarefaAdicionarElementoLista(Lista lista, int numeroDoThread) {
		this.lista = lista;
		this.numeroDoThread = numeroDoThread;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++){
            try {
				lista.adicionaElementos("Thread " + numeroDoThread + " - " +  i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}

}
