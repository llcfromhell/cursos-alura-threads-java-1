package br.com.alura.threads;

public class TarefaAcessaBancoProcedimento implements Runnable {

	private GerenciadorDeTransacao tx;
	private PoolDeConexao pool;

	public TarefaAcessaBancoProcedimento(GerenciadorDeTransacao tx, PoolDeConexao pool) {
		this.tx = tx;
		this.pool = pool;
	}

	// Run que vai gerar deadlock
	// @Override
	// public void run() {
	//
	// synchronized (tx) {
	//
	// System.out.println("Peguei a chave de tx.");
	// tx.begin();
	//
	// synchronized (pool) {
	//
	// System.out.println("Peguei a chave do pool");
	// pool.getConnection();
	//
	//
	// }
	//
	// }
	//
	// }

	@Override
	public void run() {

		synchronized (pool) {

			System.out.println("Peguei a chave do pool");
			pool.getConnection();

			synchronized (tx) {

				System.out.println("Peguei a chave de tx.");
				tx.begin();

			}

		}

	}

}
