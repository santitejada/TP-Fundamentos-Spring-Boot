# Sistema de Gestión de Tareas - Fundamentos de Spring Boot

## Descripción del proyecto
Este trabajo práctico implementa una aplicación de consola en **Spring Boot** que permite gestionar tareas (To-Do List) aplicando los fundamentos de la plataforma.  
Incluye la configuración de **profiles** (dev y prod), inyección de dependencias con `@Service` y `@Repository`, y el uso de propiedades externas a través de archivos `.properties`.

---

## Tecnologías utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Lombok**
- **Gradle**
- **IntelliJ IDEA**

---

## Instrucciones para ejecutar el proyecto

1. Clonar el repositorio
2. Abrir el proyecto en tu IDE (IntelliJ o Eclipse).
3. Verificar que esté configurado con Java 17.
4. Ejecutar la clase principal: com.utn.tareas.TareasApplication
5. Observar la salida en la consola según el entorno activo (dev o prod).

---

## Cambiar entre perfiles (dev / prod)  
El archivo application.properties define qué entorno se ejecuta. 
Dentro de ese archivo se van a encontrar con: 'spring.profiles.active=dev'  
Dependiendo de que perfil quieran usar cambian el 'spring.profiles.active=dev' por 'spring.profiles.active=prod'  
dev -> entorno de desarrollo   
<img width="448" height="151" alt="image" src="https://github.com/user-attachments/assets/ea863044-d6c2-421d-9218-bd192a55f246" />  

prod -> entorno de producción  
<img width="378" height="127" alt="image" src="https://github.com/user-attachments/assets/4c1d6be5-0d13-4fbe-8ca5-d972ea009024" />  

---

## Conclusiones personales  
Con este trabajo práctico comprendí el funcionamiento básico de Spring Boot y cómo estructurar una aplicación con distintos componentes.
Aprendí a usar las anotaciones principales (@Service, @Repository, @Value) y a manejar configuraciones mediante archivos .properties.
También entendí cómo aplicar perfiles (dev y prod) para adaptar la aplicación según el entorno de ejecución.

--- 

## Nombre y legajo 
## Santiago Ariel Tejada - 50181
