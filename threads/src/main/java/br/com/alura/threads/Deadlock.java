package br.com.alura.threads;

import java.io.File;

public class Deadlock {

	public static File arquivo1 = new File("arquivo1.txt");
	public static File arquivo2 = new File("arquivo2.txt");

	public static void main(String[] args) {

		// ATENÇÃO
		// este programa gera um deadlock pois as classes de leitura
		// acessam os arquivos simultaneamente enquanto executam procedimentos
		// sincronizados com estes arquivos
		new Thread(new LeitorArquivoAlpha(arquivo1, arquivo2)).start();
		new Thread(new LeitorArquivoBeta(arquivo1, arquivo2)).start();

	}

}
