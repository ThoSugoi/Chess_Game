package Menu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessMenu extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    
    public ChessMenu() {
        setTitle("LỳChess");

        setSize(1200, 836);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the main panel
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Create sub-panels 
        JPanel menuPanel = createSubPanel("menuPanel", "gamePanel", "recordsPanel", "modePanel","settingsPanel");
        JPanel gamePanel = createSubPanel("gamePanel", "menuPanel");
        JPanel recordsPanel = createSubPanel("recordsPanel", "menuPanel");
        JPanel modePanel = createSubPanel("modePanel", "menuPanel");
        JPanel settingsPanel = createSubPanel("settingsPanel", "menuPanel");


        // Add the sub-panels to the main panel
        mainPanel.add(menuPanel, "menuPanel");
        mainPanel.add(gamePanel, "gamePanel");
        mainPanel.add(recordsPanel, "recordsPanel");
        mainPanel.add(modePanel, "modePanel");
        mainPanel.add(settingsPanel, "settingsPanel");

        
        // Set the main panel as the content pane
        setContentPane(mainPanel);

        // Show the main panel
        cardLayout.show(mainPanel, "menuPanel");
    }
    private void setZero(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(button.getBackground());
        button.setBorder(null);
    }
    
    private void setButton(JButton button, String path) {
        // Create an ImageIcon with the texture image
        ImageIcon buttonTexture = new ImageIcon(path);
        // Get the button's size
        int buttonWidth = button.getWidth();
        int buttonHeight = button.getHeight();
        // Scale the texture image to match the button's size
        Image scaledTexture = buttonTexture.getImage().getScaledInstance(
                buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        // Create a new ImageIcon with the scaled texture image
        ImageIcon scaledButtonTexture = new ImageIcon(scaledTexture);
        // Set the button's icon to the scaled texture
        button.setIcon(scaledButtonTexture);

        // Adjust the position of the icon to align with the right end of the button
        button.setHorizontalTextPosition(SwingConstants.LEADING);
        button.setHorizontalAlignment(SwingConstants.TRAILING);

        // Adjust the margin to move the text and icon horizontally
        int horizontalMargin = buttonWidth - scaledButtonTexture.getIconWidth();
        button.setMargin(new Insets(0, horizontalMargin, 0, 0));
        setZero(button);
    }



    private JPanel createSubPanel(String name, String... buttons) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a layered pane to hold the components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 600));

        // Add the background image to the layered pane
        ImageIcon backgroundImage = null;
        if(name.equals("menuPanel")) {
        	backgroundImage = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\menu.png");
        }
        else if(name.equals("gamePanel")) {
             backgroundImage = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\game.png");
        }
        else if(name.equals("modePanel")) {
             backgroundImage = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\mode.png");
        }
        else if(name.equals("recordsPanel")) {
             backgroundImage = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\records.png");
        }
        else if(name.equals("settingsPanel")) {
             backgroundImage = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\settings.png");
        }
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        panel.add(backgroundLabel, BorderLayout.CENTER);


        JLabel label = new JLabel(name);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null); 

        // Create buttons and set their sizes and positions
        JButton[] menuButtons = new JButton[buttons.length];
        int buttonY = 15;
        String[] pathToButtonTexture = {
                "C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\newgamebutton.png",
                "C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\modesbutton.png",
                "C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\recordsbuttom.png",
                "C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\settingsbutton.png",
                "C:\\Users\\Admin\\eclipse-workspace\\ChessFromYoutube\\src\\res\\backbutton.png"
        };

        if(name.equals("menuPanel")) {
        	
            for (int i = 0; i < buttons.length; i++) {
                menuButtons[i] = new JButton(buttons[i]);
                menuButtons[i].addActionListener(this);
                menuButtons[i].setBounds(60, buttonY, 550, 160);
                buttonY += 190;


                setButton(menuButtons[i], pathToButtonTexture[i]);
                buttonPanel.add(menuButtons[i]);
            }        
        }else {
	        for (int i = 0; i < buttons.length; i++) {
	            menuButtons[i] = new JButton(buttons[i]);
	            menuButtons[i].addActionListener(this);
	            menuButtons[i].setBounds(920, 10, 200, 90);

                setButton(menuButtons[i], pathToButtonTexture[4]);
	            buttonPanel.add(menuButtons[i]);
	        }
	        
        }
        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command != null && !command.isEmpty()) {
            cardLayout.show(mainPanel, command);
        }
        if (command == "gamePanel") {
        	
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	ChessMenu example = new ChessMenu();
            example.setVisible(true);
        });
    }
}
