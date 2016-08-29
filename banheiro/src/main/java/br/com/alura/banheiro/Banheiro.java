package br.com.alura.banheiro;

public class Banheiro {
	
	public void fazNumero1() {

		
		synchronized (this) {
		
			System.out.println(getNome() + " entrando no banheiro");
	        System.out.println(getNome() + " fazendo coisa rapida");

	        try {
	            Thread.sleep(8000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        msgEnd();
			
		}
		
        
    }

	private String getNome() {
		return Thread.currentThread().getName();
	}
	
	public void fazNumero2() {

		synchronized (this) {
		
	        System.out.println(getNome() + " entrando no banheiro");
	        System.out.println(getNome() + " fazendo coisa demorada");
	
	        try {
	            Thread.sleep(15000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	
	        msgEnd();
	        
		}
    }

	private void msgEnd() {
		System.out.println(getNome() + " dando descarga");
        System.out.println(getNome() + " lavando a mao");
        System.out.println(getNome() + " saindo do banheiro");
	}
	
		
	

}
