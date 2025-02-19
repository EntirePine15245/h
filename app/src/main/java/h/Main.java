

public class Main {

  public static void main(String[] args) {
   
   System.out.print("Hello SuperHero");
  }
}
import java.util.Scanner;
import java.util.Random;

public class SnakeGame {
    // Spielfeld-Größe
    static int height = 10;
    static int width = 10;

    // Snake-Position
    static int snakeX, snakeY;

    // Futter-Position
    static int foodX, foodY;

    // Score
    static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean gameOver = false;

        // Initiale Position der Snake
        snakeX = width / 2;
        snakeY = height / 2;

        // Futter zufällig platzieren
        foodX = random.nextInt(width);
        foodY = random.nextInt(height);

        // Spielschleife
        while (!gameOver) {
            // Spielfeld zeichnen
            drawField();

            // Bewegung des Spielers (Snake)
            System.out.print("Wohin möchtest du gehen? (WASD): ");
            char move = scanner.next().charAt(0);

            switch (move) {
                case 'w':
                    snakeY--;
                    break;
                case 's':
                    snakeY++;
                    break;
                case 'a':
                    snakeX--;
                    break;
                case 'd':
                    snakeX++;
                    break;
                default:
                    System.out.println("Ungültige Eingabe!");
            }

            // Snake trifft auf Futter
            if (snakeX == foodX && snakeY == foodY) {
                score++;
                foodX = random.nextInt(width);
                foodY = random.nextInt(height);
            }

            // Kollisionsabfrage mit den Spielfeldrändern
            if (snakeX < 0 || snakeX >= width || snakeY < 0 || snakeY >= height) {
                gameOver = true;
                System.out.println("Game Over! Dein Score: " + score);
            }
        }
        scanner.close();
    }

    // Spielfeld darstellen
    public static void drawField() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == snakeX && y == snakeY) {
                    System.out.print("S ");  // Snake
                } else if (x == foodX && y == foodY) {
                    System.out.print("F ");  // Futter
                } else {
                    System.out.print(". ");  // Leeres Feld
                }
            }
            System.out.println();
        }
        System.out.println("Score: " + score);
    }
}