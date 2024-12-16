public class Wizard extends Adventurer{
  private int mana = 50;
  private int manaMax = 500;
  public Wizard(String name){
      super(name, 10);
  }

  public Wizard(String name, int hp){
      super(name, hp);
  }
  public Wizard(Sorcerer sorcerer){
    super(sorcerer.getName(), sorcerer.getHP());
  }
  //give it a short name (fewer than 13 characters)
  public String getSpecialName(){
    return "Skibidi Staff";
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
    other.setSpecial(other.applyDamage(30));
  }

  //heall or buff the target adventurer
  public String support(Adventurer other){
    other.setHP(Math.min(super.getHP()+30, other.getmaxHP()));
    other.setSpecial(Math.min(super.getSpecial()+30, other.getSpecialMax()));
  }

  //heall or buff self
  public String support(){
    if (mana >= 10){
      super.setHP(Math.min(super.getHP()+30, super.getmaxHP()));
      mana -= 10;
    } else {
      System.out.println("NOT ENOUGH MANA");
    }
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    if (mana > 25){
      other.setSpecial(other.applyDamage(75));
      super.setHP(Math.min(super.getHP()+10, super.getmaxHP()));
      mana -= 25;
    } else {
      System.out.println("NOT ENOUGH MANA");
    }
  }
}
