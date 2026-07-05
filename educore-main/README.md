EDUCORE
 
  Es el desarrollar un sistema informático en lenguaje Java, con arquitectura MVC (Modelo-Vista-Controlador), para administrar los módulos de Empleados y Gestión Académica de una institución educativa. El proyecto cumple con los lineamientos de estructura, control de versiones y documentación establecidos en el enunciado.
 
 
 
 ESTRUCTURA DEL PROYECTO
 
plaintext
  
educore-main/
├── src/main/java/edu/core/
│   ├── model/          # Clases de datos y lógica básica
│   ├── repository/      # Gestión y almacenamiento de información
│   ├── controller/     # Control de flujo y operaciones
│   └── view/           # Interfaz y menús para el usuario
├── documentos/          # Documentación oficial
│   ├── enunciado-p1.md
│   ├── enunciado-p1.pdf
│   └── Entrega-Proyecto1.pdf
├── .gitignore          # Archivos excluidos del repositorio
├── pom.xml             # Configuración de Maven y dependencias
└── LÉAME.md            # Este archivo
 
 

 
1. MÓDULO DE EMPLEADOS
 
- Clases principales:  Empleado.java ,  TipoEmpleado.java 
- Funcionalidades:
- Registro, modificación y eliminación de empleados
- Clasificación por tipo: administrativo, docente, personal de servicio
- Almacenamiento de datos: cédula, nombre completo, fecha de ingreso, estado civil, salario
- Validaciones de campos obligatorios y formatos correctos
 
2. MÓDULO DE GESTIÓN ACADÉMICA
 
- Clases principales:  Edificio.java ,  Aula.java ,  Seccion.java 
- Funcionalidades:
- Registro y administración de edificios institucionales
- Definición de aulas: capacidad, tipo de uso y ubicación
- Creación y gestión de secciones académicas
- Asignación de secciones a aulas disponibles
 
 
 
 TECNOLOGÍAS UTILIZADAS
 
- Lenguaje de programación: Java SE
- Arquitectura: Modelo-Vista-Controlador (MVC)
- Gestión de dependencias: Apache Maven
- Control de versiones: Git y plataforma GitHub
- Entorno de desarrollo: Apache NetBeans
 
 
 
 REQUISITOS CUMPLIDOS
 
 Código fuente estructurado según el patrón MVC
 Módulos de Empleados y Académico funcionales
 Validaciones de datos implementadas
 Documentación completa en carpeta  documentos/ 
 Repositorio compartido con el profesor como colaborador
 Versión oficial marcada con etiqueta  v1.0-p1 
Cumplimiento de todos los puntos del enunciado y rúbrica
 
 
 
 CÓMO EJECUTAR EL PROYECTO
 
1. Clonar el repositorio:  git clone https://github.com/[tu-usuario]/educore-main.git 
2. Abrir la carpeta en NetBeans o tu entorno de desarrollo preferido
3. Esperar a que Maven descargue las dependencias
4. Ejecutar la clase principal desde la carpeta  view/ 
 
 
 



