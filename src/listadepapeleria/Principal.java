package listadepapeleria;

import dao.Conexion;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import modelo.AdminRolDB;
import modelo.Rol;
import modelo.AdminOperacionDB;
import modelo.Operacion;
import modelo.AdminPersonaDB;
import modelo.Persona;
import modelo.AdminArticuloDB;
import modelo.Articulo;
import modelo.AdminMovimientoDB;
import modelo.Movimiento;
import modelo.RelacionesDB;
import modelo.ArticuloOrdenadoFecha;
import modelo.OperacionArticulo;
import modelo.InventarioArticulo;
import modelo.ListaArticulo;
import modelo.AdministrarInventarioArticulo;
import modelo.BalanceGeneral;
import modelo.BalanceTotalizado;
import vistas.FrmDiagLogin;

public class Principal {

    public static void main(String[] args) {
        FrmDiagLogin objFrmDiagLogin = new FrmDiagLogin(null,true);
        objFrmDiagLogin.setLocationRelativeTo(null);
        objFrmDiagLogin.setVisible(true);
        //*********** Clases Administradoras **********//
       /* AdminRolDB objAdmRolDB = new AdminRolDB();
        AdminOperacionDB objAdmOperacionDB = new AdminOperacionDB();
        AdminPersonaDB objAdmPersonaDB = new AdminPersonaDB();
        AdminArticuloDB objAdmArticuloDB = new AdminArticuloDB();
        AdminMovimientoDB objAdmMovimientoDB = new AdminMovimientoDB();*/
        //--------------------------------------------//

        //********** Variables Lectoras de consola ********//
      /*  Scanner leerOpcion = new Scanner(System.in);
        Scanner leerTexto = new Scanner(System.in);
        Scanner leerNumero = new Scanner(System.in);*/
        //-------------------------------------------------//

        //********** Otras Variales **********//          
        /*String opcion = "",
                    opcionRol = "",
                    opcionPersona = "",
                    opcionArticulo = "",
                    opcionOperacion = "",
                    opcionMovimiento = "",
                    opcionReportes = "";
        //------------------------------------------------//        
        boolean salir = false,
                    salirRol = false,
                    salirPersona = false,
                    salirArticulo = false,
                    salirOperacion = false,
                    salirMovimiento = false,
                    salirReportes = false;
        //------------------------------------------------//

        while (!salir) {
            opcion = "";
            System.out.println("\n---- MENÚ PRINCIPAL ----\n");
            System.out.println("1. Administrar Rol");
            System.out.println("2. Administrar Persona");
            System.out.println("3. Administrar Artículo");
            System.out.println("4. Administrar Operacion");
            System.out.println("5. Administrar Movimiento");
            System.out.println("6. Reportes");
            System.out.println("7. Salir");
            System.out.print("\nIngrese opción: ");
            opcion = leerOpcion.nextLine();

            switch (opcion) {
                case "1"://1. Administrar rol
                    while (!salirRol) {
                        opcionRol = "";
                        System.out.println("\n---- ADMINISTRAR ROL ----\n");
                        System.out.println("1. Agregar rol");
                        System.out.println("2. Mostrar todo los roles");
                        System.out.println("3. Mostrar un solo rol");
                        System.out.println("4. Actualizar rol");
                        System.out.println("5. Eliminar rol");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionRol = leerOpcion.nextLine();

                        switch (opcionRol) {
                            case "1":  //1. Agregar Rol
                                System.out.println("\n|=========> Insertar Rol <==========|\n");

                                Rol objRol = new Rol();

                                System.out.print("\nIngrese el nombre del rol: ");
                                objRol.setRol(leerTexto.nextLine());

                                objAdmRolDB.insertar(objRol);
                                break;
                            case "2": //2. Mostrar todos los roles:
                                System.out.println("\n|=========> Listar Roles <==========|\n");

                                for (Object obj : objAdmRolDB.listarTodo()) {
                                    Rol objRol1 = (Rol) obj;
                                    System.out.println(objRol1);
                                }
                                break;
                            case "3": //3. Mostrar un solo rol:
                                System.out.println("\n|=========> Leer Rol <==========|\n");

                                Rol objRol2 = new Rol();

                                System.out.print("Ingrese el id del rol: ");
                                objRol2.setIdrol(leerNumero.nextInt());

                                objAdmRolDB.listarUno(objRol2);

                                System.out.println(objRol2);
                                break;
                            case "4": // Actualizar una rol:
                                System.out.println("\n|=========> Actualizar Rol <==========|\n");

                                Rol objRol3 = new Rol();

                                System.out.print("Digite el id del rol a actualizar: ");
                                objRol3.setIdrol(leerNumero.nextInt());

                                // Buscar el rol en la base de datos
                                objRol3 = (Rol) objAdmRolDB.listarUno(objRol3);

                                if (objRol3.getIdrol() == 0) {
                                    System.out.println("El rol no existe.");
                                } else {
                                    // Mostrar información del rol antes de actualizar
                                    System.out.println("Rol actual:");
                                    System.out.println("ID: " + objRol3.getIdrol());
                                    System.out.println("Rol: " + objRol3.getRol());

                                    // Pedir al usuario el nuevo valor del rol
                                    System.out.print("Digite el nombre del rol: ");
                                    String nuevoRol = leerNumero.next();

                                    // Actualizar el rol en la base de datos
                                    objRol3.setRol(nuevoRol);
                                    if (objAdmRolDB.actualizar(objRol3)) {
                                        System.out.println("Rol actualizado exitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar el rol.");
                                    }
                                }
                                break;
                            case "5":  //5. Eliminar un Rol:
                                System.out.println("\n|=========> Eliminar Rol <==========|\n");

                                Rol objRol4 = new Rol();

                                System.out.print("\nIngrese el id del rol: ");
                                objRol4.setIdrol(leerNumero.nextInt());

                                if (objAdmRolDB.eliminar(objRol4)) {
                                    System.out.println("El rol se eliminó con exito.");
                                } else {
                                    System.out.println("Error al eliminar el rol.");
                                }
                                break;
                            case "6": //6. Salir
                                salirRol = true;
                                break;
                            default:
                                System.out.println("\nRol - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirRol = false;
                    break;
                case "2"://2. Administrar Persona

                    while (!salirPersona) {
                        opcionPersona = "";
                        System.out.println("\n---- ADMINISTRAR PERSONA ----\n");
                        System.out.println("1. Agregar persona");
                        System.out.println("2. Mostrar todas las personas");
                        System.out.println("3. Mostrar una sola persona");
                        System.out.println("4. Actualizar persona");
                        System.out.println("5. Eliminar persona");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionPersona = leerOpcion.nextLine();

                        switch (opcionPersona) {
                            case "1":  //1. Agregar Persona

                                Persona objPersona = new Persona();
                                System.out.println("\n|=========> Insertar Persona <==========|\n");

                                System.out.print("\nIngrese la identificación de la persona: ");
                                objPersona.setIdentificacion(leerTexto.nextLine());

                                System.out.print("\nIngrese el nombre de la persona: ");
                                objPersona.setNombre(leerTexto.nextLine());

                                System.out.print("\nIngrese el apellido de la persona: ");
                                objPersona.setApellido(leerTexto.nextLine());

                                System.out.print("\nIngrese la clave de la persona: ");
                                objPersona.setClave(leerTexto.nextLine());

                                System.out.print("\nIngrese el rol de la persona: ");
                                objPersona.setRol_idrol(leerNumero.nextInt());

                                objAdmPersonaDB.insertar(objPersona);
                                break;
                            case "2": //2. Mostrar todas las personas:
                                System.out.println("\n|=========> Listar Personas <==========|\n");

                                for (Object obj : objAdmPersonaDB.listarTodo()) {
                                    Persona objPersona1 = (Persona) obj;
                                    System.out.println(objPersona1);
                                }
                                break;
                            case "3": //3. Mostrar una sola persona:
                                System.out.println("\n|=========> Leer persona <==========|\n");

                                Persona objPersona2 = new Persona();

                                System.out.print("Ingrese el id de la persona: ");
                                objPersona2.setIdpersona(leerNumero.nextInt());

                                objAdmPersonaDB.listarUno(objPersona2);

                                System.out.println(objPersona2);
                                break;
                            case "4":  //4. Actualizar una persona:
                                System.out.println("\n|=========> Actualizar Persona <==========|\n");

                                Persona objPersona3 = new Persona();

                                System.out.print("Digite el id de la persona a actualizar: ");
                                objPersona3.setIdpersona(leerNumero.nextInt());

                                // Buscar a la persona en la base de datos
                                objPersona3 = (Persona) objAdmPersonaDB.listarUno(objPersona3);

                                if (objPersona3.getIdpersona() == 0) {
                                    System.out.println("La persona no existe.");
                                } else {
                                    // Mostrar información de la persona antes de actualizar
                                    System.out.println("Persona actual:");
                                    System.out.println("ID: " + objPersona3.getIdpersona());
                                    System.out.println("Identificacion: " + objPersona3.getIdentificacion());
                                    System.out.println("Nombre: " + objPersona3.getNombre());
                                    System.out.println("Apellido: " + objPersona3.getApellido());
                                    System.out.println("Clave: " + objPersona3.getClave());
                                    System.out.println("Rol_idrol: " + objPersona3.getRol_idrol());

                                    // Pedir al usuario el nuevo valor del rol
                                    System.out.print("Digite la nueva identificación de la persona: ");
                                    String nuevoPersona = leerNumero.next();

                                    // Pedir al usuario el nuevo nombre de la persona
                                    System.out.print("Digite el nuevo nombre de la persona: ");
                                    String nuevoPersona1 = leerNumero.next();

                                    // Pedir al usuario el nuevo apellido de la persona
                                    System.out.print("Digite el nuevo apellido de la persona: ");
                                    String nuevoPersona2 = leerNumero.next();

                                    // Pedir al usuario la nueva clave de la persona
                                    System.out.print("Digite la nueva clave de la persona: ");
                                    String nuevoPersona3 = leerNumero.next();

                                    // Pedir al usuario el nuevo rol de la persona
                                    System.out.print("Digite el nuevo rol de la persona: ");
                                    Integer nuevoPersona4 = leerNumero.nextInt();

                                    // Actualizar la persona en la base de datos
                                    objPersona3.setIdentificacion(nuevoPersona);
                                    objPersona3.setNombre(nuevoPersona1);
                                    objPersona3.setApellido(nuevoPersona2);
                                    objPersona3.setClave(nuevoPersona3);
                                    objPersona3.setRol_idrol(nuevoPersona4);

                                    if (objAdmPersonaDB.actualizar(objPersona3)) {
                                        System.out.println("Persona actualizada éxitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar la persona.");
                                    }
                                }
                                break;
                            case "5":  //5. Eliminar una perosna:
                                System.out.println("\n|=========> Eliminar Persona <==========|\n");

                                Persona objPersona4 = new Persona();

                                System.out.print("\nIngrese el id de la persona: ");
                                objPersona4.setIdpersona(leerNumero.nextInt());

                                if (objAdmPersonaDB.eliminar(objPersona4)) {
                                    System.out.println("La persona se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar la persona.");
                                }
                                break;
                            case "6": //6. Salir
                                salirPersona = true;
                                break;
                            default:
                                System.out.println("\nPersona - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirPersona = false;
                    break;
                case "3"://3. Administrar Artículo

                    while (!salirArticulo) {
                        opcionArticulo = "";
                        System.out.println("\n---- ADMINISTRAR ARTICULO ----\n");
                        System.out.println("1. Agregar artículo");
                        System.out.println("2. Mostrar todas los artículos");
                        System.out.println("3. Mostrar un artículo");
                        System.out.println("4. Actualizar artículo");
                        System.out.println("5. Eliminar artículo");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionArticulo = leerOpcion.nextLine();

                        switch (opcionArticulo) {
                            case "1":  //1. Agregar Artículo
                                System.out.println("\n|=========> Insertar Artículo <==========|\n");

                                Articulo objArticulo = new Articulo();

                                System.out.print("\nIngrese el código del artículo: ");
                                objArticulo.setCodigo(leerTexto.nextLine());

                                System.out.print("\nIngrese el nombre del artículo: ");
                                objArticulo.setNombreart(leerTexto.nextLine());

                                System.out.print("\nIngrese el preciounitario del artículo: ");
                                objArticulo.setPreciounitario(leerNumero.nextInt());

                                objAdmArticuloDB.insertar(objArticulo);
                                break;
                            case "2": //2. Mostrar todos los artículos:
                                System.out.println("\n|=========> Listar Artículos <==========|\n");

                                for (Object obj : objAdmArticuloDB.listarTodo()) {
                                    Articulo objArticulo1 = (Articulo) obj;
                                    System.out.println(objArticulo1);
                                }
                                break;
                            case "3": //3. Mostrar un solo artículo:
                                System.out.println("\n|=========> Leer Artículo <==========|\n");

                                Articulo objArticulo2 = new Articulo();

                                System.out.print("Ingrese el id del artículo: ");
                                objArticulo2.setIdarticulo(leerNumero.nextInt());

                                objAdmArticuloDB.listarUno(objArticulo2);

                                System.out.println(objArticulo2);
                                break;
                            case "4":  //4. Actualizar un artículo:
                                System.out.println("\n|=========> Actualizar Artículo <==========|\n");

                                Articulo objArticulo3 = new Articulo();

                                System.out.print("Digite el id del artículo a actualizar: ");
                                objArticulo3.setIdarticulo(leerNumero.nextInt());

                                // Buscar el artículo en la base de datos
                                objArticulo3 = (Articulo) objAdmArticuloDB.listarUno(objArticulo3);
                                if (objArticulo3.getIdarticulo() == 0) {
                                    System.out.println("El artículo no existe.");
                                } else {
                                    // Mostrar información del artículo antes de actualizar
                                    System.out.println("Artículo actual:");
                                    System.out.println("ID: " + objArticulo3.getIdarticulo());
                                    System.out.println("Código: " + objArticulo3.getCodigo());
                                    System.out.println("Nombre artículo: " + objArticulo3.getNombreart());
                                    System.out.println("Precio unitario: " + objArticulo3.getPreciounitario());

                                    // Pedir al usuario el nuevo código del artículo
                                    System.out.print("Digite el nuevo código del artículo: ");
                                    String nuevoArticulo = leerNumero.next();

                                    // Pedir al usuario el nuevo nombre del artículo
                                    System.out.print("Digite el nuevo nombre del artículo: ");
                                    String nuevoArticulo1 = leerNumero.next();

                                    // Pedir al usuario el nuevo precio unitario del artículo
                                    System.out.print("Digite el nuevo precio unitario del artículo: ");
                                    Integer nuevoArticulo2 = leerNumero.nextInt();

                                    // Actualizar el artículo en la base de datos
                                    objArticulo3.setCodigo(nuevoArticulo);
                                    objArticulo3.setNombreart(nuevoArticulo1);
                                    objArticulo3.setPreciounitario(nuevoArticulo2);
                                    if (objAdmArticuloDB.actualizar(objArticulo3)) {
                                        System.out.println("Artículo actualizado éxitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar el artículo.");
                                    }
                                }
                                break;
                            case "5":  //5. Eliminar un artículo:
                                System.out.println("\n|=========> Eliminar Artículo <==========|\n");

                                Articulo objArticulo4 = new Articulo();
                                System.out.print("\nIngrese el id del artículo: ");
                                objArticulo4.setIdarticulo(leerNumero.nextInt());

                                if (objAdmArticuloDB.eliminar(objArticulo4)) {
                                    System.out.println("El artículo se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar el artículo.");
                                }
                                break;
                            case "6": //6. Salir
                                salirArticulo = true;
                                break;
                            default:
                                System.out.println("\nArtículo - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirArticulo = false;
                    break;
                case "4"://4. Administrar Operación

                    while (!salirOperacion) {
                        opcionOperacion = "";
                        System.out.println("\n---- ADMINISTRAR OPERACION ----\n");
                        System.out.println("1. Agregar operación");
                        System.out.println("2. Mostrar todas las operarciones");
                        System.out.println("3. Mostrar una sola operación");
                        System.out.println("4. Actualizar operación");
                        System.out.println("5. Eliminar operación");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionOperacion = leerOpcion.nextLine();

                        switch (opcionOperacion) {
                            case "1":  //1. Agregar Operación
                                System.out.println("\n|=========> Insertar Operación <==========|\n");

                                Operacion objOperacion = new Operacion();

                                System.out.print("\nIngrese el nombre de la operación: ");
                                objOperacion.setNombreopr(leerTexto.nextLine());

                                objAdmOperacionDB.insertar(objOperacion);
                                break;
                            case "2": //2. Mostrar todas las operaciones:
                                System.out.println("\n|=========> Listar Operaciones <==========|\n");

                                for (Object obj : objAdmOperacionDB.listarTodo()) {
                                    Operacion objOperacion1 = (Operacion) obj;
                                    System.out.println(objOperacion1);
                                }
                                break;
                            case "3": //3. Mostrar una sola operación:
                                System.out.println("\n|=========> Leer Operación <==========|\n");

                                Operacion objOperacion2 = new Operacion();

                                System.out.print("Ingrese el id de la operación: ");
                                objOperacion2.setIdoperacion(leerNumero.nextInt());

                                objAdmOperacionDB.listarUno(objOperacion2);

                                System.out.println(objOperacion2);
                                break;
                            case "4"://4. Actualiar una operación
                                System.out.println("\n|=========> Actualizar Operación <==========|\n");

                                Operacion objOperacion3 = new Operacion();

                                System.out.print("Digite el id de la operación a actualizar: ");
                                objOperacion3.setIdoperacion(leerNumero.nextInt());

                                // Buscar la operación en la base de datos
                                objOperacion3 = (Operacion) objAdmOperacionDB.listarUno(objOperacion3);

                                if (objOperacion3.getIdoperacion() == 0) {
                                    System.out.println("\nError: No existe esa operación en el sistema. \n");
                                } else {
                                    // Mostrar información de la operación antes de actualizar
                                    System.out.println("Operación actual:");
                                    System.out.println("ID: " + objOperacion3.getIdoperacion());
                                    System.out.println("Nombreopr: " + objOperacion3.getNombreopr());

                                    // Pedir al usuario el nuevo nombre de a operación
                                    System.out.print("Ingrese nombre de la operación: ");
                                    String nuevaOperacion = leerNumero.next();

                                    // Actualizar la operación en la base de datos
                                    objOperacion3.setNombreopr(nuevaOperacion);
                                    if (objAdmOperacionDB.actualizar(objOperacion3)) {
                                        System.out.println("Operación actualizada exitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar la operación.");
                                    }
                                }
                                break;
                            case "5":  //5. Eliminar una operación:
                                System.out.println("\n|=========> Eliminar Operación <==========|\n");

                                Operacion objOperacion4 = new Operacion();

                                System.out.print("\nIngrese el id de la operación: ");
                                objOperacion4.setIdoperacion(leerNumero.nextInt());

                                if (objAdmOperacionDB.eliminar(objOperacion4)) {
                                    System.out.println("La operación se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar la operación.");
                                }
                                break;
                            case "6": //6. Salir
                                salirOperacion = true;
                                break;
                            default:
                                System.out.println("\nOperación - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirOperacion = false;
                    break;
                case "5"://4. Administrar Movimiento

                    while (!salirMovimiento) {
                        opcionOperacion = "";
                        System.out.println("\n---- ADMINISTRAR MOVIMIENTO ----\n");
                        System.out.println("1. Agregar movimiento");
                        System.out.println("2. Mostrar todos los movimientos");
                        System.out.println("3. Mostrar un movimiento");
                        System.out.println("4. Actualizar movimiento");
                        System.out.println("5. Eliminar movimiento");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionMovimiento = leerOpcion.nextLine();

                        switch (opcionMovimiento) {
                            case "1":  //1. Agregar Movimiento
                                System.out.println("\n|=========> Insertar Movimiento <==========|\n");

                                Movimiento objMovimiento = new Movimiento();

                                System.out.print("Ingrese fecha [AAAA-MM-DD]: ");
                                objMovimiento.setFecha(LocalDate.parse(leerTexto.nextLine()));

                                System.out.print("Ingrese la cantidad: ");
                                objMovimiento.setCantidad(leerNumero.nextInt());

                                System.out.print("Ingrese el id de la persona: ");
                                objMovimiento.setPersona_idpersona(leerNumero.nextInt());

                                System.out.print("Ingrese el id del artículo: ");
                                objMovimiento.setArticulo_idarticulo(leerNumero.nextInt());

                                System.out.print("Ingrese el id de la operación: ");
                                objMovimiento.setOperacion_idoperacion(leerNumero.nextInt());

                                objAdmMovimientoDB.insertar(objMovimiento);
                                break;
                            case "2": //2. Mostrar todos los movimientos:
                                System.out.println("\n|=========> Liatar Movimientos <==========|\n");

                                for (Object obj : objAdmMovimientoDB.listarTodo()) {
                                    Movimiento objMovimiento1 = (Movimiento) obj;
                                    System.out.println(objMovimiento1);
                                }
                                break;
                            case "3": //3. Mostrar un solo movimiento:
                                System.out.println("\n|=========> Leer Movimiento <==========|\n");

                                Movimiento objMovimiento2 = new Movimiento();

                                System.out.print("Ingrese el id del movimiento: ");
                                objMovimiento2.setIdmovimiento(leerNumero.nextInt());

                                objAdmMovimientoDB.listarUno(objMovimiento2);

                                System.out.println(objMovimiento2);
                                break;
                            case "4":  //4. Actualizar un movimiento:
                                System.out.println("\n|=========> Actualizar Movimiento <==========|\n");

                                Movimiento objMovimiento3 = new Movimiento();

                                System.out.print("Ingrese el id del movimiento a actualizar: ");
                                objMovimiento3.setIdmovimiento(leerNumero.nextInt());

                                // Buscar el movimiento en la base de datos
                                objMovimiento3 = (Movimiento) objAdmMovimientoDB.listarUno(objMovimiento3);

                                if (objMovimiento3.getIdmovimiento() == 0) {
                                    System.out.println("El movimiento no existe.");
                                } else {
                                    System.out.println("Movimiento actual:");
                                    System.out.println("ID: " + objMovimiento3.getIdmovimiento());
                                    System.out.println("Fecha: " + objMovimiento3.getFecha());
                                    System.out.println("Cantidad del movimiento: " + objMovimiento3.getCantidad());
                                    System.out.println("ID de la persona: " + objMovimiento3.getPersona_idpersona());
                                    System.out.println("ID de la artículo: " + objMovimiento3.getArticulo_idarticulo());
                                    System.out.println("ID de la operación: " + objMovimiento3.getOperacion_idoperacion());

                                    // Pedir al usuario la nueva fecha del movimiento
                                    System.out.print("Ingrese la nueva fecha [AAAA-MM-DD] del movimiento: ");
                                    LocalDate nuevoMovimiento = LocalDate.parse(leerNumero.next());
                                    objMovimiento3.setFecha(nuevoMovimiento);

                                    // Pedir al usuario la nueva cantidad del movimiento
                                    System.out.print("Ingrese la nueva cantidad del movimiento: ");
                                    Integer nuevoMovimiento1 = leerNumero.nextInt();

                                    // Pedir al usuario el nuevo id de la persona encargada del movimiento
                                    System.out.print("Ingrese el nuevo id de la persona encargada del movimiento: ");
                                    Integer nuevoMovimiento2 = leerNumero.nextInt();

                                    // Pedir al usuario el nuevo id del artículo del movimiento
                                    System.out.print("Ingrese el nuevo id del artículo del movimiento: ");
                                    Integer nuevoMovimiento3 = leerNumero.nextInt();

                                    // Pedir al usuario el nuevo id de la operación del movimiento
                                    System.out.print("Ingrese el nuevo id de la operación del movimiento: ");
                                    Integer nuevoMovimiento4 = leerNumero.nextInt();

                                    // Actualizar el movimiento en la base de datos
                                    objMovimiento3.setFecha(nuevoMovimiento);
                                    objMovimiento3.setCantidad(nuevoMovimiento1);
                                    objMovimiento3.setPersona_idpersona(nuevoMovimiento2);
                                    objMovimiento3.setArticulo_idarticulo(nuevoMovimiento3);
                                    objMovimiento3.setOperacion_idoperacion(nuevoMovimiento4);
                                    if (objAdmMovimientoDB.actualizar(objMovimiento3)) {
                                        System.out.println("Movimiento actualizado éxitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar el movimiento.");
                                    }
                                }
                                break;
                            case "5":  //4. Eliminar un Movimiento:
                                System.out.println("\n|=========> Eliminar Movimiento <==========|\n");

                                Movimiento objMovimiento4 = new Movimiento();

                                System.out.print("\nIngrese el id del movimiento: ");
                                objMovimiento4.setIdmovimiento(leerNumero.nextInt());

                                if (objAdmMovimientoDB.eliminar(objMovimiento4)) {
                                    System.out.println("El movimiento se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar el movimiento.");
                                }
                                break;
                            case "6": //6. Salir
                                salirMovimiento = true;
                                break;
                            default:
                                System.out.println("\nMovimiento - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirMovimiento = false;
                    break;
                case "6"://2. Administrar Reportes

                    while (!salirReportes) {
                        opcionReportes = "";
                        System.out.println("\n======> REPORTES <======\n");
                        System.out.println("1. Registro de los nuevos artículos: la cantidad de cada uno, el total y el dinero total invertido, indicando la fecha.");
                        System.out.println("2. Registro Dinero total invertido en el inventario(balance general), indicando la fecha.");
                        System.out.println("3. Balance general totalizado, indicando la fecha.");
                        System.out.println("4. Registro del inventario de los artículos, indicando la fecha.");
                        System.out.println("5. Registro inventario de los artículos, indicando la fecha.");
                        System.out.println("6. Registro de artículos actualizada, indicando la fecha.");
                        System.out.println("7. Registro de los artículos, indicando el tipo de operación, el responsable y la fecha.");
                        System.out.println("8. Registro de las operaciones realizadas sobre un artículo, indicando el código del atículo.");
                        System.out.println("9. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionReportes = leerOpcion.nextLine();
                        switch (opcionReportes) {
                            case "1"://1.Registro de los nuevos artículos: la cantidad de cada uno, el total y el dinero total invertido, indicando la fecha.");
                                System.out.println("\n********** Reporte: Total Nuevos Artículos. *********\n");

                                LocalDate fechaInicio = LocalDate.parse("1900-01-01");
                                LocalDate fechaFin = LocalDate.parse("1900-01-01");

                                System.out.print("Ingrese Fecha inicial[AAAA-MM-DD]: ");
                                fechaInicio = LocalDate.parse(leerTexto.next());

                                System.out.print("Ingrese Fecha final[AAAA-MM-DD]: ");
                                fechaFin = LocalDate.parse(leerTexto.next());

                                System.out.println("\nLista de nuevos artículos:\n");

                                RelacionesDB objRelDB = new RelacionesDB();

                                BigDecimal cantidad4 = BigDecimal.ZERO;
                                BigDecimal dinero_invertido = BigDecimal.ZERO;
                                for (ListaArticulo objResult : objRelDB.consultarDatos(fechaInicio, fechaFin)) {
                                    System.out.println(objResult);

                                    cantidad4 = cantidad4.add(new BigDecimal(objResult.getCantidad()));
                                    dinero_invertido = dinero_invertido.add(objResult.getDinero_invertido());
                                }
                                System.out.println("\nEl Total de nuevos artículos ingresados es de: " + cantidad4 + " unidades.\n");
                                System.out.println("El dinero total invertido en los nuevos artículos: " + dinero_invertido);
                                break;
                            case "2":  //2. Registro Dinero total invertido en el inventario(balance general), indicando la fecha.");
                                System.out.println("\n********** Reporte: Balance General *********\n");

                                LocalDate fechaInicio2 = LocalDate.parse("1900-01-01");
                                LocalDate fechaFin2 = LocalDate.parse("1900-01-01");

                                System.out.print("Ingrese Fecha inicial[AAAA-MM-DD]: ");
                                fechaInicio2 = LocalDate.parse(leerTexto.next());

                                System.out.print("Ingrese Fecha final[AAAA-MM-DD]: ");
                                fechaFin2 = LocalDate.parse(leerTexto.next());

                                RelacionesDB objRelDB2 = new RelacionesDB();

                                BigDecimal cantidad_total = BigDecimal.ZERO;
                                BigDecimal unidades_descontadas = BigDecimal.ZERO;
                                BigDecimal cantidad_actual = BigDecimal.ZERO;
                                BigDecimal dinero_en_inventario = BigDecimal.ZERO;
                                for (BalanceGeneral objResult : objRelDB2.consultarDatos2(fechaInicio2, fechaFin2)) {
                                    System.out.println(objResult);

                                    cantidad_total = cantidad_total.add(new BigDecimal(objResult.getCantidad_total()));
                                    unidades_descontadas = unidades_descontadas.add(new BigDecimal(objResult.getUnidades_descontadas()));
                                    cantidad_actual = cantidad_actual.add(new BigDecimal(objResult.getCantidad_actual()));
                                    dinero_en_inventario = dinero_en_inventario.add(new BigDecimal(objResult.getDinero_en_inventario()));
                                }
                                System.out.println("La cantidad total de artículos es de: " + cantidad_total + " unidades.");
                                System.out.println("Las unidades descontadas son: " + unidades_descontadas + " unidades.");
                                System.out.println("La cantidad actual de artículos es de: " + cantidad_actual + " unidades.");
                                System.out.println("El dinero en el inventario es de: " + dinero_en_inventario);
                                break;
                            case "3"://3. Balance general totalizado, indicando la fecha.
                                System.out.println("\n********** Reporte: Balance General Totalizado *********\n");

                                RelacionesDB objRelDB3 = new RelacionesDB();

                                for (BalanceTotalizado objResult : objRelDB3.consultarDatos3()) {
                                    System.out.println(objResult);
                                }
                                break;
                            case "4"://4. Registro del inventario de los artículos, indicando la fecha.
                                System.out.println("\n********** Reporte: Inventario Artículos por fechas *********\n");

                                LocalDate fechaInicio4 = LocalDate.parse("1900-01-01");
                                LocalDate fechaFin4 = LocalDate.parse("1900-01-01");

                                System.out.print("Ingrese Fecha inicial[AAAA-MM-DD]: ");
                                fechaInicio4 = LocalDate.parse(leerTexto.next());

                                System.out.print("Ingrese Fecha final[AAAA-MM-DD]: ");
                                fechaFin4 = LocalDate.parse(leerTexto.next());

                                System.out.println("\nLista de los artículos por rango de fechas:\n");

                                RelacionesDB objRelDB4 = new RelacionesDB();

                                BigDecimal valor_total = BigDecimal.ZERO;
                                for (InventarioArticulo objResult : objRelDB4.consultarDatos4(fechaInicio4, fechaFin4)) {
                                    System.out.println(objResult);

                                    valor_total = valor_total.add(objResult.getValor_total());
                                }
                                System.out.println("El total del inventario es de: " + valor_total);
                                break;
                            case "5"://5. Registro inventario de los artículos, indicando la fecha.
                                System.out.println("\n********** Reporte: Artículos según el tipo de operación *********\n");

                                LocalDate fechaInicio5 = LocalDate.parse("1900-01-01");
                                LocalDate fechaFin5 = LocalDate.parse("1900-01-01");

                                System.out.print("Ingrese Fecha inicial[AAAA-MM-DD]: ");
                                fechaInicio5 = LocalDate.parse(leerTexto.next());

                                System.out.print("Ingrese Fecha final[AAAA-MM-DD]: ");
                                fechaFin5 = LocalDate.parse(leerTexto.next());

                                System.out.println("\nLista de artículos según el tipo de operación:\n");

                                RelacionesDB objRelDB5 = new RelacionesDB();

                                for (AdministrarInventarioArticulo objResult : objRelDB5.consultarDatos5(fechaInicio5, fechaFin5)) {
                                    System.out.println(objResult);
                                }
                                break;
                            case "6"://6. Registro de artículos actualizada, indicando la fecha.
                                System.out.println("\n********** Reporte: Artículos Actuales *********\n");

                                LocalDate fechaInicio6 = LocalDate.parse("1900-01-01");
                                LocalDate fechaFin6 = LocalDate.parse("1900-01-01");

                                System.out.print("Ingrese Fecha inicial[AAAA-MM-DD]: ");
                                fechaInicio6 = LocalDate.parse(leerTexto.next());

                                System.out.print("Ingrese Fecha final[AAAA-MM-DD]: ");
                                fechaFin6 = LocalDate.parse(leerTexto.next());

                                RelacionesDB objRelDB6 = new RelacionesDB();

                                for (ListaArticulo objResult : objRelDB6.consultarDatos6(fechaInicio6, fechaFin6)) {
                                    System.out.println(objResult);
                                }
                                break;

                            case "7": //7.Registro de los artículos, indicando el tipo de operación, el responsable y la fecha.
                                System.out.println("\n********** Reporte: Artículos y responsable *********\n");
                                System.out.println("\n|=========> Listar Operaciones <==========|\n");

                                for (Object obj : objAdmOperacionDB.listarTodo()) {
                                    Operacion objOperacion1 = (Operacion) obj;
                                    System.out.println(objOperacion1);
                                }
                                String nombreOperacion = "";

                                System.out.print("Ingrese el nombre de la operación: ");
                                nombreOperacion = leerTexto.next();

                              /*  Operacion objOperacion3 = new Operacion();
                                 Buscar la operación en la base de datos
                                objOperacion3 = (Operacion) objAdmOperacionDB.listarUno(objOperacion3);
                                
                                System.out.println("\nLista de movimientos de un artículo:\n");
                                if (objOperacion3.getIdoperacion() == 0) {
                                    System.out.println("\nError: No existe esa operación en el sistema. \n");
                                } else {
                                */                                                       
                                    /*System.out.println("\n|=========> Listar Personas <==========|\n");

                                    for (Object obj : objAdmPersonaDB.listarTodo()) {
                                        Persona objPersona1 = (Persona) obj;
                                        System.out.println(objPersona1);
                                    }

                                    String nombrePersona = "";
                                    String apellidoPersona = "";

                                    System.out.print("Ingrese el nombre del responsable: ");
                                    nombrePersona = leerTexto.next();

                                    System.out.print("Ingrese el apellido del responsable: ");
                                    apellidoPersona = leerTexto.next();

                                   /* Persona objPersona3 = new Persona();
                                     Buscar a la persona en la base de datos
                                objPersona3 = (Persona) objAdmPersonaDB.listarUno(objPersona3);

                                    if (objPersona3.getIdpersona() == 0) {
                                        System.out.println("La persona no existe.");
                                    } else {
                                   */   /*  LocalDate fechaInicio7 = LocalDate.parse("1900-01-01");
                                        LocalDate fechaFin7 = LocalDate.parse("1900-01-01");

                                        System.out.print("Ingrese Fecha inicial[AAAA-MM-DD]: ");
                                        fechaInicio7 = LocalDate.parse(leerTexto.next());

                                        System.out.print("Ingrese Fecha final[AAAA-MM-DD]: ");
                                        fechaFin7 = LocalDate.parse(leerTexto.next());

                                        System.out.println("\nLista de artículos que han pasado por un responsable:\n");

                                        RelacionesDB objRelDB7 = new RelacionesDB();

                                        BigDecimal cantidad = BigDecimal.ZERO;
                                        int totalMovimientos = 0;
                                        for (ArticuloOrdenadoFecha objResult : objRelDB7.consultarDatos7(nombreOperacion, nombrePersona, apellidoPersona, fechaInicio7, fechaFin7)) {
                                            System.out.println(objResult);

                                            totalMovimientos++;
                                            cantidad = cantidad.add(new BigDecimal(objResult.getCantidad()));
                                        }
                                        System.out.println("\nTotal movimientos realizados: " + totalMovimientos);
                                        System.out.println("El Total de las cantidades movidas por " + nombrePersona + " " + apellidoPersona + " es: " + cantidad + " unidades.");
                                  //  }
                                //}
                                break;
                            case "8"://8. Registro de las operaciones realizadas sobre un artículo, indicando el código del atículo.
                                System.out.println("\n********** Reporte: Movimiento Artículos *********\n");

                                System.out.println("\n|=========> Listar Artículos <==========|\n");

                                for (Object obj : objAdmArticuloDB.listarTodo()) {
                                    Articulo objArticulo1 = (Articulo) obj;
                                    System.out.println(objArticulo1);
                                }
                                String codigoArticulo = "";

                                System.out.print("Ingrese el código del artículo: ");
                                codigoArticulo = leerTexto.next();

                                Articulo objArticulo3 = new Articulo();
                                // Buscar el artículo en la base de datos
                                objArticulo3 = (Articulo) objAdmArticuloDB.listarUno(objArticulo3);

                                System.out.println("\nLista de movimientos de un artículo:\n");
                                if (objArticulo3.getIdarticulo() == 0) {
                                    System.out.println("El artículo no existe.");
                                }
                                RelacionesDB objRelDB8 = new RelacionesDB();

                                for (OperacionArticulo objResult : objRelDB8.consultarDatos8(codigoArticulo)) {
                                    System.out.println(objResult);
                                }
                                break;
                            case "9": //9. Salir
                                salirReportes = true;
                                break;
                            default:
                                System.out.println("\nReportes - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirReportes = false;
                    break;
                case "7": //7. Salir
                    salir = true;
                    System.out.println("\n!!! Adiós !!!\n");
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("\n - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
            }
        }*/
    }
}
