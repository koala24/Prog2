/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author KOALA
 */
public class StringTool {
    private StringTool()
    {

    }

    public static Map<Character, Integer> collectDuplicateCharacters(String string)
    {
	char[] characters = string.toCharArray();
	Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	for (Character ch : characters)
	{
	    if (charMap.containsKey(ch))
            {
		charMap.put(ch, charMap.get(ch) + 1);
            }
            else
            {
		charMap.put(ch, 1);
            }
        }
	return charMap;
    }

    public static <T, J> void printSet(Set<Map.Entry<T, J>> set)
    {
	for (Map.Entry<T, J> entry : set)
	{
            System.out.println(entry.getKey() + " : " + entry.getValue());
	}
    }

    public static boolean isDuplicateCharacterPresent(String string)
    {
	boolean present = false;
	char[] characters = string.toCharArray();
	Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	for (int i = 0; i < characters.length && !present; i++)
	{
            if (charMap.containsKey(characters[i]))
            {
		present = true;
            }
            else
            {
		charMap.put(characters[i], 1);
            }
	}
	return present;
    }
    
    public static boolean isDuplicateDigitPresent(String string)
    {
	boolean present = false;
	char[] characters = string.toCharArray();
	Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	for (int i = 0; i < characters.length && !present; i++)
	{
            if (charMap.containsKey(characters[i])
		&& Character.isDigit(characters[i]))
            {
		present = true;
            }
            else
            {
		charMap.put(characters[i], 1);
            }
	}
	return present;
    }

    public static boolean isDigitPresent(String string)
    {
	boolean present = false;
	char[] characters = string.toCharArray();
	for (int i = 0; i < characters.length && !present; i++)
	{
            if (Character.isDigit(characters[i]))
            {
		present = true;
            }
	}
	return present;
    }

    public static boolean isLetterPresent(String string)
    {
	boolean present = false;
	char[] characters = string.toCharArray();
	for (int i = 0; i < characters.length && !present; i++)
	{
            if (Character.isLetter(characters[i]))
            {
		present = true;
            }
	}
	return present;
    }
	
    public static boolean isPureDigitString(String string)
    {
	boolean present = true;
	char[] characters = string.toCharArray();
	for (int i = 0; i < characters.length && present; i++)
	{
            if (!Character.isDigit(characters[i]))
            {
		present = false;
            }
	}
	return present;
    } 
}
