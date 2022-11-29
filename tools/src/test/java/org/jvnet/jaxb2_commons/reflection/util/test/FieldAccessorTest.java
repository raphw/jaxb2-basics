package org.jvnet.jaxb2_commons.reflection.util.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;
import org.jvnet.jaxb2_commons.reflection.util.Accessor;
import org.jvnet.jaxb2_commons.reflection.util.FieldAccessor;

public class FieldAccessorTest {

	@Test
	public void testGetAndSet() {
		Sample sample = new Sample();
		sample.setValue("foo");

		final Accessor<String> sampleAccessor = new FieldAccessor<String>(
				Sample.class, "value", String.class);

		Assert.assertEquals("foo", sampleAccessor.get(sample));
		sampleAccessor.set(sample, "bar");
		Assert.assertEquals("bar", sampleAccessor.get(sample));
		Assert.assertEquals("bar", sample.getValue());
	}

	public static class Sample {

		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
