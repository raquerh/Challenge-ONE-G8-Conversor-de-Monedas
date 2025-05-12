# CHALLENGE Conversor de Monedas - ONE - G8

![Java](https://img.shields.io/badge/Java-22-orange) ![Gson](https://img.shields.io/badge/Gson-2.10.1-blue) ![License](https://img.shields.io/badge/License-MIT-green)

Una aplicación Java con interfaz gráfica (GUI) que convierte monedas utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/). Los menús desplegables muestran nombres descriptivos (por ejemplo, "Pesos Argentinos (ARS)"), mientras que los resultados usan códigos de moneda (por ejemplo, "100 ARS = 0.10 USD"). Ideal para usuarios que buscan una herramienta sencilla para conversiones de divisas.

## 📋 Características
- Interfaz gráfica intuitiva construida con Swing.
- Selección de monedas con nombres descriptivos (por ejemplo, "Dólares Estadounidenses (USD)").
- Resultados de conversión en formato compacto (por ejemplo, "100 ARS = 0.10 USD").
- Soporte para monedas populares: USD, ARS, BRL, COP, MXN, JPY.
- Manejo de errores con mensajes claros (montos inválidos, problemas de conexión).
- Dependencia de Gson para parseo de JSON.

## 🛠 Requisitos
- **JDK 22**: Necesario para el módulo `java.net.http`.
- **Gson 2.10.1**: Biblioteca para parsear respuestas JSON.
- **Clave de API**: Una clave válida de [ExchangeRate-API](https://www.exchangerate-api.com/).
- **Sistema Operativo**: Windows, macOS o Linux.
- **IDE (opcional)**: IntelliJ IDEA recomendado.
- **Conexión a internet**: Para solicitudes a la API.

## 📂 Estructura del Proyecto
```
ConversorDeMonedas/
├── src/
│   └── com/
│       └── aluracursos/
│           └── conversorDeMonedas/
│               ├── Principal.java
│               ├── modulos/
│               │   ├── Api.java
│               │   ├── Key.java
│               ├── service/
│               │   ├── ExchangeRateService.java
│               ├── ui/
│                   ├── CurrencyConverterUI.java
├── lib/
│   ├── gson-2.10.1.jar
├── ConversorDeMonedas.iml
├── Key.txt
├── README.md
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