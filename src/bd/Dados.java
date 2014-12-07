/**
 * 
 */
package bd;

import java.util.*;

import materiais.*;
import usuarios.*;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Dados {
	private static List<Usuarios> ListadeUsuarios = new ArrayList<Usuarios>();
	private static List<Materiais> ListadeMateriais = new ArrayList<Materiais>();
	private static Dados instance = null;
	/**
	 * 
	 */
	private Dados() {
		// TODO Auto-generated constructor stub
		criarUsuarios();
		criarMateriais();
	}
	
	public static Dados getInstance() {
		// TODO Auto-generated method stub
		if (instance == null){
			synchronized (Dados.class) {
				if (instance == null){
					instance = new Dados();
				}
			}
		}
		return instance;
	}
	
	/**
	 * @param args
	 */
	
	public void criarUsuarios(){
		for(short i=0; i<4; i++){
			if(i==0){
				Usuarios c = new AlunoGraduacao(123, "Aluno de Graduação", "João da Silva");
				ListadeUsuarios.add(c);
				System.out.println("Usuário 1");
			}else if(i==1){
				Usuarios c = new AlunoPosGraduacao(456, "Aluno de Pós-graduação", "Luiz Fernando Rodrigues");
				ListadeUsuarios.add(c);
				System.out.println("Usuário 2");
			}else if(i==2){
				Usuarios c = new AlunoGraduacao(789, "Aluno de Graduação", "Pedro Paulo");
				ListadeUsuarios.add(c);
				System.out.println("Usuário 3");
			}else if (i==3){
				Usuarios c = new Professor(100, "Professor", "Carlos Lucena");
				ListadeUsuarios.add(c);
				System.out.println("Usuário 4");
			}
			
		}
	}
	
	public void criarMateriais(){
		for(int i=0; i<8; i++){
			if (i==0){
				Materiais m= new Livros(100, "Engenharia de Software", "Addison Wesley", "Ian Sommervile" ,"6ª", 2000, 2);
				m.setEx(2);
				ListadeMateriais.add(m);
				System.out.println("Material 1");
			}else if(i==1){
				Materiais m= new Livros(101, "UML-Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson","7ª", 2000, 3);
				m.setEx(3);
				ListadeMateriais.add(m);
				System.out.println("Material 2");
			}else if(i==2){
				Materiais m= new Revistas(200, "IEEE Transactions on Software Engineering", 53,"Setembro", 2006);
				m.setEx(4);
				ListadeMateriais.add(m);
				System.out.println("Material 3");
			}else if(i==3){
				Materiais m= new Revistas(201, "IEEE Transactions on Software Engineering", 54,"Outubro", 2006);
				m.setEx(5);
				ListadeMateriais.add(m);
				System.out.println("Material 4");
			}else if(i==4){
				Materiais m= new Cd(300, "Back To Black", "Amy Winehouse","Rehab, You Know I'm No Good, Me & Mr Jones", 2006);
				m.setEx(6);
				ListadeMateriais.add(m);
				System.out.println("Material 5");
			}else if(i==5){
				Materiais m= new Cd(301, "Iê Iê Iê", "Arnaldo Antunes","Longe, Invejoso, Envelhecer", 2009);
				m.setEx(7);
				ListadeMateriais.add(m);
				System.out.println("Material 6");
			}else if(i==6){
				Materiais m= new Dvd(400, "Indiana Jones and the Kingdom of the Crystal Skull", "Harrison Ford, Cate Blanchett", 2008, 4);
				m.setEx(8);
				ListadeMateriais.add(m);
				System.out.println("Material 7");
			}else if(i==7){
				Materiais m= new Dvd(401, "Incredible Hulk", "William Hurt, Tim Blake Nelson", 2008, 4);
				m.setEx(9);
				ListadeMateriais.add(m);
				System.out.println("Material 8");
			}
		}
	}
	
	public Usuarios getUsuarios(int cod){
		
		Iterator<Usuarios> UsersIterator = ListadeUsuarios.iterator();
		while(UsersIterator.hasNext()){
			Usuarios u = (Usuarios) UsersIterator.next();
			if (cod == u.getCodigo())
				return u;
		}
		return null;
	}

	public Materiais getMateriais(int cod){
		
		Iterator<Materiais> UsersIterator = ListadeMateriais.iterator();
		while(UsersIterator.hasNext()){
			Materiais m = (Materiais) UsersIterator.next();
			if (cod == m.getCodigo())
				return m;
		}
		return null;
	}
}