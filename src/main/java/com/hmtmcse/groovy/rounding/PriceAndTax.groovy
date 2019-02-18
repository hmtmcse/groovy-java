package com.hmtmcse.groovy.rounding

import com.hmtmcse.console.table.common.TableConstant
import com.hmtmcse.console.table.data.Table
import com.hmtmcse.console.table.data.TableRowData

import java.math.RoundingMode

class PriceAndTax {



    public static BigDecimal round(Double price, Integer precision, RoundingMode roundingMode){
        return BigDecimal.valueOf(price).setScale(precision, roundingMode)
    }

    public static void main(String[] args) {

        Table table = new Table();
        table.addHeader("Price", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader("Quantity", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader("Actual", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader("HALF_UP", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader("HALF_EVEN", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader("UP", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader("DOWN", TableConstant.LEFT_ALIGN, TableConstant.BLUE)

        def list = [
                [price: 2.7048, quentity: 5],
                [price: 2.7048, quentity: 1],
                [price: 2.7048, quentity: 7],
                [price: 2.7048, quentity: 3],
                [price: 2.485, quentity: 4],
                [price: 1.496, quentity: 2],
                [price: 2.397, quentity: 5],
        ]

        Integer precision = 2
        BigDecimal tmp, bigDecimal


        TableRowData rowData
        list.each {Map m ->
            rowData = table.setRowData("" + m.price)
            rowData.add( "" +  m.quentity)

            tmp = m.price *  m.quentity
            rowData.add( "" + tmp)

            bigDecimal = round(m.price, precision, RoundingMode.HALF_UP)
            tmp = m.quentity * bigDecimal
            rowData.add( "(" + bigDecimal + ") " + tmp)

            bigDecimal = round(m.price, precision, RoundingMode.HALF_EVEN)
            tmp = m.quentity * bigDecimal
            rowData.add( "(" + bigDecimal + ") " + tmp)

            bigDecimal = round(m.price, precision, RoundingMode.UP)
            tmp = m.quentity * bigDecimal
            rowData.add( "(" + bigDecimal + ") " + tmp)

            bigDecimal = round(m.price, precision, RoundingMode.DOWN)
            tmp = m.quentity * bigDecimal
            rowData.add( "(" + bigDecimal + ") " + tmp)

            table.addRow(rowData)
        }
        table.toTablePrint()
    }

}
