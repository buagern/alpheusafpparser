/*
Copyright 2015 Rudolf Fiala

This file is part of Alpheus AFP Parser.

Alpheus AFP Parser is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Alpheus AFP Parser is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Alpheus AFP Parser.  If not, see <http://www.gnu.org/licenses/>
*/
package com.mgz.afp.base;

import java.io.IOException;
import java.io.OutputStream;

import com.mgz.afp.base.annotations.AFPType;
import com.mgz.afp.exceptions.AFPParserException;
import com.mgz.afp.exceptions.AFPValidationException;
import com.mgz.afp.exceptions.IAFPDecodeableWriteable;
import com.mgz.afp.parser.AFPParserConfiguration;
import com.mgz.util.UtilBinaryDecoding;

@AFPType
public class RepeatingGroupBase implements IAFPDecodeableWriteable,IRepeatingGroup{
	protected int repeatingGroupLength;

	public void decodeAFP(byte[] sfData, int offset, int length, AFPParserConfiguration config) throws AFPParserException {
		repeatingGroupLength = UtilBinaryDecoding.parseInt(sfData, offset, 2);
	}

	public void validate() throws AFPValidationException {
		// TODO: validate.
	}
	
	public void writeAFP(OutputStream os, AFPParserConfiguration config) throws IOException {
		os.write(UtilBinaryDecoding.intToByteArray(repeatingGroupLength, 2));
	}

	public int getRepeatingGroupLength() {
		return repeatingGroupLength;
	}

	public void setRepeatingGroupLength(int repeatingGroupLength) {
		this.repeatingGroupLength = repeatingGroupLength;
	}
}
