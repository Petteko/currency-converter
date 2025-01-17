# Proyecto de Conversión de Monedas

Este repositorio contiene el desarrollo de un sistema interactivo de conversión de monedas, implementado en Java. El proyecto explora diversas funcionalidades del lenguaje y su ecosistema para interactuar con APIs, procesar datos en formato JSON y brindar una experiencia personalizada al usuario.

## Descripción del Proyecto

El proyecto se desarrolla en múltiples fases, abordando las siguientes áreas clave:

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
   - Selección de al menos tres monedas para incluir en la aplicación: ARS (Peso argentino), UYU (Peso uruguayo), BRL (Real brasileño), USD (Dólar estadounidense).

6. **Conversión de Monedas**:
   - Implementación de la lógica para calcular valores convertidos entre diferentes monedas, utilizando las tasas de cambio obtenidas.

7. **Interfaz de Usuario en Consola**:
   - Creación de un menú interactivo basado en la consola, permitiendo a los usuarios seleccionar opciones de conversión y proporcionar datos para los cálculos.

## Funcionalidades Extra (Opcional)

Este proyecto también sugiere funcionalidades adicionales para enriquecer la experiencia del usuario:

- **Historial de Conversiones**: 
  - Registro de las últimas conversiones realizadas.
  
- **Ampliación de Monedas Soportadas**:
  - Inclusión de más monedas para ampliar la versatilidad de la aplicación.

- **Registros con Marca de Tiempo**:
  - Uso de la biblioteca `java.time` para añadir detalles temporales a las conversiones realizadas.

## Herramientas Recomendadas

Para facilitar el análisis y depuración del desarrollo, recomendamos herramientas como:

- **Postman**: Para probar las solicitudes HTTP a la API.
- **IDE de Java**: Eclipse, IntelliJ IDEA, o cualquier otra de tu preferencia.

---

### **Nota**  
Este archivo es un placeholder y será actualizado una vez que el proyecto esté avanzando en su desarrollo.
