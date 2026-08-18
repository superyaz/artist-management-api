package com.superyaz.artistmanagementapi.model;

public class Artista {
    private String identificacion;
    private String nombresApellidos;
    private String generoArtistico;
    
    // Costo de Funciones contratadas (Máximo 3)
    private Double costoFamiliar; 
    private Double costoEmpresarial;
    private Double costoInfantil;

    public Artista() {}

    // Getters y Setters
    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getNombresApellidos() { return nombresApellidos; }
    public void setNombresApellidos(String nombresApellidos) { this.nombresApellidos = nombresApellidos; }

    public String getGeneroArtistico() { return generoArtistico; }
    public void setGeneroArtistico(String generoArtistico) { this.generoArtistico = generoArtistico; }

    public Double getCostoFamiliar() { return costoFamiliar; }
    public void setCostoFamiliar(Double costoFamiliar) { this.costoFamiliar = costoFamiliar; }

    public Double getCostoEmpresarial() { return costoEmpresarial; }
    public void setCostoEmpresarial(Double costoEmpresarial) { this.costoEmpresarial = costoEmpresarial; }

    public Double getCostoInfantil() { return costoInfantil; }
    public void setCostoInfantil(Double costoInfantil) { this.costoInfantil = costoInfantil; }
}
