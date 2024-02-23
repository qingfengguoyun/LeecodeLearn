package learn;

public class P134Try {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int reaminGas=gas[0];
        int tarCost=cost[0];
        int length=gas.length;
        int[] diff=new int[gas.length];
        for(int i=0;i<gas.length;i++){
            diff[i]=gas[i]-cost[i];
        }
        reaminGas=0;
        int start=0;
        int reach=0;
        while(start<gas.length){

            if(reaminGas>=0){
                reaminGas+=diff[reach%length];
                reach+=1;

            }else{
                reaminGas-=diff[start%length];
                start+=1;
            }
            if(reach-start==length&&reaminGas>=0){
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};
        P134Try p134Try=new P134Try();
        int i = p134Try.canCompleteCircuit(gas, cost);
        System.out.println(i);

    }
}
