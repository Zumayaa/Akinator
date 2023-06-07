import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {
    public JPanel panel = null;

    private String anterior = "cargaPantalla";
    private String actual = "inicio";
    private String bienvenidonombre;
    private JPanel contentPane;

    public Ventana() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(820, 672);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#7144c9"));

        setTitle("Adivina Ram's");

        limpiarVentana();

        this.add(panel);

        this.repaint();
        this.revalidate();
    }
    public void limpiarVentana(){

        if(panel!= null) {
            this.remove(panel);
        }

        if(actual.equals("inicio")){
            panel = inicio();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }

        if(actual.equals("juego")){
            panel = juego();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }
    }

    public JPanel inicio(){
        anterior = actual;
        actual = "inicio";

        JPanel inicioPanel = new JPanel();
        inicioPanel.setSize(820, 672);
        inicioPanel.setLocation(0, 0);
        inicioPanel.setLayout(null);
        inicioPanel.setBackground(Color.decode("#7144c9"));

        JLabel imagen1 = new JLabel();
        imagen1.setSize(250, 250);
        ImageIcon imag1 = new ImageIcon("src/title.png");
        ImageIcon icono1 = new ImageIcon(imag1.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_DEFAULT));
        imagen1.setIcon(icono1);
        imagen1.setLocation(270, 10);
        inicioPanel.add(imagen1);

        JLabel inicia = new JLabel("Ingresa tu nombre", JLabel.CENTER);
        inicia.setFont(new Font("Arial", Font.BOLD, 15));
        inicia.setSize(250, 80);
        inicia.setLocation(220, 245);
        inicia.setForeground(Color.decode("#ffbd59"));
        inicioPanel.add(inicia);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(200, 200);
        ImageIcon imag2 = new ImageIcon("src/RAMSES.png");
        ImageIcon icono2 = new ImageIcon(imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(290, 420);
        inicioPanel.add(imagen2);

        JTextField nombre = new JTextField();
        nombre.setSize(220,35);
        nombre.setLocation(278,300);
        inicioPanel.add(nombre);

        JButton iniciar = new JButton("¡INICIAR!");
        iniciar.setFont(new Font("Tahoma", Font.BOLD, 15));
        iniciar.setBackground(Color.decode("#ffbd59"));
        iniciar.setForeground(Color.decode("#FF721C"));
        iniciar.setSize(220,35);
        iniciar.setLocation(278,350);
        inicioPanel.add(iniciar);

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "juego";
                limpiarVentana();

                repaint();
                revalidate();
            }
        });
        return inicioPanel;
    }

    public JPanel juego(){
        anterior = actual;
        actual = "juego";

        JPanel juegoPanel = new JPanel();
        juegoPanel.setSize(820, 672);
        juegoPanel.setLocation(0, 0);
        juegoPanel.setLayout(null);
        juegoPanel.setBackground(Color.decode("#95E799"));


        JLabel user = new JLabel("Ingresa tu nombre de usuario",JLabel.CENTER);
        user.setFont(new Font("Arial",Font.BOLD,15));
        user.setSize(300,80);
        user.setLocation(100,200);
        user.setForeground(Color.decode("#005F04"));
        juegoPanel.add(user);

        JTextField username = new JTextField();
        username.setSize(270,42);
        username.setLocation(142,260);
        juegoPanel.add(username);

        JLabel pass = new JLabel("Ingresa tu contraseña",JLabel.CENTER);
        pass.setFont(new Font("Arial",Font.BOLD,15));
        pass.setSize(260,80);
        pass.setLocation(93,300);
        pass.setForeground(Color.decode("#005F04"));
        juegoPanel.add(pass);

        JPasswordField contrasena = new JPasswordField();
        contrasena.setSize(270,42);
        contrasena.setLocation(142,350);
        juegoPanel.add(contrasena);

        JButton acceder = new JButton("Acceder");
        acceder.setSize(150,30);
        acceder.setLocation(205,410);
        acceder.setBackground(Color.decode("#005F04"));
        acceder.setForeground(Color.white);
        acceder.setBorder(null);
        acceder.setFont(new Font("Arial", Font.BOLD, 20));
        juegoPanel.add(acceder);

        JButton cancelarBorrar = new JButton("Borrar todo");
        cancelarBorrar.setSize(100,30);
        cancelarBorrar.setLocation(230,460);
        cancelarBorrar.setBackground(Color.decode("#FF0000"));
        cancelarBorrar.setForeground(Color.white);
        cancelarBorrar.setBorder(null);
        juegoPanel.add(cancelarBorrar);

        cancelarBorrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "menu";
                limpiarVentana();

                repaint();
                revalidate();


            }

        });
        return juegoPanel;
    }


}

