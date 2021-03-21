package recipapp;

public class Ingredient {
  private String name;
  private String unit;
  private double price;
  private String label;

  /**
   * ingredient object.
   */
  public Ingredient(String name, String unit, double price, String label) {
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

  public double getPrice() {
    return price;
  }

  public void editName(String newName) {
    name = newName;
  }
  
  public void editLabel(String newLabel) {
    label = newLabel;
  }

  public void editPrice(Double newPrice) {
    price = newPrice;
  }

  public void editUnit(String newUnit) {
    unit = newUnit;
  }

}
