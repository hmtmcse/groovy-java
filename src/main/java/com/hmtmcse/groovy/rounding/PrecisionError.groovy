package com.hmtmcse.groovy.rounding

import com.hmtmcse.console.table.common.TableConstant
import com.hmtmcse.console.table.data.Table
import com.hmtmcse.console.table.data.TableRowData

import java.math.RoundingMode

class PrecisionError {

    public static List itemsAndPrice = [
            [price: 1.15, quantity: 1],
            [price: 22.95, quantity: 1],
    ]

    public static void main(String[] args) {
        [
                [
                        [price: 1.15, quantity: 1],
                        [price: 22.95, quantity: 1],
                ],
                [
                        [price: 1.15, quantity: 10],
                ],
                [
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                ],
                [
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                        [price: 1.15, quantity: 1],
                ],
                [
                        [price: 1.10, quantity: 2],
                        [price: 5.00, quantity: 1],
                ],
        ].each {
            itemsAndPrice = it
            calculate(10.0)
            println("")
            println("")
        }
    }


    public static Integer precision = 2
    public static RoundingMode roundingMode = RoundingMode.HALF_UP


    public static BigDecimal round(BigDecimal price, Integer precision, RoundingMode roundingMode) {
        return price.setScale(precision, roundingMode)
    }

    public static calculate(Double taxRateD){

        BigDecimal unitPrice
        BigDecimal taxRate = BigDecimal.valueOf(taxRateD)
        BigDecimal actualTaxPerUnit
        BigDecimal displayTaxPerUnit
        BigDecimal actualTotalTax
        BigDecimal displayTotalTax
        BigDecimal actualTotal
        BigDecimal displayTotal

        BigDecimal totalAmount
        BigDecimal displayTotalAmount


        BigDecimal actualTaxPerUnitSum = 0
        BigDecimal displayTaxPerUnitSum = 0
        BigDecimal actualTotalTaxSum = 0
        BigDecimal displayTotalTaxSum = 0
        BigDecimal actualTotalSum = 0
        BigDecimal displayTotalSum = 0
        BigDecimal totalAmountSum = 0
        BigDecimal displayTotalAmountSum = 0
        Integer quantitySum = 0

        Integer quantity
        Table table = new Table()
        TableRowData rowData


        rowData = new TableRowData()
        rowData.add("Price (P)", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)
        rowData.add("Quantity (Q)", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)
        rowData.add("Tax (T) {(P x ${taxRate}) / 100 }", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)
        rowData.add("Display Tax", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)
        rowData.add("Total Price {P x Q}", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)
        rowData.add("Display Total Price", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)
        rowData.add("Total Tax {T x Q}", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)
        rowData.add("Display Total Tax", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)

        rowData.add("Amount { Total Price + Total Tax}", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)
        rowData.add("Display Total Amount", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)
        table.addRow(rowData)

        println("Tax Rate: ${taxRateD}%")
        println("Precision: ${precision}")
        itemsAndPrice.each { item ->
            rowData = new TableRowData()
            unitPrice = BigDecimal.valueOf(item.price)
            quantity = item.quantity
            quantitySum += quantity


            actualTaxPerUnit = unitPrice.multiply(taxRate).divide(100)
            displayTaxPerUnit = round(actualTaxPerUnit, precision, roundingMode)

            actualTaxPerUnitSum = actualTaxPerUnitSum.add(actualTaxPerUnit)
            displayTaxPerUnitSum = displayTaxPerUnitSum.add(displayTaxPerUnit)

            actualTotal = unitPrice.multiply(quantity)
            displayTotal = round(actualTotal, precision, roundingMode)

            actualTotalSum = actualTotalSum.add(actualTotal)
            displayTotalSum = displayTotalSum.add(displayTotal)

            actualTotalTax = actualTotal.multiply(taxRate).divide(100)
            displayTotalTax = round(actualTotalTax, precision, roundingMode)

            actualTotalTaxSum = actualTotalTaxSum.add(actualTotalTax)
            displayTotalTaxSum = displayTotalTaxSum.add(displayTotalTax)


            totalAmount = actualTotal.add(actualTotalTax)
            displayTotalAmount = displayTotal.add(displayTotalTax)

            totalAmountSum = totalAmountSum.add(totalAmount)
            displayTotalAmountSum = displayTotalAmountSum.add(displayTotalAmount)


            rowData.add(unitPrice.toString(), TableConstant.RIGHT_ALIGN)
            rowData.add(quantity.toString(), TableConstant.RIGHT_ALIGN)

            rowData.add(actualTaxPerUnit.toString(), TableConstant.RIGHT_ALIGN)
            rowData.add(displayTaxPerUnit.toString(), TableConstant.RIGHT_ALIGN)

            rowData.add(actualTotal.toString(), TableConstant.RIGHT_ALIGN)
            rowData.add(displayTotal.toString(), TableConstant.RIGHT_ALIGN)


            rowData.add(actualTotalTax.toString(), TableConstant.RIGHT_ALIGN)
            rowData.add(displayTotalTax.toString(), TableConstant.RIGHT_ALIGN)

            rowData.add(totalAmount.toString() + " (${round(totalAmount, precision, roundingMode)})", TableConstant.RIGHT_ALIGN)
            rowData.add(displayTotalAmount.toString(), TableConstant.RIGHT_ALIGN)
            table.addRow(rowData)

        }

        rowData = new TableRowData()
        rowData.add("Total", TableConstant.RIGHT_ALIGN, TableConstant.RED)
        rowData.add(quantitySum.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED)

        rowData.add(actualTaxPerUnitSum.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED)
        rowData.add(displayTaxPerUnitSum.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED)

        rowData.add(actualTotalSum.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED)
        rowData.add(displayTotalSum.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED)


        rowData.add(actualTotalTaxSum.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED)
        rowData.add(displayTotalTaxSum.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED)

        rowData.add(totalAmountSum.toString() + " (${round(totalAmountSum, precision, roundingMode)})", TableConstant.RIGHT_ALIGN, TableConstant.RED)
        rowData.add(displayTotalAmountSum.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED)
        table.addRow(rowData)


        table.toTablePrint()

    }
}
