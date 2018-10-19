package nous2.mediatheque.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Jeu extends Element implements Serializable {

    private static final long serialVersionUID = -9158194585140750101L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateEdition;

    public Jeu() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public LocalDate getDateEdition() {
	return dateEdition;
    }

    public void setDateEdition(LocalDate dateEdition) {
	this.dateEdition = dateEdition;
    }
}
