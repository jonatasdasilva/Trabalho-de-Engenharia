/**
 * 
 */
package bd;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import materiais.Livros;
import materiais.Materiais;
import usuarios.AlunoGraduacao;
import usuarios.AlunoPosGraduacao;
import usuarios.Usuarios;

/**
 * @author J�natas da Silva e Romilson Santana
 *
 */
public class Dados {
	Set<Usuarios> ListaUsers = new HashSet<Usuarios>();
	Set<Materiais> ListaMat = new HashSet<Materiais>();
	Usuarios c;
	Materiais m;
	Materiais o;
	/**
	 * 
	 */
	public Dados() {
		// TODO Auto-generated constructor stub
		criarUsuarios();
		criarMateriais();
	}

	/**
	 * @param args
	 */
	
	public void criarUsuarios(){
		for(short i=0; i<4; i++){
			if(i==0){
				c = new AlunoGraduacao((short)123, "Aluno de Gradua��o", "Jo�o da Silva");
				ListaUsers.add(c);
			}else if(i==1){
				c = new AlunoPosGraduacao((short)456, "Aluno de P�s-gradua��o", "Luiz Fernando Rodrigues");
				ListaUsers.add(c);
			}else if(i==2){
				c = new AlunoGraduacao((short)789, "Aluno de Gradua��o", "Pedro Paulo");
				ListaUsers.add(c);
			}else{
				c = new AlunoGraduacao((short)100, "Professor", "Carlos Lucena");
				ListaUsers.add(c);
			}
			
		}
		
	}
	
	public void criarMateriais(){
		for(int i=0; i<8; i++){
			if (i==0){
				m= new Livros((short)100, "Engenharia de Software", "Addison Wesley", "Ian Sommervile" ,"6�", (short)2000, (short)2);
				ListaMat.add(m);
			}else if(i==1){
				m= new Livros((short)101, "UML � Guia do Usu�rio", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson","7�", (short)2000, (short)3);
				ListaMat.add(m);
			}else if(i==2){
				//m= new Livros((short)101, "UML � Guia do Usu�rio", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson","7�", (short)2000, (short)3);
				//ListaMat.add(m);
			}
		}
	}
	
	public Usuarios getUsuarios(short cod){
		
		Iterator<Usuarios> UsersIterator = ListaUsers.iterator();
		while(UsersIterator.hasNext()){
			Usuarios p = (Usuarios) UsersIterator.next();
			if (cod == p.getCodigo())
				p = (Usuarios) UsersIterator;
				return p;
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