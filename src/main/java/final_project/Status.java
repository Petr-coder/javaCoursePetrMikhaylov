package final_project;

enum Status {
    SHIP_CELL("\uD83D\uDEE5"), HALO_SHIP("\uD83D\uDFE6"),
    PUNCHED_CELL("\uD83D\uDFE5"), EMPTY("⬜"), GUESS ("\uD83D\uDD33"),
    DESTROYED("❌");


    private String name;

    public String getName() {
        return name;
    }


    Status(String name) {
        this.name = name;
    }


}
