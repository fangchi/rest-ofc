package jofc2.model.plugins;

public class DotStyle {

	private String type;
	
	private Integer width;
	
	private Integer size;
	
	private Integer sides;
	
	private String tip;

	public String getType() {
		return type;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getSize() {
		return size;
	}

	public DotStyle setType(String type) {
		this.type = type;
		return this;
	}

	public DotStyle setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public DotStyle setSize(Integer size) {
		this.size = size;
		return this;
	}

	public Integer getSides() {
		return sides;
	}

	public DotStyle setSides(Integer sides) {
		this.sides = sides;
		return this;
	}

	public String getTip() {
		return tip;
	}

	public DotStyle setTip(String tip) {
		this.tip = tip;
		return this;
	}
}
