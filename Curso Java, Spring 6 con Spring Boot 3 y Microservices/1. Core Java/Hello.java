
class Hello 
{
    public static void main(String args[]) 
    {
        int a = 12;
        int b = 7;
        char c = '0';


        // Prueba para If, Else If

        if (a < b)
        {
            c = 'm';
        }
        else if (a > b)
        {
            c = 'M';
        }

        System.out.println(c);


        // Prueba para Switch Statement

        switch(c)
        {
            case 'm':
                System.out.println("a es menor que b");
                break;
            case 'M':
                System.out.println("a es mayor que b");
                break;
            default:
                System.out.println("a es igual que b");        
        }

        // Prueba para Ternary Operator

        int numero = 6;
        char par_o_impar = numero % 2 == 0 ? 'p':'i' ;

        System.out.println(par_o_impar);

    }
}



