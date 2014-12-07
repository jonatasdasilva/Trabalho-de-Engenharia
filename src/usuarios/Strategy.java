/**
 * 
 */
package usuarios;

import comandos.Modelo;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public interface Strategy {
	public void emprestimo(Modelo model);
	public void reserva(Modelo model);
	public void consultasUsu(Modelo model);
	public void consultasMat(Modelo model);
	public void devolucao(Modelo model);
}
