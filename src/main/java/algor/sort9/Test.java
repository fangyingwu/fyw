package algor.sort9;

public class Test {

    public static void main(String[] args) {
        int[] nums= new int[]{3,2,1,5,6,4};
        System.out.println("==="+findKthLargest(nums,2));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        int length = nums.length;
        int p = partition(nums,0,nums.length-1);
        while (p!=(length-k)){
            if(p<(length-k)){
                p = partition(nums,p+1,nums.length-1);
            }else{
                p = partition(nums,0,p-1);
            }
        }
        System.out.println("我是p"+p);
        return nums[p];
    }




    public static int partition(int[] nums,int low,int high){
        int index = high;
       // int ii = (low+high)/2;
        int pivot = nums[high];
        //swap(nums,ii,high);
        high--;
        while(low <= high){
            if(nums[low] > pivot){
                swap(nums,low,high);
                high--;
            }else{
                low++;
            }
        }
        swap(nums,low,index);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        return low;
    }


    public static void swap(int[] nums,int low,int high){
        if(low == high) return;
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
