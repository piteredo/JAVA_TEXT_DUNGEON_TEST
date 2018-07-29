//
//
// Main.java
// 2018 @auther piteredo
// This Program is MIT license.
//
//
import java.util.Scanner;
//import java.util.ArrayList;
import java.awt.Point;


class Main {

   private static final int playerPosX = 1;
   private static final int playerPosY = 1;
   private static final int treasurePosX = 3;
   private static final int treasurePosY = 3;
   private static Map map;
   private static Player player;
   private static Treasure treasure;
   private static Printer printer;

   public static void main(String[] args){
      initMap();
      initPlayer();
      initTreasure(); 
      initPrinter();

      updateScene("TITLE");
   }

   private static void initMap(){
      map = new Map();
      map.createMap();
   }

   private static void initPlayer(){
      player = new Player();
      player.setPosition(playerPosX, playerPosY);
      map.setPlayerExists(playerPosX, playerPosY, true);
   }

   private static void initTreasure(){
      treasure = new Treasure();
      treasure.setPosition(treasurePosX, treasurePosY);
      map.setTureasureExists(treasurePosX, treasurePosY, true);
   }

   private static void initPrinter(){
      printer = new Printer();
   }

   private static void updateScene(String label){
      switch(label){
         case "TITLE": titleScene(); break;
         case "MAIN": mainScene(); break;
         case "RESULT": resultScene(); break;
      }
   }

   private static void titleScene(){
      printer.println("\r\n\r\n宝探しゲーム\r\n\r\n");
      updateScene("MAIN");
   }

   private static void mainScene(){
      updateWorldPrint();
      Point nextPos = getNextPosition();
      if(nextPos.x < -1 || nextPos.y < -1) mainScene();
      else if(!checkNextPos(nextPos)) mainScene();
      else{
         playerMove(nextPos);
         if(!checkTreasureExists(nextPos)) mainScene();
         else updateScene("RESULT");
      }
   }

   private static void updateWorldPrint(){
      Point playerPos = player.getPosition();
      int[][] mapLayoutArr = map.getLayoutArr();
      printer.printWorld(mapLayoutArr, playerPos.x, playerPos.y);
   }

   private static Point getNextPosition(){
      Point playerPos = player.getPosition();
      Point direction = scanDirection();
      if(direction.x < -1 || direction.y < -1) return direction;
      else return calcNextPos(playerPos, direction);
   }

   private static Point scanDirection(){
      printer.print("上(W)・下(S)・左(A)・右(D) 選んで押して下さい：");
      Scanner scanner = new Scanner(System.in);
      String key = scanner.next();
      System.out.println("");

      return calcDirection(key);
   }

   private static Point calcDirection(String key){
      Point direction = new Point(-2, -2);
      if(!checkKey(key)) return direction;
      else{
         switch(key){
            case "W": direction.setLocation(0, -1); break;
            case "D": direction.setLocation(1, 0); break;
            case "S": direction.setLocation(0, 1); break;
            case "A": direction.setLocation(-1, 0); break;
         }
         return direction;
      }
   }

   private static Boolean checkKey(String key){
      if(!(key.equals("W")) && !(key.equals("D")) && !(key.equals("S")) && !(key.equals("A"))){
         printer.println("-------------------------");
         printer.println("無効な入力です");
         printer.println("");
         return false;
      }
      return true;
   }

   private static Point calcNextPos(Point oldPos, Point direction){
      int new_x = oldPos.x + direction.x;
      int new_y = oldPos.y + direction.y;
      return new Point(new_x, new_y);
   }

   private static Boolean checkNextPos(Point nextPos){
      if(map.getIsWall(nextPos.x, nextPos.y)){
         printer.println("-------------------------");
         printer.println("そっちは壁です");
         printer.println("");
         return false;
      }
      return true;
   }

   private static void playerMove(Point nextPos){
      Point playerPos = player.getPosition();
      map.setPlayerExists(playerPos.x, playerPos.y, false);
      player.setPosition(nextPos.x, nextPos.y);
      map.setPlayerExists(nextPos.x, nextPos.y, true);
   }

   private static Boolean checkTreasureExists(Point nextPos){
      if(!map.getTreasureExists(nextPos.x, nextPos.y)){
         printer.println("-------------------------");
         printer.println("宝箱はありませんでした");
         printer.println("");
         return false;
      }
      return true;
   }

   private static void resultScene(){
      String treasureName = treasure.getRandomName();
      printer.println("-------------------------");
      updateWorldPrint();
      printer.println("宝箱を見つけました、ゲームクリア！");
      printer.println("見つけた宝物は『" + treasureName + "』でした");
      printer.println("");
      printer.println("");
   }
}
