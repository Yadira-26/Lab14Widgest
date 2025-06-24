package com.example.lab_14

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.*
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.*
import androidx.glance.text.Text
import androidx.glance.action.actionStartActivity

class AccesosRapidosWidget : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = AccesosRapidosContent()
}

class AccesosRapidosContent : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                AccesosWidgetUI()
            }
        }
    }
}

@Composable
fun AccesosWidgetUI() {
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .padding(16.dp)
            .background(GlanceTheme.colors.background),
        verticalAlignment = Alignment.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "📌 Mis accesos rápidos", modifier = GlanceModifier.padding(bottom = 12.dp))
        Row(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                text = "Ver Historial",
                onClick = actionStartActivity<HistorialActivity>()
            )
            Spacer(modifier = GlanceModifier.width(8.dp))
            Button(
                text = "Nueva Tarea",
                onClick = actionStartActivity<NuevaTareaActivity>()
            )
        }
    }
}
