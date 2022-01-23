/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateurcoco;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Sevrin
 */
public class GenerateurCOCO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
      ArrayList<String> list = new ArrayList();
      ArrayList<String> listFinal = new ArrayList();
      File dir  = new File("C:\\Users\\Sevrin\\Documents\\COURS\\ESIREM\\5A\\IA\\FaceMaskDetection\\data\\coco\\images\\val2017");
      File listtm[] = dir.listFiles();
      for (File file : listtm) {
            if (!file.isDirectory() && file.getName() != null) {
                    //System.out.println("Nom du fichier: "+ file.getName()); 
                    list.add(file.getName());
            }
    }
      
      //=============
      
      String path="./images/val2017/";
      for(String str : list){
          listFinal.add(path+str);
          System.out.println(path+str);
      }
      
        Path fichier = Paths.get("valpath.txt");
          //La commande suivante écrit les lignes en écrasant le texte déjà présent dans le fichier
        Files.write(fichier, listFinal, Charset.forName("UTF-8"));

    } 
 
    
}
