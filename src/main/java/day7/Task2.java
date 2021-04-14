package day7;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Player player1 = new Player(generateStaminaForPlayer());
        Player player2 = new Player(generateStaminaForPlayer());
        Player player3 = new Player(generateStaminaForPlayer());
        Player player4 = new Player(generateStaminaForPlayer());
        Player player5 = new Player(generateStaminaForPlayer());
        Player player6 = new Player(generateStaminaForPlayer());

        for (int i = player1.getStamina(); i > Player.MIN_STAMINA - 1; i--) {
            if (player1.getStamina() > 0) {
                player1.run();
            }
        }

        System.out.println(player1.getStamina());
        Player.info();
        System.out.println(Player.getCountPlayers());
    }

    private static int generateStaminaForPlayer() {
        int min = 90;
        int max = Player.MAX_STAMINA;
        int diff = max - min;
        Random random = new Random();
        return random.nextInt(diff + 1) + min;
    }
}
