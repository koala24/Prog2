/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

/**
 *
 * @author KOALA
 */
public class MasterMindMain {

    private static String randomNumber;
    private static String guessedNumber;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	RandomGenerator randomGenerator = RandomGenerator.getInstance();
	int lengthRandomNumber = 0;
	int countTry = 0;
	randomNumber = "";
	guessedNumber = "";
	String evaluationInfo = "";
	String lengthRandomNumberPrompt = "Wie lang soll die zu " +
	                                  "erratende Zahl sein? [1-10]:    ";
	System.out.println("######################  MasterMind  ######################\n");
	System.out.println("Info: Zahl mit n Stellen erraten [Ziffer 0 bis 9 möglich]\n" +
		           "      (die n-stellige Zahl hat keine doppelten Ziffern!)\n");
	lengthRandomNumber = InputHandler.captureInt(lengthRandomNumberPrompt, 0, 10);
	randomNumber = randomGenerator.getRandomDigitStringDuplicateFree(lengthRandomNumber);	
	do
	{
            guessedNumber = InputHandler.captureDigitStringDuplicateFree(" ---> Raten:    ", 
					                                 lengthRandomNumber);
            evaluationInfo = "(" + ++countTry + "): " + guessedNumber
                             + "  an richtiger Stelle: " + getCountDigitsRightPlace()
                             + "  an falscher Stelle: " + getCountDigitsFalsePlace();
            System.out.print(evaluationInfo);
	} while (!guessedNumber.equals(randomNumber));
	System.out.println(" ---> Erfolg!");
    }
    
    public static int getCountDigitsFalsePlace()
    {
	char[] randomNumberChars = randomNumber.toCharArray();
	char[] guessedNumberChars = guessedNumber.toCharArray();
	int countFalsePlace = 0;	
	for (int i = 0; i < randomNumberChars.length; i++)
	{
            for (int j = 0; j < guessedNumberChars.length; j++)
            {
		if (randomNumberChars[i] == guessedNumberChars[j] && i != j)
		{
                    countFalsePlace++;
		}
            }
	}
	return countFalsePlace;
    }

    public static int getCountDigitsRightPlace()
    {
	char[] randomNumberChars = randomNumber.toCharArray();
	char[] guessedNumberChars = guessedNumber.toCharArray();
	int countRightPlace = 0;	
	for (int i = 0; i < randomNumberChars.length; i++)
	{
            for (int j = 0; j < guessedNumberChars.length; j++)
            {
		if (randomNumberChars[i] == guessedNumberChars[j] && i == j)
		{
                    countRightPlace++;
		}
            }
	}
	return countRightPlace;
    }
}
