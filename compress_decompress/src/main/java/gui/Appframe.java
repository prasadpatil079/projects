package gui;

import groupid_comp_decomp.comp.decomp.Compress;
import groupid_comp_decomp.comp.decomp.Decompress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Appframe extends JFrame implements ActionListener {

    JButton decompressButton;
    JButton compressButton;
    public Appframe(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton=new JButton("Select file to compress ");
        compressButton.setBounds(20,200,220,30);
        compressButton.addActionListener(this);

        decompressButton=new JButton("Select file to decompress");
        decompressButton.setBounds(250,200,220,30);
        decompressButton.addActionListener(this);

        this.setTitle("Compress_Decompress");
        this.add(compressButton);
        this.add(decompressButton);

        this.setSize(500,500);
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(null);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compress.method(file);
                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompress.method(file);
                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
