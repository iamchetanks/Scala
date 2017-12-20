import scala.io.Source

object DynammicOrderRevenue {
	def main(args: Array[String]) = {
		val orderId = args(1).toInt
		val orderItems = Source.fromFile("E:/Google_drive_personal/chetan/winter_break_2017/spark_and_hadoop_udemy/data/retail_db/order_items/part-00000").getLines
		val orderRevenue = orderItems.filter(oi => oi.split(",")(1).toInt == orderId).map(oi => oi.split(",")(4).toFloat).reduce((t,v) => t+ v)
		println(orderRevenue)
	}
}