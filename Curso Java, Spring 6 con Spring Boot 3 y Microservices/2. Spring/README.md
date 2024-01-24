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

¡Entendido! Vamos a profundizar en las otras secciones de manera similar a como lo hicimos con la sección **Primary Bean**:

## ApplicationContext

El `ApplicationContext` es una interfaz que representa el contenedor que contiene y gestiona los beans de la aplicación. Existen varias implementaciones, y en este ejemplo, utilizamos `ClassPathXmlApplicationContext`.

El código de ejemplo carga el contexto desde un archivo XML llamado "spring.xml" y obtiene un bean llamado "alien". Aquí, "Alien" es un componente gestionado por Spring, y el contexto se encarga de la creación y configuración del bean. Este enfoque de IoC (Inversión de Control) permite que Spring administre las dependencias y el ciclo de vida del bean.

```java
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
Alien obj = (Alien) context.getBean("alien");
obj.code();
```

## Spring Container

El contenedor de Spring es fundamental para la IoC, donde Spring asume el control de la creación y gestión de los objetos (beans). En el ejemplo de configuración XML, se define un bean llamado "miBean" de la clase "com.ejemplo.MiBean". Este bean se convierte en un componente gestionado por el contenedor de Spring.

```xml
<beans>
    <bean id="alien" class="com.scryper.SpringDemo.Alien"></bean>
</beans>
```

En tiempo de ejecución, Spring crea una instancia de "Alien", configura sus propiedades y gestiona su ciclo de vida. Este enfoque simplifica la gestión de dependencias y promueve la modularidad en la aplicación.

```java
// App.java
package com.scryper.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        //BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
    	
    	ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
    	
    	Alien obj = (Alien) factory.getBean("alien");
    	obj.code();
        obj.age = 16;
        System.out.println(obj.age);

        // Salida : I'm Coding
        //          16

        Alien obj1 = (Alien) factory.getBean("alien");
    	obj1.code();
        System.out.println(obj1.age);

        // A pesar de que no se le dio un valor "age" este tomó el del anterior objeto
        // Salida : I'm Coding 
        //          16
    }
}
```

## Singleton vs Prototype

Spring permite especificar el alcance de los beans mediante el atributo `scope` en la configuración XML. En el ejemplo, se ilustra la diferencia entre `singleton` y `prototype`. Un bean con alcance `singleton` se crea una vez en el contenedor y se comparte en todas las solicitudes, mientras que un bean con alcance `prototype` se crea cada vez que se solicita.

```xml
<bean id="alien" class="com.scryper.SpringDemo.Alien" scope="singleton" />

<bean id="prototypeBean" class="com.scryper.SpringDemo.Alien" scope="prototype" />
```

La elección entre `singleton` y `prototype` depende de los requisitos específicos de la aplicación. Los beans `singleton` son eficientes, pero se comparten en todo el contexto, mientras que los beans `prototype` ofrecen instancias independientes para cada solicitud.

## Setter Inyection

La *Setter Inyection* es un método común para suministrar dependencias a los beans en Spring. En la clase "Alien", se define un método de setter para la propiedad "dependencia". Este método se utiliza para inyectar la dependencia después de la creación del objeto.

```java
public class MiBean {
    private Dependencia dependencia;

    // Setter para inyección
    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
}
```

Durante la configuración del bean en el contexto de Spring, se utilizará este método para establecer la dependencia. La inyección por Setter mejora la flexibilidad y facilita la configuración de dependencias, especialmente en configuraciones XML.

## Ref Attribute

En la configuración XML de Spring, el atributo `ref` se utiliza en la etiqueta `<property>` para referenciar otro bean. En el ejemplo, el bean "miBean" tiene una propiedad llamada "otraDependencia" que se refiere al bean llamado "dependencia".

```xml
<bean id="dependencia" class="com.ejemplo.Dependencia" />
<bean id="miBean" class="com.ejemplo.MiBean">
    <property name="otraDependencia" ref="dependencia" />
</bean>
```

El atributo `ref` establece una relación de dependencia entre beans, permitiendo que Spring resuelva y gestione las dependencias de manera automática.

## Constructor Injection

La inyección por constructor es otra técnica para suministrar dependencias. En la clase "MiBean", se define un constructor que acepta la dependencia como parámetro, permitiendo la inyección durante la creación del objeto.

```java
public class MiBean {
    private Dependencia dependencia;

    // Constructor para inyección
    public MiBean(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
}
```

Al configurar el bean en el contexto de Spring, se proporcionará la dependencia al crear una instancia de "MiBean". Esta forma de inyección es útil cuando se desea garantizar que todas las dependencias requeridas estén disponibles desde el principio.

## Autowire

La característica `autowire` de Spring simplifica la configuración de dependencias al permitir que Spring resuelva automáticamente las dependencias. En el ejemplo XML, el atributo `autowire` se establece en "byType", lo que significa que Spring intentará emparejar las dependencias por tipo.

```xml
<bean id="miBean" class="com.ejemplo.MiBean" autowire="byType">
    <!-- No se requiere configurar explícitamente la dependencia -->
</bean>
```

Al usar `autowire`, se reduce la necesidad de configurar manualmente las dependencias, mejorando la legibilidad del código y facilitando el mantenimiento.

Estas prácticas de configuración en Spring forman una base sólida para el desarrollo de aplicaciones gestionadas por contenedores, donde la IoC y la inyección de dependencias son fundamentales para la flexibilidad y la modularidad del código.

## Primary Bean

En Spring, cuando tienes múltiples beans del mismo tipo y necesitas indicar cuál de ellos debe ser preferido para la inyección de dependencias, puedes utilizar la anotación `@Primary` en uno de los beans. Esto indica que ese bean debe ser considerado como el candidato principal cuando se resuelven las dependencias.

A continuación, se muestra un ejemplo de cómo usar `@Primary` en una configuración basada en anotaciones:

```java
public interface Servicio {
    void realizarOperacion();
}

@Component
@Primary
public class ServicioPrincipal implements Servicio {
    public void realizarOperacion() {
        System.out.println("Realizando la operación principal");
    }
}

@Component
public class ServicioSecundario implements Servicio {
    public void realizarOperacion() {
        System.out.println("Realizando la operación secundaria");
    }
}
```

En este ejemplo, `@Primary` se utiliza en la clase `ServicioPrincipal`, indicando que debería ser la opción preferida cuando se inyecta un bean de tipo `Servicio`. Si no se especifica el bean concreto al inyectar, se utilizará el bean marcado como `@Primary` por defecto.

```java
@Service
public class ClaseQueUtilizaServicio {
    private final Servicio servicio;

    @Autowired
    public ClaseQueUtilizaServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    // ...
}
```

En este caso, `ServicioPrincipal` se inyectará en la clase `ClaseQueUtilizaServicio` debido a la anotación `@Primary`. La anotación `@Primary` es útil cuando deseas establecer una preferencia clara entre varios beans del mismo tipo.

# Spring MVC

## Spring MVC Theory

Spring MVC (Model-View-Controller) es un marco de desarrollo web en el ecosistema de Spring que facilita la creación de aplicaciones web basadas en el patrón de diseño MVC. Este patrón separa la aplicación en tres componentes principales: el Modelo (manejo de datos y lógica de negocio), la Vista (presentación de datos al usuario) y el Controlador (manejo de solicitudes y respuestas).

En Spring MVC, el flujo típico de trabajo comienza con la solicitud del usuario, que es manejada por el controlador. El controlador procesa la solicitud, interactúa con el modelo y devuelve una vista al usuario.

## Spring MVC Getting Started

Para comenzar con Spring MVC, es necesario configurar adecuadamente el archivo de configuración (como web.xml) y establecer el despachador (DispatcherServlet). Spring Boot simplifica considerablemente esta configuración mediante anotaciones y convenciones por defecto.

## Creating Controller

Los controladores en Spring MVC son responsables de manejar las solicitudes del usuario. Pueden procesar datos, interactuar con el modelo y devolver una vista. Se pueden crear controladores mediante la anotación `@Controller`.

```java
@Controller
public class MiControlador {
    @RequestMapping("/pagina")
    public String mostrarPagina() {
        // Lógica del controlador
        return "vista";
    }
}
```

## Tomcat Jasper

Tomcat Jasper es el motor JSP (JavaServer Pages) utilizado en combinación con el servidor web Apache Tomcat. Jasper compila los archivos JSP en servlets Java para mejorar el rendimiento y proporcionar funcionalidades avanzadas.

## Accepting User Input

Para aceptar la entrada del usuario en Spring MVC, se utilizan parámetros de solicitud. Esto implica la anotación `@RequestParam` para vincular los valores de los parámetros de la solicitud a los parámetros del método del controlador.

```java
@RequestMapping("/saludo")
public String saludar(@RequestParam("nombre") String nombre) {
    // Lógica del controlador
    return "saludo";
}
```

## RequestParam

La anotación `@RequestParam` en Spring MVC se utiliza para extraer y vincular los valores de los parámetros de la solicitud a los parámetros del método del controlador. Puedes especificar el nombre del parámetro y proporcionar un valor predeterminado.

```java
@RequestMapping("/saludo")
public String saludar(@RequestParam(name = "nombre", defaultValue = "Invitado") String nombre) {
    // Lógica del controlador
    return "saludo";
}
```

## ModelAndView

`ModelAndView` es una clase en Spring MVC que permite agregar atributos al modelo y especificar la vista que se mostrará al usuario.

```java
@RequestMapping("/saludo")
public ModelAndView saludar(@RequestParam(name = "nombre", defaultValue = "Invitado") String nombre) {
    ModelAndView modelAndView = new ModelAndView("saludo");
    modelAndView.addObject("nombre", nombre);
    // Lógica del controlador
    return modelAndView;
}
```

## Prefix and Suffix

El prefijo y sufijo en Spring MVC se utilizan para resolver las vistas lógicas en vistas físicas. Por ejemplo, si el prefijo es "/WEB-INF/vistas/" y el sufijo es ".jsp", una vista lógica "saludo" se resolverá como "/WEB-INF/vistas/saludo.jsp".

```xml
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/vistas/" />
    <property name="suffix" value=".jsp" />
</bean>
```

## Model and ModelMap

`Model` y `ModelMap` son objetos que permiten la comunicación entre el controlador y la vista en Spring MVC. Pueden almacenar atributos que se mostrarán en la vista.

```java
@RequestMapping("/saludo")
public String saludar(@RequestParam(name = "nombre", defaultValue = "Invitado") String nombre, Model model) {
    model.addAttribute("nombre", nombre);
    // Lógica del controlador
    return "saludo";
}
```

## Need of ModelAttribute

`@ModelAttribute` en Spring MVC se utiliza para ligar los datos del modelo directamente a los parámetros del método del controlador. Esto puede simplificar el código y mejorar la claridad.

## ModelAttribute

```java
@ModelAttribute("mensaje")
public String mensaje() {
    return "Hola, esto es un mensaje desde el modelo";
}
```

## ModelAttribute at Method Level

La anotación `@ModelAttribute` también se puede usar a nivel de método en el controlador para agregar atributos al modelo que están disponibles para todos los métodos del controlador.

```java
@ModelAttribute("titulo")
public String titulo() {
    return "Saludo App";
}
```

## Post Mapping

`@PostMapping` es una anotación en Spring MVC utilizada para manejar solicitudes HTTP POST. Se aplica a un método del controlador y especifica la ruta del URI que activará ese método cuando se realice una solicitud POST.

```java
@PostMapping("/guardarDatos")
public String guardarDatos(@ModelAttribute Usuario usuario) {
    // Lógica del controlador para guardar datos
    return "confirmacion";
}
```

## Get Mapping

`@GetMapping` es una anotación en Spring MVC utilizada para manejar solicitudes HTTP GET. Al igual que `@PostMapping`, se aplica a un método del controlador y especifica la ruta del URI que activará ese método cuando se realice una solicitud GET.

```java
@GetMapping("/mostrarDatos")
public String mostrarDatos(Model model) {
    // Lógica del controlador para mostrar datos
    return "datos";
}
```

### Spring ORM

## Spring ORM Theory

Spring ORM (Object-Relational Mapping) es una parte del ecosistema de Spring que proporciona soporte para la integración de marcos de mapeo objeto-relacional, como Hibernate y JPA (Java Persistence API). Permite a los desarrolladores interactuar con bases de datos relacionales de una manera más orientada a objetos, evitando la necesidad de escribir código SQL directamente.

En la teoría de Spring ORM, se abordan conceptos como la integración de ORM en la arquitectura de Spring, la definición de beans de origen de datos, el manejo de transacciones y la configuración de sesiones de bases de datos.

## Spring Hibernate Config

La configuración de Spring con Hibernate es esencial para aprovechar las ventajas de un marco ORM popular como Hibernate. La configuración típicamente implica definir un DataSource, un SessionFactory y un administrador de transacciones.

```xml
<!-- Configuración de DataSource -->
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
    <property name="url" value="jdbc:mysql://localhost:3306/tu_base_de_datos" />
    <property name="username" value="tu_usuario" />
    <property name="password" value="tu_contraseña" />
</bean>

<!-- Configuración de SessionFactory con Hibernate -->
<bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
    <property name="packagesToScan" value="paquete.con.tus.entidades" />
    <property name="hibernateProperties">
        <props>
            <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
            <prop key="hibernate.show_sql">true</prop>
        </props>
    </property>
</bean>

<!-- Administrador de transacciones -->
<bean id="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
    <property name="sessionFactory" ref="sessionFactory" />
</bean>
```

## MySQL and DAO

La integración de Spring ORM con MySQL implica configurar correctamente el DataSource y la configuración de Hibernate para que se conecte a la base de datos MySQL. Asegúrate de tener las dependencias adecuadas en tu proyecto, como el controlador JDBC de MySQL y las bibliotecas de Hibernate.

## DAO Creation

Los DAOs (Data Access Objects) son componentes que proporcionan métodos para interactuar con la base de datos. En Spring ORM, puedes crear DAOs utilizando la plantilla `HibernateTemplate` o aprovechando las capacidades de Spring Data JPA.

```java
@Repository
public class UsuarioDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void guardarUsuario(Usuario usuario) {
        hibernateTemplate.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return hibernateTemplate.get(Usuario.class, id);
    }
}
```

## Add and Fetch

Añadir (Add) y obtener (Fetch) son operaciones comunes realizadas a través de DAOs en aplicaciones Spring ORM.

### Añadir (Add)

```java
@Controller
public class ControladorUsuario {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioDAO.guardarUsuario(usuario);
        return "confirmacion";
    }
}
```

### Obtener (Fetch)

```java
@Controller
public class ControladorUsuario {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping("/mostrarUsuario/{id}")
    public String mostrarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "mostrarUsuario";
    }
}
```

Estos fragmentos de código muestran cómo realizar operaciones de añadir y obtener usando Spring ORM y Hibernate. Los detalles específicos pueden variar según tu configuración y modelo de datos. Además, es importante tener cuidado con la gestión de transacciones para garantizar la consistencia de la base de datos.

