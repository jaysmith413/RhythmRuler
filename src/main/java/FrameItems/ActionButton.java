package FrameItems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionButton extends JButton{
    private JButton actionButton;
    public ActionButton(ImageIcon icon){
        actionButton = new JButton();
        actionButton.setBounds(50, 100, 700, 500);
        actionButton.setText(" ");
        actionButton.setFocusable(false);
        actionButton.setContentAreaFilled(false);
        actionButton.setDisabledIcon(icon);
        actionButton.setIcon(icon);
        actionButton.setHorizontalTextPosition(JButton.CENTER);
        actionButton.setVerticalTextPosition(JButton.TOP);
        actionButton.setIconTextGap(200);
        actionButton.setEnabled(false);
        actionButton.setBackground(Color.white);
        actionButton.setFont(new Font("Comic Sans", 1, 32));
    }

    public JButton getActionButton() {
        return actionButton;
    }
}
