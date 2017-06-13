/**
  * Created by Administrator on 12/06/2017.
  */
class Garage(var isOpen:Boolean)
{
  var vBuff = scala.collection.mutable.ArrayBuffer.empty[Vehicle]
  var eBuff = scala.collection.mutable.ArrayBuffer.empty[Employee]

  var eList:Array[Employee] = Array.empty

  def addVehicle(vIn:Vehicle) =
  {
    vBuff += vIn
  }

  def addEmployee(eIn:Employee) =
  {
    eBuff += eIn
  }

  def removeVehicleByID(vID:String) =
  {
    var x:Int = 0
    var y:Int = vBuff.size - 1

    def theRemove(vID:String, theX:Int, theY:Int) {

      var x = theX
      var y = theY

      x <= y match {
        case true => vBuff(x).getReg() == vID match {
          case true =>
            vBuff.remove(x)
            y -= 1
            theRemove(vID, x, y)
          case false =>
            x += 1
            theRemove(vID, x, y)
        }
        case false =>

      }
    }
    theRemove(vID, x, y)
  }

  def removeVehicleByType(vType:String) =
  {
    var x:Int = 0
    var y:Int = vBuff.size - 1

    def theRemove(vType:String, theX:Int, theY:Int) {

      var x = theX
      var y = theY

      x <= y match {
        case true => vBuff(x).getClass.toString.substring(6) == vType match {
          case true =>
            vBuff.remove(x)
            y -= 1
            theRemove(vType, x, y)
          case false =>
            x += 1
            theRemove(vType, x, y)
        }
        case false =>

      }
    }
    theRemove(vType, x, y)
  }

  def vFix(vID:String) =
  {
    for(x <- 0 to this.vBuff.size - 1)
      {
        vID.equals(vBuff(x).getReg()) match
        {
          case true => vBuff(x).setFixed()
          case false =>
        }
      }

  }

  def calcBill(vID:String): Double =
  {
    var theCost:Double = 0.0
    for(x <- 0 to this.vBuff.size - 1)
      {
        vID.equals(vBuff(x).getReg()) match
        {
          case true => vBuff(x).getClass.toString.substring(6) match
          {
            case "Car" => theCost += 100.0
            case "Bike" => theCost += 65.0
          }
          case false =>
        }
      }
    theCost
  }

  def gOpen() =
  {
    isOpen = true
    getOpen()
  }

  def gClose() =
  {
    isOpen = false
    getOpen()
  }

  def getOpen(): Boolean =
  {
    isOpen
  }

  override def toString: String =
  {
    var str : String = ""

    str += "\n--- Vehicles ---\n\n"

    vBuff.size match {
      case 0 =>
      case _ =>

        var carCount = 0
        var bikeCount = 0

        for (x <- 0 to vBuff.size - 1) {
          var theType = ""
          vBuff(x).getClass.toString.substring(6) match
          {
            case "Car" =>
              carCount += 1
              str += ("Car " + carCount + ":\n")

            case "Bike" =>
              bikeCount += 1
              str += ("Bike " + bikeCount + ":\n")
          }

          var theFix = ""
          vBuff(x).isFixed match {
            case true => theFix = "Fixed"
            case false => theFix = "Queued for fix"
          }

          str +=
            (   "Reg. No.: " + vBuff(x).reg + "\n"
              + "Brand: " + vBuff(x).brand + "\n"
              + "Make: " + vBuff(x).make + "\n"
              + "Colour: " + vBuff(x).colour + "\n"
              + "Status: " + theFix + "\n"
              )

          vBuff(x).getClass.toString.substring(6) match
          {
            case "Car" =>
              var isAuto = ""
              vBuff(x).asInstanceOf[Car].automatic match {
                case true => isAuto = "Automatic"
                case false => isAuto = "Manual"
              }
              str +=
                  (
                    "Number of Doors: " + vBuff(x).asInstanceOf[Car].numDoors + "\n"
                  + "Transmission: " + isAuto + "\n\n"
                  )
            case "Bike" =>

              str +=
                (
                  "Number of Seats: " + vBuff(x).asInstanceOf[Bike].numSeats + "\n\n"
                  )

          }
        }
    }

    str += "--- Employees ---\n\n"

    eBuff.size match {
      case 0 =>
      case _ =>

        for (y <- 0 to eBuff.size - 1) {
          var theManager = ""
          eBuff(y).isManager match {
            case true => theManager = "Manager"
            case false => theManager = "Subordinate"
          }

          str +=
            (
                "Employee " + (y + 1) + ":\n"
                  + "Name: " + eBuff(y).firstName + " " + eBuff(y).lastName + "\n"
                  + "D.O.B.: " + eBuff(y).DOB + "\n"
                  + "Employee ID: " + eBuff(y).employeeID + "\n"
                  + "Employee Level: " + theManager + "\n\n"

            )
        }
    }

    var theOpen = ""
    isOpen match
    {
      case true => theOpen = "--- The garage is open. ---\n\n"
      case false =>"--- The garage is closed. ---\n\n"
    }
    str += theOpen

    str
  }

}
