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


	private short codigoUser;
	private short codigoMat;
	
	/**
	 * 
	 */
	public Modelo(String command, short codU, short codM) {
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

	public short getCodigoUser() {
		return codigoUser;
	}

	public short getCodigoMat() {
		return codigoMat;
	}
	
	public void setCodigoUser(short user){
		this.codigoUser = user;
	}
	
	public void setCodigoMat(short mat){
		this.codigoMat = mat;
	}
}
