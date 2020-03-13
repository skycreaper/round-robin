/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.roundrobin.UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author juancamilo
 */
public class GUI extends JFrame{
    public Color c1 = new Color(85, 230, 193);  // rgb(85, 230, 193)
    public Color c2 = new Color(154, 236, 219);  // rgb(154, 236, 219)
    public Color c3 = new Color(223, 249, 251);

    public Font font = new Font("Agency FB", Font.BOLD, 34);
    public Font font2 = new Font("Agency FB", Font.BOLD, 20);
    
    public JLabel lblTitle = new JLabel();
    public JLabel lblAutorD = new JLabel();
    public JLabel lblAutorJ = new JLabel();
    public JPanel pnlHeader = new JPanel();
    public JPanel pnlSubHeader = new JPanel();
    public JPanel pnlContent = new JPanel();
    public JPanel pnlDiagram = new JPanel();
    public JTable tblProcess;
    public JTable tblDiagram;
    public JScrollPane scrollProcess;
    public JScrollPane scrollDiagram;
    public JButton btnStart = new JButton();
    private int screenWidth = 1020;
    private int screenHeigth = 720;

    
    
    
    public GUI() {
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("ROUND ROBIN");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawHeader();
        drawSubHeader();
        drawTableProcess();
        drawTableDiagram();
        
        setVisible(true);
        setSize(screenWidth, screenHeigth);
        
    }
    public void drawHeader(){
        add(pnlHeader);
        pnlHeader.setLayout(null);
        pnlHeader.setBounds(0, 0, screenWidth, 100);
        pnlHeader.setBackground(c1);
        pnlHeader.add(lblTitle);
        lblTitle.setText("ROUND ROBIN");
        lblTitle.setBounds(screenWidth / 2, 50, 300, 40);
        lblTitle.setFont(font);
        lblTitle.setForeground(c3);
    }
    public void drawSubHeader(){
        add(pnlSubHeader);
        pnlSubHeader.setLayout(null);
        pnlSubHeader.setBounds(0, 100, screenWidth, 75);
        pnlSubHeader.setBackground(c1);
        pnlSubHeader.add(lblAutorD);
        lblAutorD.setText("DAVID STEVEN SANTOS SANTOS");
        lblAutorD.setBounds(650, 10, 350, 20);
        lblAutorD.setFont(font2);
        pnlSubHeader.add(lblAutorJ);
        lblAutorJ.setText("JUAN CAMILO SARMIENTO REYES");
        lblAutorJ.setBounds(650, 33, 350, 20);
        lblAutorJ.setFont(font2);
        
    }
    public void drawTableProcess(){
        add(pnlContent);
        pnlContent.setLayout(null);
        pnlContent.setBounds(0, 175, screenWidth, 270);
        pnlContent.setBackground(c2);
        tblProcess = new JTable(5, 7);
        changeColumNames();
        scrollProcess = new JScrollPane(tblProcess);
        pnlContent.add(scrollProcess);
        scrollProcess.setBounds(100, 30, 850, 180);

    }
    public void drawTableDiagram(){
        add(pnlDiagram);
        pnlDiagram.setLayout(null);
        pnlDiagram.setBounds(0, 445, screenWidth, 270);
        pnlDiagram.setBackground(c2);
        tblDiagram = new JTable(5,10);
        scrollDiagram = new JScrollPane(tblDiagram);
        pnlDiagram.add(scrollDiagram);
        scrollDiagram.setBounds(100, 30, 850, 180);
    }
    public void changeColumNames() {
        JTableHeader tblHeader = tblProcess.getTableHeader();
        TableColumnModel tcm = tblHeader.getColumnModel();
        TableColumn tblColumn = tcm.getColumn(0);
        tblColumn.setHeaderValue("Proceso");
        TableColumn tblColumn2 = tcm.getColumn(1);
        tblColumn2.setHeaderValue("T. Llegada");
        TableColumn tblColumn3 = tcm.getColumn(2);
        tblColumn3.setHeaderValue("T. Rafaga");
        TableColumn tblColumn4 = tcm.getColumn(3);
        tblColumn4.setHeaderValue("T. Comienzo");
        TableColumn tblColumn5 = tcm.getColumn(4);
        tblColumn5.setHeaderValue("T. Final");
        TableColumn tblColumn6 = tcm.getColumn(5);
        tblColumn6.setHeaderValue("T. Retorno");
        TableColumn tblColumn7 = tcm.getColumn(6);
        tblColumn7.setHeaderValue("T. Espera");
        tblHeader.repaint();
    }
}
