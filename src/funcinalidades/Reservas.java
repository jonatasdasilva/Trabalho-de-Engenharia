/**
 * 
 */
package funcinalidades;

import materiais.Materiais;
import usuarios.Usuarios;

/**
 * @author Jonatas da Silva e Romilso Santana
 *
 */
public class Reservas {
	Usuarios usuario;
	Materiais material;
	boolean emprestimo;

	public Reservas(Usuarios user, Materiais mat) {
		super();
		// TODO Auto-generated constructor stub
		this.usuario = user;
		this.material = mat;
		this.emprestimo = false;
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
	/**
	 * @return the emprestimo
	 */
	public boolean isEmprestimo() {
		return emprestimo;
	}
	/**
	 * @param emprestimo the emprestimo to set
	 */
	public void setEmprestimo(boolean emprestimo) {
		this.emprestimo = emprestimo;
	}
	
}
