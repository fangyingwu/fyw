package algor.sort9;

public class QuickSort {



    public static void quickSort(int[] a,int lo,int hi){
        if(lo >= hi) return;
        int pivot = partition(a,lo,hi);
        quickSort(a,lo,pivot-1);
        quickSort(a,pivot+1,hi);
    }



    public static int partition(int[] a,int lo,int hi){
        int pivot = a[hi];
        int index = hi;
        hi--;
        while(lo <= hi){
            if(a[lo] > pivot ){
                swap(a,lo,hi);
                hi--;
            }else{
                lo++;
            }
        }
        swap(a,lo,index);
        return lo;
    }

    public static void swap(int[] a,int lo,int hi){
        int temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }


}
