/**
 * 
 */
package usuarios;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Professor extends Usuarios{

	public Professor(short user, String tipo, String nome) {
		// TODO Auto-generated constructor stub
		this.codigo = user;
		this.tipo = tipo;
		this.nome = nome;
		this.qt = 1000;
	}
	
	@Override
	public short getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

}