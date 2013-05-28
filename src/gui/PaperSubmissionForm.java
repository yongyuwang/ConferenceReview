package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PaperSubmissionForm extends JFrame implements ActionListener {
	
	/**
	 * The default serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The default background color.
	 */
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	
	/**
	 * The default frame width.
	 */
	private static final int FRAME_WIDTH = 300;
	
	/**
	 * The default frame height.
	 */
	private static final int FRAME_HEIGHT = 500;

	
	final JLabel firstNameLabel, lastNameLabel, paperTitleLabel, keywordsLabel, catagoryLabel;
	final JTextField  firstNameField, lastNameField, paperTitleField, keywordsField, catagoryField;
	final BackgroundTextArea paperAbstract, paperContents;
	
	final JButton submitButton, cancelButton;
	final JPanel topPanel, midPanel, bottemPanel;
	
	
	public PaperSubmissionForm() {
		
		super("New Paper Submission");
		
		firstNameLabel = new JLabel("First name:");
		firstNameField = new JTextField(15);

		lastNameLabel = new JLabel("Last name:");
		lastNameField = new JTextField(15);
		
		paperTitleLabel = new JLabel("Submission title:");
		paperTitleField = new JTextField(15);
		
		keywordsLabel = new JLabel("Keywords:");
		keywordsField = new JTextField(15);
		
		catagoryLabel = new JLabel("Catagory:");
		catagoryField = new JTextField(15);
		
		topPanel = new JPanel(new GridLayout(5,2));
		
		topPanel.add(firstNameLabel);
		topPanel.add(firstNameField);
		
		topPanel.add(lastNameLabel);
		topPanel.add(lastNameField);
		
		topPanel.add(paperTitleLabel);
		topPanel.add(paperTitleField);
		
		topPanel.add(keywordsLabel);
		topPanel.add(keywordsField);
		
		topPanel.add(catagoryLabel);
		topPanel.add(catagoryField);
		
		paperAbstract = new BackgroundTextArea("Paste or type your abstract here.");
		paperAbstract.setWrapStyleWord(true);
		JScrollPane abstractScrollPane = new JScrollPane(paperAbstract);
		
		paperContents = new BackgroundTextArea("Paste or type your paper here.");
		paperContents.setWrapStyleWord(true);
		JScrollPane contentScrollPane = new JScrollPane(paperContents);
				
		midPanel = new JPanel(new GridLayout(2,1));
		midPanel.add(abstractScrollPane);
		midPanel.add(contentScrollPane);

		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		
		bottemPanel = new JPanel();
		bottemPanel.add(submitButton);
		bottemPanel.add(cancelButton);
		
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(bottemPanel, BorderLayout.SOUTH);

		setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setBackground(BACKGROUND_COLOR);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String [] args) {
		new PaperSubmissionForm().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

class BackgroundTextArea extends JTextArea implements FocusListener {

    private final String backgroundText;

    public BackgroundTextArea(final String backgroundText) {
        super(backgroundText);
        this.backgroundText = backgroundText;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(this.getText().isEmpty()) {
            super.setText("");
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(this.getText().isEmpty()) {
            super.setText(backgroundText);
        }
    }

    @Override
    public String getText() {
        String typed = super.getText();
        return typed.equals(backgroundText) ? "" : typed;
    }
}
