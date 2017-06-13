/**
  * Created by Administrator on 12/06/2017.
  */
class Employee(var firstName:String, var lastName:String, var DOB:String, var employeeID:String, var isManager:Boolean)
  extends Person(firstName, lastName, DOB)
{
  var theManager: String = (
    if(isManager == true) {
      "Manager"
    }
    else
    {
      "Subordinate"
    }
    )

  override def toString: String = "%s %s %s %s %s"
    .format(
      firstName,
      lastName,
      DOB,
      employeeID,
      isManager
    )
}
