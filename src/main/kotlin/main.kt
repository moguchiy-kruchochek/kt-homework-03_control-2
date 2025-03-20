package ru.netology

fun main() {
    comissionPayment("Mastercard", 400_000, amountTransition = 100_000)
}

fun comissionPayment(card: String = "Мир", pastTransitionsThisMonth: Int = 0, amountTransition: Int) {

    val generalLimitPerDay = 150_000
    val generalLimitPerMonth = 600_000
    val mastercardLimit = 75_000
    val mastercardComissionRatio = 0.6
    val minVisaComission = 35
    val visaComissionRatio = 0.75
    var comission = 0

    if (amountTransition > generalLimitPerDay) {
        println("Достигнут дневной лимит переводов, операция блокирована")
    } else if ((pastTransitionsThisMonth + amountTransition) > generalLimitPerMonth) {
        println("Достигнут месячный лимит переводов, операция блокирована")
    } else {
        if (card == "Mastercard") {
            if (amountTransition > mastercardLimit) {
                comission = ((((amountTransition - mastercardLimit) * mastercardComissionRatio) / 100) + 20).toInt()
            }
        } else if (card == "Visa") {
            comission = (((amountTransition * visaComissionRatio) / 100)).toInt()
            if (comission < minVisaComission) comission = minVisaComission
        } else {
            comission = 0
        }
        println("Комиссия составит $comission руб.")
    }
}




