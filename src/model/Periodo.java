package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Periodo {
    private BigDecimal calper;
    private BigDecimal calper2;
    private int numPer;
    private LocalDate fecIni;
    private LocalDate fecFin;
    private int tNoComput;
    private int dNoGozados;
    private int dAdeudos;
    private int anoBase;

    public Periodo() {
    }

    public Periodo(BigDecimal calper, BigDecimal calper2, int numPer, LocalDate fecIni, LocalDate fecFin, int tNoComput, int dNoGozados, int dAdeudos, int anoBase) {
        this.calper = calper;
        this.calper2 = calper2;
        this.numPer = numPer;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.tNoComput = tNoComput;
        this.dNoGozados = dNoGozados;
        this.dAdeudos = dAdeudos;
        this.anoBase = anoBase;
    }

    public BigDecimal getCalper() {
        return calper;
    }

    public void setCalper(BigDecimal calper) {
        this.calper = calper;
    }

    public BigDecimal getCalper2() {
        return calper2;
    }

    public void setCalper2(BigDecimal calper2) {
        this.calper2 = calper2;
    }

    public int getNumPer() {
        return numPer;
    }

    public void setNumPer(int numPer) {
        this.numPer = numPer;
    }

    public LocalDate getFecIni() {
        return fecIni;
    }

    public void setFecIni(LocalDate fecIni) {
        this.fecIni = fecIni;
    }

    public LocalDate getFecFin() {
        return fecFin;
    }

    public void setFecFin(LocalDate fecFin) {
        this.fecFin = fecFin;
    }

    public int gettNoComput() {
        return tNoComput;
    }

    public void settNoComput(int tNoComput) {
        this.tNoComput = tNoComput;
    }

    public int getdNoGozados() {
        return dNoGozados;
    }

    public void setdNoGozados(int dNoGozados) {
        this.dNoGozados = dNoGozados;
    }

    public int getdAdeudos() {
        return dAdeudos;
    }

    public void setdAdeudos(int dAdeudos) {
        this.dAdeudos = dAdeudos;
    }

    public int getAnoBase() {
        return anoBase;
    }

    public void setAnoBase(int anoBase) {
        this.anoBase = anoBase;
    }
}
