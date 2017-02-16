/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Zhewei
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  /** let's use the following zip code simply for the purpose of this 
      example (its the zip code for hollywood callifornia) */
  String zipCode = "91601";
  String latitude = "0";
  String longitude = "0";
try {
                    /**
                      JavaCVS api is required in order to read this, it can
                      be found at http://sourceforge.net/projects/javacsv/
                     **/
        CsvReader products = new CsvReader("db/zipcode.csv");
                    /** a cvs containing all the zip codes and latitudes
                        and longitudes can be found at: 
                        http://sourceforge.net/projects/zips/files/zips/zips.csv.zip/
                    **/
        products.readHeaders();
        int numOfHeaders = products.getHeaderCount();
        try {
            while (products.readRecord())
            {

            String lookedupZip = products.get(products.getHeader(0));
            if (lookedupZip.equals(zipCode)) {
                latitude = products.get(products.getHeader(2));
                longitude = products.get(products.getHeader(3));
                System.out.print(latitude);
                System.out.println(longitude);
            }

            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    } catch (IOException e2) {
        e2.printStackTrace();
    }
}
    
}
