package jofc2.model.plugins;

import java.util.Arrays;
import java.util.List;

import jofc2.model.elements.Element;
import jofc2.model.elements.NullElement;
import jofc2.model.metadata.Alias;

public class Tags extends Element {

	private static final long serialVersionUID = 6695611795831460343L;
	private String colour;
	@Alias("pad-x")
	private Number padX;
	@Alias("pad-y")
	private Number padY;
	private Number rotate;
	@Alias("align-x")
	private String alignX;
	@Alias("align-y")
	private String alignY;


	public Tags() {
		super("tags");
	}
	
	public Tags addValues(Object... values) {
		return addValues(Arrays.asList(values));
	}

	public Tags addValues(List<Object> values) {
		
		for (Object number : values) {
			if (number == null) {
				getValues().add(new NullElement());
			} else if((number instanceof Number)||(number instanceof ValueElement)) {
				getValues().add(number);
			} 
		}
		return this;
	}

	public String getColour() {
		return colour;
	}

	public Tags setColour(String colour) {
		this.colour = colour;
		return this;
	}

	public Number getPadX() {
		return padX;
	}

	public Tags setPadX(Number padX) {
		this.padX = padX;
		return this;
	}

	public Number getPadY() {
		return padY;
	}

	public Tags setPadY(Number padY) {
		this.padY = padY;
		return this;
	}

	public Number getRotate() {
		return rotate;
	}

	public Tags setRotate(Number rotate) {
		this.rotate = rotate;
		return this;
	}

	public String getAlignX() {
		return alignX;
	}

	public Tags setAlignX(String alignX) {
		this.alignX = alignX;
		return this;
	}

	public String getAlignY() {
		return alignY;
	}

	public Tags setAlignY(String alignY) {
		this.alignY = alignY;
		return this;
	}
}
