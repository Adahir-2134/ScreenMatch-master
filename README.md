Este programa en Java simula una página de películas y series, permitiendo consultar detalles como la clasificación, duración y calificación de películas y series. Utiliza el API de OMDb para obtener la información de cada título solicitado.

Funcionalidades
Consulta de películas y series: Permite al usuario buscar títulos específicos y recibir detalles clave, como su duración, calificación y clasificación.
Integración con OMDb API: Utiliza la API de OMDb para realizar consultas y obtener datos en tiempo real de una amplia base de películas y series.
Manejo de errores: Si el título solicitado no es válido o no se encuentra disponible, el programa informa al usuario y ofrece una retroalimentación clara.
Requisitos
Java 8 o superior.
Clave de API de OMDb: Necesitarás una clave de acceso a la API, la cual se puede obtener registrándose en el sitio de OMDb.
Uso
Clona este repositorio y abre el proyecto en tu entorno de desarrollo Java.
Agrega tu clave de API en el archivo de configuración (o en el código donde se haga la llamada al API de OMDb).
Ejecuta el programa y usa la interfaz para buscar títulos de películas o series, y consulta detalles como clasificación, duración y calificación.

Ejemplo de Salida
Título: Inception
Clasificación: PG-13
Duración: 148 min
Calificación: 8.8/10


feat: agregar visor de detalles de películas/series con integración del API OMDb

- Añadida funcionalidad para obtener y mostrar datos de películas/series (calificación, duración y clasificación) desde el API OMDb.
- Implementada interfaz de usuario para consultar películas/series y mostrar los detalles.
- Añadido manejo de errores en llamadas al API y mejor retroalimentación para resultados vacíos o no válidos.
