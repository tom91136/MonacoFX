package net.kurobako.monacofx.sample;

import net.kurobako.monacofx.sample.SamplerController.Sample;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

public class WorksheetSample implements Sample {
	@Override
	public Node mkRoot() {
		try {
			Parent node = FXMLLoader.load(getClass().getResource("/Worksheet.fxml"));
			return node;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
