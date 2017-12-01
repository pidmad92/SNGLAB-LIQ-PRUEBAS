package Services;

import com.sun.deploy.util.ArrayUtil;
import model.DatosLaborales;
import model.Periodo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeriodos {

    private DatosLaborales datosLaborales;
    private String beneficioSocial;
    private ArrayList<String> listaBeneficios;
    private ArrayList<Periodo> periodos = new ArrayList<>();

    private static final String FEC_FIN_PT1 = "1990-12-31";
    private static final String FEC_FIN_OSPT1 = "1962-01-11";



    private static final String FEC_FIN_PT2 = "2000-10-31";
    private static final String FEC_FIN_PT3 = "2004-10-31";
    private static final String FEC_INI_PT4 = "2004-11-01";


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
        LocalDate f0 = datosLaborales.getFecVincul();
        LocalDate fi = null;
        LocalDate ff = null;
        Period timeToFinPer = null;
        System.out.println("Ingreso hasta el " + LocalDate.parse(FEC_FIN_PT1));
        int p = 0;

        /*  Periodos CTS de la Reserva  */
        if(datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_PT1).plusDays(1)))){
            System.out.println("Periodos CTS de la Reserva: ");

            /*  Tipo de vinculo = 'Obrero'  */
            if(datosLaborales.getTipVinculo().equalsIgnoreCase("Obrero")) {
                System.out.println("\tCaso: 'Obrero'");

                /*  Sub-Periodo Tipo 1  */
                if(datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_OSPT1).plusDays(1)))) {
                    System.out.println("\t\tSub-Periodo Tipo 1");

                    /*  Secuencia en el Sub-Periodo Tipo 1  */
                    timeToFinPer = f0.until(LocalDate.parse(FEC_FIN_OSPT1));
                    Periodo periodo;
                    for(int a = 0; a <= timeToFinPer.getYears(); a++){
                        periodo = new Periodo();
                        p++;
                        periodo.setNumPer(p);
                        periodo.setFecIni(f0.plusYears(a).plusDays(a));
                        if((f0.plusYears(a+1).plusDays(a)).isAfter(LocalDate.parse(FEC_FIN_OSPT1).minusDays(a+1))){
                            ff = LocalDate.parse(FEC_FIN_OSPT1);
                            periodo.setFecFin(ff);
                            periodos.add(periodo);
                            break;
                        } else {
                            ff = f0.plusYears(a+1).plusDays(a);
                            periodo.setFecFin(ff);
                            periodos.add(periodo);
                        }
                    }

                    /*  Secuencia en el Sub-Periodo Tipo 2  */
                    ff = (LocalDate.parse(FEC_FIN_OSPT1).plusDays(1));
                    timeToFinPer = ff.until(LocalDate.parse(FEC_FIN_PT1));
                    f0=ff;
                    for(int a = 0; a <= timeToFinPer.getYears(); a++){
                        periodo = new Periodo();
                        p++;
                        periodo.setNumPer(p);
                        periodo.setFecIni(f0.plusYears(a).plusDays(a));
                        if((f0.plusYears(a+1).plusDays(a)).isAfter(LocalDate.parse(FEC_FIN_PT1).minusDays(a+1))){
                            ff = LocalDate.parse(FEC_FIN_PT1);
                            periodo.setFecFin(ff);
                            periodos.add(periodo);
                            break;
                        } else {
                            ff = f0.plusYears(a+1).plusDays(a);
                            periodo.setFecFin(ff);
                            periodos.add(periodo);
                        }
                    }

                    /*  Recorriendo los periodos    */
                    System.out.println("\t\t\tSecuencia en el Sub-Periodo Tipo 1:");
                    for(Periodo per : periodos){
                        System.out.println("\t\t\tPeriodo N°" + per.getNumPer() + " \t(" + per.getFecIni() + " - " + per.getFecFin() + ")" );
                        if(per.getFecFin().equals(LocalDate.parse(FEC_FIN_OSPT1))){
                            System.out.println("\t\t\tSecuencia en el Sub-Periodo Tipo 2:");
                        }
                    }
                }

                /*  Sub-Periodo Tipo 2  */
                else{
                    System.out.println("\t\tSub-Periodo Tipo 2");
                    timeToFinPer = f0.until(LocalDate.parse(FEC_FIN_PT1));
                    Periodo periodo;
                    for(int a = 0; a <= timeToFinPer.getYears(); a++){
                        periodo = new Periodo();
                        p++;
                        periodo.setNumPer(p);
                        periodo.setFecIni(f0.plusYears(a).plusDays(a));
                        if((f0.plusYears(a+1).plusDays(a)).isAfter(LocalDate.parse(FEC_FIN_PT1).minusDays(a+1))){
                            ff = LocalDate.parse(FEC_FIN_PT1);
                            periodo.setFecFin(ff);
                            periodos.add(periodo);
                            break;
                        } else {
                            ff = f0.plusYears(a+1).plusDays(a);
                            periodo.setFecFin(ff);
                            periodos.add(periodo);
                        }
                    }
                    /*  Secuencia en el Sub-Periodo Tipo 2  */
                    System.out.println("\t\t\tSecuencia en el Sub-Periodo Tipo 2:");
                    for(Periodo per : periodos){
                        System.out.println("\t\t\tPeriodo N°" + per.getNumPer() + " \t(" + per.getFecIni() + " - " + per.getFecFin() + ")" );
                    }
                }
            }

            /*  Tipo de vinculo = 'Empleado'  */
            else if(datosLaborales.getTipVinculo().equalsIgnoreCase("Empleado")) {
                System.out.println("Caso: 'Empleado'");

                /*  Sub-Periodo Tipo 1  */


                /*  Sub-Periodo Tipo 2  */

                    /*  Sub-Sub-Periodo Tipo 1  */

                    /*  Sub-Sub-Periodo Tipo 2  */

                    /*  Sub-Sub-Periodo Tipo 3  */

                    /*  Sub-Sub-Periodo Tipo 4  */

            }
            /*  Tipo de vinculo = 'Unknown'  */
            else {
                System.out.println("Error: El tipo de vinculo no fue contemplado");
            }

        }
/*

            timeToFinPer = f0.until(LocalDate.parse(FEC_FIN_P1));
            System.out.println("Tiempo hasta el fin del periodo CTS: " + timeToFinPer.getYears() + " años " + timeToFinPer.getMonths() + " meses " + timeToFinPer.getDays() + " dias ");
            for(int a = 0; a <= timeToFinPer.getYears(); a++){
                System.out.print("Periodo N°" + (a+1) + " \t" + "-" + "\t");
                System.out.print("f0: " + f0.plusYears(a).plusDays(a));
                if((a == timeToFinPer.getYears()) && (!timeToFinPer.equals(Period.of(0,0,0)))){
                    System.out.println(" - " + "ff: " + FEC_FIN_P1);
                } else {
                    System.out.print(" - " + "ff: " + f0.plusYears(a+1).plusDays(a));
                }
                System.out.println();
            }


            //for(periodoJava2.getYears()>=
        }else if((datosLaborales.getFecVincul().isAfter(LocalDate.parse("1990-12-31"))) && (datosLaborales.getFecVincul().isBefore(LocalDate.parse("2000-11-01")))){
            System.out.println("Ingresó después de " + LocalDate.parse("1990-12-31") + " y hasta " + LocalDate.parse("2000-10-31"));

        }else if((datosLaborales.getFecVincul().isAfter(LocalDate.parse("2000-10-31"))) && (datosLaborales.getFecVincul().isBefore(LocalDate.parse("2004-11-01")))){
            System.out.println("Ingresó después de " + LocalDate.parse("2000-10-31") + " y hasta " + LocalDate.parse("2004-10-31"));

        }else if(datosLaborales.getFecVincul().isAfter(LocalDate.parse("2004-10-31"))){
            System.out.println("Ingresó después de " + LocalDate.parse("2004-10-31"));

        }*/
    }

    public void printPeriodosGrati(){

    }
}
