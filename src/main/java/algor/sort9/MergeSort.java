package algor.sort9;

public class MergeSort {

    //递归调用函数
    public void mergeSortIn(int[] a,int p,int r){
        if(p >= r) return;
        int q = p+(r-p)/2;
        mergeSortIn(a,p,q);
        mergeSortIn(a,q+1,r);
        merge(a,p,q,r);
    }


    public void merge(int[] a,int low,int mid,int hih){
        int right = mid+1;
        int length = hih-low+1;
        int[] temp = new int[length];
        int index=0;
        while (low <= mid && right <= hih){
             if(a[low] <= a[right]){
                 temp[index++] =  a[low++];
             }else{
                 temp[index++] = a[right++];
             }
        }
        if(low <= mid){
           temp[index++] = a[low++];
        }
        if(right <= hih){
            temp[index++] = a[right++];
        }
        //临时数据赋值给a
        for(int i=0;i<length;i++,hih--){
           a[hih] = temp[hih];
        }
    }

}
