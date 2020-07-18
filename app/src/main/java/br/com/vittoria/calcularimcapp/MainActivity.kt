package br.com.vittoria.calcularimcapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Pegar os dados digitados nos campos e calcular o IMC

        //Ao clicar no botao: calcular o IMC
        btnCalcularIMC.setOnClickListener {

            val peso = edtPeso.text.toString().trim()
            val altura = edtAltura.text.toString().trim()

            //Verificacoes
            if (peso.isEmpty() || altura.isEmpty()){
                //alerta
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Atenção")
                    .setMessage("Preencha todos os campos!")
                    .setPositiveButton("OK"){_, _ ->
                        //FUNCAO LAMBDA
                    }
                    .setCancelable(false)
                    .create()
                    .show()
            } else if (altura.equals("0") && peso.equals("0")){
                edtAltura.error = "Campo não pode ser 0"
                edtPeso.error = "Campo não pode ser 0"
            } else {
                Toast.makeText(this@MainActivity, "Calculando...", Toast.LENGTH_LONG)
                    .show()

                //passar o peso e altura para outra tela calcular o IMC
                startActivity(Intent(this@MainActivity, ResultadoActivity::class.java).apply {
                    putExtra("peso", peso)
                    putExtra("altura", altura)
                })
                finish()
            }
        }

    }
}