package main;

import gui.LoginForm;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import javax.swing.UIManager;

public class Main {
    
    public static void main(String[] args) {
        // 1. Setup the Modern UI Theme before any window is created
        try {
            Color myBrown = new Color(194, 99, 46);
            Color myBrownHover = new Color(214, 119, 66); // Lighter for hover
            
            FlatMacLightLaf.setup();
            
            // Core accent color
            UIManager.put("Component.accentColor", myBrown);
            
            // Button hover and focus
            UIManager.put("Button.hoverBorderColor", myBrown);
            UIManager.put("Button.focusedBorderColor", myBrown);
            UIManager.put("Button.default.hoverBorderColor", myBrown);
            UIManager.put("Button.default.focusedBorderColor", myBrown);
            UIManager.put("Button.default.background", myBrown);
            UIManager.put("Button.default.hoverBackground", myBrownHover);
            UIManager.put("Button.default.focusedBackground", myBrown);
            
            // ComboBox (dropdown) - arrow button and selection
            UIManager.put("ComboBox.buttonBackground", myBrown);
            //UIManager.put("ComboBox.buttonArrowColor", myBrown);
            UIManager.put("ComboBox.buttonEditableBackground", myBrown);
            UIManager.put("ComboBox.selectionBackground", myBrown);
            UIManager.put("ComboBox.buttonFocusedBackground", myBrown);
            
            // List selection (for dropdown items)
            UIManager.put("List.selectionBackground", myBrown);
            UIManager.put("List.selectionInactiveBackground", myBrown);
            
            // JOptionPane buttons
            UIManager.put("OptionPane.buttonFocusWidth", 2);
            
            // Table and other selections
            UIManager.put("Table.selectionBackground", myBrown);
            UIManager.put("Tree.selectionBackground", myBrown);
            
            // Focus colors
            UIManager.put("Component.focusColor", myBrown);
            UIManager.put("Component.focusedBorderColor", myBrown);
            
            // CheckBox/RadioButton
            UIManager.put("CheckBox.icon.focusedBackground", myBrown);
            UIManager.put("CheckBox.icon.selectedBackground", myBrown);
            UIManager.put("RadioButton.icon.focusedBackground", myBrown);
            UIManager.put("RadioButton.icon.selectedBackground", myBrown);
            
            // Progress bar
            UIManager.put("ProgressBar.selectionBackground", myBrown);
            UIManager.put("ProgressBar.selectionForeground", myBrown);
            
            // Slider
            UIManager.put("Slider.thumbColor", myBrown);
            UIManager.put("Slider.focusedColor", myBrown);
            
            // Arcs
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