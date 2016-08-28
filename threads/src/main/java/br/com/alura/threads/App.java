package br.com.alura.threads;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String nomeProcurado = "(Dan|Chad)(\\s|\\w)*";

        Thread threadAutores = new Thread(new TarefaBuscaNome("autores.txt", nomeProcurado));
        Thread threadAssinaturas1 = new Thread(new TarefaBuscaNome("assinaturas1.txt", nomeProcurado));
        Thread threadAssinaturas2 = new Thread(new TarefaBuscaNome("assinaturas2.txt", nomeProcurado));
        
        threadAssinaturas1.start();
        threadAssinaturas2.start();
        threadAutores.start();
        
    }
}
