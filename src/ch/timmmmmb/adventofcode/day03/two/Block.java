package ch.timmmmmb.adventofcode.day03.two;

class Block {
    private int id,x,y,width,height;
    private boolean overlaps = true;
    Block(int id, int x, int y, int width, int height){
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void getIntersection(Block compare){
        if(intersects(compare.x,compare.y,compare.width,compare.height)){
            for(int i = 0; i<width;i++){
                for(int j = 0; j < height; j++) {
                    Point point = new Point(x + i, y + j);
                    if (compare.intersects(point.x,point.y,1,1)){
                        Main.positions[x + i][y + j] = true;
                        compare.overlaps = false;
                        overlaps = false;
                    }
                }
            }
        }
    }

    public String toString(){
        return "Block: "+x+":"+y+" "+width+"x"+height;
    }

    private boolean intersects(int x, int y, int width, int height){
        return this.x < x + width && this.x +this.width >x &&
                this.y < y+height && this.y +this.height > y;
    }

    public boolean isOverlaps() {
        return overlaps;
    }

    public int getId() {
        return id;
    }
}
