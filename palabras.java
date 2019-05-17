package visual;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class palabras extends JFrame implements ActionListener {

		private JLabel mensaje,mensaje2,mensaje3,mensaje4,mensaje5,mensaje6,mensaje8,mensaje7,mensaje9,mensaje10;
		private JButton boton;
		private JTextField caja;
		
	public palabras() {
		super();
		configurarVentana();
		crearComponentes();
	}
	
	private void configurarVentana(){
		this.setTitle("Juego de palabra");
		this.setSize(430, 250);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		//this.getContentPane().setBackground(new java.awt.Color(4,18,47));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearComponentes(){
		mensaje = new JLabel("Palabra");
		mensaje.setBounds(10, 0, 100, 60);
		mensaje.setForeground(Color.RED);
		this.add(mensaje);
		
		mensaje2 = new JLabel("Palindromo: ");
		mensaje2.setBounds(10, 70, 75, 60);
		mensaje2.setForeground(Color.RED);
		this.add(mensaje2);
		
		mensaje3 = new JLabel("Palabra");
		mensaje3.setBounds(10, 0, 60, 60);
		mensaje3.setForeground(Color.RED);
		this.add(mensaje3);
		
		mensaje4 = new JLabel("Longitud: ");
		mensaje4.setBounds(10, 90, 60, 60);
		mensaje4.setForeground(Color.RED);
		this.add(mensaje4);
		
		mensaje5 = new JLabel("Inversa: ");
		mensaje5.setBounds(10, 110, 60, 60);
		mensaje5.setForeground(Color.RED);
		this.add(mensaje5);
		
		mensaje6 = new JLabel("Repetida: ");
		mensaje6.setBounds(10, 130, 60, 60);
		mensaje6.setForeground(Color.RED);
		this.add(mensaje6);
		
		mensaje7 = new JLabel("");
		mensaje7.setBounds(100, 135, 100, 10);
		mensaje7.setForeground(Color.RED);
		this.add(mensaje7);
		
		mensaje8 = new JLabel("");
		mensaje8.setBounds(100, 115, 60, 10);
		mensaje8.setForeground(Color.RED);
		this.add(mensaje8);
		
		mensaje9 = new JLabel("");
		mensaje9.setBounds(100, 95, 60, 10);
		mensaje9.setForeground(Color.RED);
		this.add(mensaje9);
		
		mensaje10 = new JLabel("");
		mensaje10.setBounds(100, 155, 60, 10);
		mensaje10.setForeground(Color.RED);
		this.add(mensaje10);
		
		caja = new JTextField();
		caja.setBounds(60,20,100,30);
		this.add(caja);
		
		boton = new JButton("Verificar");
		boton.setBounds(60,60,100,30);
		boton.addActionListener(this);
		this.add(boton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			String palabra = caja.getText();
			String inversa;
			String aux;
			int longitud;
			String repetida;
			boolean pali;
			
			
			longitud = palabra.length();
			mensaje8.setText(Integer.toString(longitud));
			
			
			
			inversa="";
			for(int x=(longitud-1);x>=0;x--) {
				inversa += palabra.charAt(x);
			}
			;
			
			mensaje7.setText(inversa);
			
			
			if(palabra.replace(" ", "").equals(inversa.replace(" ", ""))) {
				mensaje9.setText("Si");
			}else {
				mensaje9.setText("No");
			}
			
			char [] letras;
			int mayorRepeticion  = 0;
			char letraMasRepetida;
			
			letras = palabra.toCharArray();
			
			for(int i=0;i<palabra.length();i++) {
				char letraActual = letras[i];
				int contador =0;
				for(int j=0;j<letras.length;j++) {
					if(letras[j]==letraActual)
						contador++;
				}
				if(mayorRepeticion < contador) {
					mayorRepeticion = contador;
					letraMasRepetida = letraActual;
					String letra = Character.toString(letraMasRepetida);
					mensaje10.setText(letra);
					
				}
			}
			
	}
	
	public static void main(String[] args) {
		palabras ventana = new palabras();
		ventana.setVisible(true);
	}
}
