//
//
// Treasure.java
// 2018 @auther piteredo
// This Program is MIT license.
//
//
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;


public class Treasure {

   private final List<String> treasureList = Arrays.asList("かんづめ", "こばん", "コーヒー豆");
   private Point pos = new Point();

   public void setPosition(int x, int y){
      this.pos.setLocation(x, y);
   }

   public Point getPosition(){
      return this.pos;
   }

   public String getRandomName(){
      Collections.shuffle(this.treasureList);
      return this.treasureList.get(0);
   }
}
