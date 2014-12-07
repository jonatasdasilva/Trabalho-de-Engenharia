package usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import comandos.Modelo;

import materiais.Materiais;
import faixada.Singleton;
import funcinalidades.Emprestimo;
import funcinalidades.Reservas;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */

public class Usuarios implements Strategy{
	short codigo;
	String nome;
	String tipo;
	boolean devedor;
	int tempo;
	Singleton faixada = Singleton.getInstance();
	short qt; //quantidade de exemplares maxima que pode emprestar. em um metodo ele percorre a lsita de emprestimos e verifica essa variavel q decrementa ela at� chegar no ficnal do loop se ela for 0 n�o pode mais ter emprestimo para aquele usuario.
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
	 * @return the tempo
	 */
	public int getTempo() {
		return tempo;
	}
	/**
	 * @param args
	 */	
	public void criarEmprestimo(Usuarios user, Materiais mat){
	}
	/**
	 * @param args
	 * @return 
	 */
	private void criarReserva(Usuarios user, Materiais mat){
	}
	@Override
	public void emprestimo(Modelo model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reserva(Modelo model) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void consultasUsu(Modelo model) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void consultasMat(Modelo model) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void devolucao(Modelo model) {
		// TODO Auto-generated method stub
		
	}
}