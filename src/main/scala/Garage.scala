/**
  * Created by Administrator on 12/06/2017.
  */
class Garage(var isOpen:Boolean)
{
  var vBuff = scala.collection.mutable.ArrayBuffer.empty[Vehicle]
  var eBuff = scala.collection.mutable.ArrayBuffer.empty[Employee]

  def addVehicle(vIn:Vehicle) =
  {
    for(x <- 0 to vIn.pBuff.size - 1)
    {
      val r = scala.util.Random
      r.nextInt(2) match
      {
        case 0 => vIn.pBuff(x).isBroken = false
        case 1 => vIn.pBuff(x).isBroken = true
      }

    }

    // Cost to fix
    vBuff += vIn
    vBuff(vBuff.size - 1).costFix = calcBill(vBuff(vBuff.size - 1).reg)

    // Time taken
    vBuff(vBuff.size - 1).timeTaken = {
      var totalTime:Double = 0.0
      for(y <- 0 to vBuff(vBuff.size - 1).pBuff.size - 1)
        {
          vBuff(vBuff.size - 1).pBuff(y).isBroken == true match
          {
            case true => totalTime += vBuff(vBuff.size - 1).pBuff(y).timeTaken
            case false =>
          }

        }
      totalTime
    }

    // Queue Check
    {
      vBuff(vBuff.size - 1).queueCheck = {
        vBuff(vBuff.size - 1).timeTaken * numBrokenParts(vBuff(vBuff.size - 1).reg)
      }
    }

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

  def vFix(vIn:Vehicle) =
  {
    var theBill:Double = 0.0
    for(x <- 0 to this.vBuff.size - 1)
      {
        vIn.reg.equals(vBuff(x).getReg()) match
        {
          case true =>
            vBuff(x).setFixed()
            theBill = calcBill(vIn.reg)

          case false =>
        }
      }
    println("Total cost of repair for vehicle " + vIn.reg + ": £" + (f"${theBill}%.2f"))

  }

  def calcBill(vID:String): Double =
  {
    var theCost:Double = 0.0
    for(x <- 0 to this.vBuff.size - 1)
      {
        vID.equals(vBuff(x).getReg()) match
        {
          case true =>

              vBuff(x).pBuff.size > 0 match
              {
                case true =>
                  for (y <- 0 to vBuff(x).pBuff.size - 1) {
                    theCost += vBuff(x).pBuff(y).pCost
                  }

                case false => theCost += 0.0
                case _ =>
              }

            vBuff(x).getClass.toString.substring(6) match
            {
             case "Car" => theCost += 100.0
             case "Bike" => theCost += 65.0
             case _ =>
            }
            case false =>
        }

      }
    theCost
  }

  def numBrokenParts(vID:String): Int = {

    var totalParts:Int = 0
    for(x <- 0 to this.vBuff.size - 1) {
      vID.equals(vBuff(x).getReg()) match {
        case true =>

          vBuff(x).pBuff.size > 0 match {
            case true =>
              for (y <- 0 to vBuff(x).pBuff.size - 1) {

                vBuff(x).pBuff(y).isBroken == true match
                {
                  case true =>
                    totalParts += 1
                  case false =>
                }
              }

            case false =>
            case _ =>
          }
        case false =>
      }
    }
    totalParts
  }

  def gOpen() =
  {
    isOpen = true
    isOpen


    vBuff = vBuff.sortWith(_.queueCheck > _.queueCheck)

    // (numBrokenParts( a.reg ))


  }

  def gClose() =
  {
    isOpen = false
    isOpen
  }

  def timeTakenAll(): Double =
  {
    var totalTime:Double = 0.0
    for(x <- 0 to vBuff.length - 1)
      {
        totalTime +=vBuff(x).timeTaken
      }
    totalTime
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

            case _ =>
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
                  + "Transmission: " + isAuto + "\n"
                  )
            case "Bike" =>

              str +=
                (
                  "Number of Seats: " + vBuff(x).asInstanceOf[Bike].numSeats + "\n"
                  )

            case _ =>

          }
          str += "Parts:\n"
          vBuff(x).pBuff.size match
          {
            case 0 => str += "- None"
            case _ =>

          for(y <- 0 to vBuff(x).pBuff.size - 1)
            {
              str+= "- " + vBuff(x).pBuff(y).pName + " | Cost: £" +
                (f"${vBuff(x).pBuff(y).pCost}%.2f") +
                {
                  vBuff(x).pBuff(y).isBroken match
                  {
                    case true => " | Status: Broken\n"
                    case false => " |  Status: Working\n"
                  }
                }
            }
          }
          str += "\n"
        }
        str += "\n"
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
