package recipapp;

public class Ingredient {
  private String name;
  private String unit;
  private double price;

  /**
   * Creates the tiles.
   */
  public Ingredient(String name, String unit, double price) {
    this.name = name;
    this.unit = unit;
    this.price = price;
  }

  /**
   * Creates the tiles.
   */
  public String getName() {
    return name;
  }

  /**
   * Creates the tiles.
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Creates the tiles.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Creates the tiles.
   */
  public void editName(String newName) {
    name = newName;
  }

  /**
   * Creates the tiles.
   */
  public void editPrice(Double newPrice) {
    price = newPrice;
  }

  /**
   * Creates the tiles.
   */
  public void editUnit(String newUnit) {
    unit = newUnit;
  }

}
