/**
 * 
 */
package comandos;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Modelo {
	private String comando;
	private int codigoUser;
	private int codigoMat;
	
	/**
	 * 
	 */
	public Modelo(String command, int codU, int codM) {
		// TODO Auto-generated constructor stub
		this.comando = command;
		this.codigoUser = codU;
		this.codigoMat = codM;	
	}
	/**
	 * @return the comando
	 */
	public String getComando() {
		return comando;
	}

	/**
	 * @param comando the comando to set
	 */
	public void setComando(String comando) {
		this.comando = comando;
	}

	public int getCodigoUser() {
		return codigoUser;
	}

	public int getCodigoMat() {
		return codigoMat;
	}
	
	public void setCodigoUser(int user){
		this.codigoUser = user;
	}
	
	public void setCodigoMat(int mat){
		this.codigoMat = mat;
	}
}
