package jofc2.model.plugins;

import jofc2.model.metadata.Alias;
import jofc2.model.metadata.Converter;
import jofc2.util.plugins.KeyElementConverter;

@Converter(KeyElementConverter.class)
public class KeyElement {

	private String colour;
	
	private String text;
	
	@Alias("font-size")
	private String font_size;

	public String getColour() {
		return colour;
	}

	public KeyElement setColour(String colour) {
		this.colour = colour;
		return this;
	}

	public String getText() {
		return text;
	}

	public KeyElement setText(String text) {
		this.text = text;
		return this;
	}

	public String getFont_size() {
		return font_size;
	}

	public KeyElement setFont_size(String font_size) {
		this.font_size = font_size;
		return this;
	}
	
}
