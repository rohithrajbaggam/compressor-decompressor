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
//        compressButton.setBounds(20, 100, 200, 30);
        compressButton.setBounds(350, 100, 300, 30);
        compressButton.addActionListener(this);
        // this statement is used to get sources. like in actionPerformed we have ActionEvent e and statement create a source that helps to rise an action when it was called


        decompressButton = new JButton("Select file to decompress");
//        decompressButton.setBounds(20, 400, 200, 30);
        decompressButton.setBounds(350, 200, 300, 30);
        decompressButton.addActionListener(this);

        // this statement is used to get sources. like in actionPerformed we have ActionEvent e and statement create a source that helps to rise an action when it was called

//        this.add(compressButton);
//        this.add(decompressButton);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(compressButton);
        buttonPanel.add(decompressButton);
        buttonPanel.setBackground(Color.DARK_GRAY);

        /*
         a new JPanel is created with FlowLayout and the buttons are added to the panel. Then the panel is added to the content pane of the JFrame.
         With this change, the compressButton and decompressButton should be arranged side-by-side in a row.
         */
        this.add(buttonPanel);
        this.setSize(1000, 500);
        this.setBackground(Color.BLACK);
        this.getContentPane().setBackground(Color.BLACK);
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
