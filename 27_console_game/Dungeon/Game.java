public class Game{

  public static void main(String[] args){
    String[][] map = new String[25][45];
    for (int i = 0; i < map.length; i ++){
      if (i == 0 || i == map.length - 1){
        for (int ii = 0; ii < map[i].length; ii ++){
          map[i][ii] = "█";
        }
      }
      else{
        for (int ii = 0; ii < map[i].length; ii ++){
          map[i][ii] = " ";
        }
        map[i][map[i].length - 1] = "█";
        map[i][0] = "█";
      }
    }

    printMap(map);
  }

  public static void printMap(String[][] map){
    String returnn = "";
    for (int i = 0; i < map.length; i ++){
      for (int ii = 0; ii < map[i].length; ii++){
        returnn += map[i][ii];
      }
      returnn += "\n";
    }
    System.out.println(returnn);
  }
}
