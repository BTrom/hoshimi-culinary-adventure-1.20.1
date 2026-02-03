package com.botrom.hoshimi_ca_mod.gui.coppergolem.options;

import com.botrom.hoshimi_ca_mod.gui.coppergolem.options.control.ControlElement;
import com.botrom.hoshimi_ca_mod.gui.coppergolem.widget.Dim2i;

/**
 * Interface for option controls (UI widgets for editing options).
 */
public interface Control<T> {
    
    /**
     * Creates the control element for rendering.
     * @param dim The position and dimensions
     * @return The control element
     */
    ControlElement<T> createElement(Dim2i dim);
    
    /**
     * Gets the option this control is for.
     * @return The option
     */
    Option<T> getOption();
    
    /**
     * Gets the maximum width needed for the control's value display.
     * @return The width in pixels
     */
    int getMaxWidth();
    
    /**
     * Gets the height needed for this control.
     * @param availableWidth The available width for the control
     * @return The height in pixels (default 18)
     */
    default int getHeight(int availableWidth) {
        return 18;
    }
}
