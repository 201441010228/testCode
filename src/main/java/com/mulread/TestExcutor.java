package com.mulread;

/**
 * @Auther: 张扬
 * @Date: 2018/7/24 17:46
 * @Description:
 */
public class TestExcutor {

    public  static  int  core = Runtime.getRuntime().availableProcessors() ;
     public static void main(String args[]){

         System.out.println(core);
         ThreadExcutor threadExcutor = new ThreadExcutor(core);
         Long start = System.currentTimeMillis();
         for(int i = 1;i <= 10 ;i++){
             threadExcutor.exec(new Runnable() {
                 @Override
                 public void run() {
                     System.out.println("线程 " + Thread.currentThread().getName()+"帮我干活");
                 }
             });
         }
         System.out.println("------------------------------------------任务用时"+(System.currentTimeMillis()-start));
         threadExcutor.shutDownThread();
     }
}
