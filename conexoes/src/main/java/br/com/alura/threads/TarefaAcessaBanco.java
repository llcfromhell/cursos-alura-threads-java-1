package br.com.alura.threads;

public class TarefaAcessaBanco implements Runnable {

	private GerenciadorDeTransacao tx;
	private PoolDeConexao pool;

	public TarefaAcessaBanco(GerenciadorDeTransacao tx, PoolDeConexao pool) {
		this.tx = tx;
		this.pool = pool;
	}

	@Override
	public void run() {

		synchronized (pool) {
		
			System.out.println("Peguei a chave do pool.");
			pool.getConnection();
			
			synchronized (tx) {
				
				System.out.println("Peguei a chave de tx.");
				tx.begin();
				
			}
			
		}
		
	}

}
