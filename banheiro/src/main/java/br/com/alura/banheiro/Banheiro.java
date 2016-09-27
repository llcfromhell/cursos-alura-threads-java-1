package br.com.alura.banheiro;

public class Banheiro {

	private boolean ehSujo = true;
	
	public void limpa() {

		bateNaPorta();
		
	    synchronized (this) {

	    	entraNoBanheiro();
	        
	    	if (!this.ehSujo) {
	            System.out.println(getNome() + ", não está sujo, vou sair");
	            return;
	        }

	        System.out.println(getNome() + " limpando o banheiro");
	        
	        this.ehSujo = false;

	        descansaPor(10000);
	        
	        this.notifyAll();

	        saiDoBanheiro();
	    }
	}

	private void saiDoBanheiro() {
		System.out.println(getNome() + " saindo do banheiro");
	}
	
	private void esperaLaFora(String nome) {

	    System.out.println(nome + ", eca, banheiro está sujo");
	    try {
	        this.wait();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
		
	private String getNome() {
		return Thread.currentThread().getName();
	}

	public void fazNumero1() {

		bateNaPorta();
		
		synchronized (this) {
			
			entraNoBanheiro();
	        
			verificaSujeira();
			
			System.out.println(getNome() + " fazendo coisa rapida");

			suja();
			
	        descansaPor(3000);

	        terminaESaiDoBanheiro();
			
		}
        
    }
	
	public void fazNumero2() {

		bateNaPorta();
		
		synchronized (this) {
		
	        entraNoBanheiro();
	        
	        verificaSujeira();
	        
	        System.out.println(getNome() + " fazendo coisa demorada");
	
	        descansaPor(5000);
	
	        terminaESaiDoBanheiro();
	        
		}
    }

	private void suja() {
		this.ehSujo = true;
	}
	
	private void bateNaPorta() {
		System.out.println(getNome() + " batendo na porta");
	}

	private void entraNoBanheiro() {
		System.out.println(getNome() + " entrando no banheiro");
	}

	private void verificaSujeira() {
		while (this.ehSujo) {
		    esperaLaFora(getNome());
		}
	}
	
	private void descansaPor(long millis) {
		try {
		    Thread.sleep(millis);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}

	private void terminaESaiDoBanheiro() {
		System.out.println(getNome() + " dando descarga");
        System.out.println(getNome() + " lavando a mao");
        saiDoBanheiro();
	}
	
		
	

}
