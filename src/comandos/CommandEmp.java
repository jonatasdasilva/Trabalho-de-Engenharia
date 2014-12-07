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
	public CommandEmp() {
	}

	public void execute(Modelo model){
		Singleton faixada = Singleton.getInstance();
		System.out.println("PASSOU! Command");
		faixada.emprestimo(model);
	}
}