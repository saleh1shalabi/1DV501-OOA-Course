package recipapp;

/**
 * the Ingredinet class.
 */
public class Ingredient {
  private String name;
  private String unit;
  private int price;
  private String label;

  /**
   * ingredient object.
   */
  public Ingredient(String name, String unit, int price, String label) {
    this.name = name;
    this.unit = unit;
    this.price = price;
    this.label = label;
  }

  public String getName() {
    return name;
  }

  public String getLabel() {
    return label;
  }

  public String getUnit() {
    return unit;
  }

  public int getPrice() {
    return price;
  }

  public void editName(String newName) {
    name = newName;
  }
  
  public void editLabel(String newLabel) {
    label = newLabel;
  }

  public void editPrice(int newPrice) {
    price = newPrice;
  }

  public void editUnit(String newUnit) {
    unit = newUnit;
  }

}
