package br.com.alura.threads;

class ImprimeWorker implements Runnable {
	
	public void run() {

		Thread threadAtual = Thread.currentThread();
		long id = threadAtual.getId();
		
		for (int i = 1; i <= 1000; i++) {
			
			System.out.println("Número: " + i + " | Thread: " + id);
		
		
		}
		
	}
}