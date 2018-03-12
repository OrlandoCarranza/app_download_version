/* 
 * 
 * 
 * 
 */
package Clases;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Orlando Carranza P.
 */
public class SearchUpdate {

    public static boolean conexion() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/OrlandoCarranza/App-que-cambia-version/master/version.txt");
            URLConnection con = url.openConnection();
            con.connect();
            System.out.println((char)27 + "[32mConexión éxitosa con: ");
            System.out.println((char)27 + "[32m     " + con);
        } catch (IOException ex) {
            System.out.println((char)27 + "[31mNo se puede conectar con: ");
            System.out.println((char)27 + "[31m     " + ex.getMessage());
            return false;
        }
        return true;
    }

    public static String obtenerVersion() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/OrlandoCarranza/App-que-cambia-version/master/version.txt");
            URLConnection con = url.openConnection();
            con.connect();
            return obtenerContenidoURL(url);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static String obtenerContenidoURL(URL url) {
        try {
            Scanner s = new Scanner(url.openStream()).useDelimiter("\\Z");
            String contenido = s.next();
            return contenido;
        } catch (IOException ex) {
            Logger.getLogger(SearchUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void abrirEnlace(String url){
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(SearchUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
