package day7;

public class Player {
    private int stamina;

    static final int MAX_STAMINA = 100;
    static final int MIN_STAMINA = 0;

    static int countPlayers = 0;

    public int getStamina() {
        return stamina;
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    public Player(int stamina) {
        this.stamina = stamina;

        if (countPlayers < 6) {
            countPlayers++;
        }
    }

    public void run() {
        if (this.stamina > 1) {
            this.stamina -= 1;
        } else if(this.stamina == 1){
            this.stamina = MIN_STAMINA;
            countPlayers--;
        } else{
            this.stamina = MIN_STAMINA;
        }
    }

    public static void info() {
        if (countPlayers < 6) {
            System.out.println("Команды неполные. На поле еще есть " + (6 - countPlayers) + " свободных мест");
        } else {
            System.out.println("На поле нет свободных мест");
        }

    }
}
