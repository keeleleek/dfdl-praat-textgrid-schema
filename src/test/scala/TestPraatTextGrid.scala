package com.gitub.keeleleek.praattextgrid

import org.apache.daffodil.tdml.Runner
import org.junit.Test
import org.junit.AfterClass

object TestPraatTextGrid {
  lazy val runner = new Runner("/", "textgrid.tdml")

  @AfterClass def shutDown {
    runner.reset
  }
}

class TestPraatTextGrid {
  import TestPraatTextGrid._

  @Test def test_ekskfk_miski_1() { runner.runOneTest("ekskfk_miski_1") }

}
