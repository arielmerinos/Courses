# Flujo de datos

- Lote secuencial
Ejecutar todo en un sólo loto y darlo como salida totalmente procesado
e.g. procesamiento de archivos, un aplicación que se encarga de ello.

Generalmente se necesita la aprobación del usuario para comenzar otro proceso.


- Tubos y filtros.
Hay un flujo donde se va atribuyendo, los resultados y salidas.

Aplicaciones conectadas en tiempo real. En linux podemos usar grep, sed, wc. Todos en el mismo proceso, está compuesta de partes separadas


Input > grep > sed > wc

Como una tubería, permite construir nuevas funcionalidades de manera más sencilla.