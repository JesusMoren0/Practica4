import java.util.Scanner;

public class Banco {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		 menu();
    }
    public static void menu(){
        int opc = 0;
        do{
        	System.out.println();
            System.out.println("| MENU |");
            System.out.println("1. Cuenta bancaria existente.");
            System.out.println("2. Crear una cuenta bancaria.");
            System.out.println("3. Salir.");
            System.out.println("Introduce una opcion: ");
            opc = capturaInt();

            switch (opc) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    crearUsuario();
                    break;
                case 3:
                    System.out.println("Vuelva pronto....");
                    break;
                default:
                    System.out.println("Opcion no valida....");
            }
        }while(opc != 3);
    }

    public static void crearUsuario(){
        cuenta = new Cuenta();
        double deposito;
        cuenta.setSaldo(0);

        System.out.println("Introduce nombre: ");
        cuenta.setNombre(capturaString());
        
        System.out.println("| PIN DE 4 DIJITOS |");
        System.out.println("Ingrese un PIN: ");
        cuenta.setPin(capturaInt());

        System.out.println("Introduce saldo: ");
        deposito = capturaDouble();
        cuenta.setSaldo((float) deposito);
    }

    public static void iniciarSesion(){

        int pin, opc = 0;
        double retirar = 0,depositar = 0;

        System.out.println("Introduce PIN para iniciar sesion.");
        pin = capturaInt();

        if(cuenta != null) {
            if (pin == cuenta.getPin()) ;

            do {
            	System.out.println();
                System.out.println("Bienvenido "+cuenta.getNombre());
                System.out.println("Su saldo acutal es de "+cuenta.getSaldo()+"$");
                System.out.println();
                System.out.println("Menu Bancaria.");
                System.out.println("1. Depositar dinero.");
                System.out.println("2. Retirar dinero.");
                System.out.println("3. Salir.");
                System.out.println("Introduce una opcion");
                opc = capturaInt();

                switch (opc) {
                    case 1:
                        System.out.println("Ingrese la cantidad a depositar: ");
                        depositar = capturaDouble();
                        cuenta.setSaldo((float) (cuenta.getSaldo() + depositar));
                        System.out.print("Transaccion exitosa.");
                        System.out.println("Su saldo es de "+cuenta.getSaldo()+"$");
                        break;
                    case 2:
                        retiro(retirar);
                        System.out.print("Transaccion exitosa.");
                        System.out.println("Su saldo es de "+cuenta.getSaldo()+"$");
                        break;
                    case 3:
                    	 System.out.println("Hasta pronto.");
                        break;
                        
                    	default:
                        System.out.println("Opcion no valida...");
                }
            } while (opc != 3);
        }else
            System.out.println("No existe cuenta creada con ese PIN.");
    }

    public static void retiro(double retirar){
        int i = 0;
        do{
            System.out.println("Ingrese la cantidad a retirar: ");
            retirar = capturaDouble();
            if(retirar <= cuenta.getSaldo()){
                cuenta.setSaldo((float)(cuenta.getSaldo()-retirar));
                i = 1;
            }else{
                System.out.print("El saldo es insuficiente...");
            }
        }while(i!=1);
    }
    
    public static Cuenta cuenta;

    public static int capturaInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String capturaString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static double capturaDouble(){
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
}

