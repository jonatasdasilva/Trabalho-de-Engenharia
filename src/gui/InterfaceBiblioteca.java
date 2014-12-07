/**
 * 
 */
package gui;

import java.util.HashMap;
import comandos.*;
import entradadedados.Keyboard;
import faixada.Singleton;
/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class InterfaceBiblioteca {
	Singleton faixada = Singleton.getInstance();
	static Modelo model = new Modelo(null, 0, 0);
	static HashMap<String, Command> comandos = new HashMap<String, Command>();
	/* Inicializando o hashmap dos comandos!*/
	public static void iniciarCommands(){
		System.out.println("Comandos sendo inseridos");
		comandos.put("emp", new CommandEmp());
		comandos.put("res", new CommandRes());
		comandos.put("dev", new CommandDev());
		comandos.put("usu", new CommandUsu());
		comandos.put("mat", new CommandMat());
		System.out.println("Comandos inseridos");
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Command c;
		int user;
		int mat;
		//boolean sair = false;
		
		// TODO Auto-generated method stub
		System.out.println("Para Sair digite: \"sair\"");
		iniciarCommands();
		
		for(;;){
			String s = Keyboard.readString();
			String dados[] = s.split(" ");
			System.out.println(dados.toString());
			System.out.println(dados[0]);
			System.out.println(dados[1]);
			System.out.println(dados[2]);
			if(dados[0].endsWith("emp")){
				System.out.println("entrou aki");
				user = Integer.parseInt(dados[1]);
				mat = Integer.parseInt(dados[2]);
				model.setCodigoUser(user);
				model.setCodigoMat(mat);
				model.setComando(dados[0]);
				c = (Command) comandos.get(model.getComando());
				c.execute(model);
			}else if (dados[0].endsWith("res")){
				user = Integer.parseInt(dados[1]);
				mat = Integer.parseInt(dados[2]);
				model.setCodigoUser(user);
				model.setCodigoMat(mat);
				model.setComando(dados[0]);
				c = (Command) comandos.get(model.getComando());
				c.execute(model);
			}else if (dados[0].endsWith("usu")){
				user = Integer.parseInt(dados[1]);
				mat = 0;
				model.setCodigoUser(user);
				model.setCodigoMat(mat);
				model.setComando(dados[0]);
				c = (Command) comandos.get(model.getComando());
				c.execute(model);
			}else if (dados[0].endsWith("mat")){
				user = 0;
				mat = Integer.parseInt(dados[2]);
				model.setCodigoUser(user);
				model.setCodigoMat(mat);
				model.setComando(dados[0]);
				c = (Command) comandos.get(model.getComando());
				c.execute(model);
			}else if (dados[0].endsWith("dev")){
				user = Integer.parseInt(dados[1]);
				mat = Integer.parseInt(dados[2]);
				model.setCodigoUser(user);
				model.setCodigoMat(mat);
				model.setComando(dados[0]);
				c = (Command) comandos.get(model.getComando());
				c.execute(model);
			}else if (dados[0].endsWith("sair")){
				System.out.println("Obridago, tenha um bom dia, e volte sempre!");
				break;
			}
		}
	}
}