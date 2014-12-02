/**
 * 
 */
package comandos;

import java.util.HashMap;

/**
 * @author Jônatas da Silva e Romilson Santana
 *
 */
public class Comandos {
	private HashMap commands = new HashMap();
	private Modelo model;
	public Comandos(){
		iniciarComandos();
	}
	
	
	private void iniciarComandos(){
		String codigouser;
		short codigomat;
		//commands.put(new CommandEmp("emp", codigouser, codigomat));
		//commands.put("dev", new CommandDev());
		//commands.put("res", new CommandRes());
		//commands.put("mat", new CommandMat());
		//commands.put("usu", new CommandUsu());
	}
}