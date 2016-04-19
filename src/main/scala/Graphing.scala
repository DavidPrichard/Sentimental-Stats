package term.project.SentimentalStats

import scalax.chart.api._

/**
  * Creates graphs from structured data.
  *
  * Author: David Prichard
  * Last Modified: 4-19-2016
  */
trait Graphing extends Time {

  private val dir = "charts/"

  //implicit private val theme = org.jfree.chart.StandardChartTheme.createDarknessTheme

  private[this] def fileName(team: Team) = {
    team.name + team.seasonYear + "@" + currentDateTime
  }

  def graph(team: Team, options: Map[String, String]): Unit = {

    val title = team.name + "," + team.seasonInterval
    val data = for (i <- 1 to 5) yield (i,i) // test
    val path = dir + fileName(team) + ".jpg"

    val chart = XYLineChart(data, title)

    chart.saveAsPNG(path)
    //chart.show()
  }

  def graphAll(list: List[Team], options: Map[String, String]) = {
    list.foreach(graph(_, options))
  }
}