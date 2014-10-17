import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazDeControlHilos extends JFrame{

	private JButton botonSimulacion;
	private JButton botonReiniciar;

	private JSlider rangoVelocidad;

	public InterfazDeControlHilos(){
		super("Control");

		setLayout(new FlowLayout());

		botonSimulacion = new JButton("simulacion");
		botonReiniciar = new JButton("reiniciar");

		rangoVelocidad = new JSlider(SwingConstants.HORIZONTAL, 0, 20, 0);
		rangoVelocidad.setMajorTickSpacing(2);
		rangoVelocidad.setPaintTicks(true);

		add(botonSimulacion, BorderLayout.NORTH);
		add(rangoVelocidad, BorderLayout.CENTER);
		add(botonReiniciar, BorderLayout.SOUTH);
	}
}