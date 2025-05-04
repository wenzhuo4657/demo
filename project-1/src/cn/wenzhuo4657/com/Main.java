package cn.wenzhuo4657.com;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Main {
	static BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	public static  void  main(String[] args) throws IOException {
		String s= re.readLine();

		int N=Integer.valueOf(s.split(" ")[0]);
		int M=Integer.valueOf(s.split(" ")[1]);
		String  L="";
		int [] b=new int[N];
		for(int i=1;i<=N;i++) {
			b[i-1]=i;
		}
		for(int i=0;i<M;i++) {
			String [] R_L=re.readLine().split(" ");
			if(R_L[0].equals("L")) {
				int c=Integer.valueOf(R_L[1]);
				for(int d=0;d<N;d++) {
					if(b[d]==c) {
						for(int h=d-1;h>=0;h--){
							b[h+1]=b[h];
						}
						b[0]=c;
						break;
					}
				}
			}else {
				int c=Integer.valueOf(R_L[1]);
				for(int d=0;d<N;d++) {
					if(b[d]==c) {
						for(int h=d;h<N-1;h++){
							b[h]=b[h+1];
						}
						b[N-1]=c;
						break;
					}
				}

			}
			for(int h=0;h<N;h++){
				System.out.print(b[i]+" ");
			}
		}


	}


}


