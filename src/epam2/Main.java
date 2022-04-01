package epam2;

import java.io.*;
import java.util.ArrayList;

public abstract class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Word> words = new ArrayList<>();
        ArrayList<Other> others = new ArrayList<>();
        String[] subStr;
        ArrayList<Line> lines = readFile();
        for (Line x : lines) {
            String delimiters = " ";
            subStr = x.getL().split(delimiters);
            for (int i = 0; i < subStr.length; i++) {
                if (subStr[i].trim().length() != 0) {
                    subStr[i] = deleteFirstCharacters(subStr[i]);
                    subStr[i] = deleteLastCharacters(subStr[i]);
                    char[] chars = subStr[i].toCharArray();
                    if (!Character.isLetter(chars[0]) || checkOnMail(chars)) {
                        Other other = new Other();
                        other.setL(subStr[i]);
                        others.add(other);
                    } else {
                        Word word = new Word();
                        word.setL(subStr[i]);
                        words.add(word);
                    }
                }
            }
        }
        words.sort(Word.AlphabetOrder);
        writeToFile(words, others);
    }

    static String deleteCharacters(String str, int to) {
        return str.substring(0, 0) + str.substring(to);
    }

    static String deleteFirstCharacters(String str) {
        int a = 0;
        for (int j = 0; j < j + 1; j++) {
            char[] charters = str.toCharArray();
            if (Character.isLetter(charters[j]) || charters[j] == '+' || Character.isDigit(charters[j])) {
                break;
            } else {
                a++;
            }
        }
        str = deleteCharacters(str, a);
        return str;
    }

    static String deleteLastCharacters(String str) {
        int a = str.length();
        for (int j = str.length() - 1; j >= 0; j--) {
            char[] charters = str.toCharArray();
            if (Character.isLetter(charters[j]) || Character.isDigit(charters[j]) || Character.isDigit(charters[j])) {
                break;
            } else {
                a--;
            }
        }
        return str.substring(0, a);
    }

    static boolean checkOnMail(char[] chars) {
        for (char aChar : chars) {
            if (aChar == '@')
                return true;
        }
        return false;
    }

    static ArrayList<Line> readFile() throws Exception {
        ArrayList<Line> lines = new ArrayList<>();
        File file = new File("D:\\kyrs\\exercise2\\src\\epam2\\nom2.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine().toLowerCase();
        while (line != null) {
            Line str = new Line();
            str.setL(line);
            lines.add(str);
            line = reader.readLine();
        }
        fr.close();
        return lines;
    }

    static void writeToFile(ArrayList<Word> words, ArrayList<Other> others) throws Exception {
        String str = words.get(0).getL();
        FileWriter fw = new FileWriter("D:\\kyrs\\exercise2\\src\\epam2\\result.txt");
        for (Word x : words) {
            if (!x.getL().regionMatches(0, str, 0, 1)) {
                fw.write("\n");
            }
            fw.write(x.getL() + " ");
            str = x.getL();
        }
        fw.write("\n");
        for (Other x : others)
            fw.write(x.getL() + " ");
        fw.close();
    }
}
