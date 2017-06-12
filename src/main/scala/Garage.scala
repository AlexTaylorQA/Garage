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
}
