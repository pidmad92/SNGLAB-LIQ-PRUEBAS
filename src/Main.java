import Services.ListaPeriodos;
import model.DatosLaborales;
import model.Empleador;
import model.Trabajador;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Empleador empleador = new Empleador("1070413933","PIDMAD - Servicios Mecatronicos");
        Trabajador trabajador = new Trabajador("704139336","Pierre David Maldonado Diaz");
        DatosLaborales datosLaborales = new DatosLaborales(empleador, trabajador, LocalDate.parse("1978-02-05"),"Empleado","General", LocalDate.parse("2016-12-12"));
        ArrayList<String> listaBeneficios = new ArrayList<>();
        listaBeneficios.add("CTS");

        ListaPeriodos listaPeriodos = new ListaPeriodos(datosLaborales,listaBeneficios);
        listaPeriodos.printPerxBeneficio();


    }
}
