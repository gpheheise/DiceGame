

/**
 * This is the dice class of the 2 player dice game. It runs the dice!
 * 
 *  @author Georg Philipp Erasmus Heise 
 *  @ SSID = 25912704 
 *  gphei2@student.monash.edu
 *  twitter = @gpheheise
 *  @version 1.0.3
 */
public class Dice
{
    
    private int faceValue;
    
    // Random contains the methode for generating "random" number below, hence the commented out commands are an alternative
    // private Random random = new Random();
  
    public Dice()
    {
        // initialise instance variables for the my Dice
  
        faceValue = 1;
    }
    public int getDice()
    {
        return faceValue;
    }
    public int rollDice()
    {
        // this method runs the dice by generating a random number 
        // between 0 and 1 and multiplying it by 5 and adding 1 to get an number between 1 and 6 
        // which a normal dice has
        
        // return faceValue = random.nextInt(6) + 1;
        return faceValue = (int)(Math.random()*6) + 1;
    }
    public void setDice(int value)
    {
        faceValue = value;

    }

}