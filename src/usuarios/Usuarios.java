package usuarios;

/**
 * @author Jônatas da Silva e Romilson Santana
 *
 */

public class Usuarios {
	short codigo;
	String nome;
	String tipo;
	//short time;
	short qt; //quantidade de exemplares maxima que pode emprestar. em um metodo ele percorre a lsita de emprestimos e verifica essa variavel q decrementa ela até chegar no ficnal do loop se ela for 0 não pode mais ter emprestimo para aquele usuario.
	 
	public short getCodigo() {
		return codigo;
	}
	public String getNome(){
		return nome;
	}
	public String getTipo(){
		return tipo;
	}
	
	public void deternimaTempo(short time){
		
	}
}
