package cromega.studio.measurepedia.data.models.instances

import cromega.studio.measurepedia.data.models.generic.Model
import cromega.studio.measurepedia.extensions.isNotNullOrBlank
import cromega.studio.measurepedia.extensions.titlecase
import cromega.studio.measurepedia.extensions.toStringWithFormat
import java.util.Date
import java.util.Locale

class Person(
    id: Int,
    private val name: String,
    private val alias: String?,
    private val updated: Date,
    val measured: Boolean
): Model(id = id)
{
    private val locale: Locale = Locale.US

    fun getName(): String = name.titlecase()

    fun hasAlias(): Boolean = alias.isNotNullOrBlank()

    fun getAlias(): String = alias ?: ""

    fun getSearchablePersonIdentifier(): String =
        String
            .format(locale = locale, "%s %s", getName(), getAlias())
            .lowercase(locale = locale)

    infix fun getUpdatedAsString(format: String): String = updated toStringWithFormat format

    fun isMeasured(): Boolean = measured

    fun getMeasuredTexts(measuredText: String, notMeasuredText: String) =
        if (measured) measuredText else notMeasuredText

    override fun clone(): Person {
        return Person(
            id = id,
            name = name,
            alias = alias,
            updated = updated,
            measured = measured
        )
    }
}
