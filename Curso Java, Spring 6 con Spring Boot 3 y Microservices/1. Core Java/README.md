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

















