import java.util.Scanner;

public class Game {
  public static boolean isGood(int x, int y){
    if (x<25&&x>=0){
      if (y<45&&y>=0){
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args){
    int x = 12;
    int y = 22;
    // 0 up 1 right 2 down 3 left
    Scanner scan = new Scanner(System.in);
    while (true){
      int dir = scan.nextInt();
      if (dir == 0){
        if (isGood(x, y+1)){
          y++;
        }
        System.out.println(x + ", " + y);
      }
      if (dir == 1){
        if (isGood(x+1, y)){
          x++;
        }
        System.out.println(x + ", " + y);
      }
      if (dir == 2){
        if (isGood(x, y-1)){
          y--;
        }
        System.out.println(x + ", " + y);
      }
      if (dir == 3){
        if (isGood(x-1, y)){
          x--;
        }
        System.out.println(x + ", " + y);
      }
    }
  }
}
