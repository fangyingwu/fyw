package algor.sort8;

/*
*
* author fyw
* 1.冒泡排序
* 2.插入排序
* 3.选择排序
*
*/
public class Sorts {


    //冒泡排序
    public  void bubbleSorts(int[] a,int n){
         if(n<=1) return;
         for(int i=0;i<n-1;i++){
             boolean flag = false;
             for(int j=0;j<n-i-1;j++){
                 if(a[j] > a[j+1]){
                     int temp = a[j];
                     a[j] = a[j+1];
                     a[j+1]=temp;
                     flag = true;
                 }
             }
             if(!flag){
                 break;
             }
         }
    }

    //冒泡排序优化
    public  void bubbleSort2(int[] a,int n){
        if(n <=1){
            return;
        }
        //最后一次交换的位置
        int laseExchage = 0;
        int sortBoard = n-1;
        for(int i=0;i<n-1;i++){
             boolean flag = false;
             for(int j=0;j<sortBoard;j++){
                if(a[j]>a[j+1]){

                }
                flag = true;
                laseExchage =j;
             }
            sortBoard = laseExchage;
            if(!flag){
               break;
            }
        }
    }

    //插入排序
    public  void  insertSorts(int[] a,int n){
        if(n<=1) return;
        for(int i=1;i<n;i++){
            int value = a[i];
            int j = i-1;
            for(;j>=0;j--){
                if(a[j] > value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    //选择排序
    public void selectSorts(int[] a,int n){
       if(n<=1) return;
       for(int i=0;i<n-1;i++){
           int min=i;
           for(int j=i+1;j<n;j++){
               if(a[j]<a[min]){
                   min=j;
               }
           }
           int temp = a[i];
           a[i] = a[min];
           a[min] = temp;
       }


    }




}
