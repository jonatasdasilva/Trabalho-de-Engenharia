/**
 * 
 */
package funcinalidades;

import faixada.Singleton;
import materiais.Materiais;
import usuarios.Usuarios;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Consultas {
	Usuarios usuario;
	Materiais material;
	Singleton s = Singleton.getInstance();
	
	public void listaConsultaDeUsuario(short user){
		usuario = s.procuraUsuario(user);
		//falta implementar a listagem dos materiais reservados ou emprestados ao usuario.
	}
	
	public void listaConsultaDeMaterial(short mat){
		material = s.procuraMaterial(mat);
		//falta implementar a listagem dos materiais reservados ou emprestados e qual a disponibilidade.
	}
}
