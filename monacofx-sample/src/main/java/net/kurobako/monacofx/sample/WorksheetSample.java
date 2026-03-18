package net.kurobako.monacofx.sample;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import net.kurobako.monacofx.sample.SamplerController.Sample;

public class WorksheetSample implements Sample {
    @Override
    public List<Tab> mkTabs() {
        try {
            Parent node = FXMLLoader.load(getClass().getResource("/Worksheet.fxml"));
            return List.of(new Tab("Worksheet", node));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
