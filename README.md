# CHALLENGE Conversor de Monedas - ONE - G8

![Java](https://img.shields.io/badge/Java-22-orange) ![Gson](https://img.shields.io/badge/Gson-2.10.1-blue) ![License](https://img.shields.io/badge/License-MIT-green)

**Esta aplicación fue desarrollada como parte del Challenge de Back End de ONE - G8 de Alura Latam.**  
Se trata de una herramienta con interfaz gráfica (GUI) en Java que convierte monedas utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/). Ofrece menús desplegables con nombres descriptivos y resultados en formato numérico español (puntos para miles, coma para decimales), ideal para usuarios que buscan una solución sencilla y efectiva para conversiones de divisas.

---

## 🌟 **Características Principales**

| **Característica**              | **Descripción**                                                                 |
|---------------------------------|---------------------------------------------------------------------------------|
| 🎨 **Interfaz Intuitiva**       | Construida con Swing, con ventanas de tamaño fijo (500x400 principal, 300x200 resultados). |
| 🌍 **Soporte de Monedas**       | Incluye monedas populares: USD, ARS, BRL, COP, MXN, JPY con nombres descriptivos. |
| 📊 **Resultados Formateados**   | Muestra conversiones como "1.000,00 ARS = 0,90 USD", con ajuste automático al ancho. |
| ⚠️ **Manejo de Errores**        | Mensajes claros para montos inválidos o problemas de conexión.                   |
| 📦 **Dependencias**             | Utiliza Gson para parseo de JSON desde la API.                                   |

### **Capturas de Pantalla**
- **Selección de Monedas**  
  ![Selección de Monedas](https://github.com/user-attachments/assets/048941b9-f28d-4137-906b-739a5017a492)

- **Resultado de Conversión**  
  ![Resultado](https://github.com/user-attachments/assets/a8c7afc5-05d3-4dfb-ba5c-c4c113a26301)

---

## 🛠 **Requisitos**

- **JDK 22**: Necesario para compilar y ejecutar (descarga desde [Adoptium](https://adoptium.net/) o [Oracle](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)).
- **Gson 2.10.1**: Biblioteca para parseo de JSON (incluida en `lib/`).
- **Clave de API**: Obtén una clave gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/).
- **Sistema Operativo**: Compatible con Windows, macOS o Linux.
- **IDE (opcional)**: Recomendado IntelliJ IDEA.
- **Conexión a Internet**: Requerida para consultas a la API.

---

## 📂 **Estructura del Proyecto**

```
ConversorDeMonedas/
├── src/
│   └── com/
│       └── aluracursos/
│           └── conversorDeMonedas/
│               ├── Principal.java         # Punto de entrada de la aplicación
│               ├── modulos/
│               │   ├── Api.java           # Conexión a la API
│               │   ├── Key.java           # Gestión de la clave API
│               ├── service/
│               │   ├── ExchangeRateService.java # Lógica de conversión
│               ├── ui/
│                   ├── ConversorDeMonedasUI.java # Interfaz gráfica
├── lib/
│   ├── gson-2.10.1.jar                  # Dependencia Gson
├── Key.txt                              # Clave API (gestionada localmente)
├── README.md                            # Documentación
```


## ▶️ Uso
1. Ejecuta la aplicación:
   - **En IntelliJ**: Haz clic derecho en `src/com/aluracursos/conversorDeMonedas/Principal.java` > **Run 'Principal.main()'**.
   - **En la terminal (sin Maven)**:
     ```bash
     cd ConversorDeMonedas
     javac -source 22 -target 22 -cp .;lib\gson-2.10.1.jar src\com\aluracursos\conversorDeMonedas\*.java src\com\aluracursos\conversorDeMonedas\modulos\*.java src\com\aluracursos\conversorDeMonedas\service\*.java src\com\aluracursos\conversorDeMonedas\ui\*.java
     java -cp .;lib\gson-2.10.1.jar com.aluracursos.conversorDeMonedas.Principal
     ```
   - **Con Maven**:
     ```bash
     mvn clean compile
     mvn exec:java -Dexec.mainClass="com.aluracursos.conversorDeMonedas.Principal"
     ```
2. En la GUI:
   - Selecciona la moneda de origen y destino desde los menús desplegables (por ejemplo, "Pesos Argentinos (ARS)", "Dólares Estadounidenses (USD)").
   - Ingresa un monto (por ejemplo, 100).
   - Haz clic en **Convertir**.
   

3. El resultado aparecerá en una ventana secundaria (por ejemplo, "100 ARS = 0.10 USD") con opciones:
   - **Otra Conversión**: Regresa a la ventana principal.
   - **Salir**: Cierra la aplicación.

## 🐛 Problemas y Soluciones

- **Advertencia: `source value 8 is obsolete`**:
  - En IntelliJ, configura **Project language level** a 22 (**File > Project Structure** > **Project** y **Modules**).
  - En la terminal, usa `-source 22 -target 22`.
  

- **Error: `package com.google.gson does not exist`**:
  - Verifica que `gson-2.10.1.jar` esté en `lib/`:
    ```bash
    dir lib\gson-2.10.1.jar
    ```
  - Añádelo en IntelliJ (**File > Project Structure** > **Libraries**).
  - Con Maven, ejecuta `mvn clean install`.
   
    
- **Error al leer `Key.txt`**:
  - Confirma que `Key.txt` esté en `ConversorDeMonedas/` con una clave válida.

    
## 📧 Contacto
Para preguntas o sugerencias, contacta a raquerh@gmail.com o abre un issue en el repositorio.
¡Gracias por tu interés! 🚀
