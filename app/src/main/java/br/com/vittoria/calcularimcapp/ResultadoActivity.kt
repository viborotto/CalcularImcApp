package br.com.vittoria.calcularimcapp

import android.content.Intent
import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //pegar dados da tela Main e realizar o calculo
        //Recuperar o peso e altura da Intent
        val pesoRecuperado = intent.getStringExtra("peso")
        val alturaRecuperada = intent.getStringExtra("altura")

        var imc = pesoRecuperado.toDouble()/(alturaRecuperada.toDouble()*alturaRecuperada.toDouble())
        var imcResp = "%.2f".format(imc) + "\n" + checkIMC(imc)

        txvResultadoImc.text = imcResp
        //Voltar para a tela Main
        btnRecalcular.setOnClickListener {
            startActivity(Intent(this@ResultadoActivity, MainActivity::class.java))
            finish()
        }
    }

    private fun checkIMC(bd: Double): String{
        when(bd){
            in 0..17 -> return "Muito abaixo do peso."
            in 17.0..18.49 -> return "Abaixo do peso."
            in 18.5..24.99 -> return "Peso normal."
            in 25.0..29.99 ->  return "Acima do peso."
            in 30.0..34.99 -> return "Obesidade I."
            in 35.0..39.99 -> return "Obesidade II(severa)."
            else -> return "Obesidade III(mórbida)."
        }
    }
}