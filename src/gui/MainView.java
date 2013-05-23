package gui;

/**
 * MainView.java
 * Creates a JFrame panel from which all other UI contents can be displayed.
 * @author yongyuwang
 * @version 5-20-1931
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.User;


public class MainView extends JFrame {
	
    /**
	 * Default serial to suppress warnings
	 */
	private static final long serialVersionUID = 1L;

	public MainView(){
		
        this.setTitle("Main View");
        this.setSize(1280,720);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        JPanel panel = new JPanel();
        this.getContentPane().add(panel, BorderLayout.CENTER);

        // creates the login panel, gets authenticated user
        LoginView LoginPanel = new LoginView(MainView.this, "Login Window", true);
        User user = LoginPanel.getUser();
        
        // creates and adds HeaderView to MainView
        HeaderView headerPanel = new HeaderView(user);
        this.getContentPane().add(headerPanel, BorderLayout.NORTH);
        headerPanel.setVisible(true);
        
        // creates and adds ContentView to MainView
        ContentView contentPanel = new ContentView(user);
        
    }
    
    public static void main(String[] args){
        new MainView().setVisible(true);
    }
}