package algor.stack6;

public class ArrayStack {

       private String[] data; //数组
       private int count;//栈中元素数
       private int n;//栈的大小


       public ArrayStack(int n){
           this.data = new String[n];
           this.n = n;
           this.count = 0;
       }

       //入栈操作
       public boolean push(String val){
              if(n == 0){
                  return false;
              }
              data[count] = val;
              count ++;
              return true;
       }

       //出栈操作
       public String pop(){
              if(count == 0){
                 return  null;
              }
              String temp = data[count-1];
              count-- ;
              return temp;
       }


}
