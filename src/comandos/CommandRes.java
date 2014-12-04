/**
 * 
 */
package comandos;

import faixada.Singleton;

/**
 * @author Jônatas da Silva e Romilson Santana
 *
 */
public class CommandRes implements Command{
	Singleton faixada = null;
	private Modelo model;
	private short user;
	private short mat;
	
	public CommandRes(Modelo mod) {
		//super();
		// TODO Auto-generated constructor stub
		this.model = mod;
		faixada = Singleton.getInstance();
	}

	public void execute(){
		this.user = model.getCodigoUser();
		this.mat = model.getCodigoMat();
		faixada.cadastrarReserva(user, mat);
	}
}
