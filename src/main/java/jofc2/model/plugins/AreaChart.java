package jofc2.model.plugins;

import java.util.Arrays;

import jofc2.model.elements.LineChart;
import jofc2.model.metadata.Alias;

public class AreaChart extends LineChart{

	private static final long serialVersionUID = -885512541074275055L;
	
	private static transient final Float DEFAULT_ALPHA = 0.35f;
	
	private String fill;
	
	@Alias("fill-alpha")
	private Float fillAlpha;
	
	@Alias("line-style")
	private LineStyle lineStyle;
	
	@Alias("dot-style")
	private DotStyle dotStyle;
	
	
	public AreaChart() {
		super("area");
		setFillAlpha(DEFAULT_ALPHA);
	}

	public AreaChart setFillAlpha(Float fillAlpha) {
		this.fillAlpha = fillAlpha;
		return this;
	}
	
	public Float getFillAlpha() {
		return fillAlpha;
	}
	

	public String getFill() {
		return fill;
	}

	public AreaChart setFill(String fill) {
		this.fill = fill;
		return this;
	}

	public LineStyle getLineStyle() {
		return lineStyle;
	}

	public AreaChart setLineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
		return this;
	}

	public DotStyle getDotStyle() {
		return dotStyle;
	}

	public AreaChart setDotStyle(DotStyle dotStyle) {
		this.dotStyle = dotStyle;
		return this;
	}
	
	public LineChart addValues(Number... values) {
		return addValues(Arrays.asList(values));
	}
}
