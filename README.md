# 2022PCTR_2CBarrioCarlos

## Descripción
Este proyecto es una simulación de un videojuego donde se generan y eliminan enemigos de diferentes tipos utilizando programación concurrente en Java.

## Objetivos
- Crear y manipular hilos en Java.
- Analizar y reflexionar sobre las ejecuciones no deterministas en programación concurrente.
- Aplicar mecanismos dinámicos de sincronización para garantizar la exclusión mutua.
- Conocer mecanismos de preservación de invariantes de los objetos compartidos para evitar estados inconsistentes.
- Comprender problemas adicionales de concurrencia dependiente del estado.
- Aplicar esperas sincronizadas para resolver problemas de dependencias de estado.
- Monitorizar la ejecución de programas concurrentes en Java.

## Estructura del Proyecto
![image](https://github.com/cbr1005/2022PCTR_2CBarrioCarlos/assets/161236233/43360c95-eb72-4b65-9bfd-8590805507b3)



## Instrucciones de Compilación y Ejecución
1. Clonar el repositorio:
git clone https://github.com/cbr1005/2022PCTR_2CBarrioCarlos.git

2. Compilar los archivos Java:
javac -d bin src/simulador_juego/*.java

3. Crear el archivo JAR:
jar cfm juego_simulacion.jar src/META-INF/MANIFEST.MF -C bin .

4. Ejecutar el archivo JAR:
java -jar juego_simulacion.jar


## Dependencias
- JDK 6 o superior
- Eclipse (opcional)

## Ejemplos de Uso
![image](https://github.com/cbr1005/2022PCTR_2CBarrioCarlos/assets/161236233/60e4421c-8449-438b-947c-f9acbc537a7c)
