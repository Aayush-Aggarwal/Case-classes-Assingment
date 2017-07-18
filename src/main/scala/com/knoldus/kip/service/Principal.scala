package com.knoldus.kip.service

import com.knoldus.kip.RamDatabase
import com.knoldus.kip.models._

trait Principal {


  def findOutIfCSE(id: Int): CoursePerformance ={
    val coursePerformance: Option[CoursePerformance]=RamDatabase.getById(id)
    val crs=coursePerformance.map(_.course).getOrElse("Doesnt exist")
    crs match {
      case "CSE" => coursePerformance.get
      case _ => throw new Exception("no such subject")
    }
  /*  val crss: Option[String]=coursePerformance.map(_.course)

    crss match {
      case Some("CSE") => coursePerformance.get
      case None => throw new Exception("no such subject")
    }
    */

  }

  def findOutIfAnyCourse(id: Int, courseName: String): CoursePerformance = {
    val coursePerformance: Option[CoursePerformance]=RamDatabase.getById(id)
    val crs=coursePerformance.map(_.course).getOrElse("Doesnt exist")
    crs match {
      case `courseName` => coursePerformance.get
      case _ => throw new Exception("no such subject")
    }

  }

  def expression(mod: Any): String ={
    mod match{
      case Student(_,_,_,_,_,_,_,_,_) => "Shut up"
      case Scoreboard(_,_,_,_,_,_) => "Hmmm .... "
      case Subject(_,_,_,_) => "aha"
      case _ => "!!!???"
    }
  }

  def checkScoreboard(scoreboard: List[Scoreboard]): List[String] = {
    val sum = scoreboard.flatMap((x) => x.subjects.map((y)=>(x.student.firstName,y.id,y.obtainedMarks)))
    sum.groupBy(_._2).mapValues((x)=>x.maxBy(_._3)._1).values.toList

  }


  def expressionRevisited: PartialFunction[ModelIdentifier, String] ={
    case Student(_,_,_,_,_,_,_,_,_) => "Shut up"
    case Scoreboard(_,_,_,_,_,_) => "Hmmm .... "
    case Subject(_,_,_,_) => "aha"
    case _ => "!!!???"
  }

}
