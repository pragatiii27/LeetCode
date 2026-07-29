import java.math.BigInteger;

class Solution {

    BigInteger[] fact = new BigInteger[55];

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];

        for(char c : s.toCharArray())
            freq[c-'a']++;

        String mid = "";

        int[] half = new int[26];
        int len = 0;

        for(int i=0;i<26;i++){

            if(freq[i]%2==1)
                mid = ""+(char)('a'+i);

            half[i]=freq[i]/2;
            len+=half[i];
        }

        fact[0]=BigInteger.ONE;
        for(int i=1;i<=50;i++)
            fact[i]=fact[i-1].multiply(BigInteger.valueOf(i));

        BigInteger total=countWays(half,len);

        if(total.compareTo(BigInteger.valueOf(k))<0)
            return "";

        StringBuilder first=new StringBuilder();

        while(len>0){

            for(int c=0;c<26;c++){

                if(half[c]==0) continue;

                half[c]--;

                BigInteger ways=countWays(half,len-1);

                if(ways.compareTo(BigInteger.valueOf(k))>=0){

                    first.append((char)('a'+c));
                    len--;
                    break;

                }else{

                    k-=ways.intValue();
                    half[c]++;

                }
            }
        }

        String second=new StringBuilder(first).reverse().toString();

        return first.toString()+mid+second;
    }

    private BigInteger countWays(int[] half,int len){

        BigInteger ans=fact[len];

        for(int x:half)
            ans=ans.divide(fact[x]);

        return ans;
    }
}