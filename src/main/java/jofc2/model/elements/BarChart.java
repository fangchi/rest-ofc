/*
This file is part of JOFC2.

JOFC2 is free software: you can redistribute it and/or modify
it under the terms of the Lesser GNU General Public License as
published by the Free Software Foundation, either version 3 of
the License, or (at your option) any later version.

JOFC2 is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

See <http://www.gnu.org/licenses/lgpl-3.0.txt>.
 */
package jofc2.model.elements;

import java.util.Arrays;
import java.util.List;

import jofc2.model.metadata.Alias;
import jofc2.model.metadata.Converter;
import jofc2.model.plugins.ValueElement;
import jofc2.util.BarConverter;

public class BarChart extends Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6695611795831460343L;
	private String colour;

	public BarChart() {
		this(Style.NORMAL);
	}

	public BarChart(Style style) {
		super(style.getStyle());
	}

	protected BarChart(String style) {
		super(style);
	}

	public BarChart addValues(Object... values) {
		return addValues(Arrays.asList(values));
	}

	public BarChart addValues(List<Object> values) {
		/*for (Number number : values) {
			if (number!=null){
			this.addBars(new Bar(number));
			}
		}*/
		
		for (Object number : values) {
			if (number == null) {
				getValues().add(new NullElement());
			} else if((number instanceof Number)||(number instanceof ValueElement)) {
				getValues().add(number);
			} 
		}
		return this;
	}

	public BarChart addBars(Bar... bars) {
		return addBars(Arrays.asList(bars));

	}

	public BarChart addBars(List<Bar> bars) {
		getValues().addAll(bars);
		return this;
	}

	public String getColour() {
		return colour;
	}

	public BarChart setColour(String colour) {
		this.colour = colour;
		return this;
	}

	public static enum Style {
		NORMAL("bar"), THREED("bar_3d"), GLASS("bar_glass"),/*plugin*/HBAR("hbar");

		private String style;

		Style(String style) {
			this.style = style;
		}

		public String getStyle() {
			return style;
		}
	}

	@Converter(BarConverter.class)
	public static class Bar {

		private Number top;
		private Number bottom;
		private String colour;
		@Alias("tip")
		private String tooltip;

		public Bar(Number top, Number bottom, String colour) {
			setTop(top);
			setBottom(bottom);
			setColour(colour);
		}

		public Bar(Number top, Number bottom) {
			this(top, bottom, null);
		}

		public Bar(Number top, String colour) {
			this(top, null, colour);
		}

		public Bar(Number top) {
			this(top, null, null);
		}

		public Number getTop() {
			return top;
		}

		public Bar setTop(Number top) {
			this.top = top;
			return this;
		}

		public Number getBottom() {
			return bottom;
		}

		public Bar setBottom(Number bottom) {
			this.bottom = bottom;
			return this;
		}

		public String getColour() {
			return colour;
		}

		public Bar setColour(String colour) {
			this.colour = colour;
			return this;
		}

		public String getTooltip() {
			return tooltip;
		}

		public Bar setTooltip(String tooltip) {
			this.tooltip = tooltip;
			return this;
		}
	}
}
