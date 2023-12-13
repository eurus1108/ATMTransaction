package ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUp extends BaseFrame {
    public StartUp() {
        super("Welcome");
    }

    @Override
    protected void addGuiComponents() {
        JLabel headerLabel = new JLabel(header);
        headerLabel.setBounds(0, 20, getWidth() - 10, 40);
        headerLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel);

        JButton startButton = new JButton("Start Transaction");
        startButton.setBounds(15, 140, getWidth() - 50, 50);
        startButton.setFont(new Font("Dialog", Font.BOLD, 22));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });
        add(startButton);

        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(15, 200, getWidth() - 50, 50);
        quitButton.setFont(new Font("Dialog", Font.BOLD, 22));
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(quitButton);
    }
}
