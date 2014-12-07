/**
 * 
 */
package comandos;

import faixada.Singleton;

/**
 * @author Jonatas da Silva e Romilson Santana 
 *
 */
public class CommandDev implements Command{

	@Override
	public void execute(Modelo model) {
		// TODO Auto-generated method stub
		Singleton faixada = Singleton.getInstance();
		System.out.println("PASSOU! CommandDev");
		faixada.devolver(model.getCodigoUser(), model.getCodigoMat());
	}
}
