/**
 * 
 */
package funcinalidades;

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
	/**
	 * 
	 */
	public Emprestimo(Usuarios user, Materiais mat){
		this.usuario = user;
		this.material = mat;
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
