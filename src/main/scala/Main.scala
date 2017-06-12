/**
  * Created by Administrator on 12/06/2017.
  */
object Main extends App
{
  val g = new Garage(true)

  val a = new Car("a", "b", "c", "d", false, 5, true)
  val b = new Car("e", "f", "g", "h", true, 10, false)

  g.addVehicle(a)
  g.addVehicle(b)

  println("Number of cars in the garage: " +  g.vBuff.size)

  val e1 = new Employee("John", "Jackson", "1/1/2000", "EM-0000", false)
  val e2 = new Employee("Jack", "Johnson", "31/12/1999", "EM-0001", false)
  val e3 = new Employee("Max", "LeManager", "20/4/1984", "EM-0003", true)

  g.addEmployee(e1)
  g.addEmployee(e2)
  g.addEmployee(e3)

  println("Number of employees in the company: " + g.eBuff.size)

  g.removeVehicleByID("a")
  println("Number of cars in garage: " +  g.vBuff.size)
  g.removeVehicleByType("Car")
  println("Number of cars in garage: " +  g.vBuff.size)

  g.gOpen()
  println(g.getOpen())
  g.gClose()
  println(g.getOpen())
  g.gOpen()
  println(g.getOpen())
}
