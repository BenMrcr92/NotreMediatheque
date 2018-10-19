package nous2.mediatheque.dto;

public class SupportDTO {

    private Long id;

    private String type;

    public SupportDTO() {
	//
    }

    public SupportDTO(Long id, String type) {
	setId(id);
	setType(type);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", type=" + type + "}";
    }
}
