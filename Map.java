//
//
// Map.java
// 2018 @auther piteredo
// This Program is MIT license.
//
//
import java.util.ArrayList;


public class Map {

   private final int mapLength = 8; // layoutと揃える、縦横同数
   private MapChip[][] mapArr;
   private final int[][] layoutArr = {
      {1,1,1,1,1,1,1,1},
      {1,0,0,0,0,0,1,1},
      {1,0,1,1,1,0,0,1},
      {1,0,1,0,1,0,1,1},
      {1,0,1,0,0,0,1,1},
      {1,0,0,1,0,0,0,1},
      {1,0,1,0,0,0,1,1},
      {1,1,1,1,1,1,1,1},
   };

   public void createMap(){
      this.mapArr = new MapChip[this.mapLength][this.mapLength];
      for(int y=0; y<mapLength; y++){
         for(int x=0; x<mapLength; x++){
            MapChip mapChip = new MapChip();
            mapChip.setPosition(x, y);
            mapChip.setType(layoutArr[y][x]);
            mapArr[y][x] = mapChip;
         }
      }
   }

   public int[][] getLayoutArr(){
      return this.layoutArr;
   }

   public Boolean getIsWall(int x, int y){
      return this.mapArr[y][x].getIsWall();
   }

   public Boolean getPlayerExists(int x, int y){
      return this.mapArr[y][x].getPlayerExists();
   }

   public Boolean getTreasureExists(int x, int y){
      return this.mapArr[y][x].getTreasureExists();
   }

   public void setPlayerExists(int x, int y, Boolean boo){
      this.mapArr[y][x].setPlayerExists(boo);
   }

   public void setTureasureExists(int x, int y, Boolean boo){
      this.mapArr[y][x].setTureasureExists(boo);
   }
}
