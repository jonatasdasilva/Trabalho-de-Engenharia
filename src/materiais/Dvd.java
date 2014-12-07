package materiais;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */

public class Dvd extends Materiais{
	String autores;
	int ano;
	int regiao;

	public Dvd(int cod, String titulo, String autores, int ano, int regiao) {
		//super();
		// TODO Auto-generated constructor stub
		this.codigo = cod;
		this.titulo = titulo;
		this.autores = autores;
		this.ano = ano;
		this.regiao = regiao;
		this.tipo = "DVD";
	}

	public String getAutores() {
		return autores;
	}

	public int getAno() {
		return ano;
	}

	public int getRegiao() {
		return regiao;
	}

}
