package org.wenzhuo4657;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class main {

    public static void main(String[] args) {
//        HashMap map = new HashMap();
//
//        map.put("1","1");
        ReentrantLock lock = new ReentrantLock();
        lock.tryLock();
        lock.lock();

        List list = new ArrayList();
        list.add("fjlakfja");
        main1( list);


    }

    public static void main1(List<Integer> list) {
        list.add(1);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println(list.get(0));

    }
}


class test{
    public void maxW(){
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        String[] str=s.split(" ");
        int n=Integer.valueOf(str[0]);
        int k=Integer.valueOf(str[1]);

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int maxW=0;
        HashSet set=new HashSet();
        for(int i=0;i<n;i++){
            if (set.add(arr[i])){
                maxW+=arr[i];
            }else {
                set.clear();
            }

        }

        System.out.println(maxW);

    }
}
