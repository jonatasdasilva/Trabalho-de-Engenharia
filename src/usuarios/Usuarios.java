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
	int codigo;
	String nome;
	String tipo;
	boolean devedor;
	int tempo;
	int qt; //quantidade de exemplares maxima que pode emprestar. em um metodo ele percorre a lsita de emprestimos e verifica essa variavel q decrementa ela até chegar no ficnal do loop se ela for 0 não pode mais ter emprestimo para aquele usuario.
	protected static List<Reservas>ResLista = new ArrayList<Reservas>();
	protected static List<Emprestimo>ListaEmp = new ArrayList<Emprestimo>();
	public int getCodigo() {
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
	public int getQt() {
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

	/* (non-Javadoc)
	 * @see usuarios.Strategy#emprestimo(usuarios.Usuarios, materiais.Materiais)
	 */
	@Override
	public void emprestimo(Usuarios user, Materiais mat) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see usuarios.Strategy#reserva(usuarios.Usuarios, materiais.Materiais)
	 */
	@Override
	public void reserva(Usuarios user, Materiais mat) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see usuarios.Strategy#consultasUsu(usuarios.Usuarios)
	 */
	@Override
	public void consultasUsu(Usuarios user) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see usuarios.Strategy#consultasMat(materiais.Materiais)
	 */
	@Override
	public void consultasMat(Materiais mat) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see usuarios.Strategy#devolucao(usuarios.Usuarios, materiais.Materiais)
	 */
	@Override
	public void devolucao(Usuarios user, Materiais mat) {
		// TODO Auto-generated method stub
		
	}

}