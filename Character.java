import java.util.ArrayList;
/**
 * Represents a character
 * @author Lesly Gonzalez
 */
public class Character {
    ArrayList <String> currentItem;
    Boolean item1;
    Boolean item2;
    Boolean item3;
    int x;
    int y;
    Map map;

    /**
     * Constructor
     */
    public Character(){
        this.currentItem = new ArrayList<String>();
        this.item1 = false;
        this.item2 = false;
        this.item3 = false;
        this.x = 0;
        this.y = 0;
        this.map = new Map();
    }

    /**
     * Allows the user to open the drawer/refrigerator when the character is in the correct room
     * Displays what's in the drawer/refrigerator.
     * @param item name of the container
     */
    public void open(String container){
        if(container.equals("box") && this.x == 0 && this.y == -1 ){
            this.map.box.print();
            this.map.box.open = true;
        }else if(container.equals("cabinet") && this.x == -1 && this.y == -1 ){
            this.map.cabinet.print();
            this.map.cabinet.open=true;
        }else{
            System.out.println("-- The wrong action, I'd say. ");
        }
    }

    /**
     * Allows the user to take the item when the character is in the correct room 
     * Will add the string into the currentItem array for further comparison
     * @param item name of the item
     */
    public void take(String item){
        if(this.map.box.open && item.equals("key") && this.x == 0 && this.y == -1 ){
            currentItem.add(item);
            this.map.box.open = true;
            System.out.println("\n   Now you have the key with you.");
        }else if(this.map.cabinet.open && item.equals("hammer") && this.x == -1 && this.y == -1 ){
            currentItem.add(item);
            this.map.cabinet.open = true;
            System.out.println("\n   NOW YOU HAVE THE MJOLNIR WITH YOU! \n   Oh, sorry, wrong game. \n   Now you have the hammer with you! .");
        }else if(item.equals("lamp") && this.x == -1 && this.y == 0 ){
            currentItem.add(item);
            this.map.left.change("\n   This room seems quite dark since you took that lamp. \n   I guess there is nothing else useful here. ");
            System.out.println("\n   Now you have the lamp with you.");
        }else{
            System.out.println("-- I guess it's not possible. ");
        }
    }

    /**
     * Allows the user to walk around the map
     * Will output "bumping wall" when the user is trying to walk beyond the map
     * @param direction north/south/west/east
     */
    public void walk(String direction){
        if (direction.equals("north")){
            if(this.y < 1){
                this.y = this.y +1;
            }else{
                System.out.println("-- You bumped the wall");
            }
        }else if(direction.equals("south")) {
            if(this.y > -1){
                this.y = this.y -1;
            }else{
                System.out.println("-- You bumped the wall");
            }

        }else if(direction.equals("west")) {
            if(this.x > -1){
                this.x = this.x -1;
            }else{
                System.out.println("-- You bumped the wall");
            }
        }else if(direction.equals("east")) {
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

    /**
     * Allows the user to use the item that is available in the current item list
     * Advances the "plot"
     * If the correct action is input, part of the password will be shown to the player.
     * Items can only be used once.
     * @param item name of the item
     */
    public void use(String item){
        if (this.currentItem.contains(item)){
            if (item.equals("hammer") && this.x == -1 && this.y == 1){
                System.out.println("\n   They're free!!! \n   Oh look! It seems like the butterflies were covering that piece of paper pinned on the wall.");
                this.map.bottomLeft.change("   The butterflies have been liberated. I see you left the piece of paper pinned on the wall.");
                this.item1 = true;
                this.currentItem.remove("hammer");

            }else if(item.equals("lamp") && this.x == 1 && this.y == 0){
                System.out.println("\n   The heat from the light bulb has made a message appear on the paper! What does it say?");
                this.item2 = true;
                this.currentItem.remove("lamp");
                this.map.right.change("\n   It stills smells like lemon, but you already found the clue in this room. \n   I hope you read it before you leave.");
           
            }else if(item.equals("key") && this.x == 1 && this.y == 1){
                System.out.println("\n   Now the closet is open. Here is some help: you have taken the ladder. \n   Is there a place where you think you might need it? ");
                this.currentItem.add("ladder");
                this.currentItem.remove("key");
                this.map.topRight.change("\n   The closed has been opened, and the ladder was left in the other room. \n   Nothing else to do here.");
            
            }else if(item.equals("ladder") && this.x == 0 && this.y == 1){
                System.out.println("\n   You have reached the odd looking portrait hanging on the wall. \n   Now you can see what was strange: the man in the portrait has only one eye. \n   There is a dusty piece of paper on the back of the frame with something written on it.");
                this.item3 = true;
                this.currentItem.remove("ladder");
                this.map.top.change("\n   You already found the clue in this room, remember? unless you forgot to read the piece of paper ");
           
            }else{
                System.out.println("   Right action but at the wrong place.");
            }
        
        }else if (item.equals("piece of paper")){
            System.out.println("   Nah. The paper is not important. What is important is the thing written on it. ");
        }else{
            System.out.println("   You don't have this item");
        }
    }

    /**
     * Allows the read the paper ball that has part of the password on it
     * Only available when the clues are solved
     * @param item paper ball
     */
    public void read(String item){
        if (item.equals("piece of paper") || item.equals("paper")){
            if (this.item1 && this.x == -1 && this.y == 1){
                System.out.println(">>> That was a noble quest. As a reward, here is the hint for the third digit of the escape code: \n   In programming we use the term _bug_ to refer to errors. \n   The digit is the string lenght of the name of the insect that caused \n   the term _bug_ to be used in programming.<<<");
            }else if(this.item2 && this.x == 1 && this.y == 0){
                System.out.println(">>> I see you are a smart individual. \n   Well, the second digit of the code to escape is the number of bits in a byte. \n   Good luck, Smithie.<<<");
            }else if(this.item3 && this.x == 0 && this.y == 1){
                System.out.println(">>> I sensed that you're a clever student when you were taken here. \n   The first code digit to escape is the number of platonic solids. \n   Good luck, Smithie. <<<");
            }else{
                System.out.println("   There is no such thing in this section of the room.");
            }
        }else{
            System.out.println("   You know that it is not something the read.");
        }
    }

    /**
     * Outputs possible commands that can be used in the game
     */
    public void help(){
        System.out.println("Possible commands:\n   walk ____\n   take _____\n   use ____\n   read _____\n   open _____");
    }

    
    public static void main(String[] args) {
        //Character character = new Character();
    }
}