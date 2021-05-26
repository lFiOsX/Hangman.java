/*
 *Założenia:
 * 1. Hasło do odgadnięcia od 1 do 10 znaków.
 * 2. Bez używania polskich znaków.
 */

package pl.nauka;

import pl.nauka.graphic.HangmanGraphic;
import pl.nauka.hangman.Hangman;

import java.util.Scanner;

public class Game {


    public static void main(String[] args) {

        Hangman hangman = new Hangman();

        hangman.hangmanTheGame();


    }
}