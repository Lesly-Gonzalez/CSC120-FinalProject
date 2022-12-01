public class Map {
    Room topLeft;
    Room top;
    Room topRight;
    Room left;
    Room middle;
    Room right;
    Room bottomLeft;
    Room bottom;
    Room bottomRight;

    public Map(){
        this.topLeft = new Room(-1, 1, "-- There is a door that is locked. It seems like a three-digit password is required to open this door. ");
        this.top = new Room(0, 1, "-- There is a drawer");
        this.topRight = new Room(1, 1,"-- There is a refrigerator");
        this.left = new Room(-1, 0, "-- There is a stove. You know that it's not a cooking game right?");
        this.middle = new Room(0, 0, "-- Back to the original place ♪");
        this.right = new Room(1,0,"-- There");
        this.bottomLeft = new Room(-1, -1, "torch");
        this.bottom = new Room(0, -1, "couch");
        this.bottomRight = new Room(1, -1, "mouse");//TODO 记得重新写
    }

    public void enter(int x, int y){
        switch(y){
            case(1):
                switch(x){
                    case(-1):
                        this.topLeft.enter();
                        break;
                    case(0):
                        this.top.enter();
                        break;
                    case(1):
                        this.topRight.enter();
                        break;
                }
            break;
            case(0):
                switch(x){
                    case(-1):
                        this.left.enter();
                        break;
                    case(0):
                        this.middle.enter();
                        break;
                    case(1):
                        this.right.enter();
                        break;
                }
            break;
            case(-1):
                switch(x){
                    case(-1):
                        this.bottomLeft.enter();
                        break;
                    case(0):
                        this.bottom.enter();
                        break;
                    case(1):
                        this.bottomRight.enter();
                        break;
                }
            break;
        }
    }
}
