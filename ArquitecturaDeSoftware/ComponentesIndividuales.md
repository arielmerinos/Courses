# Componentes individuales
O sea que no haya acoplamientos fuertes entere partes

- Invocación implícita
Cómo comunicarse entre sí sin que sepan las partes de dónde se conoces

Se publican eventos en el bus y éste los notifica a los demás componentes. En el bus hay varios tipos como el bus publicar suscribir, componente inicial y suscrito. Bus orientado a servicios, éste decide a quién notificar, se buscan ESB (Enterprise Service Bus) que tengan componentes que le hablen (proceso en cada caso, particular e implícita entre ellos)-


- Invocación explícita
Se envían mensajes y se conocen entre ellos. Tienen que publicar el tipo de comunicación con el que cuentan. Usualmente se conmunican a un registro cental. Se encuentran durante la ejecución. Se pueden hacer despliegues independientes pero hay que garantizar compatibilidad entre api's