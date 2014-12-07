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
	public CommandEmp() {
	}

	public void execute(Modelo model){
		// TODO Auto-generated method stub
		Singleton faixada = Singleton.getInstance();
		System.out.println("PASSOU! CommandEmp");
		faixada.emprestar(model.getCodigoUser(), model.getCodigoMat());
	}
}