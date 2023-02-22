public class SelfAvoidingWalk {

    public static void printPathLengths(int n, int nTrials) { 
        //print average length of paths 
        //(seperate dead and escape)
        //dead end probality
        boolean[][] grid = new boolean[n][n];
        int x = n/2; //center starting position
        int y = n/2;
        int nEscapes = 0;
        int nDeads = 0;

        for(int trials = 0; trials < nTrials; trials++){
            while(x >= 0 && x <n && y >=0 && y < n && grid[x][y] == false){//condition if path is out in bounds or hasnt run into itself
                grid[x][y] = true; 
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
                nEscapes++;
            }
            if (grid[x][y] == true){//case dead ends
                nDeads++;
            }
        }

        

        System.out.println();

    }

    public static void main(String[] args) {
        int n = 5;
        int nTrials = 1000;

        printPathLengths(n, nTrials);
    }
}
