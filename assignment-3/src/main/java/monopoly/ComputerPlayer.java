package monopoly;

import java.util.Random;

/**
 * Represents a pc Player.
 */
public class ComputerPlayer extends HumanPlayer {
  private int checker; 
  Random rnd = new Random();
  private ConsoleUi ui;

  /**
  * Super implementation.
  */
  public ComputerPlayer(Tile currentTile, String name, ConsoleUi ui) {
    super(currentTile, name, ui);
    this.ui = ui;
  }
  
  /**
   * Checks what the pc chooses to play.
   */
  private int computerChoose() {
    //  randomly player to buy or roll for PC player
    String tt = super.update();
    int x = rnd.nextInt(2);
    // if the random gets 0 then it's roll
    if (x == 0) {
      checker = x;
      return 0;
    } else {
      // if its the Start tile or a Free Tile 
      // or if the computer alrady bought now 
      // then it have to roll and it can't buy
      if (tt.equals("Start") || tt.equals("Free") || checker == 1) {
        checker = 0;
        return 0;
      } else {
        // the checker will be 1 if it choose to buy
        checker = x;
        return 1;
      }
    }  
  } 
  
  @Override
  public boolean yourTurn(Dice d1, Dice d2) {
    ui.promptForPcAction(getName()); // only to be able to see what happning
    int a = computerChoose();
    switch (a) {
      case 0:
        roll(d1, d2);
        break;
      case 1:
        buyCurrentTile();
        break;
      default:
        break;
    }  
    return a == 0;
  }
}

