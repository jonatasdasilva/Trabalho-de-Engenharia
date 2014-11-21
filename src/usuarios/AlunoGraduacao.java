package usuarios;
/**
 * 
 */

/**
 * @author Jônatas da Silva e Romilson Santana
 *
 */
public class AlunoGraduacao extends Usuarios{

	public AlunoGraduacao(short user, String tipo, String nome) {
		super();
		// TODO Auto-generated constructor stub
		this.codigo = user;
		this.tipo = tipo;
		this.nome = nome;
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