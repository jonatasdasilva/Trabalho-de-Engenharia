/**
 * 
 */
package comandos;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Modelo {
	//private String comando;
	private short codigoUser;
	private short codigoMat;
	
	/**
	 * 
	 */
	public Modelo(short codU, short codM) {
		// TODO Auto-generated constructor stub
		//this.comando = comand;
		this.codigoUser = codU;
		this.codigoMat = codM;	
	}

	//public String getComando() {
	//	return comando;
	//}

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
