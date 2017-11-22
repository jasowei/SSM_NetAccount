package com.lanou.base.test;

/**
 * Created by dllo on 17/11/22.
 */
public class Test {

    //递归计算阶乘
    public int ride(int i){
        if (i == 1){
            return 1;
        }else {
            return ride(i-1)*i;
        }

    }
    //截取字符串
    public static void sub(String str, int len){
        if (str == null){
            System.out.println("hehe");
            return;
        }
        int byteNum = 0;
        byteNum = str.length();
        byte[] bytes = str.getBytes();
        if (len > byteNum){
            len = byteNum;
        }

        //截半的话字节对于的ASC码是小于0的值
        if (bytes[len]<0){
            String s = new String(bytes,0,--len);
            System.out.println(s);
        }else {
            String s = new String(bytes,0,len);
            System.out.println(s);
        }
    }

    // 2n个数, 任意取n个, 使其和与剩余n个数之和,的差 最小
    static void func(int A[]) {
        int i;
        int j;
        // 下面的变量声明地很直白，不解释
        int n2 = A.length;
        int n = n2 / 2;
        int sum = 0;
        // 计算数组总和
        for (i = 0; i < A.length; i++) {
            sum += A[i];
        }

        /*还记得编程之美中的话吗？
        我们的程序不需要按照上述递推公式计算每个集合，只需要为每个集合设一个标志数组，
        标记SUM/2到1这个区间中的哪些值可以被计算出来。
        flag[i][j]:任意i个整数之和是j,则flag[i][j]为true。换言之，flag[i][j]为true，
        那么一定能找到一组整数，使它们的和是j。
        下面的代码将对flag数组进行初始化*/
        boolean flag[][] = new boolean[A.length + 1][sum / 2 + 1];
        for (i = 0; i < A.length; i++)
            for (j = 0; j < sum / 2 + 1; j++)
                flag[i][j] = false;

        flag[0][0] = true;
        // 重点来了
        for (int k = 0; k < n2; k++) {
            //i取k和n中的较小值，我们的目的是找出集合S(2N, N)中与SUM最接近的那个和，所以k>n时，
            // 取到n就足够了。k<n时，我们显然无法从3个数中任意选择4个数，所以取k值
            for (i = k > n ? n : k; i >= 1; i--) {
                // 两层外循环是遍历集合S(k,i)，遍历顺序S[1][1],S[2][2],S[2][1],S[3][3]……
                // 特殊的依赖关系导致必须这样设计算法
                // 内层循环计算将A[k]加入到集合中能取到的可能的j值
                for (j = 0; j <= sum / 2; j++) {//j是i个任意整数可能的和，从0遍历到sum / 2，
                    // 判断能否得到
                    // 得到j值的条件，j是和，A[k]只是其中一个，肯定需要j >= A[k]，否则，
                    // 取flag[i - 1][j - A[k]]的值的时候会发生越界情况。flag[i - 1][j - A[k]] = true
                    // 代表可以找到i - 1个数，使它们的和为j - A[k]，所以此条件满足时意味着
                    // flag[i][j] = true
                    if (j >= A[k] && flag[i - 1][j - A[k]])
                        flag[i][j] = true;
                }
            }
        }
        // 终于计算完了，现在找到最合适的结果就好了，要找到最接近SUM / 2的和，倒着找最好了
        for (j = sum / 2; j >= 0; j--) {
            if (flag[n][j]) {
                System.out.println("sum is " + sum);
                System.out.println("sum/2 is " + sum / 2);
                System.out.println("j is " + j);
                System.out.println("minimum delta is " + Math.abs(2 * j - sum));
                break;
            }
        }
    }



    public static void main(String[] args) {
        // 1
        Test test = new Test();
        System.out.println(test.ride(6));

        // 2
        sub("哈13哈342",5);

        // 3
        int[] a = {2,3,4,5,6,7};
        func(a);

    }



}
