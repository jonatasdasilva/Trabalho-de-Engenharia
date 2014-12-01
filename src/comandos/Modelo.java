/**
 * 
 */
package comandos;

/**
 * @author Jônatas da Silva
 *
 */
public class Modelo {
	private String comando;
	private short codigoUser;
	private short codigoMat;
	
	/**
	 * 
	 */
	public Modelo(String comand, short codU, short codM) {
		// TODO Auto-generated constructor stub
		this.comando = comand;
		this.codigoUser = codU;
		this.codigoMat = codM;	
	}

	public String getComando() {
		return comando;
	}

	public short getCodigoUser() {
		return codigoUser;
	}

	public short getCodigoMat() {
		return codigoMat;
	}
}
