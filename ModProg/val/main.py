import numpy

def run():
    """Anda creando una matriz números del 0-8 y loego los reorganiza de 3 ern 3"""
    A = numpy.arange(9).reshape((3, 3))
    """Aki va a imprimir la matriz A, que tiene valores del 0 al 8, de 3 en 3"""
    print(A)
    """Aquí va a impirmir el resultado de nuestra función"""
    print(rebenale_primera_ultima_col(A))

"""
creamos una función que recibe una matrix_bb, en realidad el nombre no importa
luego regresa un arreglo con sólo la primera y última a columna de la matrix_bb 
0 es la primera columna, -1 es la última columna
Funciona para cualquier matriz dada, no importa si es de 3x3,4x4,..., nxn
"""
def rebenale_primera_ultima_col(matriz_mamalona):
    return matriz_mamalona[:, [0, -1]]





if __name__ == '__main__':
    run()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
