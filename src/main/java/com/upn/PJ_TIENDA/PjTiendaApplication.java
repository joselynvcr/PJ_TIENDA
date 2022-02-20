package com.upn.PJ_TIENDA;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PjTiendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PjTiendaApplication.class, args);
//        Date date = new Date();
//
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        System.out.println(formatter.format(date));
//        LocalDateTime ldt = LocalDateTime.now();
//        System.out.println(Timestamp.valueOf(ldt));

        List<String> canciones = new ArrayList<>();
        List<String> songs = new ArrayList<>();
// Le agregamos datos
        canciones.add("Ashes to ashes");
        canciones.add("Beds are burning");
        canciones.add("It's only rock 'n' Roll (But I like it)");
        System.out.println("Recorriendo con método 1");

        for (String cancion : canciones) {

            if (cancion.equals("Ashes to ashes")|| cancion.equals("Beds are burning")) {
                songs.add(cancion);
                System.out.println(songs);
                
            }

        }
        
//        canciones.forEach((cancion) -> {
//            
//            if (cancion.equals("Ashes to ashes") || cancion.equals("Beds are burning")) {
//                songs.add(cancion);
//                System.out.println(songs);
//                
//            }
//        });


    }

}
