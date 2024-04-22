import android.annotation.SuppressLint
import android.os.Bundle


import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynotesapp2.R
import com.example.mynotesapp2.databinding.FragmentDashboardBinding


class Dashboard : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                DashboardContent()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun DashboardContent() {
    Scaffold(
    ) {
        ContenDash()
    }

}

@Composable
fun ContenDash() {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.rosa))
            .fillMaxSize()
    ) { Row {
        Text(
            text = "MyNotes",
            modifier = Modifier
                .padding(start = 106.dp, top = 27.dp)
                .size(width = 245.dp, height = 83.dp),
            style = TextStyle(
                fontFamily = FontFamily.Companion.SansSerif,
                fontWeight = FontWeight(1000),
                fontSize = 50.sp,
                color = Color(0xFFf4f8fb)
            ),
            lineHeight = 60.sp
        )
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = "Icon",
            modifier = Modifier.size(width = 100.dp, height = 100.2.dp),
            tint = Color(0xFFf4f8fb)
        )
    }



    }

}


//             .background(color = colorResource(id = R.color.rosa)) definir coloor
