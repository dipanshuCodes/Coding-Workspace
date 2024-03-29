package February19;

import java.util.Scanner;
import java.util.*;

public class ARTBALAN {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long T = s.nextLong();
		for(long t=0;t<T;t++) {
			int[] arr = new int[26];
			String str = s.next();
			for(int i=0;i<str.length();i++) {
				arr[str.charAt(i)-65]+=1;
			}
			ArrayList<Integer> map = new ArrayList<>();
			for(int i=0;i<26;i++) {
				if(arr[i]!=0) {
					map.add(arr[i]);
				}
			}
			int size = str.length();
			int mapSize = map.size();
			while(map.size()<=26) {
				map.add(0);
			}
			Collections.sort(map, Collections.reverseOrder());
			
			int ans =Integer.MAX_VALUE;
			for(int i=1;i<=size;i++) {
				if(size%i==0) {
					int numContainer = size/i;
					if(numContainer>26) {
						continue;
					}
					int excess = 0;
					int used = 0;
					int gr = i;
					//System.out.println(gr);
					for(int j=0;j<numContainer;j++) {
						int val = map.get(j)-gr;
						if(val>=0) {
							excess+=val;
						}
						else {
							used+=Math.abs(val);
						}
					}
					/*if(excess>0 && used==0) {
						
					}*/
					//System.out.println("Group Ans "+i+":"+Math.max(excess, used));
					ans=Math.min(ans,Math.max(excess, used));

					
				}
				else {
					continue;
				}
			}
			System.out.println(ans);
			
		}

	}

}
