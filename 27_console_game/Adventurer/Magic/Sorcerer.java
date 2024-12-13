public class Sorcerer extends Adventurer{
  private int mana = 10;
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
  public abstract int getSpecialMax();

  /*
    all adventurers must have a way to attack enemies and
    support their allys
  */
  //hurt or hinder the target adventurer
  public abstract String attack(Adventurer other);

  //heall or buff the target adventurer
  public abstract String support(Adventurer other);

  //heall or buff self
  public abstract String support();

  //hurt or hinder the target adventurer, consume some special resource
  public abstract String specialAttack(Adventurer other);
}
