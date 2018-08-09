/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.attributes

import java.io.DataInput
import java.io.DataOutput

/**
 * Describes an entry in a ValueTypes attribute structure.
 */
class ValueTypesEntry : SubStructure() {

    /**
     * Constant pool index of the CONSTANT_Class_info structure
     * describing the class of this value type class.
     */
    var valueTypeClassInfoIndex: Int = 0

    override fun readData(input: DataInput) {
        valueTypeClassInfoIndex = input.readUnsignedShort()
    }

    override fun writeData(output: DataOutput) {
        output.writeShort(valueTypeClassInfoIndex)
    }

    override val debugInfo: String
        get() = "with valueTypeClassInfoIndex $valueTypeClassInfoIndex"

    override val length: Int
        get() = 2

}
