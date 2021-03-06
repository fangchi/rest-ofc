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
import jofc2.model.plugins.OnShow;
import jofc2.model.plugins.ValueElement;
import jofc2.util.DotConverter;

public class LineChart extends Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8807130855547088579L;
	private static transient final Integer DEFAULT_FONTSIZE = 10;
	private Integer width;
	@Alias("dot-size")
	private Integer dotSize;
	@Alias("halo-size")
	private Integer haloSize;
	private String colour;
	private String axis;
	@Alias("on-show")
	private OnShow onShow;

	private Boolean loop;

	public String getYaxis() {
		return axis;
	}

	public void setYAxis(String yAxis) {
		this.axis = yAxis;
	}

	/**
	 * Tells the LineChart to Use the right YAxis
	 */
	public void setRightYAxis(){
		setYAxis("right");
	}

	public LineChart() {
		this(Style.NORMAL);
	}

	public LineChart(Style style) {
		this(style.getStyle());
	}

	protected LineChart(String type) {
		super(type);
		setFontSize(DEFAULT_FONTSIZE);
	}

	public Integer getWidth() {
		return width;
	}

	public LineChart setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Integer getDotSize() {
		return dotSize;
	}

	public LineChart setDotSize(Integer dotSize) {
		this.dotSize = dotSize;
		return this;
	}

	public String getColour() {
		return colour;
	}

	public LineChart setColour(String colour) {
		this.colour = colour;
		return this;
	}
	
	public OnShow getOnShow() {
		return onShow;
	}

	public LineChart setOnShow(OnShow onShow) {
		this.onShow = onShow;
		return this;
	}
	
	

	public Boolean getLoop() {
		return loop;
	}

	public LineChart setLoop(Boolean loop) {
		this.loop = loop;
		return this;
	}

	public LineChart addValues(Object... values) {//fangchi add 支持Value类型
		return addValues(Arrays.asList(values));
	}

	public LineChart addValues(List<Object> values) {//fangchi add 支持Value类型
		// We convert all Numbers to Dots except Null Values they are Converted to a Null Element
		// as Dots with the value null are interpreted as Zero from OFC and null Values themself are interpolated
		for (Object number : values) {
			if (number == null) {
				getValues().add(new NullElement());
			} else if((number instanceof Number)||(number instanceof ValueElement)) {
				getValues().add(number);
			} 
		}
		return this;
	}
	

	public LineChart addDots(Dot... dots) {
		return addDots(Arrays.asList(dots));
	}

	public LineChart addDots(List<Dot> dots) {
		getValues().addAll(dots);
		return this;
	}

	public Integer getHaloSize() {
		return haloSize;
	}

	public LineChart setHaloSize(Integer haloSize) {
		this.haloSize = haloSize;
		return this;
	}

	@Converter(DotConverter.class)
	public static class Dot {

		@Alias("halo-size")
		private Integer haloSize;
		@Alias("dot-size")
		private Integer dotSize;
		private Number value;
		private String colour;

		public Dot(Number value) {
			this(value, null, null, null);
		}

		public Dot(Number value, String colour) {
			this(value, colour, null, null);
		}

		public Dot(Number value, String colour, Integer dotSize, Integer haloSize) {
			setValue(value);
			setColour(colour);
			setDotSize(dotSize);
			setHaloSize(haloSize);
		}

		public Integer getHaloSize() {
			return haloSize;
		}

		public Dot setHaloSize(Integer haloSize) {
			this.haloSize = haloSize;
			return this;
		}

		public Integer getDotSize() {
			return dotSize;
		}

		public Dot setDotSize(Integer dotSize) {
			this.dotSize = dotSize;
			return this;
		}

		public Number getValue() {
			return value;
		}

		public Dot setValue(Number value) {
			this.value = value;
			return this;
		}

		public String getColour() {
			return colour;
		}

		public Dot setColour(String colour) {
			this.colour = colour;
			return this;
		}
	}

	public static enum Style {
		NORMAL("line"), DOT("line_dot"), HOLLOW("line_hollow");

		private String style;

		Style(String style) {
			this.style = style;
		}

		public String getStyle() {
			return style;
		}
	}
	
	
}
