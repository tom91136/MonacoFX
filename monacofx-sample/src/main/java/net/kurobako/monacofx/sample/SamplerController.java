package net.kurobako.monacofx.sample;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import atlantafx.base.theme.Dracula;
import atlantafx.base.theme.NordDark;
import atlantafx.base.theme.NordLight;
import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import atlantafx.base.theme.Theme;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

public class SamplerController implements Initializable {

    private static final String URI = "https://github.com/tom91136/monacofx";

    private static final List<Theme> UI_THEMES = List.of(
            new CupertinoDark(),
            new CupertinoLight(),
            new Dracula(),
            new NordDark(),
            new NordLight(),
            new PrimerDark(),
            new PrimerLight());

    interface Sample {
        List<Tab> mkTabs();

        default void setTheme(String theme) {}

        default void setScrollDeltaLines(int lines) {}
    }

    @FXML
    private VBox root;

    @FXML
    private Hyperlink link;

    @FXML
    private TabPane tabs;

    @FXML
    private ComboBox<String> themeBox;

    @FXML
    private ComboBox<String> scrollBox;

    @FXML
    private ComboBox<Theme> uiThemeBox;

    HostServices hostServices;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Sample> samples = List.of(new FXMLSample(), new SwingSample(), new JShellSample());

        samples.forEach(s -> tabs.getTabs().addAll(s.mkTabs()));

        themeBox.getItems().addAll("vs-dark", "vs", "hc-black", "hc-light");
        themeBox.setValue("vs-dark");
        themeBox.setOnAction(e -> {
            String theme = themeBox.getValue();
            samples.forEach(s -> s.setTheme(theme));
        });

        scrollBox.getItems().addAll("1 Line", "3 Lines", "5 Lines", "8 Lines", "12 Lines");
        scrollBox.setValue("5 Lines");
        scrollBox.setOnAction(e -> {
            int lines = Integer.parseInt(scrollBox.getValue().split(" ")[0]);
            samples.forEach(s -> s.setScrollDeltaLines(lines));
        });

        uiThemeBox.getItems().addAll(UI_THEMES);
        uiThemeBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Theme t) {
                return t == null ? "" : t.getName();
            }

            @Override
            public Theme fromString(String s) {
                return null;
            }
        });
        // Apply CupertinoDark immediately so the toolbar CSS variables resolve on first paint.
        Application.setUserAgentStylesheet(UI_THEMES.get(0).getUserAgentStylesheet());
        uiThemeBox.setValue(UI_THEMES.get(0));
        uiThemeBox.setOnAction(e -> {
            Theme t = uiThemeBox.getValue();
            if (t != null) Application.setUserAgentStylesheet(t.getUserAgentStylesheet());
        });

        link.setOnAction(e -> {
            if (hostServices == null) {
                TextInputDialog dialog = new TextInputDialog(URI);
                dialog.setTitle("HostService missing");
                dialog.setHeaderText("Unable to open URL due to missing HostService");
                dialog.setContentText("URL");
                dialog.showAndWait();
            } else hostServices.showDocument(URI);
        });
    }
}
