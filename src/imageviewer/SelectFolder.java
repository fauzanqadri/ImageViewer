/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author fauzan
 */
public class SelectFolder extends javax.swing.JFrame {

    /**
     * Creates new form SelectFolder
     */
    public SelectFolder() {
        initComponents();
        choose = new JFileChooser();
        choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FolderPath = new javax.swing.JTextField();
        ScanDirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FolderPath.setEditable(false);
        FolderPath.setText("Click To Select Image Folder");
        FolderPath.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FolderPathMouseClicked(evt);
            }
        });

        ScanDirButton.setText("Open");
        ScanDirButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScanDirButtonMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(FolderPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ScanDirButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(FolderPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ScanDirButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FolderPathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FolderPathMouseClicked
        File NameDir,NamePath;
        int checker = choose.showOpenDialog(null);
        if (checker == JFileChooser.APPROVE_OPTION) {
             NamePath = choose.getSelectedFile();
             this.FolderPath.setText(NamePath.toString());
        }else{
            JOptionPane.showMessageDialog(null, "You have Clicked Cancel Button dude", "Cancel Dialog Box", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_FolderPathMouseClicked

    private void ScanDirButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScanDirButtonMouseClicked
        if (this.FolderPath.getText().equals("Click To Select Image Folder")) {
            JOptionPane.showMessageDialog(null, "You didn't choose path dude", "Cancel Dialog Box", JOptionPane.WARNING_MESSAGE);
        }
        else{
           ImageView iv = new ImageView(this.FolderPath.getText());
           iv.PopUp();
        }
    }//GEN-LAST:event_ScanDirButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SelectFolder().setVisible(true);
            }
        });
    }
    
    private javax.swing.JFileChooser choose;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FolderPath;
    private javax.swing.JButton ScanDirButton;
    // End of variables declaration//GEN-END:variables
}
