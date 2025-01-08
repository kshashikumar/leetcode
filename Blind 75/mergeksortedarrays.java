import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{

	public static ArrayList<Integer> mergerHelper(ArrayList<Integer> arr1,ArrayList<Integer> arr2){
		int t1=0,t2=0;
		ArrayList<Integer> mArr = new ArrayList<>();
		while(t1<arr1.size() || t2<arr2.size()){
			if(t2>= arr2.size() && t1<arr1.size()){
				mArr.add(arr1.get(t1));
				t1++;
			} else if(t1>= arr1.size() && t2<arr2.size()){
				mArr.add(arr2.get(t2));
				t2++;
			} else if(t2<arr2.size() && t1<arr1.size()){
				if(arr1.get(t1) > arr2.get(t2)){
					mArr.add(arr2.get(t2));
					t2++;
				} else {
					mArr.add(arr1.get(t1));
					t1++;
				}
			}
		}
		//System.out.println(mArr);
		return mArr;
	}
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		for(int i=1;i<k;i++){
			kArrays.set(i,mergerHelper(kArrays.get(i-1),kArrays.get(i)));
		}	
		return kArrays.get(k-1);
	}
}
