package materiais;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */

public class Livros extends Materiais{
	String editora;
	String autores;
	String edicao;
	
	public Livros(short cod, String nome, String editora, String autores, String edicao, short ano, short ex) {
		super();
		// TODO Auto-generated constructor stub
		this.codigo = cod;
		this.titulo = nome;
		this.autores = autores;
		this.edicao = edicao;
		this.ano = ano;
		this.ex = ex;
	}

	/**
	 * @return the editora
	 */
	public String getEditora() {
		return editora;
	}

	/**
	 * @return the autores
	 */
	public String getAutores() {
		return autores;
	}
	/**
	 * @return the edicao
	 */
	public String getEdicao() {
		return edicao;
	}
}
