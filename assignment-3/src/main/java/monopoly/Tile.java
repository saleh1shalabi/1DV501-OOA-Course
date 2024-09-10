package monopoly;

import java.util.ArrayList;

/**
 * Represents a double linked list of game tiles.
 */
public abstract class Tile {
  private Tile next;
  private Tile prev;

  // a tile knows what objects (players) are currently on the tile, these are
  // never used for anything else than comparing object references
  // thus we can store them at the highest level of abstraction - Object instances
  ArrayList<Object> playersOnTile;  

  protected Tile() {
    // TODO: set the prev and next references correctly
    // the next and prev links should point to the object created

    next = prev = this; // this is not correct remove

    playersOnTile = new ArrayList<>();
  }

  protected Tile(Tile prevTile) {
    // TODO: set the prev and next references correctly
    // the object created should be inserted into the linked list as the next tile after prevTile

    // (3) <- 1 <-> 2 <-> 3 -> (1)
    // (2) <- 1 <-> 3 <-> 2 -> (1)
      
    next = prevTile.next;
    prevTile.next = this;
    next.prev = this;
    prev = prevTile;

    




    

    playersOnTile = new ArrayList<>();
  }

  public Tile getNext() {
    return next;
  }

  public Tile getPrev() {
    return prev;
  }

  /**
  * Checks if a player is on the tile.
  */
  public boolean isOnTile(Player player) {
    return playersOnTile.contains(player);
  }

  /**
  * Called when a player moves over a tile.
  */
  public abstract void visit(Player player);

  /**
  * Called when a player stops on a tile.
  * Subclasses need to call super if overridden.
  */
  public void stoppedOn(Player player) {
    playersOnTile.add(player);
  }

  /**
  * Called when a player moves away from the tile stopped on.
  * Subclasses need to call super if overridden.
  */
  public void startOn(Player player) {
    playersOnTile.remove(player);
  }

  /**
  * Called when a player wants to buy a tile.
  */
  public abstract boolean buy(Player player);
}
