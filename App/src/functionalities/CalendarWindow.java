package functionalities;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.swing.JFrame;

import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.ThemeType;
import com.mindfusion.common.*;

public class CalendarWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	java.util.Calendar selectedDate = java.util.Calendar.getInstance();
	Calendar calendar = new Calendar();
	protected PropertyChangeSupport changeSupport;

	public CalendarWindow() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);

		setSize(400, 250);
		setTitle("Choose a date");

		changeSupport = new PropertyChangeSupport(this);

		calendar.setTheme(ThemeType.Light);

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(calendar, BorderLayout.CENTER);

		calendar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// clear the selection
					calendar.getSelection().reset();
					// get the date that was double-clicked
					DateTime pointedDate = calendar.getDateAt(e.getX(), e.getY());
					// create a java.util.Calendar instance that points to the selected Date
					java.util.Calendar cal = java.util.Calendar.getInstance();
					cal.set(pointedDate.getYear(), pointedDate.getMonth() - 1, pointedDate.getDay());
					// raise the event
					setSelectedDate(cal);

					dispose();

				}

			}
		});

	}

	// getter of the selectedDate property
	public java.util.Calendar getSelectedDate() {
		return selectedDate;

	}

	// set the selectedDate when typed in the text field
	public void resetSelection(Date date) {
		calendar.getSelection().reset();
		calendar.getSelection().set(new DateTime(date), new DateTime(date).addMinutes(2));
		calendar.setDate(new DateTime(date));

	}

	// raises the event that the selectedDate property has changed
	public void setSelectedDate(java.util.Calendar selDate) {

		java.util.Calendar oldValue = (java.util.Calendar) selectedDate.clone();
		selectedDate = selDate;

		changeSupport.firePropertyChange("selectedDate", oldValue, selectedDate);

	}

	// adds a listener for the PropertyChange event
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

}
