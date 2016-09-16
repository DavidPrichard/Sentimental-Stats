# Sentimental Stats
This was originally a term project for ITCS 5102 "Survey of Programming Languages" at UNCC, completed mostly to learn Scala. The original project was very limited, collecting stats from [sportsdatabase.com](sportsdatabase.com), collecting Tweets referencing the a particular team, estimating the average sentiment over time, and plotting those stats.

For now, I'll focus on improving the sentimental data by using more reliable sources of data than Twitter and sportsdatabase.com, and building up a broader slice of metrics like margin-of-victory that are more useful for predicting performance. I hope to graph the results with something better than JFreeChart/ScalaChart as well.

## How to Run

1. [Download](https://github.com/4102/Sentimental-Stats/archive/master.zip) the project or clone the repo with `git clone https://github.com/4102/Sentimental-Stats.git`

2. Download and install [sbt](http://www.scala-sbt.org/download.html)

4. To compile and run, navigate to the repo's root directory from the shell of your choice and enter `sbt run`
...* To run with command-line arguments, wrap them in quotes like so: `sbt "run arg1 arg2`

## How to View/Edit

1. Download and install [IntelliJ](https://www.jetbrains.com/idea/#chooseYourEdition).
2. Select `File > Open...` and navigate to the project if it doesn't detect it on start.
3. Install the Scala plugin when prompted, or [do it manually](https://www.jetbrains.com/help/idea/2016.1/enabling-and-disabling-plugins.html).
4. Add the `lib/` directory to your dependencies/classpath:
  * Go to `File > Project Structure > Modules` and select the `Dependencies` tab
  * Select the `+` symbol, choose `jars or directories`, and finally navigate to `lib/`. Phew.
    * You have to follow the same process to add the individual jars in the root of `lib`, as IntelliJ can't identify them on its own. This is frustrating but necessary.
5. The project doesn't reliably compile or run in IntelliJ, so I strongly recommend using sbt for that instead.


## Dependencies
Sentimental Stats uses:
  * [Standford's NLP library](http://nlp.stanford.edu/software/)
  * [jsoup](https://jsoup.org/)
