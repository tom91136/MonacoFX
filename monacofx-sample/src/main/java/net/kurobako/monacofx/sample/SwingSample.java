package net.kurobako.monacofx.sample;

import java.awt.BorderLayout;
import java.util.List;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import net.kurobako.monacofx.MonacoPane;
import net.kurobako.monacofx.sample.SamplerController.Sample;

public class SwingSample implements Sample {
    @Override
    public List<Tab> mkTabs() {
        Label description = new Label("GesturePane works in a JFXPanel too!");
        description.setWrapText(true);
        description.setPadding(new Insets(16));
        Button button = new Button("Open Swing window");
        button.setOnAction(e -> SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException
                    | InstantiationException
                    | IllegalAccessException
                    | UnsupportedLookAndFeelException ignored) {
                // give up, doesn't matter
            }

            JLabel label = new JLabel("This window is a Swing JFrame with JFXPanel embedded " + "in a BorderLayout");
            label.setBorder(new EmptyBorder(10, 10, 10, 10));

            JFXPanel fxPanel = new JFXPanel();
            JFrame frame = new JFrame("GesturePane in Swing");
            frame.getContentPane().add(label, BorderLayout.NORTH);
            frame.getContentPane().add(fxPanel, BorderLayout.CENTER);
            frame.setSize(500, 500);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            Platform.runLater(() -> {
                MonacoPane pane = new MonacoPane();
                Scene scene = new Scene(pane, frame.getWidth(), frame.getHeight());
                fxPanel.setScene(scene);
            });
        }));
        VBox.setVgrow(button, Priority.ALWAYS);
        VBox box = new VBox(description, button);
        box.setAlignment(Pos.CENTER);
        return List.of(new Tab("Swing", box));
    }
}
