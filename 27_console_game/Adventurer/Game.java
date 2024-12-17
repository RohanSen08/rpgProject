import java.time.chrono.MinguoChronology;
import java.util.Scanner;

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
    for (int i = 0; i < 6; i ++){
      int x = (int)(Math.random() * 37 + 6);
      int y = (int)(Math.random() * 17 + 6);
      boolean hit = false;
      if (Math.random() > 0.5){
        for (int ii = x; ii < 45; ii ++ ){
          if (map[y][ii] == "█" && ii != x){
            hit = true;
          }
          if (!hit){
            map[y][ii] = "█";
          }
          if (ii == 45 - x || ii == 45 - (45 - x)){
            map[y][ii] = " ";
          }
        }
      }
      else{
        for (int ii = x; ii > 0; ii -- ){
          if (map[y][ii] == "█" && ii != x){
            hit = true;
          }
          if (!hit){
            map[y][ii] = "█";
          }
          if (ii == 45 - x || ii == 45 - (45 - x)){
            map[y][ii] = " ";
          }
        }
      }
      hit = false;
      if (Math.random() > 0.5){
        for (int ii = y; ii < 25; ii ++ ){
          if (map[y][ii] == "█" && ii != y){
            hit = true;
          }
          if (!hit){
            map[ii][y] = "█";
          }
          
          if (ii == 25 - y || ii == 25 - (25 - y)){
            map[ii][y] = " ";
          }
        }
      }
      else{
        for (int ii = y; ii > 0; ii -- ){
          if (map[y][ii] == "█" && ii != y){
            hit = true;
          }
          if (!hit){
            map[ii][y] = "█";
          }
          if (ii == 25 - y || ii == 25 - (25 - y)){
            map[ii][y] = " ";
          }
        }
      }
    }

    Minion[] enemies = new Minion[7];
    int[][] enemycoords = new int[7][2];
    for (int i = 0; i < 7; i ++){
      enemies[i] = new Minion((int)(Math.random() * 10));
      int[] x = {(int)(Math.random() * 20 + 2), (int)(Math.random() * 40 + 2)};
      enemycoords[i] = x;
    }

    for (int i = 0; i < enemies.length; i ++){
      map[enemycoords[i][0]][enemycoords[i][1]] = "O";
    }
    map[23][43] = "W";
    printMap(map);

    Scanner playerInput = new Scanner(System.in);
    System.out.println("Welcome Wizard. ENTER A NAME:");
    Sorcerer player = new Sorcerer(playerInput.nextLine());
    int[] coordinates = {1, 1};
    map[1][1] = "@";
    printMap(map);
    
    boolean win = false;
    int kills = 0;
    while(!win){
      map[23][43] = "W";
      coordinates = move(map, playerInput, coordinates);
      map[coordinates[0]][coordinates[1]] = "@";
      printMap(map);
      if (coordinates[0] == 23 && coordinates[1] == 43){
        if (kills >= 2){
          win = true;
        }
        else{
          System.out.println("YOU NEED " + (2 - kills) + " MORE KILLS");
        }
      }

      for (int i = 0; i < enemies.length; i ++){
        int[] bs = {100, 100};
        if (coordinates[0] == enemycoords[i][0] && coordinates[1] == enemycoords[i][1]){
          enemycoords[i] = bs;
          System.out.println("FIGHT!!");
          System.out.println("YOU WON!!");
          kills ++;
        }
      }
    }

    System.out.println("YOU WIN");
    
  }

  public static int[] move(String[][] map, Scanner playerInput, int[] coords){
    System.out.println("Please input 1, 2, 3, or 4 to move up, down, left, or right");
    String d = playerInput.nextLine();
    switch (d) {
      case "3":
          if (map[coords[0]][coords[1] - 1] != "█"){
            map[coords[0]][coords[1]] = " ";
            int[] returnn = {coords[0], coords[1] - 1};
            return returnn;
          }
          
        break;
      case "4":
          if (map[coords[0]][coords[1] + 1] != "█"){
            map[coords[0]][coords[1]] = " ";
            int[] returnn = {coords[0], coords[1] + 1};
            return returnn;
          }
        break;
      case "2":
          if (map[coords[0] + 1][coords[1]] != "█"){
            map[coords[0]][coords[1]] = " ";
            int[] returnn = {coords[0] + 1, coords[1]};
            return returnn;
          }
        break;
      case "1":
          if (map[coords[0] - 1][coords[1]] != "█"){
            map[coords[0]][coords[1]] = " ";
            int[] returnn = {coords[0] - 1, coords[1]};
            return returnn;
          }
        break;
    }
    return coords;
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
