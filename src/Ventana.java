import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana frame = new Ventana();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 820, 672);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setBackground(Color.decode("#7144c9"));

        setTitle("Adivina Ram's");

        JLabel imagen1 = new JLabel();
        imagen1.setSize(250, 250);
        ImageIcon imag1 = new ImageIcon("src/title.png");
        ImageIcon icono1 = new ImageIcon(imag1.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_DEFAULT));
        imagen1.setIcon(icono1);
        imagen1.setLocation(270, 10);
        add(imagen1);

        JLabel inicia = new JLabel("Ingresa tu nombre", JLabel.CENTER);
        inicia.setFont(new Font("Arial", Font.BOLD, 15));
        inicia.setSize(250, 80);
        inicia.setLocation(220, 245);
        inicia.setForeground(Color.decode("#ffbd59"));
        add(inicia);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(200, 200);
        ImageIcon imag2 = new ImageIcon("src/RAMSES.png");
        ImageIcon icono2 = new ImageIcon(imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(290, 420);
        add(imagen2);

        JTextField nombre = new JTextField();
        nombre.setSize(220,35);
        nombre.setLocation(278,300);
        add(nombre);

        JButton iniciar = new JButton("¡INICIAR!");
        iniciar.setFont(new Font("Tahoma", Font.BOLD, 15));
        iniciar.setBackground(Color.decode("#ffbd59"));
        iniciar.setForeground(Color.decode("#FF721C"));
        iniciar.setSize(220,35);
        iniciar.setLocation(278,350);
        add(iniciar);
    }

}

