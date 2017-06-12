/**
  * Created by Administrator on 12/06/2017.
  */
class Car(reg:String, brand:String, make:String, colour:String, isFixed:Boolean, numDoors:Int, automatic:Boolean)
  extends Vehicle(reg, brand, make, colour, isFixed)
{
  var theAuto: String = (
    if(automatic == true) {
      "Automatic"
    }
    else
    {
      "Manual"
    }
    )

  // def

  override def toString: String = "%s %s %s %s %s %s %s"
    .format(
      reg,
      brand,
      make,
      colour,
      this.checkFix(),
      numDoors.toString(),
      this.theAuto
    )
}
