//
//
// Player.java
// 2018 @auther piteredo
// This Program is MIT license.
//
//
import java.awt.Point;


public class Player {

   private Point pos = new Point();

   public void setPosition(int x, int y){
      this.pos.setLocation(x, y);
   }

   public Point getPosition(){
      return this.pos;
   }
}
