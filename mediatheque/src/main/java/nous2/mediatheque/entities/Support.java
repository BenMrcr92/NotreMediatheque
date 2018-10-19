package nous2.mediatheque.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Support implements Serializable {

    private static final long serialVersionUID = -1190196733475855886L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1, nullable = false, unique = true)
    private String code;

    @Column(length = 10, nullable = false, unique = true)
    private String typeFr;

    @Column(length = 10, nullable = false, unique = true)
    private String typeEn;

    public Support() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getTypeFr() {
	return typeFr;
    }

    public void setTypeFr(String abbr) {
	typeFr = abbr;
    }

    public String getTypeEn() {
	return typeEn;
    }

    public void setTypeEn(String abbr) {
	typeEn = abbr;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof Support)) {
	    return false;
	}
	Support other = (Support) obj;
	return code.equals(other.code);
    }

    @Override
    public int hashCode() {
	return Objects.hash(code);
    }

    @Override
    public String toString() {
	return "{id=" + id + ", code=" + code + ", typeFr=" + typeFr
		+ ", typeEn=" + typeEn + "}";
    }
}
