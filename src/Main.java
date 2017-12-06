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
        DatosLaborales datosLaborales = new DatosLaborales(empleador, trabajador, LocalDate.parse("1991-01-01"),"Empleado","General", LocalDate.parse("2015-01-01"));
        ArrayList<String> listaBeneficios = new ArrayList<>();
        listaBeneficios.add("CTS");

        ListaPeriodos listaPeriodos = new ListaPeriodos(datosLaborales,listaBeneficios);
        listaPeriodos.printPerxBeneficio();
/*
        //System.out.println(LocalDate.parse("2015-06-01").getMonthValue());
        //System.out.println(LocalDate.parse("2015-06-01").plusMonths(7).getYear());
        LocalDate fechaEjemplo = LocalDate.parse("1991-01-01");
        LocalDate fechaFin = LocalDate.parse("2000-11-01");
        LocalDate sigFecha = null;
        long tiempo = ((fechaEjemplo.until(fechaFin)).toTotalMonths()/6);
        int frac = 0;
        if(tiempo%6>0){
            frac = 1;
        }
        for(int a = 0;a <= ((int)tiempo + frac); a++){
            System.out.print((a+1));
            System.out.print(" \t" + fechaEjemplo);
            if((fechaEjemplo.getMonthValue()<5)||(fechaEjemplo.getMonthValue()>=11)) {
                sigFecha = LocalDate.parse(fechaEjemplo.getYear() + "-05-01");
            }else if((fechaEjemplo.getMonthValue()>=5)||(fechaEjemplo.getMonthValue()<11)){
                sigFecha = LocalDate.parse(fechaEjemplo.getYear() + "-11-01");
            }
            if(fechaEjemplo.isAfter(sigFecha)){
                sigFecha = sigFecha.plusYears(1);
            }
            if(sigFecha.minusDays(1).isAfter(fechaFin.minusDays(1))){
                sigFecha = fechaFin;
                System.out.print("\t\t" + sigFecha);
                fechaEjemplo = sigFecha;
                System.out.println();
                break;
            }
            System.out.print("\t\t" + sigFecha.minusDays(1));
            fechaEjemplo = sigFecha;
            System.out.println();

        }/*
        if((fechaEjemplo.getMonthValue()<5)||(fechaEjemplo.getMonthValue()>=11)) {
            sigFecha = LocalDate.parse(fechaEjemplo.getYear() + "-05-01");
        }else if((fechaEjemplo.getMonthValue()>=5)||(fechaEjemplo.getMonthValue()<11)){
            sigFecha = LocalDate.parse(fechaEjemplo.getYear() + "-11-01");
        }
        if(fechaEjemplo.isAfter(sigFecha)){
            sigFecha = sigFecha.plusYears(1);
        }
        System.out.println(sigFecha);
*/
    }
}
