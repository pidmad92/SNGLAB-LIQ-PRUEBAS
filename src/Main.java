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
        DatosLaborales datosLaborales = new DatosLaborales(empleador, trabajador, LocalDate.parse("2000-12-15"),"Empleado","General", LocalDate.parse("2018-09-02"));
        ArrayList<String> listaBeneficios = new ArrayList<>();
        listaBeneficios.add("CTS");

        ListaPeriodos listaPeriodos = new ListaPeriodos(datosLaborales,listaBeneficios);
        listaPeriodos.printPerxBeneficio();


    }
}
