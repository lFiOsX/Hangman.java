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

    // metoda zapisywania w setcie index??w trafionych liter / method saves in set array indexes of match letters.
    void saveMatchInputLetterToArrayList(String wordToCovert, String inputLetter) {
        int i = 0;
        char userInputLetterChar = getFirstIndexOfString(inputLetter); // pobiera pierwszy znak Stringa i zwraca go
        char[] charArray = wordToCovert.toCharArray();    // pobiera Stringa (has??o wisielca), tworzy tablice char-??w
        // z tego s??owa
        for (char chars : charArray) {                    // w p??tli przechodzi po kazdym znaku z tej tablicy i
            // przypisuje go do zmiennej o nazwie chars
            if (userInputLetterChar == (chars)) {         // je??li wprowadzony znak pasuje do kt??regos znaku z has??a
                // wisielca
                indexOfLetter.add(i);                     // zapisuje ka??de nast??pne przej??cie p??tli w secie (lista)
            }                                             // kiedy natrafi na literke podan?? przez u??ytkownika
            i++;                                          // inkrementacja p??tli
        }
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    //metoda zamieniania has??a na "_ _ _ _ _" .
    public String converToUnderscores(String wordToConvert) {
        String s1 = wordToConvert.replaceAll("", " ");
        return s1.replaceAll("[0-9]", "_");
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    //metoda zamieniania zgadywanego s??owa na indexy np kolor -> 01234
    String changeStringToIndexes(String wordToConvert) {
        int[] array = new int[wordToConvert.length()];
        for (int i = 0; i < wordToConvert.length(); i++) {
            array[i] = i;
        }
        return Arrays.toString(array);
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    //wyczy??c wszystkie nawiasy kwadratowe, spacje i przecinki
    protected String clearAllSquareBracketsCommasSpaces(String wordToClear) {
        String s1 = wordToClear.replaceAll(",", "");
        String s2 = s1.replaceAll("\\[", "");
        String s3 = s2.replaceAll("]", "");
        return s3.replaceAll(" ", "");
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    //wyczy???? wszystkie nawiazy kwadratowe []
    String clearAllSquareBrackets(String wordToClear) {
        String s = wordToClear.replaceAll("\\[", "");
        return s.replaceAll("]", "");
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    // metoda podmieniaj??ca ci??g np. 01234 na zgadni??te litery i zwraca np. 0k23k
    String changeEmptyFieldsToInputLetter(String userInputLetter, String unknownPassword, String guessedWord) {
        char userInputLetterChar = getFirstIndexOfString(userInputLetter); // u??yto w 2 metodach trzeba wydzielic do 1 metody
        saveMatchInputLetterToArrayList(guessedWord, userInputLetter);//zwr??c indexy trafionej litery
        StringBuilder sbUnknownPassword = new StringBuilder(unknownPassword); // stw??rz stringbuilder dla unknownPassword

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

    // dzia??a tylko raz, do naprawy
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
                System.out.println("wpisa??e?? wi??cej ni?? 10 znak??w, wpisz ponownie s??owo:");
                word = scanner.nextLine();
            } else {
                loop = false;
            }
        }
        return word;
    }

}
