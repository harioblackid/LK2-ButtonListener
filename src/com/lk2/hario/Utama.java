package com.lk2.hario;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Hario
 */
public class Utama {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   
   public Utama(){
      prepareGUI();
   }
   
   public static void main(String[] args){
      Utama UI = new Utama();  
      UI.showEventDemo();       
   }
   
   private void prepareGUI(){
      mainFrame = new JFrame("Tugas LK2 Tambahan");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(200,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showEventDemo(){
      headerLabel.setText("Protokol COVID-19"); 

      JButton okButton = new JButton("Cuci Tangan");
      JButton submitButton = new JButton("Cara Batuk");

      okButton.setActionCommand("Cuci Tangan");
      submitButton.setActionCommand("Cara Batuk");

      okButton.addActionListener(new ButtonClickListener()); 
      submitButton.addActionListener(new ButtonClickListener()); 

      controlPanel.add(okButton);
      controlPanel.add(submitButton);

      mainFrame.setVisible(true);  
   }
   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         
         if( command.equals( "Cuci Tangan" ))  {
            statusLabel.setText(""
                    + "<html>"
                    + "1. Telapak Tangan <br> "
                    + "2. Punggung Tangan <br> "
                    + "3. Sela-sela Jari <br> "
                    + "4. Kunci Jari Tangan <br> "
                    + "5. Putar ibu jari dalam genggaman <br> "
                    + "6. Puar-putar ujung jari pada telapak tangan"
                    + "</html>");
         } else {
            statusLabel.setText("<html>"
                    + "1. Tutup mulut dan hidung saat batuk dengan lengan baju dalam atau tisu agar virus tak menyebar ke udara <br>"
                    + "2. Buang tisu yang telah dipakai buat batuk ke tong sampah <br>"
                    + "3. segera cuci tangan pakai air bersih atau hand sanitizer <br>" 
                    + "4. Gunakan masker."
                    + "</html>"); 
         }  	
      }		
   }
}