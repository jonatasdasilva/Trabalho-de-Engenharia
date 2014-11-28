package materiais;

/**
 * @author Jônatas da Silva e Romilson Santana
 *
 */

public class Dvd extends Materiais{
	String autores;
	short ano;
	short regiao;

	public Dvd(short cod, String titulo, String autores, short ano, short regiao) {
		super();
		// TODO Auto-generated constructor stub
		this.codigo = cod;
		this.titulo = titulo;
		this.autores = autores;
		this.ano = ano;
		this.regiao = regiao;
	}

	public String getAutores() {
		return autores;
	}

	public short getAno() {
		return ano;
	}

	public short getRegiao() {
		return regiao;
	}

}
