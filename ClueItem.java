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

//todo这个大概率是不需要了