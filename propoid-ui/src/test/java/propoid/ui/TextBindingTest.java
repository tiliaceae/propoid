package propoid.ui;

import android.app.Activity;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import propoid.ui.bind.TextBinding;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link TextBinding}.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = propoid.ui.BuildConfig.class)
public class TextBindingTest {

	private EditText editText;

	@Before
	public void setUp() {
		Activity activity = Robolectric.buildActivity(Activity.class).create().get();;

		editText = new EditText(activity);
		activity.setContentView(editText);
	}

	@Test
	public void test() throws Throwable {
		final Foo foo = new Foo();

		TextBinding.string(foo.stringP, editText);

		assertEquals("string", editText.getText().toString());

		foo.stringP.set("fromProperty");

		assertEquals("fromProperty", editText.getText().toString());

		editText.setText("fromView");

		assertEquals("fromView", foo.stringP.get());
	}
}