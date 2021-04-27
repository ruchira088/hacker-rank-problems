package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class EncryptionSpec extends AnyFlatSpec with Matchers {

  "Encryption" should "return the expected encrypted string" in {
    Encryption.encryption("if man was meant to stay on the ground god would have given us roots") mustBe
      "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"

    Encryption.encryption("haveaniceday") mustBe "hae and via ecy"

    Encryption.encryption("feedthedog") mustBe "fto ehg ee dd"

    Encryption.encryption("chillout") mustBe "clu hlt io"
  }

}
