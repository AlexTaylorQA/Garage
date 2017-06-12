/**
  * Created by Administrator on 12/06/2017.
  */
abstract class Vehicle(reg:String, brand:String, make:String, colour:String, isFixed:Boolean)
{

  def checkFix():String = {
    var theFix: String = (
      if (isFixed == true) {
        "Fixed"
      }
      else {
        "Not yet fixed"
      }
      )
    theFix
  }

  def getReg() =
  {
    this.reg
  }

  override def toString: String = "%s %s %s %s %s"
    .format(
        reg,
        brand,
        make,
        colour,
        checkFix()
  )
}

