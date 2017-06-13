/**
  * Created by Administrator on 12/06/2017.
  */
class Bike(reg:String, brand:String, make:String, colour:String, isFixed:Boolean, var numSeats:Int)
  extends Vehicle(reg, brand, make, colour, isFixed) {

  override def toString: String = "%s %s %s %s %s %s"
    .format(
      reg,
      brand,
      make,
      colour,
      this.checkFix(),
      numSeats.toString()
    )
}
