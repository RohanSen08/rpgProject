public abstract class DungeonBoss{

  private String name;

  private int gold;

  public DungeonBoss(String name){
    this.gold = 0;
  }

  public String getName(){
    return name;
  }

  public int getGold(){
      return gold;
  }

}
