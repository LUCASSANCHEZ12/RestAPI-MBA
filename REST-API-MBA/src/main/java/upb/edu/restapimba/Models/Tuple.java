package upb.edu.restapimba.Models;

public class Tuple <A,B>
{
    private A Valor1;
    
    private B Valor2;

    public Tuple(A valor1, B valor2) {
        Valor1 = valor1;
        Valor2 = valor2;
    }

    public A getValor1() {
        return Valor1;
    }

    public B getValor2() {
        return Valor2;
    }
    
    
}
