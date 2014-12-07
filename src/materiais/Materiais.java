/**
 * 
 */
package materiais;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Materiais {
	String titulo;
	String tipo;
	int codigo;
	int ano;
	int ex;
	
	/**
	 * @param args
	 */
	public int getCodigo(){
		return codigo;
	}

	public int getEx() {
		return ex;
	}

	public void setEx(int ex) {
		this.ex = ex;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAno() {
		return ano;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

}
