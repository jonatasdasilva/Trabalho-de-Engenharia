/**
 * 
 */
package comandos;

import faixada.Singleton;

/**
 * @author Jônatas da Silva e Romilson Santana
 *
 */
public class CommandEmp implements Command{
	Singleton faixada = Singleton.getInstance();
	private short user;
	private short mat;
	
	public CommandEmp(short usuario, short material) {
		super();
		// TODO Auto-generated constructor stub
		this.user = usuario;
		this.mat = material;
		execute();
	}

	public void execute(){
		faixada.cadastrarEmprestimo(user, mat);
		
	}
}