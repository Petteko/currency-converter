# Conversor de Monedas

Este repositorio contiene un sistema interactivo de conversión de monedas desarrollado en Java. El programa permite a los usuarios convertir entre diferentes monedas utilizando tasas de cambio en tiempo real obtenidas de una API externa.

---

## Funcionalidades Principales

1. **Conversión de Monedas**:
   - Soporta las siguientes monedas: ARS (Peso argentino), BRL (Real brasileño), CLP (Peso chileno), UYU (Peso uruguayo), USD (Dólar estadounidense), EUR (Euro).
   - Realiza conversiones en tiempo real utilizando tasas de cambio actualizadas.

2. **Interfaz de Usuario en Consola**:
   - Menú interactivo que guía al usuario paso a paso.
   - Permite seleccionar monedas de origen y destino, e ingresar el monto a convertir.

3. **Manejo de Errores**:
   - Validación de entradas para evitar errores.
   - Mensajes claros en caso de problemas con la API o entradas inválidas.

4. **Historial de Conversiones**:
   - Registra las últimas conversiones realizadas.
   - Muestra el historial con detalles como monedas, montos y marcas de tiempo.

---

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:
```
currency-converter/
├── .gitignore
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── currencyconverter/
│   │   │           ├── api/
│   │   │           │   ├── APIClient.java
│   │   │           │   ├── RatesManager.java
│   │   │           │   └── UnsupportedCurrencyPairException.java
│   │   │           ├── converter/
│   │   │           │   └── ConversorMonedas.java
│   │   │           ├── ConversionEntry.java
│   │   │           ├── ConversionHistory.java
│   │   │           └── Main.java
│   │   └── resources/
│   │       └── config.properties
└── README.md
```

---

### Instrucciones de Uso

1. Clonar el Repositorio:
   - Ejecuta el siguiente comando en tu terminal:
     ```
     git clone https://github.com/Petteko/currency-converter.git
     cd currency-converter
2. Agregar tu API Key:
   - Abre el archivo config.properties y reemplaza TU_API_KEY_AQUI con tu clave de API:
     ```
     api.key=TU_API_KEY_AQUI

   - Nota: Si no tienes una API key, regístrate en un servicio como exchangerate-api.com o Alpha Vantage para obtener una.


3. Compilar y Ejecutar:
   - Si usas Maven, ejecuta los siguientes comandos:
     ```
     mvn clean install
     mvn exec:java -Dexec.mainClass="com.currencyconverter.Main"

4. Usar el Programa:
   - Sigue las instrucciones en la consola para seleccionar monedas y realizar conversiones.

---

## Dependencias

El proyecto utiliza las siguientes dependencias:

- Gson: Para manejar respuestas JSON de la API.
- Java 11 o superior: Para ejecutar el programa.

---

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue las pautas de contribución que se detallarán en un futuro.