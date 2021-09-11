import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

public class CreateAccount {
    public static void main(String[] args) {
        CA obj = new CA();
    }
}

class CA extends JFrame implements ActionListener
{

    class NewImagePanel extends JPanel {
        Image image;
        public NewImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
        }
    }



    JFrame newframe;
    JPanel newpanel;

    public CA(){

        BufferedImage image;



        try{
            image = ImageIO.read(getClass().getResource("drone_wp.jpg"));
            this.setContentPane(new CA.NewImagePanel(image));
        }catch (IOException e){
            e.printStackTrace();
            image = null;
        }



        newframe = new JFrame();

        JButton back_btn = new JButton("Back");
        back_btn.setSize(165, 30);
        back_btn.setBackground(Color.BLUE);
        back_btn.setForeground(Color.WHITE);
        back_btn.setLocation(600, 760);
        back_btn.addActionListener(this);
        back_btn.setActionCommand("Back");

        back_btn.addActionListener(e -> new application());

        JButton submitacc_btn = new JButton("Create Account");
        submitacc_btn.setSize(165, 30);
        submitacc_btn.setBackground(Color.BLUE);
        submitacc_btn.setForeground(Color.WHITE);
        submitacc_btn.setLocation(850, 760);
        submitacc_btn.addActionListener(this);
        submitacc_btn.setActionCommand("Submit");

        submitacc_btn.addActionListener(e -> new application());

        JLabel username_lbl = new JLabel("Username");
        username_lbl.setLocation(600, 630);
        username_lbl.setSize(150, 20);
        username_lbl.setForeground(Color.BLACK);
        JTextField username = new JTextField();
        username.setBounds(100, 20, 165, 25);
        username.setPreferredSize(new Dimension(150, 20));
        username.setLocation(600, 650);
        new GhostText(username, "Username");

        JLabel password_lbl = new JLabel("Password");
        password_lbl.setLocation(600, 670);
        password_lbl.setSize(150, 20);
        password_lbl.setForeground(Color.BLACK);
        JPasswordField password = new JPasswordField();
        password.setBounds(100, 20, 165, 25);
        password.setPreferredSize(new Dimension(150, 20));
        password.setLocation(600, 690);
        new GhostText(password, "Password");

        JLabel confirmps_lbl = new JLabel("Confirm Password");
        confirmps_lbl.setLocation(850, 670);
        confirmps_lbl.setSize(150, 20);
        confirmps_lbl.setForeground(Color.BLACK);
        JPasswordField confirm_password = new JPasswordField();
        confirm_password.setBounds(100, 20, 165, 25);
        confirm_password.setPreferredSize(new Dimension(150, 20));
        confirm_password.setLocation(850, 690);
        new GhostText(confirm_password, "Confirm Password");

        JLabel email_lbl = new JLabel("Email");
        email_lbl.setLocation(850, 630);
        email_lbl.setSize(150, 20);
        email_lbl.setForeground(Color.BLACK);
        JTextField email = new JTextField();
        email.setBounds(100, 20, 165, 25);
        email.setPreferredSize(new Dimension(150, 20));
        email.setLocation(850, 650);
        new GhostText(email, "Email");

        JLabel address_lbl = new JLabel("Address");
        address_lbl.setLocation(600, 710);
        address_lbl.setSize(150, 20);
        address_lbl.setForeground(Color.BLACK);
        JTextField address = new JTextField();
        address.setBounds(100, 20, 165, 25);
        address.setPreferredSize(new Dimension(150, 20));
        address.setLocation(600, 730);
        new GhostText(address, "Address");

        JLabel phone_lbl = new JLabel("Phone Number");
        phone_lbl.setLocation(850, 710);
        phone_lbl.setSize(150, 20);
        phone_lbl.setForeground(Color.BLACK);
        JTextField phone_number = new JTextField();
        phone_number.setBounds(100, 20, 165, 25);
        phone_number.setLocation(850, 730);
        phone_number.setPreferredSize(new Dimension(150, 20));

        new GhostText(phone_number, "Phone Number");

        newpanel = new JPanel(); // used to do padding like in HTML
        newpanel = new CA.NewImagePanel(image);
        newpanel.setBorder(BorderFactory.createEmptyBorder(650, 650, 600, 650));
        newpanel.setLayout(null);
        newpanel.add(username_lbl);
        newpanel.add(username);
        newpanel.add(password_lbl);
        newpanel.add(password);
        newpanel.add(confirmps_lbl);
        newpanel.add(confirm_password);
        newpanel.add(email_lbl);
        newpanel.add(email);
        newpanel.add(phone_lbl);
        newpanel.add(phone_number);
        newpanel.add(address_lbl);
        newpanel.add(address);
        newpanel.add(back_btn);
        newpanel.add(submitacc_btn);
        newpanel.setPreferredSize(new Dimension(1700, 1000));
        newpanel.setOpaque(false);

        newframe.add(newpanel, BorderLayout.PAGE_START);
        newframe.getContentPane().setLayout(new FlowLayout());
        newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newframe.setTitle("Create Account");
        newframe.pack();
        newframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(cmd.equals("Back"))
        {
            newframe.dispose();
            new APP();
        }

        else if(cmd.equals("Submit"))
        {
            JTextField username = (JTextField) newpanel.getComponents()[0];
            JPasswordField password = (JPasswordField) newpanel.getComponents()[1];
            JPasswordField confirm = (JPasswordField) newpanel.getComponents()[2];
            JTextField email = (JTextField) newpanel.getComponents()[3];
            JTextField phone = (JTextField) newpanel.getComponents()[4];
            JTextField address = (JTextField) newpanel.getComponents()[5];
            try {
                Connection con= DriverManager.getConnection(
                        "jdbc:mysql://uxkxkifhcxj67hpx:dKLI7ZyM6CcuGJ0PGgVh@bayk5r10ciurmkol7qws-mysql.services.clever-cloud.com:3306/bayk5r10ciurmkol7qws","uxkxkifhcxj67hpx","dKLI7ZyM6CcuGJ0PGgVh");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from login");
                while(rs.next()) {
                    if(rs.getString("email").equals(email.getText()) || rs.getString("username").equals(username.getText())) {
                    	// Tell user there is already account with that username or email
                        System.out.println("Account exists");
	                    return;
                    } else if(!Arrays.equals(password.getPassword(), confirm.getPassword())) {
                    	// Tell user their password and confirm password aren't the same.
                        System.out.println("Password and confirm not the same");
	                    return;
                    }
                }
                // TODO?: Add salting and hashing for security
                StringBuilder sb = new StringBuilder();
                for(char c : password.getPassword()) {
                    sb.append(c);
                }
                String realPassword = sb.toString();
	            stmt.executeUpdate(String.format("INSERT INTO login(email, password, username, phone, address)\n" +
			            "VALUES(\"%s\",\"%s\",\"%s\",%s,\"%s\")", email.getText(), realPassword, username.getText(), phone.getText(), address.getText()));
                System.out.println("Account created");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

}