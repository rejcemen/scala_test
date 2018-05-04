import org.scalatest.{FlatSpec, Matchers}
import play.api.libs.json.Json

/**
  * Created by d.merkuryev on 04.05.2018
  */
class ExampleTestFullMsisdn extends FlatSpec with Matchers {
  val jsonResponse = Json.parse(
    """
      |{
      |  "payload": {
      |    "hits": [
      |      {
      |        "state": "Free",
      |        "locked": false,
      |        "contactId": "",
      |        "category": "2029",
      |        "regionId": 77,
      |        "phone": "79260083123"
      |      },
      |      {
      |        "state": "Occupied",
      |        "locked": false,
      |        "contactId": "",
      |        "category": "2029",
      |        "regionId": 77,
      |        "phone": "79260082123"
      |      }
      |    ]
      |  },
      |  "resultCode": "OK",
      |  "trackingId": "0dd2c25c-31af-41be-bf17-42c61259072b"
      |}
    """.stripMargin)

  "full_msisdn" should "return status OK when requested" in {

  }

  "full_msisdn" should "return 2 phone numbers for serch with limit 2" in {

  }

  "full_msisdn" should "return numbers only for status 2029" in {

  }

  "full_msisdn" should "return numbers only for region 77" in {

  }

  "full_msisdn" should "return empty contactId for not occupied number" in {

  }
}
