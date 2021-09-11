import javax.swing.*;
import java.awt.*;

public class Payment {
    public static void main(String[] args){
        PM obj = new PM();
    }
}

class PM
{
    JFrame payment = new JFrame();
    JPanel pay_pan;

    public PM(){
        JLabel card_number = new JLabel("Card Number:");
        card_number.setForeground(Color.BLACK);
        card_number.setLocation(430, 290);
        card_number.setSize(150, 100);
        JTextField crd_number = new JTextField();
        crd_number.setBounds(100, 20, 170, 35);
        crd_number.setLocation(600, 320);

        JLabel card_holder = new JLabel("Card Holder Name:");
        card_holder.setForeground(Color.BLACK);
        card_holder.setLocation(430, 320);
        card_holder.setSize(150, 100);
        JTextField crdhold_name = new JTextField();
        crdhold_name.setBounds(100, 20, 170, 35);
        crdhold_name.setLocation(600, 360);

        JLabel card_expiration = new JLabel("Card Expiration Date:");
        card_expiration.setForeground(Color.BLACK);
        card_expiration.setLocation(430, 360);
        card_expiration.setSize(170, 100);
        JTextField crd_exp = new JTextField();
        crd_exp.setBounds(100, 20, 170, 35);
        crd_exp.setLocation(600, 400);

        JLabel cvv = new JLabel("CVC/CVV:");
        cvv.setLocation(430, 400);
        cvv.setSize(170, 100);
        JTextField cvc_cvv = new JTextField();
        cvc_cvv.setBounds(100, 20, 170, 35);
        cvc_cvv.setLocation(600, 440);

        pay_pan = new JPanel();
        pay_pan.setBorder(BorderFactory.createEmptyBorder(50, 350, 300, 350));
        pay_pan.setLayout(null);
        pay_pan.add(crd_number);
        pay_pan.add(card_number);
        pay_pan.add(crdhold_name);
        pay_pan.add(card_holder);
        pay_pan.add(crd_exp);
        pay_pan.add(card_expiration);
        pay_pan.add(cvc_cvv);
        pay_pan.add(cvv);
        pay_pan.setPreferredSize(new Dimension(1600, 1000));
        pay_pan.setOpaque(false);


        payment.setPreferredSize(new Dimension(1600, 1000));
        payment.add(pay_pan, BorderLayout.PAGE_START);
        payment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        payment.setTitle("Payment");
        payment.pack();
        payment.setVisible(true);

    }
}
