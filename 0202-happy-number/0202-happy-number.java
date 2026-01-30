class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        int slow = n;
        int fast = generate(n);
        do{
            slow = generate(slow);
            fast = generate(generate(fast));
            if(fast == 1) return true;
        }while(slow != fast);
        return false;
    }
    public static int generate(int n){
        int val = 0;
        while(n > 0){
            val += (n % 10) * (n % 10);
            n /= 10;
        }
        return val;
    }
}