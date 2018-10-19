package nous2.mediatheque.dto;

public class UserDTO {

    private Long id;

    private String pseudo;

    private String email;

    private String lastname;

    private String firstname;

    public UserDTO() {
	//
    }

    public UserDTO(Long id, String pseudo, String email, String lastname,
	    String firstname) {
	setId(id);
	setPseudo(pseudo);
	setEmail(email);
	setLastname(lastname);
	setFirstname(firstname);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getPseudo() {
	return pseudo;
    }

    public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }
}
