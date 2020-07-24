# Comparando los estilos

Separando estilos monolíticos (un sólo artefacto) y distribuidos (desplique individual).

- Individual
Se puede controlar cuáles son las llamadas a procesos, no hay que hacer comunicación por internet. Facilidad de teseteo. Tiene toda la información en un lugar, i.e. todas las piezas. La curva de aprendizaje es más sencilla.

- Distribuidos
Para hacer una prueba hay que tener todos los componentes y un bus compatible.
Habrá que entender cada uno de los componentes para examinar el proyecto.
Es más facil aprender a trabajar en microservicios. Tenemos diferentes versiones independientes en cada uno de los componentes, es dificil hacer llegar una nueva versión.
Es más fácil modularizar por la naturaleza del estilo.
Tiene más disponibilidad que el estilo monolítico, además es más barato cuando se trata de escalar algún componente en específico y es más fácil de adaptar.

