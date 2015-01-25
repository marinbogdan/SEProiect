package com.youtube.invaders.screen;


public class ScreenManager {

	private static Screen currentScreen;
	
	public static void setScreen(Screen screen) {
		if (currentScreen != null)
			currentScreen.dispose();
		currentScreen = screen;
		try {
			currentScreen.create();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Screen getCurrentScreen() {
		return currentScreen;
	}
	
}
