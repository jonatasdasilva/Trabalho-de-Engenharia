/**
 * 
 */
package materiais;

/**
 * @author Jônatas da Silva e Romilson Santana
 *
 */
public class Materiais {
	String titulo;
	short codigo;
	short ano;
	short ex;
	
	/**
	 * @param args
	 */
	public short getCodigo(){
		return codigo;
	}

	public short getEx() {
		return ex;
	}

	public void setEx(short ex) {
		this.ex = ex;
	}

	public String getTitulo() {
		return titulo;
	}

	public short getAno() {
		return ano;
	}

}
