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
import funcinalidades.Consultas;
import funcinalidades.Reservas;
import funcinalidades.Emprestimo;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Singleton {
	
	private Singleton() {
		
	}

	//private static List<Reservas>ResLista = new ArrayList<Reservas>();
	//private static List<Emprestimo>ListaEmp = new ArrayList<Emprestimo>();
	
	private Usuarios usuario;
	private Materiais material;
	private Consultas consulta;
	private static Dados bancodedados;
	private short limite;
	
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
			//synchronized (Singleton.class) {
				//if (instance == null){
					instance = new Singleton();
					bancodedados  = Dados.getInstance();
				//}
			//}
		}
		return instance;
	}
	/**
	 * @param args
	 */
	public String emprestimo(short user, short mat){
		String resposta = usuario.cadastrarEmprestimo(user, mat);
		return (resposta);
	}
	
	/**
	 * @param args
	 */
	public String reserva(short user, short mat){
		String resposta = usuario.cadastrarReserva(user, mat);
		return (resposta);
	}
	
	/**
	 * @param args
	 */
	public String devolucao(short user, short mat){
		String resposta = usuario.devolver(user, mat);
		return (resposta);
	}
	
	/**
	 * @param args
	 */
	public String consultaUsu(short user, short mat){
		String resposta = usuario.cadastrarEmprestimo(user, mat);
		return (resposta);
	}
	
	/**
	 * @param args
	 */
	public String consultaMat(short user, short mat){
		String resposta = usuario.cadastrarEmprestimo(user, mat);
		return (resposta);
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
	
	public void consultaUsuario(short user){
		// TODO Auto-generated method stub
		consulta.listaConsultaDeUsuario(user);
	}
	public void consultaMaterial(short mat) {
		// TODO Auto-generated method stub
		consulta.listaConsultaDeMaterial(mat);
	}
}