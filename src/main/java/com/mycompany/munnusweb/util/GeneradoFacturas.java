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

    public Path geneerarFactura(List<Propietario> propietarios, Factura factura, Vivienda vivienda) throws ExcepcionNegocio {



        Path archivoTexo = Paths.get("factura.txt");




       StringBuilder  data =  new  StringBuilder("Informacion Factura");
       for (Propietario propietario : propietarios) {
           data.append("Propietario: ").append(propietario.getNombres());
           data.append("Deirecion: ").append(propietario.getNombres());
        
       }



        try {
            Files.write(archivoTexo, data.toString().getBytes());

        } catch (IOException ex) {

            ex.printStackTrace();
            throw new ExcepcionNegocio("Se produjo un error al genera factura"+ ex.getMessage());

        }


        


        



    

        return null; 
    }
    
}
