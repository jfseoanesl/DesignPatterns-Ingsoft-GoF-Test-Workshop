# Taller: costuras y dobles de prueba

Actividad corta de análisis de casos de estudio (**30 minutos**). Cada caso describe una clase de un sistema real, lo que el equipo necesita probar, su diagrama de clases y su código. El objetivo **no** es escribir las pruebas, sino decidir si el diseño las permite y qué haría falta para escribirlas.

## Objetivo

Identificar en código existente las costuras (o su ausencia), seleccionar el doble de prueba adecuado para cada colaborador y escenario, y reconocer cuándo es necesario refactorizar o aplicar un patrón de diseño para que el código sea testeable.

## Casos

| Caso | Título | Clase bajo prueba | Tiempo |
|---|---|---|---|
| 01 | [Simulador de cuota de crédito](casos/caso-01-cuota-credito/README.md) | `SimuladorCredito` | 5 min |
| 02 | [Saludos de cumpleaños a clientes](casos/caso-02-saludos-cumpleanos/README.md) | `ServicioCumpleanos` | 7 min |
| 03 | [Bloqueo de cuentas por intentos fallidos](casos/caso-03-control-accesos/README.md) | `ServicioAutenticacion` | 6 min |
| 04 | [Emisión de certificados académicos](casos/caso-04-certificados-academicos/README.md) | `EmisorCertificados` | 6 min |
| 05 | [Confirmación de compra en una tienda en línea](casos/caso-05-checkout-tienda/README.md) | `ConfirmacionCompra` | 6 min |

Tiempo total sugerido: 30 minutos de análisis + 2 minutos de lectura de esta guía.

## Dinámica

1. Trabaje en parejas. Haga *fork* de este repositorio (o descárguelo).
2. Para cada caso, lea el contexto y los escenarios de prueba, revise el diagrama y el código, y responda las cuatro preguntas.
3. Diligencie el archivo `RESPUESTA.md` de la carpeta de cada caso. Sea breve: una tabla bien diligenciada vale más que un párrafo largo.
4. Entregue mediante un *pull request* al repositorio del curso (o según indique el docente).
5. Reto opcional (fuera de los 30 minutos): escriba una de las pruebas en `src/test/java` y ejecútela con `mvn test`.

## Conceptos de referencia

| Concepto | Definición breve |
|---|---|
| Costura (seam) | Lugar del código donde se puede cambiar el comportamiento sin editarlo en ese lugar (Feathers). En Java, la principal es la **costura de objeto**: la clase depende de una interfaz que se puede sustituir. |
| Punto de habilitación | Lugar donde se decide qué implementación usa la costura: constructor, parámetro de método, setter, fábrica o subclase. |
| Dummy | Se pasa solo para completar la firma; nunca se usa. |
| Stub | Devuelve respuestas preparadas: controla lo que el colaborador entrega a la clase (entradas indirectas). Un *saboteador* simula fallas. |
| Spy | Registra las llamadas que recibe; la prueba las revisa después de actuar (salidas indirectas). |
| Mock | Se programa con expectativas (llamadas, orden, argumentos) y las verifica él mismo. |
| Fake | Implementación funcional y simplificada (por ejemplo, un repositorio en memoria). |

Señales de que **no** hay costura: `new` de colaboradores dentro de los métodos, llamadas a métodos estáticos o Singletons, `LocalDate.now()` / `Math.random()`, clases finales de terceros usadas directamente.

## Evaluación (por caso, 5 puntos)

| Criterio | Puntos |
|---|---|
| Identifica correctamente los colaboradores y si existen costuras (con su punto de habilitación) | 1,5 |
| Selecciona el doble de prueba adecuado para cada colaborador y escenario | 1,5 |
| Decide correctamente si hace falta refactorizar o aplicar un patrón, y cuál | 1,5 |
| Justificación clara y concisa | 0,5 |

## Estructura del repositorio

```text
actividad-costuras-dobles-prueba/
├── README.md                     esta guía
├── casos/caso-NN-<nombre>/
│   ├── README.md                 contexto, escenarios, diagrama, código y preguntas
│   ├── RESPUESTA.md              plantilla de respuesta
│   └── diagrama.puml / .png      diagrama de clases
├── src/main/java/edu/ingsoft/taller/dobles/casoNN/   código de cada caso
├── src/test/java/...            espacio para el reto opcional
└── pom.xml                       Java 17 + JUnit 5
```
