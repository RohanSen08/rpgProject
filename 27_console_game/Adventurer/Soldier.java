public class Soldier extends Adventurer{
  private int stamina = 50;
  private int staminaMax = 500;
  public Soldier(String name){
      super(name, 100);
  }

  public Soldier(String name, int hp){
      super(name, hp);
  }
  //give it a short name (fewer than 13 characters)
  public String getSpecialName(){
    return "Stamina";
  }
  //accessor methods
  public int getSpecial(){
      return stamina;
  }
  public void setSpecial(int n){
    stamina = n;
  }
  public int getSpecialMax(){
    return staminaMax;
  }

  /*
    all adventurers must have a way to attack enemies and
    support their allys
  */
  //hurt or hinder the target adventurer
  public void attack(Adventurer other){
    other.applyDamage(30);
  }

  //heall or buff the target adventurer
  public void support(Adventurer other){
    other.setHP(Math.min(super.getHP()+10, other.getmaxHP()));
    other.setSpecial(Math.min(getSpecial()+10, other.getSpecialMax()));
  }

  //heall or buff self
  public void support(){
    if (stamina >= 10){
      super.setHP(Math.min(super.getHP()+10, super.getmaxHP()));
      stamina -= 10;
    } else {
      System.out.println("NOT ENOUGH STAMINA");
    }
  }

  //hurt or hinder the target adventurer, consume some special resource
  public void specialAttack(Adventurer other){
    if (stamina > 25){
      other.applyDamage(60);
      super.setHP(Math.min(super.getHP()+10, super.getmaxHP()));
      stamina -= 25;
    } else {
      System.out.println("NOT ENOUGH STAMINA");
    }
  }
}
