import Services.ListaPeriodos;
import model.DatosLaborales;
import model.Empleador;
import model.Trabajador;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*String cRojo = (char)27 + "[31;1m";
        String cAmar = (char)27 + "[33m";
        System.out.println( cRojo + "Creación de Periodos:");*/

        Empleador empleador = new Empleador("1070413933","PIDMAD - Servicios Mecatronicos");
        Trabajador trabajador = new Trabajador("704139336","Pierre David Maldonado Diaz");
        DatosLaborales datosLaborales = new DatosLaborales(empleador, trabajador, LocalDate.parse("1962-07-12"),"Empleado","General", LocalDate.parse("2005-01-01"));
        ArrayList<String> listaBeneficios = new ArrayList<>();
        listaBeneficios.add("CTS");

        ListaPeriodos listaPeriodos = new ListaPeriodos(datosLaborales,listaBeneficios);
        listaPeriodos.printPerxBeneficio();
    }
}
