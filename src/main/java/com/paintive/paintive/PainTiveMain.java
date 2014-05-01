/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paintive.paintive;

import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.util.*;
import static org.jhotdraw.draw.AttributeKeys.*;

/**
 *
 * @author Yogayustiawan
 */
public class PainTiveMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

                // Create a drawing view with a default drawing, and
                // input/output formats for basic clipboard support.
                DrawingView view = new DefaultDrawingView();
                DefaultDrawing drawing = new DefaultDrawing();
                drawing.addInputFormat(new SerializationInputOutputFormat());
                drawing.addOutputFormat(new SerializationInputOutputFormat());
                view.setDrawing(drawing);

                // Create a common drawing editor for the views
                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view);

                // Create a tool bar
                JToolBar tb = new JToolBar();

                // Add a selection tool to the toolbar.
                ButtonFactory.addSelectionToolTo(tb, editor);

                // Add a creation tool for rectangles to the toolbar.
                HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(a, Color.WHITE);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RectangleFigure(), a),
                        "edit.createRectangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for ellipse to the toolbar.
                HashMap<AttributeKey, Object> b = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.WHITE);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new EllipseFigure(), b),
                        "edit.createEllipse",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for straight line to the toolbar.
                HashMap<AttributeKey, Object> c = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(c, Color.WHITE);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new LineFigure(), c),
                        "edit.createLine",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for text area to the toolbar.
                HashMap<AttributeKey, Object> d = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.RED);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TextAreaFigure(), d),
                        "edit.createTextArea",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for diamond to the toolbar.
                HashMap<AttributeKey, Object> e = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.WHITE);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new DiamondFigure(), e),
                        "edit.createDiamond",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for round rectangle to the toolbar.
                HashMap<AttributeKey, Object> g = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.WHITE);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RoundRectangleFigure(), g),
                        "edit.createRoundRectangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for triangle to the toolbar.
                HashMap<AttributeKey, Object> h = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.WHITE);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TriangleFigure(), h),
                        "edit.createTriangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                 // Add a creation tool for triangle to the toolbar.
                HashMap<AttributeKey, Object> i = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.WHITE);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TextFigure(), i),
                        "edit.createText",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);

                // Put all together into a JFrame
                JFrame f = new JFrame("YMS Painter");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(640, 480);

                // Set up the content pane
                // Place the toolbar on the left
                f.getContentPane().add(tb, BorderLayout.WEST);

                // Place the drawing view inside a scroll pane in the center
                JScrollPane sp = new JScrollPane(view.getComponent());
                sp.setPreferredSize(new Dimension(200, 200));
                f.getContentPane().add(sp, BorderLayout.CENTER);

                f.setVisible(true);
            }
        });
    }
}
