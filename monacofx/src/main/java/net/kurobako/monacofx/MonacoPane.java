package net.kurobako.monacofx;


import com.sun.javafx.webkit.WebConsoleListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.stream.Collectors;

import javafx.concurrent.Worker.State;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MonacoPane extends StackPane {


	private static final String VENDOR = "/vendor";

	static {
		URL.setURLStreamHandlerFactory(protocol ->
				!protocol.equals("fx") ? null : new URLStreamHandler() {
					@Override protected URLConnection openConnection(URL u) throws IOException {
						return MonacoPane.class
								.getResource(VENDOR + u.getPath())
								.openConnection();
					}
				});
	}


	private static String fromResource(String path) throws IOException {
		try (InputStream s = MonacoPane.class
				.getResource(path)
				.openConnection()
				.getInputStream();
		     BufferedReader reader = new BufferedReader(new InputStreamReader(s, UTF_8))
		) {
			return reader.lines().collect(Collectors.joining("\n"));
		}
	}

	public MonacoPane() {
		WebView wv = new WebView();
		getChildren().add(wv);
		WebEngine engine = wv.getEngine();

		WebConsoleListener.setDefaultListener((webView, message, lineNumber, sourceId) -> {
			System.out.println("\t" + sourceId + ":" + lineNumber + " " + message);
		});

		engine.getLoadWorker().stateProperty().addListener((o, p, n) -> {

			if (n == State.SUCCEEDED) {
				try {
					engine.executeScript(fromResource(VENDOR + "/require.js"));
					engine.executeScript(
							"initialise('a', 'text/plain','b', 'text/plain')");
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});

		try {
			engine.loadContent(fromResource("/manaco_editor.html"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}