# Conversor de Monedas

Este repositorio contiene el desarrollo de un sistema interactivo de conversión de monedas, implementado en Java. El proyecto explora diversas funcionalidades del lenguaje y su ecosistema para interactuar con APIs, procesar datos en formato JSON y brindar una experiencia personalizada al usuario.

---

## **Descripción del Proyecto**

El proyecto se desarrolla en múltiples fases, abordando las siguientes áreas clave:

### **Funcionalidades Implementadas**
1. **Uso de HttpClient**:
    - Realización de solicitudes HTTP para conectarse a una API de tasas de cambio.
    - Obtención eficiente de respuestas y manejo estructurado de las operaciones HTTP.

2. **Configuración con HttpRequest**:
    - Personalización de solicitudes HTTP, permitiendo la especificación de parámetros y opciones específicas para la consulta.

3. **Gestión de Respuestas con HttpResponse**:
    - Análisis detallado de las respuestas recibidas, accediendo a códigos de estado, encabezados y datos en formato JSON.

4. **Manipulación de JSON con Gson**:
    - Uso de la biblioteca Gson para mapear datos JSON a objetos Java, facilitando la extracción y manipulación de información clave.

5. **Filtrado de Monedas**:
    - Navegación en la estructura JSON de la API para obtener datos específicos de monedas.
    - Selección de monedas soportadas: ARS (Peso argentino), BRL (Real brasileño), CLP (Peso chileno), UYU (Peso uruguayo), USD (Dólar estadounidense), EUR (Euro).

6. **Conversión de Monedas**:
    - Implementación de la lógica para calcular valores convertidos entre diferentes monedas, utilizando las tasas de cambio obtenidas.

7. **Interfaz de Usuario en Consola**:
    - Creación de un menú interactivo basado en la consola, permitiendo a los usuarios seleccionar opciones de conversión y proporcionar datos para los cálculos.

---

### **Funcionalidades Adicionales (Opcionales)**

Estas funcionalidades están planificadas para futuras iteraciones del proyecto:

1. **Historial de Conversiones**:
    - Registro de las últimas conversiones realizadas.
    - Almacenamiento en un archivo o base de datos para persistencia.

2. **Ampliación de Monedas Soportadas**:
    - Inclusión de más monedas para ampliar la versatilidad de la aplicación.

3. **Registros con Marca de Tiempo**:
    - Uso de la biblioteca `java.time` para añadir detalles temporales a las conversiones realizadas.

4. **Caché de Tasas de Cambio**:
    - Implementación de un sistema de caché para reducir el número de llamadas a la API y mejorar el rendimiento.

5. **Validación de Entradas**:
    - Mejora de la validación de las monedas ingresadas por el usuario para evitar errores.

6. **Interfaz de Usuario Mejorada**:
    - Refactorización del menú principal para hacerlo más intuitivo y fácil de usar.

---

## **Estructura del Proyecto**

El proyecto sigue la siguiente estructura de directorios:

---

currency-converter/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── currencyconverter/
│   │   │           ├── api/
│   │   │           │   └── APIClient.java
│   │   │           ├── converter/
│   │   │           │   └── ConversorMonedas.java
│   │   │           ├── utils/
│   │   │           │   └── UtilityClass.java
│   │   │           └── Main.java
│   │   └── resources/
│   │       └── config.properties
│   └── test/
│       └── java/
│           └── com/
│               └── currencyconverter/
│                   ├── api/
│                   │   └── APIClientTest.java
│                   └── converter/
│                       └── ConversorMonedasTest.java
└── pom.xml

---

## **Herramientas Recomendadas**

Para facilitar el análisis y depuración del desarrollo, recomendamos las siguientes herramientas:

- **Postman**: Para probar las solicitudes HTTP a la API.
- **IDE de Java**: Eclipse, IntelliJ IDEA, o cualquier otra de tu preferencia.
- **Maven**: Para la gestión de dependencias y construcción del proyecto.

---

## **Notas**

Este archivo se actualizará a medida que el proyecto avance en su desarrollo. Las funcionalidades adicionales se implementarán en futuras iteraciones para mejorar la experiencia del usuario y la robustez del sistema.

---

## **Contribuciones**

Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue las pautas de contribución que se detallarán en un futuro.