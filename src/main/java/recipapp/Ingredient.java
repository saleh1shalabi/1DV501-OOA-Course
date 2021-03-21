package recipapp;

/**
 * the Ingredinet class.
 */
public class Ingredient {
  private String name;
  private String unit;
  private double price;
  private String lable;

  /**
   * ingredient object.
   */
  public Ingredient(String name, String unit, double price, String lable) {
    this.name = name;
    this.unit = unit;
    this.price = price;
    this.lable = lable;
  }

  public String getName() {
    return name;
  }

  public String getLable() {
    return lable;
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
  
  public void editLable(String newLable) {
    lable = newLable;
  }

  public void editPrice(Double newPrice) {
    price = newPrice;
  }

  public void editUnit(String newUnit) {
    unit = newUnit;
  }

}
