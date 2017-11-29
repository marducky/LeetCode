import java.util.LinkedList;
import java.util.Queue;

public class ReverseInteger {
    public static int reverse(int i){
        // TODO Auto-generated method stub
        boolean isNegative = false;
        if (i < 0) {
            isNegative = true;
            i = -i;
        }
        int r =0;
        int q = 1;
        int result = 0;
        while (true) {
            q = (i * 52429) >>> 19;//去尾1位，2<<(16+3)＝524288 52429/524288约为0.1
            r = i - ((q << 3) + (q << 1));//r=i-q*10,截出最后一位
            result = (result<<3)+(result<<1)+r;
            i=q;
            if(q==0)break;
        }
        if(isNegative) result = -result;
        return result;

    }
    public static int reverseTwo(int x) {
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        while(x!=0){
            count++;
            int r=x%10;
            q.add(r);
            x=(x-r)/10;
        }

        int nx = 0;
        for(int i=count;i>0;i--){
            int temp = q.poll();
            int j=i;
            int carry=1;
            while(j>1){
                carry=carry*10;
                j--;
            }
            nx = nx+temp*carry;
        }
        return nx;
    }
    public static void main(String[] args){
        System.out.println(reverse(-3211));
        System.out.println(reverseTwo(-3211));

    }
}
