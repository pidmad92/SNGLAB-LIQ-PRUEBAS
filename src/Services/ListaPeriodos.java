package Services;

import model.DatosLaborales;
import model.Periodo;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeriodos {

    private DatosLaborales datosLaborales;
    private ArrayList<String> listaBeneficios;
    private ArrayList<Periodo> periodos = new ArrayList<>();
    private static final String FEC_FIN_PT1 = "1990-12-31";
    private static final String FEC_FIN_OSPT1 = "1962-01-11";
    private static final String FEC_INI_EC2 = "1962-07-12";
    private static final String FEC_FIN_EC2T1 = "1979-09-30";
    private static final String FEC_FIN_EC2T2 = "1989-12-31";
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
                break;
            default:
                System.out.println("Beneficio no contemplado");
        }
    }

    public ArrayList<Periodo> crearPeriodos(ArrayList<Periodo> perlista, LocalDate ffPer, LocalDate foUtil, LocalDate ffUtil){
        LocalDate fecIniPer;
        LocalDate fecFinPer;
        Period tmpToFin;
        Periodo per;
        int np = 0;
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        if(perlista.size()==0){
            fecIniPer = foUtil;
        } else {
            listPeriodos = perlista;
            fecIniPer = perlista.get(perlista.size() - 1).getFecFin().plusDays(1);
            np = perlista.get(perlista.size() - 1).getNumPer();
        }
        if(ffUtil.isBefore(ffPer)){
            fecFinPer = ffUtil;
        } else{
            fecFinPer = ffPer;
        }
        tmpToFin = fecIniPer.until(fecFinPer);
        // a = años, para un periodo anual
        for(int a=0;a<=tmpToFin.getYears();a++){
            per = new Periodo();
            np++;
            per.setNumPer(np);
            per.setFecIni(fecIniPer.plusYears(a).plusDays(a));
            if(per.getFecIni().plusYears(1).isAfter(fecFinPer.minusDays(a+1))){
                per.setFecFin(fecFinPer);
                listPeriodos.add(per);
                break;
            } else{
                per.setFecFin(per.getFecIni().plusYears(1));
                listPeriodos.add(per);
            }
        }
        return listPeriodos;
    }

    public ArrayList<Periodo> crearPeriodos2(ArrayList<Periodo> perlista, LocalDate ffPer, LocalDate foUtil, LocalDate ffUtil){
        LocalDate fecIniPer;
        LocalDate fecFinPer;
        Period tmpToFin;
        Periodo per;
        int b = 0;
        int np = 1;
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        if(perlista.size()==0){
            fecIniPer = foUtil;
        } else {
            listPeriodos = perlista;
            fecIniPer = perlista.get(perlista.size() - 1).getFecFin().plusDays(1);
            np = perlista.get(perlista.size() - 1).getNumPer() + 1;
        }
        if(ffUtil.isBefore(ffPer)){
            fecFinPer = ffUtil;
        } else{
            fecFinPer = ffPer;
        }

        per = new Periodo();
        per.setNumPer(np);
        per.setFecIni(fecIniPer);

        if((per.getFecIni().isAfter(LocalDate.of(fecIniPer.getYear(),1,1).minusDays(1))&&
                per.getFecIni().isBefore(LocalDate.of(per.getFecIni().getYear(),5,1)))||
                ((per.getFecIni().isAfter(LocalDate.of(fecIniPer.getYear(),11,1).minusDays(1))&&
                        per.getFecIni().isBefore(LocalDate.of(per.getFecIni().getYear()+1,1,1))))){

            per.setFecFin(LocalDate.of(per.getFecIni().getYear(),4,30));
            listPeriodos.add(per);
            fecIniPer = per.getFecFin().plusDays(1);


        }else if (per.getFecIni().isAfter(LocalDate.of(fecIniPer.getYear(),5,1).minusDays(1))&&
                per.getFecIni().isBefore(LocalDate.of(per.getFecIni().getYear(),11,1))){

            per.setFecFin(LocalDate.of(per.getFecIni().getYear(),10,31));
            listPeriodos.add(per);
            fecIniPer = per.getFecFin().plusDays(1);
        }
        np++;
        tmpToFin = fecIniPer.until(fecFinPer);

        for(int a=0;a<=tmpToFin.toTotalMonths();a=a+6){
            per = new Periodo();
            per.setNumPer(np);
            per.setFecIni(fecIniPer.plusMonths(a));
            if(per.getFecIni().plusMonths(6).isAfter(fecFinPer.minusDays(b+1))){
                per.setFecFin(fecFinPer);
                listPeriodos.add(per);
                break;
            } else{
                per.setFecFin(per.getFecIni().plusMonths(6).minusDays(1));
                listPeriodos.add(per);
            }
            b++;
            np++;
        }
        return listPeriodos;
    }

    public ArrayList<Periodo> crearPeriodos3(ArrayList<Periodo> perlista, LocalDate ffPer, LocalDate foUtil, LocalDate ffUtil){
        LocalDate fecIniPer;
        LocalDate fecFinPer;
        Period tmpToFin;
        Periodo per;
        int b = 0;
        int np = 1;
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        if(perlista.size()==0){
            fecIniPer = foUtil;
        } else {
            listPeriodos = perlista;
            fecIniPer = perlista.get(perlista.size() - 1).getFecFin().plusDays(1);
            np = perlista.get(perlista.size() - 1).getNumPer() + 1;
        }
        if(ffUtil.isBefore(ffPer)){
            fecFinPer = ffUtil;
        } else{
            fecFinPer = ffPer;
        }

        per = new Periodo();
        per.setNumPer(np);
        per.setFecIni(fecIniPer);

        per.setFecFin(per.getFecIni().withDayOfMonth(1).plusMonths(1).minusDays(1));
        listPeriodos.add(per);
        fecIniPer = per.getFecFin().plusDays(1);

        np++;
        tmpToFin = fecIniPer.until(fecFinPer);

        for(int a=0;a<=tmpToFin.toTotalMonths() + b ;a++){
            per = new Periodo();
            per.setNumPer(np);
            per.setFecIni(fecIniPer.plusMonths(a));
            if(per.getFecIni().plusMonths(1).isAfter(fecFinPer.minusDays(1))){ // Ojo aquí con las demas funciones minusdays(1)
                per.setFecFin(fecFinPer);
                listPeriodos.add(per);
                System.out.println("ROMPIO CON F0: " + per.getFecIni() + " FF: " + per.getFecFin());
                break;
            } else{
                per.setFecFin(per.getFecIni().plusMonths(1).minusDays(1));
                listPeriodos.add(per);
            }
            np++;
        }
        return listPeriodos;
    }

    public ArrayList<Periodo> crearPeriodos4(ArrayList<Periodo> perlista, LocalDate foUtil, LocalDate ffUtil){
        LocalDate fecIniPer;
        LocalDate fecFinPer;
        Period tmpToFin;
        Periodo per;
        int b = 0;
        int np = 1;
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        if(perlista.size()==0){
            fecIniPer = foUtil;
        } else {
            listPeriodos = perlista;
            fecIniPer = perlista.get(perlista.size() - 1).getFecFin().plusDays(1);
            np = perlista.get(perlista.size() - 1).getNumPer() + 1;
        }

        fecFinPer = ffUtil;

        per = new Periodo();
        per.setNumPer(np);
        per.setFecIni(fecIniPer);

        if((per.getFecIni().isAfter(LocalDate.of(fecIniPer.getYear(),1,1).minusDays(1))&&
                per.getFecIni().isBefore(LocalDate.of(per.getFecIni().getYear(),5,1)))||
                ((per.getFecIni().isAfter(LocalDate.of(fecIniPer.getYear(),11,1).minusDays(1))&&
                        per.getFecIni().isBefore(LocalDate.of(per.getFecIni().getYear()+1,1,1))))){

            per.setFecFin(LocalDate.of(per.getFecIni().getYear(),4,30));
            listPeriodos.add(per);
            fecIniPer = per.getFecFin().plusDays(1);


        }else if (per.getFecIni().isAfter(LocalDate.of(fecIniPer.getYear(),5,1).minusDays(1))&&
                per.getFecIni().isBefore(LocalDate.of(per.getFecIni().getYear(),11,1))){

            per.setFecFin(LocalDate.of(per.getFecIni().getYear(),10,31));
            listPeriodos.add(per);
            fecIniPer = per.getFecFin().plusDays(1);
        }
        np++;
        tmpToFin = fecIniPer.until(fecFinPer);

        for(int a=0;a<=tmpToFin.toTotalMonths();a=a+6){
            per = new Periodo();
            per.setNumPer(np);
            per.setFecIni(fecIniPer.plusMonths(a));
            if(per.getFecIni().plusMonths(6).isAfter(fecFinPer.minusDays(b+1))){
                per.setFecFin(fecFinPer);
                listPeriodos.add(per);
                break;
            } else{
                per.setFecFin(per.getFecIni().plusMonths(6).minusDays(1));
                listPeriodos.add(per);
            }
            b++;
            np++;
        }
        return listPeriodos;
    }

    public void printPeriodosCts(){
        System.out.println("Fecha de Ingreso: "+ datosLaborales.getFecVincul());
        LocalDate f0 = datosLaborales.getFecVincul();
        LocalDate fi = null;
        LocalDate ff = null;
        Period timeToFinPer = null;
        int p = 0;

        /*  Periodos CTS de la Reserva  */
        if(datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_PT1).plusDays(1)))){
            System.out.println("Periodos CTS de la Reserva: ");

            /*  Tipo de vinculo = 'Obrero'  */
            if(datosLaborales.getTipVinculo().equalsIgnoreCase("Obrero")) {
                System.out.println("\tCaso: 'Obrero'");

                /*  Sub-Periodo Tipo 1  */
                if(datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_OSPT1).plusDays(1)))) {
                    System.out.println("\t\tCaso 01");
                    periodos = crearPeriodos(new ArrayList<Periodo>(), LocalDate.parse(FEC_FIN_OSPT1), f0, datosLaborales.getFecCese());
                    periodos = crearPeriodos(periodos, LocalDate.parse(FEC_FIN_PT1), f0, datosLaborales.getFecCese());
                    periodos = crearPeriodos2(periodos, LocalDate.parse(FEC_FIN_PT2), f0, datosLaborales.getFecCese());
                    periodos = crearPeriodos3(periodos, LocalDate.parse(FEC_FIN_PT3), f0, datosLaborales.getFecCese());
                }

                /*  Sub-Periodo Tipo 2  */
                else{
                    System.out.println("\t\tCaso 02");
                    periodos = crearPeriodos(new ArrayList<Periodo>(), LocalDate.parse(FEC_FIN_PT1), f0, datosLaborales.getFecCese());
                    periodos = crearPeriodos2(periodos, LocalDate.parse(FEC_FIN_PT2), f0, datosLaborales.getFecCese());
                    periodos = crearPeriodos3(periodos, LocalDate.parse(FEC_FIN_PT3), f0, datosLaborales.getFecCese());
                }
            }

            /*  Tipo de vinculo = 'Empleado'  */
            else if(datosLaborales.getTipVinculo().equalsIgnoreCase("Empleado")) {
                System.out.println("Caso: 'Empleado'");

                /*  Caso 1  */
                if(datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_INI_EC2)))){
                    System.out.println("Caso de Ingreso 1:");
                    periodos = crearPeriodos(new ArrayList<Periodo>(), LocalDate.parse(FEC_FIN_PT1), f0, datosLaborales.getFecCese());
                    periodos = crearPeriodos2(periodos, LocalDate.parse(FEC_FIN_PT2), f0, datosLaborales.getFecCese());
                    periodos = crearPeriodos3(periodos, LocalDate.parse(FEC_FIN_PT3), f0, datosLaborales.getFecCese());
                }

                /*  Caso 2  */
                else if(datosLaborales.getFecVincul().isAfter((LocalDate.parse(FEC_INI_EC2).minusDays(1)))){
                    System.out.println("Caso de Ingreso 2:");

                    /*  Sub-Sub-Periodo Tipo 1  */
                    if(datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_EC2T1).plusDays(1)))) {
                        System.out.println("\t\tSub-Periodo Tipo 1");
                        periodos = crearPeriodos(new ArrayList<Periodo>(), LocalDate.parse(FEC_FIN_EC2T1), f0, datosLaborales.getFecCese());
                        periodos = crearPeriodos(periodos, LocalDate.parse(FEC_FIN_EC2T2), f0, datosLaborales.getFecCese());
                        periodos = crearPeriodos(periodos, LocalDate.parse(FEC_FIN_PT1), f0, datosLaborales.getFecCese());
                        periodos = crearPeriodos2(periodos, LocalDate.parse(FEC_FIN_PT2), f0, datosLaborales.getFecCese());
                        periodos = crearPeriodos3(periodos, LocalDate.parse(FEC_FIN_PT3), f0, datosLaborales.getFecCese());
                    }

                    /*  Sub-Sub-Periodo Tipo 2  */
                    if((datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_EC2T2).plusDays(1))))&&(datosLaborales.getFecVincul().isAfter((LocalDate.parse(FEC_FIN_EC2T1).minusDays(1))))) {
                        System.out.println("\t\tSub-Periodo Tipo 2");
                        periodos = crearPeriodos(new ArrayList<Periodo>(), LocalDate.parse(FEC_FIN_EC2T2), f0, datosLaborales.getFecCese());
                        periodos = crearPeriodos(periodos, LocalDate.parse(FEC_FIN_PT1), f0, datosLaborales.getFecCese());
                        periodos = crearPeriodos2(periodos, LocalDate.parse(FEC_FIN_PT2), f0, datosLaborales.getFecCese());
                        periodos = crearPeriodos3(periodos, LocalDate.parse(FEC_FIN_PT3), f0, datosLaborales.getFecCese());
                    }

                    /*  Sub-Sub-Periodo Tipo 3  */
                    if((datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_PT1).plusDays(1))))&&(datosLaborales.getFecVincul().isAfter((LocalDate.parse(FEC_FIN_EC2T2).minusDays(1))))) {
                        System.out.println("\t\tSub-Periodo Tipo 3");
                        periodos = crearPeriodos(new ArrayList<Periodo>(), LocalDate.parse(FEC_FIN_PT1), f0, datosLaborales.getFecCese());
                        periodos = crearPeriodos2(periodos, LocalDate.parse(FEC_FIN_PT2), f0, datosLaborales.getFecCese());
                        periodos = crearPeriodos3(periodos, LocalDate.parse(FEC_FIN_PT3), f0, datosLaborales.getFecCese());
                    }
                }
            }

            /*  Tipo de vinculo = 'Unknown'  */
            else {
                System.out.println("Error: El tipo de vinculo no fue contemplado");
            }
        }

        /*  Periodos CTS Tipo 2: Semestral  */
        else if(datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_PT2).plusDays(1)))&&(datosLaborales.getFecVincul().isAfter((LocalDate.parse(FEC_FIN_PT1).minusDays(1))))){
            System.out.println("Periodos CTS Tipo 2 Semestral: ");
            periodos = crearPeriodos2(new ArrayList<Periodo>(), LocalDate.parse(FEC_FIN_PT2), f0, datosLaborales.getFecCese());
            periodos = crearPeriodos3(periodos, LocalDate.parse(FEC_FIN_PT3), f0, datosLaborales.getFecCese());

        }

        /*  Periodos CTS Tipo 3: Mensual  */
        else if(datosLaborales.getFecVincul().isBefore((LocalDate.parse(FEC_FIN_PT3).plusDays(1)))&&(datosLaborales.getFecVincul().isAfter((LocalDate.parse(FEC_FIN_PT2).minusDays(1))))){
            System.out.println("Periodos CTS Tipo 3: Mensual ");
            periodos = crearPeriodos3(new ArrayList<Periodo>(), LocalDate.parse(FEC_FIN_PT3), f0, datosLaborales.getFecCese());
            periodos = crearPeriodos4(periodos, f0, datosLaborales.getFecCese());
        }

        /*  Periodos CTS Tipo 4: Semestral */
        else if(datosLaborales.getFecVincul().isAfter(LocalDate.parse(FEC_INI_PT4).minusDays(1))){
            System.out.println("Periodos CTS Tipo 4: Semestral ");
            periodos = crearPeriodos4(new ArrayList<Periodo>(), f0, datosLaborales.getFecCese());
        }

        /*  Recorriendo los periodos    */
        for(Periodo per : periodos){
            System.out.println("\t\t\tPeriodo N°" + per.getNumPer() + " \t(" + per.getFecIni() + " - " + per.getFecFin() + ")" + "\tTmpo. Computable: " + per.getFecIni().until(per.getFecFin()).getYears() + " años " + per.getFecIni().until(per.getFecFin()).getMonths() + " meses " + per.getFecIni().until(per.getFecFin()).getDays() + " dias");
        }
    }
}
