/**
 * 
 */
package usuarios;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class AlunoPosGraduacao extends Usuarios{
	private short qt;
	
	public AlunoPosGraduacao(short user, String tipo, String nome) {
		super();
		// TODO Auto-generated constructor stub
		this.codigo = user;
		this.tipo = tipo;
		this.nome = nome;
		this.qt = 4;
	}
	/**
	 * @return the qt
	 */
	public short getQt() {
		return qt;
	}
	
	/**
	 * @return the codigo
	 */
	public short getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}
}