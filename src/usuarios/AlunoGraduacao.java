package usuarios;

import java.util.Date;
/**
 * 
 */
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
public class AlunoGraduacao extends Usuarios{
	private short qt;
	
	public AlunoGraduacao(short user, String tipo, String nome) {
		// TODO Auto-generated constructor stub
		this.codigo = user;
		this.tipo = tipo;
		this.nome = nome;
		this.qt = 3;
		this.devedor = false;
		this.tempo = 1;
	}

	/**
	 * @return the qt
	 */
	public short getQt() {
		return qt;
	}

	/**
	 * @return the codigo
	 */
	public short getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}
	/**
	 * @return the tempo
	 */
	public int getTempo() {
		return tempo;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}
	
	@Override
	public void emprestimo(Modelo model) {
		// TODO Auto-generated method stub
		Singleton faixada = Singleton.getInstance();
		Iterator<Reservas> ResIterator = ResLista.iterator();
		short achou = 0;
		boolean resOK = true;
		boolean resU = false;
		while(ResIterator.hasNext()){
			Reservas r = (Reservas)ResIterator.next();
			if(model.getCodigoMat() == r.getMaterial().getCodigo()){
				if (model.getCodigoUser() == r.getUsuario().getCodigo()){
					if (r.isEmprestimo() == false){
						r.setEmprestimo(true);
						resU = true;
						//criarEmprestimo(r.getUsuario(), r.getMaterial());
					}
				}else{
					achou = (short) (achou + 1);
				}
			}
		}
		if (achou < faixada.procuraMaterial(model.getCodigoMat()).getEx()){
			resOK = false;
		}
		Iterator<Emprestimo> EmpIterator = ListaEmp.iterator();
		short ex = 0;
		short limite = 0;
		boolean emprestado = false;
		while(EmpIterator.hasNext()){
			Emprestimo e = (Emprestimo)EmpIterator.next();
			if (e.getUsuario().getCodigo() == model.getCodigoUser()){
				limite = (short) (limite + (e.getUsuario().getQt()));
				Date tempo = e.getDiadoemprestimo();
				Date data = new Date();
				if(data.getDate()>=(tempo.getDate() + e.getUsuario().getTempo())){
					devedor = true;
				}
			}
			if(model.getCodigoMat() == e.getMaterial().getCodigo()){
				ex = (short) (ex + 1);	
			}
			if ((model.getCodigoMat() == e.getMaterial().getCodigo()) && (e.getUsuario().getCodigo() == model.getCodigoUser())){
				emprestado = true;
			}
		}
		if (resU){
			if (!(devedor)){
				if (!(emprestado)){
					if(ex < faixada.procuraMaterial(model.getCodigoMat()).getEx()){
						if ((limite/faixada.procuraUsuario(model.getCodigoUser()).getQt()) < faixada.procuraUsuario(model.getCodigoUser()).getQt()){
							criarEmprestimo(faixada.procuraUsuario(model.getCodigoUser()), faixada.procuraMaterial(model.getCodigoMat()));
						}else{
							System.out.println("O usuário: "+faixada.procuraUsuario(model.getCodigoUser()).getNome()+" exedeu o limite de Emprestimos!\n"+"Então não foi possivél efetuar o emprestimo de: "+ faixada.procuraMaterial(model.getCodigoMat()).getTitulo());
						}
					}else{
						System.out.println("O usuário: "+faixada.procuraUsuario(model.getCodigoUser()).getNome()+" não pôde fazer o emprestimo de: "+ faixada.procuraMaterial(model.getCodigoMat()).getTitulo()+", pois não existe exemplares disponíveis!");
					}
				}else{
					System.out.println("O usuário: "+faixada.procuraUsuario(model.getCodigoUser()).getNome()+" não pode fazer novo emprestimo para: "+ faixada.procuraMaterial(model.getCodigoMat()).getTitulo()+", pois não existe registro de devolução!");
				}
			}else{
				System.out.println("O usuário: "+faixada.procuraUsuario(model.getCodigoUser()).getNome()+" não pôde fazer o emprestimo de: "+ faixada.procuraMaterial(model.getCodigoMat()).getTitulo()+", pois estar com atraso na devolução!");
			}
		}else{
			if((achou + ex)< faixada.procuraMaterial(model.getCodigoMat()).getEx()){
				if(!(devedor)){
					if(!(emprestado)){
						criarEmprestimo(faixada.procuraUsuario(model.getCodigoUser()), faixada.procuraMaterial(model.getCodigoMat()));
					}else{
						System.out.println("O usuário: "+faixada.procuraUsuario(model.getCodigoUser()).getNome()+" não pode fazer novo emprestimo para: "+ faixada.procuraMaterial(model.getCodigoMat()).getTitulo()+", pois não existe registro de devolução!");
					}
				}else{
					System.out.println("O usuário: "+faixada.procuraUsuario(model.getCodigoUser()).getNome()+" não pôde fazer o emprestimo de: "+ faixada.procuraMaterial(model.getCodigoMat()).getTitulo()+", pois estar com atraso na devolução!");
				}
			}else{
				System.out.println("O usuário: "+faixada.procuraUsuario(model.getCodigoUser()).getNome()+" não pôde fazer o emprestimo de: "+ faixada.procuraMaterial(model.getCodigoMat()).getTitulo()+", pois não existe exemplar disponível!");
			}
		}
	}
	@Override
	public void reserva(Modelo model) {
		// TODO Auto-generated method stub
		Singleton faixada = Singleton.getInstance();
		Iterator<Reservas> ResIterator = ResLista.iterator();
		short bloc = 0;
		while(ResIterator.hasNext()){
			Reservas r = (Reservas)ResIterator.next();
			if(model.getCodigoMat() == r.getMaterial().getCodigo()){
				if (model.getCodigoUser() == r.getUsuario().getCodigo()){
					System.out.println(faixada.procuraMaterial(model.getCodigoMat()).getTitulo()+" não pode ser reservado, pois o usuário: \""+faixada.procuraUsuario(model.getCodigoUser()).getNome()+"\" já possui esta reserva!");
				}
			}
			if (model.getCodigoUser() == r.getUsuario().getCodigo()){
				bloc = (short) (bloc + 1);
			}
		}
		if(bloc < 3){
			criarReserva(faixada.procuraUsuario(model.getCodigoUser()), faixada.procuraMaterial(model.getCodigoMat()));
		}else{
			System.out.println(faixada.procuraMaterial(model.getCodigoMat()).getTitulo()+" não pôde ser reservado, pois o usuáriio: "+faixada.procuraUsuario(model.getCodigoUser()).getNome()+" já chegou a cota máxima de reservas!");
		}
	}
	@Override
	public void consultasUsu(Modelo model) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void consultasMat(Modelo model) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void devolucao(Modelo model) {
		// TODO Auto-generated method stub
		Iterator<Emprestimo> EmpIterator = ListaEmp.iterator();
		while(EmpIterator.hasNext()){
			Emprestimo e = (Emprestimo)EmpIterator.next();
			if (e.getUsuario() == faixada.procuraUsuario(model.getCodigoUser())){
				if(faixada.procuraMaterial(model.getCodigoMat()) == e.getMaterial()){
					e.setDevolvido(true);
					System.out.println(faixada.procuraMaterial(model.getCodigoMat()).getTitulo()+" foi devolvido com sucesso!\n"+"Obrigado "+faixada.procuraUsuario(model.getCodigoUser()).getNome()+", volte sempre!");
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