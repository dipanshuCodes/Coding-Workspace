package SegTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class segTreeUse {
	static class segTree{
		int size;
		long[] sums;
		void init(int n) {
			size = 1;
			while(size<n)
				size*=2;
			sums = new long[2*size - 1];
		}
		void build(int[] arr, int x, int lx, int rx) {
			if(rx-lx ==1) {
				if(lx<arr.length) {
					sums[x] = arr[lx];
				}
				return;
			}
			int m = (rx+lx)/2;
			build(arr, 2*x+1, lx, m);
			build(arr, 2*x+2, m, rx);
			sums[x] = sums[2*x+1] + sums[2*x+2];
			
		}
		void build(int[] arr) {
			build(arr, 0, 0, size);
		}
		void set(int in,int val, int x, int lx, int rx) {
			if(rx-lx==1) {
				sums[x]=val;
				return;
			}
			int m = (lx + rx)/2;
			if(in<m)
				set(in, val, 2*x+1,lx,m);
			else
				set(in, val, 2*x+2, m, rx);
			
			sums[x]=sums[2*x+1]+sums[2*x+2];			
			
		}
		void set(int in, int val) {
			set(in, val, 0, 0, size);
		}
		
		long sum(int l, int r, int x, int lx, int rx) {
			if(rx<=l || lx>=r) return 0;
			if(lx>=l && rx<=r) return sums[x];
			int m = (lx+rx)/2;
			long s1 = sum(l, r, 2*x+1, lx, m);
			long s2 = sum(l, r, 2*x+2, m, rx);
			return s1+s2; 
		}
		long sum(int l, int r) {
			return sum(l, r, 0, 0, size);
		}
		
	}
	public static void main(String[] args) {
		FastReader s = new FastReader();
		int n = s.nextInt();
		int m = s.nextInt();
		int[]arr = new int[n];
		segTree st = new segTree();
		st.init(n);
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		st.build(arr);
		
		for(int i=0;i<m;i++) {
			int op = s.nextInt();
			if(op == 1) {
				int in = s.nextInt(), v = s.nextInt();
				st.set(in, v);
			}
			else {
				int l = s.nextInt(), r = s.nextInt();
				long sum = st.sum(l, r);
				System.out.println(sum);
			}
			
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
