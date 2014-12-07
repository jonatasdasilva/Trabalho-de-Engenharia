/**
 * 
 */
package funcinalidades;

import java.util.*;

import materiais.Materiais;
import usuarios.Usuarios;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Emprestimo {
	//Singleton sing = Singleton.getInstance();
	Usuarios usuario;
	Materiais material;
	Date diadoemprestimo;
	Date diadadevolucao;
	boolean devolvido;
	/**
	 * 
	 */
	public Emprestimo(Usuarios user, Materiais mat){
		this.usuario = user;
		this.material = mat;
		this.devolvido = false;
		this.diadoemprestimo = new Date();
		this.diadadevolucao = null;
		this.devolvido = false;
	}
	/**
	 * @return the diadoemprestimo
	 */
	public Date getDiadoemprestimo() {
		return diadoemprestimo;
	}
	/**
	 * @return the diadadevolucao
	 */
	public Date getDiadadevolucao() {
		return diadadevolucao;
	}
	/**
	 * @param diadadevolucao the diadadevolucao to set
	 */
	public void setDiadadevolucao(Date diadadevolucao) {
		this.diadadevolucao = diadadevolucao;
	}
	/**
	 * @return the devolvido
	 */
	public boolean isDevolvido() {
		return devolvido;
	}
	/**
	 * @param devolvido the devolvido to set
	 */
	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}
	/**
	 * @return the usuario 
	 */
	public Usuarios getUsuario() {
		return usuario;
	}
	/**
	 * @return the material
	 */
	public Materiais getMaterial() {
		return material;
	}
}
