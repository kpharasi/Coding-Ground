package leetcodeLocked;

public class WiggleSort {
	
	public static int[] wiggle(int[] nums) {
		
		for(int i=0;i<nums.length;i++) {
			if(i%2==1) {
				if(nums[i]<nums[i-1]) {
					swap(nums, i);
				}	
			} else {
				if(i!=0 && nums[i]>nums[i-1]) {
					swap(nums, i);
				}
			}
		}
		
		return nums;
	}
	
	public static void swap(int[] nums, int i) {
		int tmp = nums[i];
		nums[i] = nums[i-1];
		nums[i-1] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3, 5, 2, 1, 6, 4};
		wiggle(nums);
		boolean flag = true;
		for(int n:nums) {
			if(flag==true) {
				System.out.print(n);
				flag=false;
			} else {
				System.out.print("," + n);
			}
		}
	}

}