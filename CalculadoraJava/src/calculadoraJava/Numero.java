package calculadoraJava;

public class Numero {
	private int valor;
	
	public Numero () {
		// estabele um valor padão na instanciação de todos os objetos da classe
		this.valor = 0;
	}
	
	public void setValor(int valor) {
		
		this.valor = valor;
	}
	
	public int getValor() {
		
		return valor;
	}
}
