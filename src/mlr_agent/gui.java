/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr_agent;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ftm
 */
public class gui extends JFrame {

    private agentMLR myAgent;
    private JTextField factor_1;
    private JTextField factor_2;

    gui(agentMLR agent) {
        super(agent.getLocalName());
        myAgent = agent;
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5, 2));
        p.add(new JLabel("Factor 1:"));
        factor_1 = new JTextField(15);
        p.add(factor_1);
        p.add(new JLabel("Factor 2:"));
        factor_2 = new JTextField(15);
        p.add(factor_2);

        getContentPane().add(p, BorderLayout.CENTER);

        JButton addButton = new JButton("Calcular The Normal equation approach ");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    String xValue2 = factor_2.getText().trim();
                    String xValue = factor_1.getText().trim();
                    myAgent.normalEquation(Double.parseDouble(xValue), Double.parseDouble(xValue2));
                    factor_1.setText("");
                    factor_2.setText("");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(gui.this, "valor invalido" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        JButton crammerButton = new JButton("Calcular The Crammer Approach");
        crammerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {         
                try {
                    String xValue2 = factor_2.getText().trim();
                    String xValue = factor_1.getText().trim();
                    myAgent.getX(xValue, xValue2);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(gui.this, "valor invalido" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        p = new JPanel();
        p.add(addButton);
        p.add(crammerButton);

        getContentPane().add(p, BorderLayout.SOUTH);
        setResizable(false);
    }

    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;
        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }

}
