# Programación Orientada en Objetos

## 📌 Información General

- **Título:**  Diseño de una interfaz gráfica de usuario básica utilizando contenedores y componentes gráficos de Java AWT
- **Carrera:** Computación
- **Estudiantes:** Diana Borja y Keyra Carvajal
- **Fecha:** 25/05/2025
- **Profesor:** PhD. Gabriel Alejandro León Paredes

---

## 🛠️ Descripción
Este proyecto consiste en el desarrollo de un sistema ERP (Enterprise Resource Planning) simplificado, orientado a la gestión de compras empresariales, implementado en Java utilizando el paradigma de Programación Orientada a Objetos (POO) y con interfaces gráficas desarrolladas con Java AWT.

El objetivo principal del sistema es brindar una solución estructurada y modular que permita registrar, consultar y administrar entidades clave como:

Proveedores: Permite ingresar sus datos de contacto y tipo de contribuyente.

Productos: Asociados a un proveedor, cada producto incluye ID, nombre y precio.

Empleados: Almacenados con información personal y asignados a un departamento.

Solicitudes de compra: Generadas con fecha, estado y observaciones. Se pueden buscar y actualizar.

Detalles de solicitud: Se agregan productos con cantidades específicas, y el sistema calcula el subtotal, IVA, descuentos y total general.

💡 Características destacadas:
Aplicación modular dividida en model y view, siguiendo una estructura limpia y escalable.

Uso de clases, herencia, enums y listas dinámicas para manejar datos.

Interfaces visuales intuitivas y funcionales basadas en Frame, Panel, TextField, Choice, Button y TextArea.

Interacción entre módulos mediante listas compartidas pasadas como parámetros.

Validaciones para ingreso de datos numéricos y campos obligatorios.

Mensajes emergentes con Dialog para feedback al usuario.

Choice dinámico para listar proveedores o departamentos existentes.

Diseño inspirado en sistemas empresariales reales, pero ajustado para fines educativos.

---

# 💻 Tecnologías Utilizadas
- Java 24

- IntelliJ IDEA

- Programación Orientada a Objetos (POO)

- Estructuras de control (for, do-while, switch)

- Listas dinámicas (ArrayList)

---


## 🚀 Ejecución

Para ejecutar el proyecto en IntelliJ IDEA:

1. Abre el proyecto en IntelliJ IDEA.

2. Asegúrate de que el archivo Main.java esté configurado como clase principal.

3. Haz clic derecho sobre Main.java y selecciona Run 'Main.main()', o utiliza el botón verde ▶️ en la parte superior.

4. El programa se compilará y ejecutará automáticamente, mostrando el menú de opciones en la consola.

---

## 🧑‍💻 Ejemplo de Entrada

El usuario ejecuta el archivo .java correspondiente al main o inicia desde la clase VentanaPrincipal.

Se abre la ventana "SISTEMA DE GESTIÓN ERP" con un panel central de botones.

Este proyecto es una aplicación Java con interfaz gráfica (AWT) que gestiona:
- Empleados
- Proveedores
- Productos
- Solicitudes de compra
- Detalles de solicitud

Registro de un proveedor:

El usuario hace clic en el botón "Proveedores".

Se abre la ventana de gestión de proveedores.

Selecciona "Registrar Proveedor".

Ingresa los datos:

ID: 1001

Nombre: Logitech

Correo: ventas@logitech.com

Teléfono: 0991234567

Tipo de contribuyente: Sociedad Anónima

Clic en Registrar → aparece mensaje de confirmación.

Registro de un producto:

Regresa al menú principal y accede a "Productos".

Selecciona "Registrar Producto".

Ingresa:

ID: 2001

Nombre: Mouse inalámbrico

Precio: 25.50

Proveedor: Logitech (seleccionado del Choice)

Clic en Registrar → mensaje de éxito.

Registro de un empleado:

Clic en "Empleados".

Escoge "Registrar Empleado".

Datos:

ID: 3001

Nombre: Laura Torres

Correo: l.torres@empresa.com

Teléfono: 0987654321

Departamento: Compras

Cargo: Analista

Clic en Registrar → registro exitoso.

Ingreso de una solicitud de compra:

Clic en "Solicitudes de Compra".

Opción: "Registrar Solicitud".

Datos:

ID: 4001

Fecha: (autoasignada)

Estado: SOLICITADO (auto)

Observaciones: Compra urgente para nuevo proyecto.

Clic en Registrar → confirmación.

Cálculo del detalle de la solicitud:

Vuelve al menú principal y elige "Detalles".

Se abre ventana para seleccionar producto y cantidad.

Elige Mouse inalámbrico, cantidad 10.

Clic en Agregar.

Luego clic en "Calcular Totales".

Se muestran:

Subtotal: $255.00

Descuento (si aplica)

IVA (calculado automáticamente)

Total final

Cierre del sistema:

Clic en botón "Salir" desde el menú principal.

Se cierra la aplicación.
