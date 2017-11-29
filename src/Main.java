import Services.ListaPeriodos;
import model.DatosLaborales;
import model.Empleador;
import model.Trabajador;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*String cRojo = (char)27 + "[31;1m";
        String cAmar = (char)27 + "[33m";
        System.out.println( cRojo + "Creación de Periodos:");*/

        Empleador empleador = new Empleador("1070413933","PIDMAD - Servicios Mecatronicos");
        Trabajador trabajador = new Trabajador("704139336","Pierre David Maldonado Diaz");
        DatosLaborales datosLaborales = new DatosLaborales(empleador, trabajador, LocalDate.parse("1978-12-31"),"Empleado","General", LocalDate.parse("1992-05-13"));
        ArrayList<String> listaBeneficios = new ArrayList<>();
        listaBeneficios.add("CTS");
        listaBeneficios.add("Gratificaciones");
        listaBeneficios.add("Indemnizaciones");

        ListaPeriodos listaPeriodos = new ListaPeriodos(datosLaborales,listaBeneficios);
        listaPeriodos.printPerxBeneficio();





    }
}
