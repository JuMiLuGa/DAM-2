package controls;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author DAM2_Alu10
 */

public class AvancedTextField extends JTextField implements Serializable {
    
    
    
    

     
    
    public AvancedTextField() {
        this.setAdvancedBackColor(Color.YELLOW);
        
        
    }
    
    private Color advancedBackColor;

    /**
     * Get the value of advancedColor
     *
     * @return the value of advancedColor
     */
    public Color getAdvancedBackColor() {
        return advancedBackColor;
    }

    /**
     * Set the value of advancedColor
     *
     * @param advancedColor new value of advancedColor
     */
    public void setAdvancedBackColor(Color advancedBackColor) {
        this.advancedBackColor = advancedBackColor;
        this.setBackground(advancedBackColor);
    }
    
    private int advancedAnchor;
    
    /**
     * Get the value of advancedAnchor
     *
     * @return the value of advancedAnchor
     */
    public int getAdvancedAnchor() {
        return advancedAnchor;
    }

    /**
     * Set the value of advancedAnchor
     *
     * @param advancedAnchor new value of advancedAnchor
     */
    public void setAdvancedAnchor(int advancedAnchor) {
        this.advancedAnchor = advancedAnchor;
        this.setColumns(advancedAnchor);
        
    }
    
    private Font advancedFont;
    
    /**
     * Get the value of advancedFont
     *
     * @return the value of advancedFont
     */
    public Font getAdvancedFont() {
        return advancedFont;
    }

    /**
     * Set the value of advancedFont
     *
     * @param advancedFont new value of advancedFont
     */
    public void setAdvancedFont(Font advancedFont) {
        this.advancedFont = advancedFont;
        this.setFont(advancedFont);
    }
}
