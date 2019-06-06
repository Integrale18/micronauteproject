package etudproject;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {

	private String nom;
	private String prenom;
	private int age;

	private String matricule;
	
	public Etudiant() {
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	List<Etudiant> getMyList(){
		
		List<Etudiant> myList = new ArrayList<>();
		
		
		Etudiant etudiant = new Etudiant();
		etudiant.setAge(23);
		etudiant.setMatricule("ET945");
		etudiant.setNom("BALMA");
		etudiant.setPrenom("JOSOUE");
		
		
		Etudiant etudiant0 = new Etudiant();
		etudiant0.setAge(24);
		etudiant0.setMatricule("ET946");
		etudiant0.setNom("DOFONTIEN");
		etudiant0.setPrenom("VIANNEY");
		
		Etudiant etudiant1 = new Etudiant();
		etudiant1.setAge(21);
		etudiant1.setMatricule("ET947");
		etudiant1.setNom("GUEY");
		etudiant1.setPrenom("AROUNA");
		
		Etudiant etudiant2 = new Etudiant();
		etudiant2.setAge(24);
		etudiant2.setMatricule("ET948");
		etudiant2.setNom("YOVO");
		etudiant2.setPrenom("KOMI");
		
		Etudiant etudiant3 = new Etudiant();
		etudiant3.setAge(18);
		etudiant3.setMatricule("ET949");
		etudiant3.setNom("BISSARI");
		etudiant3.setPrenom("SERGE");
		
		myList.add(etudiant);
		myList.add(etudiant0);
		myList.add(etudiant1);
		myList.add(etudiant2);
		myList.add(etudiant3);
		
		return myList;
		
	}
}
