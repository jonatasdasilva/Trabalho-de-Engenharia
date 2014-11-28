/**
 * 
 */
package faixada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bd.Dados;
import materiais.Materiais;
import usuarios.AlunoGraduacao;
import usuarios.AlunoPosGraduacao;
import usuarios.Professor;
import usuarios.Usuarios;
import funcinalidades.Reservas;
import funcinalidades.Emprestimo;

/**
 * @author Jônatas da Silva e Romilson Santana
 *
 */
public class Singleton {
	
	private Singleton() {
		
	}
	
	
	//private static List<Usuarios>UserLista = new ArrayList<Usuarios>();
	//private static List<Materiais>MatLista = new ArrayList<Materiais>();
	private static List<Reservas>ResLista = new ArrayList<Reservas>();
	private static List<Emprestimo>ListaEmp = new ArrayList<Emprestimo>();
	
	private Usuarios usuario;
	private Materiais material;
	private Dados bancodedados;
	
	// "O Padão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela."
	private volatile static Singleton instance = null;
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
				}
			}
		}
		return instance;
	}

	public void cadastrarEmprestimo(short user, short mat){
		Iterator<Reservas> UsersIterator = ResLista.iterator();
		while(UsersIterator.hasNext()){
			Reservas p = (Reservas) UsersIterator.next();
			short cod = user;
			if(mat == p.getMaterial().getCodigo()){
				p = (Reservas) UsersIterator;
			}
			if (cod == p.getUsuario().getCodigo()){
				
			}
		}
		Emprestimo Emp = new Emprestimo((short)user, (short)mat);
		ListaEmp.add(Emp);
	}
	
	public void cadastrarReserva(short user, short mat){
		
	}
	
	public Usuarios procuraUsuario(short cod){
		// TODO Auto-generated method stub
		return bancodedados.getUsuarios(cod);
	}

	public Materiais procuraMaterial(short mat) {
		// TODO Auto-generated method stub
		return bancodedados.getMateriais(mat);
	}
}

