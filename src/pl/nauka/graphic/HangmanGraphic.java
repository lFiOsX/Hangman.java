package pl.nauka.graphic;

import java.util.Locale;

public class HangmanGraphic {

    public void graphic10(String guessedWord) {
        System.out.println("                                               |---------   ");
        System.out.println("                                               |        |   ");
        System.out.println("          PRZEGRAŁEŚ!!                         |        O   ");
        System.out.println("                                               |       /|\\ ");
        System.out.println("                                              / \\       |  ");
        System.out.println("                                             /   \\     / \\");
        System.out.println("          HASŁO: " + guessedWord.toUpperCase(Locale.ROOT) + " ");
    }

    public void graphic9() {
        System.out.println("[1] - Zgadnij całe hasło.                      |---------   ");
        System.out.println("[2] - Zgadnij literkę.                         |        |   ");
        System.out.println("[3] - Wyjście.                                 |        O   ");
        System.out.println("                                               |       /|\\ ");
        System.out.println("                                              / \\       |  ");
        System.out.println("                                             /   \\       \\");
    }

    public void graphic8() {
        System.out.println("[1] - Zgadnij całe hasło.                      |---------   ");
        System.out.println("[2] - Zgadnij literkę.                         |        |   ");
        System.out.println("[3] - Wyjście.                                 |        O   ");
        System.out.println("                                               |       /|\\ ");
        System.out.println("                                              / \\       |  ");
        System.out.println("                                             /   \\         ");
    }

    public void graphic7() {
        System.out.println("[1] - Zgadnij całe hasło.                      |---------   ");
        System.out.println("[2] - Zgadnij literkę.                         |        |   ");
        System.out.println("[3] - Wyjście.                                 |        O   ");
        System.out.println("                                               |       / \\ ");
        System.out.println("                                              / \\          ");
        System.out.println("                                             /   \\         ");
    }

    public void graphic6() {
        System.out.println("[1] - Zgadnij całe hasło.                      |---------   ");
        System.out.println("[2] - Zgadnij literkę.                         |        |   ");
        System.out.println("[3] - Wyjście.                                 |        O   ");
        System.out.println("                                               |       /    ");
        System.out.println("                                              / \\          ");
        System.out.println("                                             /   \\         ");

    }

    public void graphic5() {
        System.out.println("[1] - Zgadnij całe hasło.                      |---------   ");
        System.out.println("[2] - Zgadnij literkę.                         |        |   ");
        System.out.println("[3] - Wyjście.                                 |        O   ");
        System.out.println("                                               |            ");
        System.out.println("                                              / \\          ");
        System.out.println("                                             /   \\         ");
    }

    public void graphic4() {
        System.out.println("[1] - Zgadnij całe hasło.                      |---------   ");
        System.out.println("[2] - Zgadnij literkę.                         |        |   ");
        System.out.println("[3] - Wyjście.                                 |            ");
        System.out.println("                                               |            ");
        System.out.println("                                              / \\          ");
        System.out.println("                                             /   \\         ");
    }

    public void graphic3() {
        System.out.println("[1] - Zgadnij całe hasło.                      |            ");
        System.out.println("[2] - Zgadnij literkę.                         |            ");
        System.out.println("[3] - Wyjście.                                 |            ");
        System.out.println("                                               |            ");
        System.out.println("                                              / \\          ");
        System.out.println("                                             /   \\         ");
    }

    public void graphic2() {
        System.out.println("[1] - Zgadnij całe hasło.                                   ");
        System.out.println("[2] - Zgadnij literkę.                                      ");
        System.out.println("[3] - Wyjście.                                              ");
        System.out.println("                                                            ");
        System.out.println("                                              / \\          ");
        System.out.println("                                             /   \\         ");
    }


    public void graphic1() {
        System.out.println("[1] - Zgadnij całe hasło.                                   ");
        System.out.println("[2] - Zgadnij literkę.                                      ");
        System.out.println("[3] - Wyjście.                                              ");
        System.out.println("                                                            ");
        System.out.println("                                              /             ");
        System.out.println("                                             /              ");
        System.out.println("                                            /               ");
    }

    public void graphic0() {
        System.out.println("[1] - Zgadnij całe hasło.                                   ");
        System.out.println("[2] - Zgadnij literkę.                                      ");
        System.out.println("[3] - Wyjście.                                              ");
        System.out.println("                                                            ");
        System.out.println("                                                            ");
        System.out.println("                                                            ");
        System.out.println("                                                            ");
    }
}
