package learn;

import java.util.Arrays;

public class P36Try {
    public boolean isValidSudoku(char[][] board) {
        int row=0;
        int column=0;
        for(row=0;row<9;row++){
            boolean count[]=new boolean[9];
            Arrays.fill(count,false);
            for(column=0;column<9;column++){
                int num = Character.getNumericValue(board[row][column]);
                if(num!=-1){
                    if(!count[num-1]){
                        count[num-1]=true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        for(column=0;column<9;column++){
            boolean count[]=new boolean[9];
            Arrays.fill(count,false);
            for(row=0;row<9;row++){
                int num = Character.getNumericValue(board[row][column]);
                if(num!=-1){
                    if(!count[num-1]){
                        count[num-1]=true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        int[] r={0,1,2};
        int[] c={0,1,2};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boolean count[]=new boolean[9];
                Arrays.fill(count,false);
                for(int x=0;x<3;x++){
                    for(int y=0;y<3;y++){
                        int num = Character.getNumericValue(board[3 * i + x][3 * j + y]);
                        if(num!=-1){
                            if(!count[num-1]){
                                count[num-1]=true;
                            }
                            else{
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        P36Try p36Try=new P36Try();
        boolean validSudoku = p36Try.isValidSudoku(board);
        System.out.println(validSudoku);
    }
}
