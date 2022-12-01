import java.util.ArrayList;

public class Room {
    String description;
    ArrayList<Item> itemList;

    public Room(int x, int y, String description){
        this.description = description;
        this.itemList = new ArrayList<Item>();
    }

    public void enter(){
        System.out.println(this.description);
        //System.out.println(this.itemList);//TODO 这里也没写完
    }

}
