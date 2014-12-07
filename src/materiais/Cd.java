package materiais;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */

public class Cd extends Materiais{
	String autores;
	String faixas;

	public Cd(int cod, String titulo, String autores, String faixas, int ano) {
		//super();
		// TODO Auto-generated constructor stub
		this.codigo = cod;
		this.titulo = titulo;
		this.autores = autores;
		this.faixas = faixas;
		this.ano = ano;
		this.tipo = "CD";
	}
	
	public String getAutores() {
		return autores;
	}

	public String getFaixas() {
		return faixas;
	}

}
