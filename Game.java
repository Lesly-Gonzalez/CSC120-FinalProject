import java.util.Scanner;
public class Game {
    ClueItem clueItem1;
    ClueItem clueItem2;
    ClueItem clueItem3;
    Character character;
    Boolean win;

    public Game(){
        this.character = new Character();
        this.clueItem1 = new ClueItem(1,"First digit: 7");
        this.clueItem1 = new ClueItem(2,"Second digit: 9");
        this.clueItem1 = new ClueItem(3,"Third digit: 3");
        this.win = false;

    }

    public void gameProcess(){
        Scanner scanner = new Scanner(System.in);  
        System.out.println("-- You open your eyes. You realize you are lying on the floor in the middle of a room.\n-- You have no idea where you are, but you know something: there is an essay due tomorrow,\n-- and you HAVE to get out of the room and submit the essay on time. ");
        while (win == false){
            System.out.println("-- What are you going to do?");
            String command = scanner.nextLine();
            correspond(command);
            
            /* 
            if(this.character.item1 && this.character.item2 && this.character.item3){ //TODO 这里是错的
                System.out.println("-- It seems like you have collected all of the clues. What is your final answer?");
                String answer = scanner.nextLine();
                while (answer != "793"){
                    System.out.println("-- Wrong answer! Please enter again.");
                    answer = scanner.nextLine();
                }
                System.out.println("-- Congratulations! You escaped the room and saved your grade!");
                win = true;
            
            }*/
        }
    }

    public void correspond(String command){
        command = command + " ";
        command = command.toLowerCase();
        String[] temp = command.split(" ",2);

        switch (temp[0]){
            case("walk"):
                this.character.walk(temp[1]); //TODO 1 whyyy 是不是只有这个东西是错的 好微妙
                break;
            case("open"):
                //TODO 这个功能还没实现 感觉差不多了
                break;
            case("take"):
                this.character.take(temp[1]);
                break;
            case("read"):
                this.character.read(temp[1]);
                break;
            case("use"):
                this.character.use(temp[1]);
                break;
            default:
                System.out.println("-- Invalid input! Please try again.");

        }

    }
    public static void main(String[] args) {
        Game game = new Game();
        game.gameProcess();
    }
}
