package Round595;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class typeB {
	public static void main(String[] args) {
		FastReader s = new FastReader();
		int T = s.nextInt();
		for(int t=0;t<T;t++) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
			}
			HashSet<Integer> set = new HashSet<>();
			boolean[] visited = new boolean[n];
			int[] cycle = new int[n];
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					if(arr[i]==(i+1)) {
						cycle[i]=1;
					}
					else {
						set.add(arr[i]-1);
//						visited[i]=true;
						int j = arr[i]-1;
						while(!visited[j] && arr[j]!=(i+1)) {
							set.add(arr[j]-1);
							visited[j]=true;
							j = arr[j]-1;
						}
						set.add(arr[j]-1);
						visited[j]=true;
						for(int k : set) {
							cycle[k]=set.size();
						}
						set.clear();
					}
				}
				
					
			}
			for(int i=0;i<n;i++) {
				System.out.print(cycle[i]+" ");
			}
			System.out.println();
		}
	}
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

}