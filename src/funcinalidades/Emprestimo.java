/**
 * 
 */
package funcinalidades;

import faixada.Singleton;
import materiais.Materiais;
import usuarios.Usuarios;

/**
 * @author Jônatas da Silva e Romilson Santana
 *
 */
public class Emprestimo {
	Singleton sing = Singleton.getInstance();
	Usuarios usuario;
	Materiais material;
	short limite;
	//short time;
	short ex;
	String aux;
	//short mat;
	/**
	 * 
	 */
	public Emprestimo(short user, short mat){
		criarEmprestimo(user, mat);
	}
	/**
	 * @param args
	 */
	private void criarEmprestimo(short user, short mat) {
		// TODO Auto-generated method stub
		usuario = sing.procuraUsuario(user);
		material = sing.procuraMaterial(mat);
		if (usuario.getTipo() == "Aluno de Graduação"){
			
		}
		
	}
}
