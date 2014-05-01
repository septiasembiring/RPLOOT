/*
 * @(#)SelectionColorIcon.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.action;

import java.awt.*;
import java.net.*;
import org.jhotdraw.draw.*;

/**
 * SelectionColorIcon draws a shape with the specified color for the selected
 * figures in the current drawing view.
 * If now figures are selcted, the specified color is taken from the DrawingEditor.
 * <p>
 * The behavior for choosing the drawn color matches with
 * {@link SelectionColorChooserAction }.
 * 
 * @author Werner Randelshofer
 * @version $Id: SelectionColorIcon.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class SelectionColorIcon extends javax.swing.ImageIcon {
    private DrawingEditor editor;
    private AttributeKey<Color> key;
    private Shape colorShape;
    
    /** Creates a new instance.
     * @param editor The drawing editor.
     * @param key The key of the default attribute
     * @param imageLocation the icon image
     * @param colorShape The shape to be drawn with the color of the default
     * attribute.
     */
    public SelectionColorIcon(
            DrawingEditor editor,
            AttributeKey<Color> key,
            URL imageLocation,
            Shape colorShape) {
        super(imageLocation);
        this.editor = editor;
        this.key = key;
        this.colorShape = colorShape;
    }
    public SelectionColorIcon(
            DrawingEditor editor,
            AttributeKey<Color> key,
            Image image,
            Shape colorShape) {
        super(image);
        this.editor = editor;
        this.key = key;
        this.colorShape = colorShape;
    }
    
    @Override
    public void paintIcon(java.awt.Component c, java.awt.Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        super.paintIcon(c, g, x, y);
        Color color;
        DrawingView view = editor.getActiveView();
        if (view != null && view.getSelectedFigures().size() == 1) {
            color = view.getSelectedFigures().iterator().next().get(key);
        } else {
            color = key.get(editor.getDefaultAttributes());
        }
        if (color != null) {
            g.setColor(color);
            g.translate(x, y);
            g.fill(colorShape);
            g.translate(-x, -y);
        }
    }
}
