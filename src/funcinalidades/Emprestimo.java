/**
 * 
 */
package funcinalidades;

import java.util.Date;

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
	Date tempo;
	boolean devolvido;
	/**
	 * 
	 */
	public Emprestimo(Usuarios user, Materiais mat){
		this.usuario = user;
		this.material = mat;
		this.devolvido = false;
		this.tempo = new Date();
	}
	/**
	 * @return the tempo
	 */
	public Date getTempo() {
		return tempo;
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
