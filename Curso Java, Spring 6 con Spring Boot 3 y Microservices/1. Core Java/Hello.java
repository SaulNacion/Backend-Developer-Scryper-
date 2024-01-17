
public class Hello 
{
    public static void main(String args[]) 
    {
        // "String" es una clase y se puede declarar de ambas maneras
        String str = "Hola ";
        String str1 = new String("Saul");

        System.out.println(str.getClass());
        System.out.println(str1.getClass());

        System.out.println(str + str1);

        // Cuando se declara una nueva con los mismos caracteres no se crea una nueva
        // variable solo se le asigna la misma direccion que la variable ya creada
        String str2 = "Saul";
        String str3 = "Saul";
 
        System.out.println(str2 == str3);

        // "String" naturalmente es inmutable, pero existe un String que sí lo es
        // "StringBuffer" es mutable.
        StringBuffer name = new StringBuffer("Saul");
        System.out.println(name.charAt(3));

        name.append(" Nacion");
        System.out.println(name);

        name.insert(4, " Junior");
        System.out.println(name);
    }
}



