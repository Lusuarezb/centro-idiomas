	package control.controlPanel.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import defecto.Main;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.NoExisteCurso;
import modelo.excepciones.modelo.NoExisteEstudiante;
import modelo.excepciones.modelo.NoHayCertificados;
import modelo.excepciones.modelo.NoHayEstudiantes;

public class VerCertificadosEstudiantePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try{
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del estudiante: ");	
				String texto = Estudiante.verCertificadosEstudiante(Long.parseLong(cedula));
				Main.ventanaUsuario.ver(texto);
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoHayCertificados excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NumberFormatException excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
		else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
