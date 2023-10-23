package model;

import gui.Login;

public class Main {

	public static void main(String[] args) 	{
		App app = new App();
		//Iniciar GUI

		Login loginWindow = new Login(app);
		loginWindow.setVisible(true);
	}




}
