public class Sorcerer extends Adventurer{
  private int mana = 10;
  private int manaMax = 100;
  public Sorcerer(String name){
      super(name, 10);
  }

  public Sorcerer(String name, int hp){
      super(name, hp);
  }

  //give it a short name (fewer than 13 characters)
  public String getSpecialName(){
    return "Staff of Doom";
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
  public String attack(Adventurer other){
    other.setSpecial(other.applyDamage(15));
  }

  //heall or buff the target adventurer
  public String support(Adventurer other){
    other.setHP(Math.min(super.getHP()+15, other.getmaxHP()));
    other.setSpecial(Math.min(super.getSpecial()+15, other.getSpecialMax()));
  }

  //heall or buff self
  public String support(){
    if (mana >= 10){
      super.setHP(Math.min(super.getHP()+15, super.getmaxHP()));
      mana -= 10;
    } else {
      System.out.println("NOT ENOUGH MANA");
    }
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    if (mana > 25){
      other.setSpecial(other.applyDamage(50));
      mana -= 25;
    } else {
      System.out.println("NOT ENOUGH MANA");
    }
  }
}
