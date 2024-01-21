# Core Java
## First code in Java

Para experimentar con código se usa jshell en el terminal

```cmd
>jshell
|  Welcome to JShell -- Version 17.0.9
|  For an introduction type: /help intro

jshell> 2 + 3
$1 ==> 5

jshell> 9 - 6
$2 ==> 3
```

Para que el terminal escriba algo se usa *print()* seguido de un ";" 

```cmd
jshell> print(6);
|  Error:
|  cannot find symbol
|    symbol:   method print(int)
|  print(6);
|  ^---^
```

Se puede notar que nos arroja un error, se entiende que el **método** *method print(int)* no se encuentra ya que este está contenido en otro lugar.

```cmd
jshell> System.out.print(6);
6
jshell> System.out.print("Hello World");
Hello World
```
Una vez declarado el lugar de origen del **método** el terminal escribe lo que se le pide.

Ahora probare el último comando en *Visual Studio Code*, para esto usaré el archivo *Hello.java* que contiene el siguiente código:

```java
System.out.println("Hello World");
```

Y lo compilaré desde el terminal.

### Prueba de versión

```powershell
> java --version
java 17.0.9 2023-10-17 LTS
Java(TM) SE Runtime Environment (build 17.0.9+11-LTS-201)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.9+11-LTS-201, mixed mode, sharing)

> javac --version
javac 17.0.9
```
### Prueba de Código

```powershell
> javac Hello.java
Hello.java:2: error: class, interface, enum, or record expected
System.out.println("Hello World");
^
1 error
```

Esto indica que aún faltan cosas para que funcione el código que se agregarán más adelante.

## How Java works

Para resolver el problema del anterior video se hacen las siguientes cambios en el código de *Hello.java*:

```java
class Hello //Se crea la clase Hello
{
    public static void main(String a[]) // Este es su objeto
    {
        System.out.println("Hello World");
    }
}

```

Al compilar ese código usando el terminal se obtiene un nuevo archivo llamado *Hello.class* que es el *byte code* y luego se ejecuta para al fin lograr que el programa escriba "*Hello word*".

```cmd
>javac Hello.java
>java Hello
Hello World
```
Adicinalmente se agrega un gráfico de cómo es que funciona todo esto internamente.

![Grafico_1](/images/Grafico_1.PNG)

## Variables

Es donde se pueden guardar datos y existen diferentes tipos.

### Data types

* Integer 
* Float
* Character
* Boolean

#### Integer

Son números enteros (ej. `int num = 3;`)

- byte ->  1 bytes
- short -> 2 bytes
- int -> 4 bytes
- long -> 8 bytes

#### Float

Son numeros con decimales (ej. `float num = 2.6f;`)

- float -> 4 bytes
- double -> 8 bytes (más precisión)

#### Character

Son letras (ej. `char letter = 'k';`)

- char -> 2 bytes

#### Boolean

Pueden ser *true* o *false* (ej. `boolean b = true;`)

Para probar esto se modifica el código de *Hello.java*

```java
class Hello 
{
    public static void main(String a[]) 
    {
        int num1 = 3; // Se crean las variables enteras
        int num2 = 6;
        int result = num1 + num2; // El resultado de la suma se guarda en una variable del mismo tipo

        System.out.println(result); 
    }
}
```

Se compila para actualizar el archivo *Hello.class* y se muestra el resultado.

```cmd
>javac Hello.java
>java Hello
9
```
El siguiente código contiene todas las variables antes mencionadas y se intentará compilar para ver si la sintaxis usada es correcta.

```java
class Hello 
{
    public static void main(String a[]) 
    {
        byte by = 127; // Se crean todas las variables
        short s = 555;
        int num = 12;
        long l = 1138l;

        float f = 5.7f;
        double d = 5.75;

        char c = 's';

        boolean b = false;

        System.out.println(by); // Se muestran las variables
        System.out.println(s);
        System.out.println(num);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(b);
    }
}
```

Se compila y ejecuta el programa

```cmd
>javac Hello.java
>java Hello
127
555
12
1138
5.7
5.75
s
false
```
## Literals

Algunas formas de escribir variables en diferentes sistemas:

* Hexadecimal: `int h = 0x7E;` 
* Binario: `int b = 0b101;`

Para potencias de 10:

* Se puede separar con "_" para una mejor lectura de los ceros (ej. `long l = 100_000_000;`)
* También se pueden representar en formato científico (ej. `double d = 12e-10;`)

Las letras se pueden tratar como numeros tal que al hacer operaciones avanzaran o retrocederan según su orden en el alfabeto.

```java
class Hello 
{
    public static void main(String args[]) 
    {
        char c = 'd';
        c++;
        
        System.out.println(c);
      }
}
```
```cmd
>java Hello.java
e
```

## Type Convertion

Para probar conversiones de tipo de variable se uso el siguiente código:

```java
class Hello 
{
    public static void main(String args[]) 
    {
        //byte b = 127;
        int a = 257;
        byte b = (byte) a;

        System.out.println(b);

        float f = 5.6f;
        int i = (int) f;

        System.out.println(i);

      }
}
```
Se puede hacer una conversión directa si el valor inicial tiene menor rango que el valor final, para el caso inverso se requiere agregar entre parentesis el tipo de variable al que se quiere convertir (ej. `byte b = (byte) a;`), si el valor inocial excede el máximo valor posible en el tipo de variable convertida el valor guardado será el resto. En el caso de convertir un *float* a *integer* se perderá la parte decimal.

## Operators

### Arithmetic

|Operador|Símbolo|
|--------|-------|
|Suma    | `+`   |
|Resta   | `-`   |
|Multiplicacion   | `*`|
|División    | `/`|
|Resto   | `%`  |

### Comparator

|Operador|Símbolo|
|--------|-------|
|Mayor   |`>`    |
|Menor   |`<`    |
|Mayor igual |`<=`|
|Menor igual |`>=`|
|Igual  |`==`|
|DIferente  |`!=`|


### Conditional

|Operador|Símbolo|
|--------|-------|
|And     | `&&`  |
|Or      | `\|\|`|
|Not     | `!`   |

Se hacen las pruebas con el siguiente *script*

```java
class Hello 
{
    public static void main(String args[]) 
    {
        int a = 20;
        int b = 12;

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

        boolean result = a > b;
        System.out.println(result);
        result = a <= b;
        System.out.println(result);
        result = a != b;
        System.out.println(result);

        result = a <= b && a == b;
        System.out.println(result);
      }
}
```
```cmd
>java Hello.java
32
8    
240  
1    
8    
true 
false
true 
false
```
Los resultados son correctos

## If, Else If | Ternary Operator |  Switch Statement

Se usa *If* para determinar si una afirmacion (*Comparator Operator*) es verdadera o falsa, *Else if* sirve para repetir la acción de un *If* anterior, pero con una condición diferente.

*Switch* se usa para comparar valores y asignar una acción para cada valor de la variable.

El *Ternary Operator* realiza la misma acción que un *If, Else If*, pero es más conciso.

Luego se usa el siguiente código para las pruebas:

```java
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
```
```cmd
>java Hello.java
M
a es mayor que b
p
```

## While | Do While |  For

*While* se usa para hacer repeticiones a partir de una condición la cual se escribirá dentro del parentesis al lado de este y la acción a repetir dentro de las llave que lo acompañan (ej. `while(true){System.out.println(i);}`). 

*Do while* se usa para hacer al menos una vez la acción dentro de las llaves a pesar que la condición sea falsa, su sintaxis en la parte de *while* es la misma (ej. `do{System.out.println(i);}while(false);`). 

*For* engloba tanto la declaración de la variable a iterar, la condición y su incremento o decremento. Al igual que los anteriores tambien repite la acción dentro de las llaves (ej. `for(int i=1; i<10; i++){System.out.println(i);}`).

A continuación el código de prueba para probar los *loops*.

```java
public class Hello 
{
    public static void main(String args[]) 
    {
        int i = 1;

        while(i <= 10)
        {
            System.out.println(i);
            i++;
        }

        int j = 1;

        do
        {
            System.out.println(j);
            j++;
        }while(j <= 10);

        for(int k = 1; k <=10; k++)
        {
            System.out.println(k);
        }

    }
}
```

Se muestran diferentes maneras usando todos los *loops* de contar de 1 al 10.
```cmd
>java Hello.java
1
2 
3 
4 
5 
6 
7 
8 
9 
10
1
2
3
4
5
6
7
8
9
10
1
2
3
4
5
6
7
8
9
10
```
## Object Oriented Programming

Se muestra el código usado para probar los conceptos de la clase, en este *script* se creo la clase *Calculator* y se agregaron los métodos *add* y *res* luego se crea un objeto *calc* en la función principal de la clase *Hello* para poder usar los métodos de *Calculator*.

```java
class Calculator // Clase
{
    public int add(int n1, int n2) // Funciones de la clase (Métodos)
    {
        int s = n1 + n2;
        return s;
    }

    public int res(int n1, int n2) // Parámetros de la clase (Métodos)
    {
        int r = n1 - n2;
        return r;
    }
}

public class Hello 
{
    public static void main(String args[]) 
    {
        int a = 18;
        int b = 12;
        Calculator calc = new Calculator();  //Creación del objeto a partir de la clase

        int suma = calc.add(a,b); // Uso del objeto para hacer funciones heredadas de la clase
        int resta = calc.res(a,b);

        System.out.println(suma);
        System.out.println(resta);
        
    }
}
```
Se compilar el archivo *.java* para crea el archivo byte de *Calculator*

```cmd
>javac Hello.java
```

Y luego se ejecuta la clase *Hello* para ver los resultados de las operaciones

```cmd
>java Hello
30
6
```
## Methods | Method Overloading

En este código se puede ver que se pueden crear diferentes tipos de métodos y agregarles funcionalidad de acuerdo al tipo que sean

```java
class Computer 
{
    public void playMusic() // Tipo "void" no devuelve valores solo hace acciones
    {
        System.out.println("Playing Music...");
    }

    public String buyPen(int cost) // Tipo "String" devuelve un valor del mismo tipo
    {
        if (cost < 10)
            return "Nothing";
        return "Pen";
    }
}

public class Hello 
{
    public static void main(String args[]) 
    {
        int cost = 10;
        Computer com = new Computer();  

        com.playMusic();
        String answer = com.buyPen(cost);
        System.out.println(answer);
    }
}
```
Y este es el resultado
```cmd
>javac Hello.java
>java Hello
Playing Music...
Pen
```

El siguiente código se usa para probar el *Method Overloading* es una propiedad en Java que permite usar el mismo método de diferentes formas variando su tipo y el tipo de variables de sus parámetros
```java
class Calculator 
{
    public int add(int n1, int n2) 
    {
        return n1 + n2;
    }
    public int add(int n1, int n2, int n3) 
    {
        return n1 + n2 + n3;
    }
    public double add(double n1, int n2) 
    {
        return n1 + n2;
    }

}

public class Hello 
{
    public static void main(String args[]) 
    {
        int num1_i = 2;
        double num1_d = 2.65;
        int num2 = 3;
        int num3 = 5;
        Calculator calc = new Calculator();

        System.out.println(calc.add(num1_i,num2));
        System.out.println(calc.add(num1_i,num2,num3));
        System.out.println(calc.add(num1_d,num2));
    }
}
```
Se comprueba el resultado en el siguiente *script*
```cmd
>javac Hello.java
>java Hello
5
10  
5.65
```
## Arrays | Multidimentional Arrays | Array of Objects

Los *arrays* son un conjunto de variables pueden o no ser del mismo tipo, estas pueden estar distribuidas de las siguientes maneras:

* *Array* :  Una sola fila
    * *Array of Objects*
* *Multidimentional Array* :  Más de una fila
    * *Bidimentional Array*
    * *Jagged*
    * *Tridimentional Array*

A continuación se muestra el código para probar lo visto en los videos relacionados. 

```java
class Students
{
    String name;
    int age;
    float note;
}

public class Hello 
{
    public static void main(String args[]) 
    {
        // Arrays

        int num[] = {2,3,4}; // Declaración de "Arrays"
        char let[] = {'k','l','m'};

        int num1[] = new int[4]; // Declaración de "Arrays vacios"
        
        for (int i = 0; i <= 2; i++)
        {
            System.out.print(num[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <= 2; i++)
        {
            System.out.print(let[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <= 3; i++)
        {
            num1[i] = (int)(Math.random() * 10); // Uso de "Math.random() para agregar valores aleatorios"
            System.out.print(num1[i] + " ");
        }
        System.out.println();

        // Multidimentional Array

        //2D

        int dd_num[][] = new int[3][3];

        for (int i = 0; i <= 2; i++)
        {
            for (int j = 0; j <= 2; j++)
            {
                dd_num[i][j] = (int)(Math.random() * 10);
            }
        }

        for (int n[]: dd_num)
        {
            for (int m: n)
            {
                System.out.print(" " + m);
            }
            System.out.println();
        }

        // jagged

        int j_num[][] = new int[3][];

        j_num[0] = new int[2];
        j_num[1] = new int[4];
        j_num[2] = new int[3];


        for (int i = 0; i < j_num.length; i++)
        {
            for (int j = 0; j < j_num[i].length; j++)
            {
                j_num[i][j] = (int)(Math.random() * 10);
            }
        }

        for (int n[]: j_num)
        {
            for (int m: n)
            {
                System.out.print(" " + m);
            }
            System.out.println();
        }

        //  3D

        int ddd_num[][][] = new int[3][3][4];

        for (int i = 0; i < ddd_num.length; i++)
        {
            for (int j = 0; j < ddd_num[i].length; j++)
            {
                for (int k = 0; k < ddd_num[i][j].length; k++)
                {
                    ddd_num[i][j][k] = (int)(Math.random() * 10);
                }
            }
        }

        // Array of Objects

        Students s1 = new Students();
        s1.age = 15;
        s1.name = "Jorge";
        s1.note = 18.5f;

        Students s2 = new Students();
        s2.age = 17;
        s2.name = "Carlos";
        s2.note = 8.9f;

        Students s3 = new Students();
        s3.age = 23;
        s3.name = "Andre";
        s3.note = 16.5f;

        Students students[] = new Students[3];

        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for (int i = 0; i < students.length; i++)
        {
            System.out.println(students[i].age + " " + students[i].name + " " + students[i].note);
        }
    }
}
```

Se muestran los resultados comprobados

```cmd
>javac Hello.java
>java Hello       
2 3 4   
k l m   
3 3 7 1 
 3 8 4  
 9 3 3  
 4 3 2  
 8 2    
 5 2 9 9
 4 1 5
15 Jorge 18.5
17 Carlos 8.9
23 Andre 16.5
```
## What is String | String Buffer and String Builder

```java
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
```

```cmd
>java Hello.java
class java.lang.String
class java.lang.String
Hola Saul
true
l
Saul Nacion
Saul Junior Nacion
```
## Static Variables | Static Methods | Static Blocks

Al usar la *keyword* "static" antes de una variable esta se propaga a todos los objetos que se creen a partir de la clase que la contiene

```java
class Mobile
{
    int price;
    String brand;
    static String name;

    public void show()
    {
        System.out.println(price + " " + brand + " " + name);
    }
}

public class Hello 
{
    public static void main(String args[]) 
    {
        Mobile mb1 = new Mobile();

        mb1.price = 100;
        mb1.brand = "Apple";
        mb1.name = "Smart Phone";

        Mobile mb2 = new Mobile();

        mb2.price = 134;
        mb2.brand = "Samsung";
        //mb2.name = "Smart Phone";

        mb1.name = "JustPhone";

        mb1.show();
        mb2.show();

    }
}
```
Si se usa antes de un *method* este quedará ligado a la clase y para usarse no será necesario crear un nuevo objeto, al no tener un identificador (Un objeto relacionado) no se pueden añadir variables a este método a menos que hagamos que dependa de un objeto de esta forma se podrían añadir varibles al *static method*.


```java
class Mobile
{
    int price;
    String brand;
    String name;

    public static void show1()
    {
        System.out.println("static method");
    }

    public static void show2(Mobile obj)
    {
        System.out.println(obj.price + ":" + obj.brand + ":" + obj.name);
    }
}


public class Hello 
{
    public static void main(String[] args) 
    {
        Mobile.show1();

        Mobile obj1 = new Mobile();

        obj1.price = 200;
        obj1.brand = "Google";
        obj1.name = "SmartPhone";  

        Mobile.show2(obj1);

    }
}
```

Cada vez que un objeto es usado se ejecuta un constructor en el que podríamos poner variables iniciales, pero esto no es óptimo, porque el sistema tendría que llamar a las varibles varias veces para esto existe un bloque estático que se ejecuta una sola vez cuando usamos objetos en el método principal sin importar la cantidad de objetos que se creen.

```java
class Mobile
{
    int price;
    String brand;
    static String name;

    static
    {
        name = "Phone";
        System.out.println("in static block");
    }

    public void show()
    {
        System.out.println("in method");
        System.out.println(price + ":" + brand + ":" + name);
    }
}


public class Hello 
{
    public static void main(String[] args) 
    {
        Mobile obj1 = new Mobile();

        obj1.price = 200;
        obj1.brand = "Google";

        Mobile obj2 = new Mobile();

        obj2.price = 145;
        obj2.brand = "Apple";
        
        obj1.show();
        obj2.show();
         
    }
}
```

Se puede notar que el bloque *static* solo se ejecuta una vez a pesar de que hay dos objetos

```cmd
>javac Hello.java
>java Hello
in static block
in method      
145:Apple:Phone
in method       
145:Apple:Phone 
```
## Encapsulation | *this* keyword | Constructor

Cuando se quiere mencionar variables que tienen la denimonación de *private* lo que se hace es usar un método dentro de la clase que contiene a las varibles.

```java
class Human
{
    private int age; 
    private String name;

    public int getAge()
    {
        return 21;
    }
    
    public String getName()
    {
        return "Saul";
    }

}


public class Hello 
{
    public static void main(String[] args) 
    {
        Human obj = new Human();

        System.out.println("Su edad es: " + obj.getAge());
        System.out.println("Su nombre es: " + obj.getName());
    }
}
```

```cmd
>javac Hello.java
>java Hello 
Su edad es: 21
Su nombre es: Saul

```

Ahora si se quiere cambiar los valores de dichas variables se hace la misma manera aqui surge un problema y es que no se puede denominar a la varible local *age* de la misma manera que la instancia variable `public void setAge(int age){age = age}` por lo que se usa *this* para aclararle al programa que queremos asignarle una variable diferente a la instancia `public void setAge(int age){this.age = age}`.

```java
class Human
{
    private int age; 
    private String name;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
}


public class Hello 
{
    public static void main(String[] args) 
    {
        Human obj = new Human();

        obj.setAge(35);
        obj.setName("Carlos");
        
        System.out.println("Su edad es: " + obj.getAge());
        System.out.println("Su nombre es: " + obj.getName());

    }
}
```
```cmd
>javac Hello.java
>java Hello
Su edad es: 35
Su nombre es: Carlos
```
Un constructor es un método especial dentro de una clase que se utiliza para inicializar objetos de esa clase. Su nombre debe coincidir exactamente con el nombre de la clase y no tiene un tipo de retorno explícito. Los constructores son invocados automáticamente cuando se crea un nuevo objeto de la clase.

En el ejemplo anterior en la parte `Human obj = new Human();` *Human()* es el constructor. Se usan usualmente para inicializar la valores o código cuando se llama un objeto. 

## Default vs Parameterized | *this* and *super* method

Siguiendo con el ejemplo anterior se puede ver que existen métodos que no requieren ingresar variables para hacer acciones estos se les denomina en *default* (ej. `public void getName(){}`), pero si se necesitan ingresar varibles este será un método *parameterized* (ej. `public void setName(){String name}`).

Cuando se tiene clases padres e hijos, normalmente al usarse un objeto de la clase hijo el constructor de la clase padre se ejecutará primero que el de la clase hijo esto pasa porque aunque no se escriba se esta usando el método *super()* en el constructor hijo que refiere al constructor de la clase padre, si se quiere revertir eso lo que se tiene que hacer es usar el método *this()*.

## Anonymous Object

Es un objeto que no tiene denominación, se usa para usar algún método de la clase directamente.

```java
class Some
{
   public void showSome()
   {
        System.out.println("Some");
   }
}


public class Hello 
{
    public static void main(String[] args) 
    {
        new Some().showSome();;

    }
}
```
```cmd
>javac Hello.java
>java Hello
Some
```

## What is inheritance | Single and Multilevel inheritance

*Inheritance* o herencia se usa para crear clases que contengan información de otras clases, emparentandolas como padre a la clase original e hijo a la clase que posee sus métodos.

```java
class Calc
{
   
    public int add(int n1, int n2)
   {
        return n1 + n2;
   }
   public int sub(int n1, int n2)
   {
        return n1 - n2;
   }
}


class AdvCalc extends Calc
{
    public int mul(int n1, int n2)
    {
         return n1 * n2;
    }
    public double div(double n1, double n2)
    {
        return n1 / n2;
    }
}

public class Hello 
{
    public static void main(String[] args) 
    {
        int n1 = 1;
        int n2 = 3;
        AdvCalc obj = new AdvCalc();

        System.out.println( "Add: " + obj.add(n1, n2));
        System.out.println( "Sub: " + obj.sub(n1, n2));
        System.out.println( "Mul: " + obj.mul(n1, n2));
        System.out.println( "Div: " + obj.div(n1, n2));
    }
}
```
```cmd
>javac Hello.java
>java Hello
Add: 4
Sub: -2
Mul: 3
Div: 0.3333333333333333
```
Esta es una *single inheritance*, en cambio si se escribiera algo como
```java

Class A
{
    A()
    {
        // Code
    }
}
Class B extends A
{
    B()
    {
        // Code
    }
}
Class C extends B
{
    C()
    {
        // Code
    }
}
```
Se tendría una *multilevel inheritance*.

## Method Overriding | Access Modifiers

Cuando existan dos clases emparentadas con el mismo método el que se ejecutará será el de la clase donde se creo el objeto a pesar de que esta clase este como hija de la otra.

```java
class A
{
    public void show()
    {
        System.out.println("In A Show");
    }
    public void config()
    {
        System.out.println("In A Config");
    }
}


class B extends A
{
    public void show()
    {
        System.out.println("In B Show");
    }
}

public class Hello 
{
    public static void main(String[] args) 
    {
        B obj = new B();

        obj.show();
        obj.config();
    }
}
```
```cmd
>javac Hello.java
>java Hello
In B Show
In A Config
```
A las *keywords* *public*, *protected*, *private*, *default* (esta última no se escribe) se les denomina *Access modifiers* estas restring el uso de la clase, método, objeto o varible a las que antecedan, aqui una tabla con sus respectivas restricciones:

||private|public|protected|default|
|-|------|------|---------|-------|
|Same class| Yes| Yes| Yes| Yes
|Same package subclass| No| Yes| Yes| Yes
|Same package non-subclass| No| Yes| Yes| Yes
|Different package subclass| No| Yes| Yes| No
|Different package non-subclass| No| No| Yes| No

## Polymorphism | Dynamic Method Dispatch

El *polymorphism* se refiere a cuando un método se comporta de diferente manera dependiendo de la situación en la que se encuentre, existen dos tipos de polimorfismo, en la siguiente imagen se explican y se da un ejemplo de cómo se presentan.

![Grafico_2](/images/Grafico_2.PNG)

*Dynamic Method Dispatch* se refiere al proceso mediante el cual el método que se ejecutará para una llamada a un método es decidido en tiempo de ejecución en lugar de tiempo de compilación.

Cuando se tiene una jerarquía de clases y una subclase hereda de una superclase, y ambas clases tienen métodos con el mismo nombre, entonces puedes usar *Dynamic Method Dispatch* para invocar el método de la subclase a través de una referencia de la superclase.

```java
class A
{
    public void show()
    {
        System.out.println("In A Show");
    }
}


class B extends A
{
    public void show()
    {
        System.out.println("In B Show");
    }
}

public class Hello 
{
    public static void main(String[] args) 
    {
        A obj;

        obj = new A();
        obj.show();

        obj = new B();
        obj.show();
        
    }
}
```

```cmd
>javac Hello.java
>java Hello
In A Show
In B Show
```























