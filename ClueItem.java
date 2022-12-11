/**
 * Represents the clue items
 * @authors Lesly Gonzalez
 */
public class ClueItem {
    String content;
    int number;

    public ClueItem(int number, String content){
        this.number = number;
        this.content = content;
    }

    public String toString(){
        return this.content;
    }

}