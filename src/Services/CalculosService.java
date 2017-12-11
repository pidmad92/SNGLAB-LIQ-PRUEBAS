package Services;

import model.DatosLaborales;
import model.Periodo;

import java.util.ArrayList;

public class CalculosService {

    private DatosLaborales datosLaborales;
    private ArrayList<Periodo> periodos = new ArrayList<>();

    public CalculosService() {
    }

    public CalculosService(DatosLaborales datosLaborales, ArrayList<Periodo> periodos) {
        this.datosLaborales = datosLaborales;
        this.periodos = periodos;
    }

    public ArrayList<Periodo> CalcularCTS(){
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        return listPeriodos;
    }

    public ArrayList<Periodo> CalcularGrati(){
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        return listPeriodos;
    }

    public ArrayList<Periodo> CalcularBonExt(){
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        return listPeriodos;
    }

    public ArrayList<Periodo> CalcularIndem(){
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        return listPeriodos;
    }

    public ArrayList<Periodo> CalcularVacac(){
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        return listPeriodos;
    }

    public ArrayList<Periodo> CalcularRemIns(){
        ArrayList<Periodo> listPeriodos = new ArrayList<Periodo>();
        return listPeriodos;
    }

}
