package com.knoldus.kip.service

import com.knoldus.kip.models.{CoursePerformance, Scoreboard, Student}
import com.knoldus.kip.RamDatabase

trait Postman {


  def getTheFirstAddressOfFirstYearPerformance(id: Int):String = {
    RamDatabase.getById(id).fold("N/A"){(x:CoursePerformance) => x.scorecards.headOption.map(_.student.getaddress).getOrElse("N/A")}

  }

}
