# El caracter (.)
Cada espacio se ocupa por algún caracter (Inclusive el caracter vacío es un caracter, el espacio o algún ascii)


*.*
Va a encontrar cualquier caracter, todo lo que sea caracter, seleccionará cada uno de los caracteres y no la linea completa

# Clases predefinidas y construidad
- Los digitos
\d o [0-9], permite cambiar los rangos de búsqueda

- Las palabras (Icluye el guión bajo) también incluye todos los dígitos.
\w

- Los espacios
(el normal y el tab, también doble espacio) \s


## Escapar caracteres
Sirven para buscar caracteres de manera escencial y no cómo la clase i.e. buscar punto y no todos los caracteres

# Delimitadores
- * Que haya cero o muchos, greedy encontrar TODO haya o no caracter

- + uno o más, incluyente

- ? cero o uno

# Contadores
\d{0,1}
Escribimos la clase o caracter a buscar luego se abren corchetes y se introducen las cotas, inferior y superior.
