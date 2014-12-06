/**
 * 
 */
package gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comandos.*;
import entradadedados.Keyboard;
import faixada.Singleton;
import usuarios.Usuarios;
/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class InterfaceBiblioteca {
	Singleton faixada = Singleton.getInstance();
	static Modelo model = new Modelo((short)0, (short)0);
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
		short user;
		short mat;
		String retorno;
		// TODO Auto-generated method stub
		iniciarCommands();
		System.out.println("Para Sair digite: \"sair\"");
		for(;;){
			String s = Keyboard.readString();
			String dados[] = s.split(" ");
			System.out.println(dados.toString());
			System.out.println(dados[0]);
			System.out.println(dados[1]);
			System.out.println(dados[2]);
			if(dados[0].endsWith("emp")){
				System.out.println("entrou aki");
				user = Short.parseShort(dados[1]);
				mat = Short.parseShort(dados[2]);
				model.setCodigoUser(user);
				System.out.println(model.getCodigoUser());
				model.setCodigoMat(mat);
				System.out.println(model.getCodigoMat());
				c = (Command) comandos.get(dados[0]);
				retorno = c.execute(model);
				System.out.println(retorno);
			}else if (dados[0] == "res"){
				user = Short.parseShort(dados[1]);
				mat = Short.parseShort(dados[2]);
				model.setCodigoUser(user);
				model.setCodigoMat(mat);
				c = (Command) comandos.get(dados[0]);
				retorno = c.execute(model);
				System.out.println(retorno);
			}else if (dados[0] == "usu"){
				user = Short.parseShort(dados[1]);
				mat = 0;
				model.setCodigoUser(user);
				model.setCodigoMat(mat);
				c = (Command) comandos.get(dados[0]);
				retorno = c.execute(model);
				System.out.println(retorno);
			}else if (dados[0] == "mat"){
				user = 0;
				mat = Short.parseShort(dados[2]);
				model.setCodigoUser(user);
				model.setCodigoMat(mat);
				c = (Command) comandos.get(dados[0]);
				retorno = c.execute(model);
				System.out.println(retorno);
			}else if (dados[0] == "dev"){
				user = Short.parseShort(dados[1]);
				mat = Short.parseShort(dados[2]);
				model.setCodigoUser(user);
				model.setCodigoMat(mat);
				c = (Command) comandos.get(dados[0]);
				retorno = c.execute(model);
				System.out.println(retorno);
			}else if (dados[0] == "sair"){
				System.out.println("Obridago, tenha um bom dia e volte sempre!");
				break;
			}
		}
	}
}