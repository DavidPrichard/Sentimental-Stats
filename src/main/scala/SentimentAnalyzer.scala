package term.project.SentimentalStats

import java.util.Properties
import Sentiment.Sentiment

import edu.stanford.nlp.ling.CoreAnnotations
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations
import edu.stanford.nlp.pipeline.{Annotation, StanfordCoreNLP}
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations

import scala.collection.convert.wrapAll._

/**
  * Analyzes textual data, returning a number 0-4 representing expressed sentiment.
  *
  * Author: Yagnesh
  * Last Modified: 4/13/2016.
  */
  object SentimentAnalyzer {

  val props = new Properties
  props.setProperty("annotators", "tokenize, ssplit, parse, sentiment")
  val pipeline: StanfordCoreNLP = new StanfordCoreNLP(props)

  def mainSentiment(input: String): Sentiment = Option(input) match {
    case Some(text) if text.nonEmpty => extractSentiment(text)
    case None => throw new IllegalArgumentException("input can't be null or empty")
  }

  def sentiment(input: String): List[(String, Sentiment)] = Option(input) match {
    case Some(text) if text.nonEmpty => extractSentiments(text)
    case None => throw new IllegalArgumentException("input can't be null or empty")
  }

  private def extractSentiment(text: String): Sentiment = {
    val (_, sentiment) = extractSentiments(text)
      .maxBy { case (sentence, _) => sentence.length }
    sentiment
  }

  def extractSentiments(text: String): List[(String, Sentiment)] = {
    val annotation: Annotation = pipeline.process(text)
    val sentences = annotation.get(classOf[CoreAnnotations.SentencesAnnotation])
    sentences
      .map(sentence => (sentence, sentence.get(classOf[SentimentCoreAnnotations.SentimentAnnotatedTree])))
      .map { case (sentence, tree) => (sentence.toString, Sentiment.toSentiment(RNNCoreAnnotations.getPredictedClass(tree))) }
      .toList
  }
}
