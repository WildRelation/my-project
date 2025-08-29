public class Rational {
    int taljare;
    int namnare;

    private int gdc(int m, int n){
        m = Math.abs(m);
        n = Math.abs(n);
        while(m != n){
            if (m > n) m -= n;
            else n -= m;
        }
        return m;
    }

    public Rational(){
        taljare = 0;
        namnare = 1;
    }

    public Rational(int taljare){
        this.taljare = taljare;
    }

    public Rational(int taljare, int namnare){
        int divisor = gdc(taljare, namnare);
        this.taljare = taljare/divisor;
        this.namnare = namnare/divisor;
    }

    public Rational add(Rational rational){
        int divisor;
        Rational result = new Rational();
        result.taljare = (this.taljare*rational.namnare)+(this.namnare*rational.taljare);
        result.namnare = this.namnare*rational.namnare;
        divisor = gdc(result.taljare, result.namnare);
        result.taljare = result.taljare/divisor;
        result.namnare = result.namnare/divisor;
        return result;
    }

    public Rational add(int n){
        Rational result = new Rational();
        result.taljare = this.taljare + this.namnare*n;
        //this.taljare = result.taljare;
        return result;
    }

    public int getTaljare(){
        return this.taljare;
    }
    public int getNamnare(){
        return this.namnare;
    }

    public String toString(){
        return String.format("%d/%d", getTaljare(), getNamnare());
    }
}
