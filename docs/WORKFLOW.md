# Guía de Flujo de Trabajo (Workflow & Git Standards)

Este documento define las reglas de colaboración para el equipo. Todos los integrantes deben seguir este ciclo de vida para garantizar entregas estables sin romper el proyecto.

---

## Estrategia de Ramas (Git Branching)

El proyecto utiliza una variante aislada de **Git Flow**:

* **`main`**: Código de versión final de cada iteración.
* **`feature/<modulo>-<descripcion-corta>`**: Ramas individuales para cada Issue atómica.

### Lista de Ramas Personalizadas Generadas por Módulo

Al iniciar una Issue, crea tu rama local con la nomenglatura dictada en la issue

## Ciclo de Vida de una Issue (Paso a Paso)
### 1. Seleccionar la Issue en GitHub Projects
1. Entra al **[Tablero del Proyecto](https://github.com/users/Not-Abad/projects/3)**.
2. Ve a la columna **Backlog**.
3. Haz clic en la Issue que vas a desarrollar y en el panel lateral derecho asigna tu usuario en **Assignees**.
4. Mueve la tarjeta a la columna **In Progress**.

---

### 2. Crear la Rama en tu entorno local
Abre Git Bash o tu terminal en la carpeta del proyecto y ejecuta:

# 2.1. Asegúrate de tener lo último de main
    git checkout main
    git pull origin main

# 2.2. Crea y cámbiate a tu nueva rama de feature
    git checkout -b feature/"nombre de tu tarea"

# 2.3. Desarrollar y realizar Commits atómicos
Trabaja únicamente en los archivos de tu módulo. Realiza commits claros con mensajes descriptivos:

    git add .
    git commit -m "feat(enemies): implementar reajuste visual"

# 2.4. Subir la rama y abrir Pull Request (PR)
Cuando completes los Criterios de Aceptación de la Issue:
    git push origin feature/"nombre de tu rama"

    2.4.1. Ve a GitHub y haz clic en Compare & pull request.
    2.4.2. IMPORTANTE: Asegúrate de que la rama base sea main.
    2.4.3. En la descripción del Pull Request, vincula la Issue usando la palabra clave Closes # o Fixes # seguida del número de la Issue:
        ### Descripción del cambio
        Se implementó el ajuste al archivo java swing para mejorar visuales.
        Closes #8
    2.4.5. Pide revisión a un compañero

# 2.5. Finalizar la Issue
Una vez revisado y aprobado el Pull Request:
Se realiza el Merge a la rama main.
La Issue se cerrará automáticamente y la tarjeta del tablero pasará a Done.
Elimina tu rama remota y local para mantener limpio el repositorio:

    git checkout main
    git pull origin main
    git branch -d feature/"nombre de tu rama"
