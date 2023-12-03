import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day2 {

    public static void main( String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Tag2/ressources/text.txt"));
            String line = reader.readLine();
            int gameIdSum = 0;

            while (line != null)
            {
                boolean possible = true;
                String gameId = line.split(":")[0];
                line = line.split(":")[1];
                String[] sets = line.split(";");
                for (String set : sets)
                {

                    String[] colors = set.split(",");
                    for (String color : colors )
                    {
                        if(color.contains("red"))
                        {
                            if(Integer.parseInt(color.split(" ")[1])>12)
                            {
                                possible = false;
                            }
                        }
                        else if (color.contains("blue"))
                        {
                            if(Integer.parseInt(color.split(" ")[1])>14)
                            {
                                possible = false;
                            }
                        }
                        else
                        {
                            if(Integer.parseInt(color.split(" ")[1])>13)
                            {
                                possible = false;

                            }
                        }
                    }
                }
                if( possible )
                {
                    gameIdSum += Integer.parseInt(gameId.split(" ")[1]);
                }
                line = reader.readLine();
            }
            System.out.println( gameIdSum);
            reader.close();
        }
        catch ( IOException e)
        {
            e.printStackTrace();
        }
    }
}