package jofc2.model.plugins;

import java.util.Arrays;
import java.util.List;

import jofc2.model.elements.Element;
import jofc2.model.elements.NullElement;

public class CandleChart extends Element {

	private static final long serialVersionUID = 6695611795831460343L;
	private String colour;

	public CandleChart() {
		super("candle");
	}
	
	public CandleChart addValues(Object... values) {
		return addValues(Arrays.asList(values));
	}

	public CandleChart addValues(List<Object> values) {
		
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

	public CandleChart setColour(String colour) {
		this.colour = colour;
		return this;
	}
}
