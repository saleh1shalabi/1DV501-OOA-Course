package RecipApp;

public class Ingredient {
  private String name;
  private String unit;
  private double price;

  public Ingredient(String name, String unit, double price) {
    this.name = name;
    this.unit = unit;
    this.price = price;

  }

  public String getName() {
    return name;
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

  public void editPrice(int newPrice) {
    price = newPrice;
  }

  public void editUnit(String newUnit) {
    unit = newUnit;
  }

}
