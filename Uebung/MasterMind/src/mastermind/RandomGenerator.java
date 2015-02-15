/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.nio.ByteBuffer;
import org.apache.commons.lang3.RandomStringUtils;

/**  Recherche/URLS:
 *     http://docs.oracle.com/javase/7/docs/api/java/security/SecureRandom.html
 *     http://docs.oracle.com/javase/7/docs/api/java/util/Random.html
 *     http://docs.oracle.com/javase/7/docs/api/java/util/Timer.html
 *     
 *     http://books.google.de/books?id=bsiKrwBi8XgC&pg=PA635&lpg=PA635&dq=
 *     setSeed+generateseed&source=bl&ots=_D5nsvlcru&sig=-bEcTxIkQ_URAUpKDUN3ta7Sn_4&hl=
 *     de&sa=X&ei=KUYMVKj9HIK6ygPkzoC4CQ&ved=0CEsQ6AEwBQ#v=onepage&q=setSeed%20generateseed&f=false
 *
 *     http://www.cigital.com/justice-league-blog/2009/08/14/proper-use-of-javas-securerandom/
 *     https://github.com/fangjian601/MembaseTest/blob/master/src/com/xingcloud/dataproxy/
 *     membase/test/random/RandomGenerator.java
 *     http://www.mattnworb.com/post/14312102134/the-dangers-of-java-security-securerandom
 *     http://stackoverflow.com/questions/295628/securerandom-init-once-or-every-time-it-is-needed
 *     http://www.java-blog-buch.de/b-singleton/
 *     http://www.theserverside.de/singleton-pattern-in-java/
 *
 */
public class RandomGenerator extends TimerTask {
    private static RandomGenerator instance = new RandomGenerator();
    private SecureRandom secureRandom;
    private Random random;
    private Timer seedTimer;
    private boolean isValid;
    private static final String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";
    private static final String SECURE_RANDOM_PROVIDER = "SUN";
    private static final int SEED_REFRESH_START_MS = 360000;
    private static final int SEED_REFRESH_PERIOD_MS = 360000;
    private static final int NUM_SEED_BYTES = 8;

    private RandomGenerator()
    {
        isValid = true;
        try
        {
            secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM, 
            		                                SECURE_RANDOM_PROVIDER);
        }
        catch (NoSuchAlgorithmException nsle)
        {
            isValid = false;
        }
        catch (NoSuchProviderException nspe)
        {
            isValid = false;
        }
        random = new Random(System.currentTimeMillis());
        seedTimer = new Timer(true);    // Daemon-Thread
    }

    public static RandomGenerator getInstance()
    {
        return instance;
    }

    public boolean isValid()
    {
        return isValid;
    }

    public long getLongSeed() 
    {
        if (isValid)
        {
            byte[] seed = secureRandom.generateSeed(NUM_SEED_BYTES);
            ByteBuffer byteBuffer = ByteBuffer.wrap(seed);
            return byteBuffer.getLong();
        }
        else
        {
            return -1;
        }
    }

    public int getSecureRandomInt(int max)
    {
        return isValid ? secureRandom.nextInt(max + 1) : -1;
    }

    public int getSecureRandomInt(int min, int max)
    {
        if (min == max)
        {
            return max;
        }
        else
        {
            if (min > max)
            {
                int temp = min;
                min = max;
                max = temp;
            }
            return getSecureRandomInt(max - min) + min;
        }
    }

    public int getSecureRandomInt()
    {
        return isValid ? secureRandom.nextInt() : -1;
    }

    public double getSecureRandomDouble(double max)
    {
        return isValid ? secureRandom.nextDouble() * max : -1;
    }

    public double getSecureRandomDouble(double min, double max)
    {
        if (min == max)
        {
            return max;
        }
        else
        {
            if (min > max)
            {
                double temp = min;
                min = max;
                max = temp;
            }
            return getSecureRandomDouble(max - min) + min;
        }
    }

    public double getSecureRandomDouble()
    {
        return getSecureRandomDouble(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public byte[] getSecureRandomByteArray(int length)
    {
        byte[] bytes = new byte[length];
        secureRandom.nextBytes(bytes);
        return bytes;
    }
    
    public Object getSecureRandomObject(Object[] objects)
    {
    	return objects.length >= 1 ? objects[getSecureRandomInt(objects.length - 1)] : null;
    }

    public String getSecureRandomString(int count, int start,
                                        int end, boolean letters,
                                        boolean numbers, char[] chars)
    {
    	if (isValid)
    	{
            return RandomStringUtils.random(count, start, end, letters,
                                            numbers, chars, secureRandom);
    	}
    	else
    	{
    		return "-1";
    	}
    }
    
    public String getSecureRandomStringAlphabetic(int count)
    {
    	return getSecureRandomString(count, 0, 0, true, false, null);
    }
    
    public String getSecureRandomStringAlphanumeric(int count)
    {
    	return getSecureRandomString(count, 0, 0, true, true, null);
    }

    public String getSecureRandomStringNumeric(int count)
    {
        return getSecureRandomString(count, 0, 0, false, true, null);
    }

    public int getRandomInt(int max)
    {
        return isValid ? random.nextInt(max + 1) : -1;
    }

    public int getRandomInt(int min, int max)
    {
        if (min == max)
        {
            return max;
        }
        else
        {
            if (min > max)
            {
                int temp = min;
                min = max;
                max = temp;
            }
            return getRandomInt(max - min) + min;
        }
    }

    public int getRandomInt()
    {
        return isValid ? random.nextInt() : -1;
    }

    public double getRandomDouble(double max)
    {
        return isValid ? random.nextDouble() * max : -1;
    }

    public double getRandomDouble(double min, double max)
    {
        if (min == max)
        {
            return max;
        }
        else
        {
            if (min > max)
            {
                double temp = min;
                min = max;
                max = temp;
            }
            return getRandomDouble(max - min) + min;
        }
    }

    public double getRandomDouble()
    {
        return getRandomDouble(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public byte[] getRandomByteArray(int length)
    {
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return bytes;
    }
    
    public Object getRandomObject(Object[] objects)
    {
    	return objects.length >= 1 ? objects[getRandomInt(objects.length - 1)] : null;
    }

    public String getRandomDigitStringDuplicateFree(int length)
    {
    	if (length >= 1 && length <= 10)
    	{
        	ArrayList<Integer> values = new ArrayList<Integer>();
        	String digits = "";
        	int nextInt = 0;
        	for (int i = 0; i < 10; i++)
        	{
        		values.add(i);
        	}
    		do
    		{
    			nextInt = getRandomInt(values.size() - 1);
    			digits += values.get(nextInt);
    			values.remove(nextInt);
    		} while (digits.length() != length);
    		return digits;
    	}
    	else
    	{
    		return "-1";
    	}
    }
     
    public void startSecureRandomSeeding()
    {
        seedTimer.scheduleAtFixedRate(getInstance(), 
        		                      SEED_REFRESH_START_MS, 
        		                      SEED_REFRESH_PERIOD_MS);
    }

    public void stopSecureRandomSeeding()
    {
        seedTimer.cancel();
    }

    public void run()
    {
        if (isValid)
        {
            secureRandom.setSeed(secureRandom.generateSeed(NUM_SEED_BYTES));
        }
    }
}
