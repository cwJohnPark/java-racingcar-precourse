package testutil;

import java.io.ByteArrayInputStream;

import org.assertj.core.util.Strings;

public class CommandUtils {

	public static void command(final String... args) {
		final byte[] buf = Strings.join(args).with("\n").getBytes();
		System.setIn(new ByteArrayInputStream(buf));
	}
}
