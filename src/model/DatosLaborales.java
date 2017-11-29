package model;

import java.time.LocalDate;

public class DatosLaborales {
    private Empleador empleador;
    private Trabajador trabajador;
    private LocalDate fecVincul;
    private String tipVinculo;
    private String tipRegimen;
    private LocalDate fecCese;

    public DatosLaborales() {
    }

    public DatosLaborales(Empleador empleador, Trabajador trabajador, LocalDate fecVincul, String tipVinculo, String tipRegimen, LocalDate fecCese) {
        this.empleador = empleador;
        this.trabajador = trabajador;
        this.fecVincul = fecVincul;
        this.tipVinculo = tipVinculo;
        this.tipRegimen = tipRegimen;
        this.fecCese = fecCese;
    }

    public Empleador getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Empleador empleador) {
        this.empleador = empleador;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public LocalDate getFecVincul() {
        return fecVincul;
    }

    public void setFecVincul(LocalDate fecVincul) {
        this.fecVincul = fecVincul;
    }

    public String getTipVinculo() {
        return tipVinculo;
    }

    public void setTipVinculo(String tipVinculo) {
        this.tipVinculo = tipVinculo;
    }

    public String getTipRegimen() {
        return tipRegimen;
    }

    public void setTipRegimen(String tipRegimen) {
        this.tipRegimen = tipRegimen;
    }

    public LocalDate getFecCese() {
        return fecCese;
    }

    public void setFecCese(LocalDate fecCese) {
        this.fecCese = fecCese;
    }
}
