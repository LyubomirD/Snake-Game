package working_projects.Snake_Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

public class ButtonListener implements ActionListener {

    private final int delay;

    public final SnakeGame view;

    private final SnakeModel model;

    private final Timer timer;

    public ButtonListener(SnakeGame view, SnakeModel model) {
        this.view = view;
        this.model = model;
        this.delay = 75;
        this.timer = new Timer(delay, new TimerListener(view, model));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        String text = button.getText();

        if (text.equals("Start Game")) {
            button.setText("Restart Game");
        }

        button.setEnabled(false);
        model.initialize();
        timer.restart();
    }

}
