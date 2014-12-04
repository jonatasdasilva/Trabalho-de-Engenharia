/**
 * 
 */
package comandos;

import faixada.Singleton;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class CommandEmp implements Command{
	Singleton faixada = null;
	private Modelo model;
	private short user;
	private short mat;
	
	public CommandEmp(Modelo mod) {
		//super();
		// TODO Auto-generated constructor stub
		this.model = mod;
		faixada = Singleton.getInstance();
	}

	public void execute(){
		this.user = model.getCodigoUser();
		this.mat = model.getCodigoMat();
		faixada.cadastrarEmprestimo(user, mat);
	}
}