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
	Singleton faixada = Singleton.getInstance();
	private short user;
	private short mat;
	
	public CommandEmp(String comand, short user, short mat) {
		super();
		// TODO Auto-generated constructor stub
		
	}

	public void execute(Modelo modelo){
		this.user = modelo.getCodigoUser();
		this.mat = modelo.getCodigoMat();
		faixada.cadastrarEmprestimo(user, mat);	
	}
}