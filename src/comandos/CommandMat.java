/**
 * 
 */
package comandos;

import faixada.Singleton;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class CommandMat implements Command{
	Singleton faixada = null;
	private Modelo model;
	private short user;
	private short mat;
	
	public CommandMat(Modelo mod) {
		//super();
		// TODO Auto-generated constructor stub
		this.model = mod;
		faixada = Singleton.getInstance();
	}

	public void execute(){
		this.mat = model.getCodigoMat();
		faixada.consultaMaterial(mat);
	}
}
