import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day1 {

    public static void main( String[] args) {
        try {
        BufferedReader reader = new BufferedReader(new FileReader("Tag1/ressources/text.txt"));
        String line = reader.readLine();
        int totalNum = 0;

        while (line != null) {
            char firstNum = 'a';
            char lastNum = 'a';
            for (int i = 0; i< line.length(); i++)
            {
                if( Character.isDigit(line.charAt(i)))
                {
                    firstNum = line.charAt(i);
                    break;
                }
            }
            for (int i = line.length()-1 ; i>=0; i--)
            {
                if( Character.isDigit(line.charAt(i)))
                {
                    lastNum = line.charAt(i);
                    break;
                }
            }
            String combinedNum = "" + firstNum + lastNum;
            totalNum += Integer.parseInt(combinedNum);
            line = reader.readLine();
        }

        reader.close();
        System.out.println(totalNum);
    } catch (
    IOException e) {
        e.printStackTrace();
    }
    }
}