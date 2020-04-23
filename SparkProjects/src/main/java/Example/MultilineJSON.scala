package Example
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.log4j.{Level, Logger}
object MultilineJSON {
  def main(args:Array[String])=
  {
Logger.getLogger("org").setLevel(Level.OFF)
Logger.getLogger("akka").setLevel(Level.OFF)

   val spark=SparkSession.builder
     .master("local")
     .appName("Word Count")
     .config("spark.some.config.option", "some-value")
     .getOrCreate()
  
  val mdf = spark.read.option("multiline","true").json("C:\\Users\\pradeep\\Desktop\\spark\\Input\\Nested.JSON")
mdf.show(10)
}
}