package main;

import gui.LoginForm;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

public class Main {
    
    public static void main(String[] args) {
        // 1. Setup the Modern UI Theme before any window is created
        try {
            FlatMacLightLaf.setup();
            
            // Optional: Make buttons rounded globally
            UIManager.put("Button.arc", 10); 
            UIManager.put("Component.arc", 10);
            UIManager.put("TextComponent.arc", 10);
        } catch (Exception ex) {
            System.err.println("Failed to initialize modern theme.");
        }

        // 2. Launch the Login Form safely
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Open the LoginForm from your 'gui' package
                new LoginForm().setVisible(true);
            }
        });
    }
}