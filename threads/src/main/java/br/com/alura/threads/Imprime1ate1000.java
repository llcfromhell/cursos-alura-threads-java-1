package br.com.alura.threads;

public class Imprime1ate1000 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ImprimeWorker());
		Thread t2 = new Thread(new ImprimeWorker());
		
		t1.start();
		t2.start();

	}

}
