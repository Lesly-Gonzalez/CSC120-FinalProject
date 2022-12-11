import java.util.Scanner;
/**
 * Represents the container
 * @authors Lesly Gonzalez
 */
public class Game {
    Character character;
    Boolean win;

    /**
     * constructor
     */
    public Game(){
        this.character = new Character();
        this.win = false;

    }

    /**
     * The game process
     * Will continue to ask for the player's input
     * If the player gathers the three-digit password, the system will determine whether the password is correct or not
     * If the password is correct, the game ends
     */
    public void gameProcess(){
        Scanner scanner = new Scanner(System.in);  
        System.out.println("-- You open your eyes. You realize you are lying on the floor in the middle of a room.\n-- You have no idea where you are, but you know something: \n-- you HAVE to get out of this building because you have an exam tomorrow. \n   \n-- You can walk using the cardinal points. ");
        while (win == false){
            System.out.println("   what are you going to do?    ");
            String command = scanner.nextLine();
            correspond(command);
            
            if(this.character.item1 && this.character.item2 && this.character.item3 && this.character.x == 1 && this.character.y == -1 ){
                System.out.println("-- It seems like you have collected all of the clues. What is your final answer?");
                String answer = scanner.nextLine();
                if(!answer.equals("584")){
                    System.out.println("-- Wrong answer! Go to the correct section of the house and check on the pieces of paper again..");
                }else{
                System.out.println("-- Congratulations! You escaped the house and saved your grade!");
                scanner.close();
                win = true;
                }
            
            }
        }
    }

    /**
     * calls specific methods based on the user's input
     * @param command user's input
     */
    public void correspond(String command){
        command = command + " ";
        command = command.toLowerCase();
        String[] temp = command.split(" ",2);

        switch (temp[0]){
            case("walk"):
                this.character.walk(temp[1].strip());
                break;
            case("open"):
                this.character.open(temp[1].strip());
                break;
            case("take"):
                this.character.take(temp[1].strip());
                break;
            case("read"):
                this.character.read(temp[1].strip());
                break;
            case("use"):
                this.character.use(temp[1].strip());
                break;
            case("help"):
                this.character.help();
                break;
            default:
                System.out.println("-- Invalid input! Please try again.");

        }

    }
}