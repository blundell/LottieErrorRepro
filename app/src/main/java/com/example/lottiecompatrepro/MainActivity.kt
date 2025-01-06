package com.example.lottiecompatrepro

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.model.KeyPath
import com.example.lottiecompatrepro.ui.theme.LottieCompatReproTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LottieCompatReproTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                    // you need the appcompat dependency for this to work
                    // Cannot access 'androidx. appcompat. widget. AppCompatImageView' which is a supertype of 'com. airbnb. lottie. LottieAnimationView'.
                    // Check your module classpath for missing or conflicting dependencies
                    AndroidView(
                        factory = { c ->
                            LottieAnimationView(c).apply {
                                setAnimationFromUrl("https://drive.google.com/uc?id=1ebWqd_e2ci4kSKB83e37q2Bl0YMadwxv")
                                addLottieOnCompositionLoadedListener {
                                    Log.d("TUT", "Keypaths: ${resolveKeyPath(KeyPath("**"))}")
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LottieCompatReproTheme {
        Greeting("Android")
    }
}