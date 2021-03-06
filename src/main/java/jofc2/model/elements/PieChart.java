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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jofc2.model.metadata.Alias;
import jofc2.model.metadata.Converter;
import jofc2.model.plugins.ValueElement;
import jofc2.util.PieChartSliceConverter;

public class PieChart extends Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8853434988212173862L;
	@Alias("start-angle")
	private Integer startAngle;
	private Collection<String> colours;
	private Boolean animate;
	private Integer border;
	private Integer radius;
	@Alias("no-labels")
	private Boolean noLabels;

	public PieChart() {
		super("pie");
	}

	public PieChart setAnimate(boolean animate) {
		this.animate = animate;
		return this;
	}

	public Boolean getAnimate() {
		return animate;
	}

	public Integer getStartAngle() {
		return startAngle;
	}

	public PieChart setStartAngle(Integer startAngle) {
		this.startAngle = startAngle;
		return this;
	}

	public Collection<String> getColours() {
		return colours;
	}

	public PieChart setColours(Collection<String> colours) {
		checkColours();
		this.colours = colours;
		return this;
	}

	public PieChart setColours(String... colours) {
		checkColours();
		this.colours.clear();
		this.colours.addAll(Arrays.asList(colours));
		return this;
	}

	public PieChart setColours(List<String> colours) {
		checkColours();
		this.colours.clear();
		this.colours.addAll(colours);
		return this;
	}

	public Integer getBorder() {
		return border;
	}

	public PieChart setBorder(Integer border) {
		this.border = border;
		return this;
	}

	public PieChart addValues(Object... values) {
		getValues().addAll(Arrays.asList(values));
		return this;
	}

	public PieChart addValues(List<Object> values) {//fangchi add 支持Value类型
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

	public PieChart addSlice(Number value, String text) {
		return addSlices(new Slice(value, text));
	}

	public PieChart addSlices(Slice... s) {
		getValues().addAll(Arrays.asList(s));
		return this;
	}

	public PieChart addSlices(List<Slice> values) {
		getValues().addAll(values);
		return this;
	}

	@Converter(PieChartSliceConverter.class)
	public static class Slice implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 6961394996186973937L;
		private final String label;
		private String tip;
		private String highlight="alpha";
		private String text;
		private final Number value;

		public Slice(Number value, String label) {
			this.label = label;
			this.value = value;
		}

		/**
		 * The slice changes alpha on mouse over instead of breaking out the pie
		 */
		public void setOnMouseOverAlpha() {
			this.highlight = "alpha";
		}

		/**
		 * The slice breaks out of the pie on mouse over instead of changing its
		 * alpha
		 */
		public void setOnMouseOverBreakout() {
			this.highlight = null;
		}

		public Number getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}


		public String getText() {
			return text;
		}

		/**
		 * @return the tip Text for the slice. If Tip isset it overrides the label
		 */
		public String getTip() {
			return tip;
		}

		/**
		 * Sets the tip Text for the slice. If Tip isset it overrides the label
		 * 
		 * @param tip
		 *           the Text to set
		 */
		public void setTip(String tip) {
			this.tip = tip;
		}

		
		public String getHighlight() {
			return highlight;
		}

		/**
		 * This value is the Representation of the Slice in the legend (if it is rendered)
		 */
		public void setText(String text) {
			this.text = text;
		}
	}

	private synchronized void checkColours() {
		if (colours == null) colours = new ArrayList<String>();
	}

	public Boolean getNoLabels() {
		return noLabels;
	}

	public void setNoLabels(Boolean noLabels) {
		this.noLabels = noLabels;
	}

	public Integer getRadius() {
		return radius;
	}

	/**
	 * "radius" allows you to force the radius of the pis to a certain size. If
	 * this is left out of the JSON then the pie will resize itself so that it
	 * and all of its labels fit in the display area (as best as it can).
	 * 
	 */
	public void setRadius(Integer radius) {
		this.radius = radius;
	}
}
