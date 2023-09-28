import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.rest.ui.HttpClient
import kotlinx.coroutines.runBlocking

@Composable
@Preview
fun App() {
    var response by remember { mutableStateOf("") }
    MaterialTheme {
        Scaffold (
            drawerContent = {
                Column {
                    Text("Lanca")
                }
            },
            topBar = {
                TopAppBar(
                    contentColor = contentColorFor(Color.LightGray),
                    title = {
                        Text("Small Top App Bar")
                    }
                )
            },
            content = {
                Column {
                    Row {
                        Button(onClick = {
                            response =  runBlocking {
                                HttpClient().get()
                            }
                        }){
                            Text("https://gita-api.vercel.app/odi/verse/1/1")
                        }
                        Text(response)
                    }
                    Row {
                        Button(onClick = {
                            response =  runBlocking {
                                HttpClient().get()
                            }
                        }){
                            Text("https://gita-api.vercel.app/odi/verse/2/1")
                        }
                        Text(response)
                    }
                }
            }
        )
    }

}



fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
