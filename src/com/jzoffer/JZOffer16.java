package com.jzoffer;

public class JZOffer16 {

    public double myPow(double x, int n) {
        if(x==0 || n==0) return 0;
        if(n==1) return x;
        if(n>0){
            double ans = getUndesignedpower(x, n);
            return ans;
        }else{
            double ans = getUndesignedpower(x, -(long)(n));
            return 1/ans;
        }
    }

    private double getUndesignedpower(double x, long n){
        double res = 1;
        while(n > 0){
            if((n&1)==1){       //奇数
                res *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        double ans = new JZOffer16().myPow(2, -2147483648);  //
        System.out.println(ans);


    }



}
