package materiais;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */

public class Livros extends Materiais{
	String editora;
	String autores;
	String edicao;
	
	public Livros(int cod, String nome, String editora, String autores, String edicao, int ano, int ex) {
		//super();
		// TODO Auto-generated constructor stub
		this.codigo = cod;
		this.titulo = nome;
		this.autores = autores;
		this.edicao = edicao;
		this.ano = ano;
		this.ex = ex;
		this.tipo = "LIVRO";
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
