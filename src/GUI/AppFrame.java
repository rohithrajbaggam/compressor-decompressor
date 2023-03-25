package GUI;
import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame implements ActionListener {
    // ActionListener is used for tracking event when some click that particular button to perform responsible action
    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(20, 100, 200, 30);
        compressButton.addActionListener(this);
        // this statement is used to get sources. like in actionPerformed we have ActionEvent e and statement create a source that helps to rise an action when it was called


        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(250, 100, 200, 30);
        decompressButton.addActionListener(this);
        // this statement is used to get sources. like in actionPerformed we have ActionEvent e and statement create a source that helps to rise an action when it was called

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.green);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if compressor event was raised
        if(e.getSource()==compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    compressor.method(file);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, error.toString());
                }
            }

        }
        // if decompressor event was raised
        if(e.getSource()==decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    decompressor.method(file);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, error.toString());
                }
            }

        }

    }
}
