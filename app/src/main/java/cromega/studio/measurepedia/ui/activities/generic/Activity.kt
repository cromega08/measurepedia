package cromega.studio.measurepedia.ui.activities.generic

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cromega.studio.measurepedia.data.local.files.UserInfo
import cromega.studio.measurepedia.data.managers.general.TablesManager
import cromega.studio.measurepedia.enums.Languages
import cromega.studio.measurepedia.extensions.putExtra
import cromega.studio.measurepedia.ui.theme.MeasurepediaTheme
import java.util.Locale
import kotlin.reflect.KClass

abstract class Activity<VM: ActivityViewModel, SC: ActivityScreen<VM>>: ComponentActivity()
{
    protected val tablesManager: TablesManager = TablesManager()
    protected lateinit var userInfo: UserInfo
    protected abstract val viewModel: VM
    protected abstract val screen: SC

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        tablesManager.instantiate(context = applicationContext)
        userInfo = UserInfo(context = applicationContext)

        setLocale(language = userInfo.language)

        instantiateVariables()

        setContent {
            MeasurepediaTheme(
                darkTheme = userInfo.darkTheme
            ) {
                screen.Screen()
            }
        }
    }

    fun setLocale(language: Languages)
    {
        val locale: Locale = Locale(language.localeAcronym)

        Locale.setDefault(locale)

        val configuration: Configuration = resources.configuration

        configuration.setLocale(locale)

        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    fun <VM: ActivityViewModel, SC: ActivityScreen<VM>, AC : Activity<VM, SC>> changeActivity(
        activityToLoad: KClass<AC>,
        data: Map<String, Any> = mapOf()
    ) {
        val intent = Intent(this, activityToLoad.java)

        data.forEach { (key, value) -> intent.putExtra(key,  value) }

        startActivity(intent)
    }

    abstract fun instantiateVariables()

    override fun onDestroy()
    {
        super.onDestroy()
        tablesManager.close()
    }
}