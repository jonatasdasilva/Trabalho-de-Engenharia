/**
 * 
 */
package usuarios;

import java.util.Date;
import java.util.Iterator;

import materiais.Materiais;
import funcinalidades.Emprestimo;
import funcinalidades.Reservas;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Professor extends Usuarios{

	public Professor(short user, String tipo, String nome) {
		// TODO Auto-generated constructor stub
		this.codigo = user;
		this.tipo = tipo;
		this.nome = nome;
		this.devedor = false;
		this.tempo = 4;
	}
	
	@Override
	public short getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}
	
	/**
	 * @param args
	 */
	public String cadastrarEmprestimo(short user, short mat){
		Iterator<Reservas> ResIterator = ResLista.iterator();
		short achou = 0;
		while(ResIterator.hasNext()){
			Reservas r = (Reservas)ResIterator.next();
			if(mat == r.getMaterial().getCodigo()){
				if (user == r.getUsuario().getCodigo()){
					if (r.isEmprestimo() == false){
						r.setEmprestimo(true);
						String resposta = criarEmprestimo(r.getUsuario(), r.getMaterial());
						return (resposta);
					}
				}else{
					achou = (short) (achou + 1);
				}
			}
		}
		if(achou < faixada.procuraMaterial(mat).getEx()){
			String resposta = criarEmprestimo(faixada.procuraUsuario(user), faixada.procuraMaterial(mat));
			return (resposta);
		}else{
			return ("Não Existe Exemplares disponíveis!");
		}
	}
	/**
	 * @param args
	 */	
	public String criarEmprestimo(Usuarios user, Materiais mat){
		Iterator<Emprestimo> EmpIterator = ListaEmp.iterator();
		short ex = 0;
		short limite = 0;
		while(EmpIterator.hasNext()){
			Emprestimo e = (Emprestimo)EmpIterator.next();
			if (e.getUsuario() == user){
				limite = (short) (limite + (e.getUsuario().getQt()));
				Date tempo = e.getTempo();
				Date data = new Date();
				if((tempo.getDate()) == data.getDate()){
					devedor = true;
				}
			}
			if(mat == e.getMaterial()){
				ex = (short) (ex + 1);		
			}
		}
		if (devedor != true){
			if (((limite/user.getQt()) < user.getQt()) && (ex < mat.getEx())){
				Emprestimo Emp = new Emprestimo(user, mat);
				ListaEmp.add(Emp);
				return ("O emprestimo foi efetuado!\n"+"De "+mat.getTitulo()+", para o usuário: "+user.getNome());
			}else if (ex >= mat.getEx()){
				return ("Exemplar indisponivel, ecedeu a quantidade de exemplares!\n"+"De: "+mat.getTitulo()+", para o usuário: "+user.getNome());
				//listaExemplares(mat);
			}else if (((limite/user.getQt()) >= user.getQt()) && (user.getTipo() != "Professor")){
				return ("O usuário exedeu o limite de Emprestimos!\n"+"O usuário: "+user.getNome()+" De: "+ mat.getTitulo());
				//listaMateriais(mat);
			}
		}
		return ("O "+user.getNome()+" estar entrega em atraso!");
	}
	/**
	 * @param args
	 */
	public String cadastrarReserva(short user, short mat){
		Iterator<Reservas> ResIterator = ResLista.iterator();
		short bloc = 0;
		while(ResIterator.hasNext()){
			Reservas r = (Reservas)ResIterator.next();
			if(mat == r.getMaterial().getCodigo()){
				if (user == r.getUsuario().getCodigo()){
					return (faixada.procuraMaterial(mat).getTitulo()+" não pode ser reservado, pois o usuário: \""+faixada.procuraUsuario(user).getNome()+"\" já possui esta reserva!");
				}
			}
			if (user == r.getUsuario().getCodigo()){
				bloc = (short) (bloc + 1);
			}
		}
		if(bloc < 3){
			String resposta = criarReserva(faixada.procuraUsuario(user), faixada.procuraMaterial(mat));
			return resposta;
		}
		return (faixada.procuraMaterial(mat).getTitulo()+" não pôde ser reservado, pois o usuáriio: "+faixada.procuraUsuario(user).getNome()+" já chegou a cota máxima de reservas!");
	}
	/**
	 * @param args
	 */
	public String devolver(short user, short mat){
		Iterator<Emprestimo> EmpIterator = ListaEmp.iterator();
		while(EmpIterator.hasNext()){
			Emprestimo e = (Emprestimo)EmpIterator.next();
			if (e.getUsuario() == faixada.procuraUsuario(user)){
				if(faixada.procuraMaterial(mat) == e.getMaterial()){
					e.setDevolvido(true);
					return (faixada.procuraMaterial(mat).getTitulo()+" foi devolvido com sucesso!\n"+"Obrigado "+faixada.procuraUsuario(user).getNome()+", volte sempre!");
				}
			}
			
		}
		return ("O emprestimo não foi encontrado, verifique os dados e tente novamente!");
	}
	
	/**
	 * @param args
	 * @return 
	 */
	private String criarReserva(Usuarios user, Materiais mat){
		Reservas res = new Reservas(user, mat);
		ResLista.add(res);
		return ("O emprestimo foi efetuado!\n"+"De "+mat.getTitulo()+", para o usuário: "+user.getNome());
	}
}