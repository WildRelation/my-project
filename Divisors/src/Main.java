public class Main{
    public static void main(String[] args){
        Rational result = new Rational();

        Rational r1 = new Rational(2, 10);
        Rational r2 = new Rational(2, 5);
        Rational r5 = r2.add(r1);

        System.out.println(r1.toString());
        System.out.println(r2.toString());


        System.out.println(r5.toString());

        Rational n1 = new Rational(4);


    }
}