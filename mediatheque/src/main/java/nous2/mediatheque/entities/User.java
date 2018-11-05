package nous2.mediatheque.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1800900843909976847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{error.commons.required}")
    @Column(length = 255, nullable = false, unique = true)
    private String pseudo;

    @NotNull(message = "{error.commons.required}")
    @Column(length = 50, nullable = false)
    private String lastname;

    @NotNull(message = "{error.commons.required}")
    @Column(length = 50, nullable = false)
    private String firstname;

    @NotNull(message = "{error.commons.required}")
    @Email(message = "{error.commons.email}")
    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @NotNull(message = "{error.commons.required}")
    @Column(length = 100, nullable = false)
    private String password;

    @NotNull(message = "{error.commons.required}")
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Role role;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    public boolean accountNonExpired = true;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    public boolean accountNonLocked = true;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    public boolean credentialsNonExpired = true;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    public boolean enabled = true;

    public User() {
	//
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

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public boolean isAccountNonExpired() {
	return accountNonExpired;
    }

    public void setAccountNonExpired(boolean flag) {
	accountNonExpired = flag;
    }

    public boolean isAccountNonLocked() {
	return accountNonLocked;
    }

    public void setAccountNonLocked(boolean flag) {
	accountNonLocked = flag;
    }

    public boolean isCredentialsNonExpired() {
	return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean flag) {
	credentialsNonExpired = flag;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean flag) {
	enabled = flag;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (email == null ? 0 : email.hashCode());
	result = prime * result + (pseudo == null ? 0 : pseudo.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	User other = (User) obj;
	if (email == null) {
	    if (other.email != null) {
		return false;
	    }
	} else if (!email.equals(other.email)) {
	    return false;
	}
	if (pseudo == null) {
	    if (other.pseudo != null) {
		return false;
	    }
	} else if (!pseudo.equals(other.pseudo)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", pseudo=" + pseudo + ", lastname=" + lastname
		+ ", firstname=" + firstname + ", email=" + email
		+ ", password=[SECRET], role=" + role + ", accountNonExpired="
		+ accountNonExpired + ", accountNonLocked=" + accountNonLocked
		+ ", credentialsNonExpired=" + credentialsNonExpired
		+ ", enabled=" + enabled + "}";
    }
}
