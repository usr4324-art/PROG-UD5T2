# RipAdbaisor - Sistema de Ranking Turístico

## Descripción del Proyecto

RipAdbaisor es una aplicación de escritorio desarrollada en Java para la gestión de valoraciones de destinos turísticos. El proyecto nace como una solución para la empresa pionera en el sector de la hostelería que busca competir con grandes referentes como GulúGulú.

La aplicación permite gestionar un ranking de elementos (hoteles, playas, restaurantes) mediante un sistema de puntuación del 1 al 5, ofreciendo una interfaz amigable basada en la librería **Swing**.

## Objetivos de la Práctica
* Implementar un **CRUD** completo (Create, Read, Update, Delete) en memoria.
* Aplicar el control de versiones con **Git**, siguiendo un flujo de trabajo basado en ramas (`main` y `development`).
* Modularizar el código utilizando clases de utilidad y métodos estáticos.
* Gestionar excepciones para asegurar la robustez del programa frente a entradas de usuario inválidas.

## Requisitos Funcionales Implementados
- [x] **Clase Elemento:** Atributos de nombre, país, tipo y puntuación.
- [x] **Interfaz Gráfica:** Uso de `JOptionPane` para la interacción.
- [x] **Validación:** Clase `Utils` para control de tipos y rangos de datos.
- [x] **Persistencia Volátil:** Uso de `ArrayList` para el almacenamiento en tiempo de ejecución.
- [x] **Ranking:** Visualización de elementos ordenados de mayor a menor puntuación.

## Manual de Usuario 

Al ejecutar la aplicación, se desplegará un menú principal con las siguientes opciones:

1.  **Añadir:** Permite registrar un nuevo destino introduciendo su nombre, ubicación, categoría y puntuación.
2.  **Editar:** Busca un destino por nombre y permite actualizar cualquiera de sus campos (incluyendo la valoración).
3.  **Mostrar:** Genera un listado de todos los destinos almacenados, ordenados automáticamente por estrellas (5★ primero).
4.  **Eliminar:** Borra permanentemente un registro de la lista mediante la búsqueda de su nombre.
5.  **Salir:** Finaliza la ejecución de forma segura.

> **Nota:** La aplicación no guarda datos entre ejecuciones. Al cerrar el programa, la lista se reiniciará.