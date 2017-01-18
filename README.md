API - galaxy
==================

Aplicación Galaxy usando Google Cloud Endpoints en Java.

## Productos
- App Engine

## Lenguaje
- Java

## APIs
- Google Cloud Endpoints
- Google App Engine Maven plugin

## Instrucciones

1. Ejecutar el end-point https://galaxy-155723.appspot.com/_ah/api/galaxy/v1/galaxy?dias=X, con X=días,
   si se quieren ver los valores de la galaxia luego de haber pasado X días, esto es:

   * Número de días de sequía
   * Número de períodos de lluvia
   * Cuál es el día com máximo pico de lluvia
   * Cuantos días habrá con óptimas condiciones de lluvia

1. Ejecutar el end-point https://galaxy-155723.appspot.com/_ah/api/galaxy/v1/clima?dia=X, con X=día,
   si se quiere ver la condición climática del día X

   **NOTA:** para esta primera versión a ambos endpoints se le puede pasar un parámetro adicional delta=Y,
   donde Y representa un número real que denota la precisión en que serán comparados dos números reales,
   este valor tiene un valor por defecto de 0.1

   **NOTA 2:** una vez que se genere un día o una galaxia con un delta no podrá modificarse, por lo que si
   se intenta generar nuevamente el dia o la galaxia con un delta distinto, éste será ignorado. Se prevee
   para una segunda versión el soporte para permitir almacenar mismo día con distintos delta