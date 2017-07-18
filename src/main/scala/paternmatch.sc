/*
object Email {

  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None

  }
}

val s = "ayushagg142@gmail.com"

s match {

  case Email(user, domain) => println(user + "AT" + domain)

  case _ => println("not valid")

}


val listofEmail = List(("ayush@knoldus.in","ayush@gmail.com"),("aksh@knoldus.in","aksh@gmail.com"),("abc@xyz","aaa@xyz"))

val a = listofEmail withFilter {
  case (Email(u1,d1),Email(u2,d2))=>u1==u2
}

a.map(a => a)


val listofEmail = List(("ayush@knoldus.in","ayush@gmail.com"),("aksh@knoldus.in","aksh@gmail.com"),("abc@xyz","aaa@xyz"))

val a = listofEmail withFilter {
  case (Email(u1, d1), Email(u2, d2)) => u1 == u2
}
*/

val listfEmail = List("ayush@knoldus.in", "ayush@gmail.com", "aksh@knoldus.in", "aksh.gmailcom")


object Checker {
  def unapply(s: String): Option[(String, String)] = {
    val parts = s split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

object Twice {
  def unapply(s: String): Option[String] = {
    val l = s.length / 2
    val half = s.substring(0, l)
    if (half == s.substring(l)) Some(half) else None
  }
}

object Upercase{
  def unapply(s:String): Boolean = s.toUpperCase == s
}


"AYUSHAYUSH@GMAIL.COM" match {
  case Checker(Twice(Upercase()),d)=>println("correct")
  case _=>println("Incorrect")
}

