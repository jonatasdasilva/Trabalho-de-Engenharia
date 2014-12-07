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
	//Sendo também um Facade, pois concentra todos os dados e delega certas funções para outras classes.
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
	public void emprestar(int codigouser, int codigomat){
		System.out.println("Estar no emprestar");
		Usuarios usuario = bancodedados.getUsuarios(codigouser);
		Materiais material = bancodedados.getMateriais(codigomat);
		usuario.emprestimo(usuario, material);
		System.out.println("Saiu do emprestimo");
	}
	
	/**
	 * @param args
	 */
	public void reservar(int codigouser, int codigomat){
		System.out.println("Estar na Reserva!");
		Usuarios usuario = bancodedados.getUsuarios(codigouser);
		Materiais material = bancodedados.getMateriais(codigomat);
		usuario.reserva(usuario, material);
	}
	
	/**
	 * @param args
	 */
	public void devolver(int codigouser, int codigomat){
		System.out.println("Estar na Devolução!");
		Usuarios usuario = bancodedados.getUsuarios(codigouser);
		Materiais material = bancodedados.getMateriais(codigomat);
		usuario.devolucao(usuario, material);
	}
	
	/**
	 * @param args
	 */
	public void consultaUsu(int codigouser){
		System.out.println("Estar na Consulta de Usuário!");
		Usuarios usuario = bancodedados.getUsuarios(codigouser);
		usuario.consultasUsu(usuario);
	}
	
	/**
	 * @param args
	 */
	public void consultaMat(int codigomat){
		System.out.println("Estar na Devolução!");
		Materiais material = bancodedados.getMateriais(codigomat);
		usuario.consultasMat(material);
	}
	
	/**
	 * @param args
	 */
	public Usuarios procuraUsuario(int user){
		// TODO Auto-generated method stub
		return bancodedados.getUsuarios(user);
	}
	/**
	 * @param args
	 */
	public Materiais procuraMaterial(int mat) {
		// TODO Auto-generated method stub
		return bancodedados.getMateriais(mat);
	}
}