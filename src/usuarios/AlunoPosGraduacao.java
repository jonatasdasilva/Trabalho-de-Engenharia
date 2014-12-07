/**
 * 
 */
package usuarios;

import java.util.Date;
import java.util.Iterator;

import comandos.Modelo;
import materiais.Materiais;
import faixada.Singleton;
import funcinalidades.Emprestimo;
import funcinalidades.Reservas;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class AlunoPosGraduacao extends Usuarios implements Strategy{
	Singleton faixada = Singleton.getInstance();
	
	public AlunoPosGraduacao(int user, String tipo, String nome) {
		//super();
		// TODO Auto-generated constructor stub
		this.codigo = user;
		this.tipo = tipo;
		this.nome = nome;
		this.qt = 4;
		this.devedor = false;
		this.tempo = 2;
	}
	/**
	 * @return the qt
	 */
	public int getQt() {
		return qt;
	}
	
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	/**
	 * @return the tempo
	 */
	public int getTempo() {
		return tempo;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}
	/* (non-Javadoc)
	 * @see usuarios.Strategy#emprestimo(usuarios.Usuarios, materiais.Materiais)
	 */
	@Override
	public void emprestimo(Usuarios user, Materiais mat) {
		// TODO Auto-generated method stub
		System.out.println("Estar no emprestimo");
		Iterator<Reservas> ResIterator = ResLista.iterator();
		int achou = 0;
		boolean resOK = true;
		boolean resU = false;
		while(ResIterator.hasNext()){
			Reservas r = (Reservas)ResIterator.next();
			if(mat == r.getMaterial()){
				if (user == r.getUsuario()){
					if (r.isEmprestimo() == false){
						r.setEmprestimo(true);
						resU = true;
						//criarEmprestimo(r.getUsuario(), r.getMaterial());
					}
				}else{
					achou = (achou + 1);
				}
			}
		}
		if (achou < mat.getEx()){
			resOK = false;
		}
		Iterator<Emprestimo> EmpIterator = ListaEmp.iterator();
		int ex = 0;
		int limite = 0;
		boolean emprestado = false;
		while(EmpIterator.hasNext()){
			Emprestimo e = (Emprestimo)EmpIterator.next();
			if (e.getUsuario() == user){
				limite = (limite + (e.getUsuario().getQt()));
				Date tempo = e.getDiadoemprestimo();
				Date data = new Date();
				int atual = data.getDay();
				if(data.getDate()>=(tempo.getDate() + e.getUsuario().getTempo())){
					devedor = true;
				}
			}
			if(mat == e.getMaterial()){
				ex = (ex + 1);	
			}
			if ((mat == e.getMaterial()) && (e.getUsuario() == user)){
				emprestado = true;
			}
		}
		if (resU){
			if (!(devedor)){
				if (!(emprestado)){
					if(ex < mat.getEx()){
						if ((limite/user.getQt()) < user.getQt()){
							criarEmprestimo(user, mat);
						}else{
							System.out.println("O usuário: "+user.getNome()+" exedeu o limite de Emprestimos!\n"+"Então não foi possivél efetuar o emprestimo de: "+ mat.getTitulo());
						}
					}else{
						System.out.println("O usuário: "+user.getNome()+" não pôde fazer o emprestimo de: "+ mat.getTitulo()+", pois não existe exemplares disponíveis!");
					}
				}else{
					System.out.println("O usuário: "+user.getNome()+" não pode fazer novo emprestimo para: "+ mat.getTitulo()+", pois não existe registro de devolução!");
				}
			}else{
				System.out.println("O usuário: "+user.getNome()+" não pôde fazer o emprestimo de: "+ mat.getTitulo()+", pois estar com atraso na devolução!");
			}
		}else{
			if((achou + ex)< mat.getEx()){
				if(!(devedor)){
					if(!(emprestado)){
						criarEmprestimo(user, mat);
					}else{
						System.out.println("O usuário: "+user.getNome()+" não pode fazer novo emprestimo para: "+ mat.getTitulo()+", pois não existe registro de devolução!");
					}
				}else{
					System.out.println("O usuário: "+user.getNome()+" não pôde fazer o emprestimo de: "+ mat.getTitulo()+", pois estar com atraso na devolução!");
				}
			}else{
				System.out.println("O usuário: "+user.getNome()+" não pôde fazer o emprestimo de: "+mat.getTitulo()+", pois não existe exemplar disponível!");
			}
		}
	}
	/* (non-Javadoc)
	 * @see usuarios.Strategy#reserva(usuarios.Usuarios, materiais.Materiais)
	 */
	@Override
	public void reserva(Usuarios user, Materiais mat) {
		// TODO Auto-generated method stub
		Iterator<Reservas> ResIterator = ResLista.iterator();
		short bloc = 0;
		while(ResIterator.hasNext()){
			Reservas r = (Reservas)ResIterator.next();
			if(mat == r.getMaterial()){
				if (user == r.getUsuario()){
					System.out.println(mat.getTitulo()+" não pode ser reservado, pois o usuário: \""+user.getNome()+"\" já possui esta reserva!");
					break;
				}
			}
			if (user == r.getUsuario()){
				bloc = (short) (bloc + 1);
			}
		}
		if(bloc < 3){
			criarReserva(user, mat);
		}else{
			System.out.println(mat.getTitulo()+" não pôde ser reservado, pois o usuáriio: "+user.getNome()+" já chegou a cota máxima de reservas!");
		}
	}
	/* (non-Javadoc)
	 * @see usuarios.Strategy#consultasUsu(usuarios.Usuarios)
	 */
	@Override
	public void consultasUsu(Usuarios user) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see usuarios.Strategy#consultasMat(materiais.Materiais)
	 */
	@Override
	public void consultasMat(Materiais mat) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see usuarios.Strategy#devolucao(usuarios.Usuarios, materiais.Materiais)
	 */
	@Override
	public void devolucao(Usuarios user, Materiais mat) {
		// TODO Auto-generated method stub
		Iterator<Emprestimo> EmpIterator = ListaEmp.iterator();
		while(EmpIterator.hasNext()){
			Emprestimo e = (Emprestimo)EmpIterator.next();
			if (e.getUsuario() == user){
				if(mat == e.getMaterial()){
					e.setDevolvido(true);
					e.setDiadadevolucao(new Date());
					System.out.println(mat.getTitulo()+" foi devolvido com sucesso!\n"+"Obrigado "+user.getNome()+", volte sempre!");
				}
			}
			
		}
		System.out.println("O emprestimo não foi encontrado, verifique os dados e tente novamente!");
	}
	/**
	 * @param args
	 */	
	public void criarEmprestimo(Usuarios user, Materiais mat){
		Emprestimo Emp = new Emprestimo(user, mat);
		ListaEmp.add(Emp);
		System.out.println("O emprestimo foi efetuado!\n"+"De "+mat.getTitulo()+", para o usuário: "+user.getNome()+", Obrigado e volte sempre!");
	}
	/**
	 * @param user: Usuarios, mat Materiais
	 */
	private void criarReserva(Usuarios user, Materiais mat){
		Reservas res = new Reservas(user, mat);
		ResLista.add(res);
		System.out.println("A reserva foi efetuado!\n"+"De "+mat.getTitulo()+", para o usuário: "+user.getNome());
	}
}