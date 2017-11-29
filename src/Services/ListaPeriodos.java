package Services;

import model.DatosLaborales;
import model.Periodo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeriodos {

    private DatosLaborales datosLaborales;
    private String beneficioSocial;
    private ArrayList<String> listaBeneficios;
    private ArrayList<Periodo> periodos;

    private static final String FEC_FIN_P1 = "1990-12-31";
    private static final String FEC_FIN_P2 = "2000-10-31";
    private static final String FEC_FIN_P3 = "2004-10-31";
    private static final String FEC_INI_P4 = "2004-11-01";


    public ListaPeriodos() {
    }

    public ListaPeriodos(DatosLaborales datosLaborales, ArrayList<String> listaBeneficios) {
        this.datosLaborales = datosLaborales;
        this.listaBeneficios = listaBeneficios;
    }

    public void printPerxBeneficio(){
        Iterator<String> beneficio = listaBeneficios.iterator();
        while (beneficio.hasNext()){
            printPeriodo(beneficio.next());
        }
    }

    public void printPeriodo(String ben){
        switch (ben.toLowerCase()){
            case "cts":
                System.out.println("Periodos de " + ben);
                printPeriodosCts();
                break;
            case "gratificaciones":
                System.out.println("Periodos de " + ben);
                printPeriodosGrati();
                break;
            default:
                System.out.println("Beneficio no contemplado");
        }
    }

    public void printPeriodosCts(){
        System.out.println("Fecha de Ingreso: "+ datosLaborales.getFecVincul());
        LocalDate f0;
        f0 = datosLaborales.getFecVincul();
        Period timeToFinPer = null;

        if(datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_P1).plusDays(1)))){
            System.out.println("Ingreso hasta el " + LocalDate.parse(FEC_FIN_P1));
            timeToFinPer = f0.until(LocalDate.parse(FEC_FIN_P1));
            System.out.println("Tiempo hasta el fin del periodo CTS: " + timeToFinPer.getYears() + " años " + timeToFinPer.getMonths() + " meses " + timeToFinPer.getDays() + " dias ");
            for(int a = 1; a <= timeToFinPer.getYears(); a++){
                System.out.println(a);
            }


            //for(periodoJava2.getYears()>=
        }else if((datosLaborales.getFecVincul().isAfter(LocalDate.parse("1990-12-31"))) && (datosLaborales.getFecVincul().isBefore(LocalDate.parse("2000-11-01")))){
            System.out.println("Ingresó después de " + LocalDate.parse("1990-12-31") + " y hasta " + LocalDate.parse("2000-10-31"));

        }else if((datosLaborales.getFecVincul().isAfter(LocalDate.parse("2000-10-31"))) && (datosLaborales.getFecVincul().isBefore(LocalDate.parse("2004-11-01")))){
            System.out.println("Ingresó después de " + LocalDate.parse("2000-10-31") + " y hasta " + LocalDate.parse("2004-10-31"));

        }else if(datosLaborales.getFecVincul().isAfter(LocalDate.parse("2004-10-31"))){
            System.out.println("Ingresó después de " + LocalDate.parse("2004-10-31"));

        }
    }

    public void printPeriodosGrati(){

    }
}
