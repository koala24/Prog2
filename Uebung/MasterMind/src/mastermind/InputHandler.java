/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author KOALA
 */
public class InputHandler {
    private static BufferedReader input =
    		new BufferedReader(new InputStreamReader(System.in));
    
    private InputHandler()
    {
    	
    }
    
    public static String captureString(String prompt)
    {
        System.out.print(prompt);
        String text = "";
        boolean inputOk = false;
        while (!inputOk)
        {
            try
            {
                text = input.readLine();
                inputOk = true;
            }
            catch(IOException ioe)
            {
            }
        }
        return text;
    }
    
    public static String captureString(String prompt, int length)
    {
		String text = "";
		boolean inputOk = false;
		while (!inputOk)
		{
			text = captureString(prompt);
			inputOk = text.length() == length;
		}
		return text;
    }
    
	public static String captureString(String prompt,
			                           String inputFormat)
	{
		String text = "";
		boolean inputOk = false;
		while (!inputOk)
		{
			text = captureString(prompt);
			inputOk = text.matches(inputFormat);
		}
		return text;
	}
    
    public static String captureString()
    {
    	return captureString("");
    }
    
    public static String captureStringDuplicateFree(String prompt)
    {
    	String text = "";
    	boolean inputOk = false;
    	while (!inputOk)
    	{
    		text = captureString(prompt);
    		inputOk = !StringTool.isDuplicateCharacterPresent(text);
    	}
		return text;
    }
    
    public static String captureDigitString(String prompt)
    {
    	String text = "";
    	boolean inputOk = false;
    	while (!inputOk)
    	{
    		text = captureString(prompt);
    		inputOk = StringTool.isPureDigitString(text);
    	}
		return text;
    }
    
    public static String captureDigitString(String prompt, int length)
    {
    	String text = "";
    	boolean inputOk = false;
    	while (!inputOk)
    	{
    		text = captureDigitString(prompt);
    		inputOk = text.length() == length ? true : false;
    	}
    	return text;
    }
    
    public static String captureDigitStringDuplicateFree(String prompt, int length)
    {
    	String text = "";
    	boolean inputOk = false;
    	while (!inputOk)
    	{
    		text = captureDigitString(prompt, length);
    		inputOk = !StringTool.isDuplicateDigitPresent(text);
    	}
    	return text;
    }

    public static int captureInt(String prompt)
    {
        int value = 0;
        boolean inputOk = false;
        while (!inputOk)
        {
            try
            {
            	value = Integer.parseInt(captureString(prompt));
                inputOk = true;
            }
            catch (NumberFormatException nfe)
            {
            }
        }
        return value;
    }

    public static int captureInt(String prompt, int min, int max)
    {
        int value = 0;
        boolean inputOk = false;
        while (!inputOk)
        {
        	value = captureInt(prompt);
            inputOk = (min <= value && value <= max);
        }
        return value;
    }
    
    public static int captureInt()
    {
        return captureInt("");
    }

    public static double captureDouble(String prompt) 
    {
        double value = 0;
        boolean inputOk = false;
        while (!inputOk)
        {
            try 
            {
            	value = Double.parseDouble(captureString(prompt));
            	inputOk = true;
            } 
            catch (NumberFormatException nfe) 
            {
            }
        }
        return value;
    }

    public static double captureDouble(String prompt, double min, double max)  
    {
        double value = 0;
        boolean inputOk = false;
        while (!inputOk)  
        {
        	value = captureDouble(prompt);
        	inputOk = (min <= value && value <= max);
        }
        return value;
    }
    
    public static double captureDouble() 
    {
        return captureDouble("");
    }
}
