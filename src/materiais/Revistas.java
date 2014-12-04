package materiais;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */

public class Revistas extends Materiais{

	short edicao;
	String mes;

	public Revistas(short cod, String titulo, short edicao, String mes, short ano) {
		super();
		// TODO Auto-generated constructor stub
		this.edicao = edicao;
		this.codigo = cod;
		this.titulo = titulo;
		this.mes = mes;
		this.ano = ano;
	}
	
	public short getEdicao() {
		return edicao;
	}

	public String getMes() {
		return mes;
	}

	
}
