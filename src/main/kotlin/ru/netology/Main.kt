package ru.netology

fun main() {

    calcPay(currentTransferMoney = 25000);
    calcPay("Maestro", currentTransferMoney = 50000);
    calcPay("Mastercard", 65000, 25000);
    calcPay("Visa", currentTransferMoney = 30000);
    calcPay("Mir", currentTransferMoney = 4000);


}

fun calcPay(moneyAccount: String = "VK pay", transferCurrMonth: Int = 0, currentTransferMoney: Int) {

    val limitMaestroSum = 75000
    val limitMaestroPercent = 0.006
    val limitMaestroIncrease = 20

    val limitVisaMirPercent = 0.0075
    val minComissionVisaMir = 35

    when (moneyAccount) {
        "VK pay" -> println("Перевод на счёт: " + moneyAccount + " - осуществлён бесплатно.")
        "Maestro", "Mastercard" -> if (transferCurrMonth + currentTransferMoney > limitMaestroSum)
            println("Перевод на счёт: " + moneyAccount + " - осуществлён с комиссией: " + (currentTransferMoney * limitMaestroPercent + limitMaestroIncrease) + " рублей.")
        else
            println("Перевод на счёт: " + moneyAccount + " - осуществлён бесплатно.")

        "Visa", "Mir" -> if (currentTransferMoney * limitVisaMirPercent < minComissionVisaMir)
            println("Перевод на счёт: " + moneyAccount + " - осуществлён с комиссией: " + minComissionVisaMir + " рублей.")
        else
            println("Перевод на счёт: " + moneyAccount + " - осуществлён с комиссией: " + currentTransferMoney * limitVisaMirPercent + " рублей.")

    }

}