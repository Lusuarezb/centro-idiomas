package control.controlPanel.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import defecto.Main;
import modelo.Usuarios.Administrador;
import modelo.Usuarios.Administrativo;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.CodigoIncorrecto;
import modelo.excepciones.modelo.UsuarioRegistrado;

public class RegistrarAdministrativoPanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try {
				String nombre = Main.ventanaUsuario.getPanelP().getValue("Nombre: ");
				String apellido = Main.ventanaUsuario.getPanelP().getValue("Apellido: ");
				long cedula = Long.parseLong(Main.ventanaUsuario.getPanelP().getValue("Cedula: ")); 
				String correo = Main.ventanaUsuario.getPanelP().getValue("Correo: ");
				String contrasena = Main.ventanaUsuario.getPanelP().getValue("Contraseņa: ");
				String codigo = Main.ventanaUsuario.getPanelP().getValue("Codigo: ");
				String aviso = Administrativo.registrarAministrativo(nombre, apellido, cedula, correo, contrasena, codigo);
				Main.ventanaUsuario.Popup2(aviso);
				Main.ventanaUsuario.setPanelP();
				//Main.ventanaUsuario.getPanelP().borrar();
			}
			catch (CampoVacio exception1) {
				Main.ventanaUsuario.Popup(exception1.getMessage());
			}	
			catch(UsuarioRegistrado exception2) {
				Main.ventanaUsuario.Popup(exception2.getMessage());
			}
			catch(CodigoIncorrecto exception3) {
				Main.ventanaUsuario.Popup(exception3.getMessage());
			}
		}
		else if(evento.getActionCommand().equals("Borrar")){
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
}
