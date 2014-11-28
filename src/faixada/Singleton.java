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
	private short limite;
	
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
		Iterator<Reservas> ResIterator = ResLista.iterator();
		while(ResIterator.hasNext()){
			Reservas p = (Reservas)ResIterator.next();
			if(mat == p.getMaterial().getCodigo()){
				if (user == p.getUsuario().getCodigo()){
					criarEmprestimo(p.getUsuario(), p.getMaterial());
				}else{
					break;
				}
			}
		}
		usuario = bancodedados.getUsuarios(user);
		material = bancodedados.getMateriais(mat);
		criarEmprestimo(usuario, material);
	}
	
	private void criarReserva(short user, short mat){
		
	}
	
	public void criarEmprestimo(Usuarios user, Materiais mat){
		Iterator<Emprestimo> EmpIterator = ListaEmp.iterator();
		short ex = 0;
		short limite = 0;
		while(EmpIterator.hasNext()){
			Emprestimo e = (Emprestimo)EmpIterator.next();
			if (e.getUsuario() == user){
				limite = (short) (limite + (e.getUsuario().getQt()));
			}
			if(mat == e.getMaterial()){
				ex = (short) (ex + 1);		
			}
		}
		if (((limite/user.getQt()) < user.getQt()) && (ex < mat.getEx())){
			Emprestimo Emp = new Emprestimo(user, mat);
			ListaEmp.add(Emp);
		}else if (ex < mat.getEx()){
			System.out.println("Exemplar indisponivél");
		}else if (((limite/user.getQt()) < user.getQt())){
			System.out.println("O usuário exedeu o limite de Emprestimos!");
		}
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

