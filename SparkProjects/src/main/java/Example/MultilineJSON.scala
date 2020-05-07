package Example
import org.apache.spark._
import com.crealytics.spark.excel._
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
     .config("spark.sql.warehouse.dir", "file:///c:/tmp/spark-warehouse")
     .getOrCreate()
  
  val mdf = spark.read.option("multiLine",true).option("mode", "PERMISSIVE").json("C:\\Users\\pradeep\\Desktop\\spark\\Input\\Nested.json")
  //val x=spark.read.csv("C:\\Users\\pradeep\\Desktop\\spark\\Wordcount\\Titanic_header.txt")
  //mdf.printSchema()
mdf.show(100,false)
}
}