package chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Box;

public class Server extends JFrame implements ActionListener {

    JTextField text;
    JPanel a1;
    Box vertical = Box.createVerticalBox();

    Server() {
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        add(p1);

        // Header elements
        setupHeader(p1);

        a1 = new JPanel();
        a1.setLayout(new BoxLayout(a1, BoxLayout.Y_AXIS)); // Use BoxLayout here
        JScrollPane scrollPane = new JScrollPane(a1); // Wrap a1 in a JScrollPane
        scrollPane.setBounds(5, 70, 500, 490); // Set the bounds for the scroll pane
        add(scrollPane);

        text = new JTextField();
        text.setBounds(5, 570, 300, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(text);

        JButton send = new JButton("send");
        send.setBounds(300, 570, 90, 40);
        send.setBackground(new Color(7, 70, 80));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(send);

        setSize(410, 650);
        setLocation(200, 50);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    private void setupHeader(JPanel panel) {
        ImageIcon backIcon = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image backImage = backIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        JLabel back = new JLabel(new ImageIcon(backImage));
        back.setBounds(5, 15, 25, 25);
        panel.add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        ImageIcon profileIcon = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image profileImage = profileIcon.getImage().getScaledInstance(44, 50, Image.SCALE_DEFAULT);
        JLabel profile = new JLabel(new ImageIcon(profileImage));
        profile.setBounds(40, 10, 50, 50);
        panel.add(profile);

      ImageIcon videoIcon = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
      Image videoImage = videoIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        JLabel video = new JLabel(new ImageIcon(videoImage));
        video.setBounds(290, 20, 35, 35);
        panel.add(video);

        ImageIcon phoneIcon = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image phoneImage = phoneIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        JLabel phone = new JLabel(new ImageIcon(phoneImage));
        phone.setBounds(340, 20, 35, 35);
        panel.add(phone);

        ImageIcon pointIcon = new ImageIcon(ClassLoader.getSystemResource("icons/point.png"));
        Image pointImage = pointIcon.getImage().getScaledInstance(9, 25, Image.SCALE_DEFAULT);
        JLabel point = new JLabel(new ImageIcon(pointImage));
        point.setBounds(380, 25, 10, 25);
        panel.add(point);

        JLabel name = new JLabel("PRITI");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        panel.add(name);

        JLabel status = new JLabel("Online");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        panel.add(status);
    }

    public void actionPerformed(ActionEvent ae) {
        String message = text.getText();
        JLabel sentMessage = new JLabel("<html><div style='text-align: right;'>" + message + "</div></html>");
        JPanel messagePanel = new JPanel();

        messagePanel.add(sentMessage);
        a1.add(messagePanel);
        a1.add(Box.createVerticalStrut(25));
        text.setText("");
        a1.revalidate();
    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    public static void main(String args[]) {
        new Server();
    }
}
