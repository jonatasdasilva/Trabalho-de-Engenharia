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
	short tempo;
	/**
	 * 
	 */
	public Emprestimo(Usuarios user, Materiais mat){
		this.usuario = user;
		this.material = mat;
		if (usuario.getTipo() == "Aluno Graduação"){
			this.tempo = 1;
		}else if (usuario.getTipo() == "Aluno Pós-Graduação"){
			this.tempo = 2;
		}else if (usuario.getTipo() == "Professor"){
			this.tempo = 4;
		}
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
