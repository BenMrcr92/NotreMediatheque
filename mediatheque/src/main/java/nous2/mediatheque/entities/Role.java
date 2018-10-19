package nous2.mediatheque.entities;

public enum Role {
    ROLE_ADMIN, ROLE_MANAGER, ROLE_USER;

    // ADMIN(Droit.WRITE, Droit.WRITE),
    // MANAGER(Droit.NONE, Droit.WRITE),
    // USER(Droit.NONE, Droit.READ);
    //
    // private Droit user;
    //
    // private Droit element;
    //
    // private Role(Droit user, Droit element) {
    // this.user = user;
    // this.element = element;
    // }
    //
    // public String getName() {
    // return name();
    // }
    //
    // private static enum Droit {
    // NONE, READ, WRITE;
    //
    public String getName() {
	return name();
    }
    // }
}
