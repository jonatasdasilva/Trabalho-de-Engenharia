/**
 * 
 */
package bd;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import faixada.Singleton;
import materiais.Cd;
import materiais.Dvd;
import materiais.Livros;
import materiais.Materiais;
import materiais.Revistas;
import usuarios.AlunoGraduacao;
import usuarios.AlunoPosGraduacao;
import usuarios.Usuarios;

/**
 * @author Jonatas da Silva e Romilson Santana
 *
 */
public class Dados {
	Set<Usuarios> ListaUsers = new HashSet<Usuarios>();
	Set<Materiais> ListaMat = new HashSet<Materiais>();
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
			synchronized (Singleton.class) {
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
				Usuarios c = new AlunoGraduacao((short)123, "Aluno de Gradua��o", "Jo�o da Silva");
				ListaUsers.add(c);
			}else if(i==1){
				Usuarios c = new AlunoPosGraduacao((short)456, "Aluno de P�s-gradua��o", "Luiz Fernando Rodrigues");
				ListaUsers.add(c);
			}else if(i==2){
				Usuarios c = new AlunoGraduacao((short)789, "Aluno de Gradua��o", "Pedro Paulo");
				ListaUsers.add(c);
			}else{
				Usuarios c = new AlunoGraduacao((short)100, "Professor", "Carlos Lucena");
				ListaUsers.add(c);
			}
			
		}
	}
	
	public void criarMateriais(){
		for(int i=0; i<8; i++){
			if (i==0){
				Materiais m= new Livros((short)100, "Engenharia de Software", "Addison Wesley", "Ian Sommervile" ,"6�", (short)2000, (short)2);
				m.setEx((short) 2);
				ListaMat.add(m);
			}else if(i==1){
				Materiais m= new Livros((short)101, "UML-Guia do Usu�rio", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson","7�", (short)2000, (short)3);
				m.setEx((short) 3);
				ListaMat.add(m);
			}else if(i==2){
				Materiais m= new Revistas((short)200, "IEEE Transactions on Software Engineering", (short)53,"Setembro", (short)2006);
				m.setEx((short) 4);
				ListaMat.add(m);
			}else if(i==3){
				Materiais m= new Revistas((short)201, "IEEE Transactions on Software Engineering", (short)54,"Outubro", (short)2006);
				m.setEx((short) 5);
				ListaMat.add(m);
			}else if(i==4){
				Materiais m= new Cd((short)300, "Back To Black", "Amy Winehouse","Rehab, You Know I'm No Good, Me & Mr Jones", (short)2006);
				m.setEx((short) 6);
				ListaMat.add(m);
			}else if(i==5){
				Materiais m= new Cd((short)301, "I� I� I�", "Arnaldo Antunes","Longe, Invejoso, Envelhecer", (short)2009);
				m.setEx((short) 7);
				ListaMat.add(m);
			}else if(i==6){
				Materiais m= new Dvd((short)400, "Indiana Jones and the Kingdom of the Crystal Skull", "Harrison Ford, Cate Blanchett", (short)2008, (short)4);
				m.setEx((short) 8);
				ListaMat.add(m);
			}else if(i==7){
				Materiais m= new Dvd((short)401, "Incredible Hulk", "William Hurt, Tim Blake Nelson",(short) 2008, (short)4);
				m.setEx((short) 9);
				ListaMat.add(m);
			}
		}
	}
	
	public Usuarios getUsuarios(short cod){
		
		Iterator<Usuarios> UsersIterator = ListaUsers.iterator();
		while(UsersIterator.hasNext()){
			Usuarios u = (Usuarios) UsersIterator.next();
			if (cod == u.getCodigo())
				u = (Usuarios) UsersIterator;
				return u;
		}
		return null;
	}

	public Materiais getMateriais(short cod){
		
		Iterator<Materiais> UsersIterator = ListaMat.iterator();
		while(UsersIterator.hasNext()){
			Materiais m = (Materiais) UsersIterator.next();
			if (cod == m.getCodigo())
				m = (Materiais) UsersIterator;
				return m;
		}
		return null;
	}
}