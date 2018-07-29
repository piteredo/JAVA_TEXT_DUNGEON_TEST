//
//
// MapChip.java
// 2018 @auther piteredo
// This Program is MIT license.
//
//
import java.awt.Point;


public class MapChip {

   private Boolean isWall;
   private Boolean playerExists = false;
   private Boolean treasureExists = false;
   private Point pos = new Point();

   public void setPosition(int x, int y){
      this.pos.setLocation(x, y);
   }

   public void setType(int type){
      //@type 0:Floor 1:Wall
      this.isWall = type == 0 ? false : true;
   }

   public Boolean getIsWall(){
      return this.isWall;
   }

   public Boolean getPlayerExists(){
      return this.playerExists;
   }

   public Boolean getTreasureExists(){
      return this.treasureExists;
   }

   public void setPlayerExists(Boolean boo){
      this.playerExists = boo;
   }

   public void setTureasureExists(Boolean boo){
      this.treasureExists = boo;
   }
}
