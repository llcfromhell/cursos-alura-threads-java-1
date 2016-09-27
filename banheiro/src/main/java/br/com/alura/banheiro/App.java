package br.com.alura.banheiro;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Banheiro banheiro = new Banheiro();
    	
    	//Passando a tarefa e o nome do Thread
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");

        Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
        limpeza.setDaemon(true);
        limpeza.setPriority(Thread.MAX_PRIORITY);
        
        convidado1.start();
        convidado2.start();
        
        limpeza.start();
    }
}
