public class SelfAvoidingWalk {
    public static boolean oneWalk(int n) {
        boolean[][] grid = new boolean[n][n];

            int x = n/2; //center starting position
            int y = n/2;
           
            while(x >= 0 && x <n && y >=0 && y < n && grid[x][y] == false){//condition if path is out in bounds or hasnt run into itself
                grid[x][y] = true; 
               // pathLength++;
                double r = Math.random();
                if (r < .25){//up
                    y--; // remember: (0,0) starts top left, oposite traversing 
                }else if (r < .5) {//down
                    y++;
                }else if (r < .75) {//left
                    x--;
                }else{//right
                    x++;
                }
            }
            if (x < 0 || x >= n || y < 0 || y >= n){//case escape
                return true;
            }else{ //case dead end
                return false;
            }
    }

    public static void printPathLengths(int n, int nTrials) { 
        //print average length of paths 
        //(seperate dead and escape)
        //dead end probality
        int nDeads = 0;
        int sumEscapeLengths = 0;
        int sumDeadLengths = 0;

        for(int trials = 0; trials < nTrials; trials++){
            boolean[][] grid = new boolean[n][n];

            int x = n/2; //center starting position
            int y = n/2;
            int pathLength = 0;

            while(x >= 0 && x <n && y >=0 && y < n && grid[x][y] == false){//condition if path is out in bounds or hasnt run into itself
                grid[x][y] = true; 
                pathLength++;
                double r = Math.random();
                if (r < .25){//up
                    y--; // remember: (0,0) starts top left, oposite traversing 
                }else if (r < .5) {//down
                    y++;
                }else if (r < .75) {//left
                    x--;
                }else{//right
                    x++;
                }
            }
            if (x < 0 || x >= n || y < 0 || y >= n){//case escape
                sumEscapeLengths += pathLength;
            }else{ //case dead end
                nDeads++;
                sumDeadLengths += pathLength;
            }
        }
        System.out.println("dead end probability: " + (double)nDeads/nTrials + "\naverage length of escape paths: " + ((double)sumEscapeLengths/nTrials) + "\naverage length of dead-end paths: " + ((double)sumDeadLengths/nTrials));
    }

    public static void deadEndRectangleArea(int n, int nTrials) {
        //take ntrials and nside; return avg area of each path
        //find furthest right, left, up , and down values;;;keep track of coords
        int nDeads = 0;

        int x1 = n;
        int x2 = 0;
        int y1 = n;
        int y2 = 0;


        for(int trials = 0; trials < nTrials; trials++){
            boolean[][] grid = new boolean[n][n];

            int x = n/2; //center starting position
            int y = n/2;

            while(x >= 0 && x <n && y >=0 && y < n && grid[y][x] == false){//condition if path is out in bounds or hasnt run into itself
                grid[y][x] = true; 
                double r = Math.random();
                if (r < .25){//up
                    y--; // remember: (0,0) starts top left, oposite traversing 
                    if (y < y1){ //furthest up
                        y1 = y;
                    }
                }else if (r < .5) {//down
                    y++;
                    if (y > y2){//furthest down
                        y2 = y;
                    }
                }else if (r < .75) {//left
                    x--;
                    if (x < x1){//furthest left
                        x1 = x;
                    }
                }else{//right
                    x++;
                    if (x > x2){//furthest right
                        x2 = x;
                    }
                }
            }
            if (!(x < 0 || x >= n || y < 0 || y >= n)){
                nDeads++;
            }
        
        }
        
    }


    

    public static void main(String[] args) {
        int n = 5;
        int nTrials = 1000000;

        //printPathLengths(n, nTrials);
        deadEndRectangleArea(n, nTrials);
        
    }
}
