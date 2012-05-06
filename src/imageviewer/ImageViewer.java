/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

/**
 *
 * @author fauzan
 */
public class ImageViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ex = "1,2,3,4,my,name. is F,aUz,an";
        String[] splits = ex.split("");
        for (String split : splits) {
            System.out.println(split);
        }
    }
}
