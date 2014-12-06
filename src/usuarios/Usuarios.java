package usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import materiais.Materiais;
import faixada.Singleton;
import funcinalidades.Emprestimo;
import funcinalidades.Reservas;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */

public class Usuarios {
	short codigo;
	String nome;
	String tipo;
	boolean devedor;
	int tempo;
	Singleton faixada = Singleton.getInstance();
	short qt; //quantidade de exemplares maxima que pode emprestar. em um metodo ele percorre a lsita de emprestimos e verifica essa variavel q decrementa ela até chegar no ficnal do loop se ela for 0 não pode mais ter emprestimo para aquele usuario.
	protected static List<Reservas>ResLista = new ArrayList<Reservas>();
	protected static List<Emprestimo>ListaEmp = new ArrayList<Emprestimo>();
	public short getCodigo() {
		return codigo;
	}
	public String getNome(){
		return nome;
	}
	public String getTipo(){
		return tipo;
	}
	/**
	 * @return the qt
	 */
	public short getQt() {
		return qt;
	}
	/**
	 * @param args
	 */
	public String cadastrarEmprestimo(short user, short mat){
		return null;
	}
	/**
	 * @param args
	 */	
	public String criarEmprestimo(Usuarios user, Materiais mat){
		return null;
	}
	/**
	 * @param args
	 */
	public String cadastrarReserva(short user, short mat){
		return null;
	}
	/**
	 * @param args
	 */
	public String devolver(short user, short mat){
		return null;
	}
	
	/**
	 * @param args
	 * @return 
	 */
	private String criarReserva(Usuarios user, Materiais mat){
		return null;
	}
}