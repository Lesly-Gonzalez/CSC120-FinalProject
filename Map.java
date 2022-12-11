/**
 * Represents the map
 * @authors Lesly Gonzalez
 */
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

    Container box;
    Container cabinet;
    
    /**
     * constructor
     */
    public Map(){
        this.topLeft = new Room(-1, 1, "\n   OH WOW! This area is filled with butterflies! I feel bad for them. It must be sad to be traped in this house :( \n   There is a small window, but it seems like it's sealed. I don't think you can open it. \n   But that glass looks fragile.");
        this.top = new Room(0, 1, "\n   Beautiful light comes through a skylight and it touches the framed paintings that hang high on the wall. \n   Among those paintings there is a portrait of Leonhard Euler. \n   There is something a little strange about it, but it's hard to see from where you are.");
        this.topRight = new Room(1, 1,"\n   There is a closet here. It seem like you need a key to open it...");
        this.left = new Room(-1, 0, "\n   Books locked in a shelf, a mirror on the wall, \n   and a lamp with a hot light bulb sitting on a title table reside in this area.");
        this.middle = new Room(0, 0, "\n   Back to the original place");
        this.right = new Room(1,0,"\n   There is a quite strong smell of lemon in this area. \n   There is a desk in a corner with an yellow piece of paper, some brushes, and ink in a cup. \n   The brushed are wet with a transparent liquid, and so is the piece of paper. \n   The only legible thing in it is a signature: Werner Buchholz, June 1956. \n   This seems suspicious.");
        this.bottomLeft = new Room(-1, -1, "\n   This section has nice light green walls. \n   There is a photograph of Grace Hooper on the wall, and a cabinet next to it.");
        this.bottom = new Room(0, -1, "\n   This is an interesting room. There is a jar with dry flowers, \n   a spider web on the corner, and a tiny box on a table right in front of you.");
        this.bottomRight = new Room(1, -1, "\n   There is a door that is locked. It seems like a three-digit password is required to open this door. ");

        this.box = new Container("\n   There is an old, rusty key in the box.", "   The box is now empty.");
        this.cabinet = new Container("\n   Nothing but a hammer is what you have found in this cabinet.", "   The cabinet is now empty. \n   I hope you used that hammer wisely. ");
    }

    /**
     * Determines which room's description to print when the user enters a room
     * @param x {1,0,-1}
     * @param y {1,0,-1}
     */
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