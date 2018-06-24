package net.kurobako.monacofx;


import org.assertj.core.api.Condition;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Offset;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javafx.animation.Interpolator;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.geometry.BoundingBox;
import javafx.geometry.Dimension2D;
import javafx.geometry.Orientation;
import javafx.geometry.Point2D;
import javafx.geometry.VerticalDirection;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ZoomEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;
import javafx.stage.Window;
import javafx.util.Duration;

import static javafx.geometry.Orientation.HORIZONTAL;
import static javafx.geometry.Orientation.VERTICAL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;


@RunWith(Parameterized.class)
public class MonacoPaneTest {


	private static abstract class TestTarget {
		final String name;
		TestTarget(String name) { this.name = name; }
		abstract MonacoPane createPane();
		abstract Transform captureTransform();
		@Override
		public String toString() { return name; }
	}

	private static final String LENA = MonacoPaneTest.class
			.getResource("/lena_512.jpg")
			.toExternalForm();

	private static final UncaughtExceptionHandler HANDLER = (t, e) -> {
		throw new AssertionError("Thread " + t.getName() + " crashed while testing", e);
	};


	private static final String ID = "target";
	private MonacoPane pane;

	@Parameter public TestTarget target;

	// headful test will spawn actual window and take control of the mouse and keyboard!
	@BeforeClass
	public static void setupClass() {
		if (!Boolean.getBoolean("headful")) {
			System.out.println("Testing using Monocle");
			System.setProperty("testfx.robot", "glass");
			System.setProperty("testfx.headless", "true");
			System.setProperty("prism.order", "sw");
			System.setProperty("prism.text", "t2k");
		} else {
			System.out.println("Testing headful with real windows, " +
					"please do not touch keyboard or mouse until tests are " +
					"complete.");
		}
	}

	@Before
	public void setup() throws Exception {
		if (Platform.isFxApplicationThread()) throw new AssertionError("Invalid test state");
		Thread.setDefaultUncaughtExceptionHandler(HANDLER);
		FxToolkit.registerPrimaryStage();
//		FxToolkit.registerStage(() -> new Stage(StageStyle.TRANSPARENT));
		FxToolkit.setupSceneRoot(() -> {
			if (!Platform.isFxApplicationThread()) throw new AssertionError("Invalid test state");
			Thread.currentThread().setUncaughtExceptionHandler(HANDLER);
			pane = target.createPane();
			pane.setId(ID);
			return pane;
		});
		FxToolkit.setupStage(Window::sizeToScene);
		FxToolkit.showStage();
	}

	@After
	public void tearDown() throws Exception {
		FxToolkit.cleanupStages();
	}
	private static Condition<Node> createBarCondition(Orientation orientation, boolean visible) {
		return new Condition<>(n -> {
			if (n instanceof ScrollBar) {
				ScrollBar bar = (ScrollBar) n;
				return ((ScrollBar) n).getOrientation() == orientation &&
						visible == bar.isManaged() &&
						visible == bar.isVisible();
			} else return false;
		}, "Is ScrollBar " + orientation + " and " + (visible ? "visible" : "hidden"));
	}

	@Test
	public void testInitialisation() {
		FxAssert.verifyThat("#" + ID, NodeMatchers.isNotNull());
	}


}