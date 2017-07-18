package com.knoldus.kip.models

case class Student(id: Int,firstName:String,middelName:Option[String],lastName:String,rollno:Int,
                   age:Option[Int],gender:String,enrollmentNumber:Long,address:Option[String]
                  )
  extends ModelIdentifier{
  def getaddress:String=address.fold("N/A"){ADS=>ADS}
  def getmiddelname:String=middelName.map(_.split(" ").head).getOrElse("N/A")

}

case class Subject( id:Int,name:String,maxMarks:Int,obtainedMarks:Int)extends ModelIdentifier
case class Course(id:Int,name:String,category:String,subjects:List[Subject])extends ModelIdentifier


case class Scoreboard(id:Int,student:Student,subjects:List[Subject],total:Long,percentage:Double
                     ,grade:String,
                     )extends ModelIdentifier{
  def highestscore():List[Subject]={
    val maxmarks=subjects.map(_.obtainedMarks).max
    subjects.filter(_.obtainedMarks==maxmarks)
  }

  def lowestscore():List[Subject]={
    val lowermarks=subjects.map(_.obtainedMarks).min
    subjects.filter(_.obtainedMarks==lowermarks)
  }
}

object Scoreboard {
  def apply(student: Student, subjects: List[Subject]): Scoreboard = {
    val total = subjects.map(_.obtainedMarks).sum
    val percentage = (total / subjects.map(_.obtainedMarks).sum)
    val grade = if (percentage >= 95) {
      "A+"
    }
    else if (percentage >= 90) {
      "A"
    }
    else if (percentage >= 85) {
      "B+"
    }
    else if (percentage >= 80) {
      "B"
    }
    else if (percentage >= 70) {
      "C+"
    }
    else if (percentage >= 60) {
      "c"
    }
    else if (percentage >= 50) {
      "D+"
    }
    else if (percentage >= 40) {
      "D"
    }
    else {
      "F"
    }
    new Scoreboard(student.id,student,subjects,total,percentage,grade)
  }
}

case class CoursePerformance(id: Int,year:Int,course:String,scorecards:List[Scoreboard]) extends ModelIdentifier