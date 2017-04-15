package com.wechat.algorithm;

import java.util.*;

/**
 * Created by chengen.gu on 2017/4/3.
 */
public class HuiWenStr {

    public void huiWen(){
        Scanner  scanner = new Scanner(System.in);
        List<Integer> delIdxList = new ArrayList<>();
        Map<Character,Integer> indexMap = new HashMap<>();
        Integer longest = 0;
        Integer start = 0 ;
        Integer end = 0;
        String str = scanner.nextLine();

        for(int i = 0 ; i < str.length() ; i++ ){
            Character key = str.charAt(i);
            Integer value = indexMap.get(key);
            if(value != null){
                Integer x = i - value;
                if(longest < x){
                    if(end != 0)
                        delIdxList.add(end);
                    end = i;
                    start = value;
                    longest = end - start;
                }else{
                    if(i > start){
                        delIdxList.add(i);
                        indexMap.put(key,i);
                    }

                }
            }else{
                indexMap.put(key,i);
            }

        }

        String result = str.substring(start,end +1 );

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < result.length() ; i++ ){
            if(delIdxList.contains(i + start)){
                continue;
            }
            else{
                sb.append(result.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {

        char[] chars = new char[]{'A','a','b','D','e','A','d','E'};
        swtichChar(chars);
        System.out.println(chars);
    }

    public static void swtichChar(char[] chars){
        int end = chars.length -1 ;
        for(int i = chars.length -1 ; i >= 0 ; i--){
            if(isCap(chars[i])){
                for(int j = i ; j < end; j++){
                    cSwap(chars,j,j+1);

                }
                end--;
            }
        }
    }

    public static boolean isCap(char ch){
        if(ch >= 'A' && ch <= 'Z'){
            return true;
        }
        return false;
    }

    public static void cSwap(char[] ch,int x,int y){

       if(ch[x] != ch[y]){
           ch[y] = (char) ((int)ch[x] + (int)ch[y]);
           ch[x] = (char) ((int)ch[y] - (int)ch[x]);
           ch[y] = (char) ((int)ch[y] - (int)ch[x]);
       }
    }

   /* public static void cSwap(String str,int x,int y){
        Scanner  scanner = new Scanner(System.in);
        scanner.nextLine().toCharArray();
        str.toCharArray();
        if(str.charAt(x) != str.charAt(y)){




            str.charAt(y) = (char) ((int)str.charAt(x) + (int) str.charAt(y));
            str.charAt(x) = (char) ((int) str.charAt(y) - (int)str.charAt(x));
            str.charAt(y) = (char) ((int) str.charAt(y) - (int)str.charAt(x));
        }
    }*/

   public void code(String str){
       List<String> list = new ArrayList<>();
       StringBuffer sb = new StringBuffer();
       int index = 0;
       int start = 0;
       int end = 0;
       for(int i = 0 ; i <str.length() ; i++){
           if(i %16 == 0 ){

               start +=end;
               end +=16;
               sb = new StringBuffer();
               sb.append("000000" + index + "0").append(" ");
           }
           int x = str.charAt(i);
           String st = Integer.toHexString(x);
           sb.append(st).append(" ");
       }
   }
}
