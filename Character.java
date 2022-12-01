import java.util.ArrayList;

public class Character {
    ArrayList <String> currentItem;
    Boolean item1;
    Boolean item2;
    Boolean item3;
    int x;
    int y;
    Map map;

    public Character(){
        this.currentItem = new ArrayList<String>();
        this.item1 = false;
        this.item2 = false;
        this.item3 = false;
        this.x = 0;
        this.y = 0;
        this.map = new Map();

    }

    public void read(ClueItem clueItem){
        System.out.println(clueItem.toString());
    }

    public void take(String item){
        currentItem.add(item);
    }

    public void walk(String direction){
        if (direction == "north"){
            if(this.y < 1){
                this.y = this.y +1;
            }else{
                System.out.println("-- You bumped the wall");
            }
        }else if(direction == "south") {
            if(this.y > -1){
                this.y = this.y -1;
            }else{
                System.out.println("-- You bumped the wall");
            }

        }else if(direction == "west") {
            if(this.x > -1){
                this.x = this.x -1;
            }else{
                System.out.println("-- You bumped the wall");
            }
        }else if(direction == "east") {
            if(this.x < 1){
                this.x = this.x +1;
            }else{
                System.out.println("-- You bumped the wall");
            }
        }else{
            System.out.println("!- Invalid input! Please try again.");
        }

        this.map.enter(this.x, this.y);

    }


    //TODO每一次更改的时候对description进行更新？？？？？？感觉有点丑陋
    public void use(String item){
        if (this.currentItem.contains(item)){
            if (item == "cheese" && this.x == -1 && this.y == 1){
                System.out.println("-- The little mouse threw out a paper ball with something written on it.");
                this.item1 = true;
            }else if(item == "cup"  && this.x == -1 && this.y == 0){
                System.out.println("-- The dry ice sublimate. There is a paper ball left in the cup with something written on it. ");
                this.item2 = true;
            }else if(item == "match"  && this.x == -1 && this.y == -1){
                System.out.println("-- Now the torch is lit. It may be helpful, so you take one of the torches. ");
                this.currentItem.add("torch");
            }else if(item == "torch"  && this.x == 0 && this.y == -1){
                System.out.println("-- Now you can see what's under the couch. There is a paper ball with something written on it.");
                this.item3 = true;
            }else{
                System.out.println("-- What do you want to do with it here?");
            }
        }else if (item=="paper ball"){
            System.out.println("-- Nah. The paper ball is not important. What is important is the thing written on it. ");
        }else{
            System.out.println("-- You don't have this item");
        }
    }

    public void read(String item){
        if (item == "paper ball"){
            if (this.item1 && this.x == -1 && this.y == 1){
                System.out.println("First digit: 7");
            }else if(this.item2 && this.x == -1 && this.y == 0){
                System.out.println("Second digit: 9");
            }else if(this.item2 && this.x == 0 && this.y == -1){
                System.out.println("Third digit: 3");
            }else{
                System.out.println("There is no such thing in this section of the room.");
            }
        }else{
            System.out.println("-- You know that it is not something the read. ");
        }
    }

    
    public static void main(String[] args) {
        Character character = new Character();
        character.walk("north");
        character.walk("waht");
        character.walk("south");
    }
}
