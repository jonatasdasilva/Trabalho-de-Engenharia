/**
 * 
 */
package faixada;

import materiais.*;
import comandos.Modelo;
import bd.Dados;
import usuarios.*;


/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Singleton {
	
	private Singleton() {	
	}

	private Usuarios usuario;
	private static Dados bancodedados;
	
	// "O Padão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela."
	private static Singleton instance = null;
	// volatile -> Garante que vários segmentos ledem com a váriavel 'instance' corretamente.
	/**
	 * @param args
	 */
	/*Código exsitente no livro: "Use a Cabeça Padrões de Pojetos"*/
	public static Singleton getInstance() {
		// TODO Auto-generated method stub
		if (instance == null){
			synchronized (Singleton.class) {
				if (instance == null){
					instance = new Singleton();
					bancodedados  = Dados.getInstance();
				}
			}
		}
		return instance;
	}
	/**
	 * @param args
	 */
	public void emprestimo(Modelo model){
		usuario.emprestimo(model);
	}
	
	/**
	 * @param args
	 */
	public void reservar(Modelo model){
		usuario.reserva(model);
	}
	
	/**
	 * @param args
	 */
	public void devolucao(Modelo model){
		usuario.devolucao(model);
	}
	
	/**
	 * @param args
	 */
	public void consultaUsu(Modelo model){
		usuario.consultasUsu(model);
	}
	
	/**
	 * @param args
	 */
	public void consultaMat(Modelo model){
		usuario.consultasMat(model);
	}
	
	/**
	 * @param args
	 */
	public Usuarios procuraUsuario(short user){
		// TODO Auto-generated method stub
		return bancodedados.getUsuarios(user);
	}
	/**
	 * @param args
	 */
	public Materiais procuraMaterial(short mat) {
		// TODO Auto-generated method stub
		return bancodedados.getMateriais(mat);
	}
}