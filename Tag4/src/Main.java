import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

class Day4 {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Tag4/ressources/text.txt"));
            String line = reader.readLine();
            int pointSum = 0;

            while (line != null) {
                int exponent = 0;
                String numbersString = line.split(":")[1].split("\\|")[0];
                String winningNumbersString = line.split(":")[1].split("\\|")[1];
                int[] numbers = Arrays.stream(numbersString.trim().replace("  ", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] winningNumbers = Arrays.stream(winningNumbersString.trim().replace("  ", " ").split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int number : numbers)
                {
                    if(IntStream.of(winningNumbers).anyMatch(x -> x == number))
                    {
                        exponent +=1;
                    }
                }
                pointSum += (int) Math.floor(Math.pow(2,exponent-1));
                line = reader.readLine();
            }
            reader.close();
            System.out.println(pointSum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}