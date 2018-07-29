//
//
// Printer.java
// 2018 @auther piteredo
// This Program is MIT license.
//
//
public class Printer {

   private final String playerImg = "め";
   private final String floorImg = "　";
   private final String wallImg = "■";

   public void println(String text){
      System.out.println(text);
   }

   public void print(String text){
      System.out.print(text);
   }

   public void printWorld(int[][] mapLayoutArr, int playerPosX, int playerPosY){
      for(int y=0; y<mapLayoutArr.length; y++){
         for(int x=0; x<mapLayoutArr.length; x++){
            String img = "";
            if(x == playerPosX && y == playerPosY) img = playerImg;
            else img = mapLayoutArr[y][x] == 0 ? floorImg : wallImg;
            System.out.print(img);
         }
         System.out.println();
      }
   }
}
