package entity;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@Column(name = "id_column")
	private String id;
	
	@Column(name = "tip_user_column")
	private String tipUser ;
	@Column(name = "username_column")
	private String username;
	@Column(name = "password_column")
	private String password;
	@Column(name ="nume_column")
	private String nume;
	@Column(name = "prenume_column")
	private String prenume;

	//constructori pt baza de date
	public User(String id,String nume,String prenume){
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
	}
	public User(){};

	public User(String id, String username, String nume, String prenume){
		this.id = id;
		this.username = username;
		this.nume = nume;
		this.prenume = prenume;
	}
	// constructor folosit in cod
	public User(String id, String tipUser, String username, String password, String nume, String prenume){
		this.id = id;
		this.tipUser = tipUser;
		this.username = username;
		this.password = password;
		this.nume = nume;
		this.prenume = prenume;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getNume() {
		return nume;
	}

	public String getPrenume() {
		return prenume;
	}
}
