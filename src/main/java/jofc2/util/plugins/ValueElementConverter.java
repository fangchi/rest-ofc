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
package jofc2.util.plugins;

import jofc2.model.plugins.ValueElement;
import jofc2.util.ConverterBase;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.path.PathTrackingWriter;

public class ValueElementConverter extends ConverterBase<ValueElement> {

	@Override
	public void convert(ValueElement o, PathTrackingWriter writer, MarshallingContext mc) {
		writeNode(writer, "value", o.getValue(), false);
		writeNode(writer, "colour", o.getColour(), true);
		writeNode(writer, "dot-size", o.getDotSize(), true);
		writeNode(writer, "type", o.getType(), true);
		writeNode(writer, "on-click", o.getOnClick(), true);
		writeNode(writer, "on-click-text", o.getOnClickText(), true);
		writeNode(writer, "tip", o.getTip(), true);
		writeNode(writer, "top", o.getTop(), true);
		writeNode(writer, "left", o.getLeft(), true);
		writeNode(writer, "right", o.getRight(), true);
		writeNode(writer, "label", o.getLabel(), true);
		writeNode(writer, "x", o.getX(), true);
		writeNode(writer, "y", o.getY(), true);
		writeNode(writer, "labelColour", o.getLabelColour(), true);
	}

	@SuppressWarnings("rawtypes")
	public boolean canConvert( Class arg0) {
		return ValueElement.class.isAssignableFrom(arg0);
	}
}
