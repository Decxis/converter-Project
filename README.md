# Conversor de Divisas

## Descripción del Proyecto
Este proyecto es un conversor de divisas desarrollado en Java. Permite realizar conversiones entre diferentes tipos de divisas utilizando la API de ExchangeRate para obtener tasas de cambio actualizadas. Los usuarios pueden seleccionar las divisas de origen y destino, ingresar una cantidad a convertir y ver el resultado. El proyecto incluye funcionalidades para ver la tasa de cambio y llevar un historial de conversiones realizadas.

## Características
- Conversión de divisas en tiempo real usando la API de ExchangeRate.
- Selección de divisas por nombre completo y código.
- Visualización de la tasa de cambio entre dos divisas seleccionadas.
- Historial de conversiones con detalles de cada transacción.
- Menú interactivo para la selección de opciones.

## Estructura del Proyecto
El proyecto está organizado en varios paquetes y clases para mantener una estructura modular y limpia:


## Requisitos Previos
- Java 17 o superior
- Clave de la API de [ExchangeRate API](https://www.exchangerate-api.com/)
- Maven (si estás usando Maven para la gestión de dependencias)

## Configuración

1. Clona el repositorio o descarga el código fuente.
   ```bash
   git clone https://github.com/Decxis/converter-Project.git
Abre el proyecto en tu IDE preferido (Eclipse, IntelliJ, etc.).

Asegúrate de tener la librería Gson instalada:

Si usas Maven, agrega la siguiente dependencia al archivo pom.xml:
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
Si usas Gradle, agrega la dependencia a tu archivo build.gradle:
groovy
Copiar código
implementation 'com.google.code.gson:gson:2.8.9'
Reemplaza la clave de la API (YOUR_API_KEY) con tu clave real de ExchangeRate en CurrencyConverterService.java.

##Ejecución del Proyecto
Navega al directorio raíz del proyecto.
Ejecuta el proyecto usando tu IDE o desde la línea de comandos:
´´´bash
java -cp out/production/conversor-divisas com.currencyconverter.App
(Asegúrate de compilar el proyecto primero si es necesario).
Funcionalidades
Menú Principal
El menú principal presenta las siguientes opciones:

Convertir divisas: Permite convertir un monto de una divisa a otra seleccionada.
Ver tasa de cambio: Muestra la tasa de cambio entre dos divisas seleccionadas.
Ver historial de transacciones: Muestra un historial de todas las conversiones realizadas durante la sesión.
Salir: Cierra la aplicación.
Selección de Divisas
El usuario puede seleccionar divisas mediante un menú numerado que muestra el nombre completo y el código de cada divisa.
Historial de Transacciones
Se almacena un historial de conversiones realizadas durante la sesión actual. El historial incluye la cantidad convertida, las divisas de origen y destino, la tasa de cambio utilizada y el resultado.
Ejemplo de Uso
Selecciona la opción "Convertir divisas" en el menú.
Selecciona la divisa de origen (por ejemplo, USD).
Selecciona la divisa de destino (por ejemplo, EUR).
Ingresa la cantidad a convertir.
El sistema muestra el resultado de la conversión.
Estructura de Clases
App.java
Clase principal que contiene el menú interactivo. Es responsable de manejar la entrada del usuario y delegar las operaciones a CurrencyConverterService.

# CurrencyConverterService.java
Contiene la lógica para manejar las conversiones de divisas y consultar la API de ExchangeRate. También gestiona el historial de transacciones.

# HttpUtil.java
Clase de utilidad para manejar las solicitudes HTTP a la API de ExchangeRate.

# Currency.java
Representa una divisa con su nombre completo y código.

# TransactionHistory.java
Mantiene un registro del historial de transacciones realizadas durante la ejecución de la aplicación.

## Contribuciones
Las contribuciones son bienvenidas. Si encuentras algún problema o tienes una idea para mejorar el proyecto, por favor abre un issue o envía un pull request.

Este `README.md` proporciona una guía detallada sobre el proyecto, su configuración, ejecución y uso. Puedes modificarlo según tus necesidades específicas.
