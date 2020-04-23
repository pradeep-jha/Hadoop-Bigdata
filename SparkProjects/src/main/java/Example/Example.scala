package Example
import scala.util.Random
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SQLImplicits
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.log4j.{Level, Logger}
object Example {
  def main(args:Array[String])={
  
    println("HelloWOrld-123")
    
    
//def nextString = (1 to 10) map (_ => Random.nextPrintableChar()) mkString

   /* val numKeys = 10000090
     val keys = Random.shuffle(0 to numKeys-1)
     println(keys)
     fffffdf
    val str=keys.map(x => "Hello0 " + x)
      println(str)*/
Logger.getLogger("org").setLevel(Level.OFF)
Logger.getLogger("akka").setLevel(Level.OFF)

val key = ("Hi"+Random.nextInt())

//####Word count program:
val config = new SparkConf().setAppName("wordcount-App").setMaster("local").set("spark.executor.memory","1g")
  val sc = new SparkContext(config)
val inputrdd=sc.textFile("C:\\Users\\pradeep\\Desktop\\spark\\Wordcount\\Titanic_header.txt",2)
//val inputrdd=sc.textFile("C:/Users/nifiadmin/Desktop/VIS QA files/FP74HD-500090_20171211184414_AB.txt",2)
val word=inputrdd.flatMap(_.split("\t")).map(word=>(word,1)).reduceByKey{ (a,b) => a+b}
println("#####This is the count of each word in the file###")
word.collect().foreach(print)

println(key)
  }
}