/**
  * Created by Administrator on 12/06/2017.
  */
object Main extends App
{
  val g = new Garage(true)

  val a = new Car("SW08TNO", "Vauxhall", "Agila", "Blue", false, 0.0, 0.0, 0.0, 5, true)
  val b = new Car("AB238ZL", "Lamborghini", "Murcielago", "Orange", true, 0.0, 0.0, 0.0, 2, false)
  val c = new Bike("BK01SJV", "Harley-Davidson", "Sportster", "Red", false, 0.0, 0.0, 0.0, 1)

  val ap1 = new Part("Tyres", 100.0, false, 1.5)
  val ap2 = new Part("Fan Belt", 50.0, false, 2.1)
  val ap3 = new Part("Carburettor", 100.0, false, 3.5)
  val ap4 = new Part("Battery", 50.0, false, 2.3)
  val ap5 = new Part("Windscreen Wipers", 100.0, false, 0.5)
  val ap6 = new Part("Headlights", 50.0, false, 3.2)
  val ap7 = new Part("Brakes", 100.0, false, 6.7)
  val ap8 = new Part("Exhaust", 50.0, false, 4.3)
  val ap9 = new Part("Air Intake", 100.0, false, 6.9)
  val ap10 = new Part("Starter Motor", 50.0, false, 8.4)

  a.addPart(ap1)
  a.addPart(ap2)
  a.addPart(ap3)
  a.addPart(ap4)
  a.addPart(ap5)
  a.addPart(ap6)
  a.addPart(ap7)
  a.addPart(ap8)
  a.addPart(ap9)
  a.addPart(ap10)

  val bp1 = new Part("Tyres", 100.0, false, 1.5)
  val bp2 = new Part("Fan Belt", 54.22, false, 2.1)
  val bp3 = new Part("Carburettor", 105.25, false, 3.5)
  val bp4 = new Part("Battery", 77.0, false, 2.3)
  val bp5 = new Part("Windscreen Wipers", 35.0, false, 0.5)
  val bp6 = new Part("Headlights", 83.4, false, 3.2)
  val bp7 = new Part("Brakes", 62.5, false, 6.7)
  val bp8 = new Part("Exhaust", 45.0, false, 4.3)
  val bp9 = new Part("Air Intake", 60.0, false, 6.9)
  val bp10 = new Part("Starter Motor", 150.0, false, 8.4)

  b.addPart(bp1)
  b.addPart(bp2)
  b.addPart(bp3)
  b.addPart(bp4)
  b.addPart(bp5)
  b.addPart(bp6)
  b.addPart(bp7)
  b.addPart(bp8)
  b.addPart(bp9)
  b.addPart(bp10)


  g.addVehicle(a)
  g.addVehicle(b)
  g.addVehicle(c)

  println("Time taken to fix all cars: " + g.timeTakenAll + " hours.")
  println("Number of cars in the garage: " +  g.vBuff.size)

  val e1 = new Employee("John", "Jackson", "1/1/2000", "EM-0000", false)
  val e2 = new Employee("Jack", "Johnson", "31/12/1999", "EM-0001", false)
  val e3 = new Employee("Max", "LeManager", "20/4/1984", "EM-0003", true)

  g.addEmployee(e1)
  g.addEmployee(e2)
  g.addEmployee(e3)

  println("Number of employees in the company: " + g.eBuff.size)

  g.vFix(a)
  g.vFix(b)
  g.vFix(c)

  println(g.toString)

  g.gOpen()

  println(g.toString)


  g.removeVehicleByID("a")
  println("Number of cars in garage: " +  g.vBuff.size)
  g.removeVehicleByType("Car")
  println("Number of cars in garage: " +  g.vBuff.size)

  g.gOpen()
  println(g.isOpen)
  g.gClose()
  println(g.isOpen)
  g.gOpen()
  println(g.isOpen)

}
