package br.com.alura.threads;

import java.io.File;

public class LeitorArquivoBeta implements Runnable {

	private File arquivo1;
	private File arquivo2;

	public LeitorArquivoBeta(File arquivo1, File arquivo2) {
		this.arquivo1 = arquivo1;
		this.arquivo2 = arquivo2;
	}

	@Override
	public void run() {

		synchronized (arquivo2) {

			System.out.println("Usando arquivo2.");
			System.out.println("Nome do arquivo2 = " + arquivo2.getName());

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (arquivo1) {

				System.out.println("Usando arquivo1.");
				System.out.println("Nome do arquivo1 = " + arquivo1.getName());

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}

		}

	}

}
