/* Program to return list of numbers using + or - that results to k. Here every no. shoul be present exactly once from the given list of nos.*/
import java.io.*;
import java.util.*;

class SumUpToK {

	public ArrayList<String> finalAns = new ArrayList<String>();
	
	public void helperFunc(String comb, int sum, int target, int[] nums, int combSize, int start) {
		
		if(sum == target && combSize == nums.length) {
			if(comb.charAt(0) == '+') {
				comb = comb.substring(1,comb.length());
			}
			finalAns.add(comb);
			//System.out.println(comb);
			return;
		}

		for(int i = start; i<nums.length; i++) {

			helperFunc(comb+"+"+nums[i], sum+nums[i], target, nums, combSize+1, i+1);
			helperFunc(comb+"-"+nums[i], sum-nums[i], target, nums, combSize+1, i+1); 
		}
	}
		
	public static void main(String[] args) {

		String numbers = "2,4,6,8,10";
		int k = 10;
		String num[] = numbers.split(",");
		int nums[] = new int[num.length];
		for(int i=0; i<num.length; i++) {
			
			nums[i] = Integer.parseInt(num[i]);
		}
		SumUpToK sk = new SumUpToK();
		sk.helperFunc("", 0, k, nums, 0, 0);
		System.out.println(sk.finalAns);

	}
}
