import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaDeMonedas consultaDeMonedas = new ConsultaDeMonedas();
        System.out.println("Escriba el codigo base de dos monedas que desee comparar su tasa de cambio");

        try {
            var monedaBase = lectura.nextLine();
            var monedaTarget = lectura.nextLine();


            DatosDeMonedas datosDeMonedas = consultaDeMonedas.buscarMonedas(monedaBase, monedaTarget);
            System.out.println(datosDeMonedas);
            GeneradorJson generador = new GeneradorJson();
            generador.guardarJson(datosDeMonedas);
        }catch (NumberFormatException e){
            System.out.println("Numero no encontrado "+e.getMessage());

        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion.");
        }



        int escoge = 0;
        while (escoge != 8){



            System.out.println("*********************************\n" +
                    "Bienvenidos al conversor de monedas\n\n" +
                    "Ingresa la conversion que deseas realizar\n\n" +
                    "1. Dolar a peso argentino\n" +
                    "2. Peso argentino a dolar\n" +
                    "3. Dolar a real brasileño\n" +
                    "4. Real brasileño a dolar\n" +
                    "5. Dolar a peso colombiano\n" +
                    "6. Peso colombiano a dolar\n" +
                    "7. Convertir otra moneda\n" +
                    "8. Salir");
            escoge = lectura.nextInt();
            lectura.nextLine();

            switch (escoge){
                case 1:
                    ConversorDeMonedas.convertir("USD", "ARS", consultaDeMonedas, lectura);
                    break;

                case 2:
                    ConversorDeMonedas.convertir("ARS", "USD", consultaDeMonedas, lectura);
                    break;

                case 3:
                    ConversorDeMonedas.convertir("USD", "BRL", consultaDeMonedas, lectura);
                    break;

                case 4:
                    ConversorDeMonedas.convertir("BRL", "USD", consultaDeMonedas, lectura);
                    break;

                case 5:
                    ConversorDeMonedas.convertir("USD", "COP", consultaDeMonedas, lectura);
                    break;

                case 6:
                    ConversorDeMonedas.convertir("COP", "USD", consultaDeMonedas, lectura);
                    break;

                case 7:
                    ConversorDeMonedas.convertirOtraMoneda( consultaDeMonedas, lectura);
                    break;

                case 8:
                    System.out.println("Saliendo del conversor de monedas");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }
    }
}
