package pl.nauka.hangman;

import pl.nauka.graphic.HangmanGraphic;

import java.util.Locale;

public class Hangman extends HangmanParametersAndMethods {

    HangmanGraphic hangmanGraphic = new HangmanGraphic();


    void rules (){
        System.out.println();
        System.out.println("                      _____________________________________________");
        System.out.println("                     |                   HANGMAN                   |");
        System.out.println("                     |                                             |");
        System.out.println("                     | 1. Without Polish symbols.                  |");
        System.out.println("                     | 2. Without numbers.                         |");
        System.out.println("                     | 3. 1 - 10 letters.                          |");
        System.out.println("                     | 4. Have fun!                                |");
        System.out.println("                     |_____________________________________________|");
        System.out.println();

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    private void enterThePassword() {
        System.out.println("Wpisz hasło do odgadnięcia:");
        setGuessedWord(leaveCharactersAThroughZRestDeleteAndToLowerCase(scanner.nextLine()));
        setGuessedWord(repeatIfMoreThen10Indexes(getGuessedWord()));
        setGuessedWord(repeatIfEnteredDataIsEmpty(getGuessedWord()));


        String passwordIndexes = changeStringToIndexes(getGuessedWord());
        // pobierz zgadywane hasło, zamień na indexy wszystkie litery ("koło" -> [0, 1, 2, 3]) zapisz w zmiennej passwordIndexes
        setClearedPasswordIndexes(clearAllSquareBracketsCommasSpaces(passwordIndexes));
        // pobierz wyżej zapisane indexy zgadywanego słowa i wyczyść wszstkie przecinki, spacje i nawiasy kwadratowe
        // [0, 1, 2 ,3] -> 0123
        getClearPasswordIndexesList().add(getClearedPasswordIndexes());
        // dodaj do wyżej zapisanej listy zmienną o typie String z zawartoćią indexaów hasła.
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------


    private void guessingEntirePassword() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.print("\t\t\t\t\t\t\tWpisz zgadywane słowo: ");
        setUserInputWord(leaveCharactersAThroughZRestDeleteAndToLowerCase(scanner.nextLine()));
        System.out.println();
        System.out.println();
        System.out.println();
        setUserInputWord(repeatIfEnteredDataIsEmpty(getUserInputWord()));
        getFirstIndexOfString(getUserInputWord());
        System.out.println(getGuessedWord());
        boolean inputEqualsPassword = getGuessedWord().equals(getUserInputWord());
        if (inputEqualsPassword) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("GRATULACJE!! WYGRAŁEŚ!!");
            System.out.println();
            System.out.println();
            setLoopCondition(false);
        } else {
            addAttempts();
            System.out.println();
            System.out.println("Niestety nie trafiłeś. Próbuj dalej.");
            System.out.println();
        }
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------


    private void guessingSingleLetter() {

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("(pierwsza wpisana litera bedzie brana pod uwagę)");
        System.out.println();
        System.out.print("Wpisz literkę do odgadnięcia: ");

        setUserInputLetter(leaveCharactersAThroughZRestDeleteAndToLowerCase(scanner.nextLine()));
        //uwyczysc ze zbednych znakow wpisywana litere i zostaw tylko znaki od a do z
        setUserInputLetter(repeatIfEnteredDataIsEmpty(getUserInputLetter()));

        char firstLetterChar = getFirstIndexOfString(getUserInputLetter());
        //po wyczyszczeniu pobierz tylko pierwszy znak wpisanego ciagu znakow
        String firstLetterString = Character.toString(firstLetterChar);
        // zamien typ char na typ string
        setUserInputLetter(firstLetterString);

        setClearedPasswordIndexes(changeEmptyFieldsToInputLetter(getUserInputLetter(),
                getClearedPasswordIndexes(), getGuessedWord()));

        getClearPasswordIndexesList().add(getClearedPasswordIndexes());

        if (getClearPasswordIndexesList().get(0).equals(getClearPasswordIndexesList().get(1))) {

            addAttempts();
            // zapisz wtedy nie trafioną litere w zmiennej i wyswietl ją, dodając kazdą nastepną
            getMissedLetters().add(getUserInputLetter());
        } else {
            System.out.println();
            System.out.println("trafiłeś!");
            System.out.println();
        }
        System.out.println();
        getClearPasswordIndexesList().remove(0);

        /*
         * wyżej dodaje hasło jakie zostało zmienione po wprowadzeniu literki
         * i porównuje je z hasłem jakie było poprzednio zmienione po dodaniu literki (za pierwszym
         * przejśćiem programu, w indexie - 0 zapisywane jest puste hasło, i jeśli nie zgadniemy literki
         * to w arrayliście zostanie zapisane w indeksie - 0 puste hasło i w 1 indeksie również
         * puste hasło.
         * Niżej porównanie indeksu 0 i 1, i jesli beą sie zgadzac to zostanie cos zrobione
         * i odwrotnie.
         * Później usuwany jest  index - 0 po to aby zapisac kolejną próbe odgadnięcia hasło
         */

        if (getClearedPasswordIndexes().equals(getGuessedWord())) {
            System.out.println();
            System.out.println();
            System.out.println("GRATULACJE!!! ZGADŁEŚ!!!");
            System.out.println();
            System.out.println();
            setLoopCondition(false);
        }

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------


    private void exit() {
        boolean loopCondition3 = true;
        while (loopCondition3) {
            System.out.println("Czy jesteś pewien?");
            System.out.println("        y / n     ");
            String yesOrNo = scanner.nextLine();
            if (yesOrNo.equals("y")) {
                loopCondition3 = false;
                setLoopCondition(false);
            } else if (yesOrNo.equals("n")) {
                loopCondition3 = false;
                System.out.println("Gramy dalej");
            } else {
                loopCondition3 = true;
            }
        }
    }

//-------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------

    public void menu() {
        System.out.print("Wpisz 1, 2 lub 3: ");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1 -> {
                guessingEntirePassword();
            } // zgadnij całe hasło
            case 2 -> {
                guessingSingleLetter();
            } // zgadnij 1 literkę
            case 3 -> { // wyjście
                exit();
            } //  wyjście z programu
            default -> System.out.println("Coś poszło nie tak");
        }
    }

//-----------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    public void hangmanGraphicSelector() {
        switch (getAttempts()) {
            case 0 -> {
                hangmanGraphic.graphic0();
            }
            case 1 -> {
                hangmanGraphic.graphic1();
            }
            case 2 -> {
                hangmanGraphic.graphic2();
            }
            case 3 -> {
                hangmanGraphic.graphic3();
            }
            case 4 -> {
                hangmanGraphic.graphic4();
            }
            case 5 -> {
                hangmanGraphic.graphic5();
            }
            case 6 -> {
                hangmanGraphic.graphic6();
            }
            case 7 -> {
                hangmanGraphic.graphic7();
            }
            case 8 -> {
                hangmanGraphic.graphic8();
            }
            case 9 -> {
                hangmanGraphic.graphic9();
            }

        }
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    public void hangmanTheGame() {

        rules();

        enterThePassword();

        setLoopCondition(true);
        while (isLoopCondition()) {

            int attempts = getAttempts();
            String passwordUnderscore = converToUnderscores(getClearedPasswordIndexes());
            System.out.println();
            System.out.println("Pozostało prób: " + (10 - attempts) + "\t\t\t\t\t" +
                    "HASŁO: " + passwordUnderscore.toUpperCase(Locale.ROOT));
            System.out.println("Nie trafione litery: " + clearAllSquareBrackets(getMissedLetters().toString())
                    .toUpperCase(Locale.ROOT));

            if (attempts == 10) {
                hangmanGraphic.graphic10(getGuessedWord());
                break;
            }
            System.out.println();

            hangmanGraphicSelector();
            menu();
        }
    }

}
