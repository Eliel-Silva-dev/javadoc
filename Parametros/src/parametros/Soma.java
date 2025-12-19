package parametros;

public class Soma {

	public static void main(String[] args) {
		
		System.out.println(soma(1,2,3,4,5,6,7));
	}
	
	public static int soma(int... numeros) {
		int res = 0;
		
		for(int n:numeros) {
			res += n;
		}
		return res;
		// o metodo construtor é automaticamente chamado no ato da instanciação do objeto.
		// Ele não precisa de especificação do tipo de retorno por que ele não retorna nada.
		// Para ser um metodo construtor ele precisa term o mesmo nome da classe. ex: public Soma(...){}
		
	}
}
