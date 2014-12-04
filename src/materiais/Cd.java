package materiais;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */

public class Cd extends Materiais{
	String autores;
	String faixas;

	public Cd(short cod, String titulo, String autores, String faixas, short ano) {
		super();
		// TODO Auto-generated constructor stub
		this.codigo = cod;
		this.titulo = titulo;
		this.autores = autores;
		this.faixas = faixas;
		this.ano = ano;
	}
	
	public String getAutores() {
		return autores;
	}

	public String getFaixas() {
		return faixas;
	}

}
