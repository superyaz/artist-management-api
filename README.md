# API REST - Control de Representación de Artistas 🎨🎵

Este repositorio contiene la solución al **Taller 1** de la asignatura **Programación Web** (Calendario 2026-2) del programa de Ingeniería de Sistemas en la *Institución Universitaria Marco Fidel Suárez*. El objetivo principal es el diseño e implementación de una API REST que simula el sistema de control de una agencia de representantes de artistas.

---

## 🚀 Características y Funcionalidades

La API permite gestionar una colección de artistas con sus datos principales y controlar un máximo de 3 tipos de costos por funciones (Familiar, Empresarial e Infantil).

El sistema implementa los siguientes requerimientos y lógica de negocio:
* **Registro de Artistas:** Ruta dedicada para almacenar nuevos artistas en la colección con su Identificación, Nombres y Apellidos, y Género Artístico.
* **Gestión de Costos:** Ruta independiente para registrar y asociar los costos de las funciones a un artista específico.
* **Listado General:** Ruta para visualizar la lista completa de artistas registrados.
* **Búsqueda Individual:** Ruta para consultar la información detallada de un artista mediante su identificador.
* **Cálculo de Tarifas:** Endpoint especializado que calcula el valor total a cobrar por un artista en particular, dado el número de horas contratadas y el tipo de función.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java
* **Framework:** Spring Boot (Spring Web)
* **Persistencia:** Spring Data JPA / Hibernate (o manejo de colecciones en memoria)
* **Pruebas y Documentación:** Postman / Swagger (OpenAPI)
