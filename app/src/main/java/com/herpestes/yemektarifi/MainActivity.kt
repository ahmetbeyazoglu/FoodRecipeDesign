package com.herpestes.yemektarifi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.herpestes.yemektarifi.ui.theme.YemekTarifiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YemekTarifiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    sayfa()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun sayfa() {
    
    Scaffold(
        topBar = {
                 TopAppBar(
                    title = { Yazi(icerik = "Yemek tarifi")},
                    backgroundColor = colorResource(id = R.color.anarenk)
                 )
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(painter = painterResource(id = R.drawable.yemekresim), contentDescription ="")
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = { Log.e("Button", "Beğenildi") },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.anarenk)
                            ),
                        modifier = Modifier.weight(50f)
                        ) {
                        Yazi(icerik = "Beğen")
                    }
                    Button(onClick = { Log.e("Button", "Yorum yapıldı") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.alternatifrenk)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Yazi(icerik = "Yorum yap")
                    }
                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)) {
                    Text(
                        text = "köfte",
                        color = colorResource(id = R.color.alternatifrenk),
                        fontSize = 18.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Yazi(icerik = "Izgaraya Uygun")
                        Yazi(icerik = "7 Haziran")
                    }
                }
                Text(
                    text = "Köfte harcını hazırlamak için, soğanları rendeleyin ve maydanozları ince ince kıyın, İsterseniz, bir diş sarımsak da ekleyebilirsiniz.",
                    modifier = Modifier.padding(all = 10.dp),
                    textAlign = TextAlign.Center
                )

            }
        }
    )
}



@Composable
fun Yazi(icerik:String){
    Text(text = icerik)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YemekTarifiTheme {
        sayfa()
    }
}