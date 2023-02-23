public class SelfAvoidingWalk {

    public static boolean oneWalk(int n) {
        boolean[][] grid = new boolean[n][n];

            int x = n/2; //center starting position
            int y = n/2;
           
           // int pathLength = 0;

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
        int nEscapes = 0;
        int nDeads = 0;

        for(int trials = 0; trials < nTrials; trials++){
            if (oneWalk(n)){
                nEscapes++;
            }else{
                nDeads++;
            }
        }
        System.out.println("dead end probability: " + (double)nDeads/nTrials);
           
    }
    

    public static void main(String[] args) {
        int n = 5;
        int nTrials = 1000000;

        printPathLengths(n, nTrials);
    }
}
