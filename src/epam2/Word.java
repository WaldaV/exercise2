package epam2;

import java.util.Comparator;

public class Word extends Line{
    @Override
    public String getL() {
        return super.getL();
    }

    @Override
    public void setL(String l) {
        super.setL(l);
    }

    public static Comparator<Word> AlphabetOrder = Comparator.comparing(Word::getL);

}
