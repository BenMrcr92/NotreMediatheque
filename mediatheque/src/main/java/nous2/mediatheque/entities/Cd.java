package nous2.mediatheque.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cd extends Element implements Serializable {

    private static final long serialVersionUID = 8222161924938605210L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private LocalDate dateSortie;

    public Cd() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public LocalDate getDateSortie() {
	return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
	this.dateSortie = dateSortie;
    }
}
