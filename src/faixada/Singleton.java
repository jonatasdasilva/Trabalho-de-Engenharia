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
	/**
	 * @param args
	 */
	public void cadastrarEmprestimo(short user, short mat){
		Iterator<Reservas> ResIterator = ResLista.iterator();
		short achou = 0;
		usuario = bancodedados.getUsuarios(user);
		material = bancodedados.getMateriais(mat);
		while(ResIterator.hasNext()){
			Reservas p = (Reservas)ResIterator.next();
			if(material == p.getMaterial()){
				achou = (short) (achou + 1);
				if (usuario == p.getUsuario()){
					criarEmprestimo(usuario, material);
					ResLista.remove(p);
				}else{
					achou = (short) (achou + 1);
				}
			}
		}
		if(achou < material.getEx()){
			criarEmprestimo(usuario, material);
		}
	}
	/**
	 * @param args
	 */	
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
			System.out.println("O emprestimo foi efetuado!");
			System.out.println("De "+mat.getTitulo()+", para o usuário: "+user.getNome());
		}else if (ex >= mat.getEx()){
			System.out.println("Exemplar indisponivel, ecedeu a quantidade de exemplares!");
			System.out.println("De: "+mat.getTitulo()+", para o usuário: "+user.getNome());
			//listaExemplares(mat);
		}else if (((limite/user.getQt()) >= user.getQt()) && (user.getTipo() != "Professor")){
			System.out.println("O usuário exedeu o limite de Emprestimos!");
			System.out.println("O usuário: "+user.getNome()+" De: "+ mat.getTitulo());
			//listaMateriais(mat);
		}
	}
	/**
	 * @param args
	 */
	public void cadastrarReserva(short user, short mat){
		usuario = bancodedados.getUsuarios(user);
		material = bancodedados.getMateriais(mat);
		Iterator<Reservas> ResIterator = ResLista.iterator();
		short achou = 0;
		short bloc = 0;
		while(ResIterator.hasNext()){
			Reservas r = (Reservas)ResIterator.next();
			if(material == r.getMaterial()){
				achou = (short) (achou + 1);
				if (usuario == r.getUsuario()){
					System.out.println(material.getTitulo()+" não pode ser reservado, pois o "+usuario.getNome()+" já possui reserva para este produto!");
					bloc = 4;
					break;
				}
			}
			if (usuario == r.getUsuario()){
				bloc = (short) (bloc + 1);
			}
		}
		if(bloc < 3){
			criarReserva(usuario, material);
		}else{
			System.out.println(material.getTitulo()+" não pôde ser reservado, pois o usuáriio: "+usuario.getNome()+" já chegou a cota máxima de reservas!");
		}
	}
	/**
	 * @param args
	 */
	private void criarReserva(Usuarios user, Materiais mat){
		Reservas res = new Reservas(user, mat);
		ResLista.add(res);
		System.out.println("O emprestimo foi efetuado!");
		System.out.println("De "+mat.getTitulo()+", para o usuário: "+user.getNome());
	}
	/**
	 * @param args
	 */
	public void devolucao(short user, short mat){
		usuario = bancodedados.getUsuarios(user);
		material = bancodedados.getMateriais(mat);
		Iterator<Emprestimo> EmpIterator = ListaEmp.iterator();
		while(EmpIterator.hasNext()){
			Emprestimo e = (Emprestimo)EmpIterator.next();
			if (e.getUsuario() == usuario){
				if(material == e.getMaterial()){
					ListaEmp.remove(e);
					System.out.println(material.getTitulo()+" foi devolvido com sucesso!");
					System.out.println("Obrigado "+usuario.getNome()+", volte sempre!");
				}
			}
			
		}
	}
	/**
	 * @param args
	 */
	public Usuarios procuraUsuario(short cod){
		// TODO Auto-generated method stub
		return bancodedados.getUsuarios(cod);
	}
	/**
	 * @param args
	 */
	public Materiais procuraMaterial(short mat) {
		// TODO Auto-generated method stub
		return bancodedados.getMateriais(mat);
	}
}

