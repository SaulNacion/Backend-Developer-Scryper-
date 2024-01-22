# Getting Started

## Introduction to Spring

Cuando hablamos de Spring, nos referimos al Spring Framework, ampliamente reconocido como uno de los frameworks más destacados para el desarrollo en Java. Aunque existen otras opciones como Struts y EJB orientadas al mercado empresarial, así como JPA para el manejo de bases de datos, Spring sobresale por su capacidad integral para abordar diversas necesidades. La característica distintiva de Spring es su enfoque en POJO (Plain Old Java Project), a diferencia de EJB, que utiliza Entity y tiende a tener una huella más pesada en términos de tamaño para las empresas que lo adoptan.

Spring ofrece soporte para una variedad de proyectos, como Dependency Injection, desarrollo web a través de Spring MVC, creación de API REST mediante Spring REST, y aspectos relacionados con la seguridad, cada uno presentado en módulos separados. Básicamente, Spring se configura como una colección de módulos que incluye:

- Spring Core: para la inyección de dependencias.
- Spring MVC: para el desarrollo web.
- Spring REST: para la creación de API REST.

Esta estructura modular simplifica la adaptación de Spring a diferentes necesidades, permitiendo a los desarrolladores utilizar únicamente los componentes necesarios para sus proyectos específicos.

## Spring Documentation

Para obtener información detallada sobre Spring, la documentación oficial está en el siguiente enlace: [Official Spring's Web](https://spring.io). Además existen proyectos específicos y guías prácticas en [Spring Projects](https://spring.io/projects/) y [Guides](https://spring.io/guides/), respectivamente. La documentación también está disponible en formato Epub, accesible a través de [Epub](https://docs.spring.io/spring-framework/docs/4.3.24.RELEASE/spring-framework-reference/epub/).

## Spring Tool Suite STS

Para facilitar el desarrollo con Spring, se proporciona Spring Tool Suite (STS), una herramienta integral que ofrece soporte para la creación, edición y prueba de aplicaciones basadas en Spring.

# Spring Boot

## Dependency Injection in Spring

La inyección de dependencias es un concepto fundamental en Spring, permitiendo una gestión eficiente de componentes y promoviendo la modularidad y la reutilización de código. Con Spring, la *Dependency Injection* se realiza de manera sencilla, facilitando el mantenimiento y la evolución de las aplicaciones.

En este caso Spring está gestando la creación de clases y objetos.

```java
// DemoApplication.java
package com.scryper.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	
		// Alien obj = context.getBean(Alien.class);

		// obj.code();

		// Salida: Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.scryper.demo.Alien' available
	
		// Anotando "@Component" en la clase "Alien"
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	
		Alien obj = context.getBean(Alien.class);

		obj.code();

		// Salida: Coding...

	}

}
```
```java
// Alien.java
package com.scryper.demo;

import org.springframework.stereotype.Component;

@Component
public class Alien {

    public void code()
    {
        System.out.println("Coding...");
    }

}
```

## Spring Boot Autowire

@Autowired es una anotación que se utiliza para la inyección de dependencias. La inyección de dependencias es un patrón de diseño en el que las clases reciben las dependencias que necesitan en lugar de crearlas internamente. Esto ayuda a lograr un código más flexible, mantenible y fácil de probar.

Cuando se utiliza @Autowired en Spring Boot, se le está diciendo al contenedor de inversión de control de Spring que resuelva automáticamente las dependencias necesarias para mi clase y las proporcione. Esta anotación puede aplicarse a constructores, métodos setter o directamente a campos.

```java
//DemoApplication.java
package com.scryper.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	
		// Alien obj = context.getBean(Alien.class);

		// obj.code();

		// Salida: Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.scryper.demo.Laptop.compile()" because "this.lap" is null

		// Anotando "@Autowired" sobre la declaracion Laptop lap;
		Alien obj = context.getBean(Alien.class);

		obj.code();

		// Salida: Compiling...
	}
}
```

```java
// Alien.java
package com.scryper.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired
    Laptop lap;

    public void code()
    {
        lap.compile();
    }

}
```

```java
// Laptop.java
package com.scryper.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop {

    public void compile() {
        System.out.println("Compiling...");
    }

}
```
# Spring Core IoC

## BeanFactory

En el contexto del Inversion of Control (IoC) en Spring, la interfaz fundamental que encapsula el contenedor de beans es conocida como `BeanFactory`. La IoC, en el caso de Spring, se refiere al hecho de que el contenedor de Spring maneja la creación y gestión de objetos (beans) en lugar de que la aplicación lo haga directamente.

La `BeanFactory` es responsable de la configuración, creación y administración de los beans dentro de la aplicación. Su función principal es proporcionar un entorno centralizado para la gestión de objetos, permitiendo que las dependencias entre los diferentes componentes de la aplicación se administren de manera eficiente.

Algunas características clave de `BeanFactory` incluyen:

1. **Inyección de Dependencias (DI):** La `BeanFactory` realiza la inyección de dependencias, lo que significa que se encarga de suministrar las dependencias necesarias a los beans durante su creación. Esto promueve la modularidad y la fácil sustitución de componentes en una aplicación.

2. **Configuración Externa:** La configuración de los beans se realiza externamente, generalmente a través de archivos XML o anotaciones, permitiendo una configuración más flexible y fácil de cambiar sin necesidad de modificar el código fuente.

3. **Lazy Initialization:** La `BeanFactory` admite la inicialización perezosa (lazy initialization) de beans. Esto significa que un bean no se crea hasta que sea solicitado, mejorando el rendimiento al cargar solo los beans necesarios.

4. **Manejo del Ciclo de Vida:** La `BeanFactory` gestiona el ciclo de vida de los beans, lo que incluye la creación, la llamada a los métodos de inicialización y la destrucción cuando ya no son necesarios.

5. **Escalabilidad:** Permite la creación y gestión eficiente de un gran número de beans, facilitando la construcción de aplicaciones escalables y mantenibles.

Un ejemplo básico de configuración XML para un bean en un archivo de contexto de Spring podría verse así:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="package.ClassMyBean" />

</beans>
```
A continuación el código de prueba 

```java
// App.java
package com.scryper.SpringDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class App 
{
    public static void main( String[] args )
    {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
    	
    	Alien obj = (Alien) factory.getBean("alien");
    	
    	obj.code();

        // Salida: I'm Coding...
        
    }
}
```

```java
// Alien.java
package com.scryper.SpringDemo;

public class Alien {

	public void code()
	{
		System.out.println("I'm Coding...");
	}
}
```

```xml
<!-- spring.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<bean id="alien" class="com.scryper.SpringDemo.Alien"></bean>

</beans>
```