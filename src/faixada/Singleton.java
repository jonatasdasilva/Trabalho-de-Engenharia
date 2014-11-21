/**
 * 
 */
package faixada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	
	private static List<Usuarios>UserLista = new ArrayList<Usuarios>();
	private static List<Materiais>MatLista = new ArrayList<Materiais>();
	private static List<Reservas>ResLista = new ArrayList<Reservas>();
	private static List<Emprestimo>ListaEmp = new ArrayList<Emprestimo>();
	
	private Usuarios usuario;
	private Materiais material;
	
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
		Emprestimo Emp = new Emprestimo((short)user, (short)mat);
		ListaEmp.add(Emp);
	}
	
	public void cadastrarReserva(int user, int mat){
		
	}
	
	public void cadastrarUsuario(short user, String tipo, String nome){
		if (tipo == "Aluno de Graduação"){
			UserLista.add(new AlunoGraduacao(user, tipo, nome));
		}else if(tipo == "Aluno de Pós-graduação"){
			UserLista.add(new AlunoPosGraduacao(user, tipo, nome));
		}else if(tipo == "Professor"){
			UserLista.add(new Professor(user, tipo, nome));
		}
	}
	
	public void cadastrarMaterial(int mat, String titulo, String editora, String Autores, int ed, int anoP){
		
	}
	
	public Usuarios procuraUsuario(short cod){
		Iterator<Usuarios> i = UserLista.iterator();
		while(i.hasNext()){
			Usuarios element = (Usuarios) i.next();
			if (element.getCodigo() == cod){
				return element;
			}
		}
		return null;
	}

	public Materiais procuraMaterial(short mat) {
		// TODO Auto-generated method stub
		Iterator<Materiais> i = MatLista.iterator();
		while(i.hasNext()){
			Materiais element = (Materiais) i.next();
			if (element.getCodigo() == mat){
				return element;
			}
		}
		return null;
	}
}

