/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


/**
 *
 * @author fauzan
 */
public class ImageView extends JFrame implements ActionListener{
    
    private String FolderPath;
    
    int arraySize;
    int nowLocation;
    Button next = new Button("Next");
    Button previous = new Button("Previous");
    Frame frame = new Frame();
    ImageCanvas ic;
    Canvas mycanvas = new Canvas();
    Image image;
    
    public int getArraySize() {
        return arraySize;
    }

    public int getNowLocation() {
        return nowLocation;
    }

    public void setNowLocation(int nowLocation) {
        this.nowLocation = nowLocation;
    }
    
    
    
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
    
    private WindowListener WindowEvent;
    
    public ImageView(String Path) {
        this.setFolderPath(Path);
        this.setNowLocation(0);
    }

    public ImageView() {
        this.setNowLocation(0);
    }
    
    

    public String getFolderPath() {
        return FolderPath;
    }

    public void setFolderPath(String FolderPath) {
        this.FolderPath = FolderPath;
    }
    
    public List<String> ScanFileImage(){
        
        File file = new File(this.getFolderPath());
        List<String> contents = new ArrayList<String>();
        for (int i = 0; i < file.list().length; i++) {
            if (file.listFiles()[i].isDirectory()) {
                continue;
            }else{
                if (file.list()[i].toCharArray()[0] == '.') {
                    continue;
                }else{                    
                    try {
                        String[] splits = file.list()[i].toString().split("\\.");
                        String mini = splits[splits.length-1].toLowerCase();
                        //System.out.println(mini);
                        if (mini.equals("jpg") || mini.equals("jpeg") || mini.equals("png") || mini.equals("gif") || mini.equals("tiff")) {
                            contents.add(file.listFiles()[i].toString());
                        }else{
                            continue;
                        }
                    }catch(Exception e){
                        System.out.println(e);
                        continue;
                    }
                }
            }
        }
        return contents;
    }
    
    
    public void PopUp(){
        
        this.next.setBounds(60, 400, 220, 30);
        this.previous.setBounds(60, 400, 220, 30);
        this.frame.add(previous);
        this.frame.add(next);
        this.next.addActionListener(this);
        this.previous.addActionListener(this);
        this.ic = new ImageCanvas(this.ScanFileImage().toArray()[this.getNowLocation()].toString());
        this.frame.add(this.ic);
        //this.image = Toolkit.getDefaultToolkit().createImage(this.ScanFileImage().toArray()[this.getNowLocation()].toString());
        
        this.frame.setSize(1024, 768);
        this.frame.setLayout(new FlowLayout());
        this.frame.setVisible(true);
        this.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                frame.dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setArraySize(this.ScanFileImage().size());
        if (ae.getSource() == this.next) {
            if (this.getNowLocation() == this.getArraySize()-1) {
                this.setNowLocation(0);
                
            }else{
                this.setNowLocation(this.getNowLocation()+1);
            }
            System.out.println(this.getNowLocation());
        }else if(ae.getSource() == this.previous){
            if (this.getNowLocation() == 0) {
                this.setNowLocation(this.getArraySize()-1);
            }else{
                this.setNowLocation(this.getNowLocation()-1);
            }
            System.out.println(this.getNowLocation());
        }else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
        this.ic.repaint();
        this.frame.remove(this.ic);
        this.ic = new ImageCanvas(this.ScanFileImage().toArray()[this.getNowLocation()].toString());
        this.frame.add(ic);
        this.frame.repaint();
    }
    
    
}
