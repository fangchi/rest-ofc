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
import java.util.Collection;

import jofc2.model.metadata.Alias;
import jofc2.model.metadata.Converter;
import jofc2.model.plugins.DotStyle;
import jofc2.util.ScatterChartPointConverter;

public class ScatterChart extends Element {

	private static final String TYPE = "scatter";
	private static final long serialVersionUID = 3029567780918048503L;
	private String colour;
	@Alias("dot-size")
	private Integer dotSize;
	
	@Alias("dot-style")
	private DotStyle dotStyle;

	public ScatterChart() {
		super(TYPE);
	}

    public ScatterChart(Style style){
        super(style.getStyle());
    }

	public ScatterChart addPoints(Point... points) {
		getValues().addAll(Arrays.asList(points));
		return this;
	}

	public ScatterChart addPoint(Number x, Number y) {
		return addPoints(new Point(x, y));
	}

	public ScatterChart addPoints(Collection<Point> points) {
		getValues().addAll(points);
		return this;
	}

	public String getColour() {
		return colour;
	}

	public ScatterChart setColour(String colour) {
		this.colour = colour;
		return this;
	}

	public Integer getDotSize() {
		return dotSize;
	}

	public void setDotSize(Integer dotSize) {
		this.dotSize = dotSize;
	}
	
	public DotStyle getDotStyle() {
		return dotStyle;
	}

	public ScatterChart setDotStyle(DotStyle dotStyle) {
		this.dotStyle = dotStyle;
		return this;
	}

	@Converter(ScatterChartPointConverter.class)
	public static class Point {

		private Number x;
		private Number y;
		@Alias("dot-size")
		private Number dotSize;
		
		//plugins
		@Alias("on-click")
		private String on_click;
		@Alias("on-click-text")
		private String on_click_text;
		
		private String tip;
		
		private String colour;
		
		public Point(Number x, Number y) {
			this.x = x;
			this.y = y;
		}

		public Number getX() {
			return x;
		}

		public Point setX(Number x) {
			this.x = x;
			return this;
		}

		public Number getY() {
			return y;
		}

		public Point setY(Number y) {
			this.y = y;
			return this;
		}

		public Number getDotSize() {
			return dotSize;
		}

		public Point setDotSize(Number dotSize) {
			this.dotSize = dotSize;
			return this;
		}

		public String getOn_click() {
			return on_click;
		}

		public Point setOn_click(String on_click) {
			this.on_click = on_click;
			return this;
		}

		public String getOn_click_text() {
			return on_click_text;
		}

		public Point setOn_click_text(String on_click_text) {
			this.on_click_text = on_click_text;
			return this;
		}

		public String getTip() {
			return tip;
		}

		public Point setTip(String tip) {
			this.tip = tip;
			return this;
		}

		public String getColour() {
			return colour;
		}

		public Point setColour(String colour) {
			this.colour = colour;
			return this;
		}
		
		
	}

    public static enum Style {
		NORMAL("scatter"), LINE("scatter_line");

		private String style;

		Style(String style) {
			this.style = style;
		}

		public String getStyle() {
			return style;
		}
	}
}
