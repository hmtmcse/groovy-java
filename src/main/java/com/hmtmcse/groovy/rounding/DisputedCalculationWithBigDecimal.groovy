package com.hmtmcse.groovy.rounding

import com.hmtmcse.console.table.common.TableConstant
import com.hmtmcse.console.table.data.Table
import com.hmtmcse.console.table.data.TableRowData

import java.math.RoundingMode

class DisputedCalculationWithBigDecimal {

    static Map headerDefination = [
            UP  : "Unit Price",
            Qty : "Quantity",
            ATPU: "Actual Tax Per Unit",
            RTPU: "Rounded Tax Per Unit",
            ATP : "Actual Total Price",
            RTP : "Rounded Total Price",
            ATT : "Actual Total Tax",
            RTT : "Rounded Total Tax"
    ]

    public static BigDecimal round(Double price, Integer precision, RoundingMode roundingMode) {
        return BigDecimal.valueOf(price).setScale(precision, roundingMode)
    }

    public static void main(String[] args) {

        Double taxRate = 10
        Integer scale = 2
        RoundingMode roundingMode = RoundingMode.HALF_UP

        def cartItemList = [
               [price: 0.10, quentity: 1],
               [price: 0.13, quentity: 1],
        ]
        makeCart(cartItemList, taxRate, scale, roundingMode)
    }

    public static  makeCart(def productList,  Double taxRate, Integer scale, RoundingMode roundingMode ){

        headerDefination.each{ header ->
            println(header.key+" = "+header.value)
        }

        println("")

        Table table = new Table();
        table.addHeader(headerDefination.keySet()[0].toString(), TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader(headerDefination.keySet()[1].toString(), TableConstant.LEFT_ALIGN, TableConstant.BLUE)

        table.addHeader(headerDefination.keySet()[2].toString()+" (UP × taxRate(${taxRate}) / 100)", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader(headerDefination.keySet()[3].toString(), TableConstant.LEFT_ALIGN, TableConstant.BLUE)

        table.addHeader(headerDefination.keySet()[4].toString()+" (UP × ${headerDefination.keySet()[1]}) ", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader(headerDefination.keySet()[5].toString(), TableConstant.LEFT_ALIGN, TableConstant.BLUE)

        table.addHeader(headerDefination.keySet()[6].toString()+" ((ATP × taxRate(${taxRate})) / 100) ", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader(headerDefination.keySet()[7].toString(), TableConstant.LEFT_ALIGN, TableConstant.BLUE)

        table.addHeader("Amount (ATP + ATT)", TableConstant.LEFT_ALIGN, TableConstant.BLUE)
        table.addHeader("Rounded Amount", TableConstant.LEFT_ALIGN, TableConstant.BLUE)

        TableRowData rowData
        BigDecimal subTotalQuantity = 0

        BigDecimal subTotalActualUnitTax = 0
        BigDecimal subTotalRoundedUnitTax = 0

        BigDecimal subTotalActualTax = 0
        BigDecimal subTotalRoundedTax = 0

        BigDecimal subTotalActualPrice = 0
        BigDecimal subTotalRoundedPrice = 0

        BigDecimal subTotalActualAmount = 0
        BigDecimal subTotalRoundedAmount = 0

        productList.each{ Map product ->
            rowData = table.setRowData("" + product.price, TableConstant.RIGHT_ALIGN)
            rowData.add("" + product.quentity, TableConstant.RIGHT_ALIGN)

            BigDecimal actualUnitTax = ((product.price * taxRate) / 100)
            BigDecimal roundedUnitTax = round(actualUnitTax, scale, roundingMode)

            rowData.add("" + (actualUnitTax), TableConstant.RIGHT_ALIGN)
            rowData.add("" + (roundedUnitTax), TableConstant.RIGHT_ALIGN)

            BigDecimal actualTotalPrice = product.quentity * product.price
            BigDecimal roundedTotalPrice = round(actualTotalPrice, scale, roundingMode)

            rowData.add("" + actualTotalPrice, TableConstant.RIGHT_ALIGN)
            rowData.add("" + roundedTotalPrice, TableConstant.RIGHT_ALIGN, TableConstant.YALLOW)

            BigDecimal actualTotalTax = (actualTotalPrice.multiply(taxRate) / 100)
            BigDecimal roundedTotalTax = round(roundedUnitTax.multiply(product.quentity), scale, roundingMode)

            rowData.add("" + actualTotalTax, TableConstant.RIGHT_ALIGN)
            rowData.add("" + roundedTotalTax, TableConstant.RIGHT_ALIGN)

            BigDecimal actualAmount = actualTotalPrice.add(actualTotalTax)
            BigDecimal roundedAmount = roundedTotalTax.add(roundedTotalPrice)

            rowData.add("" + (actualAmount), TableConstant.RIGHT_ALIGN)
            rowData.add("" + (roundedAmount), TableConstant.RIGHT_ALIGN, TableConstant.BLUE)
            table.addRow(rowData)

            subTotalQuantity += product.quentity

            subTotalActualTax += actualTotalTax
            subTotalRoundedTax += roundedTotalTax

            subTotalActualUnitTax += actualUnitTax
            subTotalRoundedUnitTax += roundedUnitTax

            subTotalActualPrice += actualTotalPrice
            subTotalRoundedPrice += roundedTotalPrice

            subTotalActualAmount += actualAmount
            subTotalRoundedAmount += roundedAmount
        }
        rowData = table.setRowData();
        rowData.add("Total Calculation", TableConstant.RIGHT_ALIGN, TableConstant.RED);
        rowData.add(subTotalQuantity.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED);

        rowData.add(subTotalActualUnitTax.toString()+" ("+round(subTotalActualUnitTax, scale, roundingMode)+")", TableConstant.RIGHT_ALIGN, TableConstant.RED);
        rowData.add(subTotalRoundedUnitTax.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED);

        rowData.add(subTotalActualPrice.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED);
        rowData.add(subTotalRoundedPrice.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED);

        rowData.add(subTotalActualTax.toString()+" ("+round(subTotalActualTax, scale, roundingMode)+")", TableConstant.RIGHT_ALIGN, TableConstant.RED);
        rowData.add(subTotalRoundedTax.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED);
        rowData.add(subTotalActualAmount.toString()+" ("+round(subTotalActualAmount, scale, roundingMode)+")", TableConstant.RIGHT_ALIGN, TableConstant.RED);
        rowData.add(subTotalRoundedAmount.toString(), TableConstant.RIGHT_ALIGN, TableConstant.RED);

        table.addRow(rowData);
        table.toTablePrint()

    }
}
