/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

import java.awt.*;
import java.awt.image.ImageProducer;

/**
 *
 * @author fauzan
 */
public class ImageCanvas extends Canvas{

    Image img;
    public ImageCanvas(String Path) {
        MediaTracker media = new MediaTracker(this);
        img = Toolkit.getDefaultToolkit().getImage(Path);
        media.addImage(img, 0);
        super.setSize(1024, 768);
        try{
            media.waitForID(0);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    public ImageCanvas() {
    }
    

//    public ImageCanvas(ImageProducer imageProducer) {
//        img = createImage(imageProducer);
//    }
    
    @Override
    public void paint(Graphics g){
       g.drawImage(img, WIDTH, WIDTH, this);
        //g.drawImage(img, 800, 600, this);
     //g.drawImage(img, 0,0, this);   
    }

    @Override
    public void update(Graphics grphcs) {
        super.update(grphcs);
    }
    
    
    
}
