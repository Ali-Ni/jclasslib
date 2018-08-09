/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/

package org.gjt.jclasslib.browser.detail.attributes

import org.gjt.jclasslib.browser.BrowserServices
import org.gjt.jclasslib.browser.detail.TableDetailPane
import org.gjt.jclasslib.structures.attributes.ValueTypesAttribute
import org.gjt.jclasslib.structures.attributes.ValueTypesEntry
import java.util.*

class ValueTypesAttributeDetailPane(services: BrowserServices) : TableDetailPane<ValueTypesAttribute>(ValueTypesAttribute::class.java, services) {

    override fun createTableModel(attribute: ValueTypesAttribute) = AttributeTableModel(attribute.classes)

    override val rowHeightFactor: Float
        get() = 2f

    inner class AttributeTableModel(rows: Array<ValueTypesEntry>) : ColumnTableModel<ValueTypesEntry>(rows) {

        override fun buildColumns(columns: ArrayList<Column<ValueTypesEntry>>) {
            super.buildColumns(columns)
            columns.apply {
                add(object : NamedConstantPoolLinkColumn<ValueTypesEntry>("Inner Class", services, 220) {
                    override fun getConstantPoolIndex(row: ValueTypesEntry) = row.valueTypeClassInfoIndex
                })
            }
        }
    }
}
