package pl.nauka.hangman;

import java.util.*;

public class HangmanParametersAndMethods {

    private String guessedWord;
    private String userInputLetter;
    private String userInputWord;
    private final List<Integer> indexOfLetter = new LinkedList();
    private int attempts;
    private final List<String> clearPasswordIndexesList = new ArrayList<>();
    private final Set<String> missedLetters = new HashSet<>();
    private String clearedPasswordIndexes;
    private boolean loopCondition = true;


    Scanner scanner = new Scanner(System.in);


    //------GETTERS--------------------------------------------------------------------------------------------------


    public boolean isLoopCondition() {
        return loopCondition;
    }

    public String getClearedPasswordIndexes() {
        return clearedPasswordIndexes;
    }

    public Set<String> getMissedLetters() {
        return missedLetters;
    }

    public String getUserInputLetter() {
        return userInputLetter;
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public String getUserInputWord() {
        return userInputWord;
    }

    public int getAttempts() {
        return attempts;
    }

    public List<String> getClearPasswordIndexesList() {
        return clearPasswordIndexesList;
    }

    //------SETTERS--------------------------------------------------------------------------------------------------

    public void setLoopCondition(boolean loopCondition) {
        this.loopCondition = loopCondition;
    }

    public void setClearedPasswordIndexes(String clearedPasswordIndexes) {
        this.clearedPasswordIndexes = clearedPasswordIndexes;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setGuessedWord(String guessedWord) {
        this.guessedWord = guessedWord;
    }

    public void setUserInputLetter(String userInputLetter) {
        this.userInputLetter = userInputLetter;
    }

    public void setUserInputWord(String userInputWord) {
        this.userInputWord = userInputWord;
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    // metoda zapisywania w setcie indexów trafionych liter / method saves in set array indexes of match letters.
    void saveMatchInputLetterToArrayList(String wordToCovert, String inputLetter) {
        int i = 0;
        char userInputLetterChar = getFirstIndexOfString(inputLetter); // pobiera pierwszy znak Stringa i zwraca go
        char[] charArray = wordToCovert.toCharArray();    // pobiera Stringa (hasło wisielca), tworzy tablice char-ów
        // z tego słowa
        for (char chars : charArray) {                    // w pętli przechodzi po kazdym znaku z tej tablicy i
            // przypisuje go do zmiennej o nazwie chars
            if (userInputLetterChar == (chars)) {         // jeśli wprowadzony znak pasuje do któregos znaku z hasła
                // wisielca
                indexOfLetter.add(i);                     // zapisuje każde następne przejście pętli w secie (lista)
            }                                             // kiedy natrafi na literke podaną przez użytkownika
            i++;                                          // inkrementacja pętli
        }
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    //metoda zamieniania hasła na "_ _ _ _ _" .
    public String converToUnderscores(String wordToConvert) {
        String s1 = wordToConvert.replaceAll("", " ");
        return s1.replaceAll("[0-9]", "_");
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    //metoda zamieniania zgadywanego słowa na indexy np kolor -> 01234
    String changeStringToIndexes(String wordToConvert) {
        int[] array = new int[wordToConvert.length()];
        for (int i = 0; i < wordToConvert.length(); i++) {
            array[i] = i;
        }
        return Arrays.toString(array);
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    //wyczyśc wszystkie nawiasy kwadratowe, spacje i przecinki
    protected String clearAllSquareBracketsCommasSpaces(String wordToClear) {
        String s1 = wordToClear.replaceAll(",", "");
        String s2 = s1.replaceAll("\\[", "");
        String s3 = s2.replaceAll("]", "");
        return s3.replaceAll(" ", "");
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    //wyczyść wszystkie nawiazy kwadratowe []
    String clearAllSquareBrackets(String wordToClear) {
        String s = wordToClear.replaceAll("\\[", "");
        return s.replaceAll("]", "");
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    // metoda podmieniająca ciąg np. 01234 na zgadnięte litery i zwraca np. 0k23k
    String changeEmptyFieldsToInputLetter(String userInputLetter, String unknownPassword, String guessedWord) {
        char userInputLetterChar = getFirstIndexOfString(userInputLetter); // użyto w 2 metodach trzeba wydzielic do 1 metody
        saveMatchInputLetterToArrayList(guessedWord, userInputLetter);//zwróc indexy trafionej litery
        StringBuilder sbUnknownPassword = new StringBuilder(unknownPassword); // stwórz stringbuilder dla unknownPassword

        for (int i = 0; i < indexOfLetter.size(); i++) {
            sbUnknownPassword.setCharAt(indexOfLetter.get(i), userInputLetterChar); // zamien podany z tablicy "indexOfLetter index, na podana iterke
        }
        indexOfLetter.clear();
        return sbUnknownPassword.toString();
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    String leaveCharactersAThroughZRestDeleteAndToLowerCase(String word) {
        return word.toLowerCase().replaceAll("[^a-z]", "");
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    char getFirstIndexOfString(String word) {
        return word.charAt(0);

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    // działa tylko raz, do naprawy
    String repeatIfEnteredDataIsEmpty(String enteredData) {
        boolean chooseLoop = true;
        while (chooseLoop) {
            if (enteredData.isEmpty()) {
                System.out.print("Podaj jeszcze raz:");
                enteredData = scanner.nextLine();

            } else {
                chooseLoop = false;
            }
        }
        return enteredData;
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    void addAttempts() {
        setAttempts(attempts + 1);
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    String repeatIfMoreThen10Indexes(String word) {
        boolean loop = true;
        while (loop) {
            char[] chars = word.toCharArray();
            if (chars.length >= 11) {
                System.out.println("wpisałeś więcej niż 10 znaków, wpisz ponownie słowo:");
                word = scanner.nextLine();
            } else {
                loop = false;
            }
        }
        return word;
    }

}
