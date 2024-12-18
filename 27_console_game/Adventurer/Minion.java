public class Minion extends Adventurer{
  public Minion(int hp){
    super("enemy", hp);
  }
  public int getSpecial(){
    return 0;
  }
  public void setSpecial(int n){
    System.out.println("dont need this");
  }
  public String getSpecialName(){
    return "Super attack";
  }
  public int getSpecialMax(){
    return 0;
  }
  public void attack(Adventurer other){
    other.applyDamage(25);
  }
  public void support(Adventurer other){
    System.out.println("dont need this");
  }

  //heall or buff self
  public void support(){
    System.out.println("dont need this");
  }

  //hurt or hinder the target adventurer, consume some special resource
  public void specialAttack(Adventurer other) {
    other.applyDamage(50);
  }
}
