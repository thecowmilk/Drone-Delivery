import javax.swing.*;
import java.awt.*;

public class MainPage {
    public static void main(String[] args){ MP obj = new MP(); }
}

class MP
{
    JFrame mainpage = new JFrame();
    JPanel mp_panel;


    public MP(){


        JTextArea about_us =  new JTextArea("SHERBIMI\n" + "\n" +
                "Ne dergojme porosi fillimisht ne te gjithe Tiranen. Jemi vetem ne Tirane momentalisht , por pas\n" +
                "disa vitesh kur te jemi zgjeruar dhe te kemi pikat tona ne cdo vend do te veprojme ne cdo qytet\n" +
                "te Shqiprise.\n" + "\n" + "MISIONI\n" + "\n" + "Ne kemi si qëllim të sjellim një risi në vend, ku transporti i postës të pasurohet me teknika të\n" +
                "reja inovatore, por edhe të lehtësojë punën e saj, gjithashtu do të shtonte fitimet e postës por\n" +
                "edhe besimin e klientit, për një shërbim të shpejtë e të sigurtë.\n" + "\n" + "QELLIMI\n" + "\n" + "Qëllimi afatshkurtër: ngritja e sistemit, fitimi i një klientele dhe arritja me sukses e punës së\n" +
                "dërgimit të pakove nga posta.\n" +
                "Qëllim afatgjatë: shpërhapja e këtij shërbimi në postat e qyteteve të tjera të Shqipërisë.\n" + "\n" + "RRETH NESH\n" + "\n" + "Një ide e lindur nga ngjarjet momentale të botës dhe krijimi i një zgjidhje për qytetarët të cilët\n" +
                "kërkojnë shërbimin e postës. Ne kemi si qëllim të sjellim një risi në vend, ku transporti i postës\n" +
                "të pasurohet me teknika të reja inovatore, por edhe të lehtësojë punën e saj, gjithashtu do të\n" +
                "shtonte fitimet e postës por edhe besimin e klientit, për një shërbi të shpejtë e të sigurtë. Jemi\n" +
                "grup programuesish te punesuar nga posta shqiptare per te kryer sherbimin e drone-delivery\n" + "\n" + "Lajme të fundit nga posta\n" + "\n" + "Lajme të fundit nga posta\n" + "\n" + "Pagesa online" +
                "Do jene procedurat e zakonshme, lloji kartes, pagesa numri\n");
        about_us.setFont(about_us.getFont().deriveFont(20f));
        about_us.setSize(1600, 1000);
        about_us.setForeground(Color.BLACK);
        about_us.setLocation(0, 10);

        mp_panel = new JPanel();
        mp_panel.setBorder(BorderFactory.createEmptyBorder(50, 350, 300, 350));
        mp_panel.setLayout(null);
        mp_panel.setPreferredSize(new Dimension(1600, 1000));
        mp_panel.add(about_us);
        mp_panel.setOpaque(false);

        mainpage.setPreferredSize(new Dimension(1600, 1000));
        mainpage.add(mp_panel, BorderLayout.PAGE_START);
        mainpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainpage.setTitle("About Us");
        mainpage.pack();
        mainpage.setVisible(true);

    }
}