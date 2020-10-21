package com.kotlin.kotlinenhance.javaCallKt;

/**
 * @author : kingBoy
 * @time 2020/10/21 11:41
 */
class JavaCallKt {

    public static void main(String[] args) {
        final Overloads overloads = new Overloads();
        overloads.overloads(1, 2, 3);
        //kt可变参数调用
        overloads.overloads(1);
    }


    //java 调用包方法
    private void callPackageMethod() {
        PackageMethodKt.sayHello();
    }


    //java 调用扩展方法
    private void callExtMethod() {
        ExtMethodKt.noEmpty("");
    }
}
