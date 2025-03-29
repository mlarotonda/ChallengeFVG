# Challenge FVG

- Proyecto Gradle desarrollado en Java con tests en JUnit, utilizando Selenium para casos del Frontend y RestAssured para
  Backend.
- El Challenge consiste en 2 tests para el Frontend y 1 para el Backend.
- Instrucciones para ejecutar:
    1) Clonar el repositorio
    2) Descargar Chromedriver segun la version de tu navegador y pegarlo en la carpeta driver. <br>
       Link descarga: https://googlechromelabs.github.io/chrome-for-testing/
    3) Es requisito para ejecutar el proyecto tener instalado Java y Gradle.<br>
       En caso de no tener Java -> https://www.java.com/es/download/manual.jsp (version 8 o superior)<br>
       En caso de no tener Gradle -> https://gradle.org/install/
    4) Dentro de la carpeta del proyecto, ejecutar el comando: <br>
       &nbsp;&nbsp; \$ *./gradlew AllTest* --> Para ejecutar todos los test <br>
       &nbsp;&nbsp; \$ *./gradlew FrontendTest* --> Para ejecutar todos los test de Frontend <br>
       &nbsp;&nbsp; \$ *./gradlew BackendTest* --> Para ejecutar todos los test de Backend
  5) Para ver el reporte de los casos ingresar a la ruta: <br>
     &nbsp;&nbsp; */build/reports/tests/{carpetaDeTest}/index.html* <br>
     Esto resulta util para ver el log en casos de Backend.   
