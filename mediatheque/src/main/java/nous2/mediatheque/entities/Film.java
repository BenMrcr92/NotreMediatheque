package nous2.mediatheque.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Film extends Element implements Serializable {

    private static final long serialVersionUID = 8222161924938605210L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private LocalDate dateSortie;

    @NotEmpty(message = "{error.commons.required}")
    @ElementCollection(targetClass = Support.class)
    @CollectionTable(name = "film_support", joinColumns = @JoinColumn(name = "film_id"))
    @Column(name = "support_id")
    private Set<Support> supports;

    public Film() {
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
