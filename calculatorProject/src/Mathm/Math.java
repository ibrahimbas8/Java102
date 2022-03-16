package Mathm;

public class Math {
    //toplama
    public static double sum(double num1, double num2){
        return num1 + num2;
    }
    //çıkarma
    public static double extraction(double num1, double num2){
        return num1 - num2;
    }
    //çarpma
    public static double impact(double num1, double num2){
        return num1 * num2;
    }
    //bölme
    public static double divide(double num1, double num2){
        if (num2 != 0){
            return num1 / num2;
        }
        return 0;
    }
    //üs alma
    public static double exponentiation(double num, double top){
        int expo = 1;
        for (int i=0; i<top; i++){
            expo *= num;
        }
        return expo;
    }
    //karekök
    public static double sqrt(double num){
        return 0;
    }
    //mod alma
    public static double mode(double num,double numMod){
        return num%numMod;
    }
    //Mutlak değer
    public static double absolute(double num){
        if (num<0) return -num;
        return num;
    }
    //faktöriyel
    public static double fak(double num){
        if (num ==1) return 1;
        else if (num>1){
            int fak = 1;
            for (int i=2; i<=num;i++){
                fak *=i;
            }
            return fak;
        }
        return 0;
    }
    //türev
    public static double derivative(double num, double top){
        return 0;
    }
    //integral
    public static double integral(double num, double top){
        return 0;
    }
}
