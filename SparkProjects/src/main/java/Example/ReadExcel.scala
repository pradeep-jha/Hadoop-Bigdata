package Example
import org.apache.spark.SparkConf
import org.apache.spark._
import com.crealytics.spark.excel
import org.apache.spark.sql._
import org.apache.log4j.{Level, Logger}

  
object ReadExcel {
    def main(args:Array[String])=
  {
Logger.getLogger("org").setLevel(Level.OFF)
Logger.getLogger("akka").setLevel(Level.OFF)

   val spark=SparkSession.builder
     .master("local")
     .appName("ReadExcel")
     .config("spark.executer.memory", "1g")
     .config("spark.driver.memory", "1g")
     .config("spark.sql.warehouse.dir", "file:///c:/tmp/spark-warehouse")
     .getOrCreate()
 print(spark.conf.getAll)
 val in_df=spark.read.format("com.crealytics.spark.excel") 
                .option("location", "C:\\Users\\pradeep\\Desktop\\pycharm_spark\\input\\911.xlsx") 
                .option("useHeader", "true") 
                .option("treatEmptyValuesAsNulls", "false") 
                .option("inferSchema", "false") 
                .option("addColorColumns", "false") 
                .option("dataAddress", "Sheet3!") 
                .load("C:\\Users\\pradeep\\Desktop\\pycharm_spark\\input\\911.xlsx")
 
 in_df.printSchema()
 in_df.show(100,false)

}
}