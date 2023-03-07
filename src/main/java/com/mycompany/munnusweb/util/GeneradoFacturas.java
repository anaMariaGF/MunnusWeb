package com.mycompany.munnusweb.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.mycompany.munnusweb.domain.Factura;
import com.mycompany.munnusweb.domain.Propietario;
import com.mycompany.munnusweb.domain.Vivienda;

public class GeneradoFacturas {
    

    public Path geneerarFactura(List<Propietario> propietarios, Factura factura, Vivienda vivienda){



        
        Path archivoTexo = Paths.get("factura.txt");



       StringBuilder  data =  new  StringBuilder("Informacion Factura");
       
       for (Propietario propietario : propietarios) {
           data.append("Propietario: ").append(propietario.getNombres()).append(" ").append(propietario.getApellidos()).append("\n");
           data.append("Vivienda: ").append(vivienda.getDireccionVivienda()).append("\n\n");
           data.append("Periodo: ").append(factura.getPeriodo()).append("\n");
           data.append("Valor a pagar: ").append(factura.getValor()).append("\n");
        
       }

/*

        try {
           Files.write(archivoTexto, data.toString().getBytes());
            return archivoTexto;

        } catch (IOException e) {

            throw new ExcepcionNegocio("Se produjo un error al genera factura"+ ex.getMessage());
            
            e.printStackTrace();
        }*/


        return null; 
    }
    
}
