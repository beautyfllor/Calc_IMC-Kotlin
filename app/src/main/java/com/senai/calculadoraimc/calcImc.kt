package com.senai.calculadoraimc

fun situacao(imc: Double): String {
    if (imc <= 18.5)
        return "Você está abaixo do peso. Cuidado!"
    else if (imc > 18.5 && imc < 24.9)
        return "Você está no peso ideal. Parabéns!"
    else if (imc > 25 && imc < 29.9)
        return "Você está levemente acima do peso."
    else if (imc > 30 && imc < 34.9)
        return "Você está com obesidade grau I."
    else if (imc > 35 && imc < 39.9)
        return "Você está com obesidade grau II."
    else
        return "Você está com obesidade grau III."
}

fun calcularImc(peso: Double, altura: Double): Double {
    var imc = peso / (altura * altura)
    return imc
}