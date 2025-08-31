import java.util.Random;

public class GuessMyNumberModel {
    private int secretNumber;
    public int limit;
    public int lastGuess;
    public int nrGuesses;

    public int getMAX(){
        return limit;
    }

    public int getNoOfGuesses(){
        return nrGuesses;
    }

    public GuessMyNumberModel(int limit){
        this.limit = limit;
    }

    public void initGame(){
        Random randomNr = new Random();
        secretNumber = randomNr.nextInt(limit) +1 ;
        System.out.println(" " + secretNumber);
        nrGuesses = 0;
    }

    public void setGuess(int myGuess){
        lastGuess = myGuess;
        nrGuesses++;
    }

    public String compareGuessToStr(){
        if(compareGuess()==1) return "to high";
        else if (compareGuess()==-1) return "to low";
        return "correct";
    }

    private int compareGuess(){
        if (lastGuess>secretNumber) return 1;
        else if (lastGuess <secretNumber) return -1;
        return 0;
     }

    public int getSecret() {
        return secretNumber;
    }
}
