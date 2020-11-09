package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public int [] randomGenerate(int offset,int inset){//offset is always 1 for this question
        int[] ret = new int[inset+1];
        for(int x=0; x< inset+1; x++){
            ret[x]= (int) Math.random()*(((int)inset/10)+1);
        }
    }

    public static void main(String[] args) {
        boolean cont =true;
        while(cont) {
            Scanner s = new Scanner(System.in);
            System.out.println(" please give us an array of numbers over a range 1 to n+1 with a single missing number within it. \nsyntax: separated by spaces \n e.g. \"3 5 4 1\" ");
            String array = s.nextLine();
            String[] splits = array.split(" ");
            Integer[] split = new Integer[splits.length];
            for (int i = 0; i < splits.length; i++) {
                split[i] = Integer.parseInt(splits[i]);
            }
            int offset = (int) Collections.min(Arrays.asList(split));//for the question it wll always be one but for general range this will be more flexible.
            System.out.println(" echo array " + Arrays.toString(split));
            boolean[] buckets = new boolean[split.length + 1];//one larger as there will be a hole
            for (int x = 0; x < splits.length; x++) {
                buckets[split[x] - offset] = true;
            }//insert to buckets
            int y = 0;
            while (buckets[y]) {
                y++;
            }
            System.out.println(" missing number over the range is " + (y + offset));
            System.out.println(" Do you want to continue (y- yes or n- no)");
            String c = s.nextLine();
            if(c.equalsIgnoreCase("n"))cont=false;
            else if (!c.equalsIgnoreCase("y")) {
                throw new Error(" cannot understand input ");
            }//otherwise continue executing program
        }
    }
}