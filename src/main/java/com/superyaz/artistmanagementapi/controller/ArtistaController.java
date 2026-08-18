package com.superyaz.artistmanagementapi.controller;

import com.superyaz.artistmanagementapi.model.Artista;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    private List<Artista> coleccionArtistas = new ArrayList<>();

    // 1. Ruta para almacenar artistas (sin costos iniciales)
    @PostMapping("/registrar")
    public String registrarArtista(@RequestBody Artista artista) {
        artista.setCostoFamiliar(null);
        artista.setCostoEmpresarial(null);
        artista.setCostoInfantil(null);
        coleccionArtistas.add(artista);
        return "Artista almacenado con éxito. Recuerde registrar los costos en la ruta correspondiente.";
    }

    // 1.1 Ruta para registrar los costos de las funciones
    @PutMapping("/{identificacion}/costos")
    public String registrarCostos(
            @PathVariable String identificacion,
            @RequestParam Double costoFamiliar,
            @RequestParam Double costoEmpresarial,
            @RequestParam Double costoInfantil) {
        
        for (Artista artista : coleccionArtistas) {
            if (artista.getIdentificacion().equals(identificacion)) {
                artista.setCostoFamiliar(costoFamiliar);
                artista.setCostoEmpresarial(costoEmpresarial);
                artista.setCostoInfantil(costoInfantil);
                return "Costos registrados correctamente para el artista: " + identificacion;
            }
        }
        return "Artista no encontrado.";
    }

    // 2. Ruta para mostrar el listado de los artistas
    @GetMapping("/listado")
    public List<Artista> listarArtistas() {
        return coleccionArtistas;
    }

    // 3. Ruta para buscar un artista y mostrar su información
    @GetMapping("/{identificacion}")
    public Artista buscarArtista(@PathVariable String identificacion) {
        return coleccionArtistas.stream()
                .filter(a -> a.getIdentificacion().equals(identificacion))
                .findFirst()
                .orElse(null);
    }

    // 4. Ruta para calcular el valor a cobrar
    @GetMapping("/{identificacion}/calcular")
    public String calcularCobro(
            @PathVariable String identificacion,
            @RequestParam String tipoFuncion, 
            @RequestParam Double horasContratadas) {
        
        Artista artista = buscarArtista(identificacion);
        if (artista == null) return "Artista no encontrado.";

        Double costoPorHora = 0.0;

        switch (tipoFuncion.toLowerCase()) {
            case "familiar":
                costoPorHora = artista.getCostoFamiliar();
                break;
            case "empresarial":
                costoPorHora = artista.getCostoEmpresarial();
                break;
            case "infantil":
                costoPorHora = artista.getCostoInfantil();
                break;
            default:
                return "Tipo de función no válido. Use: familiar, empresarial o infantil.";
        }

        if (costoPorHora == null) return "El costo para este tipo de función no ha sido registrado.";

        double total = costoPorHora * horasContratadas;
        return "El valor a cobrar por " + horasContratadas + " horas de función " + tipoFuncion + " es: $" + total;
    }
}
