### Sebastián Camilo Villamarín Rodríguez
### Daniel Alejandro Varón Rojas
## AeroDescuentos

Se está desarrollando para una aerolínea su módulo de liquidación de tiquetes aéreos. Para el mismo, se tiene una función que aplica descuentos a la tarifa base del vuelo dependiendo del tiempo de antelación de la reserva y la edad del pasajero. Los descuentos SON ACUMULABLES.

Normativa 005, sobre los descuentos:

- 15% de descuento sacando el billete con antelación superior a 20 días.
- 5% a los pasajeros con edad inferior a 18 años y 8% a los pasajeros con edad superior a 65 años.

La siguiente es la especificación de la función que se usará en el módulo del cálculo de los descuentos:
~~~
/**
calcular la tarifa de cada billete según el trayecto, la antelación en la que se obtiene el billete y la edad del pasajero, de acuerdo con la normativa 005.
@param tarifaBase valor base del vuelo
@param diasAntelacion dias de antelación del vuelo
@param edad - edad del pasajero
@throws ExcepcionParametrosInvalidos [“PRECIO NEGATIVO”, “NUMERO DE DIAS NEGATIVO”, “EDAD INVALIDA”]
**/

public long calculoTarifa(long tarifaBase, int diasAntelacion, int edad)
~~~

**1.** De acuerdo con lo indicado, y teniendo en cuenta que NO hay precondiciones, en qué casos se debería arrojar una excepción de tipo ExcepcionParametrosInvalidos?. Agregue esto a la especificación.

Se debería arrojar una excepción cuando se ingrese una tarifa base negativa, un número de días de anticipación negativo y una edad menor a 0 o mayor a 150.

**2.** En la siguiente tabla enumere un conjunto de clases de equivalencia que -según usted- creen una buena división del conjunto de datos de entrada de la función anterior:

| Número | Clase de equivalencia (en lenguaje natural o matemático) | Resultado correcto / incorrecto |
| -- | -- | -- |
| 1 | tarifaBase < 0 | Incorrecto, precio negativo |
| 2 | tarifaBase ≥ 0 | Correcto, precio valido |
| 3 | diasAntelacion < 0 | Incorrecto, número de días negativos |
| 4 | díasAntelacion ≥ 0 | Correcto, número de días valido |
| 5 | 0 ≤ edad ≤ 150 | Correcto, edad valida |
| 6 | edad < 0 ó 150 < edad | Incorrecto, edad invalida |


**3.** Para cada clase de equivalencia, defina un caso de prueba específico, definiendo: parámetros de entrada y resultados esperados.
Casos:

1.	calculoTarifa(-10, 12, 9) 			***PRECIO NEGATIVO***
2.	calculoTarifa(0, 12, 9)				***tarifa 0 (descuento menor de edad)***
3.	calculoTarifa(12, -2, 12)			***NUMERO DE DIAS NEGATIVO***
4.	calculoTarifa(10, 0, 12)			***tarifa 9.5 (descuento menor de edad)***
5.	calculoTarifa(20, 21, 0)			***tarifa 17 (descuento más de 20 días)***
6.	calculoTarifa(20, 12, 66)			***tarifa 18.4 (descuento tercera edad)***
7.	calculoTarifa(40, 20, 151) 			***EDAD INVALIDA***
8.	calculoTarifa(40, 20, -1) 			***EDAD INVALIDA***

**4.** A partir de las clases de equivalencia identificadas en el punto 2, identifique las condiciones límite o de frontera de las mismas.
Las condiciones de limite o frontera son:

1.	La edad debe estar entre 0 y 150 años.
2.	La tarifa debe ser positiva o 0.
3.	El número de días anticipados de compra de tiquete deben ser positivos o 0.

**5.** Para cada una de las condiciones de frontera anteriores, defina casos de prueba específicos.

1.	calculoTarifa(-1, 12, 9) 			***PRECIO NEGATIVO***
2.	calculoTarifa(12, -1, 12)			***NUMERO DE DIAS NEGATIVO***
3.	calculoTarifa(40, 20, 151) 			***EDAD INVALIDA***
4.	calculoTarifa(40, 20, -1) 			***EDAD INVALIDA***
