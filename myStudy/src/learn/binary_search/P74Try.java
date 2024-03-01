package learn.binary_search;

public class P74Try {

    public boolean searchMatrix(int[][] matrix, int target) {
        int l=matrix.length;
        int c=matrix[0].length;
        int lenght=l*c;
        int left=0,right=lenght-1;
        while(left<right){
            int mid=(left+right)/2;
            int l2=mid/c;
            int c2=mid%c;
            if (matrix[l2][c2]==target){
                return true;
            }else{
                if(matrix[l2][c2]<target){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
//            System.out.println(String.format("left:%d right:%d",left,right));
        }
        return matrix[left/c][left%c]==target;
    }

    public static void main(String[] args) {
        P74Try p74Try=new P74Try();
        int[][] matrix=new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=15;
        System.out.println(p74Try.searchMatrix(matrix,target));
    }
}
