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

	public String execute(Modelo model){
		Singleton faixada = Singleton.getInstance();
		System.out.println("PASSOU! Command");
		String resposta = faixada.emprestimo(model.getCodigoUser(), model.getCodigoMat());
		System.out.println(resposta);
		return (resposta);
	}
}