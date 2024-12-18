import java.time.chrono.MinguoChronology;
import java.util.Scanner;
import java.util.Random;

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
      enemies[i] = new Minion((int)(Math.random() * 100));
      int[] x = {(int)(Math.random() * 20 + 2), (int)(Math.random() * 40 + 2)};
      enemycoords[i] = x;
    }

    for (int i = 0; i < enemies.length; i ++){
      map[enemycoords[i][0]][enemycoords[i][1]] = "O";
    }
    map[23][43] = "W";
    printMap(map);

    Scanner playerInput = new Scanner(System.in);
    System.out.println("Wizard (0) or Soldier (1)?");
    Adventurer player = new Minion(1);
      if (playerInput.nextLine().equals("0")) {
        System.out.println("Welcome Wizard. ENTER A NAME:");
        player = new Sorcerer(playerInput.nextLine());
      } else if (playerInput.nextLine().equals("1")) {
        System.out.println("Welcome Soldier. ENTER A NAME:");

        player = new Soldier(playerInput.nextLine());
      }
    int[] coordinates = {1, 1};
    map[1][1] = "@";
    printMap(map);
    
    boolean win = false;
    int kills = 0;
    boolean dead = false;

    Random rand = new Random();
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
        int[] abcdefg = {100, 100};
        if (coordinates[0] == enemycoords[i][0] && coordinates[1] == enemycoords[i][1]){
          enemycoords[i] = abcdefg;
          System.out.println("FIGHT!!");
          Minion enemy = enemies[i];
          while (enemy.getHP()>0){
            if (rand.nextDouble() > 0.9){
              enemy.specialAttack(player);
            } else {
              enemy.attack(player);
            }
            if (player.getHP()<=0){
              dead = true;
              break;
            }
            System.out.println("Health: "+player.getHP()+" "+player.getSpecialName()+": "+player.getSpecial());
            System.out.println("Attack (0) SuperAttack (1) Heal (2)");
            boolean asdfajk = false;
              if (playerInput.nextLine().equals("0")) {

                player.attack(enemy);
                System.out.println("Enemy HP: "+enemy.getHP());
                asdfajk = true;
              } else if (playerInput.nextLine().equals("1")) {

                player.specialAttack(enemy);
                System.out.println("Enemy HP: "+enemy.getHP());
                System.out.println("Your "+player.getSpecialName()+ ": " +player.getSpecial());
                asdfajk = true;
              }
              else if (playerInput.nextLine().equals("1")) {

                player.support(player);
                System.out.println("Your HP: "+player.getHP());
                System.out.println("Your "+player.getSpecialName()+ ": " +player.getSpecial());
                asdfajk = true;
              }
            }
          kills ++;
          System.out.println("VICTORY!");
          player.support(player);
        }
        if (dead){
          break;
        }
      }
    }
    if (!dead ) {
      System.out.println("YOU WIN");
    } else {
      System.out.println("YOU LOST");
    }
    
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
