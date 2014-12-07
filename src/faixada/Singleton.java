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
	//Sendo tamb�m um Facade, pois concentra todos os dados e delega certas fun��es para outras classes.
	private Usuarios usuario;
	private static Dados bancodedados;
	
	// "O Pad�o Singleton garante que uma classe tenha apenas uma inst�ncia e fornece um ponto global de acesso a ela."
	private static Singleton instance = null;
	// volatile -> Garante que v�rios segmentos ledem com a v�riavel 'instance' corretamente.
	/**
	 * @param args
	 */
	/*C�digo exsitente no livro: "Use a Cabe�a Padr�es de Pojetos"*/
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
		System.out.println("Estar na Devolu��o!");
		Usuarios usuario = bancodedados.getUsuarios(codigouser);
		Materiais material = bancodedados.getMateriais(codigomat);
		usuario.devolucao(usuario, material);
	}
	
	/**
	 * @param args
	 */
	public void consultaUsu(int codigouser){
		System.out.println("Estar na Consulta de Usu�rio!");
		Usuarios usuario = bancodedados.getUsuarios(codigouser);
		usuario.consultasUsu(usuario);
	}
	
	/**
	 * @param args
	 */
	public void consultaMat(int codigomat){
		System.out.println("Estar na Devolu��o!");
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