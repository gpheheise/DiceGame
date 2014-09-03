

/**
 * This is the Player class of the 2 player dice game. It sets player 1 and 2!
 * 
 *  @author Georg Philipp Erasmus Heise 
 *  @ SSID = 25912704 /
 *  gphei2@student.monash.edu
 *  twitter = @gpheheise
 *  @version 1.0.3
 */
public class Player
{
  private String name;
  private int position;
  /**
   * Get the player's name
   *
   * @return the name of the player
   */
  public String getName()
  {
     return this.name;
  }
    /**
   * Get the player's position.
   *
   * @return the position of the player.
   */
  public int getPosition()
  {
      return this.position;
  }
  /**
   * Construct a basic player object.
   */
  public Player()
    {//change to how 
        this("");
    }

  /**
   * Construct a player object with a specific name.
   *
   * @param name the name of the player.
   */
  public Player(String name)
    {
        this.name     = name;
        this.position = 0;
    }
  
  /**
   * Raise the player's position
   * @param number to raise the position
   */
  public void raisePosition(int count)
  {
      this.position += count;
  }
  /**
   * Set the player's name
   *
   * @param the name of the player
   */
  public void setName(String name)
  {
     this.name = name;
  }

  /**
   * Reduce the player's position 
   */
  public void penalize()
  {
     this.position -= 5;
  }



}
