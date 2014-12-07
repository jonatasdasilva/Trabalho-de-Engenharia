package materiais;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */

public class Revistas extends Materiais{
	int edicao;
	String mes;

	public Revistas(int cod, String titulo, int edicao, String mes, int ano) {
		//super();
		// TODO Auto-generated constructor stub
		this.edicao = edicao;
		this.codigo = cod;
		this.titulo = titulo;
		this.mes = mes;
		this.ano = ano;
		this.tipo = "REVISTA";
	}
	
	public int getEdicao() {
		return edicao;
	}

	public String getMes() {
		return mes;
	}
}
