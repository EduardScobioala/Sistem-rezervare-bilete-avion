package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class ButtonFill extends BasicButtonUI {

	@Override
	public void update(Graphics g, JComponent c) {
		if (c.isOpaque()) {
			Color fillColor = c.getBackground();

			AbstractButton button = (AbstractButton) c;
			ButtonModel model = button.getModel();

			if (model.isPressed()) {
				fillColor = fillColor.darker();
			} else if (model.isRollover()) {
				fillColor = fillColor.brighter();
			}

			g.setColor(fillColor);
			g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 30, 30);
		}
		paint(g, c);
	}
}
