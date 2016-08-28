package br.com.alura.threads;

public class RespostaMain {

	public static void main(String[] args) {
		ImprimeString imprimeString = new ImprimeString();
		Thread t = new Thread(imprimeString);
		t.start();
	}
	
}
