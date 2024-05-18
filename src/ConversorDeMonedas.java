import java.util.Scanner;

public class ConversorDeMonedas {
    public static void convertir(String monedaBase, String monedaTarget, ConsultaDeMonedas consultaDeMonedas, Scanner lectura){
        double cantidad;
        double cantidadConvertida;

        DatosDeMonedas monedas = consultaDeMonedas.buscarMonedas(monedaBase, monedaTarget);
        System.out.println("La tasa de conversion para hoy\n1 "+monedaBase+ "= "+monedas.conversion_rate()+ " "+monedaTarget);
        System.out.println("Ingrese la cantidad de "+ monedaBase);
        cantidad = Double.parseDouble(lectura.nextLine());
        cantidadConvertida = cantidad * monedas.conversion_rate();
        System.out.println(cantidad+" "+monedaBase+" = "+cantidadConvertida+" "+monedas.target_code());
    }

    public static void convertirOtraMoneda(ConsultaDeMonedas consultaDeMonedas, Scanner lectura){
        System.out.println("Ingrese el codigo de la moneda base");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese la moneda la cual quiere convertir");
        String monedaObjetivo = lectura.nextLine().toUpperCase();
        convertir(monedaBase, monedaObjetivo, consultaDeMonedas, lectura);


    }
}
