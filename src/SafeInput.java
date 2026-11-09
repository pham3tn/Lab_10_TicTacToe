import java.util.Scanner;
public class SafeInput {

    /**
     *
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt)
    {
        boolean done = false;
        String trash ="";
        int intVal = 0;

        do{
            IO.print("\n" + prompt + ": ");

            if(pipe.hasNextInt())
            {
                intVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else{
                trash = pipe.nextLine();
                IO.println("You must enter a valid integer, not "+trash);
            }
        } while (!done);

        return intVal;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        boolean done = false;
        String trash ="";
        double doubleVal = 0;

        do{
            IO.print("\n" + prompt + ": ");

            if(pipe.hasNextDouble())
            {
                doubleVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else{
                trash = pipe.nextLine();
                IO.println("You must enter a valid double, not "+trash);
            }
        } while (!done);

        return doubleVal;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        boolean done = false;
        String trash = "";
        int rangedInt = 0;

        do{
            IO.print(prompt + " [" + low + "-" +high +"]: ");

            if(pipe.hasNextInt())
            {
                rangedInt = pipe.nextInt();
                pipe.nextLine();

                if(rangedInt >= low & rangedInt<=high)
                    done = true;

                else
                    IO.println("You must enter a valid value within the range [" + low + "-" +high +"]");

            }
            else{
                trash = pipe.nextLine();
                IO.println("You must enter a valid integer, not "+trash);
            }
        } while (!done);
        return rangedInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double rangedDouble = 0;
        boolean done = false;
        String trash = "";

        do{
            IO.print(prompt + " [" + low + "-" +high +"]: ");

            if(pipe.hasNextDouble())
            {
                rangedDouble = pipe.nextDouble();
                pipe.nextLine();

                if(rangedDouble >= low & rangedDouble<=high)
                    done = true;

                else
                    IO.println("You must enter a valid value within the range [" + low + "-" +high +"]");

            }
            else{
                trash = pipe.nextLine();
                IO.println("You must enter a valid double, not "+trash);
            }
        } while (!done);
        return rangedDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean done = false;
        boolean returnValue = true;
        String response = "";
        String trash = "";

        do{
            IO.print(prompt + "[YyNn]: ");
            response = pipe.nextLine();

            if(response.isEmpty())
            {
                IO.println("You must enter [YyNn] ");
            }

            else if(response.equalsIgnoreCase("Y"))
            {
                done = true;
                returnValue = true;
            }

            else if(response.equalsIgnoreCase("N")) {
                done = true;
                returnValue = false;
            }

            else{
                IO.println("You must answer [YyNn], not " + response);
            }
        } while (!done);

        return returnValue;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        boolean done = false;
        String retVal = "";

        do{
            IO.print(prompt +  ": ");
            retVal = pipe.nextLine();

            if(retVal.matches(regEx))
                done = true;
            else
                IO.println("You must enter a value that matches the regEx! ");

        } while (!done);

        return retVal;
    }

    public static void prettyHeader(String msg)
    {
        final int TOTAL_WIDTH = 60;
        final int BORDER_STAR = 3;
        int msgLength = msg.length();
        int totalSpaces = 0;
        int spaceBefore = 0;
        int spaceAfter = 0;

        if(msgLength > 54)
        {
            IO.println("Failed to create header, message is too long!");
            return;
        }
        totalSpaces = TOTAL_WIDTH - (2*BORDER_STAR) - msgLength;
        spaceBefore = totalSpaces/2;

        if(totalSpaces % 2 == 0)
            spaceAfter = spaceBefore;
        else
            spaceAfter = spaceBefore + 1;

        for(int c = 1; c<= TOTAL_WIDTH; c++)
            IO.print("*");
        IO.println();

        for(int c = 1; c<=BORDER_STAR; c++)
            IO.print("*");
        for(int c = 1; c<= spaceBefore; c++)
            IO.print(" ");
        IO.print(msg);
        for(int c =1; c<= spaceAfter; c++)
            IO.print(" ");
        for(int c =1 ; c <= BORDER_STAR; c++)
            IO.print("*");
        IO.println();

        for(int c = 1; c<=TOTAL_WIDTH; c++)
            IO.print("*");
    }
}





