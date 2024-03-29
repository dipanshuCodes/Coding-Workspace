package Round579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class typeE {
	static class FastReader 
	
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 

	public static void main(String[] args) {
		FastReader s = new FastReader();
		int n = s.nextInt();
		int[] arr = new int[n];
		int[] fre = new int[150002];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
			fre[arr[i]]++;
			if(fre[arr[i]]>=3) {
				fre[arr[i]]=3;
			}
			
		}
		for(int i=150001;i>0;i--) {
			if(fre[i]==0) {
				continue;
			}
			if(fre[i]==3) {
				if(fre[i+1]==0) {
					fre[i+1]++;
					fre[i]--;
				}else if(fre[i+1]!=0) {
					fre[i]--;
				}
				if(fre[i-1]==0) {
					fre[i-1]++;
					fre[i]--;
				}else if(fre[i-1]!=0) {
					fre[i]--;
				}
			}
			if(fre[i]==2) {
				if(fre[i+1]==0) {
					fre[i+1]++;
					fre[i]--;
				}
				else if(fre[i-1]==0) {
					fre[i-1]++;
					fre[i]--;
				}else {
					fre[i]--;
				}
			}
			if(fre[i]==1) {
				if(fre[i+1]==0) {
					fre[i+1]++;
					fre[i]--;
				}
			}
		}
		long ans=0;
		for(int i=1;i<fre.length;i++) {
			if(fre[i]==1) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
