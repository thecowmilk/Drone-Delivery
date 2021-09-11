import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.*;

public class application {
    public static void main(String[] args) {
        APP obj = new APP();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://uxkxkifhcxj67hpx:dKLI7ZyM6CcuGJ0PGgVh@bayk5r10ciurmkol7qws-mysql.services.clever-cloud.com:3306/bayk5r10ciurmkol7qws","uxkxkifhcxj67hpx","dKLI7ZyM6CcuGJ0PGgVh");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from login");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}


class APP extends JPanel implements ActionListener {


    class ImagePanel extends JPanel {
        Image image;
        public ImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
        }
    }

    JFrame frame = new JFrame();
    JPanel panel;




    public APP() {

        BufferedImage image;


        try{
            image = ImageIO.read(getClass().getResource("nice_drone.jpg"));
            this.setContentPane(new ImagePanel(image));
        }catch (IOException e){
            e.printStackTrace();
            image = null;
        }

        JLabel drone_delivery =  new JLabel("DRONE DELIVERY");
        drone_delivery.setFont(drone_delivery.getFont().deriveFont(20f));
        drone_delivery.setSize(300, 30);
        drone_delivery.setForeground(Color.WHITE);
        drone_delivery.setLocation(700, 40);


        JLabel user_lbl = new JLabel("Username");
        user_lbl.setLocation(600, 300);
        user_lbl.setSize(150, 20);
        user_lbl.setForeground(Color.WHITE);
        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        userText.setPreferredSize(new Dimension(150, 20));
        userText.setLocation(600, 320);
        new GhostText(userText, "Username");

        JLabel pass_lbl = new JLabel("Password");
        pass_lbl.setLocation(850, 300);
        pass_lbl.setSize(150, 20);
        pass_lbl.setForeground(Color.WHITE);
        JPasswordField userPSWD = new JPasswordField();
        userPSWD.setPreferredSize(new Dimension(150, 20));
        userPSWD.setBounds(100, 20, 165, 25);
        userPSWD.setLocation(850, 320);
        new GhostText(userPSWD, "Password");

        JButton create_btn = new JButton("Sign Up");
        create_btn.setSize(165, 30);
        create_btn.setLocation(850, 350);
        create_btn.setBackground(Color.BLUE);
        create_btn.setForeground(Color.WHITE);
        create_btn.addActionListener(this);
        create_btn.setActionCommand("Open");

        create_btn.addActionListener(e -> new CA());


        JButton submit_btn = new JButton("Submit");
        submit_btn.setSize(165, 30);
        submit_btn.setLocation(600, 350);
        submit_btn.setBackground(Color.BLUE);
        submit_btn.setForeground(Color.WHITE);
        submit_btn.addActionListener(this);
        submit_btn.setActionCommand("Login");

        panel = new JPanel();
        panel = new ImagePanel(image);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 350, 300, 350));
        panel.setLayout(null);

        panel.add(user_lbl);
        panel.add(userText);
        panel.add(pass_lbl);
        panel.add(userPSWD);
        panel.add(submit_btn);
        panel.add(create_btn);
        panel.add(drone_delivery);
        panel.setPreferredSize(new Dimension(1600, 1000));
        panel.setOpaque(false);


        frame.setPreferredSize(new Dimension(1600, 1000));
        frame.add(panel, BorderLayout.PAGE_START);
        frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drone Delivery");
        frame.pack();
        frame.setVisible(true);

    }

    private void setContentPane(ImagePanel imagePanel) {

    }

    @Override
        public void actionPerformed (ActionEvent e){
            String cmd = e.getActionCommand();

            if (cmd.equals("Open")) {
                frame.dispose();
                new CreateAccount();
            } else if (cmd.equals("Login")) {
                System.out.println("Login bois");
                JTextField username = (JTextField) panel.getComponents()[0];
                JPasswordField password = (JPasswordField) panel.getComponents()[1];
                StringBuilder sb = new StringBuilder();
                for (char c : password.getPassword()) {
                    sb.append(c);
                }
                String realPassword = sb.toString();
                try {
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://uxkxkifhcxj67hpx:dKLI7ZyM6CcuGJ0PGgVh@bayk5r10ciurmkol7qws-mysql.services.clever-cloud.com:3306/bayk5r10ciurmkol7qws", "uxkxkifhcxj67hpx", "dKLI7ZyM6CcuGJ0PGgVh");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from login");
                    while (rs.next()) {
                        System.out.println(rs.getString("username"));
                        System.out.println(username.getText());
                        if (rs.getString("username").equals(username.getText()) && rs.getString("password").equals(realPassword)) {
                            // Logged in successfully!
                            new LI();
                            System.out.println("Logged in");
                            return;
                        }
                    }
                    // User didn't log in successfully
                    System.out.println("Not logged in");
                } catch (SQLException uhoh) {
                    uhoh.printStackTrace();
                }
            }

        }



    }
