/**
 * 
 */
package usuarios;

import materiais.Materiais;
import comandos.Modelo;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public interface Strategy {
	public void emprestimo(Usuarios user, Materiais mat);
	public void reserva(Usuarios user, Materiais mat);
	public void consultasUsu(Usuarios user);
	public void consultasMat(Materiais mat);
	public void devolucao(Usuarios user, Materiais mat);
}
