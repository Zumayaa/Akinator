import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;
public class Ventana extends JFrame {
    public JPanel panel = null;
    public int terminar = 0;
    private int a=0,b=0;

    private Nodo marcos;
    private Nodo jenni;
    private Nodo nataCano;
    private Nodo jett;

    private String preg;
    private JButton afirmativo = new JButton("Sí");

    private JButton negativo = new JButton("No");
    private String anterior = "cargaPantalla";
    private String actual = "inicio";
    private String user;

    private JLabel pregunta = new JLabel(preg,SwingConstants.CENTER);
    private JPanel contentPane;

    private String personaje_adivinado;
    private String ruta;

    private String respuesta;
    ImageIcon logo = new ImageIcon("src/ranse.jpg");

    private Nodo raiz = construirArbol();

    Scanner scanner = new Scanner(System.in);


    public Ventana() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(820, 672);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#7144c9"));



        setIconImage(logo.getImage());

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
        if(actual.equals("finish")){
            panel = finish();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }
        if(actual.equals("posibles")){
            panel = posibles();

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
        iniciar.setFocusPainted(false);
        iniciar.setFont(new Font("Tahoma", Font.BOLD, 15));
        iniciar.setBackground(Color.decode("#ffbd59"));
        iniciar.setForeground(Color.decode("#FF721C"));
        iniciar.setSize(220,35);
        iniciar.setLocation(278,350);
        inicioPanel.add(iniciar);

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = nombre.getText();
                if(user.equals("")){
                    JOptionPane.showMessageDialog(null,"¡Ingresa un nombre para jugar!","ERROR", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    user = nombre.getText();
                    anterior = actual;
                    actual = "posibles";
                    limpiarVentana();

                    repaint();
                    revalidate();
                }
            }
        });
        return inicioPanel;
    }

    public Nodo construirArbol() {

        Nodo marcos = new Nodo(null, null, null, "Marcos Camachito");
        Nodo jenni = new Nodo(null, null, null, "Jenni Rivera");
        Nodo nataCano = new Nodo(null, null, null, "Natanael Cano");
        Nodo jett = new Nodo(null, null, null, "Jett");

        Nodo videojuego = new Nodo("¿El personaje es de un videojuego?", jett, jenni, null);
        Nodo esCantante = new Nodo("¿El personaje es un cantante?", nataCano, marcos, null);

        Nodo raiz = new Nodo("¿El personaje es mujer?", videojuego, esCantante, null);

        return raiz;
    }

    public void jugarAkinator(Nodo nodo) {
        if (nodo.personaje != null) {
            System.out.println("El personaje es: " + nodo.personaje);
            if (nodo.personaje.equals("Marcos Camachito")){
                personaje_adivinado = "Marcos";
                ruta = "src/marcos.jpeg";
            }
            if (nodo.personaje.equals("Jenni Rivera")){
                personaje_adivinado = "Jenni Rivera";
                ruta = "src/jenni.jpeg";
            }
            if (nodo.personaje.equals("Natanael Cano")){
                personaje_adivinado = "Natanael Cano";
                ruta = "src/nata.jpeg";
            }
            if (nodo.personaje.equals("Jett")){
                personaje_adivinado = "Jett";
                ruta = "src/jett.jpeg";
            }

            return;
        }




        System.out.println(nodo.pregunta + " (responder si/no)");
        pregunta.setText(nodo.pregunta);

        afirmativo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a!=2) {
                    jugarAkinator(nodo.si);

                }

                if(a==2){
                    anterior = actual;
                    actual="finish";
                    a=0;
                    limpiarVentana();

                    repaint();
                    revalidate();
                }else {
                    a++;
                }

            }
        });

        negativo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(a!=2) {
                    jugarAkinator(nodo.no);

                }

                if(a==2){
                    anterior = actual;
                    actual="finish";
                    a=0;
                    limpiarVentana();

                    repaint();
                    revalidate();
                }else {
                    a++;
                }
            }

        });
    }

    public JPanel posibles(){
        anterior = actual;
        actual = "posibles";

        JPanel posiblesPanel = new JPanel();
        posiblesPanel.setSize(820, 672);
        posiblesPanel.setLocation(0, 0);
        posiblesPanel.setLayout(null);
        posiblesPanel.setBackground(Color.decode("#7144c9"));

        JLabel personajesTitle = new JLabel("¡Estos son los personajes que puedo adivinar!",JLabel.CENTER);
        personajesTitle.setFont(new Font("Arial",Font.BOLD,25));
        personajesTitle.setSize(700,80);
        personajesTitle.setLocation(50,30);
        personajesTitle.setForeground(Color.decode("#ffbd59"));
        posiblesPanel.add(personajesTitle);

        JLabel marcos = new JLabel();
        marcos.setSize(170, 190);
        ImageIcon marcIcon = new ImageIcon("src/marcos.jpeg");
        ImageIcon marcosIcono = new ImageIcon(marcIcon.getImage().getScaledInstance(marcos.getWidth(), marcos.getHeight(), Image.SCALE_DEFAULT));
        marcos.setIcon(marcosIcono);
        marcos.setLocation(30, 180);
        posiblesPanel.add(marcos);

        JLabel marcosLabel = new JLabel("Marcos", JLabel.CENTER);
        marcosLabel.setFont(new Font("Arial", Font.BOLD, 25));
        marcosLabel.setSize(100, 80);
        marcosLabel.setLocation(70, 360);
        marcosLabel.setForeground(Color.decode("#ffbd59"));
        posiblesPanel.add(marcosLabel);

        JLabel nata = new JLabel();
        nata.setSize(170, 190);
        ImageIcon nataIcon = new ImageIcon("src/nata.jpeg");
        ImageIcon nataIcono = new ImageIcon(nataIcon.getImage().getScaledInstance(nata.getWidth(), nata.getHeight(), Image.SCALE_DEFAULT));
        nata.setIcon(nataIcono);
        nata.setLocation(218, 180);
        posiblesPanel.add(nata);

        JLabel nataLabel = new JLabel("Natanael", JLabel.CENTER);
        nataLabel.setFont(new Font("Arial", Font.BOLD, 25));
        nataLabel.setSize(200, 80);
        nataLabel.setLocation(210, 360);
        nataLabel.setForeground(Color.decode("#ffbd59"));
        posiblesPanel.add(nataLabel);

        JLabel jenni = new JLabel();
        jenni.setSize(170, 190);
        ImageIcon jenniIcon = new ImageIcon("src/jenni.jpeg");
        ImageIcon jeniIcono = new ImageIcon(jenniIcon.getImage().getScaledInstance(jenni.getWidth(), jenni.getHeight(), Image.SCALE_DEFAULT));
        jenni.setIcon(jeniIcono);
        jenni.setLocation(405, 180);
        posiblesPanel.add(jenni);

        JLabel jenniLabel = new JLabel("Jenni", JLabel.CENTER);
        jenniLabel.setFont(new Font("Arial", Font.BOLD, 25));
        jenniLabel.setSize(200, 80);
        jenniLabel.setLocation(385, 360);
        jenniLabel.setForeground(Color.decode("#ffbd59"));
        posiblesPanel.add(jenniLabel);

        JLabel jett = new JLabel();
        jett.setSize(170, 190);
        ImageIcon jettIcon = new ImageIcon("src/jett.jpeg");
        ImageIcon jettIcono = new ImageIcon(jettIcon.getImage().getScaledInstance(jett.getWidth(), jett.getHeight(), Image.SCALE_DEFAULT));
        jett.setIcon(jettIcono);
        jett.setLocation(590, 180);
        posiblesPanel.add(jett);

        JLabel jettLabel = new JLabel("Jett", JLabel.CENTER);
        jettLabel.setFont(new Font("Arial", Font.BOLD, 25));
        jettLabel.setSize(200, 80);
        jettLabel.setLocation(570, 360);
        jettLabel.setForeground(Color.decode("#ffbd59"));
        posiblesPanel.add(jettLabel);

        JButton siguiente = new JButton("¡A jugar!");
        siguiente.setFocusPainted(false);
        siguiente.setSize(280,50);
        siguiente.setLocation(260,500);
        siguiente.setBackground(Color.decode("#ffbd59"));
        siguiente.setForeground(Color.decode("#FF721C"));
        siguiente.setFont(new Font("Arial", Font.BOLD, 20));
        posiblesPanel.add(siguiente);


        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "juego";

                jugarAkinator(raiz);
                limpiarVentana();

                repaint();
                revalidate();
            }
        });

        return posiblesPanel;
    }

    public JPanel juego(){
        anterior = actual;
        actual = "juego";

        JPanel juegoPanel = new JPanel();
        juegoPanel.setSize(820, 672);
        juegoPanel.setLocation(0, 0);
        juegoPanel.setLayout(null);
        juegoPanel.setBackground(Color.decode("#7144c9"));


        JLabel jugador = new JLabel(user + ", A jugar!",JLabel.CENTER);
        jugador.setFont(new Font("Arial",Font.BOLD,25));
        jugador.setSize(300,80);
        jugador.setLocation(250,30);
        jugador.setForeground(Color.decode("#ffbd59"));
        juegoPanel.add(jugador);


        pregunta.setFont(new Font("Arial",Font.BOLD,35));
        pregunta.setSize(600,80);
        pregunta.setLocation(100,100);
        pregunta.setForeground(Color.decode("#FFC51C"));
        juegoPanel.add(pregunta);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(250, 250);
        ImageIcon imag2 = new ImageIcon("src/RAMSES.png");
        ImageIcon icono2 = new ImageIcon(imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(275, 380);
        juegoPanel.add(imagen2);

        afirmativo.setFocusPainted(false);
        afirmativo.setSize(280,50);
        afirmativo.setLocation(260,200);
        afirmativo.setBackground(Color.decode("#ffbd59"));
        afirmativo.setForeground(Color.decode("#FF721C"));
        afirmativo.setFont(new Font("Arial", Font.BOLD, 20));
        juegoPanel.add(afirmativo);

        negativo.setFocusPainted(false);
        negativo.setSize(280,50);
        negativo.setLocation(260,300);
        negativo.setBackground(Color.decode("#ffbd59"));
        negativo.setForeground(Color.decode("#FF721C"));
        negativo.setFont(new Font("Arial", Font.BOLD, 20));
        juegoPanel.add(negativo);


        return juegoPanel;
    }

    public JPanel finish(){
        anterior = actual;
        actual = "finish";

        JPanel finishPanel = new JPanel();
        finishPanel.setSize(820, 672);
        finishPanel.setLocation(0, 0);
        finishPanel.setLayout(null);
        finishPanel.setBackground(Color.decode("#7144c9"));


        JLabel respuesta = new JLabel("Estoy pensando en, " + personaje_adivinado,SwingConstants.CENTER);
        respuesta.setFont(new Font("Arial",Font.BOLD,35));
        respuesta.setSize(600,60);
        respuesta.setLocation(100,30);
        respuesta.setForeground(Color.decode("#FFC51C"));
        finishPanel.add(respuesta);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(250, 250);
        ImageIcon imag2 = new ImageIcon(ruta);
        ImageIcon icono2 = new ImageIcon(imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(275, 115);
        finishPanel.add(imagen2);

        JButton salir = new JButton("Terminar el juego");
        salir.setFocusPainted(false);
        salir.setSize(220,45);
        salir.setLocation(290,445);
        salir.setBackground(Color.decode("#582813"));
        salir.setForeground(Color.decode("#FF721C"));
        salir.setFont(new Font("Arial", Font.BOLD, 20));
        finishPanel.add(salir);

        JLabel imagen1 = new JLabel();
        imagen1.setSize(400, 250);
        ImageIcon imag1 = new ImageIcon("src/piramide.png");
        ImageIcon icono1 = new ImageIcon(imag1.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_DEFAULT));
        imagen1.setIcon(icono1);
        imagen1.setLocation(200, 385);
        finishPanel.add(imagen1);


        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ventana screen = new Ventana();
            }

        });

        return finishPanel;
    }


}

