package nous2.mediatheque.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    // @NotEmpty(message = "{error.commons.required}")
    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "film_id")
    // private Set<Support> supports = new TreeSet<>();
    @Column(nullable = false)
    private boolean dvd;

    @Column(nullable = false)
    private boolean blueRay;

    @Column(nullable = false)
    private boolean numerique;

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

    // public void addSupport(Support support) {
    // supports.add(support);
    // }
    //
    // public void removeSupport(Support support) {
    // supports.remove(support);
    // }
    public boolean isDvd() {
	return dvd;
    }

    public void setDvd(boolean dvd) {
	this.dvd = dvd;
    }

    public boolean isBlueRay() {
	return blueRay;
    }

    public void setBlueRay(boolean blueRay) {
	this.blueRay = blueRay;
    }

    public boolean isNumerique() {
	return numerique;
    }

    public void setNumerique(boolean numerique) {
	this.numerique = numerique;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result
		+ (dateSortie == null ? 0 : dateSortie.hashCode());
	result = prime * result + (id == null ? 0 : id.hashCode());
	result = prime * result + (nom == null ? 0 : nom.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Film other = (Film) obj;
	if (dateSortie == null) {
	    if (other.dateSortie != null) {
		return false;
	    }
	} else if (!dateSortie.equals(other.dateSortie)) {
	    return false;
	}
	if (nom == null) {
	    if (other.nom != null) {
		return false;
	    }
	} else if (!nom.equals(other.nom)) {
	    return false;
	}
	return true;
    }
}
