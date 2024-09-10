package monopoly;

/**
 * Represents a player and offers human interaction via ConsoleUi.
 */
public class HumanPlayer implements Player {
  private Tile currentTile;
  private String name;
  private int funds;
  private ConsoleUi ui = null;
 
  /**
   * Creates a new player and sets it on a tile.
   */
  public HumanPlayer(Tile currentTile, String name, ConsoleUi ui) {
    this.name = name;
    this.ui = ui;
    this.currentTile = currentTile;
    currentTile.stoppedOn(this);
    funds = 500;
  }

  /**
   * Returns the funds of the player.
   */
  public int getFunds() {
    return funds;
  }

  /**
   * Returns the name of the player.
   */
  public String getName() {
    return name;
  }

  /**
   * Moves the player forward a number of steps and visits the tiles the player pass and stop on.
   * The tile the player stops on is reported as visited when the player moves forward.
   */
  private void move(int steps) {
    currentTile.startOn(this);

    for (int i = 0; i < steps; i++) {
      currentTile.visit(this);
      currentTile = currentTile.getNext();  
    }
    currentTile.stoppedOn(this);
  }

  /**
   * Returns true of the player is currently positioned on a specific Tile.
   */
  public boolean isOnTile(Tile t) {
    return t == currentTile;
  }

  /**
   * Handles the interaction when it is the players turn to perform some actions.
   */
  public boolean yourTurn(Dice d1, Dice d2) {
    
    ConsoleUi.Action a = this.ui.promptForAction(getName());
    switch (a) {
      case ROLL:
        // created a method insted of writen the whole process here
        roll(d1, d2);
        break;
      case BUY:
        buyCurrentTile();
        break;
      default:
        break;
    }  
    return a == ConsoleUi.Action.ROLL;
  }
  
  // changed to protected to get access to from computer player class
  protected void buyCurrentTile() {

    if (currentTile.buy(this)) {
      ui.playerBuysProperty(getName(), currentTile.toString());
    }
  }

  /**
   * Call to make the player pay rent for a specific property.
   */
  public int payRent(int amount) {
    if (funds < amount) {
      amount = funds;
    }
    funds -= amount;
    ui.playerPaysRentFor(getName(), currentTile.toString(), amount);

    return amount;
  }

  /**
   * Call to deduce funds from the player. For example when buying a property.
   */
  public boolean deduceFunds(int cost) {
    if (funds > cost) { // we do not allow funds to go to 0, 0 = bankrupt
      funds -= cost;
      ui.playerFundsDeduced(getName(), cost);

      return true;
    } else {
      ui.playerUnableToPay(getName(), cost);

      return false;
    }
  }

  /**
   * Call to add funds to a player for example when passing the start tile.
   */
  public void addFunds(int amount) {
    funds += amount;
    ui.playerReceivedFunds(getName(), amount);
  }

  /**
   * Called when case ROLL.
   */
  public boolean roll(Dice d1, Dice d2) {
    d1.roll();
    d2.roll();
    final int steps1 = d1.getValue();
    final int steps2 = d2.getValue();
    ui.playerMoves(getName(), steps1, steps2);
    move(steps1 + steps2);
    return true;
  }

  /**
   * Called from the ComputerPlayer to updating the Tile PC is on.
   */
  public String update() {
    return currentTile.toString(); 
  }
}
