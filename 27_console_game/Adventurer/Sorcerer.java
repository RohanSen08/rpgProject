public class Sorcerer extends Adventurer{
  private int mana = 10;
  private int manaMax = 100;
  public Sorcerer(String name){
      super(name, 150);
  }

  public Sorcerer(String name, int hp){
      super(name, hp);
  }

  //give it a short name (fewer than 13 characters)
  public String getSpecialName(){
    return "Mana";
  }
  //accessor methods
  public int getSpecial(){
      return mana;
  }
  public void setSpecial(int n){
    mana = n;
  }
  public int getSpecialMax(){
    return manaMax;
  }

  /*
    all adventurers must have a way to attack enemies and
    support their allys
  */
  //hurt or hinder the target adventurer
  public void attack(Adventurer other){
    other.applyDamage(15);
  }

  //heall or buff the target adventurer
  public void support(Adventurer other){
    other.setHP(Math.min(super.getHP()+30, other.getmaxHP()));
    other.setSpecial(Math.min(getSpecial()+30, other.getSpecialMax()));
  }

  //heall or buff self
  public void support(){
    if (mana >= 10){
      super.setHP(Math.min(super.getHP()+30, super.getmaxHP()));
      mana -= 10;
    } else {
      System.out.println("NOT ENOUGH MANA");
    }
  }

  //hurt or hinder the target adventurer, consume some special resource
  public void specialAttack(Adventurer other){
    if (mana > 25){
      other.applyDamage(50);
      mana -= 25;
    } else {
      System.out.println("NOT ENOUGH MANA");
    }
  }
}
