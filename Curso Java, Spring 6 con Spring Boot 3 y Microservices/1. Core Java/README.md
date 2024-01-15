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



























