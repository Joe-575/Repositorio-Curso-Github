# Conceptos Fundamentales de GitHub

## 1. Commit
**Definición:** Un commit es una instantánea de los cambios realizados en el repositorio.

**Aplicación:** Guardar cambios con un mensaje descriptivo.

**Pasos:**
```bash
# 1. Agregar archivos al área de preparación
git add .

# 2. Crear el commit con un mensaje descriptivo
git commit -m "Descripción clara del cambio"

# 3. Ver el historial de commits
git log
```

---

## 2. Branch
**Definición:** Una rama es una línea de desarrollo independiente del código principal.

**Aplicación:** Trabajar en nuevas funcionalidades sin afectar la rama principal.

**Pasos:**
```bash
# 1. Crear una nueva rama
git branch nombre-rama

# 2. Cambiar a la rama
git checkout nombre-rama

# O hacerlo en un solo comando
git checkout -b nombre-rama

# 3. Ver todas las ramas
git branch -a

# 4. Eliminar una rama local
git branch -d nombre-rama
```

---

## 3. Fork
**Definición:** Un fork es una copia completa de un repositorio en tu cuenta de GitHub.

**Aplicación:** Contribuir a proyectos de otros sin permisos de escritura directa.

**Pasos:**
```bash
# 1. Hacer clic en "Fork" en GitHub (interfaz web)
# 2. Clonar el fork en tu máquina
git clone https://github.com/tu-usuario/repositorio.git

# 3. Agregar el upstream (repositorio original)
git remote add upstream https://github.com/usuario-original/repositorio.git

# 4. Ver los remotes configurados
git remote -v
```

---

## 4. Pull Request (PR)
**Definición:** Una solicitud para fusionar cambios de una rama a otra.

**Aplicación:** Proponer cambios y permitir revisión de código antes de fusionar.

**Pasos:**
```bash
# 1. Hacer cambios y commit en tu rama
git add .
git commit -m "Descripción del cambio"

# 2. Enviar los cambios al repositorio remoto
git push origin nombre-rama

# 3. En GitHub, hacer clic en "Compare & pull request"
# 4. Completar el título y descripción del PR
# 5. Los colaboradores revisan y hacen merge si es aprobado
```

---

## 5. Remote
**Definición:** Una referencia a un repositorio alojado en un servidor remoto.

**Aplicación:** Conectar tu repositorio local con versiones en línea.

**Pasos:**
```bash
# 1. Ver todos los remotes
git remote -v

# 2. Agregar un nuevo remote
git remote add nombre-remoto https://github.com/usuario/repositorio.git

# 3. Cambiar la URL de un remote
git remote set-url nombre-remoto nueva-url

# 4. Eliminar un remote
git remote remove nombre-remoto

# 5. Ver información detallada
git remote show nombre-remoto
```

---

## 6. Origin
**Definición:** El nombre predeterminado del repositorio remoto principal (usualmente en GitHub).

**Aplicación:** Referencia automática al repositorio clonado.

**Pasos:**
```bash
# 1. Ver el remote origin
git remote -v

# 2. Cambiar la URL de origin
git remote set-url origin https://github.com/usuario/nuevo-repositorio.git

# 3. Enviar cambios a origin
git push origin nombre-rama

# 4. Traer cambios desde origin
git pull origin nombre-rama
```

---

## 7. Upstream
**Definición:** El repositorio original del cual fue hecho el fork.

**Aplicación:** Mantener sincronizado tu fork con el proyecto principal.

**Pasos:**
```bash
# 1. Agregar upstream (después de hacer fork)
git remote add upstream https://github.com/usuario-original/repositorio.git

# 2. Verificar que fue agregado
git remote -v

# 3. Traer cambios del upstream
git fetch upstream

# 4. Fusionar cambios del upstream a tu rama local
git merge upstream/main

# 5. En una sola línea
git pull upstream main
```

---

## 8. Push
**Definición:** Enviar commits locales al repositorio remoto.

**Aplicación:** Compartir cambios con el equipo en GitHub.

**Pasos:**
```bash
# 1. Push a la rama actual
git push origin nombre-rama

# 2. Push forzado (usar con cuidado)
git push origin nombre-rama --force

# 3. Push de todas las ramas
git push origin --all

# 4. Push de todas las etiquetas
git push origin --tags

# 5. Configurar rama por defecto para push
git push --set-upstream origin nombre-rama
```

---

## 9. Fetch
**Definición:** Descargar cambios del repositorio remoto sin fusionarlos automáticamente.

**Aplicación:** Revisar cambios antes de integrarlos en tu trabajo local.

**Pasos:**
```bash
# 1. Traer cambios de origin
git fetch origin

# 2. Traer cambios de upstream
git fetch upstream

# 3. Traer cambios de todas las ramas
git fetch --all

# 4. Ver diferencias después de fetch
git diff origin/main main

# 5. Fusionar después de revisar
git merge origin/main
```

---

## 10. Stash
**Definición:** Almacenar temporalmente cambios sin hacer commit.

**Aplicación:** Cambiar de rama sin perder cambios en progreso.

**Pasos:**
```bash
# 1. Guardar cambios en el stash
git stash

# 2. Guardar con un mensaje descriptivo
git stash save "descripción del cambio"

# 3. Ver lista de stash
git stash list

# 4. Recuperar el último stash
git stash pop

# 5. Recuperar un stash específico
git stash apply stash@{0}

# 6. Eliminar un stash
git stash drop stash@{0}

# 7. Eliminar todos los stash
git stash clear
```

---

## 11. Submodule
**Definición:** Un repositorio Git dentro de otro repositorio.

**Aplicación:** Incluir dependencias externas manteniendo versionado independiente.

**Pasos:**
```bash
# 1. Agregar un submodule
git submodule add https://github.com/usuario/repositorio.git ruta/local

# 2. Clonar un repositorio con submodules
git clone --recurse-submodules https://github.com/usuario/repositorio.git

# 3. Si ya clonaste sin submodules, inicializarlos
git submodule init
git submodule update

# 4. Actualizar submodules a la última versión
git submodule update --remote

# 5. Entrar al directorio del submodule
cd ruta/local
git checkout main
cd ..

# 6. Eliminar un submodule
git rm --cached ruta/local
rm -rf ruta/local
```

---

## 12. Merge
**Definición:** Fusionar cambios de una rama a otra.

**Aplicación:** Integrar nuevas funcionalidades o fixes a la rama principal.

**Pasos:**
```bash
# 1. Cambiar a la rama destino (generalmente main)
git checkout main

# 2. Fusionar la rama de origen
git merge nombre-rama

# 3. En caso de conflictos, resolver manualmente
# Editar los archivos con conflicto

# 4. Marcar como resueltos
git add archivo-resuelto.txt

# 5. Completar el merge
git commit -m "Merge de nombre-rama a main"

# 6. Merge sin crear commit de fusión (squash)
git merge --squash nombre-rama
```

---

## 13. Rebase
**Definición:** Re-aplicar commits en una rama diferente.

**Aplicación:** Mantener un historial lineal y limpio.

**Pasos:**
```bash
# 1. Cambiar a la rama que quieres actualizar
git checkout feature-branch

# 2. Rebase sobre main
git rebase main

# 3. En caso de conflictos, resolverlos y continuar
git add archivo-resuelto.txt
git rebase --continue

# 4. Si necesitas abortar el rebase
git rebase --abort

# 5. Fuerza el push después de un rebase (cuidado)
git push origin feature-branch --force
```

---

## 14. Tag
**Definición:** Marcar puntos específicos del historio como versiones.

**Aplicación:** Crear releases y versiones del proyecto.

**Pasos:**
```bash
# 1. Crear un tag anotado
git tag -a v1.0.0 -m "Versión 1.0.0"

# 2. Crear un tag ligero
git tag v1.0.0

# 3. Listar todos los tags
git tag -l

# 4. Ver detalles de un tag
git show v1.0.0

# 5. Enviar un tag específico
git push origin v1.0.0

# 6. Enviar todos los tags
git push origin --tags

# 7. Eliminar un tag local
git tag -d v1.0.0

# 8. Eliminar un tag remoto
git push origin :v1.0.0
```

---

## 15. Cherry-pick
**Definición:** Aplicar commits específicos de una rama a otra.

**Aplicación:** Traer fixes importantes sin fusionar toda la rama.

**Pasos:**
```bash
# 1. Ver el hash del commit que deseas
git log rama-origen

# 2. Cambiar a la rama destino
git checkout main

# 3. Aplicar el commit específico
git cherry-pick hash-del-commit

# 4. Cherry-pick múltiples commits
git cherry-pick hash1 hash2 hash3

# 5. Rango de commits
git cherry-pick hash-inicio..hash-fin

# 6. En caso de conflictos, resolverlos
git add archivo-resuelto.txt
git cherry-pick --continue
```

---

## Flujo de Trabajo Típico

1. **Crear una rama**: `git checkout -b nueva-funcionalidad`
2. **Hacer cambios y commits**: `git add .` → `git commit -m "mensaje"`
3. **Enviar cambios**: `git push origin nueva-funcionalidad`
4. **Crear PR en GitHub**: Comparar y solicitar revisión
5. **Hacer merge**: Una vez aprobado, fusionar a main
6. **Actualizar local**: `git pull origin main`

---

## Tips Importantes

- **Siempre sincroniza**: `git pull` antes de empezar a trabajar
- **Commits atómicos**: Un commit = una funcionalidad o fix
- **Mensajes claros**: Describe qué cambió y por qué
- **Protege main**: Usa políticas de protección de ramas
- **Code review**: Siempre revisa antes de hacer merge
