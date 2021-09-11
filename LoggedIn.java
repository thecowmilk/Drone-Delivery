import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LoggedIn {
    public static void main(String[] args) {
        LI obj = new LI();
    }
}

class LI extends JFrame implements ActionListener
{

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


    JFrame logged = new JFrame();
    JPanel loggedpanel;

    public LI(){

        BufferedImage image;



        try{
            image = ImageIO.read(getClass().getResource("logged_in.jpeg"));
            this.setContentPane(new LI.ImagePanel(image));
        }catch (IOException e){
            e.printStackTrace();
            image = null;
        }

        JButton fq_btn = new JButton("Faqa Kryesore");
        fq_btn.setSize(300, 30);
        fq_btn.setLocation(500, 650);
        fq_btn.setBackground(Color.BLUE);
        fq_btn.setForeground(Color.WHITE);
        fq_btn.setActionCommand("AboutUs");
        fq_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String myurl1 = "https://dronedelivery05.000webhostapp.com/";
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(myurl1));
            }catch (Exception e2) {
                e2.printStackTrace();
                }
            }
        });

        JButton news_btn = new JButton("Lajme Nga Posta");
        news_btn.setSize(300, 30);
        news_btn.setLocation(500, 690);
        news_btn.setBackground(Color.BLUE);
        news_btn.setForeground(Color.WHITE);
        news_btn.setActionCommand("OpenSite");
        news_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String myurl = "https://dronedelivery05.000webhostapp.com/";
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(myurl));
                } catch (Exception e1) {
                    e1.printStackTrace();

                }
            }
        });


        JButton payment_btn = new JButton("Pagesa Online");
        payment_btn.setSize(300, 30);
        payment_btn.setLocation(810, 650);
        payment_btn.setBackground(Color.BLUE);
        payment_btn.setForeground(Color.WHITE);
        payment_btn.setActionCommand("Pay");
        payment_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(cmd.equals("Pay"))
                {
                    logged.dispose();
                    new PM();
                }
            }
        });


        JButton Logback_btn = new JButton("Go Back");
        Logback_btn.setSize(300, 30);
        Logback_btn.setLocation(810, 690);
        Logback_btn.setBackground(Color.BLUE);
        Logback_btn.setForeground(Color.WHITE);
        Logback_btn.addActionListener(this);
        Logback_btn.setActionCommand("Logback");

        Logback_btn.addActionListener(e -> new application());




        loggedpanel = new JPanel();
        loggedpanel = new LI.ImagePanel(image);
        loggedpanel.setBorder(BorderFactory.createEmptyBorder(50, 350, 300, 350));
        loggedpanel.setLayout(null);

        loggedpanel.add(fq_btn);
        loggedpanel.add(news_btn);
        loggedpanel.add(payment_btn);
        loggedpanel.add(Logback_btn);
        loggedpanel.setPreferredSize(new Dimension(1600, 1000));
        loggedpanel.setOpaque(false);


        logged.setPreferredSize(new Dimension(1600, 1000));
        logged.add(loggedpanel, BorderLayout.PAGE_START);
        logged.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logged.setTitle("Logged In");
        logged.pack();
        logged.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(cmd.equals("Logback"))
        {
            logged.dispose();
            new APP();
        }

        else{
            System.out.println("IF Statements wont get checked");
        }
    }

}